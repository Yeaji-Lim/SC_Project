/* 메인 메뉴 시작 */
function displaySub(id) {
	for(i=1 ; i<=6 ; i++) {
		var img = document.getElementById("menu_"+i).getElementsByTagName("img").item(0);
		if( img.src.indexOf("_on.") > -1 ) img.src = img.src.replace("_on.png", ".png");
	
		var sub = document.getElementById("subnav_list"+i);
		if( sub ) {
			sub.style.display="none"

			var imgTag = sub.getElementsByTagName("img");
			for( var j = 0; j < imgTag.length ; j++ ) {
				var imgName = imgTag[j].src;
				if( imgName.indexOf("_on.") > -1 ) imgTag[j].src = imgName.replace("_on.png",".png");
			}
		}
	}

	imgName = document.getElementById("menu_"+id).getElementsByTagName("img").item(0).src;
	if( imgName.indexOf("_on.") < 0 ) {
		document.getElementById("menu_"+id).getElementsByTagName("img").item(0).src = imgName.replace(".png","_on.png");
	}

	if(document.getElementById("subnav_list"+id)) document.getElementById("subnav_list"+id).style.display="block";
}

/* IMG ON/OFF SCRIPT - MOUSEOVER / MOUSEOUT
-------------------------------------------------*/
function menuOver() {
	this.src = this.src.replace(".png", "_on.png");
}
function menuOut() {
	this.src = this.src.replace("_on.png", ".png");
}

function imageOver(anchor) {
	for(i=1 ; i<=6 ; i++) {	
		var sub = document.getElementById("subnav_list"+i);
		if( sub ) {
			var imgTag = sub.getElementsByTagName("img");
			for( var j = 0; j < imgTag.length ; j++ ) {
				var imgName = imgTag[j].src;
				if( imgName.indexOf("_on.") > -1 ) imgTag[j].src = imgName.replace("_on.png",".png");
			}
		}
	}

	var imgEl = anchor.getElementsByTagName("img").item(0);
	if( imgEl.src.indexOf("_on.png") < 0 ) imgEl.src = imgEl.src.replace(".png", "_on.png");
}
function imageOut(anchor) {
	var imgEl = anchor.getElementsByTagName("img").item(0);
	if( imgEl.src.indexOf("_on.png") > -1 ) imgEl.src = imgEl.src.replace("_on.png", ".png");
}



/* Navigation JAVASCRIPT -
-------------------------------------------------*/

/* Global Navigation JAVASCRIPT - 이미지 on/off
-------------------------------------------------*/
function initGNavigation() {
	// change top menu text to image
	topMenuEl = document.getElementById("gnavigation").getElementsByTagName("li");
	for (i=0; i<topMenuEl.length; i++) {
		var menuAnchor = topMenuEl[i].getElementsByTagName("a")[0];
		menuAnchor.innerHTML = "<img src=\"/open_content/img/navigation/gnavigation/" + topMenuEl[i].className + ".png\" alt=\"" + menuAnchor.innerHTML + "\"/>";
	}
}


/* Sub Navigation JAVASCRIPT - 이미지 on/off
-------------------------------------------------*/
function initSNavigation() {
	subMenuEl = document.getElementById("snavigation").getElementsByTagName("li");
	for (i=0; i<subMenuEl.length; i++) {
		var menuAnchor = subMenuEl[i].getElementsByTagName("a")[0];

		if( menuAnchor.getElementsByTagName("img").item(0) ) {
			//menuAnchor.innerHTML = "<img src=\"/open_content/img/navigation/sub/" + subMenuEl[i].className + ".png\" alt=\"" + menuAnchor.innerHTML + "\" />";
			menuAnchor.getElementsByTagName("img").item(0).onmouseover = menuOver;
			menuAnchor.getElementsByTagName("img").item(0).onmouseout = menuOut;
		}
	}
}
/* Side Navigation Depth5 JAVASCRIPT - 이미지 on/off
-------------------------------------------------*/
var old_menu5 = '';
function menuclick5(depth5) {
    if( old_menu5 != depth5 ) {
		if( old_menu5 !='' ) {
			document.getElementById(old_menu5).style.display = 'none';
		}
    
		document.getElementById(depth5).style.display = 'block';
		old_menu3 = depth5;
    } else {
        document.getElementById(depth5).style.display = 'none';
        old_menu3 = '';
    }
}

