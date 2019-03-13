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
                <label class="layui-form-label">土地ID  :</label>
                <div class="layui-input-block">
                    <input type="text" id="field_id" name="field_id" lay-verify="number"  autocomplete="off"  class="layui-input">
                </div>
            </div>
            <div class="layui-form-item">
                <label class="layui-form-label">植物ID  :</label>
                <div class="layui-input-block">
                    <input type="text" id="plant_id" name="plant_id"  disabled="disabled"  autocomplete="off"  class="layui-input">
                </div>
            </div>
            <div class="layui-form-item">
                <label class="layui-form-label">作物名称  :</label>
                <div class="layui-input-block">
                    <input type="text" id="plant_name" name="plant_name" disabled="disabled"  autocomplete="off"  class="layui-input">
                </div>
            </div>
            <div class="layui-form-item">
                <label class="layui-form-label">用户ID  :</label>
                <div class="layui-input-block">
                    <input type="text" id="user_id" name="user_id" disabled="disabled"  autocomplete="off"  class="layui-input">
                </div>
            </div>
            <div class="layui-form-item">
                <label class="layui-form-label">作物重量（kg）:</label>
                <div class="layui-input-block">
                    <input type="text" name="weight" lay-verify="number" autocomplete="off"  class="layui-input">
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
                url: '${pageContext.request.contextPath}/AddCrop',
                type: 'post',
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
                    alert("请填写正确的土地ID！");
                },complete: function () {
                    layer.closeAll('loading');
                }
            });
            return false;
        });
     $("#field_id").blur(function(){
    	 var field_id=$("#field_id").val();
    	 $.ajax({
    		 url:"${pageContext.request.contextPath}/GetRoomInfo?field_id="+field_id,
    		 type:"get",
    		 success:function(data)
    		 {
    			 var obj=eval("("+data+")");
    			 $("#plant_id").val(obj.plant.id);
    			 $("#plant_name").val(obj.plant.name);
    			 $("#user_id").val(obj.user_id);
    		 }
    	 })
     })
    });
</script>

</body>
</html>