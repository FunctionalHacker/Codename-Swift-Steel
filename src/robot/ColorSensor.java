package robot;
import lejos.hardware.Button;
import lejos.hardware.ev3.LocalEV3;
import lejos.hardware.port.Port;
import lejos.hardware.sensor.EV3ColorSensor;
import lejos.hardware.sensor.SensorModes;
import lejos.robotics.SampleProvider;

public class ColorSensor {

	private Port sensorPort;
	private SensorModes rgbSensor;
	private SampleProvider colorProvider;
	private float[] rgbSample;
	private float[] colorA;
	private float[] colorB;

	/**
	 * Class constructor with a String parameter for configuring the port.
	 * @author Team 12: Ville Kautonen, Jerry Hällfors, Marko Korhonen
	 */
	public ColorSensor(String port) {
		sensorPort = LocalEV3.get().getPort(port);
		rgbSensor = new EV3ColorSensor(sensorPort);
		colorProvider = ((EV3ColorSensor)rgbSensor).getRGBMode();
		rgbSample = new float[colorProvider.sampleSize()];
		colorA = new float[colorProvider.sampleSize()];
		colorB = new float[colorProvider.sampleSize()];
		saveColors();

	}

	/**
	 * checkColor compares the color sensor's current input at the given time to the sample provided by saveColors method.
	 * @return The method returns true, when the calculated value is lower than the threshold value. Otherwise returns false.
	 */
	public int checkColor () {
		colorProvider.fetchSample(rgbSample, 0);
		int[] realA = new int[3];
        realA[0] = Math.round(colorA[0]*765);
        realA[1] = Math.round(colorA[1]*765);
        realA[2] = Math.round(colorA[2]*765);

		int[] realB = new int[3];
        realB[0] = Math.round(colorB[0]*765);
        realB[1] = Math.round(colorB[1]*765);
        realB[2] = Math.round(colorB[2]*765);

        int[] sampleRGB = new int[3];
        sampleRGB[0] = Math.round(rgbSample[0]*765);
        sampleRGB[1] = Math.round(rgbSample[1]*765);
        sampleRGB[2] = Math.round(rgbSample[2]*765);

        double sampleColorA;
        int aR = realA[0] - sampleRGB[0];
        int aG = realA[1] - sampleRGB[1];
        int aB = realA[2] - sampleRGB[2];
        sampleColorA = Math.sqrt((aR*aR) + (aG*aG) + (aB*aB));

        double sampleColorB;
        int bR = realB[0] - sampleRGB[0];
        int bG = realB[1] - sampleRGB[1];
        int bB = realB[2] - sampleRGB[2];
        sampleColorB = Math.sqrt((bR*bR) + (bG*bG) + (bB*bB));

        int thresholdValue = 50;
        if (thresholdValue > sampleColorA) {
                return 1;
        }
        if (thresholdValue > sampleColorB) {
            return 2;
        }
        return 0;
	}
	/**
	 * Sets up the sample colors for the colorCheck method.
	 */
	public void saveColors() {
    	System.out.println("Show samplecolor A to the color sensor and press Escape to verify it.");

    	while (Button.ID_ESCAPE == Button.waitForAnyPress()) {
        	colorProvider.fetchSample(colorA, 0);
        	System.out.println(Math.round(colorA[0]*765));
        	System.out.println(Math.round(colorA[1]*765));
        	System.out.println(Math.round(colorA[2]*765));
        	System.out.println("Press any key to continue.");
    	}

    	System.out.println("");
    	System.out.println("Show samplecolor B to the color sensor and press Escape to verify it.");
    	while (Button.ID_ESCAPE == Button.waitForAnyPress()) {
   		 colorProvider.fetchSample(colorB, 0);
        	System.out.println(Math.round(colorB[0]*765));
        	System.out.println(Math.round(colorB[1]*765));
        	System.out.println(Math.round(colorB[2]*765));
        	System.out.println("Press any key to continue.");
    	}

    }
}