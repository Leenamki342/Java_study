package test.mypac;
/*
 * 	[ 클래스의 용도 ]
 * 
 * 	1. 객체의 설계도 역할 
 * 		- 객체는 값의 저장소(Field) 와 기능(Method) 으로 이루어져 있다.
 * 		- 객체의 설계도 역할이라는 의미는 해당 클래스로 객체를 생성 했을때
 *		    그 객체가 어떤 저장소와 어떤 기능을 갖게 할지 정할 수 있다는 의미이다.
 *		- 객체는 java script 에서 object{} 와 거의 유사하다.
 * 	2. Data Type 의 역할
 *  3. static 자원들을 감싸고 있는 역할
 */

// public 은 공개한다라는 의미가 있다.
public class Car {
	// 필드(저장소) 정의하기
	public String name;
	public int cc;
	
	public void drive() {
		// 자동차가 달리는 기능
		System.out.println("달려요!");
	}
	public void hotHip() {
		// 엉덩이를 따뜻하게 해주는 기능
		System.out.println("엉덩이를 따뜻하게해요.");
	}
}
