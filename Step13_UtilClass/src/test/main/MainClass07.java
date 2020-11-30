package test.main;

import java.util.ArrayList;
import java.util.List;

import test.pac.Car;

public class MainClass07 {
	public static void main(String[] args) {
		/*
		 *  1. Car type 의 참조값을 담을 수 있는 ArrayList 객체를 생성해서
		 *  	ArrayList 객체의 참조값을 
		 *  	cars 라는 이름의 지역변수에 담기.
		 *  
		 *  2. new Car("차의 이름") 과 같은 형식으로 Car 객체를 3개 생성해서
		 *     cars 에 들어있는 참조값을 이용해서 배열에 참조값을 담기.
		 *     
		 *  3. 반복문 돌면서 cars 안에 있는 Car 객체의 참조값을 하나씩 순서대로 참조해서
		 *     .drive() 메소드를 호출하기.
		 *     
		 *  (콘솔창에 출력하는거 아님)
		 */
		// 1.
		List<Car> cars=new ArrayList<>();
		// 2.
		cars.add(new Car("아우디"));
		cars.add(new Car("BMW"));
		cars.add(new Car("제네시스"));
		// 3.
		for(Car tmp:cars) {
			tmp.drive();
		}
	}
}
