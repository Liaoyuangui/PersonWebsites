/**
 * 设置主题
 * @returns
 */ 
     //设置主题
     function getTheme(){
    	 var data={"isStart":1}
    	 $.ajax({
    		url:"/PersonWebsites/theme/selectAlltheme.do",
    		type:"post",
    		data:data,
    		success:function(res){
    		  $('#headImgUrl').attr('src', res[0].headImgurl);
   			  $('#headSign').html(res[0].headSign);
   			  $('#indexLbUrl1').attr('src', res[0].indexLburl1);
   			  $('#indexLbUrl2').attr('src', res[0].indexLburl2);
   			  $('#indexLbUrl3').attr('src', res[0].indexLburl3);
   			  $('#footLabel').html(res[0].footLabel);
   			  $('#footLabel1').html(res[0].footLabel1);
    		}
    	 });
     }
     
     getTheme(); //主题