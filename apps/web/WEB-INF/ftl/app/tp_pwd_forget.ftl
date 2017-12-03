<#assign title="App管理平台 - 忘记密码"/>
<#include "layout/header.ftl"/>
        <div class="main   ">
    
    
    
    <div class="login-title"><span>忘记密码</span></div>
      <div class="login-field">
      <form method="POST" action="/Index/forgot">
        <div class="alert alert-danger">邮箱地址格式错误</div>        <div class="form-group">
          <input type="email" class="form-control" name="email" placeholder="Email">
        </div>
        <div class="form-group">
          <button type="submit" class="btn btn-large btn-block btn-primary btn-login">重置密码</button>
        </div>
      </form>
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