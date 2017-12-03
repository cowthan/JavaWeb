
<html>
    <head>
        <meta charset="utf-8">
        <title>文档 - Tinker Platform - Android 热补丁平台</title>
            <meta name="description" content="Tinker 平台提供 Android APP 热更新服务，APP 接入 Tinker 平台后，可以随时下发补丁包，实时更新APP">    <link rel="stylesheet" href="/Public/css/bootstrap.min.css?v=1.2" />
        <!-- <link rel="stylesheet" href="/Public/css/flat-ui.min.css" /> -->
        <link rel="stylesheet" href="/Public/css/main.css?v=1.4" />
        <link rel="shortcut icon" href="/Public/img/tinker/favicon.ico" type="image/x-icon" />
    </head>
    
    <body>
        <div class="hd">
            <div class="wrapper">
                <a href="/" class="logo-tinker"></a>
                <ul>
                        <li><a href="/tp_home_login.html" class="">登录</a></li>
                        <li><a href="/tp_home_account_info.html" class="">我的帐号</a></li>
                        <li><a href="/tp_home_download.html" class=""> SDK下载 </a></li>
                        <li><a href="" class=""> 文档 </a></li>
                        <li><a href="/tp_bill.html" class="">账单</a></li>
                        <li><a href="/tp_home_price.html" class="">价格</a></li>
                        <li><a href="/tp_app_list.html" class="">我的App</a></li>
                      </ul>
            </div>
        </div>
        <div class="main   ">
    
    <style>
    
    
    .pay-wrapper {
        padding:50px;
    }
    .pay{
        width: 500px;
        display: block;
        /*border:1px solid #e8eaea;*/
        border-radius: 8px;
        background-color: #fff;
        position:relative;
        margin:0 auto;
        text-align: center;
    }
    .pay-head {
        margin:0;
        padding:45px;
        text-align: center;
    }
    .pay h3 {
        font-size: 24px;
        color: #fff;
        font-weight: normal;
        padding:0;
        margin:0;
    }
    .pay-level {
        font-size: 13px;
        padding:7px;
        color: #eee;
    }
    .pay .header {
        border-radius: 8px 8px 0 0 ;
        background-color: rgb(46,154,226);
        color:#fff;
        font-size:14px;
        padding-bottom:4px;
    }
    .pay-type {
        padding:30px 0 10px 0;
    }
    .pay-type label{
        line-height: 1.5;
    }
    .price-area {
        padding:30px 0 40px 0;
    }
    .price-area .price {
        font-size: 30px;
        line-height: 1.5em;
    }
    .year-coupon {
        font-size:14px;
        display: block;
    }
    .year-coupon .discount {
        color: red;
    }
    .year-coupon .orig {
        text-decoration: line-through;
    }
    .next-btn {
        margin: 10px 0 40px 0;
    }
    .qr {
        padding:30px 0 40px 0;
        border-top:1px solid #ccc;
    }
    .qr p {
        padding-bottom:10px;
    }
    .form {
        padding:30px 0 20px 0;
        border-top:1px solid #ccc;
    }
    .form form {
        width:280px;
        margin:0 auto;
    }
    .alert {
        width:500px;
        margin: 0px auto 30px auto;
        padding: 10px 0 10px 20px;
    }
    
    .active, .active a {
        -webkit-transition: none;
        -moz-transition: none;
        -ms-transition: none;
        -o-transition: none;
        transition: none;
    }
    .active-selected {
        background-color: #fff;
        padding:8px 12px;
        border-radius: 8px 8px 0 0;
        color:#000;
    }
    .active-selected a{
        color:#000!important;
    }
    .active-unselected a{
        color:#eee;
        font-size:14px;
        padding:8px 6px;
    }
    .active-unselected a:hover{
        color:#fff;
        font-size:14px;
        padding:8px 6px;
    }
    .pay-tips {
        text-align: center;
        padding:10px;
        font-size: 14px;
    }
    </style>
    <div class="wrapper">
        <div class="pay-wrapper">
            <div class="pay">
                <div class="header">
                    <div class="pay-head">
                        <h3>购买标准版</h3>
                        <div class="pay-level">
                            你的账号属于<25w量级
                        </div>
                    </div>
    
                    <span>日请求量：</span>
    
                                        <span class="active active-selected" data-price="399" data-level="1"><a href="javascript:void(0);"><10w</a></span>
                        <span class="active active-unselected" data-price="899" data-level="2"><a href="javascript:void(0);"><25w</a></span>
                        <span class="active active-unselected" data-price="1699" data-level="3"><a href="javascript:void(0);"><50w</a></span>
                        <span class="active active-unselected" data-price="2899" data-level="4"><a href="javascript:void(0);"><100w</a></span>
                </div>
    
                <div class="pay-type">
                    <label class="radio-inline radio">
                        <input type="radio" name="level" value="year" checked="checked" />按年购买
                    </label>
                    <label class="radio-inline radio">
                        <input type="radio" name="level" value="month" />按月购买
                    </label>
                </div>
    
    
                <div class="price-area">
                    <span class="price">399元/月</span>
                    <div class="year-coupon">
                        <span class="orig"></span>
                        <span class="discount">8.3折优惠</span>
                    </div>
                    <div class="multipal">
                        ×
                        <select id="monthMultipal">
                            <option value="1">1个月</option>
                            <option value="2">2个月</option>
                            <option value="3">3个月</option>
                            <option value="4">4个月</option>
                            <option value="5">5个月</option>
                            <option value="6">6个月</option>
                            <option value="7">7个月</option>
                            <option value="8">8个月</option>
                            <option value="9">9个月</option>
                            <option value="10">10个月</option>
                            <option value="11">11个月</option>
                        </select>
                    </div>
                </div>
    
                <div class="qr" style="display:none">
                    <p>使用<strong style="color:#1cabeb">支付宝</strong>(与JsPatch共用一个账户)扫描以下二维码，支付金额 <strong id="payMoney"></strong>：</p>
                                        <img src="/Public/img/tinker/qr.png" style="width:200px;height:200px" />            </div>
    
                <div class="form" style="display:none">
                    <p>请提交支付时使用的支付宝用户名:</p>
                    <form method="POST" action="/Pay">
                        <div class="form-group">
                            <input type="hidden" name="paidMoney" id="paidMoney" />
                            <input type="hidden" name="monthCount" id="monthCount" />
                            <input type="hidden" name="level" id="level" />
                            <input type="text" class="form-control" name="account" placeholder="支付宝用户名" />
                        </div>
                        <div class="form-group">
                            <button type="submit" class="btn btn-large btn-block btn-primary">
                                提 交
                            </button>
                        </div>
                    </form>
                </div>
    
                <a href="javascript:void(0)" class="btn btn-info next-btn">下一步</a>
    
            </div>
        </div>
    </div>
    
    <div class="clear"></div>
    <div id="fill"></div>
    </div>
    <div class="ft">
      <span class="copyright">
            TinkerPatch.com     © 2017 </span>
      <span class="links">
              <a href="https://github.com/tinkerPatch">Github开源</a> | <a href="/Docs/contract">用户协议</a> |<a href="mailto:admin@tinkerpatch.com">联系我们</a></span>  </span>
    </div>
    
    <script src="/Public/js/jquery-1.11.3.min.js"></script>
    <script src="/Public/js/bootstrap.min.js?v=1.2"></script>
    <script type="text/javascript">
    
      $('[data-toggle="tooltip"]').tooltip()
    
      var fillPadding = function() {
        $('#fill').height($('#fill').height() + window.innerHeight - ($('.main').offset().top + $('.main').height() + $('.ft').height()))
      }
      $(window).resize(fillPadding);
      fillPadding();
        $('.ft').show();
    </script>
    
      <script>
        (function(i,s,o,g,r,a,m){i['GoogleAnalyticsObject']=r;i[r]=i[r]||function(){
        (i[r].q=i[r].q||[]).push(arguments)},i[r].l=1*new Date();a=s.createElement(o),
        m=s.getElementsByTagName(o)[0];a.async=1;a.src=g;m.parentNode.insertBefore(a,m)
        })(window,document,'script','//www.google-analytics.com/analytics.js','ga');
    
        ga('create', 'UA-1895639-14', 'auto');
        ga('send', 'pageview');
      </script>
    </body>
    </html>
    
    <script>
    var m = [399, 399, 899, 1799, 3599];
    var level = 2 || 0;
    $('.active').removeClass('active-selected').addClass('active-unselected')
    $('.active[data-price^=' + m[level] + ']').addClass('active-selected')
    updatePrice()
    
    if (!level) {
        $('.pay-level').hide();
    }
    
    $('.pay .header a').click(function(){
        $('.active').removeClass('active-selected').addClass('active-unselected')
        $(this).parent().removeClass('active-unselected').addClass('active-selected')
        updatePrice()
    })
    $('.pay-type input').change(function(){
        updatePrice()
    })
    $('.next-btn').click(function(){
        if (!$('.qr').is(":visible")) {
            $('.qr').show()
        } else {
            $('.form').show()
            $(this).hide()
        }
    
    })
    
    $('#monthMultipal').change(function(){
        updatePrice();
    })
    
    function updatePrice() {
        var isYear = $('.pay-type input:checked').val() == 'year'
        var price = $('.active-selected').data('price')
        var level = $('.active-selected').data('level')
        var totalPrice = price;
        if (isYear) {
            totalPrice = price*10;
            $('.price').text(price*10+'元/年')
            $('.year-coupon .orig').text(price*12+'元/年')
            $('#payMoney').text(price*10 + '元')
            $('.year-coupon').show()
            $('#paidMoney').val(totalPrice)
            $('#monthCount').val(12)
            $('#level').val(level)
            $('.multipal').hide()
        } else {
            totalPrice = $('#monthMultipal option:selected').val() * price;
            $('.price').text(price+'元/月')
            $('#payMoney').text($('#monthMultipal option:selected').val() * price + '元')
            $('.year-coupon').hide()
            $('#paidMoney').val(totalPrice)
            $('#monthCount').val($('#monthMultipal option:selected').val())
            $('#level').val(level)
            $('.multipal').show()
        }
        var imgPrefix = "/Public/img/qr/";
        var qrImg = ""
        switch (totalPrice) {
            case 399:
                qrImg = imgPrefix + '399.png';
                break;
            case 899:
                qrImg = imgPrefix + '899.png';
                break;
            case 1799:
                qrImg = imgPrefix + '1799.png';
                break;
            case 3599:
                qrImg = imgPrefix + '3599.png';
                break;
            case 3990:
                qrImg = imgPrefix + '3990.png';
                break;
            case 8990:
                qrImg = imgPrefix + '8990.png';
                break;
            case 17990:
                qrImg = imgPrefix + '17990.png';
                break;
            case 35990:
                qrImg = imgPrefix + '35990.png';
                break;
            case 1197:
                qrImg = imgPrefix + '1197.png';
                break;
            default:
                qrImg = imgPrefix + 'normal.png';
                break;
        }
        $('#qrCode').attr('src', qrImg);
        $('#payErrorBtn').click(function(){
            $('#qrCode').attr('src', imgPrefix + 'normal.png');
            $(this).parent().html('请重新扫以上二维码支付');
        })
    }
    
    </script>