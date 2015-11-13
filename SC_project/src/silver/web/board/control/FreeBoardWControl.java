package silver.web.board.control;



import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import silver.web.board.dao.FreeBoardDAO;
import silver.web.board.vo.FreeBoardVO;



@Controller
public class FreeBoardWControl {
	@Autowired
	FreeBoardDAO frdao;
	
	@Autowired
	HttpServletRequest request;
	
	@Autowired
	ServletContext servletContext;
	//위는 아래의 첨부파일이 저장될 폴더명을
	//절대경로로 만들기 위해 필요하다.
	

	
	
	@RequestMapping(value="freewrite.sc",method=RequestMethod.POST)
	public ModelAndView write(FreeBoardVO vo)throws Exception{
		//현재 영역은 POST방식으로 write.inc로
		//요청될 때 수행되는 영역이다.
		//인자인 BbsVO가 자동으로 생성되어
		//파라미터들일 BbsVO에 있는 변수 명들과
		//동일한 곳에 찾아 저장된다.
	
		
		System.out.println(vo.getFb_content());
		
		//
		frdao.writeBbs(vo);
		
		//반환객체 생성
		ModelAndView mv = new ModelAndView();
		
		//Redirect로 list.inc를 호출
		mv.setViewName("redirect:/freelist.sc");
		
		return mv;
	}
}
