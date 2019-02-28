var xx = 1;
$(document).ready(function() {
	$(document).on( 'click','#im1',function() {//动态元素捕捉方法，像下面那个函数的写法只能是现有元素
			$(this).attr("style", "filter:grayscale(0);");
			$("#im2").attr("style", "filter:grayscale(1);");
		});
	$(document).on( 'click','#im2',function() {//动态元素捕捉方法，像下面那个函数的写法只能是现有元素
		$(this).attr("style", "filter:grayscale(0);");
		$("#im1").attr("style", "filter:grayscale(1);");
	});
	$("#click").click(function() {
		if (xx == 1) {
			$(".box").attr("style", "right: 0;");
			xx = 0;
		} else {
			$(".box").attr("style", "right:-270px");
			xx = 1;
		}
	});


});
