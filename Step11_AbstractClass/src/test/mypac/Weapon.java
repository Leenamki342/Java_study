package test.mypac;

// 미완성의 메소드를 멤버로 가지고 있으려면 abstract 예약어를 붙인다.
public abstract class Weapon {
	// 무기 작동을 준비하는 메소드
	public void prepare() {
		System.out.println("무기 작동을 준비 합니다.");
	}
	// 공격하는 메소드 ( 모양은 완벽하지만 호출했을때 뭘해야할지 아무것도 알려지지 않음 )
	public abstract void attack();
}
