<#assign title="App管理平台 - 价格表" />
<#include "layout/header.ftl"/>
        <div class="main   ">
    
    <style>
    
    .price-list{
        text-align: center;
        padding:50px 0;
    }
    .price-wrapper {
        width: 290px;
        float:left;
        margin:10px;
    }
    .price-item{
        width: 290px;
        height: 400px;
        display: block;
        /*border:1px solid #e8eaea;*/
        border-radius: 8px;
        background-color: #fff;
        position:relative;
    }
    .price-item h3 {
        margin:0;
        padding:45px;
        text-align: center;
        font-size: 24px;
        color: #fff;
        font-weight: normal;
    }
    .price-item .header {
        border-radius: 8px 8px 0 0 ;
        background-color: rgb(87,183,156);
        color:#fff;
        font-size:14px;
        padding-bottom:4px;
    }
    .price-standard .header{
        background-color: rgb(46,154,226);
    }
    .price-ee .header {
        background-color: rgb(87,183,156);
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
        padding:8px 9px;
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
    .price-wrapper ul {
        padding:15px 0;
        margin:0;
        font-size: 14px;
    }
    .price-wrapper ul li {
        list-style: none;
        text-align: center;
        padding:5px;
        margin:0;
    }
    .price-wrapper ul li a {
        color:#34495e;
    }
    .price-wrapper ul li a:hover {
        color:#16a085;
    }
    .price-wrapper ul li .remark {
        font-size:12px;
        color:#999;
    }
    .price-item .price {
        padding:50px;
        text-align: center;
        font-size: 32px;
    }
    .price-item .price-tinker {
        padding-bottom:20px;
    }
    .price .price-flow{
        display: block;
        padding: 15px;
        font-size:14px;
    }
    
    .faq {
        width:800px;
        margin:10px auto;
        padding-bottom:60px;
    }
    .faq h2 {
        font-size:34px;
        text-align: center;
    }
    .faq h3 {
        font-size: 24px;
        padding:20px 0 5px 0;
    }
    </style>
    <div class="wrapper">
    
        
    
    
        <div class="price-list">
            <div class="price-wrapper">
                <div class="price-item">
                    <div class="header">
                        <h3>基础版</h3>
                        <span>日请求量：</span>
                        <span class="active active-selected"><1w</span>
                    </div>
    
                    <div class="price price-tinker">免费<span class="price-flow">赠流量包10G</span></div>
    
                    <a href="/Apps" class="btn btn-default">开始使用</a>
                </div>
                <ul>
                    <li>最大补丁大小:500k</li>
                    <li>APP/补丁数量无限制</li>
                    <li>历史补丁保存</li>
                    <li><a href="/Docs/config">在线参数</a></li>
                    <li><a href="/Docs/monitor">实时监控</a></li>
                    <li>最大补丁大小:500k</li>
                </ul>
            </div>
            <div class="price-wrapper">
                <div class="price-item price-standard">
                    <div class="header">
                        <h3>标准版</h3>
                        <span>日请求：</span>
                        <span class="active active-selected" data-num="10"><a href="javascript:void(0);"><10w</a></span>
                        <span class="active active-unselected" data-num="25"><a href="javascript:void(0);"><25w</a></span>
                        <span class="active active-unselected" data-num="50"><a href="javascript:void(0);"><50w</a></span>
                        <span class="active active-unselected" data-num="100"><a href="javascript:void(0);"><100w</a></span>
                    </div>
                    <div class="price price-tinker">
                        <span id="price10" class="price-month">399元/月 <span class="price-flow">赠流量包200G</span></span>
                        <span id="price25" class="price-month" style="display:none">899元/月 <span class="price-flow">赠流量包500G</span></span>
                        <span id="price50" class="price-month" style="display:none">1699元/月 <span class="price-flow">赠流量包1T</span></span>
                        <span id="price100" class="price-month" style="display:none">2899元/月 <span class="price-flow">赠流量包2T</span></span>
                    </div>
                    <a href="/Pay" class="btn btn-info">购 买</a>
                </div>
                <ul>
                    <li>1对1问题跟进解决</li>
                    <li>补丁大小无限制</li>
                    <li>APP/补丁数量无限制</li>
                    <li>历史补丁保存</li>
                    <li><a href="/Docs/config">在线参数</a></li>
                    <li><a href="/Docs/monitor">实时监控</a></li>
                    <li><a href="/Docs/rule">灰度下发</a></li>
                    <li><a href="/Docs/rule">条件下发</a></li>
                </ul>
            </div>
            <div class="price-wrapper">
                <div class="price-item price-ee">
                    <div class="header">
                        <h3>定制版</h3>
                        日请求量：
                        <span class="active active-selected">不限</span>
                    </div>
                    <div class="price">联系我们</div>
                        <a href="mailto:jspatch@qq.com" class="btn btn-default buy-btn">联系我们</a>
                </div>
    
                <ul>
                    <li>所有功能无限制</li>
                    <li>日请求量无限制</li>
                    <li>功能定制</li>
                    <li>自建服务器</li>
                    <li>1对1问题跟进解决</li>
                </ul>
            </div>
            <div class="clear"></div>
        </div>
        <div class="faq">
            <h2>常见问题</h2>
            <h3>各个版本的区别？</h3>
    
            <p>基础版只支持日请求量1w以下的APP，同时每月流量10G，标准版分10w/25w/50w/100w四个量级，附赠不同的流量包，并支持灰度下发/条件下发等功能。定制版根据用户具体需求量身定制，可以<a href="mailto:admin@tinkerpatch.com">联系我们</a>了解详情。</p>
    
            <h3>如何计算日请求量？</h3>
    
            <p>日请求量目前以每日调用 <a href="/User/req">fetchPatchUpdate</a> 的次数为准，平台会计算十天内的日请求量的中位数决定账户应该属于哪个量级。日请求量是算一个账户里所有APP的累计请求，例如账号里有两个APP，一个日请求量2w，一个日请求量5k，那这个用户累计日请求量2.5w，属于标准版<10w量级。</p>
    
            <h3>日请求量超过购买的量级会怎样？</h3>
    
            <p>对于基础版用户，若量级超过日请求量1w，会无法下发新的补丁，但已下发的补丁会正常运行。</p>
            <p>对于标准版用户，若是按月购买，用户增长到平均日请求量大于购买的量级，当月可以继续正常使用，下个月续费时再选用合适的量级。若是按年购买，我们会联系你商讨升级方案。</p>
    
            <h3>流量超出会怎样？</h3>
    
            <p>标准版每一档所配的流量一般已经可以满足需求。若补丁较大并下发得较频繁，当月流量超出时，会无法下发新的补丁，但已下发的补丁会正常运行，需要另外购买流量或升级套餐才能继续下发。超出流量价格为0.5元/G。</p>
    
            <h3>可以试用标准版吗？</h3>
    
            <p>可以，每个新注册的用户会有30天的标准版试用期，不限日请求量，只限流量10G。到期后若没有续费会自动降为基础版。1月11日以前注册的用户试用期会一直延期到2月10日。</p>
    
            <h3>我还有其他问题</h3>
    
            <p>欢迎<a href="mailto:admin@tinkerpatch.com">联系我们</a>。</p>
            <p></p>
        </div></div>
    
    <div class="clear"></div>
    <div id="fill"></div>
    </div>
    <div class="ft">
      <span class="copyright">
            TinkerPatch.com     © 2017 </span>
      <span class="links">
              <a href="https://github.com/tinkerPatch">Github开源</a> | <a href="/Docs/contract">用户协议</a> |<a href="mailto:admin@tinkerpatch.com">联系我们</a></span>  </span>
    </div>
    
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
    $('.price-standard .header a').click(function(){
        $('.price-standard .active').removeClass('active-selected').addClass('active-unselected')
        $(this).parent().removeClass('active-unselected').addClass('active-selected')
        $('.price-month').hide();
        $('#price'+$(this).parent().data('num')).show();
    })
    </script>

<#include "layout/footer.ftl"/>