package silver.web.member.control;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class MyPageMainControl {

	@RequestMapping("/mypage.sc")
	public String mypage(){
		return "/myPage/myPageMain";
	}
	
}
