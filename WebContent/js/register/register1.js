$(function(){
    	$("#userName").change(function(){
    		var userName=$("#userName").val();
    		userName=$.trim(userName);
    		if(userName!=""){
    			var parrern=/^[\u4e00-\u9fa5a-zA-Z_0-9]{1,}$/;
    	        if(!parrern.test(userName)){
    	            alert("用户名输入格式有误，请重新输入！");
    	            $("#userName").focus();
    	            return false;
    	        }else{
    	        	var url="RegisterController/userNameExists.do";
    	        	var args={"userName":userName,"time":new Date()};
    	        	$.post(url,args,function(data){
    	        	$("#message").html(data);
    	        	
    	        	});
    	        }
    		}
    	});
    });
//点击注册时触发
function register(){
    //验证用户名
    var username=$("#userName").val();
    username=$.trim(username);
    if(username==""){
        alert("用户名不能为空！");
        $("#userName").focus();
        return false;
    }else{
        var parrern=/^[\u4e00-\u9fa5a-zA-Z_0-9]{1,}$/;
        if(!parrern.test(username)){
            alert("用户名输入格式有误，请重新输入！");
            $("#userName").focus();
            return false;
        }
    }

    //验证密码
    var password=$("#password").val();
    if(password==""){
        alert("密码不能为空！");
        $("#password").focus();
        return false;
    }else{
       if(password.length<6||password.length>12){
           alert("密码在6-12位之间！");
           $("#password").focus();
           return false;
       }
    }

    //确认密码
    var password1=$("#password1").val();
    if(password1==""){
        alert("确认密码不能为空！");
        $("#password1").focus();
        return false;
    }else{
        if(password!=password1){
            alert("两次密码输入不相等，请重新输入！");
            $("#password1").focus();
            return false;
        }
    }

  /*  //验证手机号码
    var phone=$("#phone").val();
    if(phone==""){
        alert("手机号码不能为空！");
        $("#phone").focus();
        return false;
    }else{
        var parrern=/^[1][3|4|5|7|8|][0-9]{9}$/;13 14 15 17 18
        if(!parrern.test(phone)){
            alert("手机号格式有误，请重新输入！");
            $("#phone").focus();
            return false;
        }
    }
*/
    //验证邮箱
    var email=$("#email").val();
    if(email==""){
        alert("邮箱不能为空！");
        return false;
    }else{
        var parrern1=/^([A-Za-z0-9_\.\-]+)@([a-zA-Z0-9_]+)\.([A-Za-z]{2,4})$/;
        if(email!=""&&!parrern1.test(email)){
            alert("邮箱格式有误！");
            $("#email").focus();
            return false;
        }
    }
    return true;

}


