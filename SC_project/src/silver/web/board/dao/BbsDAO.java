package silver.web.board.dao;

import java.util.List;
import java.util.Map;

import org.mybatis.spring.SqlSessionTemplate;

import silver.web.board.vo.BbsVO;
import silver.web.board.vo.CommVO;

public class BbsDAO {

	private SqlSessionTemplate template;

	public void setTemplate(SqlSessionTemplate template) {
		this.template = template;
	}


	public int getTotalCount(String bname){
		return template.selectOne("info.totalCount", bname);
	}

	public BbsVO[] getList(Map<String, String> m){

		List<BbsVO> list = template.selectList("info.list", m);

		BbsVO[] ar = new BbsVO[list.size()];

		return list.toArray(ar);

	}

	public boolean write(BbsVO vo){

		int cnt = template.insert("info.write", vo);

		if(cnt  >  0)
			return true;
		else
			return false;
	}

	public BbsVO getBoard(String seq){

		return template.selectOne("info.getBoard", seq);

	}

	public void updateLev(Map<String, String> m){
		template.update("info.updateLev", m);
	}

	public void addAns(BbsVO vo){
		template.insert("info.addAns", vo);
	}

	public void editBbs(BbsVO vo){
		template.update("info.edit", vo);
	}

	//댓글 보여주는 애
	public List<BbsVO> view2(String seq){

		List<BbsVO> list = template.selectList("info.commList", seq);

		return list;
	}


	//댓글 추가하는 애
	public void addAnswer(CommVO cvo){

		template.insert("info.addComment", cvo);
	}

	//조회수 증가
	public void updateHit(String seq){

		template.update("info.updateHit",seq);


	}

	public void bbsDel(String seq){

		template.update("info.updateBbs", seq);

	}

	public void delComm(String c_idx){
		template.update("info.updateComm", c_idx);
	}

}
