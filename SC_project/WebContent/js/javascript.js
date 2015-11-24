// 전역 변수
var errmsg = "";
var errfld;

// 필드 검사
function check_field(fld, msg) 
{
    if ((fld.value = trim(fld.value)) == "") 			   
        error_field(fld, msg);
    else
        clear_field(fld);
    return;
}

// 필드 오류 표시
function error_field(fld, msg) 
{
    if (msg != "")
        errmsg += msg + "\n";
    if (!errfld) errfld = fld;
    fld.style.background = "#BDDEF7";
}

// 필드를 깨끗하게
function clear_field(fld) 
{
    fld.style.background = "#FFFFFF";
}

function trim(s)
{
	var t = "";
	var from_pos = to_pos = 0;

	for (i=0; i<s.length; i++)
	{
		if (s.charAt(i) == ' ')
			continue;
		else 
		{
			from_pos = i;
			break;
		}
	}

	for (i=s.length; i>=0; i--)
	{
		if (s.charAt(i-1) == ' ')
			continue;
		else 
		{
			to_pos = i;
			break;
		}
	}	

	t = s.substring(from_pos, to_pos);
	//				alert(from_pos + ',' + to_pos + ',' + t+'.');
	return t;
}

// 자바스크립트로 PHP의 number_format 흉내를 냄
// 숫자에 , 를 출력
function number_format(data) 
{
	
    var tmp = '';
    var number = '';
    var cutlen = 3;
    var comma = ',';
    var i;
   
    len = data.length;
    mod = (len % cutlen);
    k = cutlen - mod;
    for (i=0; i<data.length; i++) 
	{
        number = number + data.charAt(i);
		
        if (i < data.length - 1) 
		{
            k++;
            if ((k % cutlen) == 0) 
			{
                number = number + comma;
                k = 0;
			}
        }
    }

    return number;
}

// 새 창
function popup_window(url, winname, opt)
{
    window.open(url, winname, opt);
}


// 폼메일 창
function popup_formmail(url)
{
	opt = 'scrollbars=yes,width=417,height=385,top=10,left=20';
	popup_window(url, "wformmail", opt);
}

// 큰이미지 창
function popup_large_image(it_id, img, width, height, cart_dir)
{
	var top = 10;
	var left = 10;
	url = "./SubPage.php?CID="+cart_dir+"/largeimage.php&it_id=" + it_id + "&img=" + img;
	width = width + 50;
	height = height + 70;
	opt = 'scrollbars=yes,width='+width+',height='+height+',top='+top+',left='+left;
	popup_window(url, "largeimage", opt);
}

// , 를 없앤다.
function no_comma(data)
{
	var tmp = '';
    var comma = ',';
    var i;

	for (i=0; i<data.length; i++)
	{
		if (data.charAt(i) != comma)
		    tmp += data.charAt(i);
	}
	return tmp;
}

// 삭제 검사 확인
function del(href) 
{
    if(confirm("한번 삭제한 자료는 복구할 방법이 없습니다.\n\n정말 삭제하시겠습니까?")) 
        document.location.href = href;
}

// 삭제 검사 확인
function it_del(href) 
{
    if(confirm("한번 삭제한 제품은 복구할 방법이 없습니다.\n\n해당 제품의 문의게시글이 모두 삭제됩니다.\n\n정말 삭제하시겠습니까?")) 
        document.location.href = href;
}

// 쿠키 입력
function set_cookie(name, value, expirehours) 
{
	var today = new Date();
	today.setTime(today.getTime() + (60*60*1000*expirehours));
	document.cookie = name + "=" + escape( value ) + "; path=/; expires=" + today.toGMTString() + ";";
}

