package silver.web.member.control;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;


import silver.web.member.dao.LoginDAO;
import silver.web.member.vo.LoginVO;
@Controller
public class DelUserControl{

	LoginVO vo;
	@Autowired
	LoginDAO dao;
	
	@Autowired
	HttpSession session;	
	
	String tel;
	public void setDao(LoginDAO dao) {
		this.dao = dao;
	}
	
	@RequestMapping(value="/mydel.sc")
	public ModelAndView del(LoginVO vo)throws Exception{
		
		LoginVO dvo = (LoginVO)session.getAttribute("login_ok");
		tel = dvo.getTel();
		vo.setTel(tel);
		//System.out.println(vo.getTel());
		dao.delBbs(vo);
		ModelAndView mv = new ModelAndView();
		session.removeAttribute("login_ok");
		mv.setViewName("redirect:/main.sc");
		return mv;
	}
}
