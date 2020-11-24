package test;

public class Step02_Step07_arrange {
	/*
	 * 	지역변수 : 메소드 or 생성자 안에서 선언된 변수
	 * 			실행 순서가 왔을때만 생성되고 실행된 이후엔 사라진다.
	 * 			{}안 생성 방법 => 데이터타입 지역변수명=value;
	 * 			()안 생성 방법/매개변수 => 데이터타입 매개변수명
	 * 
	 * 	메모리에서 만들어지는 영역 : stack 영역
	 * 
	 * 	ex) V 표시가 된곳에 들어갈 수 있다.
	 * 
	 * 	public class Car{
	 * 	
	 * 		public Car( V ){ 			생성자
	 * 			V
	 * 		}
	 * 		public void drive( V ){	메소드
	 * 			V
	 * 		}
	 * 	}
	 * 
	 * 	- 지역변수는 좀더 좁은 범위의 지역변수도 존재한다.
	 *  - 좁은 범위란 생성자 혹은 메소드보다 더 좁은 범위를 말한다.
	 *  - {} 안에서 선언된 지역변수는 실행순서가 {} 를 벗어나면 해당 지역변수는 사라진다.
	 *  
	 *  지역변수 : name, num, greet
	 * 			greet는 if문 안에서 선언된 변수이기 때문에 if문 {}안에서만 사용할수있다.
	 *  
	 *  public void test(String name){
	 *  	int num=10;
	 *  
	 *  	if( num >= 10 ){
	 *  		String greet="hello";
	 *  	}
	 *  
	 *  	System.out.println(name);
	 *  	System.out.println(num);
	 *  	System.out.println(greet);
	 *  	=> 에러/greet는 if문에서만 존재하기 때문에
	 *  }
	 * 
	 * 	java 에서 사용하는 data type
	 * 	
	 * 	1. 기본 data type : 실제 value를 다루는 데이터 type
	 * 					 stack 영역에 일어나는 일 /변수에 실제 value값이 들어있다.
	 * 
	 * 		정수형 : byte, short, int, long
	 * 		실수형 : float, double
	 * 		논리형 : boolean
	 * 		문자형 : char
	 * 
	 * 	2. 참조 data type : 설계된 클래스 자체가 data type 역할을 하기 때문에
	 * 					  종류가 엄청나게 많다.
	 * 
	 * 		String, Car, Phone, House ...
	 * 
	 * 		String name="kim";
	 * 		=> name 이라는 변수에 "kim"이라는 정보를 가지고 있는 객체가 heap 영역
	 * 			어디에 있는지 참조값(id값)이 들어있다.
	 * 	
	 * 	- 원하는 데이터 type 만드는 방법
	 * 
	 * 	int num = 10;
	 *  boolean isRun = true;
	 *  char ch = 'A';
	 *  
	 *  - 참조 데이터 type String 은 만드는 방법이 간단하다 (new 예약어 없이)
	 *  String name = "kimgura";
	 *  
	 *  - String 이외에 다른 참조 데이터 type 은 new 라는 예약어를 이용해서 만든다
	 *  (배열은 예외)
	 *  Car c1 = new Car();
	 *  
	 *  - new 예약어를 이용해서 만들어지는 (String 포함) 것의 실체는 Object(객체)이다.
	 *  
	 *  - 객체는 메모리 영역중에서 heap 영역에 만들어지고
	 *  
	 *  - 객체는 Field(저장소)와 Method(기능)으로 이뤄질수 있다.
	 *  
	 *  이런 작업을 할때는 이런 클래스의 이런 메소드를 활용하고
	 *  저런 작업을 할때는 이런 객체의 이런 메소드를 활용하고
	 *  어떤 값이 필요할 때는 이런 객체의 이런 필드를 참조하고... 
	 */
}
