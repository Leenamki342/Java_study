package test.main;

import java.util.ArrayList;
import java.util.List;

import test.pac.MemberDto;

public class MainClass06 {
	public static void main(String[] args) {
		// MemberDto 객체의 참조값을 담을 수 있는 ArrayList 객체를 생성해서
		// ArrayList 객체의 참조값을 List type 지역변수 members 에 담기
		List<MemberDto> members=new ArrayList<>();
		// 3명의 회원 정보를 members 배열에 담기
		
		// 방법 1
		MemberDto m1=new MemberDto(1, "김구라", "어디지");
		MemberDto m2=new MemberDto(2, "해골", "기억안나");
		MemberDto m3=new MemberDto(3, "덩어리", "어디죠");
		
		members.add(m1);
		members.add(m2);
		members.add(m3);
		
		// 방법 2
		members.add(new MemberDto(1, "ㅁ", "ㄴ"));
		members.add(new MemberDto(2, "a", "b"));
		members.add(new MemberDto(3, "c", "d"));
		
		// 다른 방법 3
		MemberDto mem1=new MemberDto();
		mem1.setNum(1);
		mem1.setName("김구라");
		mem1.setAddr("노량진");
		members.add(mem1);
		
		
		// 값 호출방법 두가지
		// 방법 1
		members.get(0).getNum();
		// 방법 2
		mem1.getNum();
		
	}
}
