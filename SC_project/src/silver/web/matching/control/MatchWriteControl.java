package silver.web.matching.control;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import silver.web.matching.dao.MatchingDAO;
import silver.web.matching.vo.MatchingVO;
import silver.web.member.vo.LoginVO;

@Controller
public class MatchWriteControl {

	@Autowired
	MatchingDAO mbdao;
	
	@Autowired
	HttpSession session;
	
	@RequestMapping(value="/mb_write.sc", method=RequestMethod.POST)
	public ModelAndView write(MatchingVO vo) throws Exception{
		
		LoginVO login = (LoginVO)session.getAttribute("login_ok");
		
		String writer = login.getTel();
		vo.setMb_writer(writer);
		
		String loc = vo.getMb_city() + "/" + vo.getMb_state();
		vo.setMb_location(loc);
			
		mbdao.mbWrite(vo);
		
		ModelAndView mv = new ModelAndView();
		//Redirect로 list.inc를 불러줘야 한다!!
		mv.addObject("login", login);
		mv.setViewName("redirect:/mb_list.sc");
		
		return mv;
		
		
	}
}
