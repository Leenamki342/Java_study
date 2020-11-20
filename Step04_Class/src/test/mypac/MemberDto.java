package test.mypac;

public class MemberDto {
	// 필드의 접근 지정자를 private 로 하면 객체 내부에서만 접근 가능하고
	// 외부에서 접근 불가능하다.
	// 메소드의 기능이 망가지는걸 막기위해서 사용한다.
	// public <=> private 서로 반대
	private int num;
	private String name, addr;
	
	/*
	 * 	class 안에 들어올 수 있는것 1. 필드, 2. 메소드, 3. 생성자
	 *  메소드는 public void 메소드명 이렇게 void 가 필요하지만
	 *  그냥 public 은 객체를 new 할때 호출되는 생성자
	 *  메소드가 아니라 생성자(Constructor) 이다.
	 */
	
	public MemberDto(int num,String name,String addr) {
		System.out.println("MemberDto() 생성자가 호출됨!");
		// 생성자로 전달받은 값을 필드에 저장하기.
		this.num=num;
		this.name=name;
		this.addr=addr;
	}
	// 데이터 타입과 필드 명이 정해져있을때 set, get + ctrl + space를 하면 자동완성 된다.
	// 또는 오른쪽 마우스 - Source - Ganerater setter and getter 을 하고
	// 모두 체크하고 Ganerater 하면 한번에 만들어진다.
	public int getNum() {
		return num;
	}

	public void setNum(int num) {
		this.num = num;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAddr() {
		return addr;
	}

	public void setAddr(String addr) {
		this.addr = addr;
	}
	
}
