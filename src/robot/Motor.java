package robot;

import lejos.hardware.motor.EV3LargeRegulatedMotor;
import lejos.hardware.port.MotorPort;
import lejos.robotics.RegulatedMotor;
import lejos.utility.Delay;

public class Motor {
	Thread thread = new Thread();
	private int maxspeed = 500;
	private RegulatedMotor bottom = new EV3LargeRegulatedMotor(MotorPort.A);
	private RegulatedMotor middle = new EV3LargeRegulatedMotor(MotorPort.B);
	private RegulatedMotor arm = new EV3LargeRegulatedMotor(MotorPort.C);

	public void test(){
		bottom.rotate(180*3);
	}
}