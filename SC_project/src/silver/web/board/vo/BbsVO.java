package silver.web.board.vo;

import java.util.List;

import org.springframework.web.multipart.MultipartFile;

public class BbsVO {
	
		private String 	seq, writer, title, content, pwd,
		groups, step, lev, bname , regdate , uploadFileName, ip ;
		
		private int hit;
		
		private int nowPage;

		private MultipartFile upload;
		
		private List<CommVO> c_list;
		
		
		
		

		public int getHit() {
			return hit;
		}

		public void setHit(int hit) {
			this.hit = hit;
		}

		public List<CommVO> getC_list() {
			return c_list;
		}

		public void setC_list(List<CommVO> c_list) {
			this.c_list = c_list;
		}

		public int getNowPage() {
			return nowPage;
		}

		public void setNowPage(int nowPage) {
			this.nowPage = nowPage;
		}

		public String getSeq() {
			return seq;
		}

		public void setSeq(String seq) {
			this.seq = seq;
		}

		public String getWriter() {
			return writer;
		}

		public void setWriter(String writer) {
			this.writer = writer;
		}

		public String getTitle() {
			return title;
		}

		public void setTitle(String title) {
			this.title = title;
		}

		public String getContent() {
			return content;
		}

		public void setContent(String content) {
			this.content = content;
		}

		public String getPwd() {
			return pwd;
		}

		public void setPwd(String pwd) {
			this.pwd = pwd;
		}

		

		

		public String getGroups() {
			return groups;
		}

		public void setGroups(String groups) {
			this.groups = groups;
		}

		public String getStep() {
			return step;
		}

		public void setStep(String step) {
			this.step = step;
		}

		public String getLev() {
			return lev;
		}

		public void setLev(String lev) {
			this.lev = lev;
		}

		public String getBname() {
			return bname;
		}

		public void setBname(String bname) {
			this.bname = bname;
		}

		public String getRegdate() {
			return regdate;
		}

		public void setRegdate(String regdate) {
			this.regdate = regdate;
		}

		public String getUploadFileName() {
			return uploadFileName;
		}

		public void setUploadFileName(String uploadFileName) {
			this.uploadFileName = uploadFileName;
		}

		public String getIp() {
			return ip;
		}

		public void setIp(String ip) {
			this.ip = ip;
		}

		public MultipartFile getUpload() {
			return upload;
		}

		public void setUpload(MultipartFile upload) {
			this.upload = upload;
		}
		
}
