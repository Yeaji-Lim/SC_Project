package silver.web.board.vo;

public class QNABoardVO {
	
	private String qb_subject, qb_writer, qb_content,qb_regdate;
	private int qb_num, qb_readcount;
	
	private int qb_groups, qb_step, qb_lev;
	
	private int nowPage;

	public String getQb_subject() {
		return qb_subject;
	}

	public void setQb_subject(String qb_subject) {
		this.qb_subject = qb_subject;
	}

	public String getQb_writer() {
		return qb_writer;
	}

	public void setQb_writer(String qb_writer) {
		this.qb_writer = qb_writer;
	}

	public String getQb_content() {
		return qb_content;
	}

	public void setQb_content(String qb_content) {
		this.qb_content = qb_content;
	}

	public int getQb_num() {
		return qb_num;
	}

	public void setQb_num(int qb_num) {
		this.qb_num = qb_num;
	}

	public int getQb_readcount() {
		return qb_readcount;
	}

	public void setQb_readcount(int qb_readcount) {
		this.qb_readcount = qb_readcount;
	}

	public String getQb_regdate() {
		return qb_regdate;
	}

	public void setQb_regdate(String qb_regdate) {
		this.qb_regdate = qb_regdate;
	}

	public int getQb_groups() {
		return qb_groups;
	}

	public void setQb_groups(int qb_groups) {
		this.qb_groups = qb_groups;
	}

	public int getQb_step() {
		return qb_step;
	}

	public void setQb_step(int qb_step) {
		this.qb_step = qb_step;
	}

	public int getQb_lev() {
		return qb_lev;
	}

	public void setQb_lev(int qb_lev) {
		this.qb_lev = qb_lev;
	}

	public int getNowPage() {
		return nowPage;
	}

	public void setNowPage(int nowPage) {
		this.nowPage = nowPage;
	}
	
}