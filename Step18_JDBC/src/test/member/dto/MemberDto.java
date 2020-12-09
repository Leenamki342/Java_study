package test.member.dto;

public class MemberDto {
	// 필드
	private int num;
	private String name;
	private String addr;
	// 디폴트 생성자
	public MemberDto() {}
	// 마우스 오른쪽 누르고 Source -> Generate Constructor from ...
	public MemberDto(int num, String name, String addr) {
		super();
		this.num = num;
		this.name = name;
		this.addr = addr;
	}
	// 마우스 오른쪽 누르고 Source -> Generate Getter and Setter ..
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
