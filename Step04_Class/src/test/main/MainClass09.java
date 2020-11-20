package test.main;

import test.mart.Computer;
import test.mart.Cpu;
import test.mart.HardDisk;
import test.mart.Memory;

public class MainClass09 {
	public static void main(String[] args) {
		/*
		 * 	[ 프로그래밍의 목적 ]
		 * 
		 * 	test.mart  패키지 안에 있는 클래스를 활용해서 만들기
		 * 
		 * 	1. 게임을 한다.
		 * 	2. oli999@naver.com 으로 이메일을 보낸다.
		 */
		Cpu cpu=new Cpu();
		Memory memory=new Memory();
		HardDisk hardDisk=new HardDisk();
		
		Computer com=new Computer(cpu, memory, hardDisk);
		// 다른방식은 new Computer(new Cpu(), new Memory(), new HardDisk());
		// 이렇게 하면 따로 참조값을 지역변수에 넣지 않아도 된다.
		com.playGame();
		com.sendEmail("oli999@naver.com");
	}
}
