package test.main;

import test.mypac.MyObject;

public class MainClass01 {
	public static void main(String[] args) {
		// 1. MyObject 객체를 생성해서 참조값을 m1 이라는 지역변수에 담기
		MyObject m1=new MyObject();
		
		// 2. m1 안에 들어있는 참조값을 이용해서 3개의 메소드를 모두 호출하기
		m1.walk();
		m1.getGreeting();
		m1.getNumber();
		
		// 3. m1 안에 들어있는 참조값을 이용해서 getNumber() 메소드를
		// 다시 호출하고 리턴되는 값을 a라는 지역변수에 담기
		int a=m1.getNumber();
		
		// 4. m1 안에 들어있는 참조값을 이용해서 getGreegint() 메소드를
		// 다시 호출하고 리턴되는 값을 b라는 지역변수에 담기
		String b=m1.getGreeting();
	}
}
