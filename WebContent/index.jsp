<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>个人网站</title>
<meta name="keywords" content="个人主页" />
<meta name="description" content="" />
<link rel="stylesheet" href="css/bootstrap.min.css">
<link rel="stylesheet" href="css/index.css"/>
<link rel="stylesheet" href="css/style.css"/>

<script type="text/javascript" src="js/jquery-2.1.1.min.js"></script>
<script type="text/javascript" src="js/jquery.SuperSlide.2.1.1.js"></script>
<script type="text/javascript" src="js/bootstrap.min.js"></script>
<!--[if lt IE 9]>
<script src="js/html5.js"></script>
<![endif]-->
<style>
  .s_about h2 a{
    padding-left: 100px;
    font-size: 14px;
    cursor: pointer;
  }
</style>
</head>

<body>
    <!--header start-->
    <div id="header">
      <h1>Liaoyuangui&nbsp;&nbsp;&nbsp;欢迎您！</h1>
      <p>青春是打开了,就合不上的书。人生是踏上了，就回不了头的路，爱情是扔出了，就收不回的赌注。</p>    
    </div>
     <!--header end-->
    <!--nav-->
     <div id="nav">
        <ul>
         <li><a href="index.jsp">首页</a></li>
         <li><a href="page/showPage/about.jsp">关于我</a></li>
         <li><a href="shuo.html">碎言碎语</a></li>
         <li><a href="riji.html">个人日记</a></li>
         <li><a href="xc.html">相册展示</a></li>
         <li><a href="learn.html">学无止境</a></li>
         <li><a href="guestbook.html">留言板</a></li>
         <div class="clear"></div>
        </ul>
      </div>
       <!--nav end-->
    <!--轮播图-->
    <div id="myCarousel" class="carousel slide">
        <!-- 轮播（Carousel）指标 -->
        <ol class="carousel-indicators">
            <li data-target="#myCarousel" data-slide-to="0" class="active"></li>
            <li data-target="#myCarousel" data-slide-to="1"></li>
            <li data-target="#myCarousel" data-slide-to="2"></li>
        </ol>
        <!-- 轮播（Carousel）项目 -->
        <div class="carousel-inner">
            <div class="item active">
                <img src="images/1/4.jpg" alt="First slide">
                <div class="carousel-caption">1</div>
            </div>
            <div class="item">
                <img src="images/1/5.jpg" alt="Second slide">
                <div class="carousel-caption">2</div>
            </div>
            <div class="item">
                <img src="images/1/6.jpg" alt="Third slide">
                <div class="carousel-caption">3</div>
            </div>
        </div>
        <!-- 轮播（Carousel）导航 -->
        <a class="carousel-control left" href="#myCarousel"
           data-slide="prev">&lsaquo;
        </a>
        <a class="carousel-control right" href="#myCarousel"
           data-slide="next">&rsaquo;
        </a>
    </div>
    <!--content start-->
    <div id="content">
         <!--left-->
         <div class="left" id="c_left">
           <div class="s_tuijian">
           <h2>文章<span>推荐</span></h2>
           </div>
          <div class="content_text">
           <!--wz-->
           <div class="wz">
            <h3><a href="#" title="浅谈：html5和html的区别">浅谈：html5和html的区别</a></h3>
             <dl>
               <dt><img src="images/s.jpg" width="200"  height="123" alt=""></dt>
               <dd>
                 <p class="dd_text_1">最近看群里聊天聊得最火热的莫过于手机网站和html5这两个词。可能有人会问，这两者有什么关系呢？随着这移动互联
                 网快速发展的时代，尤其是4G时代已经来临的时刻，加上微软对"XP系统"不提供更新补丁、维护的情况下。
               html5+css3也逐渐的成为新一代web前端技术.....</p>
               <p class="dd_text_2">
               <span class="left author">段亮</span><span class="left sj">时间:2014-8-9</span>
               <span class="left fl">分类:<a href="#" title="学无止境">学无止境</a></span><span class="left yd"><a href="#" title="阅读全文">阅读全文</a>
               </span>
                <div class="clear"></div>
               </p>
               </dd>
               <div class="clear"></div>
             </dl>
            </div>
           <!--wz end-->
            <!--wz-->
           <div class="wz">
            <h3><a href="#" title="浅谈：html5和html的区别">浅谈：html5和html的区别</a></h3>
             <dl>
               <dt><img src="images/s1.jpg" width="200" height="123" alt=""></dt>
               <dd>
                 <p class="dd_text_1">最近看群里聊天聊得最火热的莫过于手机网站和html5这两个词。可能有人会问，这两者有什么关系呢？随着这移动互联
                 网快速发展的时代，尤其是4G时代已经来临的时刻，加上微软对"XP系统"不提供更新补丁、维护的情况下。
               html5+css3也逐渐的成为新一代web前端技术.....</p>
               <p class="dd_text_2">
               <span class="left author">段亮</span><span class="left sj">时间:2014-8-9</span>
               <span class="left fl">分类:<a href="#" title="学无止境">学无止境</a></span><span class="left yd"><a href="#" title="阅读全文">阅读全文</a>
               </span>
                <div class="clear"></div>
               </p>
               </dd>
               <div class="clear"></div>
             </dl>
            </div>
           <!--wz end-->
            <!--wz-->
           <div class="wz">
            <h3><a href="#" title="浅谈：html5和html的区别">浅谈：html5和html的区别</a></h3>
             <dl>
               <dt><img src="images/s2.jpg" width="200" height="123" alt=""></dt>
               <dd>
                 <p class="dd_text_1">最近看群里聊天聊得最火热的莫过于手机网站和html5这两个词。可能有人会问，这两者有什么关系呢？随着这移动互联
                 网快速发展的时代，尤其是4G时代已经来临的时刻，加上微软对"XP系统"不提供更新补丁、维护的情况下。
               html5+css3也逐渐的成为新一代web前端技术.....</p>
               <p class="dd_text_2">
               <span class="left author">段亮</span><span class="left sj">时间:2014-8-9</span>
               <span class="left fl">分类:<a href="#" title="学无止境">学无止境</a></span><span class="left yd"><a href="#" title="阅读全文">阅读全文</a>
               </span>
                <div class="clear"></div>
               </p>
               </dd>
               <div class="clear"></div>
             </dl>
            </div>
           <!--wz end-->
           <!--wz-->
           <div class="wz">
            <h3><a href="#" title="浅谈：html5和html的区别">浅谈：html5和html的区别</a></h3>
             <dl>
               <dt><img src="images/s3.jpg" width="200" height="123" alt=""></dt>
               <dd>
                 <p class="dd_text_1">最近看群里聊天聊得最火热的莫过于手机网站和html5这两个词。可能有人会问，这两者有什么关系呢？随着这移动互联
                 网快速发展的时代，尤其是4G时代已经来临的时刻，加上微软对"XP系统"不提供更新补丁、维护的情况下。
               html5+css3也逐渐的成为新一代web前端技术.....</p>
               <p class="dd_text_2">
               <span class="left author">段亮</span><span class="left sj">时间:2014-8-9</span>
               <span class="left fl">分类:<a href="#" title="学无止境">学无止境</a></span><span class="left yd"><a href="#" title="阅读全文">阅读全文</a>
               </span>
                <div class="clear"></div>
               </p>
               </dd>
               <div class="clear"></div>
             </dl>
            </div>
           <!--wz end-->
            <!--wz-->
           <div class="wz">
            <h3><a href="#" title="浅谈：html5和html的区别">浅谈：html5和html的区别</a></h3>
             <dl>
               <dt><img src="images/s3.jpg" width="200" height="123" alt=""></dt>
               <dd>
                 <p class="dd_text_1">最近看群里聊天聊得最火热的莫过于手机网站和html5这两个词。可能有人会问，这两者有什么关系呢？随着这移动互联
                 网快速发展的时代，尤其是4G时代已经来临的时刻，加上微软对"XP系统"不提供更新补丁、维护的情况下。
               html5+css3也逐渐的成为新一代web前端技术.....</p>
               <p class="dd_text_2">
               <span class="left author">段亮</span><span class="left sj">时间:2014-8-9</span>
               <span class="left fl">分类:<a href="#" title="学无止境">学无止境</a></span><span class="left yd"><a href="#" title="阅读全文">阅读全文</a>
               </span>
                <div class="clear"></div>
               </p>
               </dd>
               <div class="clear"></div>
             </dl>
            </div>
           <!--wz end-->
        </div>
        
      <!--      ---------------        关于我           -----------          -->  
         </div>
         <!--left end-->
         <!--right-->
         <div class="right" id="c_right">
          <div class="s_about">
          <h2>关于我<a href="page/showPage/about.jsp">更多>></a></h2>
           <img id="person_tx" src="" width="230" height="230" alt="个人头像"/>
           <p id='person_name'></p>
           <p id='person_work'></p>
           <p id='person_address'></p>
           <p>
           <a href="#" title="联系博主"><span class="left b_1"></span></a><a href="#" title="加入QQ群，一起学习！"><span class="left b_2"></span></a>
           <div class="clear"></div>
           </p>
          </div>
          <!--栏目分类-->
           <div class="lanmubox">
              <div class="hd">
               <ul><li>精心推荐</li><li>最新文章</li><li class="hd_3">随机文章</li></ul>
              </div>
              <div class="bd">
                <ul>
					<li><a href="#" title="网站项目实战开发（-）">网站项目实战开发（-）</a></li>
					<li><a href="#" title="关于响应式布局">关于响应式布局</a></li>
					<li><a href="#" title="如何创建个人博客网站">如何创建个人博客网站</a></li>
					<li><a href="#" title="网站项目实战开发（二）">网站项目实战开发（二）</a></li>
					<li><a href="#" title="为什么新站前期排名老是浮动？(转)">为什么新站前期排名老是浮动？(转)</a></li>
				</ul>
                 <ul>
					<li><a href="#" title="网站项目实战开发（-）">网站项目实战开发（-）</a></li>
					<li><a href="#" title="关于响应式布局">关于响应式布局</a></li>
					<li><a href="#" title="如何创建个人博客网站">如何创建个人博客网站</a></li>
					<li><a href="#" title="网站项目实战开发（二）">网站项目实战开发（二）</a></li>
					<li><a href="#" title="为什么新站前期排名老是浮动？(转)">为什么新站前期排名老是浮动？(转)</a></li>
				</ul>
                 <ul>
					<li><a href="#" title="网站项目实战开发（-）">网站项目实战开发（-）</a></li>
					<li><a href="#" title="关于响应式布局">关于响应式布局</a></li>
					<li><a href="#" title="如何创建个人博客网站">如何创建个人博客网站</a></li>
					<li><a href="#" title="网站项目实战开发（二）">网站项目实战开发（二）</a></li>
					<li><a href="#" title="为什么新站前期排名老是浮动？(转)">为什么新站前期排名老是浮动？(转)</a></li>
				</ul>
                 
                
              </div>
           </div>
           
          <!-- ---------------------------------关于我结束------------------ --> 
           <!--end-->
           <div class="link">
            <h2>友情链接</h2>
            <p><a href="#">段亮个人博客</a></p>
           </div>
         </div>
         <!--right end-->
         <div class="clear"></div>
    </div>
    <!--content end-->
    <!--footer start-->
    <div id="footer">
     <p>Design by:<a href="http://www.duanliang920.com" target="_blank">少年</a> 2014-8-9</p>
    </div>
    <!--footer end-->
    <script type="text/javascript">jQuery(".lanmubox").slide({easing:"easeOutBounce",delayTime:400});</script>
    <script  type="text/javascript" src="js/nav.js"></script>
</body>
<script>
    getPersonInfo();
    function getPersonInfo(){
    	$.ajax({
    		url:'users/selectUserAndPersonByUserId.do',
    		type:'post',
    		data:{"userId":1},
    		success:function(res){
    			$("#person_tx").attr("src",res.result.person_tx);
    			$("#person_name").html("姓名："+res.result.person_name);
    			$("#person_work").html("职业："+res.result.person_work);
    			$("#person_explanin").html("简介:"+res.result.person_explanin);
    			$("#person_address").html("简介:"+res.result.person_address);
    			
    		}
    		
    	});
    }


</script>

</html>