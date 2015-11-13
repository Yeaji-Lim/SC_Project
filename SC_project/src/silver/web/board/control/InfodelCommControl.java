package silver.web.board.control;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import silver.web.board.dao.BbsDAO;
import silver.web.board.vo.CommVO;



@Controller
public class InfodelCommControl {
	
	@Autowired
	BbsDAO infoDAO;
	
	
	@RequestMapping("/delComm.sc")
	public ModelAndView delComm(CommVO cvo){
		
		
		ModelAndView mv = new ModelAndView();
		
		
		infoDAO.delComm(cvo.getC_idx());
		
		
		mv.setViewName("redirect:/view.sc?seq="+cvo.getSeq()+"&nowPage="+cvo.getNowPage());
		
		return mv;
	}
	
	

}
