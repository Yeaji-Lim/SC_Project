package silver.web.board.control;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;

import silver.web.board.dao.BbsDAO;
import silver.web.board.vo.BbsVO;



public class InfoViewControl implements Controller {

	BbsDAO infoDAO;
	BbsVO vo;
	HttpSession session;


	String seq, nowPage;


	public void setInfoDAO(BbsDAO infoDAO) {
		this.infoDAO = infoDAO;
	}


	public void setSession(HttpSession session) {
		this.session = session;
	}

	public void setVo(BbsVO vo) {
		this.vo = vo;
	}

	@Override
	public ModelAndView handleRequest
	(HttpServletRequest request, HttpServletResponse arg1) throws Exception {
		seq = request.getParameter("seq");
		nowPage = request.getParameter("nowPage");


		BbsVO vo = infoDAO.getBoard(seq);



		//우선 현재 읽기를 하는 게시물이 앞서
		//읽은 적이 있는지를 판단하기 위해
		//HttpSession으로 부터 읽은 게시물들이
		// 저장된 List를 얻어낸다.
		HttpSession session = request.getSession();

		List<BbsVO> vList = null;

		Object obj = session.getAttribute("view_list");
		//만약!
		//위의 내용을 처음으로 수행하는 것이라면
		//obj에는 null값이 들어가 있다. 이것을 비교하자
		if(obj == null){
			//처음하는 것이므로 list를 생성하여
			//그곳에 게시물객체를 저장한 후 세션에 
			//list를 저장한다.
			vList = new ArrayList<BbsVO>();
			vList.add(vo);

			infoDAO.updateHit(vo.getSeq());//조회수 증가

			session.setAttribute("view_list", vList);
		}else{

			vList = (List<BbsVO>)obj;

			//ArrayList에 있는 모든 BbsVO들을
			//b_idx값으로 비교
			boolean check = true;
			for(BbsVO bvo : vList){
				if(bvo.getSeq().equals(vo.getSeq())){
					//이미 읽었던 게시물!!
					check = false;
					break;//반복문 탈출
				}
			}//for의 끝

			if(check){
				//앞서 읽었던 게시물이 아닌 경우이므로
				//조회수 증가
				infoDAO.updateHit(seq);
				vList.add(vo);
			}
		}

		ModelAndView mv = new ModelAndView();

		mv.addObject("vo", vo);
		mv.addObject("svo", vo.getC_list());
		mv.addObject("seq", seq);
		mv.addObject("nowPage", nowPage);
		mv.setViewName("/board/infoView");

		return mv;
	}

}
