package spring.sts.webtest;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import spring.model.img.ImgDAO;
import spring.model.img.ImgDTO;
import spring.model.img.ImgService;
import spring.utility.webtest.Utility;

@Controller
public class ImgController {
	
	@Autowired
	private ImgDAO dao;
	
	@Autowired
	private ImgService mgr;
	
	@RequestMapping(value="/img/deleteProc", method=RequestMethod.POST)
	public String delete(int no, String passwd, Model model, HttpServletRequest request) {
		
		Map map = new HashMap();
		map.put("no", no);
		map.put("passwd", passwd);
		
		boolean rflag = dao.checkRefnum(no);
		boolean pflag = dao.passCheck(map);
		boolean flag = false;
		
		
		String upDir = request.getRealPath("/img/storage");
		String oldfile = request.getParameter("oldfile");
		
		if(pflag){
			flag = dao.delete(no);
			if(rflag)
			Utility.deleteFile(upDir, oldfile);		
		}
		
		model.addAttribute("flag", flag);
		model.addAttribute("pflag", pflag);
		
		
		return "/img/deleteProc";
	}
	
	@RequestMapping(value="/img/delete", method=RequestMethod.GET)
	public String delete(int no, Model model) {
		
		boolean flag = dao.checkRefnum(no);
		System.out.println(flag);
		
		model.addAttribute("flag", flag);

		
		return "/img/delete";
	}
	
	@RequestMapping(value="/img/reply", method=RequestMethod.POST)
	public String reply(ImgDTO dto, Model model, HttpServletRequest request) {
		
		String upDir = request.getRealPath("/img/storage");
		
		String fname = Utility.saveFileSpring(dto.getFnameMF(), upDir);

		dto.setFname(fname);
		
		boolean flag = mgr.reply(dto);
		if(flag) {
			model.addAttribute("nowPage", request.getParameter("nowPage"));
			model.addAttribute("col", request.getParameter("col"));
			model.addAttribute("word", request.getParameter("word"));
			return "redirect:/img/list";
		}else {
			return "/error/error";
		}
	}
	
	@RequestMapping(value="/img/reply", method=RequestMethod.GET)
	public String reply(int no, Model model) {
		
		ImgDTO dto = dao.replyRead(no);
		
		model.addAttribute("dto", dto);
		
		return "/img/reply";
	}
	
	@RequestMapping(value="/img/updaProc", method=RequestMethod.POST)
	public String upda(int no, String passwd, String oldfile, ImgDTO dto, 
			Model model, HttpServletRequest request) {
		
		String upDir = request.getRealPath("/img/storage");
		
		String fname = Utility.saveFileSpring(dto.getFnameMF(), upDir);
		int filesize = (int)dto.getFnameMF().getSize();
		
		Map map = new HashMap();
		map.put("no", no); 
		map.put("passwd",passwd );
	 				
		boolean flag = dao.passCheck(map);
		boolean flag2 = false;
		if(flag){
		 	
		 	if(filesize>0){
		 		if(oldfile!=null)Utility.deleteFile(upDir, oldfile);	
		 	}else{
		 		fname=oldfile;
		 	}
		 		dto.setFname(fname);	 		
		 		  
		 		flag2= dao.update(dto);	 	 	 
		}
		
		model.addAttribute("flag", flag);
		model.addAttribute("flag2", flag2);
		model.addAttribute("no", no);
		
		return "/img/updaProc";
	}
	
	@RequestMapping(value="/img/upda", method=RequestMethod.GET)
	public String upda(int no, Model model) {
		
		ImgDTO dto = dao.read(no);
		
		model.addAttribute("dto", dto);
		
		return "/img/upda";
	}
	
	@RequestMapping("/img/read")
	public String read(int no, ImgDTO dto, Model model) {
		
		dao.upViewcnt(no);
		
		dto = dao.read(no);

		String content = dto.getContent();	   
		content = content.replaceAll("\r\n", "<br>");
		
		List list = dao.readImg(no);
		
		int[] noArr = (int[])list.get(0);
		String[] fArr = (String[])list.get(1);
		
		model.addAttribute("dto", dto);
		model.addAttribute("list", list);
		model.addAttribute("noArr", noArr);
		model.addAttribute("fArr", fArr);
		
		return "/img/read";
	}
	
	@RequestMapping(value="/img/create", method=RequestMethod.POST)
	public String create(ImgDTO dto, HttpServletRequest request) {
		
		String upDir = request.getRealPath("/img/storage");
		
		String fname = Utility.saveFileSpring(dto.getFnameMF(), upDir);

		dto.setFname(fname);
		
		boolean flag = dao.create(dto);
		
		if(flag) {
			return "redirect:/img/list";
		}else {
		return "/error/error";
		}
	}
	
	@RequestMapping(value="/img/create", method=RequestMethod.GET)
	public String create() {
		
		return "/img/create";
	}
	
	@RequestMapping("/img/list")
	public String list(ImgDTO dto, HttpServletRequest request) {
		
		String col=Utility.checkNull(request.getParameter("col"));
		String word=Utility.checkNull(request.getParameter("word")); 
		
		if(col.equals("total")) word="";
		//paging관련
		int nowPage =1;
		int recordPerPage=5;
		if(request.getParameter("nowPage")!=null){
		nowPage = Integer.parseInt(request.getParameter("nowPage"));
		}
		
		//db에서 가져올 레코드의 순번
		int sno =((nowPage-1)*recordPerPage)+1;
		int eno =nowPage * recordPerPage;

		Map map = new HashMap();
		map.put("col", col);
		map.put("word", word);
		map.put("sno", sno);
		map.put("eno", eno);
		
		List<ImgDTO> list = dao.list(map);
		int totalRecord =dao.total(map);
		
		String paging = Utility.paging3(totalRecord, nowPage, recordPerPage, col, word);
		
		request.setAttribute("list", list);
		request.setAttribute("paging", paging);
		request.setAttribute("col", col);
		request.setAttribute("word", word);
		request.setAttribute("nowPage", nowPage);
		
		return "/img/list";
	}
}
