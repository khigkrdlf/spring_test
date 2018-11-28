package spring.model.img;

import java.math.BigDecimal;
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
public class ImgDAO {
	@Autowired
	private SqlSessionTemplate mybatis;
	
	public void setMybatis(SqlSessionTemplate mybatis) {
		this.mybatis = mybatis;
	}

	public boolean checkRefnum(int no){
		boolean flag = false;
		int cnt = mybatis.selectOne("img.checkRefnum", no);
		if(cnt>0)flag=true;
		return flag;
	}
	
	public ImgDTO replyRead(int no){
		
		return mybatis.selectOne("img.replyRead", no);
	}
	
	public boolean replyCreate(ImgDTO dto){
		boolean flag = false;
		
		System.out.println(dto.getFname());
		int cnt = mybatis.insert("img.replyCreate", dto);
		if(cnt>0)flag=true;
		return flag;
	}
	
	public void upAnsnum(Map map){
		mybatis.update("img.upAnsnum", map);
	}
	
	public void upViewcnt(int no){
		mybatis.update("img.upViewcnt", no);
	}
	

	
	public boolean passCheck(Map map){

		boolean flag = false;
		int cnt = mybatis.selectOne("img.passCheck", map);
		if(cnt>0)flag=true;
		return flag;

	}
	
	public int total(Map map){
		
		return mybatis.selectOne("img.total", map);
	}

public List<ImgDTO> list(Map map){
		
		return mybatis.selectList("img.list", map);
	}
	
public boolean delete(int no){

	boolean flag = false;
	int cnt = mybatis.delete("img.delete", no);
	if(cnt>0)flag=true;
	return flag;

}
	
//update
public boolean update(ImgDTO dto){
	boolean flag = false;
	int cnt = mybatis.update("img.update", dto);
	if(cnt>0)flag=true;
	return flag;
}
	
	public ImgDTO read(int no){
		
		return mybatis.selectOne("img.read", no);
	}
	
	public List readImg(int no) {
		List list = new ArrayList();
		Map map = mybatis.selectOne("img.imgread",no);

		int[] ino = {
		((BigDecimal)map.get("PRE_NO2")).intValue(),
		((BigDecimal)map.get("PRE_NO1")).intValue(),
		((BigDecimal)map.get("NO")).intValue(),
		((BigDecimal)map.get("NEX_NO1")).intValue(),
		((BigDecimal)map.get("NEX_NO2")).intValue(),
		};

		String[] lFname = { 
		(String)map.get("PRE_FNAME2"),
		(String)map.get("PRE_FNAME1"),
		(String)map.get("FNAME"),
		(String)map.get("NEX_FNAME1"),
		(String)map.get("NEX_FNAME2"),
		};

		list.add(ino);
		list.add(lFname);

		return list;
		}
	
	public boolean create(ImgDTO dto){
		boolean flag = false;
		int cnt = mybatis.insert("img.create", dto);
		if(cnt>0)flag=true;
		return flag;
	}
	}
