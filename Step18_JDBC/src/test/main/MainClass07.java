package test.main;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Scanner;

import test.member.dto.MemberDto;
import test.util.DBConnect;

/*
 *   Scanner 객체를 이용해서 검색할 회원의 번호를 입력받고
 *   입력받은 숫자를 이용해서 SELECT 문을 수행하고
 *   결과값을 MemberDto 객체를 생성해서 담기.
 *   
 *   결과가 없다면 MemberDto 객체를 생성하지 마세요. (null 인 상태로 두기)
 */
public class MainClass07 {
	public static void main(String[] args) {
		Scanner scan=new Scanner(System.in);
		System.out.println("검색할 번호 입력 : ");
		int num1=scan.nextInt();
		
		// 검색된 회원정보가 담길 MemberDto 객체의 참조값을 담을 지역변수
		MemberDto dto=null;
		Connection conn=null;
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		try {
			// Connection 객체의 참조값 얻어오기
			conn=new DBConnect().getConn();
			// 실행할 SELECT 문의 뼈대 준비하기
			String sql="SELECT num, name, addr FROM member WHERE num=?";
			// PreparedStatement 객체 
			pstmt=conn.prepareStatement(sql);
			// ? 에 값 바인딩해서 SELECT 문 완성하기
			pstmt.setInt(1, num1);
			// 쿼리문(SELECT) 수행하고 결과를 ResultSet 으로 받기
			rs=pstmt.executeQuery();
			if(rs.next()) { // Select 된 결과가 있다면
				// MemberDto 객체를 생성해서
				dto=new MemberDto();
				// Setter 메소드를 이용해서 담는다.
				dto.setNum(num1);
				// ResultSet 객체에 있는 값도 얻어와서 담는다.
				dto.setName(rs.getString("name"));
				dto.setAddr(rs.getString("addr"));
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
		// 위의 try~catch~finally 절이 수행된 후 SELECT 된 결과가 있는지 없는지를 
		// 여기서 쉽게 판별하는 방법
		if(dto==null) {
			System.out.println(num1+" 번 회원은 존재하지 않습니다.");
		}else {
			System.out.println("번호 : "+dto.getNum()+", 이름 : "+dto.getName()
			+", 주소 : "+dto.getAddr());
		}
	}
}
