package silver.web.board.control;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import silver.web.board.dao.BbsDAO;
import silver.web.board.vo.BbsVO;
import silver.web.board.vo.CommVO;


@Controller
public class InfoAddAnsControl {
	
	
	@Autowired
	BbsDAO infoDAO;
	
	@Autowired
	HttpServletRequest request;
	
	@Autowired
	HttpSession session;
	
	
	@RequestMapping(value="comment.sc", method=RequestMethod.POST)
	public ModelAndView answer(CommVO cvo){
		
		
		BbsVO vo = infoDAO.getBoard(String.valueOf(cvo.getSeq()));
		
		ModelAndView mv = new ModelAndView();
		
		cvo.setIp(request.getRemoteAddr());
		
		infoDAO.addAnswer(cvo);
		
		
		
		mv.addObject("seq", vo.getSeq());
		
			
		mv.setViewName("redirect:/view.sc?seq="+vo.getSeq()+"&nowPage="+cvo.getNowPage());
		
		return mv;
	}

}
