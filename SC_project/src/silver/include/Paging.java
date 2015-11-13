package silver.include;

public class Paging {
	//페이징 기법에 필요한 변수들 선언
	int nowPage = 1; //현재 페이지 값
	int nowBlock = 1; //현재 블럭
	int totalRecord = 0;//총 게시물 수
	int numPerPage = 10;//한 페이지당 표현될 게시물 수
	int pagePerBlock = 5;//한 블럭당 표현될 페이지 수
	int totalPage = 0;// 총 페이지 수
	int begin = 0;//한 페이지에 시작게시물의 행번호
	int end = 0;//한 페이지에 마지막게시물의 행번호
	
	int startPage, endPage;
	
	//이전과 다음 기능 가능 여부
	boolean isPre, isNext;
	
	//위의 변수들을 통해 페이징 기법의 HTML 코드를 저장할 곳
	StringBuffer sb;
	
	//생성자 정의
	public Paging(int nowpage, int total, int numPerPage, int pagePerBlock) {
		this.nowPage = nowpage; //현재 페이지 값
		this.totalRecord = total; //총 게시물의 수
		this.numPerPage = numPerPage; //한 페이지 당 게시물의 수
		this.pagePerBlock = pagePerBlock; 
		
		//총 게시물 수로 총 페이지 수를 구한다!
		totalPage = (int)Math.ceil(
				total/(double)numPerPage);
		
		//현재 페이지가 전체 페이지 수보다
		//크다면 현재 페이지 값을
		//전체 페이지 값으로 변경하자!
		if(nowpage > totalPage)
			nowpage = totalPage;
		
		// 현재 페이지 값이 1이면 ---> begin:1, end:10
		// 현재 페이지 값이 2면 ---> begin:11, end:20
		// 현재 페이지 값이 3 ---> begin:21, end:30
		begin = (nowpage-1)*numPerPage+1;
		end = nowpage*numPerPage;
		
		//end의 값이 총 게시물의 수를 넘으면
		//문제가 발생하므로 조정해야 한다.
		if(end > total)
			end = total;
		
		// 페이지 블럭을 만들기 위해 필요한 변수
		// 블럭의 시작 페이지 값 구하기
		int startPage = ((nowpage-1)/pagePerBlock)*pagePerBlock+1; 
		// 블럭의 마지막 페이지 값 구하기
		int endPage = startPage + pagePerBlock - 1;

		// 만약, 총 페이지 수의 값이 12일 경우, 
		// 위의 연산에 의하면 endPage의 값이 15가 된다
		// 위와 같은 경우, endPage의 값을 totalPage의 값으로 변경해야 한다
		if(endPage > totalPage)
			endPage = totalPage;
		
		//이전과 다음 기능 가능여부 확인
		if(startPage > 1)//이전 기능이 되는 경우
			isPre = true;
		
		if(endPage < totalPage)//다음 기능이 되는 경우
			isNext = true;
		
		//list.jsp에서 표현될 페이징 기법의 html 코드를 저장할 객체생서
		sb = new StringBuffer();
		
		//html코드 생성
		if(isPre){
			//이전 기능이 수행되어야 한다!!
			sb.append("<img src='images/button/but_prev.gif' ");
			sb.append("onclick='");
			sb.append("javascript:location.href=\"");
			sb.append("list.inc?nowPage=");
			sb.append(nowpage-pagePerBlock);
			sb.append("\"' style='cursor:pointer'>");
		}else{
			sb.append("<img src='images/button/but_prev.gif'/>");
		}
		
		sb.append("|");
		
		//페이지 번호 출력
		for(int i=startPage;i<=endPage;i++){
			//페이지 번호가 전체 총 페이지 수보다 클 경우, 반복문 탈출
			if(i>totalPage)
				break;
			
			//현재 페이지는 링크를 걸지 않는다
			if(nowpage == i){
				//sb.append("<li class='now'>"+i+"</li>");
				sb.append("&nbsp;<span style='");
				sb.append("color:#000; font-weight:bold;'>");
				sb.append(i);
				sb.append("</span>");
			}else{
				sb.append("<a href='list.inc?nowPage=");
				sb.append(i);
				sb.append("'>");
				sb.append(i);
				sb.append("</a>");
			}
		}//for
		
		sb.append("&nbsp;|");
		
		if(isNext){
			//다음 기능이 수행되어야 한다!!
			sb.append("<img src='images/button/but_next.gif' ");
			sb.append("onclick='javascript:location.href=\"");
			sb.append("list.inc?nowPage=");
			sb.append(nowpage+pagePerBlock);
			sb.append("\"' style='cursor:pointer'>");
		}else{
			sb.append("<img src='images/button/but_next.gif'/>");
		}
		
		
	}//생성자

	public int getNowPage() {
		return nowPage;
	}

	public void setNowPage(int nowPage) {
		this.nowPage = nowPage;
	}

	public int getNowBlock() {
		return nowBlock;
	}

	public void setNowBlock(int nowBlock) {
		this.nowBlock = nowBlock;
	}

	public int getTotalRecord() {
		return totalRecord;
	}

	public void setTotalRecord(int totalRecord) {
		this.totalRecord = totalRecord;
	}

	public int getNumPerPage() {
		return numPerPage;
	}

	public void setNumPerPage(int numPerPage) {
		this.numPerPage = numPerPage;
	}

	public int getPagePerBlock() {
		return pagePerBlock;
	}

	public void setPagePerBlock(int pagePerBlock) {
		this.pagePerBlock = pagePerBlock;
	}

	public int getTotalPage() {
		return totalPage;
	}

	public void setTotalPage(int totalPage) {
		this.totalPage = totalPage;
	}

	public int getBegin() {
		return begin;
	}

	public void setBegin(int begin) {
		this.begin = begin;
	}

	public int getEnd() {
		return end;
	}

	public void setEnd(int end) {
		this.end = end;
	}

	public int getStartPage() {
		return startPage;
	}

	public void setStartPage(int startPage) {
		this.startPage = startPage;
	}

	public int getEndPage() {
		return endPage;
	}

	public void setEndPage(int endPage) {
		this.endPage = endPage;
	}

	public boolean isPre() {
		return isPre;
	}

	public void setPre(boolean isPre) {
		this.isPre = isPre;
	}

	public boolean isNext() {
		return isNext;
	}

	public void setNext(boolean isNext) {
		this.isNext = isNext;
	}

	public StringBuffer getSb() {
		return sb;
	}

	public void setSb(StringBuffer sb) {
		this.sb = sb;
	}
	

}
