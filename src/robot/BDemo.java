package robot;

import lejos.hardware.Button;
import lejos.robotics.subsumption.Behavior;

public class BDemo implements Behavior {
	private TwoTiresTwoCups tttc;
	private BottomMotor bMotor;
	private MiddleMotor mMotor;
	private TopMotor tMotor;
	private volatile boolean suppressed = false;
	public BDemo(BottomMotor bMotor, MiddleMotor mMotor, TopMotor tMotor) {
		this.bMotor = bMotor;
		this.mMotor = mMotor;
		this.tMotor = tMotor;
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
			tttc = new TwoTiresTwoCups(bMotor, mMotor, tMotor);
			tttc.setDaemon(true);
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
