package silver.web.board.dao;

import java.util.List;
import java.util.Map;

import org.mybatis.spring.SqlSessionTemplate;

import silver.web.board.vo.QNABoardVO;

public class QNABoardDAO {

	private SqlSessionTemplate template;

	public void setTemplate(SqlSessionTemplate template) {
		this.template = template;
	}

	//게시물 수 반환
	public int getTotalCount(){
		return template.selectOne("qna.totalCount");
	}

	//표현할 게시물 목록을 반환
	public QNABoardVO[] getQNAList(Map<String, String> map){
		List<QNABoardVO> list = template.selectList("qna.qbList", map);

		QNABoardVO[] ar = null;
		if(list != null && list.size() > 0){
			ar = new QNABoardVO[list.size()];
			list.toArray(ar);
		}
		return ar;
	}

	//원글을 저장하는 기능
	public void qb_insert(QNABoardVO vo){
		template.insert("qna.qb_write", vo);
	}

	//기본키값으로 게시물을 검색
	public QNABoardVO getQNABoard(String qb_num){
		return template.selectOne("qna.qb_view", qb_num);
	}

	//답변 저장시 qb_lev 조정
	public void updateLev(Map<String, String> map){
		template.update("qna.updateLev", map);
	}

	//답변 저장
	public void addQBans(QNABoardVO vo){
		template.insert("qna.qb_ans_write", vo);
		
	}
	
	//게시물 수정
	public void qb_edit(QNABoardVO vo){
		template.update("qna.qb_edit", vo);
	}
	
	//조회수 증가
	public int updateRead(String qb_num){
		return template.update("qna.update_readcount", qb_num);
	}
	
	//답변을 삭제
	public int delQna(String qb_num){
		return template.delete("qna.qb_del", qb_num);
	}

}