// 쿠키 얻음
function get_cookie(name) 
{
    var find_sw = false;
    var start, end;
    var i = 0;

	for (i=0; i<= document.cookie.length; i++)
	{
		start = i;
		end = start + name.length;

		if(document.cookie.substring(start, end) == name) 
		{
			find_sw = true
			break
		}
	}

    if (find_sw == true) 
	{
        start = end + 1;
        end = document.cookie.indexOf(";", start);

        if(end < start)
            end = document.cookie.length;

        return document.cookie.substring(start, end);
    }
    return "";
}

// 쿠키 지움
function delete_cookie(name) 
{
	var today = new Date();

	today.setTime(today.getTime() - 1);
	var value = getCookie(name);
	if(value != "")
		document.cookie = name + "=" + value + "; path=/; expires=" + today.toGMTString();
		
}

// 쿠키 지움
function del_cookie( name ) {

    expireDate = new Date
    expireDate.setDate(expireDate.getDate()-1) 
    document.cookie = name + "=;expires=" + expireDate.toGMTString()
    
}



// 우편번호 창
function popup_zip(frm_name, frm_zip1, frm_zip2, frm_addr1, frm_addr2, dir, top, left)
{
    url = './SubPage.php?CID='+dir+'/mbzip.php&frm_name='+frm_name+'&frm_zip1='+frm_zip1+'&frm_zip2='+frm_zip2+'&frm_addr1='+frm_addr1+'&frm_addr2='+frm_addr2+'&zip_chk=1';
    opt = 'scrollbars=yes,width=490,height=340,top='+top+',left='+left;
    window.open(url, "mbzip", opt);
}

// 우편번호 창
function popup_sinzip(frm_name, frm_zip1, frm_zip2, frm_addr1, frm_addr2, dir, top, left)
{
    url = './SubPage.php?CID='+dir+'/mbsinzip.php&frm_name='+frm_name+'&frm_zip1='+frm_zip1+'&frm_zip2='+frm_zip2+'&frm_addr1='+frm_addr1+'&frm_addr2='+frm_addr2+'&zip_chk=1';
    opt = 'scrollbars=no,width=470,height=580,top='+top+',left='+left;
    window.open(url, "mbzip", opt);
}

// a 태그에서 onclick 이벤트를 사용하지 않기 위해
function winopen(url, name, option)
{
    window.open(url, name, option);
    return ;
}

// TEXTAREA 사이즈 변경
function textarea_size(fld, size)
{
	var rows = parseInt(fld.rows);

	rows += parseInt(size);
	if (rows > 0) {
		fld.rows = rows;
	}
}

var old='';
function menu(name){

	submenu=eval(name+".style");

	if (old!=submenu)
	{
		if(old!='')
		{
			old.display='none';
		}
		submenu.display='block';
		old=submenu;
	}
	else
	{
		submenu.display='none';
		old='';
	}
}

// 3.36
function image_window(img, w, h)
{
    var tmp_w = w;
    var tmp_h = h;
    winl = (screen.width-w)/2;
    wint = (screen.height-h)/3;

    if (w >= screen.width) {
        winl = 0;
        w = screen.width - 10;
        h = (parseInt)(w * (h / w));
    }

    if (h >= screen.height) {
        wint = 0;
        h = screen.height - 80;
        w = (parseInt)(h * (w / h));
    }

    var settings  ='width='+w+',';
        settings +='height='+h+',';
        settings +='top='+wint+',';
        settings +='left='+winl+',';
        settings +='scrollbars=no,';
        settings +='resizable=no,';
        settings +='status=no';

    win=window.open("","newWindow",settings);
    win.document.open();
    win.document.write ("<html><head><meta http-equiv='content-type' content='text/html; charset=utf-8'>");
    win.document.write ("<title>이미지 보기</title></head>");
    win.document.write ("<body leftmargin=0 topmargin=0>");
    //win.document.write ("<img src='"+img+"' width='"+w+"' height='"+h+"'border=0 onclick='window.close();' style='cursor:hand' title='해상도 ("+tmp_w+"x"+tmp_h+")\n클릭하면 닫혀요'>");
    win.document.write ("<img src='"+img+"' width='"+w+"' height='"+h+"'border=0 onclick='window.close();' onkeypress='window.close();' style='cursor:hand' alt='이미지' />");
    win.document.write ("</body></html>");
    win.document.close();

    if(parseInt(navigator.appVersion) >= 4){win.window.focus();}
}
// 화면 확대, 축소
var nowZoom = 100;		//현재비율
var maxZoom = 200;		//최대비율
var minZoom = 80;		// 최소비율

