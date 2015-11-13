package silver.web.board.control;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import silver.web.board.dao.QNABoardDAO;
import silver.web.board.vo.QNABoardVO;

@Controller
public class QNAEditControl {

	@Autowired
	QNABoardDAO qnadao;
	
	@Autowired
	HttpServletRequest request;

	//view.jsp에서 [수정]버튼을 클릭했을 때, 현재 control이 수행될 때는 GET방식!
		@RequestMapping(value="qb_edit.sc", method=RequestMethod.GET)
		public ModelAndView edit(QNABoardVO vo) throws Exception{
			//edit라는 함수가 호출될때는 vo가 만들고 동일한 파라미터들이 vo객체로 자동으로 들어간다
			//이 vo는 파라미터를 받은 객체이다!! seq를 통해서 나머지의 값들을 가져와야 한다!!
			
			QNABoardVO qvo = qnadao.getQNABoard(String.valueOf(vo.getQb_num())); //seq검색을 통해 값들을 받아온다!!
			
			ModelAndView mv = new ModelAndView();
			mv.addObject("vo", qvo);
			mv.addObject("nowPage", vo.getNowPage());
			mv.setViewName("/board/qnAEdit");
			
			return mv;
			
			
		}

		//edit.jsp 폼화면에서 수정을 할때는 DB작업을 수행해야 한다! 이때 요청방식은 POST
		@RequestMapping(value="qb_edit.sc", method=RequestMethod.POST)
		public ModelAndView edit_ok(QNABoardVO vo) throws Exception{
			
			//DB에 저장
			qnadao.qb_edit(vo);
			
			ModelAndView mv = new ModelAndView();
			mv.setViewName("redirect:/qb_view.sc?qb_num="+vo.getQb_num()+"&nowPage="+vo.getNowPage());
			
			return mv;
			
		}
		
	
}
