package test.main;

import test.mypac.MyObject;
import test.mypac.Phone;

public class MainClass04 {
	public static void main(String[] args) {
		// MyObject 클래스에 있는 usePhone() 메소드를 출력하기
		MyObject m1=new MyObject();
		Phone p1=new Phone();
		m1.usePhone(p1);
		
		// 두줄 코딩
		MyObject myphone=new MyObject();
		myphone.usePhone(new Phone());
		
		// 한줄 코딩
		new MyObject().usePhone(new Phone());
	}
}
