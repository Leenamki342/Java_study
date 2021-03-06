package test.main;

import test.mypac.Member;

public class MainClass04 {
	public static void main(String[] args) {
		/*
		 * 	회원 한명의 정보
		 * 	번호 : 1
		 *  이름 : 김구라
		 *  주소 : 노량진
		 *  이라고 가정하고 해당 정보를 Member 객체에 담는 코드를 작성하기.
		 *  자바는 클래스안에 지정된 객체만 변수입력이 가능한데
		 *  스크립트는 유연하게 새로운 변수를 생성 가능하다.
		 */
		Member mem1=new Member();
		mem1.num=1;
		mem1.name="김구라";
		mem1.addr="노량진";
		
		/*
		 * 	위의 작업은 javascript 에서 아래의 작업과 같다.
		 * 	
		 * 	let mem1={};
		 * 	mem1.num=1;
		 * 	mem1.name="김구라";
		 * 	mem1.addr="노량진";
		 */
		
		/*
		 * mem1 에 들어있는 참조값을 이용해서
		 * 콘솔창에 아래와 같은 형식으로 출력하기.
		 * 번호 : 1, 이름 : 김구라, 주소 : 노량진
		 */
		System.out.println("번호 : "+mem1.num+", 이름 : "+mem1.name+ ", 주소 : "+mem1.addr);
		mem1.showInfo();
	}
}
