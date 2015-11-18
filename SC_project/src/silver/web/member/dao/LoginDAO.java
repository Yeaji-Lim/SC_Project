package silver.web.member.dao;

import java.util.Map;

import org.mybatis.spring.SqlSessionTemplate;

import silver.web.member.vo.LoginVO;

public class LoginDAO {

	private SqlSessionTemplate template;

	public void setTemplate(SqlSessionTemplate template) {
		this.template = template;
		//System.out.println("^^::::::::::::::::::::::::");
	}

	// 로그인 기능
	public LoginVO login(Map<String, String> m){

		return template.selectOne("silver.login", m);

	}

	// 회원가입 기능
	public boolean add(LoginVO vo){
		boolean check = false;

		//받은 인자들을 mem.add가 원하는
		//MemberVO에 저장하여 보낸다.
		int cnt = template.insert("silver.add", vo);

		if(cnt >0)
			check = true;
		else
			check = false;

		return check;
	}

	//회원정보 가져오기

	public LoginVO getUser(String tel){
		return template.selectOne("silver.getuser", tel);
	}

	//회원정보 수정
	public void edit(LoginVO vo){
		template.update("silver.edit",vo);
	}

	//회원정보 삭제
	public void delBbs(LoginVO vo){
		template.update("silver.del",vo);
	}

}