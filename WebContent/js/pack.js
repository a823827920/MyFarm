var xx = 1,
	yy = 1,
	zz = 1;
$(document).ready(function() {
	$(document).on('click', '#pack', function() {
		if (yy == 1) {
			$(".pack_show").attr("style", "opacity:1;z-index:1002;");
			$(this).attr("style", " box-shadow: 0px 0px 1px 8px #10cbbc;");
			yy = 0;
		} else {
			$(".pack_show").attr("style", "opacity:0;z-index:-1;");
			$(this).attr("style", " box-shadow: none;");
			yy = 1;
		}
	});
	$(document).on('click', '#pack1', function() {
		if (zz == 1) {
			$(".pack_show2").attr("style", "opacity:1;position:fixed;z-index:1002;");
			$(this).attr("style", " box-shadow: 0px 0px 1px 8px #10cbbc;");
			zz = 0;
		
		} else {
			$(".pack_show2").attr("style", "opacity:0");
			$(this).attr("style", " box-shadow: none;");
			zz = 1;
		}
	});
});
jQuery(function() {
	var top = 490;
	$(window).scroll(function() {
		if ($(window).scrollTop() >= top) {
			if (xx == 1) {
				$("#test0").attr("style", "display: inline-block;background-color:#413a10;z-index:1001");
				$(".pack_show2").attr("style", "display:inline-block;position:fixed;");
				xx = 0;
				zz = 1;
				$("#pack1").attr("style", " box-shadow: none;");
				
				$("#test0").animate({
					top: 0
				}, "slow");
			}
		} else {
			$("#test0").attr("style", "display: none;");
			$(".pack_show2").attr("style", "display:none;opacity:1 !important");
			xx = 1;
		}
	}).trigger("scroll");
});
