<#assign title="历史补丁 - 账单" />
<#include "layout/header.ftl"/>
        <div class="main   ">
    
    <style>
        table {
            width: 700px;
        }
    </style>

        <#include "layout/sidebar.ftl" />



            <div class="app-ctn">
            <h1>历史补丁</h1>
                        <h3 class="app-history-title">App版本:2.0</h3>
                    <table>
                        <tr>
                            <th style="width:70px">补丁版本</th>
                            <th>描述</th>
                            <th style="width:70px">更新时间</th>
                            <th style="width:40px">大小</th>
                            <th style="width:70px">操作</th>
                        <tr>
                        <tr>
                                <td>2</d>
                                <td>22233333</d>
                                <td>2017-11-24 18:25:20</d>
                                <td>23KB</d>
                                <td><a href="${base}/patch/detail" class="btn btn-primary">详情</a></td>
                            </tr><tr>
                                <td>1</d>
                                <td>11111</d>
                                <td>2017-11-24 18:24:20</d>
                                <td>84KB</d>
                                <td><a href="${base}/patch/detail" class="btn btn-primary">详情</a></td>
                            </tr>                </table>    </div>
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