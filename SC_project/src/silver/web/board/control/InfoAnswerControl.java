package silver.web.board.control;

import java.io.File;
import java.util.HashMap;
import java.util.Map;

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
public class InfoAnswerControl {
	
	@Autowired
	BbsDAO infoDAO;
	
	@Autowired
	HttpServletRequest request;
	
	@Autowired
	ServletContext application;
	
	String uploadPath;
	
	public void setUploadPath(String uploadPath) {
		this.uploadPath = uploadPath;
	}



	@RequestMapping(value="answer.sc", method=RequestMethod.GET)
	public ModelAndView write(BbsVO vo) throws Exception{
		
		
		ModelAndView mv = new ModelAndView();
		mv.addObject("vo", vo);
		mv.setViewName("/board/infoAnswer");
		
		return mv;
		
	}
	
	@RequestMapping(value="answer.sc", method=RequestMethod.POST)
	public ModelAndView answer(BbsVO vo) throws Exception{
		
			if(vo.getUpload().getSize()>0){
			
			String path = application.getRealPath(uploadPath);
			
			MultipartFile upload = vo.getUpload();
			
			String fileName = upload.getOriginalFilename();
			
			fileName = silver.util.FileSaveUtil.checkSameFileName(fileName, path);
			
			upload.transferTo(new File(path, fileName));
			
			vo.setUploadFileName(fileName);
			
		}else{
				vo.setUploadFileName("");
		}

			vo.setIp(request.getRemoteAddr());
			vo.setBname("BBS");
			
			//���� �����ۿ� groups���� ���� lev�� ���� �������� lev����
			//ū �Խù����� lev�� 1�� �����ؾ� �Ѵ�.
			
			Map<String, String> map = new HashMap<>();
			
			map.put("groups", vo.getGroups());
			map.put("lev", vo.getLev());
			
			infoDAO.updateLev(map);
			
			int lev = Integer.parseInt(vo.getLev())+1;
			int step = Integer.parseInt(vo.getStep())+1;
			
			vo.setLev(String.valueOf(lev));
			vo.setStep(String.valueOf(step));
			
			
			infoDAO.addAns(vo);
			
			ModelAndView mv = new ModelAndView();
			
			mv.setViewName("redirect:/info.sc?nowPage="+vo.getNowPage());
			
			return mv;
		
	}
	

}
