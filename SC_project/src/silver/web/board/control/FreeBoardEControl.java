package silver.web.board.control;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import silver.web.board.dao.FreeBoardDAO;
import silver.web.board.vo.FreeBoardVO;


@Controller
public class FreeBoardEControl {

	@Autowired
	FreeBoardDAO frdao;

	@Autowired
	HttpServletRequest request;


	String nowPage,fb_num;

	@RequestMapping(value="freeedit.sc",method=RequestMethod.GET)
	public ModelAndView edit(FreeBoardVO vo)throws Exception{

		System.out.println(vo.getFb_num());
		FreeBoardVO bvo = frdao.getBoard(vo.getFb_num());
		nowPage= request.getParameter("nowPage");
		ModelAndView mv = new ModelAndView();
		mv.addObject("vo", bvo);
		mv.addObject("fb_num",bvo.getFb_num());
		mv.addObject("nowPage",nowPage );
		mv.setViewName("/board/freeedit");
		return mv;

	}
	@RequestMapping(value="freeedit.sc",method=RequestMethod.POST)
	public ModelAndView execute(FreeBoardVO vo)throws Exception{
		String nowPage=	request.getParameter("nowPage");

		//DB수정
		frdao.editBbs(vo);

		ModelAndView mv = new ModelAndView();
		mv.setViewName("redirect:/freeview.sc?fb_num="+
				vo.getFb_num()+"&nowPage="+
				nowPage);

		return mv;
	}



}
