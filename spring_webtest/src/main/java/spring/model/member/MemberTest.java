package spring.model.member;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;

public class MemberTest {

	
	public static void main(String[] args) {
		Resource resource = new ClassPathResource("daoTest.xml");
		
		BeanFactory factory = new XmlBeanFactory(resource);
		
		MemberDAO dao = (MemberDAO)factory.getBean("member");
		
		
//		create(dao);
//		read(dao);
//		update(dao);
//		delete(dao);
//		list(dao);
//		total(dao); 
//		updateFile(dao);
//		updatePw(dao);
//		getGrade(dao);
//		getFname(dao);
//		getPwFind(dao);
		getIdFind(dao);
//		duplicateId(dao);
//		duplicateEmail(dao);
//		loginCheck(dao);
	}	
	

	




	private static void loginCheck(MemberDAO dao) {
		Map map = new HashMap();
		map.put("id", "abcd12");
		map.put("passwd", "123");
		
		if(dao.loginCheck(map)) {
			p("회원입니다.");
		}else {
			p("회원이 아니거나 아이디 패스워드 오류입니다.");
		}
		
	}







	private static void duplicateEmail(MemberDAO dao) {
		String email = "1123@naver.com";
		if(dao.duplicateEmail(email)) {
			p("중복");
		}else {
			p("중복아님");
		}
	}



	private static void duplicateId(MemberDAO dao) {
		String id = "asd12";
		if(dao.duplicateId(id)) {
			p("중복");
		}else {
			p("중복아님");
		}
		
	}


	private static void getIdFind(MemberDAO dao) {
		
		String email = "1123@naver.com";
		MemberDTO dto = dao.Idfind(email);
		
		p(dto.getMname()+"님의 id는" + dto.getId()+"입니다.");
		
		
	}



	private static void getPwFind(MemberDAO dao) {
		String id = "abcd12";
		MemberDTO dto = dao.Pwfind(id);
		
		p("pw:" + dto.getPasswd());
		
	}







	private static void getFname(MemberDAO dao) {
		p(dao.getFname("abcd12"));
		
	}







	private static void getGrade(MemberDAO dao) {
		p(dao.getGrade("abcd12"));
		
	}







	private static void updatePw(MemberDAO dao) {
		Map map = new HashMap();
		map.put("passwd", "123");
		map.put("id", "abcd12");
		
		if(dao.updatePw(map)) {
			p("성공");
		}else {
			p("실패");
		}
	}







	private static void updateFile(MemberDAO dao) {
		Map map = new HashMap();
		map.put("fname", "my.jpg");
		map.put("id", "abcd12");
		
		if(dao.updateFile(map)) {
			p("성공");
		}else {
			p("실패");
		}
	}







	private static void create(MemberDAO dao) {
		MemberDTO dto = new MemberDTO();
		
		dto.setId("abcd12");
		dto.setPasswd("1234");
		dto.setMname("김길동");
		dto.setTel("123-1234-4567");
		dto.setEmail("abcd12@naver.com");
		dto.setZipcode("12345");
		dto.setAddress1("서울시 양천구");
		dto.setAddress2("아파트");
		dto.setJob("학생");
		dto.setFname("등대.jpg");
		
		//dto.setFilesize();
		if (dao.create(dto)) {
			p("등록 성공"); 
		}
		else {
			p("등록 실패");
		}	
		
	}

	private static void read(MemberDAO dao) {
		String id = "abc12";
		
		MemberDTO dto = dao.read(id);
		
		p(dto);		
	}

	private static void update(MemberDAO dao) {
		MemberDTO dto = new MemberDTO();
		dto.setId("abcd12");
		dto.setTel("123-1234-4567");
		dto.setEmail("jkl@naver.com");
		dto.setZipcode("12111");
		dto.setAddress1("서울시 강서구");
		dto.setAddress2("아파트");
		dto.setJob("직장인");

		
		if (dao.update(dto)) {
			p("변경 성공");
		}
		else {
			p("변경 실패");
		}			
	}

	private static void delete(MemberDAO dao) {
		String id = "member1";
		
		if (dao.delete(id)) {
			p("삭제 성공");
		}
		else {
			p("삭제 실패");
		}		
	}

	private static void list(MemberDAO dao) {
		Map map = new HashMap();
		map.put("col", "mname");
		map.put("word", "");
		map.put("sno", 1);
		map.put("eno", 5);
		
		List<MemberDTO> list = dao.list(map);
		
		for (int i=0; i<list.size(); i++) {
			MemberDTO dto = list.get(i);
						
			p(dto);
		}		
	}
		
	private static void total(MemberDAO dao) {
		Map map = new HashMap();
		map.put("col", "title");
		map.put("word", "");
				
		System.out.println(dao.total(map));		
	}

	//	private static void upAnsnum(MemberDAO dao) {
//		Map map = new HashMap();
//		map.put("ref", 1);
//		map.put("ansnum", 0);
//		
//		dao.upAnsnum(map);		
//	}

	private static void p(MemberDTO dto) {
		p("아이디 : " + dto.getId());		
		p("이름 : " + dto.getMname());
		p("패스워드 : " + dto.getPasswd());
		p("전화번호 : " + dto.getTel());
		p("이메일 : " + dto.getEmail());
		p("우편번호 : " + dto.getZipcode());
		p("주소 : " + dto.getAddress1());
		p("상세주소 : " + dto.getAddress2());
		p("날짜 : " + dto.getMdate());
		p("사진 : " + dto.getFname());
		p("등급 : " + dto.getGrade());
	}

	private static void p(String string) {
		System.out.println(string);		
	}

}
