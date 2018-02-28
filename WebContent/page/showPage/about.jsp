<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="shortcut icon" type="image/x-icon" href="../../images/ico.ico" media="screen" />
<title>关于我--放肆的青春诠释了悲伤</title>
<meta name="keywords" content="个人主页" />
<meta name="description" content="" />
<link rel="stylesheet" href="../../css/index.css"/>
<link rel="stylesheet" href="../../css/style.css"/>
<link rel="stylesheet" href="../../layui/css/layui.css">
<script type="text/javascript" src="../../js/jquery-2.1.1.min.js"></script>
<script type="text/javascript" src="../../js/jquery.SuperSlide.2.1.1.js"></script>
<script type="text/javascript" src="../../layui/layui.js"></script>
<script type="text/javascript" src="http://api.map.baidu.com/api?v=2.0&ak=6c497f51c06477544e5fa6e9bd68f7c3"></script>
<style>
  .basicInfo_title{
    color: blue;
    font-size: 18px;
  }
  .basic_Info{
    margin-left: 50px;
    width: 600px;
  }
  .basic_Info .p1{
    float: left;
    padding-right:120px;
    width: 30%;
    font-size: 14px;
  }
  .basic_Info span{
   padding-top:5px;
   font-size: 14px;
  }
  #person_explanin{
    margin-top: 5px;
  }
  #allmap{
    margin-top:-5px;
    padding:0;
    width: 100%;
    height: 400px;
    margin: 0 auto;
  }
  .jx p{
     text-indent:2em ;
  }
  #jxCarousel{
    margin-bottom: 10px;
  }
  #c_right .s_about img{margin-left: 15px;}
</style>

</head>

