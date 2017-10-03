package robot;

public class TireDemo {
	public static void main(String[] args) {
		BottomMotor bMotor = new BottomMotor();
		MiddleMotor mMotor = new MiddleMotor();
		TopMotor tMotor = new TopMotor();

		mMotor.rotate(30*3);
		bMotor.rotate(300*3);
		mMotor.rotateToDefaultPos();
		tMotor.toggle();
		mMotor.rotate(500*3);
		bMotor.rotate(-70*3);
		tMotor.toggle();
		bMotor.rotateToDefaultPos();
		mMotor.rotateToDefaultPos();
	}
}
