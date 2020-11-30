package test.main;

import java.util.ArrayList;
import java.util.List;

import test.pac.Rect;

public class Test {
	public static void main(String[] args) {
		/*
		 *  1. Rect type 의 참조값을 담을 수 있는 ArrayList 객체를 생성해서
		 *  	ArrayList 객체의 참조값을 
		 *  	rects 라는 이름의 지역변수에 담기.
		 *  
		 *  2. new rects("크기") 과 같은 형식으로 rects 객체를 3개 생성해서
		 *     rects 에 들어있는 참조값을 이용해서 배열에 참조값을 담기.
		 *     
		 *  3. 반복문 돌면서 rects 안에 있는 Rect 객체의 참조값을 하나씩 순서대로 참조해서
		 *     .Area() 메소드를 호출하기.
		 *     
		 *  (콘솔창에 출력하는거 아님)
		 */
		List<Rect> rects=new ArrayList<>();
		rects.add(new Rect(10,20));
		rects.add(new Rect(30,40));
		rects.add(new Rect(50,60));
		
		for(Rect tmp:rects) {
			tmp.getArea();
		}
	}
	
}
