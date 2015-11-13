package silver.web.board.control;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import silver.web.board.dao.QNABoardDAO;
import silver.web.board.vo.QNABoardVO;

@Controller
public class QNAViewControl{

	@Autowired
	QNABoardDAO qnadao;
	
	@Autowired
	HttpServletRequest request;
	
	@Autowired
	HttpSession session;
	
	QNABoardVO vo;
	
	String qb_num, nowPage;

	@RequestMapping("/qb_view.sc")
	public ModelAndView view(QNABoardVO vo) throws Exception {
		
		qb_num = request.getParameter("qb_num");
		nowPage = request.getParameter("nowPage");
		
		vo = qnadao.getQNABoard(qb_num);
		
		//LoginVO login = (LoginVO)session.getAttribute("login_ok");
		
		List<QNABoardVO> list = null;
		
		Object obj = session.getAttribute("view_list");
		if(obj == null){
			list = new ArrayList<QNABoardVO>();
			list.add(vo);
			
			qnadao.updateRead(qb_num);
			session.setAttribute("view_list", list);
		}else{
			list = (List<QNABoardVO>)obj;
			boolean check = true;
			for(QNABoardVO qvo : list){
				if(qb_num.equals(String.valueOf(qvo.getQb_num()))){
					check = false;
					break;
				}
			}//for
			if(check){
				qnadao.updateRead(qb_num);
				list.add(vo);
			}
			
		}
		
		ModelAndView mv = new ModelAndView();
		mv.addObject("vo", vo);
		mv.addObject("qb_num", qb_num);
		mv.addObject("nowPage", nowPage);
		
		session.setAttribute("vo", vo);
		
		mv.setViewName("/board/qnAView");
		
		return mv;
	}

}
