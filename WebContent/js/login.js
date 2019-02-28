function getXMLHttpRequest(){
    var xmlhttp;
        if (window.XMLHttpRequest) {// code for IE7+, Firefox, Chrome, Opera, Safari
            xmlhttp = new XMLHttpRequest();
        } else {// code for IE6, IE5
            xmlhttp = new ActiveXObject("Microsoft.XMLHTTP");
        }
        return xmlhttp;
}
function returnImg()
{
	var idElement=document.getElementById("userid");
    var id=idElement.value;        
    //1.获取XMLHttpRequest对象
    var req=getXMLHttpRequest();
    //4.处理响应结果               
    //2.建立一个连接
    req.open("get","LoginImgServ?id="+id);
    //3.发送get请求
    req.send(null);
    req.onreadystatechange=function(){
    if(req.readyState==4){//XMLHttpRequest对象读取成功
           if(req.status==200){//服务器相应正常
               var img=document.getElementById("userImg");  
               img.src="img/other_img/"+req.responseText;
                //根据返回的结果显示不同的信息
                /*if(req.responseText=="true"){
                    msg.innerHTML="<font color='red'>已被注册</font>";                   
                  }else{
                        msg.innerHTML="<font color='green'>可以使用</font>";
                    
                     //window.alert(check);
                   }*/
               }
            }
      }
}