/* Side Navigation Depth4 JAVASCRIPT - 이미지 on/off
-------------------------------------------------*/
var old_menu = '';
function menuclick(depth4) {
    if( old_menu != depth4 ) {
		if( old_menu !='' ) {
			document.getElementById(old_menu).style.display = 'none';
		}
    
		document.getElementById(depth4).style.display = 'block';
		old_menu = depth4;
    } else {
        document.getElementById(depth4).style.display = 'none';
        old_menu = '';
    }
}

/* Side Navigation Depth3 JAVASCRIPT - 이미지 on/off
-------------------------------------------------*/
var old_menu3 = '';
function menuclick3(depth3) {
    if( old_menu3 != depth3 ) {
		if( old_menu3 !='' ) {
			document.getElementById(old_menu3).style.display = 'none';
		}
    
		document.getElementById(depth3).style.display = 'block';
		old_menu3 = depth3;
    } else {
        document.getElementById(depth3).style.display = 'none';
        old_menu3 = '';
    }
}


/* Navigation JAVASCRIPT -
-------------------------------------------------*/


/* Global Navigation Action JAVASCRIPT 
-------------------------------------------------*/
var currentMenu;	// current shown menu (mouse over)
var focusMenu;	// current page menu
var menu = new Array();	// each menu array

function initNavigation(seq) {
	for(i=1; i<6; i++) {
		menu[i] = document.getElementsBySelector("#gnavigation li.menu0" + i)[0];
		//menu[i].onmouseover = navigationOver;
		//menu[i].onfocus = navigationOver;
		//menu[i].onmouseout = navigationOut;
		//menu[i].onblur = navigationOut;

		menu[i].submenu = document.getElementsBySelector("#gnavigation li.menu0" + i +" ul.depth2")[0];
		menu[i].submenu.menu = menu[i];
		menu[i].submenu.onmouseover = subOver;
		menu[i].submenu.onfocus = subOver;
	}
}
function initFocus() {		// current page menu focusing
	if (focusMenu) {
		currentMenu = focusMenu;
	} else {
		currentMenu = null;
	}
	showSubmenu();
}
function navigationOver() {		// onmouseover
	hideSubmenu();
	if (focusMenu) {
		focusMenu.submenu.style.display = "none";
	}
	currentMenu = this;
	showSubmenu();
}
function navigationOut() {		// onmouseout
	this.isMenuOver = false;
	setTimeout("hideSubmenu()", 500);
}
function showSubmenu() {
	if (currentMenu) {
		currentMenu.submenu.style.display = "block";
		currentMenu.isMenuOver = true;
	}
}
function hideSubmenu() {
	if (currentMenu && !currentMenu.isMenuOver) {
		currentMenu.submenu.style.display = "none";
		currentMenu.isMenuOver = false;
		initFocus();
	}
}
function subOver() {
	this.menu.isMenuOver = true;
}


