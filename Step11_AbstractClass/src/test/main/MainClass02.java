package test.main;

import test.mypac.Gun;
import test.mypac.Weapon;

public class MainClass02 {
	public static void main(String[] args) {
		/*
		 *  직접 Weapon 추상클래스를 상속받은 클래스를
		 *  정의해서 객체 생성하고 해당 참조값을 이용해서
		 *  아래의 useWeapon 메소드를 호출해 보세요.
		 *  ( 단, 클래스명은 MyWeapon 말고 다른걸로)
		 */
		Weapon shot=new Gun();
		useWeapon(shot);
		
		Weapon shot1=new Gun();
		MainClass02.useWeapon(shot1); // 클래스명은 생략 가능
		
	}
	// Weapon type 참조값을 인자로 전달받는 메소드
	public static void useWeapon(Weapon w) {
		w.prepare();
		w.attack();
	}
}
