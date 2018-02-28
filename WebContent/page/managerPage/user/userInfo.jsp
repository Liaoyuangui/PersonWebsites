<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
 <title></title>
    <link rel="stylesheet" href="../../../layui/css/layui.css">
    <style>
        .layui-upload-list{
            width: 150px;
            height: 150px;
            border: 1px solid;
        }
        .layui-upload-list .layui-upload-img{width:150px;height: 150px;}
        .layui-upload{width:400px;height: 250px;margin: 0 auto}
    </style>
</head>
<body>

<div class="layui-form" action="" enctype="multipart/form-data" id="js_form_box">
     <div class="layui-upload">
        <input id="choseTx" type="file" name="choseTx"  lay-type="file" >
        <button type="button" class="layui-btn" id="uploadTx">确定上传</button>
        <div class="layui-upload-list">
            <img class="layui-upload-img" name="personTx" id="personTx" >
            <p id="userText"></p>
        </div>
     </div>
    
    <!-- <div class="layui-form-item">
		<div class="layui-inline">
			<div class="site-demo-upload">
				<img id="imgShow" src="">
				<div class="site-demo-upbar">
					<div class="layui-box layui-upload-button">
						<form target="layui-upload-iframe" method="get" key="set-mine" enctype="multipart/form-data"
							action="/test/upload.json">
							<input type="file" name="file" class="layui-upload-file" id="test">
						</form>
						<span class="layui-upload-icon"><i class="layui-icon"></i>上传图片</span>
					</div>
				</div>
			</div>
		</div>
	</div> -->
    
    <div class="layui-form-item">
	   <div class="layui-inline">
	        <label class="layui-form-label">姓名</label>
	        <div class="layui-input-block">
	            <input type="text" name="personName" lay-verify="required" id="p_personName" autocomplete="off" placeholder="请输入标题" class="layui-input">
	        </div>
	   </div>
	    <div class="layui-inline">
	        <label class="layui-form-label">性别</label>
	        <div class="layui-input-block">
	            <select name="personSex" lay-filter="sex" id="p_personSex">
	                <option value="男">男</option>
	                <option value="女">女</option>
	            </select>
	        </div>
	    </div>
    </div>
    <div class="layui-form-item">
        <div class="layui-inline">
            <label class="layui-form-label">个人爱好</label>
            <div class="layui-input-block">
                <input type="text" name="personHobby" id="p_personHobby" lay-verify="required" autocomplete="off" placeholder="请输入爱好" class="layui-input">
            </div>
        </div>
        <div class="layui-inline">
            <label class="layui-form-label">个人qq</label>
            <div class="layui-input-block">
                <input type="text" name="personQq"  id="p_personQq" lay-verify="required" autocomplete="off" placeholder="请输入qq" class="layui-input">
            </div>
        </div>
    </div>
    <div class="layui-form-item">
        <div class="layui-inline">
            <label class="layui-form-label">手机号码</label>
            <div class="layui-input-inline">
                <input type="text" name="personTel" id="p_personTel" lay-verify="phone" placeholder="请输入电话号码"  autocomplete="off" class="layui-input">
            </div>
        </div>
        <div class="layui-inline">
            <label class="layui-form-label">个人职业</label>
            <div class="layui-input-block">
                <input type="text" name="personWork" id="p_personWork" lay-verify="required" autocomplete="off"  class="layui-input">
            </div>
        </div>
    </div>

    <div class="layui-form-item">
            <label class="layui-form-label">个人地址</label>
            <div class="layui-input-block">
                <input type="text" name="personAddress" id="p_personAddress" lay-verify="required" autocomplete="off"  class="layui-input">
            </div>
    </div>

    <div class="layui-form-item layui-form-text">
        <label class="layui-form-label">个性签名</label>
        <div class="layui-input-block">
            <textarea placeholder="请输入内容" id="p_personSign" name="personSign" class="layui-textarea"></textarea>
        </div>
    </div>
    <div class="layui-form-item layui-form-text">
        <label class="layui-form-label">个人说明</label>
        <div class="layui-input-block">
            <textarea class="layui-textarea" id="p_personExplanin" name="personExplanin" placeholder="请输入内容"  ></textarea>
        </div>
    </div>
 	<!--  其他   ：personOthers-->
    <div class="layui-form-item">
        <div class="layui-input-block">
            <button class="layui-btn" lay-submit="" lay-filter="btnSave">立即提交</button>
            <button type="reset" class="layui-btn layui-btn-primary">重置</button>
        </div>
    </div>
</div>

<script src="../../../layui/layui.js" charset="utf-8"></script>
<!-- 注意：如果你直接复制所有代码到本地，上述js路径需要改成你本地的 -->
<script>
	var utilExt;
	 layui.config({
		base : '../../../js/unit/'
	});
    layui.use(['form', 'layedit', 'laydate','upload','layer','utilExt'], function(){
        var form = layui.form
                ,layer = layui.layer
                ,layedit = layui.layedit
                ,laydate = layui.laydate;
        var $ = layui.jquery
                var upload = layui.upload;
        utilExt=layui.utilExt;

        //创建一个编辑器
       // var editIndex = layedit.build('p_personExplanin');
        //获取个人信息
        getPersonInfo();
        
        //监听提交
        form.on('submit(btnSave)', function(data){
        	var data = utilExt.getParamValues('p_','#js_form_box');
        	data.personTx = $('#personTx').attr('src');
            $.ajax({
            	url:'../../../users/insertOrUpdatePersonInfo.do',
            	data:data,
            	type:'post',
            	success:function(result){
            		if(result.errcode=='0'){
            			//重新调用查询的方法
            			utilExt.successMsg("保存成功！！！", function() {
							layer.closeAll();
							getPersonInfo();
						});
            		}else{
            			 utilExt.errorMsg("保存失败");
            		}
            	}
            });
        	
        });

       //普通图片上传
        var uploadInst = upload.render({
            elem: '#choseTx'
            ,url: '../../../users/saveUserImg.do'
           	,auto: false //选择文件后不自动上传
           	,bindAction: '#uploadTx' //指向一个按钮触发上传
            /* ,before: function(obj){
                //预读本地文件示例，不支持ie8
                obj.preview(function(index, file, result){
                    $('#userTx').attr('src', result); //图片链接（base64）
                });
            } */
        	,done: function(res){
        	      //上传完毕回调
        		 $('#personTx').attr('src', res.src);
        		 layer.msg('上传成功',{icon:1});
        	}
           
        });
       //获取个人信息
       function getPersonInfo(){
    	   $.ajax({
    		  url:'../../../users/getPonserInfoByUserId.do', 
    		  type:'post',
    		  success:function(res){
    			  if(res.errcode=='1'){
    				  layer.msg(res.result,{icon:2}); 
    			  }else{
						utilExt.setParamValues(res.result,'p_','#js_form_box');
						 $('#personTx').attr('src', res.result.personTx);
						 $('#p_personSex').siblings().find('dd[lay-value="' + res.result.personSex + '"]').click();
    			  }
    		  }
    	   });
       }


    });
</script>

</body>
</html>