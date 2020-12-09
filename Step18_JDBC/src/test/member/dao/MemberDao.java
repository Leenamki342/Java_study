package test.member.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;

import test.util.DBConnect;

/*
 *   회원정보(member 테이블) 의 내용을
 *   select
 *   insert
 *   update
 *   delete
 *   작업을 할 객체를 생성할 클래스 설계하기
 */
public class MemberDao {
	
	// 회원 한명의 정보를 저장하는 메소드 만들기
	// 메소드명 : insert
	// 리턴타입 : 알아서
	// 메소드에 전달하는 인자의 type : MemberDto
	
	// 회원 한명의 정보를 수정하는 메소드 만들기
	// 메소드명 : update
	// 리턴타입 : 알아서
	// 메소드에 전달하는 인자의 type : MemberDto
	
	// 회원 한명의 정보를 delete 하는 메소드
	public boolean delete(int num) {
		
		
		// 필요한 찹조값을 담을 지역변수 미리 만들고 초기화하기
		Connection conn=null;
		PreparedStatement pstmt=null;
		int flag=0;
		try {
			// Connection 객체의 참조값 얻어오기
			conn=new DBConnect().getConn();
			// 실행할 sql 문의 뼈대 준비하기
			String sql="Delete FROM member WHERE num=?";
			// PreparedStatement 객체의 참조값 얻어오기
			pstmt=conn.prepareStatement(sql);
			// ? 에 값 바인딩 하기
			pstmt.setInt(1, num);
			// sql 문 실행하고 변화된 row 의 갯수 리턴받기
			flag=pstmt.executeUpdate();
			System.out.println("회원정보를 삭제했습니다.");
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			try {
				if(pstmt!=null)pstmt.close();
				if(conn!=null)conn.close();
			}catch(Exception e) {}
		}
		if(flag>0) {
			System.out.println("작업(DELETE) 성공");
		}else {
			System.out.println("작업(DELETE) 실패");
		}
		return false;
	}
}
