package robot;

import lejos.robotics.subsumption.*;

public class Main {
	public static void main(String[] args) {
		Motor motor = new Motor();
		motor.test();

//		Behavior's priority is determined by it's position in
//		behaviorArray. First index being the lowest priority
//		and last being the highest.

//		Behavior b1 = new BUser();
//		Behavior b2 = new BDemo();
//		Behavior b3 = new BMenu();
//		Behavior b4 = new BExit();
//		Behavior[] behaviorArray = {b1, b2, b3, b4};
//		Arbitrator arbi = new Arbitrator(behaviorArray);
	}
}