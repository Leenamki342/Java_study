package test.mypac;
/*
 * 	[ 메소드를 만들 때 고려해야 하는 것]
 * 
 * 	1. 접근 지정자 ( public/공개, protected, default, private/비공개 )
 * 
 * 	2. static(클래스당 하나만) or non static(객체마다 하나씩)
 * 
 *  3. 리턴 타입 ( void 는 어떤 타입로 리턴하지 않는다 )
 *  
 *  4. 메소드명 ( 영문자 소문자로 시작하고 예약어가 아니면 된다. )
 *  
 *  5. 메소드에 전달하는 인자의 갯수와 데이터 타입
 */
public class MyObject {
	// 어떤 값도 리턴하지 않는 메소드
	public void walk() {
		System.out.println("걸음을 걸어요~");
	}
	// int 타입을 리턴하는 메소드
	public int getNumber() {
		int num=10;
		return num;
	}
	// String 타입을 리턴하는 메소드
	public String getGreeting() {
		String greet="안녕하세요";
		return greet;
	}
	// Home 타입을 리턴하는 메소드
	public House getHouse() {
		House home=new House();
		return home; // 또는 return new House();
	}
	// Phone 타입을 전달받는 메소드
	public void usePhone(Phone p) {
		p.call();
	}
	// Phone 타입을 전달받는 static 메소드
	public static void callPhone(Phone p) {
		p.call();
	}
	// House 타입을 리턴해주는 static 메소드
	public static House buyHouse() {
		return new House();
	}
}
