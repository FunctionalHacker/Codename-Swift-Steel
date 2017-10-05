package robot;

import lejos.hardware.motor.EV3LargeRegulatedMotor;
import lejos.hardware.port.MotorPort;
import lejos.robotics.RegulatedMotor;

/**
 * This is the motor class for the bottom motor of the robot.
 * @author Team 12: Ville Kautonen, Jerry Hällfors, Marko Korhonen
 *
 */
public class BottomMotor {
	private RegulatedMotor motor = new EV3LargeRegulatedMotor(MotorPort.A);
	private int curRotation;
	private static int maxRotation;
	TouchSensor ts;

	public BottomMotor(TouchSensor ts){
		this.ts = ts;
		maxRotation = 260*3;
		curRotation = 0;
	}

	/**
	 * Rotates the motor for a specified amount. Positive angle is away from the default
	 * position, negative angle is towards the default position.
	 * @param angle the angle to be rotated
	 */
	public void rotate(int angle){
		if(angle + curRotation > maxRotation){
			angle = maxRotation - curRotation;
		}
		motor.rotate(-angle);
		curRotation += angle;
	}

	/**
	 * Rotates the motor back to it's default position, regardless of current position.
	 */
	public void rotateToDefaultPos() {
		motor.forward();
		while(true) {
			if (ts.pressed()) {
				motor.stop();
				curRotation = 0;
				break;
			}
		}
	}
}
