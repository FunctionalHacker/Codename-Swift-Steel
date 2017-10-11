package robot;

import lejos.hardware.Button;
import lejos.hardware.motor.EV3MediumRegulatedMotor;
import lejos.hardware.port.MotorPort;
import lejos.robotics.RegulatedMotor;

/**
 * This is the motor class for the top motor of the robot, the "hand" part.
 * @author Team 12: Ville Kautonen, Jerry Hällfors, Marko Korhonen
 *
 */
public class TopMotor {
	private int maxRotation = 90;
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
		tMotor.setStallThreshold(1, 100);
	}

	/**
	 * Changes the state of the hand. If it's closed, it's opened and vice versa.
	 */
//	public void toggle() {
//		if (isOpen) {
//			tMotor.rotate(maxRotation);
//			isOpen = false;
//		} else {
//			tMotor.rotate(-maxRotation);
//			isOpen = true;
//		}
//	}

//	public void toggle() {
//		int x = 0;
//		//forward = kiinni
//		if (!isOpen) {
//			System.out.println("avaudu");
//			tMotor.forward();
//			while(true) {
//				tacho = tMotor.getTachoCount();
//				System.out.println(tacho);
//				if (tMotor.getTachoCount() > 90 || Button.ESCAPE.isDown()) {
//					tMotor.stop();
//					tMotor.resetTachoCount();
//					isOpen = true;
//					break;
//				}
//			}
//			tMotor.stop();
//		}
//		else {
//			System.out.println("sulkeudu");
//			tMotor.backward();
//			while(true) {
//				tacho = tMotor.getTachoCount();
//				System.out.println(tacho);
//				if (tMotor.getTachoCount() < -60 || Button.ESCAPE.isDown()) {
//					tMotor.stop();
//					tMotor.resetTachoCount();
//					isOpen = false;
//					break;
//				}
//			}
//			tMotor.stop();
//		}
//	}
//}

	public void toggle() {
		int testi = 0;
		int kill = 0;
		//forward = kiinni
		if (!isOpen) {
			System.out.println("avaudu");
			tMotor.rotate(-tacho);
			tMotor.resetTachoCount();
			isOpen = true;
		}
		else {
			System.out.println("sulkeudu");
			tMotor.backward();
			while(kill<50000||Button.ESCAPE.isDown()) {
				tacho = tMotor.getTachoCount();
				System.out.println(tacho);
				if (tacho==testi) {
					kill += 1;
				}
				testi = tacho;
			}
			isOpen = false;
			tMotor.stop();
		}
	}
}