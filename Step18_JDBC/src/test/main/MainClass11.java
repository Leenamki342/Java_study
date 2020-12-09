package test.main;

import test.member.dao.MemberDao;
import test.member.dto.MemberDto;

public class MainClass11 {
	public static void main(String[] args) {
		/*
		 *   아래는 member 테이블에 저장된 회원의 번호라고 가정을 하자
		 *   
		 *   그런데 저 번호의 회원이 있는지 확실하지 않다.
		 *   
		 *   만일 존재한다면 해당회원의 정보를 콘솔창에 출력하고
		 *   
		 *   존재하지 않는다면 해당회원은 존재하지 않는다고 콘솔창에
		 *   
		 *   출력하는 프로그래밍을 해보기.
		 *   
		 *   단) MemberDao 객체를 활용해서...
		 */
		int num=808;
		
		MemberDto dto=new MemberDao().select(num);
		if(dto==null) {
			System.out.println(num+"번은 존재하지 않음");
		}else {
			System.out.println("num : "+num+" name : "+dto.getName()+" addr : "+dto.getAddr());
		}
	}
}
