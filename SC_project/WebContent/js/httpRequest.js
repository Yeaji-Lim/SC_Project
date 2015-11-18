
var xhr = null;

function getRequest(){
	if(window.ActiveXObject)//인터넷익스플로러
		xhr = new ActiveXObject("Microsoft.XMLHTTP");
	else
		xhr = new XMLHttpRequest();
}

function sendRequest(url, param,
		callback, method, async){
	
	getRequest();//xhr객체 생성
	
	//전송방식(method) 문자열을 받아서
	// 소문자로 변경한 후, "get"으로 비교한다.
	// 만약! "get"이면 "GET"으로 바꾸고 아니면
	// 모두 "POST"로 설정한다.
	method = (method.toLowerCase() == "get")?"GET":"POST";
	
	param = (param == null || param == "")?null:param;
	
	//요청방식에 따라 파라미터와 URL은 달라진다.
	// 예) get방식: test.jsp?v1=ttt
	//     post방식: test.jsp   
	if(method == "GET" && param != null)
		url = url+"?"+param;
	
	//도착함수 지정
	xhr.onreadystatechange = callback;
	
	//요청 정보 설정
	xhr.open(method, url, async);
	
	//헤더값 설정
	xhr.setRequestHeader("Content-Type",
	 "application/x-www-form-urlencoded");
	
	//요청보내기
	xhr.send(method=='POST'?param:null); 
	//post방식 : xhr.send(param);
	//get방식 : xhr.send(null);
}







