package robot;

import lejos.hardware.motor.EV3MediumRegulatedMotor;
import lejos.hardware.port.MotorPort;
import lejos.robotics.RegulatedMotor;

/**
 * This is the motor class for the top motor of the robot, the "hand" part.
 * @author Team 12: Ville Kautonen, Jerry Hällfors, Marko Korhonen
 *
 */
public class TopMotor {
	private boolean position;
	private RegulatedMotor arm = new EV3MediumRegulatedMotor(MotorPort.C);
	public TopMotor() {
		position = true;
		arm.setSpeed(200);
	}

	/**
	 * Changes the state of the hand. If it's closed, it's opened and vice versa.
	 */
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
