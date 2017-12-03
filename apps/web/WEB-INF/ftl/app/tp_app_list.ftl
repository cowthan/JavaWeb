<#assign title="我的APP - App管理平台"/>
<#include "layout/header.ftl"/>
            <div class="main   ">
        
        <div class="wrapper">
            <div class="app-list">
                <a href="${base}/version/list">
                        <div class="app-icon">
                            <img src="${base}/resource/img/app-icon.png">
                            <span class="mask"></span>
                        </div>
                        <div class="app-list-title">叮咚艺学</div>
                        <div class="app-list-detail">
                            <span>App版本：2.0</span>
                            <span>Patch版本：0</span>
                        </div>
                        <span class="app-list-btn">管理</span>
                        <div class="clear"></div>
                    </a>        <a href="${base}/app/add" class="app-new-btn "><img src="${base}/resource/img/new-app.png"/><span class="app-list-btn">新增APP</span></a>
            </div>
            <div class="clear"></div>
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