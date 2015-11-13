// 탑메뉴 스크립트
	var nowMenuId=0;
	var nowSubId=0;
	var oldMenuId=0;
	function onMenu(id,sid){
		
		if (nowMenuId == 0){
			var newimg = "img"+id;
			if(sid) var newsimg = "s"+id+"simg"+sid;
			var newsubmenu = "submenu"+id;
			//alert(newimg);
			//alert(newsubmenu);
			if(id) document.getElementById(newsubmenu).style.visibility = "visible";				
			//document.getElementById(newimg).src = "./image/common/topmenu/"+newimg+"_on.png";
			//if(sid) document.getElementById(newsimg).src = "./image/common/topmenu/sub"+id+"_"+sid+"_on.png";
		}else{ 
			var img = "img"+nowMenuId;
			var submenu = "submenu"+nowMenuId;
			document.getElementById(submenu).style.visibility = "hidden";				
			//document.getElementById(img).src = "./image/common/topmenu/"+img+".png";
	 
			var newimg = "img"+id;
			var newsubmenu = "submenu"+id;
			document.getElementById(newsubmenu).style.visibility = "visible";				
			//document.getElementById(newimg).src = "./image/common/topmenu/"+newimg+"_on.png";
	}
	 
	nowMenuId = id;
	return nowMenuId;
	 
	}
	

	function outMenu(id){
	var newimg = "img"+id;
	var newsubmenu = "submenu"+id;
	document.getElementById(newimg).src = "./image/common/topmenu/"+newimg+"_on.png";
	document.getElementById(newsubmenu).style.visibility = "hidden";	
	
	alert(oldMenuId);
	var img = "img"+oldMenuId;
	var submenu = "submenu"+oldMenuId;
	document.getElementById(submenu).style.visibility = "visible";				
	document.getElementById(img).src = "./image/common/topmenu/"+img+".png";
	}
				 
// 탑메뉴 스크립트---