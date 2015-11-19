package silver.web.message.dao;

import java.util.List;
import java.util.Map;

import org.mybatis.spring.SqlSessionTemplate;

import silver.web.message.vo.MsgVO;

public class MsgDAO {
	
	private SqlSessionTemplate template;

	public void setTemplate(SqlSessionTemplate template) {
		this.template = template;
	}
	//공지사항 로직
	
	//원하는 공지사항의 게시물 수를 반환
	public int getTotalCount(String requesttel){
		return template.selectOne("msg.msg_totalCount",requesttel);
	}
	//표현할 게시물 목록을 반환
	public MsgVO[] getList(Map<String, String> m){
		List<MsgVO> list = template.selectList("msg.msg_list", m);
		//System.out.println(list.size());
		// 받은 list 구조를 다시 배열로 변환 
		
		MsgVO[] ar = null;
		if(list != null && list.size()>0){
			ar= new MsgVO[list.size()];
			//list의 요소들을 배열에 복사해 넣는다. 
			list.toArray(ar);
			
		}
		return ar;
	}
	//공지사항 글저장
	public void writeBbs(MsgVO vo){
		String re = vo.getRequest_tel().trim();
		vo.setRequest_tel(re);
		template.insert("msg.msg_write",vo);	
	}
	//쪽지보기보기
	public MsgVO getBoard(String b_idx){
		return template.selectOne("msg.msg_getBoard", b_idx);
	}
	//삭제
	public void delBbs(MsgVO vo){
		template.update("msg.msg_del",vo);
	}

}
