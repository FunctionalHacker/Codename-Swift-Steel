package robot;

import lejos.robotics.subsumption.*;

public class Main {
	public static void main(String[] args) {
		MotorTest motor = new MotorTest();
		motor.test();

//		Behavior's priority is determined by it's position in
//		behaviorArray. First index being the lowest priority
//		and last being the highest.

//		Behavior b1 = new BUser();
//		Behavior b2 = new BDemo();
//		Behavior[] behaviorArray = {b1, b2};
//		Arbitrator arbi = new Arbitrator(behaviorArray);
	}
}