package silver.web.member.control;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import silver.web.member.dao.LoginDAO;
import silver.web.member.vo.LoginVO;

@Controller
public class MyPageEditControl {

	@Autowired
	LoginDAO dao;
	
	@Autowired
	HttpServletRequest request;
	
	@Autowired
	HttpSession session;
	
	@Autowired
	ServletContext sevletcontext;
	
	@RequestMapping(value="myedit.sc", method=RequestMethod.GET)
	public ModelAndView View(LoginVO vo)throws Exception{
		vo = (LoginVO)session.getAttribute("login_ok");
		String tel = vo.getTel();
		LoginVO dvo = dao.getUser(tel);
		ModelAndView mv = new ModelAndView();
		mv.addObject(dvo);
		mv.setViewName("/myPage/myedit");
		return mv;
	}
	
	@RequestMapping(value="myedit.sc", method=RequestMethod.POST)
	public ModelAndView Edit(LoginVO vo)throws Exception{
		LoginVO dvo = (LoginVO)session.getAttribute("login_ok");
		String tel = dvo.getTel();
		vo.setTel(tel);
		/*System.out.println(vo.getTel());
		System.out.println(vo.getAddr());
		System.out.println(vo.getNickname());
		System.out.println(vo.getPwd());*/
		dao.edit(vo);
		ModelAndView mv = new ModelAndView();
		mv.setViewName("/myPage/myPageMain");
		
		return mv;
	}
	
}
