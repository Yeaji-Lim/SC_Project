
// 자바스크립트에서 사용하는 전역변수 선언
var g4_path      = "..";
var g4_bbs       = "bbs";
var g4_bbs_img   = "img";
var g4_url       = "http://www.sir.co.kr";
var g4_is_member = "1";
var g4_is_admin  = "";
var g4_bo_id 	 = "g3_use";
var g4_sca       = "";
var g4_charset   = "utf-8";
var g4_cookie_domain = ".sir.co.kr";
var g4_is_gecko  = navigator.userAgent.toLowerCase().indexOf("gecko") != -1;
var g4_is_ie     = navigator.userAgent.toLowerCase().indexOf("msie") != -1;


window.onload = function(){ 
	
	//changeOverImg('wrap','img');
}



/* rollover img */
/* 메뉴가 모두 글씨로 표현되서 빼버림
function changeOverImg(elId, tagName) {
	var el = document.getElementById(elId).getElementsByTagName(tagName);
    
	for (i=0; i<el.length; i++) {
		var imgsrc = el[i].getAttribute("src");
		var imgname = imgsrc.split(".");
		var strlength = (imgname.length)-2;
		var leng = imgname[strlength].length;
		var check = imgname[strlength].substr(leng-3,3);
		
		var cName = el[i].className.indexOf("over_img");
		if (cName != -1 && check != "_on") {
			el[i].parentNode.onfocus = changeOver;
			el[i].parentNode.onblur = changeOut;
			el[i].parentNode.onmouseover = changeOver;
			el[i].parentNode.onmouseout = changeOut;
		}
	}
}
*/
function changeOver() {
	if (this.childNodes[0].src.indexOf(".gif") != -1) {var ext = ".gif";} 
	else if (this.childNodes[0].src.indexOf(".jpg") != -1) {var ext = ".jpg";} 
	else if (this.childNodes[0].src.indexOf(".png") != -1) {var ext = ".png";}

	if (this.childNodes[0].src.indexOf("_on") == -1) {
	this.childNodes[0].src=this.childNodes[0].src.replace(ext, "_on"+ext);
	this.className=this.className.replace("", " on");
	} else {}
}
function changeOut() {
	if (this.childNodes[0].src.indexOf(".gif") != -1) {var ext = ".gif";} 
	else if (this.childNodes[0].src.indexOf(".jpg") != -1) {var ext = ".jpg";} 
	else if (this.childNodes[0].src.indexOf(".png") != -1) {var ext = ".png";}

	this.childNodes[0].src=this.childNodes[0].src.replace( "_on"+ext, ext);
	this.className=this.className.replace(" on", "");
}





// swapImage
function MM_swapImgRestore() { //v3.0
  var i,x,a=document.MM_sr; for(i=0;a&&i<a.length&&(x=a[i])&&x.oSrc;i++) x.src=x.oSrc;
}

function MM_preloadImages() { //v3.0
  var d=document; if(d.images){ if(!d.MM_p) d.MM_p=new Array();
    var i,j=d.MM_p.length,a=MM_preloadImages.arguments; for(i=0; i<a.length; i++)
    if (a[i].indexOf("#")!=0){ d.MM_p[j]=new Image; d.MM_p[j++].src=a[i];}}
}

function MM_findObj(n, d) { //v4.01
  var p,i,x;  if(!d) d=document; if((p=n.indexOf("?"))>0&&parent.frames.length) {
    d=parent.frames[n.substring(p+1)].document; n=n.substring(0,p);}
  if(!(x=d[n])&&d.all) x=d.all[n]; for (i=0;!x&&i<d.forms.length;i++) x=d.forms[i][n];
  for(i=0;!x&&d.layers&&i<d.layers.length;i++) x=MM_findObj(n,d.layers[i].document);
  if(!x && d.getElementById) x=d.getElementById(n); return x;
}

