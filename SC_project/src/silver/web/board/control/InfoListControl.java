package silver.web.board.control;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;

import silver.include.Paging;
import silver.web.board.dao.BbsDAO;
import silver.web.board.vo.BbsVO;


public class InfoListControl implements Controller {

	BbsDAO infoDAO;
		
		
	public void setInfoDAO(BbsDAO infoDAO) {
		this.infoDAO = infoDAO;
	}


	public static final int BLOCK_LIST = 10;
	public static final int BLOCK_PAGE = 5;
	int nowPage, rowTotal;
	String pageCode;
	
	
	@Override
	public ModelAndView
	handleRequest(HttpServletRequest arg0, HttpServletResponse arg1)
			throws Exception {
		
		String c_page = arg0.getParameter("nowPage");
		
		if(c_page == null)
			nowPage = 1;
		else
			nowPage = Integer.parseInt(c_page);
		
		String bname = "BBS";
		
		rowTotal = infoDAO.getTotalCount(bname);
		
		Paging page = new Paging(nowPage, rowTotal, BLOCK_LIST, BLOCK_PAGE);
		
		pageCode = page.getSb().toString();
		
		int begin = page.getBegin();
		int end = page.getEnd();
		
		if(end > rowTotal)
			end = rowTotal;
		
		Map<String, String> map = new HashMap<>();
		
		map.put("bname", bname);
		map.put("begin", String.valueOf(begin));
		map.put("end", String.valueOf(end));
		
		BbsVO[] ar = infoDAO.getList(map);
		
		ModelAndView mv = new ModelAndView();
		
		mv.addObject("list", ar);
		mv.addObject("pageCode", pageCode);
		mv.addObject("nowPage", nowPage);
		mv.addObject("rowTotal", rowTotal);
		mv.addObject("blockList", BLOCK_LIST);
		mv.addObject("blockPage", BLOCK_PAGE);
		mv.setViewName("/board/infoList");
		
		return mv;
	}
	

	

}
