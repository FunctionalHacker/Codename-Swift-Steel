package robot;

public class TwoTiresTwoCups extends Thread {

	Navigator navi;
	ColorSensor color;

	public TwoTiresTwoCups(BottomMotor bMotor, MiddleMotor mMotor, TopMotor tMotor, ColorSensor color){
		navi = new Navigator(bMotor, mMotor, tMotor);
		this.color = color;
	}
	public void run(){
		navi.lift();
		color.saveColors();

		// Tire A1
		navi.tireA1();
		navi.grabToggle();
		navi.rotateToDefaultPos();
		if (color.checkColor()==1) {
			System.out.println(color.checkColor());
			navi.cupA();
		} else if (color.checkColor()==2){
			System.out.println(color.checkColor());
			navi.cupB();
		} else {
			System.out.println(color.checkColor());
			navi.cupC();
		}
		navi.grabToggle();

		// Tire B1
		navi.tireB1();
		navi.grabToggle();
		navi.rotateToDefaultPos();
		if (color.checkColor()==1) {
			System.out.println(color.checkColor());
			navi.cupA();
		} else if (color.checkColor()==2){
			System.out.println(color.checkColor());
			navi.cupB();
		} else {
			System.out.println(color.checkColor());
			navi.cupC();
		}
		navi.grabToggle();

		// Tire A2
		navi.tireA2();
		navi.grabToggle();
		navi.rotateToDefaultPos();
		if (color.checkColor()==1) {
			System.out.println(color.checkColor());
			navi.cupA();
		} else if (color.checkColor()==2){
			System.out.println(color.checkColor());
			navi.cupB();
		} else {
			System.out.println(color.checkColor());
			navi.cupC();
		}
		navi.grabToggle();

		// Tire B2
		navi.tireB2();
		navi.grabToggle();
		navi.rotateToDefaultPos();
		if (color.checkColor()==1) {
			System.out.println(color.checkColor());
			navi.cupA();
		} else if (color.checkColor()==2) {
			System.out.println(color.checkColor());
			navi.cupB();
		} else {
			System.out.println(color.checkColor());
			navi.cupC();
		}
		navi.grabToggle();

		navi.rotateToDefaultPos();

		// Tire A3
		navi.tireA2();
		navi.grabToggle();
		navi.rotateToDefaultPos();
		if (color.checkColor()==1) {
			System.out.println(color.checkColor());
			navi.cupA();
		} else if (color.checkColor()==2){
			System.out.println(color.checkColor());
			navi.cupB();
		} else {
			System.out.println(color.checkColor());
			navi.cupC();
		}
		navi.grabToggle();

		// Tire B3
		navi.tireB2();
		navi.grabToggle();
		navi.rotateToDefaultPos();
		if (color.checkColor()==1) {
			System.out.println(color.checkColor());
			navi.cupA();
		} else if (color.checkColor()==2) {
			System.out.println(color.checkColor());
			navi.cupB();
		} else {
			System.out.println(color.checkColor());
			navi.cupC();
		}
		navi.grabToggle();

		navi.rotateToDefaultPos();
	}
}