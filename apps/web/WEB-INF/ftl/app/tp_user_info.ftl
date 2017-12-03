<#assign title="App管理平台 - 用户信息"/>
<#include "layout/header.ftl"/>
        <div class="main   ">
    
    
    <div class="wrapper">
    <div class="login-title">我的帐号</div>
    <div class="login-field">
    <form method="POST" action="/User">
          <div class="form-group">
        <p>帐号：gezi@dongqiudi.com 
        </p>
        <p>
          <notempty name="level">
          <p>帐号量级：<25w</p>
          
                                  <div>标准版 (<10w量级，2017-11-28 到期，剩余 
                  <span style="color:red">4</span> 
                                天 <a href="/Pay">续费</a>)</div>      </empty>
    
        </p>
    
        <p><a href="/User/req">帐号请求详情</a></p>
        
      </div>
          <div class="form-group">
          <input type="password" class="form-control" name="pwd" placeholder="原密码">
        </div>
        <div class="form-group">
          <input type="password" class="form-control" name="new_pwd" placeholder="新密码">
        </div>
        <div class="form-group">
          <input type="password" class="form-control" name="new_pwd_confirm" placeholder="再次输入新密码">
        </div>
        <div class="form-group">
          <button type="submit" class="btn btn-large btn-block btn-primary">修改密码</button>
        </div>  
      <a class="btn btn-large btn-danger btn-logout btn-block" href="/Index/logout">退出登录</a>
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