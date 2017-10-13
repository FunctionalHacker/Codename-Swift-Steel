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
	private int maxRotation = 100;
	private boolean isOpen;
	int tacho = 0;
	boolean stop = false;
	/**
	 * The LeJOS motor used in this class
	 */
	private RegulatedMotor tMotor = new EV3MediumRegulatedMotor(MotorPort.C);
	public TopMotor() {
		isOpen = true; //Tärkeä
		tMotor.setSpeed(100);
	}

	/**
	 * Changes the state of the hand. If it's closed, it's opened and vice versa.
	 */
	public void toggle() {
		if (isOpen) {
			tMotor.rotate(maxRotation);
			isOpen = false;
		} else {
			System.out.println(tMotor.getTachoCount());
			tMotor.rotate(-tMotor.getTachoCount());
			isOpen = true;
		}
	}

}