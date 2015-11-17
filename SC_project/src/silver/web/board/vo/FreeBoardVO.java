package silver.web.board.vo;

import java.util.List;

public class FreeBoardVO {
	private String fb_num,fb_subject,fb_content,fb_writertel,fb_regdate;
	private int status,fb_readcount;
	private List<FreeRepyVO> f_list;
	public String getFb_num() {
		return fb_num;
	}
	public void setFb_num(String fb_num) {
		this.fb_num = fb_num;
	}
	public String getFb_subject() {
		return fb_subject;
	}
	public void setFb_subject(String fb_subject) {
		this.fb_subject = fb_subject;
	}
	public String getFb_content() {
		return fb_content;
	}
	public void setFb_content(String fb_content) {
		this.fb_content = fb_content;
	}
	public String getFb_writertel() {
		return fb_writertel;
	}
	public void setFb_writertel(String fb_writertel) {
		this.fb_writertel = fb_writertel;
	}
	public String getFb_regdate() {
		return fb_regdate;
	}
	public void setFb_regdate(String fb_regdate) {
		this.fb_regdate = fb_regdate;
	}

	public int getStatus() {
		return status;
	}
	public void setStatus(int status) {
		this.status = status;
	}
	public int getFb_readcount() {
		return fb_readcount;
	}
	public void setFb_readcount(int fb_readcount) {
		this.fb_readcount = fb_readcount;
	}
	public List<FreeRepyVO> getF_list() {
		return f_list;
	}
	public void setF_list(List<FreeRepyVO> f_list) {
		this.f_list = f_list;
	}
	

}
