package robot;

public class Navigator {
	BottomMotor bMotor;
	MiddleMotor mMotor;
	TopMotor tMotor;

	private int rideHeight = 50*3;
	private int tA = 130*3;
	private int tB = 100*3;
	private int cA = 260*3;
	private int cB = 240*3;

	public Navigator(){
		bMotor = new BottomMotor();
		mMotor = new MiddleMotor();
		tMotor = new TopMotor();
	}

	public void tireA(){
		mMotor.rotate((rideHeight)-mMotor.getCurRotation());
		bMotor.rotate((tA)-bMotor.getCurRotation());
		mMotor.rotateToDefaultPos();
	}

	public void tireB(){
		mMotor.rotate((rideHeight)-mMotor.getCurRotation());
		bMotor.rotate((tB)-bMotor.getCurRotation());
		mMotor.rotateToDefaultPos();
	}

	public void cupA(){
		mMotor.rotate((rideHeight)-mMotor.getCurRotation());
		bMotor.rotate((cupAlocation)-bMotor.getCurRotation());
	}

	public void cupB(){

	}

	public void grabToggle(){
		tMotor.toggle();
	}

	public void rotateToDefaultPos(){
		if(mMotor.getCurRotation() == 0){
			mMotor.rotate(rideHeight);
		}
		bMotor.rotateToDefaultPos();
		mMotor.rotateToDefaultPos();
	}
}
