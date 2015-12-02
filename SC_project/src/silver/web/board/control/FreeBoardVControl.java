package silver.web.board.control;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import silver.web.board.dao.FreeBoardDAO;
import silver.web.board.vo.FreeBoardVO;
import silver.web.board.vo.FreeRepyVO;


@Controller
public class FreeBoardVControl {
	
	@Autowired
	FreeBoardDAO frdao;

	@Autowired
	HttpServletRequest request;
	
	@Autowired
	HttpSession session;
	
	FreeBoardVO vo;
	
	String fb_num,nowPage;
		
	@RequestMapping("/freeview.sc")
	public ModelAndView view(FreeBoardVO vo)throws Exception{
		 fb_num = request.getParameter("fb_num");
		 nowPage = request.getParameter("nowPage");
		
		vo = frdao.getBoard(fb_num);
		frdao.updateHit(fb_num);
		
		List<FreeRepyVO> list1= vo.getF_list();
		
		//jsp에서 표현하기 위해
		//vo를 ModelAndView에 저장하여 보낸다.
		ModelAndView mv = new ModelAndView();
		mv.addObject("vo", vo);
		session.setAttribute("free", vo);
		mv.addObject("nowPage", nowPage);
		mv.addObject("fb_num", fb_num);
		mv.addObject("list1",list1);
		mv.setViewName("/board/freeview");
				
		return mv;
		
		
		
	}

}
