package robot;

public class TwoTiresTwoCups {

	Navigator navi;
	ColorSensor color;

	public TwoTiresTwoCups(){
		navi = new Navigator();
		color = new ColorSensor("S1");
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
			navi.cupB();
		} else {
			System.out.println(color.checkColor());
			navi.cupA();
		}
		navi.grabToggle();

		// Tire B1
		navi.tireB1();
		navi.grabToggle();
		navi.rotateToDefaultPos();
		if (color.checkColor()==1) {
			System.out.println(color.checkColor());
			navi.cupB();
		} else {
			System.out.println(color.checkColor());
			navi.cupA();
		}
		navi.grabToggle();

		// Tire A2
		navi.tireA2();
		navi.grabToggle();
		navi.rotateToDefaultPos();
		if (color.checkColor()==1) {
			System.out.println(color.checkColor());
			navi.cupB();
		} else {
			System.out.println(color.checkColor());
			navi.cupA();
		}
		navi.grabToggle();

		// Tire B2
		navi.tireB2();
		navi.grabToggle();
		navi.rotateToDefaultPos();
		if (color.checkColor()==1) {
			System.out.println(color.checkColor());
			navi.cupB();
		} else {
			System.out.println(color.checkColor());
			navi.cupA();
		}
		navi.grabToggle();

		navi.rotateToDefaultPos();
	}
}