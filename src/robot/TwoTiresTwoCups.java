package robot;

public class TwoTiresTwoCups {

	Navigator navi;

	public TwoTiresTwoCups(){
		navi = new Navigator();
	}
	public void run(){
		navi.tireB();
		navi.grabToggle();
		navi.cupA();
		navi.grabToggle();
		navi.rotateToDefaultPos();
	}
}
