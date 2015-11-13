package silver.web.board.control;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import silver.web.board.dao.QNABoardDAO;
import silver.web.board.vo.QNABoardVO;

@Controller
public class QNADeleteControl {

	@Autowired
	QNABoardDAO qnadao;
	
	@Autowired
	HttpServletRequest request;

	String qb_num, nowPage;

	@RequestMapping("/qb_del.sc")
	public ModelAndView del(QNABoardVO vo) throws Exception {
		
		qb_num = request.getParameter("qb_num");
		nowPage = request.getParameter("nowPage");
		
		int n = qnadao.delQna(qb_num);
		String msg = "";
		
		if(n > 0){
			msg = "삭제 완료";
		}else{
			msg = "삭제 실패";
		}
		
		ModelAndView mv = new ModelAndView();
		mv.addObject("nowPage", nowPage);
		mv.addObject("msg", msg);
		mv.setViewName("/delete");
		
		return mv;
		
	}
	
}
