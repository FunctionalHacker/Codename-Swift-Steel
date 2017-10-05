package robot;

public class Demo {
//	boolean inDefaultPos;
//	int color;
//	int resourcesBox;
//	int boxPos1;
//	int boxPos2;
//
//	BottomMotor bottomMotor = new BottomMotor(null);
//	MiddleMotor middlemotor = new MiddleMotor();
//	TopMotor topmotor = new TopMotor();
//
//	public void sort() {
//		if (!inDefaultPos) {
//			rotateToDefaultPos();
//		}
//
//
//		middleMotor.lift();
//
//		getResources();
//		rotateToDefaultPos();
//		color = colorSensor.calculateColor();
//		sortToBox(color);
//		rotateToDefaultPos(); //paljon makeempi tietenki jos ei tarvitse aina palata defaultPosiin...
//	}
//
//
//	public void rotateToDefaultPos() {
//			middleMotor.lift();
//
//		//}
//		while(!touchSensor.getIsTouched()) { //Käännetään kurki oikeaan asentoon
//			bottomMotor.rotate(10);
//
//		} //Lasketaan kurki alas
//		//bottomMotor.setAsMaxRotation(); tällä voisi asettaa bottomMotorin max arvon
//		bottomMotor.stop();
//		middleMotor.lower();
//		inDefaultPos = true;
//	}
//
//	public void getResources() {
//		inDefaultPos = false;
//		while(bottomMotor.getRotation() < resourcesBox) {
//			bottomMotor.rotate(10);
//		}
//		pickUp();
//	}
//
//	public void pickUp() {
//		topMotor.open();
//		middleMotor.lower();
//		topMotor.close();
//		middleMotor.lift();
//
//	}
//
//	public void sortToBox(int color) {
//		if(!inDefaultPos) {
//			rotateToDefaultPos();
//		}
//
//		inDefaultPos = false;
//		if (color == 1) {
//			while(bottomMotor.getRotation < boxPos1) {
//				bottomMotor.rotate(10);
//				pickUp();
//
//			}
//		} else {
//			while(bottomMotor.getRotation < boxPos2) {
//				bottomMotor.rotate(10);
//				pickUp();
//			}
//		}
//	}
}