// 화면크기 확대
function zoomIn() {
	if (nowZoom < maxZoom)
	{
		nowZoom += 10; // 25%씩 확대
	} else {
		alert("화면의 최대비율입니다.");
		return;
	}
	document.body.style.zoom = nowZoom + "%";
}

// 화면크기 축소
function zoomOut() {
	if (nowZoom > minZoom)
	{
		nowZoom -= 10; // 25%씩 축소
	} else {
		alert("화면의 최소비율입니다.");
		return;
	}
	document.body.style.zoom = nowZoom + "%";
}

// 화면크기 기본
function zoomDefault() {
	nowZoom = 100;
	document.body.style.zoom = nowZoom + "%";
}



// 전체메뉴보이기,감추기
function total_menu_show(id,height){

	   $("#"+id).animate({

			  "top" : "+="+height+"px"

	   }, "slow");

}

function total_menu_hide(id,height){

	   $("#"+id).animate({

			  "top" : "-="+height+"px"

	   }, "slow");

}


// 페이지 스크롤사이즈
function ___getPageScroll() {
	var xScroll, yScroll;
	if (self.pageYOffset) {
		yScroll = self.pageYOffset;
		xScroll = self.pageXOffset;
	} else if (document.documentElement && document.documentElement.scrollTop) {	 // Explorer 6 Strict
		yScroll = document.documentElement.scrollTop;
		xScroll = document.documentElement.scrollLeft;
	} else if (document.body) {// all other Explorers
		yScroll = document.body.scrollTop;
		xScroll = document.body.scrollLeft;	
	}
	arrayPageScroll = new Array(xScroll,yScroll);
	return arrayPageScroll;
};

// 페이지 사이즈
function ___getPageSize() {
	var xScroll, yScroll;
	if (window.innerHeight && window.scrollMaxY) {	
		xScroll = window.innerWidth + window.scrollMaxX;
		yScroll = window.innerHeight + window.scrollMaxY;
	} else if (document.body.scrollHeight > document.body.offsetHeight){ // all but Explorer Mac
		xScroll = document.body.scrollWidth;
		yScroll = document.body.scrollHeight;
	} else { // Explorer Mac...would also work in Explorer 6 Strict, Mozilla and Safari
		xScroll = document.body.offsetWidth;
		yScroll = document.body.offsetHeight;
	}
	var windowWidth, windowHeight;
	if (self.innerHeight) {	// all except Explorer
		if(document.documentElement.clientWidth){
			windowWidth = document.documentElement.clientWidth; 
		} else {
			windowWidth = self.innerWidth;
		}
		windowHeight = self.innerHeight;
	} else if (document.documentElement && document.documentElement.clientHeight) { // Explorer 6 Strict Mode
		windowWidth = document.documentElement.clientWidth;
		windowHeight = document.documentElement.clientHeight;
	} else if (document.body) { // other Explorers
		windowWidth = document.body.clientWidth;
		windowHeight = document.body.clientHeight;
	}	
	// for small pages with total height less then height of the viewport
	if(yScroll < windowHeight){
		pageHeight = windowHeight;
	} else { 
		pageHeight = yScroll;
	}
	// for small pages with total width less then width of the viewport
	if(xScroll < windowWidth){	
		pageWidth = xScroll;		
	} else {
		pageWidth = windowWidth;
	}
	arrayPageSize = new Array(pageWidth,pageHeight,windowWidth,windowHeight);
	return arrayPageSize;
};