function MM_swapImage() { //v3.0
  var i,j=0,x,a=MM_swapImage.arguments; document.MM_sr=new Array; for(i=0;i<(a.length-2);i+=3)
   if ((x=MM_findObj(a[i]))!=null){document.MM_sr[j++]=x; if(!x.oSrc) x.oSrc=x.src; x.src=a[i+2];}
}

// 쇼 하이드 레이어
function MM_showHideLayers() { //v6.0
  var i,p,v,obj,args=MM_showHideLayers.arguments;
  for (i=0; i<(args.length-2); i+=3) if ((obj=MM_findObj(args[i]))!=null) { v=args[i+2];
    if (obj.style) { obj=obj.style; v=(v=='show')?'visible':(v=='hide')?'hidden':v; }
    obj.visibility=v; }
}

// 새창(항상 위)
function MM_openBrWindow(theURL,winName,features) { //v2.0

  imgwin=window.open(theURL,winName,features);
  imgwin.focus();

}

// 게시판폼 싸이즈조절
function textarea_decrease(id, row){
  
    if (document.getElementById(id).rows - row > 0)
        document.getElementById(id).rows -= row;
}

function textarea_original(id, row){
  
    document.getElementById(id).rows = row;
}

function textarea_increase(id, row){
  
    document.getElementById(id).rows += row;
}


function bt(id,after) 
{ 
eval(id+'.filters.blendTrans.stop();'); 
eval(id+'.filters.blendTrans.Apply();'); 
eval(id+'.src="'+after+'";'); 
eval(id+'.filters.blendTrans.Play();'); 
} 

// 움직이는 퀵메뉴
var isDOM = (document.getElementById ? true : false); 
var isIE4 = ((document.all && !isDOM) ? true : false);
var isNS4 = (document.layers ? true : false);
var isNS = navigator.appName == "Netscape";

function getRef(id) {
	if (isDOM) return document.getElementById(id);
	if (isIE4) return document.all[id];
	if (isNS4) return document.layers[id];
}

function getSty(id) {
	x = getRef(id);
	return (isNS4 ? getRef(id) : getRef(id).style);
}

function setCookie( name, value, expiredays )
{
	var today = new Date();
	today.setDate( today.getDate() + expiredays );
	document.cookie = name + "=" + escape( value ) + "; path=/; expires=" + today.toGMTString() + ";";
}

var scrollerHeight = 372; 
var puaseBetweenImages = 3000;
var imageIdx = 0;

function moveRightEdge() {
	var yMenuFrom, yMenuTo, yOffset, timeoutNextCheck;

	if (isNS4) {
		yMenuFrom   = DivTop.top;
		yMenuTo     = windows.pageYOffset;   // 위쪽 위치
	} else if (isDOM) {
		yMenuFrom   = parseInt (DivTop.style.top, 10);
		yMenuTo     = (isNS ? window.pageYOffset : document.body.scrollTop); // 위쪽 위치
	}
	timeoutNextCheck = 500;

	if (yMenuFrom != yMenuTo) {
		yOffset = Math.ceil(Math.abs(yMenuTo - yMenuFrom) / 20);
		if (yMenuTo < yMenuFrom)
			yOffset = -yOffset;
		if (isNS4)
			DivTop.top += yOffset;
		else if (isDOM)
			DivTop.style.top = parseInt (DivTop.style.top, 10) + yOffset;
			timeoutNextCheck = 10;
	}
	setTimeout ("moveRightEdge()", timeoutNextCheck);
}


// 클릭시 점선없애기
//function bluring(){ 
//if(event.srcElement.tagName=="A"||event.srcElement.tagName=="IMG") document.body.focus(); 
//} 
//document.onfocusin=bluring; 


