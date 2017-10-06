package robot;

import lejos.hardware.Button;
import lejos.robotics.subsumption.Behavior;

public class BKill implements Behavior {
	private volatile boolean suppressed = false;
	@Override
	public boolean takeControl() {
		if (Button.ESCAPE.isDown()) {
			return true;
		}
		else {
			return false;
		}
	}

	@Override
	public void action() {
		System.exit(0);
	}

	@Override
	public void suppress() {
		suppressed = true;

	}

}
