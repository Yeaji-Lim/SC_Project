package silver.web.message.control;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import silver.web.message.dao.MsgDAO;
import silver.web.message.vo.MsgVO;

@Controller
public class Msg_ReplyControl {

	@Autowired
	MsgDAO mgdao;
	
	@Autowired
	HttpServletRequest request;
	
	@Autowired
	HttpSession session;
	
	@RequestMapping(value="msg_reply.sc", method=RequestMethod.GET)
	public ModelAndView writeReplyForm(MsgVO vo)throws Exception{
		//String request_tel = request.getParameter("request_tel");
		ModelAndView mv = new ModelAndView();
		mv.addObject("request_tel", vo.getRequest_tel());
		mv.setViewName("msg/msg_reply");
		return mv;
	}
	
	
	@RequestMapping(value="msg_reply.sc", method=RequestMethod.POST)
	public ModelAndView writeReply(MsgVO vo)throws Exception{
		
		vo.setRequest_tel(vo.getRequest_tel().trim());
		
		
		
		mgdao.writeBbs(vo);
		//반환객체 생성
		ModelAndView mv = new ModelAndView();
		
		//Redirect로 list.inc를 호출
		mv.setViewName("/msg/replySuccess");
		
		return mv;
	}
		
}
