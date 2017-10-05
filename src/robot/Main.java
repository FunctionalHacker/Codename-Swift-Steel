package robot;

import lejos.robotics.subsumption.*;

/**
 * Behavior's priority is determined by it's position in
 * behaviorArray. First index being the lowest priority
 * and last being the highest.
 * @author Team 12: Ville Kautonen, Jerry Hällfors, Marko Korhonen
 *
 */
public class Main {
	public static void main(String[] args) {
		TwoTiresTwoCups tttc = new TwoTiresTwoCups();
		tttc.run();

//		TESTS
//		TouchSensor tSensor = new TouchSensor("S2");
//		BottomMotor bMotor = new BottomMotor(tSensor);
//		MiddleMotor mMotor = new MiddleMotor();
//		TopMotor tMotor = new TopMotor();
//
//		bMotor.rotateToDefaultPos();
//		mMotor.rotate(500);
//		tMotor.toggle();
//		mMotor.rotate(500*3);
//		bMotor.rotate(-70*3);
//		tMotor.toggle();
//		bMotor.rotateToDefaultPos();
//		mMotor.rotateToDefaultPos();

//		Behavior b1 = new BUser();
//		Behavior b2 = new BDemo();
//		Behavior[] behaviorArray = {b1, b2};
//		Arbitrator arbi = new Arbitrator(behaviorArray);
	}
}