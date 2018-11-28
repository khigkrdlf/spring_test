package spring.model.memo;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;

public class MemoTest {

	
	public static void main(String[] args) {
		Resource resource = new ClassPathResource("daoTest.xml");
		
		BeanFactory factory = new XmlBeanFactory(resource);
		
		MemoDAO dao = (MemoDAO)factory.getBean("memo");
		
		
//		create(dao);
//		read(dao);
//		update(dao);
		delete(dao);
//		list(dao);
//		total(dao); 
//		upViewcnt(dao);
//		checkRefnum(dao);
//		upAnsnum(dao);
//		reply(dao);
// 	upAnsnum(dao)과 replyCreate(dao)는 동시 실행
//		replyRead(dao);
//		checkPasswd(dao);		
//		replyRead(dao);
//		reply(dao);
	}	
	

	




	private static void create(MemoDAO dao) {
		MemoDTO dto = new MemoDTO();
		
		dto.setTitle("제목1");
		dto.setContent("내용1");
		//dto.setFilesize();
		
		if (dao.create(dto)) {
			p("등록 성공");
		}
		else {
			p("등록 실패");
		}	
		
	}

	private static void read(MemoDAO dao) {
		int bbsno = 2;
		
		MemoDTO dto = dao.read(bbsno);
		
		p(dto);		
	}

	private static void update(MemoDAO dao) {
		MemoDTO dto = new MemoDTO();
		dto.setTitle("제목변경");
		dto.setContent("내용변경");
		dto.setMemono(2);
		
		if (dao.update(dto)) {
			p("변경 성공");
		}
		else {
			p("변경 실패");
		}			
	}

	private static void delete(MemoDAO dao) {
		int memono = 3;
		
		if (dao.delete(memono)) {
			p("삭제 성공");
		}
		else {
			p("삭제 실패");
		}		
	}

	private static void list(MemoDAO dao) {
		Map map = new HashMap();
		map.put("col", "");
		map.put("word", "");
		map.put("sno", 1);
		map.put("eno", 5);
		
		List<MemoDTO> list = dao.list(map);
		
		for (int i=0; i<list.size(); i++) {
			MemoDTO dto = list.get(i);
						
			p(dto);
		}		
	}
		
	private static void total(MemoDAO dao) {
		Map map = new HashMap();
		map.put("col", "title");
		map.put("word", "");
				
		System.out.println(dao.total(map));		
	}

	private static void upViewcnt(MemoDAO dao) {
		int memono = 1;
		dao.updateviewcnt(memono);		
	}

	private static void checkRefnum(MemoDAO dao) {
		
		if (dao.checkRefnum(1)) {
			p("해당 글이 부모글입니다. 삭제 불가능합니다.");
		}
		else {
			p("해당 글의 부모글이 존재합니다. 삭제 가능합니다.");
		}			
	}

	private static void reply(MemoDAO dao) {
		MemoDTO dto = dao.replyRead(4);
		dto.setContent("답변내용");
		
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

	//	private static void upAnsnum(MemoDAO dao) {
//		Map map = new HashMap();
//		map.put("ref", 1);
//		map.put("ansnum", 0);
//		
//		dao.upAnsnum(map);		
//	}

	private static void p(MemoDTO dto) {
		p("일련번호 : " + dto.getMemono());		
		p("제목 : " + dto.getTitle());
		p("작성일 : " + dto.getWdate());
		p("조회수 : " + dto.getViewcnt());
		p("글번호 : " + dto.getIndent());
		p("내용 : " + dto.getContent());
	}

	private static void p(String string) {
		System.out.println(string);		
	}

}
