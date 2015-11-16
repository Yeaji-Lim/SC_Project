package silver.web.message.control;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;

import silver.web.message.dao.MsgDAO;
import silver.web.message.vo.MsgVO;

public class Msg_ViewControl implements Controller {

	MsgDAO dao; // 이름이 같은 경우 자동대입되도록 한다.
	// 검색된 게시물이 저장될 곳
	MsgVO vo;
	
	//파라미터 값
	String b_idx, nowPage;
	

	public void setDao(MsgDAO dao) {
		this.dao = dao;
	}


	@Override
	public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response) throws Exception {
		// 파라미터 값들 받기
		b_idx = request.getParameter("b_idx");
		nowPage = request.getParameter("nowPage");
		
		vo = dao.getBoard(b_idx);
		//jsp에서 표현가기 위해 vo를 ModelAndView에 저장하여 보낸다.
		ModelAndView mv = new ModelAndView();
		mv.addObject("vo", vo);
		mv.addObject("nowPage", nowPage);
		mv.addObject("b_idx", b_idx);
		mv.setViewName("/msg/msg_view");
		
		return mv;
	}

}
