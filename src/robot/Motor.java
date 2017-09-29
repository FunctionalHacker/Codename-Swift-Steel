package robot;

import lejos.hardware.motor.EV3LargeRegulatedMotor;
import lejos.hardware.motor.EV3MediumRegulatedMotor;
import lejos.hardware.port.MotorPort;
import lejos.robotics.RegulatedMotor;
import lejos.utility.Delay;

public class Motor {
	Thread thread = new Thread();
	private int maxspeed = 500;
	// To get the correct rotation, the degree amount must be multiplied by 3, to get the correct
	// rotation. The correct multiplier for the arm is yet to be determined
	private RegulatedMotor bottom = new EV3LargeRegulatedMotor(MotorPort.A);
	private RegulatedMotor middle = new EV3LargeRegulatedMotor(MotorPort.B);
	private RegulatedMotor arm = new EV3MediumRegulatedMotor(MotorPort.C);

	public void test(){
		bottom.rotate(180*3);
	}
}