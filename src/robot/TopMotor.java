package robot;

import lejos.hardware.motor.EV3MediumRegulatedMotor;
import lejos.hardware.port.MotorPort;
import lejos.robotics.RegulatedMotor;

public class TopMotor {
	private boolean position;
	private RegulatedMotor arm = new EV3MediumRegulatedMotor(MotorPort.C);
	public TopMotor() {
		position = true;
		arm.setSpeed(200);
	}

	public void toggle() {
		if (position) {
			arm.rotate(110);
			position = false;
		} else {
			arm.rotate(-110);
			position = true;
		}
	}
}
