package silver.web.board.control;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import silver.web.board.dao.BbsDAO;
import silver.web.board.vo.BbsVO;


@Controller
public class InfoEditControl {
	
	
	@Autowired
	BbsDAO infoDAO;
	
	@Autowired
	ServletContext application;
	
	@Autowired
	HttpServletRequest request;
	
	String uploadPath;

	public void setUploadPath(String uploadPath) {
		this.uploadPath = uploadPath;
	}

	@RequestMapping(value="/edit.sc",method=RequestMethod.GET)
	public ModelAndView edit(BbsVO vo) throws Exception{
		
		BbsVO bvo = infoDAO.getBoard(vo.getSeq());
		
		ModelAndView mv = new ModelAndView();
		
		mv.addObject("nowPage", vo.getNowPage());
		mv.addObject("vo", bvo);
		mv.addObject("seq", vo.getSeq());
		mv.setViewName("/board/infoEdit");

		return mv;
		
	}
	

	@RequestMapping(value="/edit.sc",method=RequestMethod.POST)
	public ModelAndView edit2(BbsVO vo) throws Exception{
		
		infoDAO.editBbs(vo);
		
		ModelAndView mv = new ModelAndView();
		
		mv.setViewName
		("redirect:/view.sc?seq="+vo.getSeq()+"&nowPage="+vo.getNowPage());
		
		return mv;

	}
}
