package silver.web.main.control;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import silver.web.board.dao.FreeBoardDAO;
import silver.web.board.dao.NoticeBoardDAO;
import silver.web.board.vo.FreeBoardVO;
import silver.web.board.vo.NoticeBoardVO;
import silver.web.matching.dao.MatchingDAO;
import silver.web.matching.vo.MatchingVO;

@Controller
public class MainControl {

	@Autowired
	NoticeBoardDAO ntdao;

	@Autowired
	FreeBoardDAO frdao;

	@Autowired
	MatchingDAO mbdao;


	//페이징 기법에 필요한 변수들
	public static final int BLOCK_LIST=10;
	public static final int BLOCK_PAGE=5;

	int nowPage; //현재 페이지 값
	int rowTotal; //총 게시물의 수

	@RequestMapping("main.sc")
	public ModelAndView mainView() throws Exception{
		

		FreeBoardVO[] ar1 =  frdao.getMainList();
		MatchingVO[] ar2 = mbdao.getMainList();
		NoticeBoardVO[] ar3 = ntdao.getMainList();
		
		ModelAndView mv = new ModelAndView();
		mv.addObject("list1", ar1);
		mv.addObject("list2", ar2);
		mv.addObject("list3", ar3);
		
		mv.setViewName("/main");
		
		return mv;
		

	}

}
