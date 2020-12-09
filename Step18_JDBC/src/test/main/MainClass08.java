package test.main;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import test.member.dto.MemberDto;
import test.util.DBConnect;

/*
 *  member 테이블에서 회원목록을 SELECT 하고
 *  num 에 대해서 오름차순 정렬을 해서
 *  List<MemberDto> 형태로 만들기 
 */
public class MainClass08 {
	public static void main(String[] args) {
		
		List<MemberDto> list=new ArrayList<>();
		Connection conn=null;
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		try {
			// Connection의 참조값 얻어오기
			conn=new DBConnect().getConn();
			// sql문 뼈대 생성 ( 한칸씩 띄워야 보기 편함 )
			String sql="SELECT num,name,addr FROM member ORDER BY num ASC";
			// PreparedStatement 객체 
			pstmt=conn.prepareStatement(sql);
			// sql문에 ? 가 없으므로 바인딩할 내용도 없다. 
			// 쿼리문(SELECT) 수행하고 결과를 ResultSet 으로 받기
			rs=pstmt.executeQuery();
			while(rs.next()) { // 반복문 돌면서 커서를 한칸씩 내린다.
				// 커서가 위치한 곳의 데이터를 읽어와서 MemberDto 객체를
				// 생성해서 담는다.
				MemberDto dto=new MemberDto();
				dto.setNum(rs.getInt("num"));
				dto.setName(rs.getString("name"));
				dto.setAddr(rs.getString("addr"));
				// 생성된 MemberDto 객체의 참조값을 
				// ArrayList 객체에 누적시킨다.
				list.add(dto);
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
		// 위의 코드를 수행한 후 배열의 방 갯수 참조
		int size=list.size();
		// showInfo() 메소드에 List 참조값 전달하기
		showInfo(list);
		
		System.out.println("main 메소드를 종료합니다.");
	}
	public static void showInfo(List<MemberDto> list) {
		for(MemberDto tmp:list) {
			System.out.println(tmp.getNum()+"|"+tmp.getName()+
					"|"+tmp.getAddr());
		}
	}
}
