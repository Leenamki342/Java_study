package test.main;

import test.mypac.Member;

public class MainClass05 {
	public static void main(String[] args) {
		/*
		 *  두명의 회원정보를 2개의 Member 객체를 생성해서 담아보세요.
		 *  
		 *  this 란 자신이 포함된 객체의 참조값을 가르키는 예약어이다.
		 */
		Member mem1=new Member();
		mem1.num=1;
		mem1.name="김구라";
		mem1.addr="노량진";
		
		Member mem2=new Member();
		mem2.num=2;
		mem2.name="해골";
		mem2.addr="행신동";
	}
}