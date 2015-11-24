package silver.web.message.control;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import silver.web.member.vo.LoginVO;
import silver.web.message.dao.MsgDAO;
import silver.web.message.vo.MsgVO;

@Controller
public class Msg_WriteControl {
/*
 * 앞서 생성된 빈객체들과 특정 빈 객체 내에
 * 있는 멤버변수와 이름이 같은 경우
 * 자동으로 참조하는 Autowire기능을
 * 어노테이션으로 지정이 가능하다.
 * 먼저
 * Controller-servlet.xml에서
 * <context:annotation-config />가
 * 설정되어 있어야 한다.
 */
	@Autowired
	MsgDAO mgdao;
	
	@Autowired
	HttpServletRequest request;
	
	@Autowired
	HttpSession session;


	@RequestMapping(value="/msg_write.sc", method=RequestMethod.POST)
	public ModelAndView write(MsgVO vo)throws Exception{
		//현재 영역은 POST방식으로 write.inc로
		//요청될 때 수행되는 영역이다.
		//인자인 BbsVO가 자동으로 생성되어
		//파라미터들일 BbsVO에 있는 변수 명들과
		//동일한 곳에 찾아 저장된다.
			//DB저장!
		String send_tel = request.getParameter("send_tel");
		LoginVO login = (LoginVO)session.getAttribute("login_ok");
		vo.setSend_tel(login.getTel());
		
		vo.setRequest_tel(send_tel);
		
		mgdao.writeBbs(vo);
		//반환객체 생성
		ModelAndView mv = new ModelAndView();
		
		//Redirect로 list.inc를 호출
		mv.setViewName("/msg/msg_close");
		
		return mv;
	}
}