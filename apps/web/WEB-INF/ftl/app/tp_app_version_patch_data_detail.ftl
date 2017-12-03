<#assign title="实时监控 - 账单" />
<#include "layout/header.ftl"/>
            <div class="main   ">
        
        <link rel="stylesheet" href="//cdnjs.cloudflare.com/ajax/libs/morris.js/0.5.1/morris.css">
        <style>
        .err_list {
            width:640px;
        }
        h1 a{
            color:#34495e;
        }
        .menu {
            text-align: center;
            margin:20px;
        }
        .menu span {
            padding: 5px;
        }
        #errTips {
            padding:10px 20px;
            background-color: #f8f7f3;
            border: 1px solid #eee;
            position: absolute;
            display: none;
            font-size: 14px;
            width:220px;
            text-align: center;
        }
        </style>

            <#include "layout/sidebar.ftl" />



                <div class="app-ctn">
                <h1><a href="/Apps/stat/appID/1326/av/5.7.7/pv/1">实时监控</a> - 错误列表</h1>
        
        
                <div class="menu">
                    <span>App版本：5.7.7 </span>
                    <span>补丁版本：1 </span>
                </div>
                <table class="err_list">
                    <tr>
                        <th>出现次数</th>
                        <th>最后出现时间</th>
                        <th>错误码</th>
                        <th>错误提示<th>
                    </tr>
                    <tr>
                        <td>59</td>
                        <td>2017-11-20 23:00:48</td>
                        <td>-201</td>
                        <td class="errHint">-201</td>
                    <tr><tr>
                        <td>19</td>
                        <td>2017-11-01 13:47:56</td>
                        <td>-200</td>
                        <td class="errHint">-200</td>
                    <tr><tr>
                        <td>1460</td>
                        <td>2017-11-22 23:52:48</td>
                        <td>-203</td>
                        <td class="errHint">-203</td>
                    <tr><tr>
                        <td>41</td>
                        <td>2017-11-08 02:16:20</td>
                        <td>-204</td>
                        <td class="errHint">-204</td>
                    <tr><tr>
                        <td>15</td>
                        <td>2017-11-09 19:43:02</td>
                        <td>-103</td>
                        <td class="errHint">-103</td>
                    <tr><tr>
                        <td>29</td>
                        <td>2017-11-17 03:08:19</td>
                        <td>-241</td>
                        <td class="errHint">-241</td>
                    <tr><tr>
                        <td>140</td>
                        <td>2017-11-23 15:31:59</td>
                        <td>-101</td>
                        <td class="errHint">-101</td>
                    <tr><tr>
                        <td>2</td>
                        <td>2017-11-04 15:23:40</td>
                        <td>-107</td>
                        <td class="errHint">-107</td>
                    <tr><tr>
                        <td>1</td>
                        <td>2017-10-29 13:05:32</td>
                        <td>-240</td>
                        <td class="errHint">-240</td>
                    <tr><tr>
                        <td>6</td>
                        <td>2017-11-13 12:35:01</td>
                        <td>-104</td>
                        <td class="errHint">-104</td>
                    <tr><tr>
                        <td>3</td>
                        <td>2017-11-02 10:20:19</td>
                        <td>-102</td>
                        <td class="errHint">-102</td>
                    <tr><tr>
                        <td>1</td>
                        <td>2017-11-10 22:28:37</td>
                        <td>-100</td>
                        <td class="errHint">-100</td>
                    <tr>        </table>
                <div id="errTips">ss</div>
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
        var errMsg = {
            // JSPatch Error
            "-1001": "NSURLErrorTimedOut 请求超时",
            "-1005": "NSURLErrorNetworkConnectionLost 网络无法连接",
            "5001": "脚本解包失败",
            "5002": "脚本内容解包失败",
            "5003": "脚本验证失败",
            "5004": "脚本文件丢失",
            "5005": "脚本验证文件丢失",
            "5006": "解密验证文件失败",
            "5007": "网络错误",
        
        
            // TinkerPatch Error
            "-1": "下载补丁时异常",
            "-2": "合成补丁时异常",
            "-3": "加载补丁时异常",
        
            "-100": "补丁加载出现异常",
            "-101": "补丁加载进入安全模式",
            "-102": "补丁加载Dex时出现异常",
            "-103": "补丁加载Dex时检测失败",
            "-104": "补丁加载资源时出现异常",
            "-105": "补丁加载资源时检测失败",
            "-106": "补丁解释执行时获取instruction set出现异常",
            "-107": "补丁解释执行时命令行出错",
        
            "-200": "补丁合成出现异常",
            "-201": "补丁合成dexopt文件出现异常",
            "-202": "补丁合成patch.info文件损坏",
            "-203": "补丁合成dexopt文件不存在",
            "-204": "补丁合成dexopt文件格式异常",
            "-205": "补丁合成不支持JIT模式",
        
            "-210": "补丁合成签名校验失败",
            "-211": "补丁合成dex meta文件损坏",
            "-212": "补丁合成library meta文件损坏",
            "-213": "补丁合成无法从安装包找到tinkerId",
            "-214": "补丁合成无法从补丁包找到tinkerId",
            "-215": "补丁合成package meta文件损坏",
            "-216": "补丁合成tinkerId不相等",
            "-217": "补丁合成res meta文件损坏",
            "-218": "补丁合成存在不支持的类型",
        
            "-230": "补丁合成版本校验失败",
            "-240": "补丁合成补丁包失败",
            "-241": "补丁合成dex文件失败\n(patch是否基于正确的base包生成?)",
            "-242": "补丁合成library文件失败",
            "-243": "补丁合成资源文件失败",
        }
        
        // $('.err_list td').mouseenter(function(){
        //     var $this = $(this);
        //     var msg = errMsg[$this.text()] ? errMsg[$this.text()] : "未知错误";
        //     var pos = $this.position()
        //     $('#errTips').text(msg)
        //     $('#errTips').css({left: pos.left, top: pos.top + 50}).show()
        // }).mouseleave(function(){
        //     $('#errTips').hide()
        // })
        
        elems = document.getElementsByClassName("errHint");
        for(var i = 0; i < elems.length; i++) {
            var elem = elems[i]
            var msg = errMsg[elem.innerText] ? errMsg[elem.innerText] : "未知错误";
            elem.innerText = msg;
        }
        
        </script>

<#include "layout/footer.ftl"/>