// flash(파일경로, 가로, 세로, 배경색, 윈도우모드, 변수)
function flash(url,w,h,bg,win,vars){
	var s=
	"<object classid='clsid:d27cdb6e-ae6d-11cf-96b8-444553540000' codebase='http://fpdownload.macromedia.com/pub/shockwave/cabs/flash/swflash.cab#version=8,0,0,0' width='"+w+"' height='"+h+"' align='middle'>"+
	"<param name='movie' value='"+url+"' />"+
	"<param name='wmode' value='"+win+"' />"+
	"<param name='menu' value='false' />"+
	"<param name='quality' value='high' />"+
	"<param name='FlashVars' value='"+vars+"' />"+
	"<param name='bgcolor' value='"+bg+"' />"+
	"<embed src='"+url+"' wmode='"+win+"' menu='false' quality='high' bgcolor='"+bg+"' width='"+w+"' height='"+h+"' align='middle' type='application/x-shockwave-flash' pluginspage='http://www.macromedia.com/go/getflashplayer' />"+
	"</object>";
	document.write(s);
}


// flashWrite(파일경로, 가로, 세로, 아이디, 배경색, 변수)
function flashWrite(url,w,h,id,bg,vars){

	// 플래시 코드 정의
	var flashStr=
	"<object classid='clsid:d27cdb6e-ae6d-11cf-96b8-444553540000' codebase='http://fpdownload.macromedia.com/pub/shockwave/cabs/flash/swflash.cab#version=9,0,0,0' width='"+w+"' height='"+h+"' id='"+id+"' align='middle'>"+
	"<param name='allowScriptAccess' value='always' />"+
	"<param name='movie' value='"+url+"' />"+
	"<param name='FlashVars' value='"+vars+"' />"+
	"<param name='menu' value='false' />"+
	"<param name='quality' value='high' />"+
	"<param name='bgcolor' value='"+bg+"' />"+
	"<param name='wmode' value='transparent' />"+
	"<embed src='"+url+"' FlashVars='"+vars+"' menu='false' scale='false' quality='high' wmode='transparent' bgcolor='"+bg+"' width='"+w+"' height='"+h+"' name='"+id+"' align='middle' allowScriptAccess='always' type='application/x-shockwave-flash' pluginspage='http://www.macromedia.com/go/getflashplayer' />"+
	"</object>";

	// 플래시 코드 출력
	document.write(flashStr);

}


// flashbg(파일경로, 가로, 세로, 아이디, 배경색, 변수)
function flashbg(url,w,h,id,bg,vars){

	// 플래시 코드 정의
	var flashStr=
	"<object classid='clsid:d27cdb6e-ae6d-11cf-96b8-444553540000' codebase='http://fpdownload.macromedia.com/pub/shockwave/cabs/flash/swflash.cab#version=8,0,0,0' width='"+w+"' height='"+h+"' id='"+id+"' align='middle'>"+
	"<param name='allowScriptAccess' value='always' />"+
	"<param name='movie' value='"+url+"' />"+
	"<param name='FlashVars' value='"+vars+"' />"+
	"<param name='menu' value='false' />"+
	"<param name='quality' value='high' />"+
	"<param name='bgcolor' value='"+bg+"' />"+
	"<embed src='"+url+"' FlashVars='"+vars+"' menu='false' quality='high' bgcolor='"+bg+"' width='"+w+"' height='"+h+"' name='"+id+"' align='middle' allowScriptAccess='always' type='application/x-shockwave-flash' pluginspage='http://www.macromedia.com/go/getflashplayer' />"+
	"</object>";

	// 플래시 코드 출력
	document.write(flashStr);

}


// MediaPlayer(파일경로, 가로, 세로, id)
function MediaPlayer(Str1, Str2, Str3, Str4, Str5){
	document.write('<Object classid="clsid:22D6F312-B0F6-11D0-94AB-0080C74C7E95"  codebase="http://activex.microsoft.com/activex/controls/mplayer/en/nsmp2inf.cab#Version=5,1,52,701" type="application/x-oleobject" width="'+Str2+'" height="'+Str3+'" standby="Loading Microsoft?Windows?Media Player components..." id="'+Str4+'">'
	+'<param name="filename" value="'+Str1+'">'
	+'<param name="AutoStart" value="1">'
	+'<param name="showcontrols" value="'+Str5+'">'
	+'<param name="showstatusbar" value="true">'
	+'<param name="enablecontextmenu" value="true">'
	+'</object>');
	}


