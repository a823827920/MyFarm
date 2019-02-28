var yy = 1;
$(document).ready(function() {
	$(".in").click(function() {
		if (yy == 1) {
			$(this).attr("style", "filter:grayscale(0);");
			yy = 0;
		} else {
			$(this).attr("style", "filter:grayscale(1);");
			yy = 1;
		}
	});
});
