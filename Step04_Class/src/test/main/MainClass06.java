package test.main;

import test.mypac.MemberDto;

public class MainClass06 {
	public static void main(String[] args) {
		// MemberDto 객체 생성해서 참조값을 dto1 이라는 이름의 지역변수에 담기
		// 결국 new 라는 것은 뒤의 클래스명/생성자 을(를) 데리고 오는것이다.
		MemberDto dto1=new MemberDto(1, "김구라", "addr");
		
	}
}
