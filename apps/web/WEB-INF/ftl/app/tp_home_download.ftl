<#assign title="App管理平台 - SDK下载" />
<#include "layout/header.ftl"/>
            <div class="main   ">
        
        <style>
        .btn-download {
          display: block;
          width: 350px;
          padding: 20px;
          margin:30px auto 0 auto;
          font-size: 22px;
        }
        .btn-download span {
          display: block;
          font-size: 14px;
          padding:3px;
        }
        .tips {
          text-align: center;
          font-size:14px;
          padding: 5px;
        }
        .sdk-ctn {
          padding:40px;
        }
        </style>
        <div class="sdk-ctn">
          <a href="http://ogmj51oem.bkt.clouddn.com/TinkerDebugTool.apk?v=1.0.1" class="btn btn-download btn-primary">
              Debug Tool 下载(v1.0.1)
              <span>TinkerDebugTool.apk (781.2KB)</span>
            </a>
            <!-- <div class="tips">更新时间：2016-11-15 10:35</div> -->
          <div class="sdk-changelog">
          <h3>更新日志</h3>
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