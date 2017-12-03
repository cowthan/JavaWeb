<#assign title="在线参数 - App管理平台"/>
<#include "layout/header.ftl"/>
            <div class="main   ">
        
        
        <style>
            #configTable {
                width:630px;
            }
            #configTable tr td {
                padding: 8px;
            }
            .del-panel {
                padding:0;
                margin:0;
            }
        
            #wrapper {
                width: 0;
                height: 0;
                position:absolute;
                left:0;
                top:0;
                background-color: rgba(0,0,0,.2);
                z-index: 100;
                display: none;
            }
            #newPanel {
                position: absolute;
                z-index:101;
                left: 450px;
                top: 150px;
                width: 300px;
                background-color: #fff;
                /*border: 5px solid #bbb;*/
                border-radius: 10px;
                padding:25px 30px;
                display: none;
            }
            #newPanel .form-control {
                margin: 10px 0;
            }
            .btn-new {
                width:145px;
                margin-right:5px;
            }
            .btn-cancel {
                width:115px;
            }
            .btn-del {
                width: 70px;
                padding:8px;
                margin:0 auto;
            }
            .config-tips {
                text-align: center;
                padding-top:40px;
            }
        
        </style>
        <#include "layout/sidebar.ftl" />
        
        
            <div class="app-ctn">
                <h1>在线参数</h1>
                           <div class="alert alert-success">新增成功</div>      <table id="configTable">
                    <tr>
                        <th>参数名称</th>
                        <th>参数值</th>
                        <th>操作</th>
                    </tr>
                    <tr>
                            <td>key</td>
                            <td>value</td>
                            <td>
                                <form method="POST" action="/Apps/config/appID/4797" class="del-panel">
                                    <input type="hidden" name="delKey" value="key"/>
                                    <input type="hidden" name="isDel" value="1"/>
                                    <button type="submit" class="btn btn-danger btn-block btn-del" onSubmit="return checkDel();">删除</button>
                                </form>
                            </td>
                        </tr>        </table>
                    <div class="app-history-empty">
                    <a href="javascript:void(0);" class="btn btn-primary" id="newConfig">新增参数</a>
                </div>
        
                <form method="POST" action="/Apps/config/appID/4797" id="newPanel">
                    <input type="text" class="form-control" name="key" placeholder="参数名"/>
                    <input type="text" class="form-control" name="val" placeholder="参数值"/>
                    <div class="form-control">
                        <button type="submit" class="btn btn-primary btn-new">新增</button>
                        <a href="javascript:void(0);" class="btn btn-default btn-cancel">取消</a>
                    </div>
                </form>
        
            </div>
        </div>
        
        <div id="wrapper"></div>
        
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
            $('#newConfig').click(function(){
                $('#wrapper').width($(document).width()).height($(document).height()).show()
                $('#newPanel').show()
            });
            $('.btn-del').click(function(){
                if (confirm("确定删除？")) {
                    $(this).parent().submit();
                }
            })
            $('.btn-cancel').click(function(){
                $('#wrapper').hide();
                $('#newPanel').hide();
            });
        </script>


<#include "layout/footer.ftl"/>