/* Location Current JAVASCRIPT -
-------------------------------------------------*/
function initLocation(col) {
	initNavigation();

	if (document.getElementById("location")) {
		loc = document.getElementById("location").getElementsByTagName("a");

		var num = 0;

		//header - 1depth menu
		for( var i = 1; i <= 6 ; i++ ) {
			var topMenuAlt = document.getElementById("menu_" + i).getElementsByTagName("img").item(0).alt;

			if( topMenuAlt == loc.item(1).innerHTML ) {
				displaySub(i);
				num=i;
				break;
			}
		}

		//header - 2depth menu
		if( num > 0 && loc.item(2) ) {
			var subNav = document.getElementById("subnav_list" + num).getElementsByTagName("li");

			for( var i = 0 ; subNav && i < subNav.length ; i++ ) {
				var topMenuAlt = subNav[i].getElementsByTagName("img").item(0).alt;

				if( topMenuAlt == loc.item(2).innerHTML ) {
					var subImg = subNav[i].getElementsByTagName("img").item(0);
					subImg.src = subImg.src.replace(".png", "_on.png");
					break;
				}
			}
		}

		if (document.getElementById("snavigation") && document.getElementById("snavigation").getElementsByTagName("li")) {
			subMenuLi = document.getElementById("snavigation").getElementsByTagName("li");

			for(i=0; i<subMenuLi.length; i++) {
				if( subMenuLi[i].getElementsByTagName("img").item(0) ) {
					subMenuText = subMenuLi[i].getElementsByTagName("img").item(0).alt;
					if (loc.item(2) && subMenuText == loc.item(2).innerHTML) {		// sub menu depth2
						if(subMenuLi[i].getElementsByTagName("img").item(0).src.indexOf("_on.png") == -1) {
							subMenuLi[i].getElementsByTagName("img").item(0).onmouseover();
						}
						subMenuLi[i].getElementsByTagName("img").item(0).onmouseover = null;
						subMenuLi[i].getElementsByTagName("img").item(0).onmouseout = null;

						//3depth
						if (subMenuLi[i].getElementsByTagName("ul").item(0)) {
							subMenuLi[i].getElementsByTagName("ul").item(0).style.display = "block";

							subMenuLi2 = subMenuLi[i].getElementsByTagName("ul").item(0).getElementsByTagName("li");
							for(var j = 0 ; j < subMenuLi2.length ; j++ ) {
								subMenuText = subMenuLi2[j].getElementsByTagName("a").item(0).innerHTML;

								if (loc.item(3) && subMenuText == loc.item(3).innerHTML) {		// sub menu depth3
									subMenuLi2[j].getElementsByTagName("a").item(0).style.color = col;

									//4depth
									if (subMenuLi2[j].getElementsByTagName("ul").item(0)) {
										subMenuLi2[j].getElementsByTagName("ul").item(0).style.display = "block";

										subMenuLi3 = subMenuLi2[j].getElementsByTagName("ul").item(0).getElementsByTagName("li");
										for(var k = 0 ; k < subMenuLi3.length ; k++ ) {
											subMenuText = subMenuLi3[k].getElementsByTagName("a").item(0).innerHTML;

											if (loc.item(4) && subMenuText == loc.item(4).innerHTML) {	
												subMenuLi3[k].getElementsByTagName("a").item(0).style.color = col;

												//5depth
												if( subMenuLi3[k].getElementsByTagName("ul").item(0) ) {
													subMenuLi3[k].getElementsByTagName("ul").item(0).style.display = "block";
													subMenuLi4 = subMenuLi3[k].getElementsByTagName("ul").item(0).getElementsByTagName("li");
													for( var l = 0 ; l < subMenuLi4.length; l++ ) {
														subMenuText = subMenuLi4[l].getElementsByTagName("a").item(0).innerHTML;

														if( loc.item(5) && subMenuText == loc.item(5).innerHTML ) {
															subMenuLi4[l].getElementsByTagName("a").item(0).style.color = col;
														}
													}
													i += l - 1;
												}
											}
										}
										i += k - 1;
									}
								}
							}
							i += j - 1;
						}
					}
				}
			}
		}
	}
}

function getAllChildren(e) {
	// Returns all children of element. Workaround required for IE5/Windows. Ugh.
	return e.all ? e.all : e.getElementsByTagName('*');
}

