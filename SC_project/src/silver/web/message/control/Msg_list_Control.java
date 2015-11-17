package silver.web.message.control;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;


import silver.include.Paging;
import silver.web.member.vo.LoginVO;
import silver.web.message.dao.MsgDAO;
import silver.web.message.vo.MsgVO;

@Controller
public class Msg_list_Control{
		@Autowired
		MsgDAO dao;
	
		@Autowired
		HttpServletRequest request;
		
		@Autowired
		HttpSession session;
		
		//페이징 기법에 필요한 변수들
		public static final int BLOCK_LIST = 10;
		public static final int BLOCK_PAGE = 5;
		
		int nowPage; //현재 페이지 값
		int rowTotal; //총 게시물의 수
		//String rowTotal1;		
		String pageCode; //페이징 처리된 HTML코드
					
		@RequestMapping(value="/msg_list.sc", method=RequestMethod.GET)
		public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response) throws Exception {
			
			//현재 페이지 값 받기
			LoginVO vo = (LoginVO)session.getAttribute("login_ok");
			String c_page = request.getParameter("nowPage");
			String tel = vo.getTel();
			
			if(c_page == null)
				nowPage =1;
			else
				nowPage = Integer.parseInt(c_page);
			
			rowTotal = dao.getTotalCount(tel);
			
			//페이징 코드를 만들어 내는 객체 생성!!
			Paging page = new Paging(nowPage, rowTotal, BLOCK_LIST, BLOCK_PAGE);
			pageCode = page.getSb().toString();

			//게시물 표현을 위한 begin과 end값
			int begin = page.getBegin();
			int end = page.getEnd();

			if(end > rowTotal){
				end = rowTotal;
			}
			
			//dao를 통해 표현할 목록을 가져오기 위해 map구조를 생성
			Map<String, String> map = 
					new HashMap<>();
			map.put("send_tel", tel);
			map.put("begin", String.valueOf(begin));
			map.put("end", String.valueOf(end));

			MsgVO[] ar = dao.getList(map);
				
			//jsp에서 표현할 수 있도록 반환객체 생성
			ModelAndView mv =  new ModelAndView();
			mv.addObject("list", ar);
			mv.addObject("nowPage", nowPage);
			mv.addObject("pageCode",pageCode);
			mv.addObject("rowTotal",rowTotal);
			mv.addObject("blockList",BLOCK_LIST);
			
			mv.setViewName("/msg/msg_list");
			return mv;
		}
}
