		layui.use('layer', function() { //独立版的layer无需执行这一句
			var $ = layui.jquery,
				layer = layui.layer; //独立版的layer无需执行这一句

			//触发事件
			var active = {
				offset: function(othis) {
					var type = othis.data('type'),
						text = othis.text(),
						tt = othis.data('url');

					layer.open({
						type: 1,
						offset: 'auto' //具体配置参考：http://www.layui.com/doc/modules/layer.html#offset
							,
						title: false,
						id: 'layerDemo' + type //防止重复弹出
							,
						content: '<ul><li>1</li><li>2</li></ul>',
						//						btn: '关闭全部',
						btnAlign: 'c' //按钮居中
							,
						shade: [0.8, '#393D49'] //显示遮罩
							,
						area: '400px',
						yes: function() {
							layer.closeAll();
						}
					});
				}
			};
			$('.czstore').on('click', function() {
				var othis = $(this),
					method = othis.data('method');
				active[method] ? active[method].call(this, othis) : '';
			});

		});