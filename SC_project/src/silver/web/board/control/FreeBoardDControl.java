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
public class FreeBoardDControl {

	@Autowired
	FreeBoardDAO frdao;
	@Autowired
	HttpServletRequest request;

	String nowPage,fb_num,fb_pwd;

	@RequestMapping(value="freedel.sc", method=RequestMethod.POST)
	public ModelAndView del(FreeBoardVO vo) throws Exception{
		nowPage=request.getParameter("nowPage");


		//frdao.del(vo.getFb_num(), vo.getFb_pwd());


		ModelAndView mv= new ModelAndView();
		mv.addObject("nowPage",nowPage );
		mv.setViewName("redirect:/board/freelist.sc");
		return mv;
	}

}
