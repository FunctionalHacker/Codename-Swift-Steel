package robot;

import lejos.robotics.subsumption.Behavior;
/**
 * The behaviour class for when the robot is doing nothing.
 * @author Team 12: Ville Kautonen, Jerry Hällfors, Marko Korhonen
 *
 */
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
