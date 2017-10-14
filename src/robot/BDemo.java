package robot;

import lejos.hardware.Button;
import lejos.robotics.subsumption.Behavior;
/**
 * This is the behaviour class for the demo mode
 * @author Team 12: Ville Kautonen, Jerry Hällfors, Marko Korhonen
 *
 */
public class BDemo implements Behavior {
	private TwoTiresTwoCups tttc;
	private BottomMotor bMotor;
	private MiddleMotor mMotor;
	private TopMotor tMotor;
	private ColorSensor color;
	private volatile boolean suppressed = false;
	public BDemo(BottomMotor bMotor, MiddleMotor mMotor, TopMotor tMotor, ColorSensor color) {
		this.bMotor = bMotor;
		this.mMotor = mMotor;
		this.tMotor = tMotor;
		this.color = color;
		tttc = new TwoTiresTwoCups(bMotor, mMotor, tMotor, color);
	}
	/**
	 * 
	 * @return true if the behaviour wants to take control, e.g when the left button is down.
	 */
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
			tttc = new TwoTiresTwoCups(bMotor, mMotor, tMotor, color);
			tttc.setDaemon(true);
			tttc.start();
		}

	}

	@Override
	public void suppress() {
		suppressed = true;
	}

}
