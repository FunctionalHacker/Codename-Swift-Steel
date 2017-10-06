package robot;

import lejos.robotics.subsumption.Behavior;

public class BIdle implements Behavior {
	private volatile boolean suppressed = false;
	@Override
	public boolean takeControl() {
		return true;
	}

	@Override
	public void action() {
		suppressed = false;
	}

	@Override
	public void suppress() {
		suppressed = true;

	}

}
