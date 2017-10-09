package robot;

import lejos.hardware.device.PSPNXController;
import lejos.hardware.ev3.LocalEV3;
import lejos.hardware.motor.EV3LargeRegulatedMotor;
import lejos.hardware.motor.EV3MediumRegulatedMotor;
import lejos.hardware.port.*;
import lejos.robotics.RegulatedMotor;

public class ControllerTest {
	public static void main(String[] args) {
		RegulatedMotor bMotor = new EV3LargeRegulatedMotor(MotorPort.A);
		RegulatedMotor mMotor = new EV3LargeRegulatedMotor(MotorPort.B);
		RegulatedMotor tMotor = new EV3MediumRegulatedMotor(MotorPort.C);
		Port controllerPort = LocalEV3.get().getPort("S3");
		PSPNXController psp = new PSPNXController(controllerPort);
		boolean running = true;
		int buttons[];

		while(running){
			buttons = psp.getButtons();
			try {
			if(buttons[0] == 1){
				bMotor.forward();
			}
			else if(buttons[0] == 0 && bMotor.getRotationSpeed() > 0){
				bMotor.stop();
			}
			if(buttons[2] == 1){
				bMotor.backward();
			}
			else if(buttons[2] == 0 && bMotor.getRotationSpeed() < 0){
				bMotor.stop();
			}
			if(buttons[1] == 1){
				psp.close();
				bMotor.close();
				running = false;
			}
		}
	}
}
