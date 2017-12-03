<#assign title="编辑APP - App管理平台"/>
<#include "layout/header.ftl"/>
            <div class="main   ">
        
        <style>
        .dropdown-menu {
          width:450px!important;
          overflow: hidden;
        }
        .app-actions {
            margin: 70px auto 20px auto;
            width:150px;
        }
        .app-delete-btn {
            width: 150px!important;
            padding: 15px 0!important;
            margin:0 10px!important;
            float: left;
        }
        
        .app-delete-panel {
            clear:both;
            width: 300px;
            background: #eaeaea;
            border-radius: 10px;
            padding:10px 30px 5px 30px;
            margin: 10px auto;
            display: none;
        }
        
        .app-delete-panel h4{
            font-size: 20px;
            text-align: center;
        }
        
        .app-delete-panel p {
            font-size:14px;
        }
        
        .app-delete-panel .btn {
            width: 115px!important;
        }
        </style>
        
        
        
        <div id="deleteModal" class="modal hide fade" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
          <div class="modal-header">
            <button type="button" class="close" data-dismiss="modal" aria-hidden="true">×</button>
            <div class="modal-title">确定删除此 App？</div>
          </div>
          <div class="modal-body">
            <p>需删除所有版本补丁后才能删除App。</p>
          </div>
          <div class="modal-footer">
            <form method="POST" action="/Apps/edit/id/1326" style="margin:0">
                <input name="isDel" type="hidden" value="1" />
                <button class="btn btn-default" data-dismiss="modal" aria-hidden="true">取消</button>
                <button class="btn btn-danger" type="submit">确定删除</button>
            </form>
          </div>
        </div>



            <#include "layout/sidebar.ftl" />



                <div class="app-ctn">
                <h1>APP 信息</h1>
                <form method="POST" action="/Apps/edit/id/1326" class="app-info-form">
                                      <div class="form-group">
                    <label>APP 名称:</label>
                    <input type="text" class="form-control" id="appNameInput" name="name" value="懂球帝" placeholder="App名">
                  </div>
                            <div class="form-group">
                    <button type="submit" class="btn btn-large btn-block btn-primary"> 修 改 </button>
                  </div>
                </form>
        
                <div class="app-actions">
                    <a href="#deleteModal" class="btn btn-large btn-danger btn-block app-delete-btn" data-toggle="modal">删除此App</a>
                    <div class="clear"></div>
                </div>
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
        $('#appNameInput').typeahead({
            autoSelect: true,
            delay: 200,
            source: function (query, process) {
              $.ajax({
                  url: '/Apps/search',
                  data: {q: query},
                  dataType: 'json'
              })
              .done(function(response) {
                  return process(response);
              });
            },
            matcher: function(item) {
              return true;
            },
            afterSelect: function(item) {
              $('#appIdInput').val(item['appId']);
            }
        });
        </script>


<#include "layout/footer.ftl"/>