package silver.web.matching.control;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import silver.web.matching.dao.MatchingDAO;
import silver.web.matching.vo.MatchingVO;

@Controller
public class MatchViewControl {

	@Autowired
	MatchingDAO mbdao;
	
	@Autowired
	HttpServletRequest request;
	
	@Autowired
	HttpSession session;
	
	MatchingVO vo;
	
	String mb_num, nowPage;
	
	@RequestMapping("/mb_view.sc")
	public ModelAndView view(MatchingVO vo) throws Exception {
		
		mb_num = request.getParameter("mb_num");
		nowPage = request.getParameter("nowPage");
		
		vo = mbdao.mbView(mb_num);
		
		ModelAndView mv = new ModelAndView();
		mv.addObject("vo", vo);
		mv.addObject("mb_num", mb_num);
		mv.addObject("nowPage", nowPage);
		
		session.setAttribute("vo", vo);
		
		mv.setViewName("/matching/mbView");
		
		return mv;
	}

	
}
