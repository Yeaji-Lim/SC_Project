package silver.web.board.control;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import silver.web.board.dao.BbsDAO;
import silver.web.board.vo.BbsVO;



@Controller
public class InfoWriteControl {

	@Autowired
	BbsDAO infoDAO;
	
	@Autowired
	HttpServletRequest request;
	
	@Autowired
	ServletContext servletContext;
	
	@Autowired
	HttpSession session;
	
	String uploadPath;

	
	public void setUploadPath(String uploadPath) {
		this.uploadPath = uploadPath;
	}
	
	@RequestMapping(value="/infowrite.sc", method=RequestMethod.POST)
	public ModelAndView write(BbsVO vo) throws Exception{
		
		/*if(vo.getUpload().getSize()>0){
			
			String path = servletContext.getRealPath(uploadPath);
			
			MultipartFile upload = vo.getUpload();
			
			String fileName = upload.getOriginalFilename();
			
			fileName = silver.util.FileSaveUtil.checkSameFileName(fileName, path);
			
			upload.transferTo(new File(path, fileName));
			
			vo.setUploadFileName(fileName);
			
		}else{
				
		}*/
		
		vo.setUploadFileName("");
		vo.setIp(request.getRemoteAddr());
		vo.setBname("BBS");
		
		infoDAO.write(vo);
		
		ModelAndView mv = new ModelAndView();
		
		mv.setViewName("redirect:/info.sc");
				
		return mv;		
	}
	
	
	
}
