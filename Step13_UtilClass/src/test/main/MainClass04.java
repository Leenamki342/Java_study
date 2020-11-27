package test.main;

import java.util.ArrayList;
import java.util.List;

public class MainClass04 {
	public static void main(String[] args) {
		// 정수를 저장할 ArrayList 객체를 생성해서 참조값을 nums라는 지역변수에 담기
		// int 는 예약어일 뿐 class 역할을 못하기 때문에 Integer을 입력해야함
		List<Integer> nums=new ArrayList<>();
		nums.add(10);
		nums.add(20);
		nums.add(30);
		
		// 실수를 저장할 ArrayList 객체를 생성해서 참조값을 nums2 라는 지역변수에 담기
		List<Double> nums2=new ArrayList<>();
		nums2.add(10.1);
		nums2.add(20.2);
		nums2.add(30.3);
	}
}
