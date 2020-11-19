package test.main;

import test.mypac.Car;

public class MainClass01 {
	public static void main(String[] args) {
		// Car Type 의 참조값을 담을 수 있는 빈 지역 변수 car1 만들기
		Car car1=null;
		// Car 클래스로 객체를 생성(new)하고 생성된 객체의 참조값을 car1 에 대입하기
		car1=new Car(); // 여기선 지역변수에 Car(); 의  참조값이 들어간 것이다.
		/*
		 * 	객체는 함수 인가요? 함수가 아니에요.
		 * 	null 이 아닌 다른값을 넣으면 덮어쓰기가 된다.
		 */
		// car1. 이렇게만 기록해도 9개의 구성이 자동으로 생성될 수 있다.
		// id(키값 / 참조값):45
		
		// <리턴위치 지정 방법>
		// boolean isEnd=true;
		// if(isEnd) {
		// 	return;
		// }
		car1.drive(); // 하나만 있는건 객체 두개 합친 것은 메소드이다.
		car1.hotHip(); 
	}
}