// 플레이어 제어버튼
function play() {
	player.play();
}
function stop() {
	player.stop();
}
function pause() {
	player.pause();
}

function mute(vol) {
	if (vol == 'off') {
		document.all.on.style.display = "block";
		document.all.off.style.display = "none";
		player.settings.volume = 0 ;
	} else if ( vol == 'on') {
		document.all.off.style.display = "block";
		document.all.on.style.display = "none";
		player.settings.volume = 100 ;
	}
}

function onInitVol()	{
	ey = event.clientY;
	volpy = vol.style.pixelTop;
	
	bDragCheck = true;

	document.onmousemove = onVolumnControl;

	if (document.all) {
		document.onmouseup = new Function('bDragCheck=false');
	}
}

function onVolumnControl() {
	if(bDragCheck)	{

		var mPos = volpy - (ey - event.clientY);
		if (mPos > -30 && mPos < 35) { 
		
			document.all.vol.style.pixelTop = mPos;

			var soundness = (mPos - 34) * -1;

			if (0 < soundness)	{
				player.settings.volume = 37 + soundness;

			} 
			else if (0 >= soundness ) {
				player.settings.volume =  0 ;
			}
		}

		return false;
	}
}


// HTML 로 넘어온 <img ... > 태그의 폭이 테이블폭보다 크다면 테이블폭을 적용한다.
function resizeBoardImage(imageWidth, borderColor) {
    /*
    var content = document.getElementById("writeContents");
    if (content) {
        var target = content.getElementsByTagName("img");
        if (target) {
            var imageHeight = 0;

            for(i=0; i<target.length; i++) { 
                // 원래 사이즈를 저장해 놓는다
                target[i].tmpWidth  = target[i].width;
                target[i].tmpHeight = target[i].height;

                //alert(target[i].width);

                // 이미지 폭이 테이블 폭보다 크다면 테이블폭에 맞춘다
                if(target[i].width > imageWidth) {
                    imageHeight = parseFloat(target[i].width / target[i].height)
                    target[i].width = imageWidth;
                    target[i].height = parseInt(imageWidth / imageHeight);

                    // 스타일에 적용된 이미지의 폭과 높이를 삭제한다
                    target[i].style.width = '';
                    target[i].style.height = '';
                }

                if (borderColor) {
                    target[i].style.borderWidth = '1px';
                    target[i].style.borderStyle = 'solid';
                    target[i].style.borderColor = borderColor;
                }
            }
        }
    }
    */

    var target = document.getElementsByName('target_resize_image[]');
    var imageHeight = 0;

    if (target) {
        for(i=0; i<target.length; i++) { 
            // 원래 사이즈를 저장해 놓는다
            target[i].tmp_width  = target[i].width;
            target[i].tmp_height = target[i].height;
            // 이미지 폭이 테이블 폭보다 크다면 테이블폭에 맞춘다
            if(target[i].width > imageWidth) {
                imageHeight = parseFloat(target[i].width / target[i].height)
                target[i].width = imageWidth;
                target[i].height = parseInt(imageWidth / imageHeight);
                target[i].style.cursor = 'pointer';

                // 스타일에 적용된 이미지의 폭과 높이를 삭제한다
                target[i].style.width = '';
                target[i].style.height = '';
            }

            if (borderColor) {
                target[i].style.borderWidth = '1px';
                target[i].style.borderStyle = 'solid';
                target[i].style.borderColor = borderColor;
            }
        }
    }
}


