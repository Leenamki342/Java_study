package tset.dept.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import test.dept.dto.DeptDto;
import test.util.DBConnect;

/*
 *   1. 모든 회원 select
 *   2. 선택한 회원 select
 *   3. 회원 insert
 *   4. 회원 update
 *   5. 회원 delete
 */

public class DeptDao {
	
	// 1. selectAll
	public List<DeptDto> selectAll(){
		List<DeptDto> list=new ArrayList<>();
		Connection conn=null;
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		try {
			conn=new DBConnect().getConn();
			String sql="SELECT deptno, dname, loc FROM dept ORDER BY ASC";
			pstmt=conn.prepareStatement(sql);
			rs=pstmt.executeQuery();
			while(rs.next()) {
				DeptDto dto=new DeptDto();
				dto.setDeptno(rs.getInt("deptno"));
				dto.setDname(rs.getString("dname"));
				dto.setLoc(rs.getString("loc"));
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
		return null;
	}
	
	// 2. select
	public DeptDto select(int deptno) {
		DeptDto dto=null;
		Connection conn=null;
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		try {
			conn=new DBConnect().getConn();
			String sql="SELECT dname, loc FROM dept WHERE deptno=?";
			pstmt=conn.prepareStatement(sql);
			pstmt.setInt(1, deptno);
			rs=pstmt.executeQuery();
			while(rs.next()) {
				dto=new DeptDto();
				dto.setDeptno(deptno);
				dto.setDname(rs.getString("dname"));
				dto.setLoc(rs.getString("loc"));
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
		return dto;
	}
	
	// 3. insert
	public boolean insert(DeptDto dto) {
		Connection conn=null;
		PreparedStatement pstmt=null;
		int flag=0;
		try {
			conn=new DBConnect().getConn();
			String sql="INSERT INTO dept (deptno, dname, loc) VALUES(member_seq.NEXTVAL, ?, ?)";
			pstmt=conn.prepareStatement(sql);
			pstmt.setString(1, dto.getDname());
			pstmt.setString(2, dto.getLoc());
			flag=pstmt.executeUpdate();
			System.out.println("새로운 회원 정보가 입력되었습니다.");
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
	// 4. update
	public boolean update(DeptDto dto) {
		Connection conn=null;
		PreparedStatement pstmt=null;
		int flag=0;
		try {
			conn=new DBConnect().getConn();
			String sql="UPDATE dept SET dname=?loc=? WHERE deptno=?";
			pstmt=conn.prepareStatement(sql);
			pstmt.setString(1, dto.getDname());
			pstmt.setString(2, dto.getLoc());
			pstmt.setInt(3, dto.getDeptno());
			flag=pstmt.executeUpdate();
			System.out.println("회원 정보가 수정되었습니다.");
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
	
	// 5. delete
	public boolean delete(int deptno) {
		Connection conn=null;
		PreparedStatement pstmt=null;
		int flag=0;
		try {
			conn=new DBConnect().getConn();
			String sql="DELETE FROM dept WHERE deptno=?";
			pstmt=conn.prepareStatement(sql);
			pstmt.setInt(1, deptno);
			flag=pstmt.executeUpdate();
			System.out.println("선택하신 row 가 삭제되었습니다.");
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
