package robot;

import lejos.hardware.Button;
import lejos.robotics.subsumption.Behavior;

/**
 * The behavior class for the used to kill the program when escape is pressed
 * @author Team 12: Ville Kautonen, Jerry Hällfors, Marko Korhonen
 *
 */
public class BKill implements Behavior {
	private volatile boolean suppressed = false;
	/**
	 * 
	 * @return true if escape is pressed
	 */
	@Override
	public boolean takeControl() {
		if (Button.ESCAPE.isDown()) {
			return true;
		}
		else {
			return false;
		}
	}
	
	/**
	 * This behaviour's action, which is to kill the whole program
	 */
	@Override
	public void action() {
		System.exit(0);
	}
	
	@Override
	public void suppress() {
		suppressed = true;

	}

}
