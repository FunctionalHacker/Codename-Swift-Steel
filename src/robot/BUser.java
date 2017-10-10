package robot;

import lejos.hardware.Button;
import lejos.robotics.subsumption.Behavior;

public class BUser implements Behavior {
	private User user;
	private volatile boolean suppressed = false;

	public BUser(BottomMotor bMotor, MiddleMotor mMotor, TopMotor tMotor) {
		user = new User(bMotor, mMotor, tMotor);
	}

	@Override
	public boolean takeControl() {
		if (Button.RIGHT.isDown()) {
			return true;
		}
		else {
			return false;
		}
	}

	@Override
	public void action() {
		user.run();
	}

	@Override
	public void suppress() {
		suppressed = true;

	}

}
