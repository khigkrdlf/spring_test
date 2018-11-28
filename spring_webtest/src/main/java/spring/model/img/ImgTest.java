package spring.model.img;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;

public class ImgTest {

	
	public static void main(String[] args) {
		Resource resource = new ClassPathResource("daoTest.xml");
		
		BeanFactory factory = new XmlBeanFactory(resource);
		
		BbsDAO dao = (BbsDAO)factory.getBean("dao");
		
		
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
	





	private static void create(BbsDAO dao) {
		BbsDTO dto = new BbsDTO();
		dto.setWname("가길동");
		dto.setTitle("제목1");
		dto.setContent("내용1");
		dto.setPasswd("123");
		dto.setFilename("");
		//dto.setFilesize();
		
		if (dao.create(dto)) {
			p("등록 성공");
		}
		else {
			p("등록 실패");
		}	
		
	}

	private static void read(BbsDAO dao) {
		int bbsno = 2;
		
		BbsDTO dto = dao.read(bbsno);
		
		p(dto);		
	}

	private static void update(BbsDAO dao) {
		BbsDTO dto = new BbsDTO();
		dto.setWname("변경");
		dto.setTitle("제목변경");
		dto.setContent("내용변경");
		dto.setFilename("파일이름변경");
		dto.setFilesize(999);
		dto.setBbsno(3);
		
		if (dao.update(dto)) {
			p("변경 성공");
		}
		else {
			p("변경 실패");
		}			
	}

	private static void delete(BbsDAO dao) {
		int bbsno = 11;
		
		if (dao.delete(bbsno)) {
			p("삭제 성공");
		}
		else {
			p("삭제 실패");
		}		
	}

	private static void list(BbsDAO dao) {
		Map map = new HashMap();
		map.put("col", "name");
		map.put("word", "");
		map.put("sno", 1);
		map.put("eno", 5);
		
		List<BbsDTO> list = dao.list(map);
		
		for (int i=0; i<list.size(); i++) {
			BbsDTO dto = list.get(i);
						
			p(dto);
		}		
	}
		
	private static void total(BbsDAO dao) {
		Map map = new HashMap();
		map.put("col", "wname");
		map.put("word", "");
				
		System.out.println(dao.total(map));		
	}

	private static void upViewcnt(BbsDAO dao) {
		int bbsno = 1;
		dao.upViewcnt(bbsno);		
	}

	private static void checkRefnum(BbsDAO dao) {
		
		if (dao.checkRefnum(11)) {
			p("해당 글이 부모글입니다. 삭제 불가능합니다.");
		}
		else {
			p("해당 글의 부모글이 존재합니다. 삭제 가능합니다.");
		}			
	}

	private static void reply(BbsDAO dao) {
		BbsDTO dto = dao.replyRead(9);
		dto.setWname("답변");
		dto.setContent("답변내용");
		dto.setPasswd("123");
		dto.setFilename("답변파일이름");
		dto.setFilesize(10);
		
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

	private static void replyRead(BbsDAO dao) {
		int num = 4;
		BbsDTO dto = dao.replyRead(num);
		p("번호:" +dto.getNum());
		p("ref:" +dto.getRef());
		p("indent:" +dto.getIndent());
		p("ansnum:" +dto.getAnsnum());
		p("제목:" +dto.getSubject());
		
	}

//	private static void upAnsnum(BbsDAO dao) {
//		Map map = new HashMap();
//		map.put("ref", 1);
//		map.put("ansnum", 0);
//		
//		dao.upAnsnum(map);		
//	}

	private static void checkPasswd(BbsDAO dao) {
		Map map = new HashMap();
		map.put("bbsno", 1);
		map.put("passwd", "123");
		
		if (dao.passCheck(map)) {
			p("비밀번호가 일치합니다.");
		}
		else {
			p("비밀번호 일치 안 함");
		}		
	}

	private static void p(BbsDTO dto) {
		p("일련번호 : " + dto.getBbsno());		
		p("작성자 : " + dto.getWname());
		p("제목 : " + dto.getTitle());
		p("작성일 : " + dto.getWdate());
		p("조회수 : " + dto.getViewcnt());
		p("글번호 : " + dto.getIndent());
		p("내용 : " + dto.getContent());
		p("파일이름 : " + dto.getFilename());
		p("파일크기 : " + dto.getFilesize());
	}

	private static void p(String string) {
		System.out.println(string);		
	}

}
