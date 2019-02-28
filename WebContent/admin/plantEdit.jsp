<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="${pageContext.request.contextPath}/layui/css/layui.css"  media="all">
<script type="text/javascript" src="${pageContext.request.contextPath}/js/jquery.js"></script>
<script src="${pageContext.request.contextPath}/layui/layui.js" charset="utf-8"></script>
</head>
<body>
<fieldset class="layui-elem-field layui-field-title ">
    <legend><li id="icon" class="layui-icon layui-icon-face-smile layui-anim layui-anim-rotate " style="font-size: 30px; color: #1E9FFF;" data-anim="layui-anim-rotate"></li> <span style="font-size: 8px">我在等风，也在等你</span></legend>
    <br>
    <div class="layui-field-box" style="width: 97%">
        <form class="layui-form" action="" method="get">
            <div class="layui-form-item">
                <label class="layui-form-label">植物ID  :</label>
                <div class="layui-input-block">
                    <input type="text" name="id" disabled="disabled"  autocomplete="off"  class="layui-input">
                </div>
            </div>
            <div class="layui-form-item">
                <label class="layui-form-label">植物名:</label>
                <div class="layui-input-block">
                    <input type="text" name="name" lay-verify="required" autocomplete="off" class="layui-input">
                </div>
            </div>
            <div class="layui-form-item">
                <label class="layui-form-label">库存 ：</label>
                <div class="layui-input-block">
                    <input type="text" name="stock" lay-verify="number" autocomplete="off" class="layui-input">
                </div>

            </div>
            <div class="layui-form-item">
                <label class="layui-form-label">售价 ：</label>
                <div class="layui-input-block">
                    <input type="text" name="salePrice"  lay-verify="number" autocomplete="off" class="layui-input">
                </div>
            </div>
            <div class="layui-form-item">
                <label class="layui-form-label">描述 ：</label>
                <div class="layui-input-block">
                    <input type="text" name="des"  lay-verify="required" autocomplete="off" class="layui-input">
                </div>
            </div>
            <div class="layui-form-item">
                <label class="layui-form-label">进价 ：</label>
                <div class="layui-input-block">
                    <input type="text" name="orderPrice"  lay-verify="number" autocomplete="off" class="layui-input">
                </div>
            </div>
            <div class="layui-form-item">
                <label class="layui-form-label">类别 ：</label>
                <div class="layui-input-block">
                    <input type="text" name="cate_id"  lay-verify="numer" autocomplete="off" class="layui-input">
                </div>
            </div>
            <div class="layui-form-item">
            	<label class="layui-form-label">图片名 ：</label>
                <div class="layui-input-block">
                    <input type="text" name="img" id="img" disabled="disabled"  autocomplete="off" class="layui-input">
                </div>
            </div>
            <div class="layui-upload" style="margin-left:25%">
			  <button type="button" class="layui-btn" id="test1">上传图片</button>
			  <div class="layui-upload-list">
			    <img class="layui-upload-img" style="width:150px;height:150px" id="demo1" src="">
			    <p id="demoText"></p>
			  </div>
			</div>
            <br><br>
            <div class="layui-form-item">
                <div class="layui-input-block" >
                    <button class="layui-btn" lay-submit="" lay-filter="formDemo">立即提交</button>
                </div>
            </div>
        </form>
    </div>

</fieldset>
<!-- 注意：如果你直接复制所有代码到本地，上述js路径需要改成你本地的 -->
<script>
    
    layui.use(['form', 'layedit', 'laydate','upload'], function(){
    	var form = layui.form
        ,layer = layui.layer
        ,layedit = layui.layedit
        ,laydate = layui.laydate;
        //自定义验证规则  对应：lay-verify="menuSort"
        form.verify({
            
        });

        //注意：parent 是 JS 自带的全局对象，可用于操作父页面
        var index = parent.layer.getFrameIndex(window.name); //获取窗口索引
        //监听提交
        form.on('submit(formDemo)', function(data){
            var $=layui.$;
            $.ajax({
                url: '${pageContext.request.contextPath}/UpdatePlant',
                type: 'get',
                async:false,
                data: {
                	map: JSON.stringify(data.field)
                } ,
                dataType: 'json',
                success: function(result){
                    if(result=='1'){
                        layer.msg('操作成功....', {icon: 6});
                        setTimeout(function(){
                            parent.layer.close(index);
                            parent.layui.table.reload('demo');
                        }, 1000);
                    }else{
                        layer.msg('操作失败', {icon: 5});
                    }
                } ,
                error: function(){
                    alert("网络忙，请稍后重试！");
                },complete: function () {
                    layer.closeAll('loading');
                }
            });
            return false;
        });
        var $ = layui.jquery
        ,upload = layui.upload;
        
        
      //普通图片上传
        var uploadInst = upload.render({
          elem: '#test1'
          ,url: '${pageContext.request.contextPath}/Upload'
          ,before: function(obj){
        	  
            //预读本地文件示例，不支持ie8
            obj.preview(function(index, file, result){
              $('#demo1').attr('src', result); //图片链接（base64）
            });
          }
          ,done: function(res){
        	  $("[name=img]").val(res.data);
            //如果上传失败
            if(res.code > 0){
              return layer.msg('上传失败');
            }
            //上传成功
          }
          ,error: function(){
            //演示失败状态，并实现重传
            var demoText = $('#demoText');
            demoText.html('<span style="color: #FF5722;">上传失败</span> <a class="layui-btn layui-btn-xs demo-reload">重试</a>');
            demoText.find('.demo-reload').on('click', function(){
              uploadInst.upload();
            });
          }
        });
    });
</script>

</body>
</html>