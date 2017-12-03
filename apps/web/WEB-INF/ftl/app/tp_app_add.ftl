<#assign title="创建App - App管理平台"/>
<#include "layout/header.ftl"/>
            <div class="main   ">
        
        <style>
        .dropdown-menu {
          width:400px!important;
          overflow: hidden;
        }
        
        .app-new-ctn {
            width:400px;
            margin:0 auto;
            padding-top:20px;
            padding-bottom:70px;
        }
        .app-new-ctn h1 {
            font-size:35px;
            padding:20px;
            text-align: center;
        }
        .app-new-appid {
            width:350px!important;
            float: left;
        }
        .app-new-help {
            margin-left: 10px;
        }
        .app-new-help-content {
            clear: both;
            margin-top:20px;
            font-size:14px;
        }
        .app-new-help-content span {
            color: red;
        }
        
        </style>
        <div class="wrapper">
            <div class="app-new-ctn">
                <h1>添加APP</h1>
                <form method="POST" action="/Apps/newapp">
                            <div class="form-group">
                    <input type="text" class="form-control" name="name" placeholder="App名"  data-provide="typeahead" id="appNameInput">
                  </div>
                            <div class="form-group">
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
        
        
        