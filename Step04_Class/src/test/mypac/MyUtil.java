package test.mypac;
/*
 * 	static 자원을 포함하는 용도로 사용하기
 */
public class MyUtil {
	// non static 필드 (허상)
	public int version=1;
	
	// static 에서는 this 가 의미가 없음 (this 가 아닌 클래스명을 언급하면됨.)
	
	// static 필드 (진짜)
	public static String owner;
	public static void playMusic() {
		System.out.println("음악을 틀어요!");
	}
}
