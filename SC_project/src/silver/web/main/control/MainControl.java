package silver.web.main.control;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import silver.include.Paging;
import silver.web.board.dao.FreeBoardDAO;
import silver.web.board.dao.NoticeBoardDAO;
import silver.web.board.vo.FreeBoardVO;
import silver.web.matching.dao.MatchingDAO;

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
		
		//rowTotal =ntdao.getTotalCount();
		rowTotal = frdao.getTotalCount();
		//페이징 코드를 만들어내는 객체 생성
		Paging page = new Paging(nowPage, rowTotal, BLOCK_LIST, BLOCK_PAGE);
		
		int begin = page.getBegin();
		int end = page.getEnd();
		if(end>rowTotal)
			end= rowTotal;
		
		//dao를 통해 표현할 목록을 가져오기 위해 map구조를 생성
		Map<String, String> map = 
				new HashMap<>();
		map.put("begin", String.valueOf(begin));
		map.put("end", String.valueOf(end));

		//ntdao.getList(map);

		FreeBoardVO[] ar =  frdao.getList(map);
System.out.println(rowTotal +","+begin+","+end);

		//mbdao.getmbList(map);

		
		
		ModelAndView mv = new ModelAndView();
		mv.addObject("list", ar);
		
		mv.setViewName("main");
		
		return mv;
		

	}

}