function drawFont(fontSize) {
    if (!fontSize) {
        fontSize = getFontSize();
    }

    var subject=document.getElementById("writeSubject"); 
    var content=document.getElementById("writeContents"); 
    var comment=document.getElementById("commentContents");
    var wr_subject=document.getElementById("wr_subject");
    var wr_content=document.getElementById("wr_content");

    if (comment) {
        var commentDiv = comment.getElementsByTagName("div");
        var lineHeight = fontSize+Math.round(1.1*fontSize); 
    }

    fontSize = fontSize + "px";

    if (subject)
        subject.style.fontSize=fontSize;
    if (content)
        content.style.fontSize=fontSize; 
    if (wr_subject)
        wr_subject.style.fontSize=fontSize; 
    if (wr_content)
        wr_content.style.fontSize=fontSize; 
    if (commentDiv) {
        for (i=0;i<commentDiv.length;i++) {
            commentDiv[i].style.fontSize=fontSize;
        }
    }
}


function flash_movie(src, ids, width, height, wmode){
    var wh = "";
    if (parseInt(width) && parseInt(height)) 
        wh = " width='"+width+"' height='"+height+"' ";
    return "<object classid='clsid:d27cdb6e-ae6d-11cf-96b8-444553540000' codebase='http://download.macromedia.com/pub/shockwave/cabs/flash/swflash.cab#version=9,0,0,0' "+wh+" id="+ids+"><param name=wmode value="+wmode+"><param name=movie value="+src+"><param name=quality value=high><embed src="+src+" quality=high wmode="+wmode+" type='application/x-shockwave-flash' pluginspage='http://www.macromedia.com/shockwave/download/index.cgi?p1_prod_version=shockwaveflash' "+wh+"></embed></object>";
}

function obj_movie(src, ids, width, height, autostart){
    var wh = "";
    if (parseInt(width) && parseInt(height)) 
        wh = " width='"+width+"' height='"+height+"' ";
    if (!autostart) autostart = false;
    return "<embed src='"+src+"' "+wh+" autostart='"+autostart+"'></embed>";
}

function doc_write(cont){
    document.write(cont);
}
    
