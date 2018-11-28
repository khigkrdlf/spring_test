package spring.model.member;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import spring.db.webtest.DBClose;
import spring.db.webtest.DBOpen;

@Repository
public class MemberDAO {
	@Autowired
	private SqlSessionTemplate mybatis;
	
	public void setMybatis(SqlSessionTemplate mybatis) {
		this.mybatis = mybatis;
	}

	public MemberDTO Pwfind(String id){
		
		return mybatis.selectOne("member.getPwFind", id);
	}
	
	public MemberDTO Idfind(String email){
		return mybatis.selectOne("member.getIdFind", email);
	}
	
	public String getGrade(String id){
		
		return mybatis.selectOne("member.getGrade", id);
	}
	
	public boolean loginCheck(Map map){
		boolean flag = false;
		int cnt = mybatis.selectOne("member.loginCheck", map);
		if(cnt>0)flag=true;
		return flag;
	}
	
	public String getFname(String id){
		
		return mybatis.selectOne("member.getFname", id);
	}
	
	public MemberDTO readPw(String id){
		MemberDTO dto = new MemberDTO();
		Connection con = DBOpen.open();
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		StringBuffer sql = new StringBuffer();
		sql.append(" select passwd ");
		sql.append(" from member ");
		sql.append(" where id = ? ");
		
		try {
			pstmt = con.prepareStatement(sql.toString());
			pstmt.setString(1, id);
			
			rs = pstmt.executeQuery();
			
			if(rs.next()){
				dto.setPasswd(rs.getString("passwd"));
				
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			DBClose.close(rs, pstmt, con);
		}
		
		
		return dto;
	}
	

	public boolean updatePw(Map map){
		boolean flag = false;
		int cnt = mybatis.update("member.updatePw", map);
		if(cnt>0)flag=true;
		return flag;
	}
	
	public boolean updateFile(Map map){
		boolean flag = false;
		int cnt = mybatis.update("member.updateFile", map);
		if(cnt>0)flag=true;
		return flag;
	}
	
	public boolean duplicateMname(String mname){
		boolean flag = false;
		Connection con = DBOpen.open();
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		StringBuffer sql = new StringBuffer();
		sql.append(" select count(mname) ");
		sql.append(" from member ");
		sql.append(" where mname = ? ");
		
		try {
			pstmt = con.prepareStatement(sql.toString());
			pstmt.setString(1, mname);
			
			rs = pstmt.executeQuery();
			
			if(rs.next()){
				int cnt = rs.getInt(1);
				if(cnt>0)flag=true;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			DBClose.close(rs, pstmt, con);
		}
		
		return flag;
	}
	
	public boolean duplicateEmail(String email){
		boolean flag = false;
		int cnt = mybatis.selectOne("member.duplicateEmail", email);
		if(cnt>0)flag=true;
		return flag;
	}
	
	public boolean duplicateId(String id){
		boolean flag = false;
		int cnt = mybatis.selectOne("member.duplicateId", id);
		if(cnt>0)flag=true;
		return flag;
	}
	
	public int total(Map map){
		
		return mybatis.selectOne("member.total", map);
	}
	
	public List<MemberDTO> list(Map map){
		
		return mybatis.selectList("member.list", map);
	}
	
	public MemberDTO read(String id){
		
		return mybatis.selectOne("member.read", id);
	}
	
	public boolean update(MemberDTO dto){
		boolean flag = false;
		int cnt = mybatis.update("member.update", dto);
		if(cnt>0)flag=true;
		return flag;
	}
	
	public boolean delete(String id){
		boolean flag = false;
		int cnt = mybatis.delete("member.delete", id);
		if(cnt>0)flag=true;
		return flag;
	}
	
	public boolean create(MemberDTO dto){
		boolean flag = false;
		int cnt = mybatis.insert("member.create", dto);
		if(cnt>0)flag=true;
		return flag;
	}
	
}
