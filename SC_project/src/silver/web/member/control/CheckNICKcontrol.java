package silver.web.member.control;

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
public class CheckNICKcontrol {
	
	@Autowired
	LoginDAO dao;
	
	@Autowired
	HttpSession session;
	
	@Autowired
	HttpServletRequest request;
	
	
	@RequestMapping(value="/checkNICK.sc", method=RequestMethod.POST)
	public ModelAndView checkNICK(LoginVO vo){
		ModelAndView mv = new ModelAndView();
		
		boolean check = dao.checkNICK(vo.getNickname());
		
		session.setAttribute("check", check);
		mv.setViewName("/checkNICK");
		
		return mv;
	}

}
