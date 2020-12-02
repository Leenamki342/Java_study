package test.main;

import java.util.Random;

/*
 *  프로그래머가 직접 예외 클래스를 정의하고
 *  필요한 시점에 예외를 발생 시킬수도 있을까?
 *  
 *  Exception or RuntimeException 클래스를 상속받으면 가능하다.
 *  Exception 은 try, catch 로 반드시 묶어야하고
 *  RuntimeException 은 try, catch가 아닌 extends로 가능
 */
public class MainClass07 {
	public static void main(String[] args) {
		System.out.println("main 메소드가 시작되었습니다.");
		
		Random ran=new Random();
		int ranNum=ran.nextInt(5);
		if(ranNum==0) { // 우연히 0이 나오면
			// throw 예약어를 이용해서 HeadacheException 발생시키기
			throw new HeadacheException("으악 머리 아파 ㅠㅠ");
		}
		
		System.out.println("main 메소드가 종료됩니다.");
	}
	// static 클래스 안에선 같은 static class 만 사용이 가능하다.
	// 머리아픈 Exception 
	static class HeadacheException extends RuntimeException{
		// 예외 메세지를 String type 으로 전달받는 생성자
		public HeadacheException(String msg) {
			// 부모 생성자에 전달해야한다.
			super(msg);
		}
	}	
}
