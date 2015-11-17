package silver.web.board.control;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import silver.web.board.dao.FreeBoardDAO;
import silver.web.board.vo.FreeBoardVO;



@Controller
public class FreeBoardWControl {
	@Autowired
	FreeBoardDAO frdao;

	@Autowired
	HttpSession session;	
	
	@RequestMapping(value="freewrite.sc", method=RequestMethod.POST)
	public ModelAndView write(FreeBoardVO vo)throws Exception{
		
		frdao.writeBbs(vo);
		
		//반환객체 생성
		ModelAndView mv = new ModelAndView();
		
		//Redirect로 list.inc를 호출
		mv.setViewName("redirect:/freelist.sc");
		
		return mv;
	}
}
