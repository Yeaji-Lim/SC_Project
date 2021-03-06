package silver.web.member.control;

import java.util.HashMap;
import java.util.Map;

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
public class LoginControl {

	@Autowired
	LoginDAO dao;

	@Autowired
	HttpServletRequest request;

	@Autowired
	HttpSession session;

	public String makeString(
			String[] ar){
		StringBuffer buf = new StringBuffer();

		for(int i=0;i<ar.length; i++){
			// StringBuffer에 배열의 요소 중
			// 하나를 추가한다.
			buf.append(ar[i]);
		}
		return buf.toString();
	}


	@RequestMapping(value="login.sc", method=RequestMethod.POST)
	public ModelAndView login(LoginVO vo) throws Exception{
		request.setCharacterEncoding("utf-8");

		Map<String,String> m = new HashMap<>();

		m.put("tel", vo.getTel());
		m.put("pwd", vo.getPwd());

		vo = dao.login(m);

		ModelAndView mv = new ModelAndView();
		mv.addObject("vo", vo);

		if(vo != null){
			session.setAttribute("login_ok", vo);
			mv.setViewName("/index");
		}
		else
			mv.setViewName("/error");
		return mv;
	}

	
	@RequestMapping(value="login2.sc", method=RequestMethod.POST)
	public ModelAndView login_header(LoginVO vo) throws Exception{
		request.setCharacterEncoding("utf-8");

		Map<String,String> m = new HashMap<>();

		m.put("tel", vo.getTel());
		m.put("pwd", vo.getPwd());

		vo = dao.login(m);

		ModelAndView mv = new ModelAndView();
		mv.addObject("vo", vo);

		if(vo != null){
			session.setAttribute("login_ok", vo);
			mv.setViewName("/myPage/loginSuccess");
		}
		else
			mv.setViewName("/myPage/loginFail");
		return mv;
	}

	

}
