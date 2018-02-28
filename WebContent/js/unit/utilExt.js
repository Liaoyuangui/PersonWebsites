layui.define('layer', function(exports) {
	var $ = layui.jquery, layer = layui.layer;
	var utilExt = {
		debug : false,
		log : function(obj) {
			if (utilExt.debug) {
				var message = Array.prototype.slice.call(arguments, 0);
				console.log.apply(console, [ 'utilExt-debug:' ].concat(message));
			}
		}
	};
	var outLog = function(obj) {
		utilExt.log(obj);
	};

	utilExt.basePath = location.protocol + "//" + location.host + '/ServiceManager/';
	utilExt.isMoney = function(num) {
		var reg = /^[0-9]*(\.[0-9]{1,2})?$/;
		return reg.test(num);
	};
	utilExt.addTips = function() {
		$('input').focus(function() {
			var $this = $(this), id = $this.attr('id'), maxlength = $this.attr('maxlength');
			if (maxlength && id) {
				layer.tips('该字段最大输入长度为' + maxlength + '字符', '#' + id, {
					tips : [ 1, '#F7B824' ],
					time : 4000
				});
			}
		});
	};
	utilExt.alert = function(msg, cb, title, iconIdx) {
		layer.alert(msg, {
			icon : iconIdx || 0,
			title : title || '系统提示'
		}, function(index) {
			if (cb && typeof cb == "function") {
				cb.call(cb, index);
			} else {
				layer.close(index);
			}
		});
	};
	utilExt.successMsg = function(msg, cb, title) {
		utilExt.alert(msg, cb, title, 1);
	};
	utilExt.errorMsg = function(msg, cb, title) {
		utilExt.alert(msg, cb, title, 2);
	};

	utilExt.openLayer = function(params) {
		var layerParams = {
			type : 2,
			title : params.title || "添加信息",
			shadeClose : false,// 是否点击遮罩关闭
			shade : 0.8,
			area : params.area || [ '800px', '90%' ],
			content : params.url,
			skin: params.skin,
			maxmin : true,
			success : function(layero, index) {
				// 是否含有 params['isFull']:true
				if (params['isFull'] && params['isFull'] == true) {
					layer.full(index);
				}
				// 绑定关闭事件
				var fmCnt = layero.find('iframe')[0].contentDocument
				var $btnClose = $(fmCnt).find('.layui-btn.btn-close');
				if ($btnClose.length) {
					$btnClose.click(function() {
						layer.closeAll();
					});
				}
			},
			cancel : function() {
				typeof params.cancel == 'function' ? params.cancel() : ''
			}
		};
		layer.open(layerParams);
	};
	utilExt.cancelCB = function(btnId) {
		var btn = btnId ? btnId : '#btn_query';
		$(document).find(btn).click();
		layer.closeAll();
	};
	utilExt.alertCB = function(btnId) {
		var btn = btnId ? btnId : '#btn_query';
		$(parent.document).find(btn).click();
		parent.layer.closeAll();
	};

	/*****************************************************************************
	 * 获取输入信息 parentTag(expression表达式) 查找范围
	 * 
	 * @param {Object}
	 *          paramId_prefix
	 */
	utilExt.getParamValues = function(paramId_prefix, parentTag) {
		var $params = typeof parentTag != 'undefined' ? $(parentTag).find("[id^='" + paramId_prefix + "']") : $("[id^='"
				+ paramId_prefix + "']"), params = {}, param, value, type;
		for (var i = 0; i < $params.length; i++) {
			param = $params.get(i);
			value = $(param).val();
			realValue = $(param).attr("real-value");
			type = $(param).attr("type");
			if (realValue)
				value = realValue;
			var pIdx = param.id.replace(paramId_prefix, "");
			if ("checkbox,radio".indexOf(type) > -1)
				params[pIdx] = !!param.checked;
			else if ("select-one")
				params[pIdx] = value;
			else
				params[pIdx] = $(param).text();

			if (!params[pIdx])
				delete params[pIdx]
			else{
					//params[pIdx] = params[pIdx].toString().trim();
					params[pIdx]=$.trim(params[pIdx].toString());
				}
		}
		outLog(params);
		return params;

	};
	/*****************************************************************************
	 * 值绑定 parentTag(expression表达式) 查找范围
	 * 
	 * @param {Object}
	 *          paramId_prefix
	 * @c_tranf值替代 格式｛attr1:{1：‘Y’,2:'N'}，attr2:{1：‘zhengc’,2:'fzhengc'}｝
	 * @jsonData JOSN数据包
	 */
	utilExt.setParamValues = function(jsonData, paramId_prefix, parentTag, c_tranf) {
		var $params, v_data, artType, $parent = $(parentTag);
		if (paramId_prefix == null || typeof paramId_prefix == 'undefined') {
			return;
		}
		// 对象遍历
		var objFun = function(datas) {
			var real_value;
			for ( var atr in datas) {
				vdata = datas[atr];
				real_value = null;
				if (c_tranf && c_tranf[atr]) {
					real_value = vdata;
					vdata = c_tranf[atr][vdata];
					if (!vdata)
						vdata = real_value;
					var trigger = c_tranf[atr].trigger;
					if (typeof trigger == 'function') {
						var conv = trigger.call(null, vdata);
						if (conv) // 带返回值时,值转换
							vdata = conv;
					}
				}
				switch (typeof vdata) {
				case "object":
					objFun(vdata);
					break;
				default:
					var $elem = $("[id='p_" + atr + "'],[type='radio'][name='p_" + atr + "'][value='" + vdata + "']");
					if (real_value)
						$elem.attr("real-value", real_value);
					// 表单元素
					if ($elem[0]) {
						var tagName = $elem[0].tagName.toLowerCase();
						if ('input,select,textarea'.indexOf(tagName) > -1) {
							var elem_type = $elem[0].type;
							// 判断类型
							/**
							 * **
							 * button,checkbox,file,hidden,image,password,radio,reset,submit,text*
							 */
							switch (elem_type) {
							case 'text':
							case 'number':
								$elem.val(vdata);
								break;
							case 'password':
							case 'hidden':
								$elem.val(vdata);
								break;
							case 'select-one':
								$elem.val(vdata).change();
								break;
							case 'checkbox':
								$elem.attr('checked', 'checked');
								break;
							case 'radio':
								$elem.attr('checked', 'checked');
								break;
							default:
								$elem.text(vdata);
								outLog(elem_type);
							}

						} else {
							if ("img".indexOf(tagName) > -1) {
								$elem.attr("src", vdata);
							} else {
								$elem.text(vdata);
							}
							outLog("other controler:" + $elem.tag);
						}
					} else {
						outLog(atr + " never using");
					}
				}
			}
		};
		objFun(jsonData);
	};
	/*****************************************************************************
	 * 获取地址栏查询参数
	 */
	utilExt.getUrlParam = function(name) {
		var reg = new RegExp("(^|&)" + name + "=([^&]*)(&|$)"); // 构造一个含有目标参数的正则表达式对象
		var r = window.location.search.substr(1).match(reg); // 匹配目标参数
		if (r != null)
			return unescape(r[2]);
		return null; // 返回参数值
	};

	/*****************************************************************************
	 * 通用资源请求ajax
	 * 
	 * @param JSONDATA
	 *          格式{cid:id,url:_url,data:jonsparams,ajaxFunc:func,before:func,compile:func}
	 *          【@param {String} url :(ajax地址)
	 * @param {Object}
	 *          data :(json 上传的格式数据)
	 * @param {Function}
	 *          ajaxFunc (json 成功返回数据回调函数)
	 * @param {String}
	 *          cid (如果在服务查询数据,cid定义页面将数据显示容器expression表达式)
	 * @param {Function}
	 *          func1 执行其他函数】
	 * 
	 */
	utilExt.JSONDATA = {
		cid : null,
		url : null,
		data : null,
		ajaxFunc : null,
		before : null,
		complete : null,
		async : true,
		method : "post",
		dataFilter : null,
		dataType : 'json'
	};
	utilExt.sessionDeal = function(msg) {
		layer.alert(msg, {
			icon : 0,
			closeBtn : 0
		}, function() {
			window.parent.parent.parent.location = "default.def";
		});
		return false;
	};
	utilExt.commAJAX = function(JSONDATA) {
		if (typeof JSONDATA == "object" && JSONDATA.url)
			$.ajax({
				// 请求方式
				type : JSONDATA.method || "post",
				data : JSONDATA.data,
				// 请求地址
				url : utilExt.basePath + JSONDATA.url,
				// 处理方式：异步true，同步false
				async : JSONDATA.async || true,
				// 请求发送前处理函数
				beforeSend : function(xhr) {
					// this; // 调用本次AJAX请求时传递的options参数
					layer.load(2);
					var beforefun = JSONDATA.before;
					if (beforefun && typeof beforefun == "function") {
						if (!beforefun.call(beforefun, xhr)) // 提交前检查，返回true 通过
							xhr.abort();
						layer.closeAll('loading');
						return;
					}
					this.url = this.url.replace(/sort%5B%5D/g, "sort");
					if (this.data)
						this.data = this.data.replace(/sort%5B%5D/g, "sort");
				},
				// 请求完成处理函数
				complete : function(xhr, tStatus) {
					var sessionstatus = xhr.getResponseHeader("sessionstatus");
					if (sessionstatus == "timeout") {
						utilExt.sessionDeal('登录超时，请重新登录');
					} else if (sessionstatus == "loginExists") {
						layer.alert("用户已经登录,请忽重复登录");
					} else if (sessionstatus == "loginChange") {
						utilExt.sessionDeal("用户已在其他地方登录");
					}
					layer.closeAll('loading');
					if (tStatus == 'error') {
						outLog("request error");
						outLog(JSON.stringify(this));
					}
					var completefun = JSONDATA.complete;
					if (completefun && typeof completefun == "function") {
						completefun.call(completefun, xhr, tStatus);
						return;
					}
					// this; // 调用本次AJAX请求时传递的options参数
				},
				// 对Ajax返回的原始数据进行预处理
				dataFilter : function(data, type) {
					var dataFilterfun = JSONDATA.dataFilter;
					if (dataFilterfun && typeof dataFilterfun == "function")
						return dataFilterfun.call(dataFilterfun, data, type);
					return data // 返回处理后的数据
				},
				statusCode : {
					404 : function() {
						outLog('page not found 404');
					}
				},
				success : function(data, textStatus, jqXHR) {
					var ajaxFunc = JSONDATA.ajaxFunc;
					if (typeof ajaxFunc == "function") {
						ajaxFunc.call(ajaxFunc, data);
					}
				},
				dataType : JSONDATA.dataType || "json"
			});
	};
	/**
	 * Ajax 全局处理 $.ajaxSetup({ contentType :
	 * "application/x-www-form-urlencoded;charset=utf-8", complete :
	 * function(XMLHttpRequest, textStatus) { outLog("Ajax请求完成" + textStatus); //
	 * 通过XMLHttpRequest取得响应头，sessionstatus var sessionstatus =
	 * XMLHttpRequest.getResponseHeader("sessionstatus"); if (sessionstatus ==
	 * "timeout") { outLog("SESSIONTIMEOUT"); window.location = utilExt.basePath; } },
	 * beforeSend : function(XMLHttpRequest) { outLog("Ajax开始请求"); }
	 * 
	 * });
	 */
	utilExt.dateFormat = function(timestamp, formatStr) {
		var date = timestamp ? (new Date(timestamp)) : (new Date());
		if (!formatStr) {
			formatStr = 'yyyy-mm-dd';
		}
		reg = /[Yy]{4}/g;
		formatStr = formatStr.replace(reg, date.getFullYear());
		reg = /[Mm]{2}/g;
		formatStr = formatStr.replace(reg, utilExt.digit(date.getMonth() + 1));
		reg = /[Dd]{2}/g;
		formatStr = formatStr.replace(reg, utilExt.digit(date.getDate()));
		return formatStr;
	};
	// 补齐数位
	utilExt.digit = function(num) {
		return num < 10 ? '0' + (num | 0) : num;
	};

	/**
	 * 小写金额转大写
	 */
	utilExt.num2Chinese = function(num) {
		if (isNaN(num) || num > Math.pow(10, 12))
			return ""
		var cn = "零壹贰叁肆伍陆柒捌玖"
		var unit = new Array("拾百千", "分角")
		var unit1 = new Array("万亿", "")
		var numArray = num.toString().split(".")
		var start = new Array(numArray[0].length - 1, 2)

		function toChinese(num, index) {
			var num = num.replace(/\d/g, function($1) {
				return cn.charAt($1) + unit[index].charAt(start-- % 4 ? start % 4 : -1)
			})
			return num
		}

		for (var i = 0; i < numArray.length; i++) {
			var tmp = ""
			for (var j = 0; j * 4 < numArray[i].length; j++) {
				var strIndex = numArray[i].length - (j + 1) * 4
				var str = numArray[i].substring(strIndex, strIndex + 4)
				var start = i ? 2 : str.length - 1
				var tmp1 = toChinese(str, i)
				tmp1 = tmp1.replace(/(零.)+/g, "零").replace(/零+$/, "")
				tmp1 = tmp1.replace(/^壹拾/, "拾")
				tmp = (tmp1 + unit1[i].charAt(j - 1)) + tmp
			}
			numArray[i] = tmp
		}

		numArray[1] = numArray[1] ? numArray[1] : ""
		numArray[0] = numArray[0] ? numArray[0] + "元" : numArray[0], numArray[1] = numArray[1].replace(/^零+/, "")
		numArray[1] = numArray[1].match(/分/) ? numArray[1] : numArray[1] + "整"
		return numArray[0] + numArray[1]
	};
	exports('utilExt', utilExt);
});