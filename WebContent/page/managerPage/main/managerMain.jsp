<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="shortcut icon" type="image/x-icon" href="../../../images/ico.ico" media="screen" />
<title>Liaoyuangui 后台管理--放肆的青春诠释了悲伤</title>
<link rel="stylesheet" href="../layui/css/layui.css">
</head>
<body>
<div class="layui-layout layui-layout-admin">
    <div class="layui-header">
        <div class="layui-logo">Liaoyuangui网站后台管理</div>
        <!-- 头部区域（可配合layui已有的水平导航） -->
        <ul class="layui-nav layui-layout-left">
            <li class="layui-nav-item"><a href="../page/managerPage/articles/addArticles.html"  target="mainFrame">发表文章</a></li>
            <li class="layui-nav-item"><a href="../page/managerPage/myalbum/myAlbum.html"  target="mainFrame">我的相册</a></li>
            <li class="layui-nav-item"><a href="../page/managerPage/message/showMessage.html"  target="mainFrame">留言列表</a></li>
        </ul>
        <ul class="layui-nav layui-layout-right">
            <li class="layui-nav-item">
                <a href="javascript:;">
                    <img src="../images/myCarousel/b.jpg" class="layui-nav-img">
                   ${managerInfo.loginName }
                </a>
                <dl class="layui-nav-child">
                    <dd><a href="../page/managerPage/user/userInfo.jsp" target="mainFrame">基本资料</a></dd>
                    <dd><a href="../page/managerPage/safety/safety.html" target="mainFrame">安全设置</a></dd>
                </dl>
            </li>
            <li class="layui-nav-item"><a href="../page/login/login.jsp">退了</a></li>
        </ul>
    </div>

    <div class="layui-side layui-bg-black">
        <div class="layui-side-scroll">
            <!-- 左侧导航区域（可配合layui已有的垂直导航） -->
            <ul class="layui-nav layui-nav-tree"  lay-filter="test">
                <li class="layui-nav-item layui-nav-itemed">
                    <a class="" href="javascript:;">个人管理</a>
                    <dl class="layui-nav-child">
                        <dd><a href="../page/managerPage/user/userInfo.jsp"  target="mainFrame">基本信息</a></dd>
                        <dd><a href="../page/managerPage/user/personRestinfo.html"  target="mainFrame">其他信息</a></dd>
                    </dl>
                </li> 
                <li class="layui-nav-item">
                    <a href="javascript:;">文章分类</a>
                    <dl class="layui-nav-child">
                        <dd><a href="../page/managerPage/articlesClass/articlesClass.html"  target="mainFrame">分类信息</a></dd>
                        <dd><a href="../page/managerPage/articlesClass/addArticlesClass.html"  target="mainFrame">添加分类</a></dd>
                    </dl>
                </li>
                <li class="layui-nav-item">
                   <a href="javascript:;">文章管理</a>
                    <dl class="layui-nav-child">
                        <dd><a href="../page/managerPage/articles/addArticles.html"  target="mainFrame">发表文章</a></dd>
                        <dd><a href="../page/managerPage/articles/articles.html"  target="mainFrame">文章列表</a></dd>
                    </dl>
                </li>
                 <li class="layui-nav-item">
                   <a href="javascript:;">日记管理</a>
                    <dl class="layui-nav-child">
                        <dd><a href="../page/managerPage/diary/addDiary.html"  target="mainFrame">发表日记</a></dd>
                        <dd><a href="../page/managerPage/diary/showDiary.html"  target="mainFrame">日记列表</a></dd>
                    </dl>
                </li>
                 <li class="layui-nav-item">
                   <a href="javascript:;">相册管理</a>
                    <dl class="layui-nav-child">
                        <dd><a href="../page/managerPage/myalbum/addAlbum.html"  target="mainFrame">创建相册</a></dd>
                        <dd><a href="../page/managerPage/myalbum/myAlbum.html"  target="mainFrame">我的相册</a></dd>
                    </dl>
                </li>
                <li class="layui-nav-item">
                   <a href="javascript:;">留言管理</a>
                    <dl class="layui-nav-child">
                        <dd><a href="../page/managerPage/message/showMessage.html"  target="mainFrame">留言列表</a></dd>
                       <!--  <dd><a href="../page/managerPage/message/"  target="mainFrame">我的相册</a></dd> -->
                    </dl>
                </li>
                <li class="layui-nav-item">
                   <a href="javascript:;">媒体管理</a>
                    <dl class="layui-nav-child">
                        <dd><a href="../page/managerPage/media/addMedia.html"  target="mainFrame">添加媒体</a></dd>
                        <dd><a href="../page/managerPage/media/showMedia.html"  target="mainFrame">媒体列表</a></dd>
                    </dl>
                </li>
                 <li class="layui-nav-item">
                   <a href="javascript:;">主题管理</a>
                    <dl class="layui-nav-child">
                        <dd><a href="../page/managerPage/theme/addTheme.html"  target="mainFrame">添加主题</a></dd>
                        <dd><a href="../page/managerPage/theme/myTheme.html"  target="mainFrame">主题列表</a></dd>
                    </dl>
                </li>
                
            </ul>
        </div>
    </div>

    <div class="layui-body">
        <!-- 内容主体区域 -->
        <div style="padding: 15px;">
            <iframe name="mainFrame" id='mainFrame' width="100%" height="500px;" frameborder="0"></iframe>
        </div>
    </div>

    <div class="layui-footer">
        <!-- 底部固定区域 -->
        © www.liaoyuangui.com -
    </div>
</div>
<script src="../layui/layui.js"></script>
<script>
    //JavaScript代码区域
    layui.use('element', function(){
        var element = layui.element;

    });
    
    function reinitIframe(){ 
    	var iframe = document.getElementById("mainFrame");  //mainFrame为iframe 的id
    	try{ 
    	//var bHeight = iframe.contentWindow.document.body.scrollHeight; 
    	//var dHeight = iframe.contentWindow.document.documentElement.scrollHeight; 
    	var bHeight = iframe.document.body.scrollHeight; 
    	var dHeight = iframe.document.documentElement.scrollHeight;
    	var height = Math.max(bHeight, dHeight); 
    	iframe.height = height; 
    	}catch (ex){} 
    	} 
    	window.setInterval("reinitIframe()", 100);   //每隔100毫秒，系统自动执行一次这个reinitIframe()函数
</script>
</body>
</html>