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
		BottomMotor bMotor = new BottomMotor();
		MiddleMotor mMotor = new MiddleMotor();
		TopMotor tMotor = new TopMotor();
//		TwoTiresTwoCups tttc = new TwoTiresTwoCups(bMotor, mMotor, tMotor);
//		tttc.run();

//		TwoTiresTwoCups tttc = new TwoTiresTwoCups();
//		tttc.run();

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

		Behavior b1 = new BIdle();
		Behavior b2 = new BUser(bMotor, mMotor, tMotor);
		Behavior b3 = new BDemo(bMotor, mMotor, tMotor);
		Behavior b4 = new BKill();
		Behavior[] behaviorArray = {b1, b2, b3, b4};
		Arbitrator arbi = new Arbitrator(behaviorArray);
		arbi.go();
	}
}