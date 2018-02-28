/**
 * 
 */
var carousel;
//加载固定的两张图片
//$("body").append("<div class='floatImg'><img alt='' src='/PersonWebsites/images/floatImg/123.gif'></div>"+
//    "<div class='floatImg1'><img alt='' src='/PersonWebsites/images/floatImg/111.gif'></div>");


//获取个人信息
function getPersonInfo(){
	$.ajax({
		url:'../../users/selectUserAndPersonByUserId.do',
		type:'post',
		data:{"userId":1},
		success:function(res){
			$(".person_tx").attr("src",res.result.person_tx);
			$(".person_name").html("姓名："+res.result.person_name);
			$(".person_work").html("职业："+res.result.person_work);
			$(".person_explanin").html("个人简介："+res.result.person_explanin);
			$(".person_sign").html("个性签名："+res.result.person_sign);
			$(".person_hobby").html("爱好："+res.result.person_hobby);
			$(".person_qq").html("QQ："+res.result.person_qq);
			$(".person_tel").html("联系方式："+res.result.person_tel);
			$(".person_sex").html("性别："+res.result.person_sex);
			$(".person_address").html("联系地址："+res.result.person_address);
		}
		
	});
}

//查询推荐的文章
function getTjArticles(){
	   $.ajax({
		  url:'../../articles/queryTjArticles.do',
		  type:'post',
		  success:function(res){
			 $.each(res,function(i,item){
				if(i<5){
					 $("#jxtj").append("<li><a href='articleDetails.html?aId="+item.articlesId+"' title=''>"+item.cententTitle+"</a></li>");
				} 
			 });
		  }
	   });
}
//查询最新的文章
function getNewArticles(){
	   $.ajax({
		  url:'../../articles/queryNewArticles.do',
		  type:'post',
		  success:function(res){
			  $.each(res,function(i,item){
					if(i<5){
						 $("#zxwz").append("<li><a href='articleDetails.html?aId="+item.articlesId+"' title=''>"+item.cententTitle+"</a></li>");
					} 
				 });
		  }
	   });
}
//关于我的页面的显示信息
function getPersonRestInfo(){
	var data={"userXXDD":"xxdd"}
	$.ajax({
		url:"/PersonWebsites/personRestinfo/selectAllPersonRestInfo.do",
		type:"post",
		data:data,
		success:function(res){
			//console.log(res[0])
			//undefined
			var str="";
			var str1="";
			if(res[0].my_lbImg1!=undefined){
				str += "<div><img width='100%' height='280px' src='"+res[0].my_lbImg1+"'></div>";
			}
			if(res[0].my_lbImg2!=undefined){
				str += "<div><img width='100%' height='280px' src='"+res[0].my_lbImg2+"'></div>";
			}
			if(res[0].my_lbImg3!=undefined){
				str += "<div><img width='100%' height='280px' src='"+res[0].my_lbImg3+"'></div>";
			}
			if(res[0].my_lbImg4!=undefined){
				str += "<div><img width='100%' height='280px' src='"+res[0].my_lbImg4+"'></div>";
			}
			$("#myCarousel_img").html(str);  //设置个人轮播图片
			//轮播
			  carousel.render({
			    elem: '#myCarousel'
			    ,width: '100%' //设置容器宽度
			    ,arrow: 'hover' //鼠标悬停显示箭头
			    ,anim: 'fade' //切换动画方式，默认从左向右
			    ,interval:'6000' //间隔时间
			  });
			  
			$("#jx_jj").html(res[0].jx_jj);  //设置家乡简介
			if(res[0].jx_lbImg1!=undefined){
				str1 += "<div><img width='100%' height='280px' src='"+res[0].jx_lbImg1+"'></div>";
			}
			if(res[0].jx_lbImg2!=undefined){
				str1 += "<div><img width='100%' height='280px' src='"+res[0].jx_lbImg2+"'></div>";
			}
			if(res[0].jx_lbImg3!=undefined){
				str1 += "<div><img width='100%' height='280px' src='"+res[0].jx_lbImg3+"'></div>";
			}
			if(res[0].jx_lbImg4!=undefined){
				str1 += "<div><img width='100%' height='280px' src='"+res[0].jx_lbImg4+"'></div>";
			}
			$("#jxCarousel_img").html(str1);  //设置家乡轮播图片
			 //家乡轮播
			  carousel.render({
			    elem: '#jxCarousel'
			    ,width: '100%' //设置容器宽度
			    ,arrow: 'hover' //鼠标悬停显示箭头
			    ,anim: 'fade' //切换动画方式，默认从左向右
			    ,interval:'6000' //间隔时间
			  });
		    // 百度地图API功能
		    var map = new BMap.Map("allmap");  // 创建Map实例
		    map.centerAndZoom(res[0].dt_addr,12);      // 初始化地图,用城市名设置地图中心点

		    map.addControl(new BMap.NavigationControl());   // 添加平移缩放控件
		    map.addControl(new BMap.ScaleControl());        // 添加比例尺控件
		    map.addControl(new BMap.OverviewMapControl());  //添加缩略地图控件
		    map.enableScrollWheelZoom();                    //启用滚轮放大缩小
		    var point = new BMap.Point(res[0].addr_jd,res[0].addr_wd);
		    //var point = new BMap.Point(107.622312,28.574019);    // 创建点坐标(经度,纬度)
		    //  map.centerAndZoom(point, 13);                   // 初始化地图,设置中心点坐标和地图大小级别
		    map.addOverlay(new BMap.Marker(point));         // 给该坐标加一个红点标记
		/* -------------------------------------------------------------------------- */
			
		}
	});
	
	 
}