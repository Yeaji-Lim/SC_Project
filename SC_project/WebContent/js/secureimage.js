String.prototype.trim = function() {
	return this.replace(/^\s+/, '').replace(/\s+$/, '');
}
String.prototype.blank = function() {
	return /^\s*$/.test(this);
}

function secure_image_reload()
{
	$("#imgSecureImage").attr("src","./SubPage.php?CID=bbs/secureimage_view.php&key="+parseInt(Math.random()*1000000));
}

$(document).ready(function(){
	$("#aImageReload").bind("click",function(){
		secure_image_reload();
		return false;
	});
	
});

// 출력된 캡챠이미지의 키값과 입력한 키값이 같은지 비교한다.
function check_securekey(input_key)
{
    if (typeof(input_key) != 'undefined') {
        var captcha_result = false;
        $.ajax({
            type: 'POST',
            url: './SubPage.php?CID=bbs/secureimage.ajax.php',
            data: {
                'wr_key': input_key.value 
            },
            cache: false,
            async: false,
            success: function(text) {
                captcha_result = text;
            }
        });

        if (captcha_result == 0) {
            alert('자동등록방지 필수입력입니다.\n\n글자가 틀렸거나 입력 횟수가 넘었습니다.\n\n이미지를 클릭하여 다시 입력해 주십시오.');
            input_key.select();
            return false;
        }
    }
    return true;
}