document.getElementsBySelector = function(selector) {
	// Attempt to fail gracefully in lesser browsers
	if (!document.getElementsByTagName) {
		return new Array();
	}
	// Split selector in to tokens
	var tokens = selector.split(' ');
	var currentContext = new Array(document);
	for (var i = 0; i < tokens.length; i++) {
		token = tokens[i].replace(/^\s+/,'').replace(/\s+$/,'');;
		if (token.indexOf('#') > -1) {
			// Token is an ID selector
			var bits = token.split('#');
			var tagName = bits[0];
			var id = bits[1];
			var element = document.getElementById(id);
			if (tagName && element.nodeName.toLowerCase() != tagName) {
				// tag with that ID not found, return false
				return new Array();
			}
			// Set currentContext to contain just this element
			currentContext = new Array(element);
			continue; // Skip to next token
		}
		if (token.indexOf('.') > -1) {
			// Token contains a class selector
			var bits = token.split('.');
			var tagName = bits[0];
			var className = bits[1];
			if (!tagName) {
				tagName = '*';
			}
			// Get elements matching tag, filter them for class selector
			var found = new Array;
			var foundCount = 0;
			for (var h = 0; h < currentContext.length; h++) {
				var elements;
				if (tagName == '*') {
						elements = getAllChildren(currentContext[h]);
				} else {
						elements = currentContext[h].getElementsByTagName(tagName);
				}
				for (var j = 0; j < elements.length; j++) {
					found[foundCount++] = elements[j];
				}
			}
			currentContext = new Array;
			var currentContextIndex = 0;
			for (var k = 0; k < found.length; k++) {
				if (found[k].className && found[k].className.match(new RegExp('\\b'+className+'\\b'))) {
					currentContext[currentContextIndex++] = found[k];
				}
			}
			continue; // Skip to next token
		}
		// Code to deal with attribute selectors
		if (token.match(/^(\w*)\[(\w+)([=~\|\^\$\*]?)=?"?([^\]"]*)"?\]$/)) {
			var tagName = RegExp.$1;
			var attrName = RegExp.$2;
			var attrOperator = RegExp.$3;
			var attrValue = RegExp.$4;
			if (!tagName) {
				tagName = '*';
			}
			// Grab all of the tagName elements within current context
			var found = new Array;
			var foundCount = 0;
			for (var h = 0; h < currentContext.length; h++) {
				var elements;
				if (tagName == '*') {
						elements = getAllChildren(currentContext[h]);
				} else {
						elements = currentContext[h].getElementsByTagName(tagName);
				}
				for (var j = 0; j < elements.length; j++) {
					found[foundCount++] = elements[j];
				}
			}
			currentContext = new Array;
			var currentContextIndex = 0;
			var checkFunction; // This function will be used to filter the elements
			switch (attrOperator) {
				case '=': // Equality
					checkFunction = function(e) { return (e.getAttribute(attrName) == attrValue); };
					break;
				case '~': // Match one of space seperated words 
					checkFunction = function(e) { return (e.getAttribute(attrName).match(new RegExp('\\b'+attrValue+'\\b'))); };
					break;
				case '|': // Match start with value followed by optional hyphen
					checkFunction = function(e) { return (e.getAttribute(attrName).match(new RegExp('^'+attrValue+'-?'))); };
					break;
				case '^': // Match starts with value
					checkFunction = function(e) { return (e.getAttribute(attrName).indexOf(attrValue) == 0); };
					break;
				case '$': // Match ends with value - fails with "Warning" in Opera 7
					checkFunction = function(e) { return (e.getAttribute(attrName).lastIndexOf(attrValue) == e.getAttribute(attrName).length - attrValue.length); };
					break;
				case '*': // Match ends with value
					checkFunction = function(e) { return (e.getAttribute(attrName).indexOf(attrValue) > -1); };
					break;
				default :
					// Just test for existence of attribute
					checkFunction = function(e) { return e.getAttribute(attrName); };
			}
			currentContext = new Array;
			var currentContextIndex = 0;
			for (var k = 0; k < found.length; k++) {
				if (checkFunction(found[k])) {
					currentContext[currentContextIndex++] = found[k];
				}
			}
			// alert('Attribute Selector: '+tagName+' '+attrName+' '+attrOperator+' '+attrValue);
			continue; // Skip to next token
		}
		// If we get here, token is JUST an element (not a class or ID selector)
		tagName = token;
		var found = new Array;
		var foundCount = 0;
		for (var h = 0; h < currentContext.length; h++) {
			var elements = currentContext[h].getElementsByTagName(tagName);
			for (var j = 0; j < elements.length; j++) {
				found[foundCount++] = elements[j];
			}
		}
		currentContext = found;
	}
	return currentContext;
}

