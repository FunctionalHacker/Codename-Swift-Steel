package robot;

import lejos.hardware.Button;
import lejos.robotics.subsumption.Behavior;

public class BDemo implements Behavior {
	private TwoTiresTwoCups tttc;
	private volatile boolean suppressed = false;
	public BDemo(BottomMotor bMotor, MiddleMotor mMotor, TopMotor tMotor) {
		tttc = new TwoTiresTwoCups(bMotor, mMotor, tMotor);
	}

	@Override
	public boolean takeControl() {
		if (Button.LEFT.isDown()) {
			return true;
		}
		else {
			return false;
		}
	}

	@Override
	public void action() {
		suppressed = false;
		if(!suppressed&!tttc.isAlive()) {
			tttc.start();
		}

	}

	@Override
	public void suppress() {
		suppressed = true;
//		if (tttc.isAlive()) {
//			tttc
//		}
	}

}
