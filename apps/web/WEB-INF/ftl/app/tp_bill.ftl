<#assign title="App管理平台 - 账单" />
<#include "layout/header.ftl"/>
            <div class="main   ">
        
        <div class="wrapper">
        
        
            <!--h1 class="bill-overview-title">本月概况 <span>(  —  )</span></h1>
            <div class="bill-overview">
        
               <span class="bill-overview-left">免费请求量占比()</span>
                <span class="bill-overview-right"><a href="/Bill/detail">请求详情</a> | <a href="/Docs/price">价格详情</a></span>
                <div class="clear"></div>
                <div class="bill-percent"><span style="width:"></span></div>
        
            </div>
        
                <table class="table-bill-overview">
                    <tr class="table-hd">
                        <th>合计请求数</th>
                        <th>免费请求数</th>
                        <th>价格</th>
                        <th>超出请求数</th>
                        <th>超出金额</th>
                    </tr>
                    <tr>
                        <td></td>
                        <td>/月</td>
                        <td>1元/次请求</td>
                        <td></td>
                        <td>￥</td>
                    </tr>
                </table--> 
        
            <h1 class="paid-title">标准版账单</h1>
                <table class="bill">
                    <tr class="bill-hd">
                        <th>账单编号</th>
                        <th>创建日期</th>
                        <th>量级</th>
                        <th>月数</th>
                        <th>总金额</th>
                        <th>支付账号</th>
                        <th>账单状态</th>
                    </tr>
                    <tr>
                            <td>3ff7daeb8605f989</td>
                            <td>2017年10月28日</td>
                            <td><10w</td>
                            <td>1个月</td>
                            <td>￥399</td>
                            <td>hengxin196@gmail.com</td>
                            <td><span class="green">已生效</span>
                                </td>
                        </tr><tr>
                            <td>98b84f389753fb89</td>
                            <td>2017年11月24日</td>
                            <td><25w</td>
                            <td>12个月</td>
                            <td>￥8990</td>
                            <td>admin</td>
                            <td>                        <span class="red">核对中</span></td>
                        </tr>        </table>
            
        
        
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
        
        <script type="text/javascript">
        
          $('[data-toggle="tooltip"]').tooltip()
        
            var fillPadding = function() {
                $('#fill').height($('#fill').height() + window.innerHeight - ($('.main').offset().top + $('.main').height() + $('.ft').height()))
            }
            $(window).resize(fillPadding);
            fillPadding();
            $('.ft').show();
        </script>
<#include "layout/footer.ftl"/>