<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
    <title>登录页面</title>
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <script type="text/javascript" src="js/jquery-2.1.1.min.js"></script>

    <link href="css/login.css" rel='stylesheet' type='text/css' />
    <style>
      #msg{
		    width: 30%;
		    margin: 6px auto;
		    margin-bottom: -10px;
		    color: red;
      }
      #login_img{width:50%}
    </style>
    <script type="text/javascript">
        
    </script>

</head>
<body>
<!-----start-main---->
<div class="main">
    <div class="login-form">
        <h1>登录界面</h1>
        <div class="head">
            <img id="login_img" src="images/login_user.png" alt=""/>
        </div>
        <div id='msg'>${msg}</div>
        <form method="post" action="loginController/login.do">
            <input type="text" class="text" id="UserName" name="UserName" placeholder="请输入用户名" >
            <input type="password" id="password" name="password" placeholder="请输入密码">
           
            <input type="text" id="yzm" name="yzm" placeholder="请输入验证码" style="width: 40%">
            <img id="codeimg" name="codeimg" style="width: 20%;height:30px;" border=0 src="page/login/number.jsp">
            <a href="javascript:reloadImage('page/login/number.jsp')">看不清</a>
            <div id="message" style="font-size: 11px;margin: -20px 0 0 0;position: absolute;"></div>
           
            <div class="submit">
                <input type="submit" onclick="return logincheck()" value="登录" >
                <!-- style="width: 250px;height: 40px;margin-left: 30px;
                               text-align: center;background: #ff9759;color: blue;font-size: 22px;border-radius:10px" -->
            </div>
            <p>
                <a href="<%=basePath%>view/resetpass/reset_fs.jsp">忘记密码?</a>&nbsp;|&nbsp;<a href="page/login/register.jsp">注册</a>
                &nbsp;|&nbsp;<a href="index.jsp">返回首页</a>
            </p>
        </form>
    </div>
</div>
</body>

<script language="javascript" type="text/javascript">
    //更换验证码
    function reloadImage(imgurl){
        var getimagecode=document.getElementById("codeimg");
        getimagecode.src= imgurl + "?id=" + Math.random();
    }

    //验证输入是否正确
    function logincheck(){
        var userName=$("#UserName").val();
        if(userName==""){
            alert("请输入用户名！");
            $("#UserName").focus();
            return false;
        }else{
            var parrern=/^[\u4e00-\u9fa5a-zA-Z_0-9]{1,}$/;
            if(!parrern.test(userName)){
                alert("输入格式有误！");
                $("#UserName").focus();
                return false;
            }
        }
        //验证密码
        var password=$("#password").val();
        if(password==""){
            alert("请输入密码！");
            $("#password").focus();
            return false;
        }/* else{
            if(password.length<6||password.length>12){
                alert("请输入6-12位密码！");
                $("#password").focus();
                return false;
            }
        } */

       
        //验证验证码
        var code=$("#yzm").val();
        if(code==""){
            alert("请输入验证码！");
            $("#yzm").focus();
            return false;
        }
      
    }  
    
 //ajax自动验证验证码的正确性
$(function(){
	    
    	$("#yzm").change(function(){
    		var code=$("#yzm").val();
    		code=$.trim(code);
    		if(code!=""){
	        	var url="loginController/IsExistCode.do";
	        	var args={"yzm":code,"time":new Date()};
	        	$.post(url,args,function(data){
	        		if(data=="0"){
	        			$("#message").html("验证码输入错误");
	        			$("#message").css('color','red');
	        		}if(data=="1"){
	        			$("#message").html("验证码输入正确");
	        			$("#message").css('color','green');
	        		}
	        	
	        	});
    		}
    	});
    });

</script>
</html>

