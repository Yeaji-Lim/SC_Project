package silver.web.board.control;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import silver.web.board.dao.QNABoardDAO;
import silver.web.board.vo.QNABoardVO;
import silver.web.member.vo.LoginVO;

@Controller
public class QNAAnswerControl {

	@Autowired
	QNABoardDAO qnadao;
	
	@Autowired
	HttpSession session;
	
	@RequestMapping(value="qb_answer.sc", method=RequestMethod.GET)
	public ModelAndView answrite(QNABoardVO vo) throws Exception{
		
		//seq, groups, step, lev, nowPage
		ModelAndView mv = new ModelAndView();
		mv.addObject("vo", vo); //파라미터들이 들어갔다!!!
		mv.setViewName("/board/qnAanswerForm");
		
		return mv;
	}
	
	@RequestMapping(value="qb_answer.sc", method=RequestMethod.POST)
	public ModelAndView answer(QNABoardVO vo) throws Exception{
	
		//현재 참조글의 groups값과 같고 lev의 값이 참조값의 lev보다 큰 게시물의 lev를 1씩 증가
		Map<String, String> map = new HashMap<String, String>();
		map.put("qb_groups", String.valueOf(vo.getQb_groups()));
		map.put("qb_lev", String.valueOf(vo.getQb_lev()));
		//lev값 조정!!
		qnadao.updateLev(map);

		//답변 저장
		//답변의 groups는 참조글의 groups와 같다!
		//step은 참조글 step+1, lev는 참조글 lev+1이다!!
		int lev = vo.getQb_lev() + 1;
		int step = vo.getQb_step() + 1;
		
		//1씩 증가된 값들을 vo에 다시 저장!
		vo.setQb_lev(lev);
		vo.setQb_step(step);
		
		LoginVO login = (LoginVO)session.getAttribute("login_ok");
		
		String writer = login.getTel();
		vo.setQb_writer(writer);
		
		//DB에 저장
		qnadao.addQBans(vo);
		
		ModelAndView mv = new ModelAndView();
		mv.addObject("login", login);
		//Redirect로 list.inc를 불러줘야 한다!!
		mv.setViewName("redirect:/qb_list.sc?nowPage="+vo.getNowPage());
		
		return mv;
	}
	
}
