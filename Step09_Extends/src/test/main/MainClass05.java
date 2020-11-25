package test.main;
/*
 * 	자녀를 키우고 있다고 가정하에
 * 	자녀가 현재 사용하는 폰이 인터냇이 안되는 구형폰이다.
 * 	자녀가 인터냇을 하고싶어서 스마트폰을 달라고 조른다.
 * 	어떻게 할까?
 * 
 * 	1. 스마트폰을 새로 사준다(만들어서 준다)
 * 
 * 	2. 스마트폰의 사용설명서만 가지고 와서 현재폰의 설명서라고 우기고 
 * 		그냥 지금 폰을 쓰라고 한다.
 */
import test.mypac.Phone;
import test.mypac.SmartPhone;

public class MainClass05 {
	public static void main(String[] args) {
		Phone p1=new Phone();
		// Phone 은 Object, Phone 이렇게 두가지 뿐이라
		// SmartPhone 은 없기 때문에 캐스팅이 안된다.
		// runtime 시에 ClassCastException 이 발생한다.
		// 위의 설명서에서 2번과 같은 경우이다.
		SmartPhone p2=(SmartPhone)p1;
		p2.doInternet();
	}
}