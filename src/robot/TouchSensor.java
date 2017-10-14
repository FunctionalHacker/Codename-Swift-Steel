package robot;

import lejos.hardware.ev3.LocalEV3;
import lejos.hardware.port.Port;
import lejos.hardware.sensor.EV3TouchSensor;
import lejos.robotics.SampleProvider;
/**
 * Class for the touch sensor used to stop BottomMotor before it hits anything
 * @author Team 12: Ville Kautonen, Jerry Hällfors, Marko Korhonen
 *
 */
public class TouchSensor {
	private Port sensorPort;
	private EV3TouchSensor tsensor;
	private SampleProvider push;
	private float[] touchsample;
	public TouchSensor(String port) {
		sensorPort = LocalEV3.get().getPort(port);
		tsensor = new EV3TouchSensor(sensorPort);
		push = tsensor.getTouchMode();
		touchsample = new float[push.sampleSize()];
	}

	/**
	 * 
	 * @return true if the sensor is pressed
	 */
	public boolean pressed() {
		push.fetchSample(touchsample, 0);
		if (touchsample[0]==1) {
			return true;
		}
		else {
			return false;
		}
	}
}
