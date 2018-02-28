/**
 * 
 */
/*****************************************************************************
	 * 获取输入信息 parentTag(expression表达式) 查找范围
	 * 
	 * @param {Object}
	 *          paramId_prefix
	 */

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

   /**
    *  获取输入信息 parentTag
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

	