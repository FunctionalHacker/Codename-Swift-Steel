package robot;

public class Demo {
	boolean inDefaultPos;
	int color;
	int resourcesBox;
	int boxPos1;
	int boxPos2;

	public void sort() {
		if (!inDefaultPos) {
			rotateToDefaultPos();
		}

		craneMotor.lift();

		getResources();
		rotateToDefaultPos();
		color = colorSensor.calculateColor();
		sortToBox(color);
		rotateToDefaultPos(); //paljon makeempi tietenki jos ei tarvitse aina palata defaultPosiin...
	}


	public void rotateToDefaultPos() {
			craneMotor.lift();

		//}
		while(!touchSensor.getIsTouched()) { //Käännetään kurki oikeaan asentoon
			baseMotor.rotate(10);

		} //Lasketaan kurki alas
		//baseMotor.setAsMaxRotation(); tällä voisi asettaa baseMotorin max arvon
		baseMotor.stop();
		craneMotor.lower();
		inDefaultPos = true;
	}

	public void getResources() {
		inDefaultPos = false;
		while(baseMotor.getRotation() < resourcesBox) {
			baseMotor.rotate(10);
		}
		pickUp();
	}

	public void pickUp() {
		handMotor.open();
		craneMotor.lower();
		handMotor.close();
		craneMotor.lift();

	}

	public void sortToBox(int color) {
		if(!inDefaultPos) {
			rotateToDefaultPos();
		}

		inDefaultPos = false;
		if (color == 1) {
			while(baseMotor.getRotation < boxPos1) {
				baseMotor.rotate(10);
				pickUp();

			}
		} else {
			while(baseMotor.getRotation < boxPos2) {
				baseMotor.rotate(10);
				pickUp();
			}
		}
	}
}
