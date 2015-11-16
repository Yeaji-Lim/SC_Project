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
public class RegControl {
	
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
	
	@RequestMapping(value="reg.sc", method=RequestMethod.GET)
	public String regForm(){
		return "/myPage/regForm";
	}
	
	@RequestMapping(value="reg.sc", method=RequestMethod.POST)
	public ModelAndView reg(LoginVO vo) throws Exception{

		String[] s_phone = request.getParameterValues("tel");
		String s_tel = makeString(s_phone);

		vo.setTel(s_tel);

		boolean ch = dao.add(vo);

		ModelAndView mv = new ModelAndView();
		if(ch == true)
			mv.setViewName("/myPage/regSuccess");
		else
			mv.setViewName("/myPage/regFail");

		return mv;

	}
	

}
