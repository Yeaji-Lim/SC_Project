package silver.web.matching.dao;

import java.util.List;
import java.util.Map;

import org.mybatis.spring.SqlSessionTemplate;
import silver.web.matching.vo.MatchingVO;

public class MatchingDAO {
	private SqlSessionTemplate template;

	public void setTemplate(SqlSessionTemplate template) {
		this.template = template;
	}
	
	public int getTotalCount(){
		return template.selectOne("match.totalCount");
	}
	
	public MatchingVO[] getmbList(Map<String, String> m){
		List<MatchingVO> list = template.selectList("match.mbList", m);
		
		// 받은 list 구조를 다시 배열로 변환 
		MatchingVO[] ar = null;
		if(list != null && list.size()>0){
			ar= new MatchingVO[list.size()];
			//list의 요소들을 배열에 복사해 넣는다. 
			list.toArray(ar);
		}
		return ar;
	}
	
	public boolean mbWrite(MatchingVO vo){
		int cnt = template.insert("match.mb_write",vo);
		if(cnt >0 ){
			return true;
		}
		else{
			return false;
		}
	}
	
	public MatchingVO mbView(String mb_num){
		return template.selectOne("match.mb_view", mb_num);
	}
	
	public void mbEdit(MatchingVO vo){
		template.update("match.mb_edit", vo);
	}
	public void mbDel(MatchingVO vo){
		template.update("match.mb_del",vo);
	}
	
}
