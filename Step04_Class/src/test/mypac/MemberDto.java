package test.mypac;

public class MemberDto {
	public int num;
	public String name, addr;
	
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
}
