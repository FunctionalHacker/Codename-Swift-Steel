package robot;

import lejos.hardware.ev3.LocalEV3;
import lejos.hardware.port.Port;
import lejos.hardware.sensor.EV3TouchSensor;
import lejos.robotics.SampleProvider;

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

//	pressed returns true if the sensor is pressed when
//	the method is called and false otherwise.
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
