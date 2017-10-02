package robot;

import lejos.hardware.motor.EV3LargeRegulatedMotor;
import lejos.hardware.port.MotorPort;
import lejos.robotics.RegulatedMotor;

public class BottomMotor {
	private RegulatedMotor motor = new EV3LargeRegulatedMotor(MotorPort.A);
	private int curRotation;
	private static int maxRotation;

	public BottomMotor(){
		maxRotation = -220*3;
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
