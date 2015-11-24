package silver.master.dao;

import java.util.List;
import java.util.Map;

import org.mybatis.spring.SqlSessionTemplate;

import silver.web.member.vo.LoginVO;

public class MasterDAO {
	private SqlSessionTemplate template;

	public void setTemplate(SqlSessionTemplate template) {
		this.template = template;
	}
	
	
	
	public int getTotalCount(){
		return template.selectOne(
				"mas.totalCount");
	}
	
	// 표현할 게시물 목록을 반환
	public LoginVO[] getList(Map<String,String> m){
		List<LoginVO> list =
			template.selectList("mas.list",m);
		
		//받은 list구조를 다시 배열로 변환
		LoginVO[] ar = null;
		if(list != null && list.size() > 0){
			ar = new LoginVO[list.size()];
			
			//list의 요소들을 배열에 복사해 넣는다.
			list.toArray(ar);
		}
		return ar;
	}
	//게시물 수정
		public void editBbs(LoginVO vo){
			template.update("mas.edit", vo);
		}
	
		public LoginVO getBoard(String n){
			return template.selectOne(
					"mas.getBoard", n);
		}
	
		public boolean del(String idx){
		
			int cnt= template.update("mas.del",idx);
			boolean check=false;
			if(cnt>0)
				check=true;
				else {
					
				}
			return check;
		}
		
		
		
		
	
}
	
