package test.main;
/*
 * 	1. 배열을 어떻게 만드는지?
 * 	
 * 	- 배열은 { } 열고 닫고 해서 만든다. 
 * 
 * 	2. 배열의 데이터 type 은 어떻게 선언하는지?
 * 
 * 	- 배열안에 저장된 type + [ ] 기호를 조합해서 선언한다. 
 * 
 * 	3. nums, nums2, truth, names 에 저장된 값은 참조값인지? 아닌지?
 * 		(배열이 참조 데이터 type 인지? 기본 데이터 type 인지?)
 * 
 * 	- 배열은 참조 데이터 type 이다.
 * 
 * 	- 가변배열에는 참조데이터타입 /고정배열에는 기본,참조 둘다 가능하다.
 * 	int = 기본데이터 타입
 *  int[] = 참조데이터타입
 */
public class MainClass01 {
	public static void main(String[] args) {
		
		// int type 5 개를 저장하고 있는 배열
		int[] nums= {10,20,30,40,50};
		
		// double type 5 개를 저장하고 있는 배열
		double[] num2= {10.1, 10.2, 10.3, 10.4, 10.5};
		
		// boolean type 3 개를 저장하고 있는 배열
		boolean[] truth= {true, false, false};
		
		// String type 3 개를 저장하고 있는 배열
		String[] names= {"김구라", "해골", "원숭이"};
		
		// 배열의 방 갯수 5 가 참조된다.
		int size=nums.length;
		
		// 배열의 방 갯수 3 이 참조된다.
		int size2=names.length;
		
		// 배열의 각 방에 저장된 아이템을 참조하는 방법
		int num11=nums[0];
		int num22=nums[1];
		int num33=nums[2];
		
		String name1=names[0];
		String name2=names[1];
		String name3=names[2];
	}
}
