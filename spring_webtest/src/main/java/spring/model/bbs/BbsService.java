package spring.model.bbs;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class BbsService {

	@Autowired
	private BbsDAO dao;
	
	@Autowired
	private ReplyDAO rdao;
	
	public void delete(int bbsno) throws Exception {
		//해당 메소드를 호출한 곳에서 exception처리를 하겠다는 뜻
		rdao.bdelete(bbsno);	//부모글의 댓글 모두 삭제
		dao.delete(bbsno);	//부모글 삭제
		
	}
	

	public void reply(BbsDTO dto) throws Exception {

			Map map = new HashMap();
			map.put("grpno", dto.getGrpno());
			map.put("ansnum", dto.getAnsnum());
			
			dao.upAnsnum(map);
			dao.replyCreate(dto);

	}

}
