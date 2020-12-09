package test.main;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Scanner;

import test.util.DBConnect;

/*
 *   Scanner 객체를 이용해서 검색할 회원의 번호를 입력받고
 *   DB 에서 Select 한 다음
 *   결과값이 있으면 해당 회원의 정보를 콘솔창에 출력하고
 *   결과값이 없으면 해당 회원은 존재하지 않습니다. 라고 출력되는 프로그래밍 하기.
 *   
 *   예)
 *   검색할 회원정보 입력:
 *   801
 *   801 번 회원은 존재하지 않습니다.
 *   
 *   검색할 회원정보 입력:
 *   850
 *   번호 : 850
 */
public class MainClass06 {
	public static void main(String[] args) {
		// 콘솔창으로 부터 입력받을 객체 생성
		Scanner scan=new Scanner(System.in);
		// 콘솔창에 입력한 값을 정수로 얻어낸다.
		System.out.println("회원번호 입력 : ");
		int num1=scan.nextInt();
		
		// 필요한 객체를 담을 지역변수 미리 만들기
		Connection conn=null;
		PreparedStatement pstmt=null;
		ResultSet rs=null; // int flag=0;
		try {
			// Connection 객체의 참조값 얻어오기
			conn=new DBConnect().getConn();
			// 실행할 SELECT 문의 뼈대 준비하기
			String sql="SELECT name, addr FROM member WHERE num=?";
			// PreparedStatement 객체 
			pstmt=conn.prepareStatement(sql);
			// ? 에 값 바인딩해서 SELECT 문 완성하기
			pstmt.setInt(1, num1);
			// 쿼리문(SELECT) 수행하고 결과를 ResultSet 으로 받기
			rs=pstmt.executeQuery();
			/*
			 *  member table 에서 num 은 PRIMARY KEY 값이다.
			 *  따라서 SELECT 된 결과 row 의 갯수는
			 *  0 이나 1 이 된다.
			 */
			// 이렇게 작성해도됨. boolean isExist=rs.next();
			if(rs.next()) {
				// SELECT 된 row 가 존재한다면 커서가 위치한 곳 데이터 읽어오기
				String name=rs.getString("name");
				String addr=rs.getString("addr");
				System.out.println("번호 : "+num1+" 이름 : "+name+" 주소 : "+addr);
			}else {
				System.out.println(num1+" 번 회원은 존재하지 않습니다.");
			}
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			try {
				if(pstmt!=null)pstmt.close();
				if(conn!=null)conn.close();
				if(rs!=null)rs.close();
			}catch(Exception e) {}
		}
	}
}
