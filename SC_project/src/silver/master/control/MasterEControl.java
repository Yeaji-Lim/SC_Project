package silver.master.control;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import silver.master.dao.MasterDAO;
import silver.web.member.vo.LoginVO;

@Controller
public class MasterEControl {
	
	@Autowired
	MasterDAO masdao;
	@Autowired
	HttpServletRequest request;
	
	
	String nowPage,idx;

	@RequestMapping(value="masedit.sc",method=RequestMethod.GET)
	public ModelAndView edit(LoginVO vo)throws Exception{
		LoginVO bvo = masdao.getBoard(vo.getIdx());
		System.out.println(nowPage);
		nowPage= request.getParameter("nowPage");
		ModelAndView mv = new ModelAndView();
		mv.addObject("vo", bvo);
		mv.addObject("idx",bvo.getIdx());
		mv.addObject("nowPage",nowPage );
		
		mv.setViewName("/master/masedit");
		return mv;

	}
	@RequestMapping(value="masedit.sc",method=RequestMethod.POST)
	public ModelAndView execute(LoginVO vo)throws Exception{
		String nowPage=	request.getParameter("nowPage");

		//DB수정
		masdao.editBbs(vo);

		ModelAndView mv = new ModelAndView();
		mv.setViewName("redirect:/m_list.sc?idx="+
				vo.getIdx()+"&nowPage="+
				nowPage);

		return mv;
	}
}
