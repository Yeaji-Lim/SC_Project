package silver.web.board.control;

import java.io.File;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import silver.web.board.dao.BbsDAO;
import silver.web.board.vo.BbsVO;


@Controller
public class InfoEditControl {
	
	
	@Autowired
	BbsDAO infoDAO;
	
	@Autowired
	ServletContext application;
	
	@Autowired
	HttpServletRequest request;
	
	String uploadPath;

	public void setUploadPath(String uploadPath) {
		this.uploadPath = uploadPath;
	}
	
	// view.jsp ���� ������ư�� �������� ��, ���� control�� ����� ����
	// Get������� ��û�Ǿ��� �� �̴�.
	@RequestMapping(value="/edit.sc",method=RequestMethod.GET)
	public ModelAndView edit(BbsVO vo) throws Exception{
		
		ModelAndView mv = new ModelAndView();
		
		mv.addObject("nowPage", vo.getNowPage());
		
		
		vo = infoDAO.getBoard(vo.getSeq());
		
		
		mv.addObject("vo", vo);
		mv.addObject("seq", vo.getSeq());
		mv.setViewName("/board/infoEdit");
		
		return mv;
		
	}
	
	// ��(edit.jsp) ȭ�鿡�� ������ ���Ҷ� DB�۾��� �����ؾ� �Ѵ�. �̶� ��û
	// ����� POST����̴�.

	@RequestMapping(value="/edit.sc",method=RequestMethod.POST)
	public ModelAndView edit2(BbsVO vo) throws Exception{
		
		ModelAndView mv = new ModelAndView();
		
		
		
		if(vo.getUpload().getSize() > 0){
			
			String path=application.getRealPath("uploadPath");
			
			MultipartFile upload=vo.getUpload();
			
			String fileName = upload.getOriginalFilename();
			
			fileName = silver.util.FileSaveUtil.checkSameFileName(fileName, path);
			
			upload.transferTo(new File(path, fileName));
			
			vo.setUploadFileName(fileName);
			
		}
		
		vo.setIp(request.getRemoteAddr());
		
		infoDAO.editBbs(vo);
		
		mv.setViewName
		("redirect:/view.sc?seq="+vo.getSeq()+"&nowPage="+vo.getNowPage());
		
		return mv;

	}
}
