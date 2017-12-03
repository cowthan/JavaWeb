<#assign title="修改补丁 - 账单" />
<#include "layout/header.ftl"/>
                <div class="main   ">


                <#include "layout/sidebar.ftl" />


                    <div class="app-ctn patch-ctn">
                    <h1>添加版本</h1>
                    <form method="POST" action="/Apps/newVersion/appID/4490" enctype="multipart/form-data" style="width:400px;margin:0 auto;">
                                <div class="form-group">
                                    安卓：<input type="text" class="form-control" name="appVersion" placeholder="Version Name">
                                    <input type="text" class="form-control" name="appVersion" placeholder="Version Code">
                      </div>
                        <div class="form-group">
                            iOS：<input type="text" class="form-control" name="appVersion" placeholder="Version Name">
                            <input type="text" class="form-control" name="appVersion" placeholder="Version Code">
                        </div>
                        <div class="form-group">
                            <input type="text" class="form-control" name="appVersion" placeholder="升级描述">
                        </div>
                        <div class="form-group">
                        <input type="text" class="form-control" name="appVersion" placeholder="apk下载地址">
                    </div>
                      <div class="form-group">
                        <input name="appID" type="hidden" value="4490" />
                        <button type="submit" class="btn btn-large btn-block btn-primary"> 提 交 </button>
                      </div>
                    </form>
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

<#include "layout/footer.ftl"/>