package robot;

import lejos.hardware.device.PSPNXController;
import lejos.hardware.ev3.LocalEV3;
import lejos.hardware.port.Port;

public class User {
	private BottomMotor bMotor;
	private MiddleMotor mMotor;
	private TopMotor tMotor;

	public User(BottomMotor bMotor, MiddleMotor mMotor, TopMotor tMotor) {
		this.bMotor = bMotor;
		this.mMotor = mMotor;
		this.tMotor = tMotor;
	}

	public void run() {
		Port controllerPort = LocalEV3.get().getPort("S3");
		PSPNXController psp = new PSPNXController(controllerPort);
		bMotor.setSpeed(100);
		mMotor.setSpeed(100);
		boolean running = true;
		int buttons[];

		while(running){
			buttons = psp.getButtons();
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
				mMotor.forward();
			}
			else if(buttons[1] == 0 && mMotor.getRotationSpeed() > 0){
				mMotor.stop();
			}

			if(buttons[3] == 1){
				mMotor.backward();
			}
			else if(buttons[3] == 0 && mMotor.getRotationSpeed() < 0){
				mMotor.stop();
			}

			if(buttons[14] == 1){
				tMotor.toggle();
			}


			if(buttons[11] == 1){
				psp.close();
				bMotor.close();
				running = false;
			}
		}
	}


}
