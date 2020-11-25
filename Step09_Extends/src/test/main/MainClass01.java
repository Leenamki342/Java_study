package test.main;

import test.mypac.HandPhone;
import test.mypac.Phone;

public class MainClass01 {
	// run 했을 때 application 의 시작점/도입점이 되는 main 메소드
	public static void main(String[] args) {
		Phone p1=new Phone(); // run을 해야 참조값이 지역변수에 담긴다.
		HandPhone p2=new HandPhone();
		// extends를 하면 부모클래스의 데이터값을 상속받을 수 있다.
		p1.call();
		// 부모클래스(Phone)에 정의된 메소드 호출가능
		p2.call();
		// 자식클래스(HandPhone)에 추가된 메소드는 당연히 호출가능
		p2.mobileCall();
		p2.takePicture();
	}
}
