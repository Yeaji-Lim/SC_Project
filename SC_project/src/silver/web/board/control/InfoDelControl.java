package silver.web.board.control;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import silver.web.board.dao.BbsDAO;
import silver.web.board.vo.BbsVO;



@Controller
public class InfoDelControl {
	
	@Autowired
	BbsDAO infoDAO;
	
	@RequestMapping("/del.sc")
	public ModelAndView bbsDel(BbsVO vo) throws Exception{
		
		ModelAndView mv = new ModelAndView();
		
		infoDAO.bbsDel(vo.getSeq());
		
		mv.setViewName("redirect:/info.sc");
		
		return mv;
		
	}

}