<body>
      <!--header start-->
    <div id="header">
       <img id="headImgUrl" alt="img" src="../../images/welcome.png" width="300" height="50" style="margin-left: 350px">
      <p id="headSign">青春是打开了,就合不上的书。人生是踏上了，就回不了头的路，爱情是扔出了，就收不回的赌注。</p>    
    </div>
     <!--header end-->
    <!--nav-->
     <div id="nav">
         <ul>
	          <li><a href="../../index.html">首页</a></li>
	         <li><a href="about.jsp">关于我</a></li>
	         <li><a href="learn.html">学海无涯</a></li>
	    <!--      <li><a href="dynamics.html">个人动态</a></li> -->
	         <li><a href="personalDiary.html">个人日记</a></li>
	         <li><a href="media.html">媒体展示</a></li>
	         <li><a href="message.html">留言板</a></li>
	         <div class="clear"></div>
        </ul>
      </div>
       <!--nav end-->
    <!--content start-->
    <div id="content">
       <!--left-->
         <div class="left" id="about_me">
           <div class="weizi">
           <div class="wz_text">当前位置：<a href="../../index.html">首页</a>><h1>关于我</h1></div>
           </div>
           <div class="about_content">
              <!--轮播 -->
		        <div class="layui-carousel" id="myCarousel">
				  <div carousel-item id="myCarousel_img">
				    <!-- <div><img width="100%" height="280px" src="../../images/myCarousel/a.jpg"></div>
				    <div><img width="100%" height="280px" src="../../images/myCarousel/b.jpg"></div>
				    <div><img width="100%" height="280px" src="../../images/myCarousel/c.jpg"></div>
				    <div><img width="100%" height="280px" src="../../images/myCarousel/d.jpg"></div> -->
				  </div>
				</div><br>
		     <!--轮播结束 -->
		     <!-- 基本信息 -->
		       <div class='basicInfo_title' style="margin-top: 20px;">基本信息：</div> <hr>
			       <div>
			         <div class='basic_Info'>
			             <span class='person_name p1'></span>
			        	 <span class='person_sex p1'></span>
			         </div>
			         <div class='basic_Info'>
			             <span class='person_hobby p1'></span>
			        	 <span class='person_work p1'></span>
			         </div>
			         <div class='basic_Info'>
			             <span class='person_qq p1'></span>
			        	 <span class='person_tel p1'></span>
			         </div>
			         <div class='basic_Info'>
			             <span class='person_sign'></span>
			         </div>
			          <div class='basic_Info' id="person_explanin">
			             <span class='person_explanin'></span>
			         </div><br>
		       </div>
		       <div class='basicInfo_title'>联系地址：</div> <hr>
		       <!-- 百度地图  -->
		       <div id="allmap"> </div>
               <div class='basicInfo_title' style="margin-top: 40px;">我的家乡：</div> <hr> 
               <div class='jx' id="jx_jj">
               	<!-- 	<p>正安县是贵州省遵义市下辖县，位于遵义市东北部，是贵州襟联重庆的前沿，是渝南、黔北经济文化的重要交汇区域，素有"黔北门户"之称。<p>
					<p>正安县位于贵州省北部，北接重庆市南川区，东北毗邻道真县、务川县，东南与凤冈县和湄潭县交界，南靠绥阳县，西北与桐梓县接壤。 </p>
                    <p>正安县名优特产主要有野木瓜、正安白茶等，风景名胜主要有尹珍务本堂、九道水国家森林公园等。</p> -->
               </div>
               <!--轮播 -->
		        <div class="layui-carousel" id="jxCarousel">
				  <div carousel-item id="jxCarousel_img">
				   <!--  <div><img width="100%" height="280px" src="../../images/myCarousel/e.jpg"></div>
				    <div><img width="100%" height="280px" src="../../images/myCarousel/f.png"></div>
				    <div><img width="100%" height="280px" src="../../images/myCarousel/g.jpg"></div>
				    <div><img width="100%" height="280px" src="../../images/myCarousel/h.gif"></div> -->
				  </div>
				</div>
           </div>
         </div>
         <!--end left -->
         <!--right-->
         <div class="right" id="c_right">
          <div class="s_about">
          <h2>关于我</h2>
           <img class="person_tx" src="" width="230" height="230" alt="个人头像"/>
           <p  class='person_name'></p>
           <p class='person_work'></p>
           <p class='person_address'></p>
           <p>
           <a target=blank href=tencent://message/?uin=1129896968&Site=lyg&Menu=yes><span class="left b_1"></span></a><a target="_blank" href="//shang.qq.com/wpa/qunwpa?idkey=9a9e02cd8b34796871514359bae9521d53a793fce9e46794b69d18b43fcf540c"><img border="0" src="//pub.idqqimg.com/wpa/images/group.png" alt="難忘的、壹天" title="難忘的、壹天"></a>
           <div class="clear"></div>
           </p>
          </div>
         <!--栏目分类-->
	        <div class="lanmubox">
	            <div class="hd">
	                <ul><li>精心推荐</li><li>最新文章</li></ul>
	            </div>
	            <div class="bd">
	                <ul id='jxtj'>
	                </ul>
	                <ul id='zxwz'>
	                </ul>
	            </div>
	        </div>
           <!--end-->
         </div>
         <!--end  right-->
         <div class="clear"></div>
         
    </div>
    <!--content end-->
    <!--footer-->
    <div id="footer">
     <p id="footLabel">The Boy Who Harnessed The Wind Liaoyuangui</p>
     <p id="footLabel1">联系方式:1129696968@qq.com</p>
    </div>
    <!--footer end-->
    <script type="text/javascript">jQuery(".lanmubox").slide({easing:"easeOutBounce",delayTime:400});</script>
    <script  type="text/javascript" src="../../js/nav.js"></script>
 	<script type="text/javascript" src='../../js/content/content.js'></script>
 	<script type="text/javascript" src="../../js/content/theme.js"></script>
</body>
<script>
    var carousel;
	layui.use('carousel', function(){
     carousel = layui.carousel;
	//关于我的信息
	  getPersonRestInfo();
	  setLunbo();
	});

 
//获取个人信息
    getPersonInfo();
  //查询推荐的文章
    getTjArticles();
//查询最新的文章
    getNewArticles();
    
    //设置轮播
    function setLunbo(){
    
    }
</script>
</html>
