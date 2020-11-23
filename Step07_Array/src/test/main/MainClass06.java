package test.main;

import test.mypac.Rect;

public class MainClass06 {
	public static void main(String[] args) {
		/*
		 * 	가로 세로의 길이가 100, 100
		 * 	가로 세로의 길이가 200, 100
		 * 	가로 세로의 길이가 300, 200
		 *  인 사각형 3개가 있다.
		 *  
		 *  1. 각각에 대응되는 Rect 객체를 3개 생성해서
		 * 	rect1, rect2, rect3 라는 지역변수에 담기
		 * 
		 * 	2. rect1, rect2, rect3 에 담긴 참조값을 배열에 순서대로 담기
		 * 		배열의 참조값이 담길 지역변수는 rects 로 선언
		 * 
		 * 	3. rects 배열에 담긴 값을 순서대로 참조해서 .getArea() 메소드를 호출하고
		 * 		리턴되는 값을 이용해서 사격형의 넓이를 순서대로 콘솔창에 출력하기
		 */
		Rect rect1=new Rect(100, 100);
		Rect rect2=new Rect(200, 100);
		Rect rect3=new Rect(300, 200);
		
		// Rect[] rects={rect1, rect2, rect3};
		Rect[] rects=new Rect[3];
		rects[0]=rect1;
		rects[1]=rect2;
		rects[2]=rect3;
		
		for(int i=0;i<rects.length;i++) {
			
			// System.out.println(rects[i].getArea());
			
			// i 번째 방에 있는 Rect 객체를 참조해서
			Rect tmp=rects[i];
			
			// .getArea() 메소드를 호출해서 리턴되는 값을 콘솔창에 출력하기
			int area=tmp.getArea();
			System.out.println(area);
		}
	}
}
