var xx = 1;
			jQuery(function() {
				var top = 490;
				$(window).scroll(function() {
					if ($(window).scrollTop() >= top) {
						if (xx == 1) {
							$("#test0").attr("style", "display: inline-block;background-color:#413a10;z-index:1001");
							xx = 0;
							$("#test0").animate({
								top: 0
							}, "slow");
						}
					} else {
						$("#test0").attr("style", "display: none;");
						xx = 1;
					}
				}).trigger("scroll");
			});