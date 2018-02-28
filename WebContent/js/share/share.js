/**
 * Created by AISINO on 2017/9/27.
 */
var addHtml = {
    init : function() {
        addHtml.addFloatCircle();
        addHtml.share();
        addHtml.showShare();
    },

    // 添加分享功能
    addFloatCircle : function() {
        /*var floatCircle = '<ul id="share-list">'
         + '<img src="../../images/showPage/float1.png" />' + '</div>'
         + '<div>' + '<img src="../../images/showPage/float2.png" />'
         + '</div>';*/
        var strHtml = ""
            + '<div class="toolbar" >'
            + '<a id="show_qq_list" target="_blank" href="http://wpa.qq.com/msgrd?v=3&uin=2479960206&site=qq&menu=yes" class="toolbar-item toolbar-item-qq" >'
            + '<a href="javascript:;" class="toolbar-item toolbar-item-share">'
            + '<div class="toolbar-layer">'
            + '<ul id="share-list" class="share-list">'
            + '<li class="share-sinaweibo"></li>'
            + '<li class="share-qqweibo"></li>'
            + '<li class="share-qzone"></li>'
            + '<li class="share-weixin"></li>'
            + '</ul>'
            + '</div>'
            + '</a> <a href="javascript:;" class="toolbar-item toolbar-item-weixin"> '
            + '<span class="toolbar-layer"></span></a> '
            + '<a id="backtop" href="javascript:;" class="toolbar-item toolbar-item-top" style="display:none;"></a>'
            + '</div>';
        //$("#floatCircle").append(strHtml);
    },
    //分享显示
    showShare:function(){
        /* $(".share").mouseover(function(){
         $(".shareBox").css('display','block');
         }); */
        $(".share").click(function(){
          //  $(".shareBox").css('display','block');
        });
    },

    // 分享
    share:function(){
        //$("#share-list li").on('click',function() {document.title
        $("#share-list1 li").click(function(){
            var css = $(this).attr("class"), url = location.href, title = $(".title").html(), desc = $(
                'meta[name="description"]').attr('content')
                || '';
            switch (css) {
                case 'share-sinaweibo':
                    url = 'http://v.t.sina.com.cn/share/share.php?url='
                        + url
                        + '&title='
                        + title
                        + ' - '
                        + desc;
                    break;
                case 'share-qqweibo':
                    url = 'http://v.t.qq.com/share/share.php?url='
                        + url
                        + '&title='
                        + title
                        + ' - '
                        + desc;
                    break;
                case 'share-sohuweibo':
                    url = 'http://t.sohu.com/third/post.jsp?link='
                        + encodeURIComponent(url)
                        + '&title='
                        + encodeURIComponent(title);
                    break;
                case 'share-renren':
                    url = 'http://share.renren.com/share/buttonshare.do?link='
                        + encodeURIComponent(url)
                        + '&title='
                        + encodeURIComponent(title);
                    break;
                case 'share-qzone':
                    url = 'http://sns.qzone.qq.com/cgi-bin/qzshare/cgi_qzshare_onekey?url='
                        + url
                        + '&title='
                        + title
                        + '&pics=&summary=' + desc;
                    break;
                case 'share-baidu':
                    url = 'http://cang.baidu.com/do/add?it='
                        + encodeURIComponent(title)
                        + '&iu=' + encodeURIComponent(url)
                        + '&fr=ien#nw=1';
                    break;
                case 'share-qq':
                    url = 'http://connect.qq.com/widget/shareqq/index.html?url='
                        + url
                        + '&title='
                        + title
                        + '&desc=' + title + ' - ' + desc;
                    break;
                case 'share-weixin':
                    var code = window.location.href;
                    var img = '<img src="http://qr.liantu.com/api.php?text='
                        + code + '"/>';
                    layer.open({
                        type : 1,
                        offset : '100px',
                        title : '扫描二维码分享到朋友圈',
                        content : img
                    });
                    return;
                    break;
            }
            window.open(url);
        })
    }
}

