package test.mypac;

public class Rect {
	// 필드
	private int width;	// 폭을 저장할 필드
	private int height;	// 높이를 저장할 필드
	// 생성자의 인자로 width 와 height 를 전달 받아서 필드에 저장하는
	// 생성자를 정의하기
	public Rect(int width, int height) {
		this.height=height;	// 필드 = 지역변수
		this.width=width;	
	}
	
	// 필드에 저장된 width 와 height 를 이용해서 사각형의 넓이를 리턴하는 메소드를
	// 정의하기 ( 메소드명은 getArea() 로 지정 )
	public int getArea() {
		return this.height*this.width;
	}
	
}
