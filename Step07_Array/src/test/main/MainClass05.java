package test.main;

import test.mypac.Car;

public class MainClass05 {
	public static void main(String[] args) {
		// 1. Car type 을 담을 수 있는 방 3개짜리 배열객체를 생성한 다음
		// 참조값을 cars 라는 지역변수에 담기
		Car[] cars=new Car[3];
		
		// 2. cars 배열에 Car 객체를 생성해서 순서대로 담기( 총 3개 )
		cars[0]=new Car();
		cars[1]=new Car();
		cars[2]=new Car();
		// 또는
		for(int i=0;i<cars.length;i++) {
			cars[i]=new Car();
		}
		// 3. cars 배열에 저장된 Car 객체의 참조값을 순서대로 참조해서
		// .drive() 메소드를 호출하기
		cars[0].drive();
		cars[1].drive();
		cars[2].drive();
		// 또는
		for(int i=0;i<cars.length;i++) {
			cars[i].drive();
		}
		// 다합쳐서 사용할 수 있다.
		for(int i=0;i<cars.length;i++) {
			cars[i]=new Car();
			
			cars[i].drive();
		}
	}
}
