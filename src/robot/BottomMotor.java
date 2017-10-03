package robot;

import lejos.hardware.motor.EV3LargeRegulatedMotor;
import lejos.hardware.port.MotorPort;
import lejos.robotics.RegulatedMotor;

public class BottomMotor {
	private RegulatedMotor motor = new EV3LargeRegulatedMotor(MotorPort.A);
	private int curRotation;
	private static int maxRotation;
	TouchSensor ts;

	public BottomMotor(TouchSensor ts){
		this.ts = ts;
		maxRotation = 260*3;
		curRotation = 0;
	}
	public void rotate(int angle){
		if(angle + curRotation > maxRotation){
			angle = maxRotation - curRotation;
		}
		motor.rotate(-angle);
		curRotation += angle;
	}
	//public void rotateToDefaultPos(){
	//	rotate(-curRotation);
	//	curRotation = 0;
	//}

	public void rotateToDefaultPos() {
		motor.forward();
		while(true) {
			if (ts.pressed()) {
				motor.stop();
				curRotation = 0;
				break;
			}
		}
	}
}
