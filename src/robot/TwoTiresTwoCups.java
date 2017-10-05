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
		navi.tireA();
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
		navi.tireB();
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