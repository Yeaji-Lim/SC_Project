package silver.web.matching.control;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import silver.web.matching.dao.MatchingDAO;
import silver.web.matching.vo.MatchingVO;

@Controller
public class MatchEditControl {

	@Autowired
	MatchingDAO mbdao;
	
	@Autowired
	HttpServletRequest request;
	
	String nowPage = "";

	//view.jsp에서 [수정]버튼을 클릭했을 때, 현재 control이 수행될 때는 GET방식!
		@RequestMapping(value="mb_edit.sc", method=RequestMethod.GET)
		public ModelAndView edit(MatchingVO vo) throws Exception{
			//edit라는 함수가 호출될때는 vo가 만들고 동일한 파라미터들이 vo객체로 자동으로 들어간다
			//이 vo는 파라미터를 받은 객체이다!! seq를 통해서 나머지의 값들을 가져와야 한다!!
			
			nowPage = request.getParameter("nowPage");
			
			MatchingVO mvo = mbdao.mbView(vo.getMb_num()); //seq검색을 통해 값들을 받아온다!!
			
			ModelAndView mv = new ModelAndView();
			mv.addObject("vo", mvo);
			mv.addObject("nowPage", nowPage);
			mv.setViewName("/matching/mbEdit");
			
			return mv;
			
			
		}

		//edit.jsp 폼화면에서 수정을 할때는 DB작업을 수행해야 한다! 이때 요청방식은 POST
		@RequestMapping(value="mb_edit.sc", method=RequestMethod.POST)
		public ModelAndView edit_ok(MatchingVO vo) throws Exception{
			
			//DB에 저장
			mbdao.mbEdit(vo);
			
			ModelAndView mv = new ModelAndView();
			mv.setViewName("redirect:/mb_view.sc?mb_num="+vo.getMb_num()+"&nowPage="+nowPage);
			
			return mv;
			
		}
		
	
}
