package silver.web.board.dao;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.mybatis.spring.SqlSessionTemplate;

import silver.web.board.vo.FreeBoardVO;

public class FreeBoardDAO {

	private SqlSessionTemplate template;

	public void setTemplate(SqlSessionTemplate template) {
		this.template = template;
	}
	
	// 비지니스 로직----------------------
	
	// 원하는 bbs의 게시물 수를 반환
	public int getTotalCount(){
		return template.selectOne(
				"free.totalCount");
	}
	
	// 표현할 게시물 목록을 반환
	public FreeBoardVO[] getList(Map<String,String> m){
		List<FreeBoardVO> list =
			template.selectList("free.list",m);
		
		//받은 list구조를 다시 배열로 변환
		FreeBoardVO[] ar = null;
		if(list != null && list.size() > 0){
			ar = new FreeBoardVO[list.size()];
			
			//list의 요소들을 배열에 복사해 넣는다.
			list.toArray(ar);
		}
		return ar;
	}
	
	public FreeBoardVO[] getMainList(){
		List<FreeBoardVO> list =
			template.selectList("free.mainList");
		
		//받은 list구조를 다시 배열로 변환
		FreeBoardVO[] ar = null;
		if(list != null && list.size() > 0){
			ar = new FreeBoardVO[list.size()];
			//list의 요소들을 배열에 복사해 넣는다.
			list.toArray(ar);
		}
		return ar;
	}
	
	//원글을 저장하는 기능
	public boolean writeBbs(FreeBoardVO vo){
		int cnt = template.insert(
				"free.write", vo);
		
		if(cnt > 0)
			return true;
		else
			return false;
	}
	
	//기본키를 가지고 게시물 검색
	public FreeBoardVO getBoard(String n){
		return template.selectOne(
				"free.getBoard", n);
	}
	
	public  void updateHit(String fb_readcount){
		
		template.update("free.updateHit",fb_readcount);
		
	}
	public boolean del(String fb_num,String fb_pwd){
		HashMap<String, String>map = new HashMap<>();
		map.put("fb_num", fb_num);
		map.put("fb_pwd", fb_pwd);
		int cnt= template.update("free.freedel",map);
		boolean check=false;
		if(cnt>0)
			check=true;
			else {
				
			}
		return check;
	}
	
	
	
/*	//답변 저장시 lev를 조정하는 기능
	public void updateLev(Map<String, String> m){
		template.update("bbs.updateLev", m);
	}
	
	//답변 저장
	public void addAns(BbsVO vo){
		template.insert("bbs.addAns", vo);
	}
	*/
	//게시물 수정
	public void editBbs(FreeBoardVO vo){
		template.update("free.edit", vo);
	}
}



;