// 이미지의 크기에 따라 새창의 크기가 변경됩니다.
// zzzz님께서 알려주셨습니다. 2005/04/12
function image_window(img)
{
    var w = img.tmp_width; 
    var h = img.tmp_height; 
    var winl = (screen.width-w)/2; 
    var wint = (screen.height-h)/3; 

    if (w >= screen.width) { 
        winl = 0; 
        h = (parseInt)(w * (h / w)); 
    } 

    if (h >= screen.height) { 
        wint = 0; 
        w = (parseInt)(h * (w / h)); 
    } 

    var js_url = "<script type='text/javascript'> \n"; 
        js_url += "<!-- \n"; 
        js_url += "var ie=document.all; \n"; 
        js_url += "var nn6=document.getElementById&&!document.all; \n"; 
        js_url += "var isdrag=false; \n"; 
        js_url += "var x,y; \n"; 
        js_url += "var dobj; \n"; 
        js_url += "function movemouse(e) \n"; 
        js_url += "{ \n"; 
        js_url += "  if (isdrag) \n"; 
        js_url += "  { \n"; 
        js_url += "    dobj.style.left = nn6 ? tx + e.clientX - x : tx + event.clientX - x; \n"; 
        js_url += "    dobj.style.top  = nn6 ? ty + e.clientY - y : ty + event.clientY - y; \n"; 
        js_url += "    return false; \n"; 
        js_url += "  } \n"; 
        js_url += "} \n"; 
        js_url += "function selectmouse(e) \n"; 
        js_url += "{ \n"; 
        js_url += "  var fobj      = nn6 ? e.target : event.srcElement; \n"; 
        js_url += "  var topelement = nn6 ? 'HTML' : 'BODY'; \n"; 
        js_url += "  while (fobj.tagName != topelement && fobj.className != 'dragme') \n"; 
        js_url += "  { \n"; 
        js_url += "    fobj = nn6 ? fobj.parentNode : fobj.parentElement; \n"; 
        js_url += "  } \n"; 
        js_url += "  if (fobj.className=='dragme') \n"; 
        js_url += "  { \n"; 
        js_url += "    isdrag = true; \n"; 
        js_url += "    dobj = fobj; \n"; 
        js_url += "    tx = parseInt(dobj.style.left+0); \n"; 
        js_url += "    ty = parseInt(dobj.style.top+0); \n"; 
        js_url += "    x = nn6 ? e.clientX : event.clientX; \n"; 
        js_url += "    y = nn6 ? e.clientY : event.clientY; \n"; 
        js_url += "    document.onmousemove=movemouse; \n"; 
        js_url += "    return false; \n"; 
        js_url += "  } \n"; 
        js_url += "} \n"; 
        js_url += "document.onmousedown=selectmouse; \n"; 
        js_url += "document.onmouseup=new Function('isdrag=false'); \n"; 
        js_url += "//--> \n"; 
        js_url += "</"+"script> \n"; 

    var settings;

    if (g4_is_gecko) {
        settings  ='width='+(w+10)+','; 
        settings +='height='+(h+10)+','; 
    } else {
        settings  ='width='+w+','; 
        settings +='height='+h+','; 
    }
    settings +='top='+wint+','; 
    settings +='left='+winl+','; 
    settings +='scrollbars=no,'; 
    settings +='resizable=yes,'; 
    settings +='status=no'; 


    win=window.open("","image_window",settings); 
    win.document.open(); 
    win.document.write ("<html><head> \n<meta http-equiv='imagetoolbar' CONTENT='no'> \n<meta http-equiv='content-type' content='text/html; charset="+g4_charset+"'>\n"); 
    var size = "이미지 사이즈 : "+w+" x "+h;
    win.document.write ("<title>"+size+"</title> \n"); 
    if(w >= screen.width || h >= screen.height) { 
        win.document.write (js_url); 
        var click = "ondblclick='window.close();' style='cursor:move' title=' "+size+" \n\n 이미지 사이즈가 화면보다 큽니다. \n 왼쪽 버튼을 클릭한 후 마우스를 움직여서 보세요. \n\n 더블 클릭하면 닫혀요. '"; 
    } 
    else 
        var click = "onclick='window.close();' onkeypress='window.close();' style='cursor:pointer' title=' "+size+" \n\n 클릭하면 닫혀요. '"; 
    win.document.write ("<style>.dragme{position:relative;}</style> \n"); 
    win.document.write ("</head> \n\n"); 
    win.document.write ("<body leftmargin=0 topmargin=0 bgcolor=#dddddd style='cursor:arrow;'> \n"); 
    win.document.write ("<table width=100% height=100% cellpadding=0 cellspacing=0><tr><td align=center valign=middle><img src='"+img.src+"' width='"+w+"' height='"+h+"' border=0 class='dragme' "+click+" alt='이미지' /></td></tr></table>");
    win.document.write ("</body></html>"); 
    win.document.close(); 

    if(parseInt(navigator.appVersion) >= 4){win.window.focus();} 
}

function FontPlus()
{ 
	var l = document.getElementById('bbs_content'); 
	var nSize = l.style.fontSize  ? l.style.fontSize  : '9pt'; 
	var iSize = parseInt(nSize.replace('pt','')); 

	if (iSize < 20) 
	{ 
		l.style.fontSize  = (iSize + 1) + 'pt'; 
		l.style.lineHeight = '140%'; 
	} 
} 
function FontMinus() 
{ 
	var l = document.getElementById('bbs_content'); 
	var nSize = l.style.fontSize ? l.style.fontSize : '9pt'; 
	var iSize = parseInt(nSize.replace('pt','')); 

	if (iSize > 6) 
	{ 
		l.style.fontSize = (iSize - 1) + 'pt'; 
		l.style.lineHeight = '140%'; 
	} 
}

/*<!-- Begin
browserName = navigator.appName;
browserVer = parseInt(navigator.appVersion);
ns3up = (browserName == "Netscape" && browserVer >= 3);
ie4up = (browserName.indexOf("Microsoft") >= 0 && browserVer >= 4);

function cnjView(name, img) {
if (ns3up || ie4up) {
img_on = ("" + img); 
document[name].src = img_on;
}
}

// End -->
*/