package silver.web.board.control;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;

import silver.web.board.dao.NoticeBoardDAO;
import silver.web.board.vo.NoticeBoardVO;

public class Notice_DelControl implements Controller  {

	NoticeBoardDAO dao;
	NoticeBoardVO vo;
	
	String b_idx,nickname;
		
	public void setDao(NoticeBoardDAO dao) {
		this.dao = dao;
	}

	@Override
	public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response) throws Exception {
		b_idx=request.getParameter("b_idx");
		nickname=request.getParameter("nickname");
		vo = new NoticeBoardVO();
		vo.setB_idx(b_idx);
		vo.setNickname(nickname);
		ModelAndView mv = new ModelAndView();
		dao.delBbs(vo);
		mv.setViewName("redirect:/notice.sc");
		
		return mv;
	}
}
