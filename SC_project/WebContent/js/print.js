// Page Print
function New_PagePrint(print_content){
    if (confirm('프린트를 하실려면 새창을 띄우셔야합니다. 계속하시겠습니까?'))
    {
        var objWin = window.open('', 'printerWindow', 'width=780,height=600,resizable=no,scrollbars=yes,toolbar=no,menubar=no');
        var strHtml = '';
		strHtml += "<!DOCTYPE html PUBLIC '-//W3C//DTD XHTML 1.0 Transitional//EN' 'http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd'>\n";
		strHtml += "<html xmlns='http://www.w3.org/1999/xhtml' xml:lang='kr' lang='kr'>\r\n";
		strHtml += "<head>\r\n";
		strHtml += "<meta http-equiv='Content-Type' content='text/html; charset=utf-8' />\r\n";
        strHtml += "<meta http-equiv='Content-Script-Type' content='text/javascript' />\r\n";
        strHtml += "<meta http-equiv='Content-Style-Type' content='text/css' />\r\n";
        strHtml += "<meta http-equiv='X-UA-Compatible' content='IE=edge' />\r\n";
		strHtml += "<title>페이지프린트</title>\r\n";
		strHtml += "<link rel='stylesheet' href='./css/main.css' type='text/css'/>\r\n";
		strHtml += "<link rel='stylesheet' href='./css/bbs.css' type='text/css'/>\r\n";
		strHtml += "<link rel='stylesheet' href='./css/topmenu.css' type='vtext/css'/>\r\n";
		strHtml += "</head>\r\n";
        strHtml += "<body onload='javascript:print()'>\r\n";
        strHtml += "<div class='printTop'>\r\n";
        strHtml += "    <a href='#print' onclick='javascript:print()'><img src='image/common/print_img02.gif' alt='프린트' border='0' /></a>\r\n";
        strHtml += "</div>\r\n";
        strHtml += "<div class='printContainer'>\r\n";
        strHtml += document.getElementById(print_content).innerHTML;
        strHtml += "</div>\r\n";
        strHtml += " <div class='printBottom'>\r\n";
        strHtml += "    <a href='javascript:window.close();'><img src='image/common/btn_close01.gif' alt='닫기' /></a>\r\n";
        strHtml += "</div>\r\n";
        strHtml += "</body>\r\n";
        strHtml += "</html>\r\n";
        objWin.document.open();
        objWin.document.write(strHtml);
        objWin.document.close();
    }
}