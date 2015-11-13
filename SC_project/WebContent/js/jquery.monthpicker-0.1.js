/**
 * monthPicker 0.1
 * http://stove99.tistory.com
 * 2011.09.19
 */
String.prototype.string = function(len) { var s = '', i = 0; while (i++ < len) { s += this; } return s; };
String.prototype.zf = function(len) { return "0".string(len - this.length) + this; };
Number.prototype.zf = function(len) { return this.toString().zf(len); };

(function($){
	$.fn.monthPicker = function(opt){
		var CID = $("#CID").val();
		var cate1 = $("#cate1").val();
		var cate2 = $("#cate2").val();
		var cate3 = $("#cate3").val();
		var cate4 = $("#cate4").val();
		var input = null;
		var curYear = null;
		var pop = $("<div><div class='year'><span><a class='changeYear' data-amount='-1'>◀</a></span><strong id='curYear'></strong><span><a class='changeYear' data-amount='1'>▶</a></span></div><ul id='monthList'></ul></div>").addClass("monthPicker");
		var monthList = pop.find("#monthList");

		for( var idx=1; idx<=12; idx++ ) monthList.append($("<li><a></a></li>").data("month", idx).find("a").text(idx+"월").parent());

		pop.css({
			position : "absolute",
			top : this.offset().top+this.outerHeight()+2,
			left : this.offset().left,
			background : "#fff"
		});
		
		$("body").append(pop);

		
		this.click(function(){
			input = $(this);
			curYear = $(this).val().split("-").length==2 ? $(this).val().split("-")[0] : new Date().getFullYear();
			$("#curYear").text(curYear+"년");
			
			pop.css({
				top : $(this).offset().top+$(this).outerHeight()+10,
				left : $(this).offset().left-155
			});
			pop.show();
		});
		
		pop.mouseleave(function(){
			pop.hide();
		});
		
		pop.find(".changeYear").click(function(){
			curYear = parseInt(curYear,10) + parseInt($(this).data("amount"), 10);
			$("#curYear").text(curYear+"년");
		});
		
		pop.find("#monthList li").click(function(){
			input.val(curYear + "-" + $(this).data("month").zf(2));
			pop.hide();
			location.href="./SubPage.php?CID="+CID+"&y="+curYear+"&m="+$(this).data("month").zf(2)+"&cate1="+cate1+"&cate2="+cate2+"&cate3="+cate3+"&cate4="+cate4+"";
		});
	};
})(jQuery);