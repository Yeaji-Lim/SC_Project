package silver.web.board.control;

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
public class QNAWriteControl {

	@Autowired
	QNABoardDAO qnadao;
	
	@Autowired
	HttpSession session;
	
	@RequestMapping(value="qb_write.sc", method=RequestMethod.POST)
	public ModelAndView write(QNABoardVO vo) throws Exception{
		
		LoginVO login = (LoginVO)session.getAttribute("login_ok");
		
		String writer = login.getTel();
		vo.setQb_writer(writer);
		
		qnadao.qb_insert(vo);
		
		ModelAndView mv = new ModelAndView();
		//Redirect로 list.inc를 불러줘야 한다!!
		mv.addObject("login", login);
		mv.setViewName("redirect:/qb_list.sc");
		
		return mv;
		
		
	}
	
}
