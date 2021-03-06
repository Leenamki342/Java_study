package test.main;

import java.sql.Connection;
import java.sql.PreparedStatement;

import test.util.DBConnect;

/*
 *   member 테이블에서
 *   회원번호가 801 번 회원의 정보를 삭제하는 기능을 완성하기.
 *   hint
 *   new DBConnect().getConn();
 */
public class MainClass05{
	public static void main(String[] args) {
		// 삭제할 회원의 번호
		int num=835;
		
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
	}
}
