<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();

String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    <title>注册页面</title>
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
    <script type="text/javascript" src="js/jquery-2.1.1.min.js"></script>
    <script src="js/register/register1.js"></script>
    <script type="text/javascript" src="layui-v2.1.2/layui/layui.js"></script>
    <link rel="stylesheet" href="css/register.css" type="text/css"/>
    <script type="text/javascript"></script>

</head>
<body>
   <div id="div_all">
       <div id="imgbox">
           <div id="loginbox"><font color="red"> 已经注册了？请点击</font>&nbsp;&nbsp;&nbsp;<a href="page/login/login.jsp">登录</a></div>
       </div>
       <div id="tishibox">
           <br>
           <p>填写注册信息提示：</p>
           <p><font color="red">*</font>&nbsp;用户名由汉字、字母、数字或下划线组成,不能包含其他特殊符号</p>
           <p><font color="red">*</font>&nbsp;密码由6-12位字符组成,建议使用复杂密码</p>
           <p><font color="red">*</font>&nbsp;确认密码和密码须保持一致</p>
           <p><font color="red">*</font>&nbsp;邮箱为重要通讯方式，请如实填写</p>
       </div>

       <div id="xinxi">
          <form action="RegisterController/userRegister.do" method="post" onsubmit="return check()">
               <!--label聚焦--for属性中用id-->
           <table  id="table1" cellspacing="10">
               <tr align="center">
                   <td colspan="3" style="color:#0776ec">请输入注册信息</td>
               </tr>
               <tr align="center">
                   <td colspan="3" style="color:#ff5e6a">${msg}</td>
               </tr>
               <tr>
                   <td><label for="userName">用户名：</label></td>
                   <td><input type="text" id="userName" name="loginName" class="inp">
                       <div id="message" style="font-size: 11px"></div>
                          <!-- onfocus="register('userName')" onblur="register1('userName')"-->
                   </td>

               </tr>
               <tr>
                   <td><label for="password">密 码：</label></td>
                   <td><input type="password" id="password" name="password" class="inp"></td>

               </tr>
               <tr>
                   <td><label for="password1">确认密码：</label></td>
                   <td><input type="password" id="password1" name="password1" class="inp"/></td>

               </tr>

               <tr>
                   <td><label for="email">邮箱：</label></td>
                   <td>  <input type="text" id="email" name="email" class="inp"></td>

               </tr>

               <tr align="center">
                   <td colspan="3">
                       <input type="submit" value="提交" id="tijiao" class="anniu" onclick="return register()">
                       <input type="reset" value="重置" id="reset" class="anniu">
                   </td>
               </tr>
         </table>
        </form>
      </div>

   </div>
</body>

<script type="text/javascript">
   


</script>


</html>