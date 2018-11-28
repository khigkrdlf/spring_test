package spring.model.bbs;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;



public class ReplyTest {

	
	public static void main(String[] args) {
		Resource resource = new ClassPathResource("daoTest.xml");
		
		BeanFactory factory = new XmlBeanFactory(resource);
		
		ReplyDAO dao = (ReplyDAO)factory.getBean("reply");
		
		
//		create(dao);
//		read(dao);
//		update(dao);
//		delete(dao);
//		bdelete(dao);
//		list(dao);
//		total(dao); 
	}	
	





	private static void bdelete(ReplyDAO dao) {
		int bbsno = 3;
		
		if (dao.bdelete(bbsno)) {
			p("삭제 성공");
		}
		else {
			p("삭제 실패");
		}
		
	}



	private static void create(ReplyDAO dao) {
		ReplyDTO dto = new ReplyDTO();
		dto.setContent("댓글내용입니다.");
		dto.setId("abc12");
		dto.setBbsno(3);
		
		if (dao.create(dto)) {
			p("등록 성공");
		}
		else {
			p("등록 실패");
		}	
		
	}

	private static void read(ReplyDAO dao) {
		int rnum = 1;
		
		ReplyDTO dto = dao.read(rnum);
		
		p(dto);		
	}

	private static void update(ReplyDAO dao) {
		ReplyDTO dto = new ReplyDTO();
		dto.setContent("댓글내용변경");
		dto.setRnum(1);
		
		if (dao.update(dto)) {
			p("변경 성공");
		}
		else {
			p("변경 실패");
		}			
	}

	private static void delete(ReplyDAO dao) {
		int rnum = 3;
		
		if (dao.delete(rnum)) {
			p("삭제 성공");
		}
		else {
			p("삭제 실패");
		}		
	}

	private static void list(ReplyDAO dao) {
		Map map = new HashMap();
		map.put("bbsno", 3);
		map.put("sno", 1);
		map.put("eno", 5);
		
		List<ReplyDTO> list = dao.list(map);
		
		for (int i=0; i<list.size(); i++) {
			ReplyDTO dto = list.get(i);
						
			p(dto);
			p("-----------------------------");
		}		
	}
		
	private static void total(ReplyDAO dao) {
		int bbsno = 3;
				
		System.out.println(dao.total(bbsno));		
	}

	

	

//	private static void upAnsnum(ReplyDAO dao) {
//		Map map = new HashMap();
//		map.put("ref", 1);
//		map.put("ansnum", 0);
//		
//		dao.upAnsnum(map);		
//	}

	private static void p(ReplyDTO dto) {
		p("일련번호 : " + dto.getRnum());		
		p("내용 : " + dto.getContent());
		p("날짜 : " + dto.getRegdate());
		p("아이디 : " + dto.getId());
		p("부모글번호 : " + dto.getBbsno());
	}

	private static void p(String string) {
		System.out.println(string);		
	}

}
