package silver.web.message.vo;

public class MsgVO {
	private String b_idx,send_tel,request_tel,content,write_date,status,subject;

	
	public String getSubject() {
		return subject;
	}

	public void setSubject(String subject) {
		this.subject = subject;
	}

	public String getB_idx() {
		return b_idx;
	}

	public void setB_idx(String b_idx) {
		this.b_idx = b_idx;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public String getWrite_date() {
		return write_date;
	}

	public void setWrite_date(String write_date) {
		this.write_date = write_date;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getSend_tel() {
		return send_tel;
	}

	public void setSend_tel(String send_tel) {
		this.send_tel = send_tel;
	}

	public String getRequest_tel() {
		return request_tel;
	}

	public void setRequest_tel(String request_tel) {
		this.request_tel = request_tel;
	}

}
