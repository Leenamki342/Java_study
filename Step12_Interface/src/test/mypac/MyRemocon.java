package test.mypac;

public class MyRemocon implements Remocon{
	// 인터페이스도 참조타입으로 입력가능하다.
	@Override
	public void up() {
		System.out.println("볼륨을 올려요");
		
	}

	@Override
	public void down() {
		System.out.println("불륨을 내려요");
		
	}
	
}
