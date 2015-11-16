package silver.web.matching.control;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import silver.include.Paging;
import silver.web.matching.dao.MatchingDAO;
import silver.web.matching.vo.MatchingVO;

@Controller
public class MatchListControl {

	@Autowired
	MatchingDAO mbdao;
	
	@Autowired
	HttpServletRequest request;
	
	public static final int BLOCK_LIST = 10;
	public static final int BLOCK_PAGE = 5;
	int nowPage; //현재페이지
	int rowTotal; //총 게시물의 수
	String pageCode; //페이징 처리된 HTML코드
	
	@RequestMapping("/mb_list.sc")
	public ModelAndView handleRequest(MatchingVO vo) throws Exception {
		//현재 페이지 값 받기
		String c_page = request.getParameter("nowPage");

		if(c_page == null){
			nowPage = 1;
		}else{
			nowPage = Integer.parseInt(c_page);
		}

		rowTotal = mbdao.getTotalCount();

		//페이징 코드를 만들어 내는 객체 생성!!
		Paging page = new Paging(nowPage, rowTotal, BLOCK_LIST, BLOCK_PAGE);
		pageCode = page.getSb().toString();

		//게시물 표현을 위한 begin과 end값
		int begin = page.getBegin();
		int end = page.getEnd();

		if(end > rowTotal){
			end = rowTotal;
		}
		
		Map<String, String> map = new HashMap<String, String>();
		map.put("begin", String.valueOf(begin));
		map.put("end", String.valueOf(end));

		MatchingVO[] ar = mbdao.getmbList(map);
		ModelAndView mv = new ModelAndView();
		mv.addObject("list", ar);
		mv.addObject("nowPage", nowPage);
		mv.addObject("pageCode", pageCode);
		mv.addObject("rowTotal", rowTotal);
		mv.addObject("blockList", BLOCK_LIST);

		mv.setViewName("/matching/mbList");
		
		return mv;
	}
	
}
