package test.main;

import test.mypac.Gun;
import test.mypac.Weapon;

public class MainClass03 {
	// 내부 Inner Class (내부 클래스에 한해서 필요시 static 예약어를 붙일 수 있다.)
	static class AirPlane extends Weapon{
		@Override
		public void attack() {
			System.out.println("공중에서 공격을 해요");
		}
	}
	
	public static void main(String[] args) {
		// Local Inner Class
		class Sword extends Weapon{
			@Override
			public void attack() {
				System.out.println("칼로 공격을 해요");
			}
		}
		Weapon w1=new Sword(); // Local Inner Class / 다른 지역 클래스
		useWeapon(w1);
		
		Weapon w2=new AirPlane(); // Inner Class / 같은 지역 다른 클래스
		useWeapon(w2);
		
		Weapon w3=new Gun(); // External Class / 외부 클래스
		useWeapon(w3);
	}
	// 만약, static을 빼면 참조값을 출력하기 때문에 
	// useWeapon(w1)을 new MainClass03().useWeapon(w1); 이렇게 바꿔야한다.
	public static void useWeapon(Weapon w) {
		w.prepare();
		w.attack();
	}
}
