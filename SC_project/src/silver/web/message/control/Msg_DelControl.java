package silver.web.message.control;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;

import silver.web.message.dao.MsgDAO;
import silver.web.message.vo.MsgVO;


public class Msg_DelControl implements Controller  {

	MsgDAO dao;
	MsgVO vo;
	
	String b_idx,tel;
	


	public void setDao(MsgDAO dao) {
		this.dao = dao;
	}



	@Override
	public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response) throws Exception {
		b_idx=request.getParameter("b_idx");
		//System.out.println(b_idx);
		//tel = request.getParameter("tel");
		vo = new MsgVO();
		vo.setB_idx(b_idx);
		//vo.setSendtel(tel);
		ModelAndView mv = new ModelAndView();
		dao.delBbs(vo);
		mv.setViewName("redirect:/msglist.sc");
		
		return mv;
	}
}
