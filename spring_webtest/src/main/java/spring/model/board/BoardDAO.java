package spring.model.board;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.List;
import java.util.Map;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import spring.db.webtest.DBClose;
import spring.db.webtest.DBOpen;


@Repository
public class BoardDAO {
	
	@Autowired
	private SqlSessionTemplate mybatis;
	
	
	
	
	
	public SqlSessionTemplate getMybatis() {
		return mybatis;
	}

	public void setMybatis(SqlSessionTemplate mybatis) {
		this.mybatis = mybatis;
	}

	public boolean create(BoardDTO dto) {
		boolean flag = false;
		int cnt = mybatis.insert("board.create", dto);
		if(cnt>0)flag=true;
		return flag;
	}

	public BoardDTO read(int num) {
		
		return mybatis.selectOne("board.read", num);
		
	}

	public boolean update(BoardDTO dto) {
		boolean flag = false;

		int cnt = mybatis.update("board.update", dto);
		if(cnt>0)flag=true;
		return flag;
	}

	public boolean delete(int num) {
		boolean flag = false;
		
		int cnt = mybatis.delete("board.delete", num);
		if(cnt>0)flag=true;
		
		return flag;
	}

	public List<BoardDTO> list(Map map) {
		
		return mybatis.selectList("board.list", map);
		
	}

	public int total(Map map) {
		

		return mybatis.selectOne("board.total", map);
	}

	public void upCount(int num) {
		mybatis.update("board.upCount", num);
	}

	// 부모의 refnum은 0. 답변글의 refnum은 부모글의 num을 따라감
	// refnum이 0보다 크면 부모글이 아니라는 얘기. ->> true면 삭제 가능
	public boolean checkRefnum(int num) {
		boolean flag = false;

		int cnt = mybatis.selectOne("board.checkRefnum", num);
		if(cnt>0)flag=true;

		return flag;
	}

	public boolean insertReply(BoardDTO dto) {
		boolean flag = false;
		int cnt = mybatis.insert("board.insertReply", dto);
		if(cnt>0)flag=true;
		return flag;
	}

	// 부모의 num을 가지고 읽어들이고, 제목은 수정할 수 없음
	// num은 replyCreate의 refnum을 부모의 num으로 입력해주기 위해 읽어들이고,
	// ref는 부모글과 같게 하기위해,
	// indent와 ansnum은 부모글보다 1씩 크게 하기 위해 읽어온다
	public BoardDTO replyRead(int num) {
		BoardDTO dto = null;

		Connection con = DBOpen.open();
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		StringBuffer sql = new StringBuffer();
		sql.append(" select num, subject, ref, indent, ansnum ");
		sql.append(" from board ");
		sql.append(" where num = ? ");

		try {
			pstmt = con.prepareStatement(sql.toString());
			pstmt.setInt(1, num);

			rs = pstmt.executeQuery();

			if (rs.next()) {
				dto = new BoardDTO();
				dto.setNum(rs.getInt("num"));
				dto.setSubject(rs.getString("subject"));
				dto.setRef(rs.getInt("ref"));
				dto.setIndent(rs.getInt("indent"));
				dto.setAnsnum(rs.getInt("ansnum"));
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBClose.close(rs, pstmt, con);
		}

		return dto;
	}

	// 부모글의 ref와 일치하는 것들 중 (=답변글들 중)
	// ansnum이 부모글보다 큰 글이 있으면 1을 더함
	// 왜냐면, 이렇게 해야 이전에 써졌던 답변글의 ansnum이 1 증가
	public void upAnsnum(Map map){
		mybatis.update("board.upAnsnum", map);
	}

	public boolean checkPasswd(Map map) {
		boolean flag = false;
		int cnt = mybatis.selectOne("board.passwdCheck", map);
		if(cnt>0)flag=true;
		return flag;
	}

	public BoardDTO readReply(int num) {
		return mybatis.selectOne("board.readReply", num);

	}

}