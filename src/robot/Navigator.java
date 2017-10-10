package robot;

public class Navigator {
	BottomMotor bMotor;
	MiddleMotor mMotor;
	TopMotor tMotor;

	private int rideHeight = 70*3;
	private int t1Height = rideHeight - 13*3;
	private int t2Height = rideHeight - 23*3;
	private int tA = 140*3;
	private int tB = 100*3;
	private int cA = 260*3;
	private int cB = 210*3;
	private int cC = 160*3;

	public Navigator(BottomMotor bMotor, MiddleMotor mMotor, TopMotor tMotor){
		this.bMotor = bMotor;
		this.mMotor = mMotor;
		this.tMotor = tMotor;
	}

	public void tireA1(){
		mMotor.rotate((rideHeight)-mMotor.getCurRotation());
		bMotor.rotate((tA)-bMotor.getCurRotation());
		mMotor.rotate(-t1Height);
	}

	public void tireB1(){
		mMotor.rotate((rideHeight)-mMotor.getCurRotation());
		bMotor.rotate((tB)-bMotor.getCurRotation());
		mMotor.rotate(-t1Height);
	}

	public void tireA2(){
		mMotor.rotate((rideHeight)-mMotor.getCurRotation());
		bMotor.rotate((tA)-bMotor.getCurRotation());
		mMotor.rotate(-t2Height);
	}

	public void tireB2(){
		mMotor.rotate((rideHeight)-mMotor.getCurRotation());
		bMotor.rotate((tB)-bMotor.getCurRotation());
		mMotor.rotate(-t2Height);
	}

	public void tireA3(){
		mMotor.rotate((rideHeight)-mMotor.getCurRotation());
		bMotor.rotate((tA)-bMotor.getCurRotation());
		mMotor.rotateToDefaultPos();
	}

	public void tireB3(){
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

	public void cupC(){
		mMotor.rotate((rideHeight)-mMotor.getCurRotation());
		bMotor.rotate((cC)-bMotor.getCurRotation());
	}

	public void grabToggle(){
		tMotor.toggle();
	}

	public void rotateToDefaultPos(){
		if(mMotor.getCurRotation() != rideHeight){
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
