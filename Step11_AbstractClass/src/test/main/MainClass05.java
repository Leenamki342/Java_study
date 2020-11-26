package test.main;
/*
 *  [ 추상클래스 (Abstract Class) ]
 *  
 *  - class 예약어 앞에 abstract 를 명시해서 클래스를 정의한다.
 *  - 형태만 정의되고 실제 구현은 되지 않은 메소드가 존재할수 
 *    있다.
 *  - 형태만 정의된 메소드를 만들때는 abstract 예약어를 
 *    붙어서 메소드를 정의한다.
 *  - 생성자는 존재하지만 단독으로 객체 생성은 불가하다
 *  - 추상클래스 Type 의 id 가 필요하다면 추상클래스를 상속받은 
 *    자식클래스를 정의해서 객체 생성한다.
 *  - 추상클래스를 상속받은 자식클래스는 부모의 추상메소드를 
 *    모두 오버라이드(재정의) 해야한다. 
 */
import test.mypac.Weapon;

public class MainClass05 {
	public static void main(String[] args) {
		// 익명클래스를 이용해서 1회용 Weapon type 참조값 얻어내서 메소드 호출하기
		// 지역변수에 담지 않았기 때문에 한번 사용한 후 재사용 불가
		useWeapon(new Weapon() {
			@Override
			public void attack() {
				System.out.println("마구잡이로 공격해요");	
			}
		});
	}
	public static void useWeapon(Weapon w) {
		w.prepare();
		w.attack();
	}
	
}
