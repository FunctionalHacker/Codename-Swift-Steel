package robot;

import lejos.hardware.motor.EV3LargeRegulatedMotor;
import lejos.hardware.port.MotorPort;
import lejos.robotics.RegulatedMotor;

public class BottomMotor {
	private RegulatedMotor motor = new EV3LargeRegulatedMotor(MotorPort.A);
	private int curRotation;
	private static int maxRotation;

	public BottomMotor(){
		maxRotation = 220*3;
		curRotation = 0;
	}
	public void rotate(int angle){
		angle=angle*3;
		if(angle > maxRotation){
			angle = maxRotation;
		}
		if(angle + curRotation > maxRotation){
			angle = maxRotation - curRotation;
		}
		else{
			motor.rotate(-angle);
			curRotation = curRotation + angle;
		}
	}
	public void rotateToDefaultPos(){
		rotate(-curRotation);
		curRotation = 0;
	}
}
