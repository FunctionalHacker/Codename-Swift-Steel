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
	/**
	 * The LeJOS motor used in this class
	 */
	private RegulatedMotor motor = new EV3LargeRegulatedMotor(MotorPort.A);

	/**
	 * The current rotation of the motor is always saved here
	 */
	private int curRotation;

	public int getCurRotation() {
		return curRotation;
	}

	/**
	 * The maximum rotation the motor can handle
	 */
	private static int maxRotation;
	TouchSensor tSensor;

	public BottomMotor(){

		/**
		 * The touch sensor is used to stop the motor before
		 * the bottom motor hits anything when returning home
		 */
		tSensor = new TouchSensor("S2");

		/**
		 * The maximum rotation the motor can handle
		 */
		maxRotation = 260*3;

		/**
		 * The current rotation of the motor is always saved here
		 */
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
			if (tSensor.pressed()) {
				motor.stop();
				curRotation = 0;
				break;
			}
		}
	}
}
