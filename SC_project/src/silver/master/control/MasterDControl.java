package silver.master.control;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import silver.master.dao.MasterDAO;
import silver.web.member.vo.LoginVO;

@Controller
public class MasterDControl {
	
	@Autowired
	HttpServletRequest request;
	@Autowired
	MasterDAO masdao;
	
	
	String nowPage;
	
	@RequestMapping(value="/masdel.sc")
	public ModelAndView del(LoginVO vo) throws Exception{
		
		nowPage=request.getParameter("nowPage");
		ModelAndView mv= new ModelAndView();
		mv.addObject("nowPage", nowPage);
		masdao.del(vo.getIdx());
		mv.setViewName("redirect:/m_list.sc?idx="+
				vo.getIdx()+"&nowPage="+
				nowPage);
		
		return mv;
		
	}
	

}
