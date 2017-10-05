package robot;

public class TwoTiresTwoCups {

	Navigator navi;

	public TwoTiresTwoCups(){
		navi = new Navigator();
	}
	public void run(){
		navi.tireA();
		navi.grabToggle();
		navi.cupA();
		navi.grabToggle();
		navi.tireB();
		navi.grabToggle();
		navi.cupB();
		navi.grabToggle();
		navi.rotateToDefaultPos();
	}
}
