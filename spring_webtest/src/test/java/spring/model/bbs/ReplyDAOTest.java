package spring.model.bbs;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Ignore;
import org.junit.Test;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;

public class ReplyDAOTest {

	private static ReplyDAO dao;
	private static BeanFactory beans;
	
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		
		Resource resource = new ClassPathResource("daoTest.xml");
		
		beans = new XmlBeanFactory(resource);
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

	@Before
	public void setUp() throws Exception {
		dao = (ReplyDAO)beans.getBean("reply");
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testRcount() {
		int bbsno = 3;
		int cnt = dao.rcount(bbsno);
		assertEquals(cnt, 5);
	}

	@Test
	public void testTotal() {
		int bbsno = 3;
		int total = dao.total(bbsno);
		assertEquals(total, 5);
	}

	@Test
	public void testList() {
		Map map = new HashMap();
		map.put("bbsno", 3);
		map.put("sno", 1);
		map.put("eno", 5);
		
		List<ReplyDTO> list = dao.list(map);
		
		assertEquals(list.size(), 5);
	}

	@Test
	public void testBdelete() {
		int bbsno = 106;
		assertTrue(dao.bdelete(bbsno));
	}

	@Test
	public void testDelete() {
		int rnum = 17;
		assertTrue(dao.delete(rnum));
	}

	@Test
	public void testUpdate() {
		ReplyDTO dto = dao.read(5);
		dto.setContent("내용변경");
		assertTrue(dao.update(dto));
	}

	@Test
	public void testRead() {
		int rnum = 1;
		ReplyDTO dto = dao.read(rnum);
		assertNotNull(dto);
	}

	@Test
	@Ignore
	public void testCreate() {
		ReplyDTO dto = new ReplyDTO();
		dto.setContent("댓글내용입니다.");
		dto.setId("abc12");
		dto.setBbsno(104);
		assertTrue(dao.create(dto));
	}

}
