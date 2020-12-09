package test.member.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import test.member.dto.MemberDto;
import test.util.DBConnect;

/*
 *   회원정보(member 테이블) 의 내용을
 *   select
 *   insert
 *   update
 *   delete
 *   작업을 할 객체를 생성할 클래스 설계하기
 *   
 *   - 필요한 객체를 담을 지역변수를 선언하는 위치도 중요하다.
 *   - 필요한 객체를 생성하는 위치도 중요하다.
 *   
 */
public class MemberDao {
	// 모든 회원의 정보를 SELECT 해서 리턴하는 메소드
	public List<MemberDto> selectAll(){
		// MemberDto 객체를 누적실킬 ArrayList 객체 생성하기
		List<MemberDto> list=new ArrayList<>();
		Connection conn=null;
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		try { // try 안에서 만들어진 지역변수는 try 밖에서 사용 불가능하다.
			conn=new DBConnect().getConn();
			// 실행할 SELECT 문 작성
			String sql="SELECT num,name,addr FROM member ORDER BY num ASC";
			pstmt=conn.prepareStatement(sql);
			// ? 에 바인딩 할게 있으면 하고 아니면 말고
			rs=pstmt.executeQuery();
			while(rs.next()) {
				// select 된 row 하나의 정보를 MemberDto 객체를 생성해서 담고
				MemberDto dto=new MemberDto();
				dto.setNum(rs.getInt("num"));
				dto.setName(rs.getString("name"));
				dto.setAddr(rs.getString("addr"));
				// 새로 생성한 MemberDto 객체의 참조값을 ArrayList 객체에 누적시킨다.
				list.add(dto);
			}
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			try {
				if(rs!=null)rs.close();
				if(pstmt!=null)pstmt.close();
				if(conn!=null)conn.close();
			}catch(Exception e) {}
		}
		if(list.size()>0) {
	    	System.out.println("실패");
	    }else {
	    	System.out.println("성공");
	    }
		return list;
	}
	
	// 회원 한명의 정보를 SELECT 해서 리턴하는 메소드
	public MemberDto select(int num) {
		// 회원 한명의 정보를 담고 있는 MemberDto 객체를 담을 지역변수 만들기
		MemberDto dto=null;
		// 필요한 객체의 참조값을 담을 지역변수 만들기 
		// ( 지역변수에 null 을 넣는 이유는 어떤 값이든 넣지 않으면 만들어지지 않기 때문  )
		// 연결
		Connection conn=null;
		// 준비상태
		PreparedStatement pstmt=null;
		// 결과
		ResultSet rs=null;
		try {
			conn=new DBConnect().getConn();
			String sql="SELECT name,addr FROM member WHERE num=?";
			pstmt=conn.prepareStatement(sql);
			// ? 에 값 바인딩 하기.
			pstmt.setInt(1,num);
			// SELECT 문 수행하고 결과를 ResultSet 으로 받기
			rs=pstmt.executeQuery(); // SELECT 문은 Query , 나머지는 Update
			if(rs.next()) { // 만일 select 된 row 가 있다면
				// 결과를 MemberDto 객체를 생성해서 담는다.
				dto=new MemberDto();
				dto.setNum(num);
				dto.setName(rs.getString("name"));
				dto.setAddr(rs.getString("addr"));
			}
			
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			try {
				// 마무리 작업 ( 만약 제대로 닫지 않으면 서버가 응답을 안할 수 있음 )
				// != null 을 하는 이유는 Exception 이 발생해도 다음 순서로 넘어가게 하기 위해서
				if(pstmt!=null)pstmt.close();
				if(conn!=null)conn.close();
				if(rs!=null)rs.close();
			}catch(Exception e) {}
		}
		
		return dto;
	}
	
	// 회원 한명의 정보를 저장하는 메소드 만들기
	// 메소드명 : insert
	// 리턴타입 : 알아서
	// 메소드에 전달하는 인자의 type : MemberDto

	public boolean insert(MemberDto dto) {
		
		// 필요한 참조값을 담을 지역변수 미리 만들고 초기화하기
		Connection conn=null;
		PreparedStatement pstmt=null;
		int flag=0;
		try {
			// Connection 객체의 참조값 얻어오기
			conn=new DBConnect().getConn();
			// 실행할 sql 문의 뼈대 준비하기
			String sql="INSERT INTO member"
					+ " (num, name, addr)"
					+ " VALUES(member_seq.NEXTVAL, ?, ?)";
			// PreparedStatement 객체의 참조값 얻어오기
			pstmt=conn.prepareStatement(sql);
			// ? 에 값 바인딩 하기
			pstmt.setString(1, dto.getName());
			pstmt.setString(2, dto.getAddr());
			// INSERT 문 수행하기 ( 1개의 row 가 추가되었으므로 1이 리턴된다. ) 
			flag=pstmt.executeUpdate();
			System.out.println("회원정보를 입력했습니다.");
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			try {
				if(pstmt!=null)pstmt.close();
				if(conn!=null)conn.close();
			}catch(Exception e) {}
		}
		if(flag>0) {
			return true;
		}else {
			return false;
		}
		
	}
	
	// 회원 한명의 정보를 수정하는 메소드 만들기
	// 메소드명 : update
	// 리턴타입 : 알아서
	// 메소드에 전달하는 인자의 type : MemberDto
	
	public boolean update(MemberDto dto) {
		
		// 필요한 참조값을 담을 지역변수 미리 만들고 초기화하기
		Connection conn=null;
		PreparedStatement pstmt=null;
		int flag=0;
		try {
			// Connection 객체의 참조값 얻어오기
			conn=new DBConnect().getConn();
			// 실행할 sql 문의 뼈대 준비하기
			String sql="UPDATE member SET addr=?, name=? WHERE num=?";
			// PreparedStatement 객체의 참조값 얻어오기
			pstmt=conn.prepareStatement(sql);
			// ? 에 값 바인딩 하기 ( sql 문에서 ? 순서에 맞춰서 ) 
			pstmt.setString(1, dto.getAddr());
			pstmt.setString(2, dto.getName());
			pstmt.setInt(3, dto.getNum());
			// sql 문 실행하고 변화된 row 의 갯수 리턴받기
			flag=pstmt.executeUpdate();
			System.out.println("회원정보를 수정했습니다.");
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			try {
				if(pstmt!=null)pstmt.close();
				if(conn!=null)conn.close();
			}catch(Exception e) {}
		}
		if(flag>0) {
			return true;
		}else {
			return false;
		}
		
	}
	
	// 회원 한명의 정보를 delete 하는 메소드
	public boolean delete(int num) {
		
		// 필요한 참조값을 담을 지역변수 미리 만들고 초기화하기
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
			return true;
		}else {
			return false;
		}
		
	}
}
