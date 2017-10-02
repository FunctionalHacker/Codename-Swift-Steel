package robot;

import lejos.hardware.motor.EV3LargeRegulatedMotor;
import lejos.hardware.port.MotorPort;
import lejos.robotics.RegulatedMotor;

public class MiddleMotor {
	private RegulatedMotor motor = new EV3LargeRegulatedMotor(MotorPort.B);
	private int curRotation;
	private static int maxRotation;

	public MiddleMotor(){
		maxRotation = -90*3;
		curRotation = 0;
	}
	public boolean rotate(int angle){
		if(angle + curRotation < maxRotation){
			return false;
		}
		else{
			motor.rotate(angle);
			curRotation = curRotation + angle;
			return true;
		}
	}
	public void rotateToDefaultPos(){
		this.rotate(-curRotation);
		curRotation = 0;
	}
}