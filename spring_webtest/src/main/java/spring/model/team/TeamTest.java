package spring.model.team;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;

public class TeamTest {

	
	public static void main(String[] args) {
		Resource resource = new ClassPathResource("daoTest.xml");
		
		BeanFactory factory = new XmlBeanFactory(resource);
		
		TeamDAO dao = (TeamDAO)factory.getBean("team");
		
		
//		create(dao);
//		read(dao);
//		update(dao);
//		delete(dao);
//		list(dao);
//		total(dao); 
//		upViewcnt(dao);
//		checkRefnum(dao);
//		upAnsnum(dao);
		reply(dao);
// 	upAnsnum(dao)과 replyCreate(dao)는 동시 실행
//		replyRead(dao);
//		checkPasswd(dao);		
//		replyRead(dao);
//		reply(dao);
	}	
	

	




	private static void create(TeamDAO dao) {
		TeamDTO dto = new TeamDTO();
		
		dto.setName("백길동");
		dto.setPhone("123-1234-1234");
		dto.setHobby("독서");
		dto.setSkills("Java");
		dto.setGender("남자");
		dto.setZipcode("12345");
		dto.setAddress("서울시 종로구 관철동");
		dto.setAddress2("젊음의 거리");
		
		if (dao.create(dto)) {
			p("등록 성공");
		}
		else {
			p("등록 실패");
		}	
		
	}

	private static void read(TeamDAO dao) {
		int no = 7;
		
		TeamDTO dto = dao.read(no);
		
		p(dto);		
	}

	private static void update(TeamDAO dao) {
		TeamDTO dto = new TeamDTO();
		dto.setName("백길동");
		dto.setPhone("123-1234-1234");
		dto.setHobby("독서");
		dto.setSkills("Java");
		dto.setGender("남자");
		dto.setZipcode("12345");
		dto.setAddress("서울시 종로구 관철동");
		dto.setAddress2("젊음의 거리");
		dto.setNo(2);
		
		if (dao.update(dto)) {
			p("변경 성공");
		}
		else {
			p("변경 실패");
		}			
	}

	private static void delete(TeamDAO dao) {
		int no = 3;
		
		if (dao.delete(no)) {
			p("삭제 성공");
		}
		else {
			p("삭제 실패");
		}		
	}

	private static void list(TeamDAO dao) {
		Map map = new HashMap();
		map.put("col", "");
		map.put("word", "");
		map.put("sno", 1);
		map.put("eno", 5);
		
		List<TeamDTO> list = dao.list(map);
		
		for (int i=0; i<list.size(); i++) {
			TeamDTO dto = list.get(i);
						
			p(dto);
		}		
	}
		
	private static void total(TeamDAO dao) {
		Map map = new HashMap();
		map.put("col", "name");
		map.put("word", "");
				
		System.out.println(dao.total(map));		
	}


	private static void checkRefnum(TeamDAO dao) {
		
		if (dao.checkRefnum(1)) {
			p("해당 글이 부모글입니다. 삭제 불가능합니다.");
		}
		else {
			p("해당 글의 부모글이 존재합니다. 삭제 가능합니다.");
		}			
	}

	private static void reply(TeamDAO dao) {
		TeamDTO dto = dao.replyRead(7);
		dto.setName("백길동");
		dto.setPhone("123-1234-1234");
		dto.setHobby("독서");
		dto.setSkills("Java");
		dto.setGender("남자");
		dto.setZipcode("12345");
		dto.setAddress("서울시 종로구 관철동");
		dto.setAddress2("젊음의 거리");
		
		Map map = new HashMap();
		map.put("grpno", dto.getGrpno());
		map.put("ansnum", dto.getAnsnum());
		
		dao.upAnsnum(map);
		if (dao.replyCreate(dto)) {
			p("답변 등록 성공");
		}
		else {
			p("답변 등록 실패");
		}		
	}

	//	private static void upAnsnum(TeamDAO dao) {
//		Map map = new HashMap();
//		map.put("ref", 1);
//		map.put("ansnum", 0);
//		
//		dao.upAnsnum(map);		
//	}

	private static void p(TeamDTO dto) {
		p("일련번호 : " + dto.getNo());		
		p("작성자 : " + dto.getName());
		p("성별 : " + dto.getGender());
		p("전화번호 : " + dto.getPhone());
		p("보유기술 : " + dto.getSkills());
		p("취미 : " + dto.getHobby());
		p("우편번호 : " + dto.getZipcode());
		p("주소 : " + dto.getAddress());
		p("상세주소 : " + dto.getAddress2());
	}


	private static void p(String string) {
		System.out.println(string);		
	}

}