/* TAB MENU SCRIPT
-------------------------------------------------*/
function initTabMenu(tabContainerID) {
	var tabContainer = document.getElementById(tabContainerID);
	var tabAnchor = tabContainer.getElementsByTagName("a");
	var i = 0;

	for(i=0; i<tabAnchor.length-1; i++) {
		thismenu = tabAnchor.item(i);

		thismenu.container = tabContainer;
		thismenu.targetEl = document.getElementById(tabAnchor.item(i).href.split("#")[1]);
		thismenu.targetEl.style.display = "none";
		thismenu.imgEl = thismenu.getElementsByTagName("img").item(0);
		thismenu.onclick = function tabMenuClick() {
			currentmenu = this.container.current;
			if (currentmenu == this)
				return false;

			if (currentmenu) {
				currentmenu.targetEl.style.display = "none";
				if (currentmenu.imgEl) {
					currentmenu.imgEl.src = currentmenu.imgEl.src.replace("_on.png", ".png");
				} else {
					currentmenu.className = currentmenu.className.replace(" on", "");
				}
			}
			this.targetEl.style.display = "";
			if (this.imgEl) {
				this.imgEl.src = this.imgEl.src.replace(".png", "_on.png");
			} else {
				this.className += " on";
			}
			this.container.current = this;

			return false;
		};

		if(!thismenu.container.first)
			thismenu.container.first = thismenu;
	}
	if (tabContainer.first)
		tabContainer.first.onclick();
}

function initTabMenu2(tabContainerID) {
        var tabContainer = document.getElementById(tabContainerID);
        var tabAnchor = tabContainer.getElementsByTagName("a");
        var i = 0;
 
        for(i=0; i<tabAnchor.length; i++) {
                thismenu = tabAnchor.item(i);
 
                thismenu.container = tabContainer;
                thismenu.targetEl = document.getElementById(tabAnchor.item(i).href.split("#")[1]);
                thismenu.targetEl.style.display = "none";
                thismenu.imgEl = thismenu.getElementsByTagName("img").item(0);
                thismenu.onclick = function tabMenuClick() {
                        currentmenu = this.container.current;
                        if (currentmenu == this)
                                return false;
 
                        if (currentmenu) {
                                currentmenu.targetEl.style.display = "none";
                                if (currentmenu.imgEl) {
                                        currentmenu.imgEl.src = currentmenu.imgEl.src.replace("_on.png", ".png");
                                } else {
                                        currentmenu.className = currentmenu.className.replace(" on", "");
                                }
                        }
                        this.targetEl.style.display = "";
                        if (this.imgEl) {
                                this.imgEl.src = this.imgEl.src.replace(".png", "_on.png");
                        } else {
                                this.className += " on";
                        }
                        this.container.current = this;
 
                        return false;
                };
 
                if(!thismenu.container.first)
                        thismenu.container.first = thismenu;
        }
        if (tabContainer.first)
                tabContainer.first.onclick();
}

function tabMenuClick() {

	currentmenu = this.menuContainer.current;

	if (currentmenu != this) {

		currentmenu.targetEl.style.display = "none";

		currentmenu.getElementsByTagName("img").item(0).onmouseover = menuOver;

		currentmenu.getElementsByTagName("img").item(0).onmouseout = menuOut;

		currentmenu.getElementsByTagName("img").item(0).onmouseout();



		this.targetEl.style.display = "block";

		this.getElementsByTagName("img").item(0).onmouseover = null;

		this.getElementsByTagName("img").item(0).onmouseout = null;

		this.menuContainer.current = this;

	}

	return false;
}

//슬라이딩메뉴//
function initMoving(target, topPosition, topLimit, btmLimit) {
	if (!target)
		return false;

	var obj = target;
	obj.initTop = topPosition;
	obj.topLimit = topLimit;
	obj.bottomLimit = document.documentElement.scrollHeight - btmLimit;

	obj.style.position = "absolute";
	obj.top = obj.initTop;
	obj.left = obj.initLeft;
	obj.style.top = obj.top + "px";

	obj.getTop = function() {
		if (document.documentElement.scrollTop) {
			return document.documentElement.scrollTop;
		} else if (window.pageYOffset) {
			return window.pageYOffset;
		} else {
			return 0;
		}
	}
	obj.getHeight = function() {
		if (self.innerHeight) {
			return self.innerHeight;
		} else if(document.documentElement.clientHeight) {
			return document.documentElement.clientHeight;
		} else {
			return 500;
		}
	}
	obj.move = setInterval(function() {
		//pos = obj.getTop() + obj.getHeight() / 2 - 15;
		pos = obj.getTop() + topPosition;

		if (pos > obj.bottomLimit)
			pos = obj.bottomLimit
		if (pos < obj.topLimit)
			pos = obj.topLimit

		interval = obj.top - pos;
		obj.top = obj.top - interval / 3;
		obj.style.top = obj.top + "px";
	}, 30)
}



