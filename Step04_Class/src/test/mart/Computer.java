package test.mart;

public class Computer {
	// 필드
	private Cpu cpu;
	private Memory memory;
	private HardDisk hardDisk;

	// 생성자를 하나라도 정의하면 default 생성자는 사라지게 된다.
	// 생성자 (생성자는 여러개 정의할 수 있다 / 오버로딩)
	public Computer(Cpu cpu, Memory memory, HardDisk hardDisk) {
		this.cpu=cpu;
		this.memory=memory;
		this.hardDisk=hardDisk;
	}
	
	// 메소드
	public void playGame() {
		System.out.println("게임을 해요!");
	}
	public void sendEmail(String addr){
		System.out.println(addr+" 이라는 주소로 이메일을 보내요!");
	}
}
