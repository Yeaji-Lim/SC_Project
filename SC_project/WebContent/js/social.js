function goTwitter(msg,url) {
	var href = "http://twitter.com/home?status=" + encodeURI(msg) + " " + url;
	var a = window.open(href, 'twitter', '');
	if ( a ) {
		a.focus();
	}
 }

function goTwitter2(msg) {
	var href = "http://twitter.com/home?status=" + msg;
	var a = window.open(href, 'twitter', '');
	if ( a ) {
		a.focus();
	}
 }
function goMe2Day(msg,url,tag) {
	// var href = "http://me2day.net/posts/new?new_post[body]=" + encodeURI(msg) + " " + encodeURIComponent(url) + "&new_post[tags]=" + encodeURIComponent(tag);
	var href = "http://me2day.net/posts/new?new_post[body]=\"" + encodeURI(msg) + "\":" + url;
	var a = window.open(href, 'me2Day', '');
	if ( a ) {
		a.focus();
	}
}
function goFaceBook(msg,url) {
	var href = "http://www.facebook.com/sharer.php?u=" + url + "&t=" + encodeURIComponent(msg);
	var a = window.open(href, 'facebook', '');
	if ( a ) {
		a.focus();
	}
}

function goFaceBook2(url) {
	var href = "http://www.facebook.com/sharer.php?u=" + url;
	var a = window.open(href, 'facebook', '');
	if ( a ) {
		a.focus();
	}
}

function goFaceBook3(url,image,title,summary) {

	var href = "http://www.facebook.com/sharer.php?s=100&p[url]=" + url + "&p[images][0]=" + image + "&p[title]=" + title + "&p[summary]=" + summary;

	href = href.split("#").join("%23");

	//href = encodeURI(href);

	var a = window.open(href, 'facebook', '');
	if ( a ) {
		a.focus();
	}

}

function goCyWorld(title, thumbnail, summary, writer, url) {
// var href = "http://api.cyworld.com/openscrap/post/v1/?xu=http://ticketmonster.co.kr/html/cyworldConnectToXml.php?no=" + no +"&sid=suGPZc14uNs4a4oaJbVPWkDSZCwgY8Xe";
// var a = window.open(href, 'facebook', 'width=450,height=410');
// if ( a ) {
//  a.focus();
// }
	var href = "http://csp.cyworld.com/bi/bi_recommend_pop.php?url=" + url;
	href += "&title=" + encodeURIComponent(title);
	href += "&thumbnail=" + encodeURIComponent(thumbnail);
	href += "&summary=" + encodeURIComponent(summary);
	href += "&writer=" + encodeURIComponent(writer);
	window.open(href, 'recom_icon_pop', 'width=400,height=364,scrollbars=no,resizable=no');
}
function goYozmDaum(link,prefix,parameter) {
	var href = "http://yozm.daum.net/api/popup/prePost?sourceid=54&link=" + encodeURIComponent(link) + "&prefix=" + encodeURIComponent(prefix) + "&parameter=" + encodeURIComponent(parameter);
	var a = window.open(href, 'yozmSend', 'width=466, height=356');
	if ( a ) {
		a.focus();
	}
}