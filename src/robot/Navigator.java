package robot;

public class Navigator {
	BottomMotor bMotor;
	MiddleMotor mMotor;
	TopMotor tMotor;

	private int rideHeight = 70*3;
	private int tA = 140*3;
	private int tB = 100*3;
	private int cA = 260*3;
	private int cB = 210*3;

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
		bMotor.rotate((cA)-bMotor.getCurRotation());
	}

	public void cupB(){
		mMotor.rotate((rideHeight)-mMotor.getCurRotation());
		bMotor.rotate((cB)-bMotor.getCurRotation());
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

	public void lift() {
		if (mMotor.getCurRotation() != rideHeight) {
			mMotor.rotate(rideHeight);
		}
	}
}
