package robot;

/**
 * Just a demo of the robot lifting a tire and then dropping it.
 * @author Team 12: Ville Kautonen, Jerry Hällfors, Marko Korhonen
 *
 */
public class TireDemo {
	public static void main(String[] args) {
		TouchSensor tSensor = new TouchSensor("S2");
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
