<#assign title="发布补丁 - 账单" />
<#include "layout/header.ftl"/>
            <div class="main   ">
        
        <style>
        
        .patch-ctn {
            padding:30px 10px;
            float: left;
            width:650px;
        }
        .patch-ctn h1 {
            font-size:35px;
            text-align: center;
            padding-bottom: 20px;
        
        }
        #patch-form {
            width: 430px;
            margin:0 auto;
        }
        .btn-patch-new, .btn-patch-del{
            float:right;
            font-size: 20px!important;
            padding-top:5px!important;
            padding-bottom: 5px!important;
            width:40px;
        }
        .patch-rsa {
          padding: 10px 0;
        }
        
        
        .patch-form-gray select{
          width: 100px;
        }
        .patch-submit {
          margin:20px 10px;
        }
        
        .patch-form-gray-count {   
            width: 180px!important;
            height: 31px!important;
            font-size: 14px!important;
        }
        .patch-form-condition {
            margin: 10px 0;
        }
        .patch-form-condition input {
          width:310px;
        }
        .patch-form-condition select {
          height:42px;
          float: right;
        }
        
        .patch-delete-btn-new {
           width:130px;
           margin:0 auto;
        }
        
        .patch-content-menu {
          font-size: 14px;
          padding-bottom:5px;
        }
        .patch-content-menu a {
          color: #888;
        }
        .patch-content-menu a:hover {
          color: #000;
        }
        .patch-content-menu a.selected{
          color: #000;
        }
        .patch-content-menu span {
          padding-right:10px;
        }
        .patch-content-menu span .tips {
          float:right;
          font-size: 13px;
          color: #888;
          display: none;
        }
        
        
        .textarea-ctn {
            padding:10px;
            width:100%;
            margin:0 auto;
            height:240px;
        }
        
        #patchTextPanel{
          display: none;
        }
        
        #patchTextFooter {
          font-size: 14px;
          padding:5px 0;
          line-height: 30px;
        }
        #patchTextSelectArea {
          width: 300px;
          display: inline;
        }
        .patch-text-covnertor {
          display: block;
          float: right;
        }
        #conditionSelect {
          width: 110px;
        }
        </style>
        
        
        <div id="deleteModal" class="modal hide fade" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
          <div class="modal-header">
            <button type="button" class="close" data-dismiss="modal" aria-hidden="true">×</button>
            <div class="modal-title">确定删除此版本？</div>
          </div>
          <div class="modal-body">
            <p>此版本未下发补丁，删除对客户端无影响。</p>
          </div>
          <div class="modal-footer">
            <form method="POST" action="/Apps/patch/id/7523" style="margin:0">
                <input name="appVersion" type="hidden" value="2.0"/>
                <input name="patchID" type="hidden" value="7523" />
                <input name="appID" type="hidden" value="4490" />
                <input name="isDel" type="hidden" value="1" />
                <button class="btn btn-default" data-dismiss="modal" aria-hidden="true">取消</button>
                <button class="btn btn-danger" type="submit">确定删除</button>
            </form>
          </div>
        </div>



            <#include "layout/sidebar.ftl" />


                <div class="patch-ctn">
                <h1>发布补丁</h1>
                    
                <form id="patch-form" method="POST" action="/Apps/patch/id/7523" enctype="multipart/form-data">
        
                            
                  <div class="form-group">
                    <div class="patch-info">
                        <span>App版本号：2.0</span>
                    </div>
                  </div>
                  <div class="form-group">
                    <div class="patch-content-menu">
                                      <span>补丁文件</span>
                    </div>
                    <div id="patchFilePanel">
                      <input id="patchFile" type="file" style="display:none" name="patch">  
                      <div class="input-append">  
                          <input id="patchFileInput" class="input-large" type="text" style="    height: 41px;border-right: none;box-shadow: none;border-radius:6px 0 0 6px;width:340px" disabled="disabled" placeholder='请选择补丁文件'>  
                          <a class="btn btn-info" onclick="$('input[id=patchFile]').click();">选择文件</a>  
                      </div>  
                    </div>
                  
                  </div>
                  <div class="form-group">
                    <label>补丁描述</label>
                    <input type="text" class="form-control" name="description" placeholder="" />
                  </div>
        
                  
                  <div class="patch-rule-swich">
                    <div class="radio radio-inline">
                      <label><input name="rule" type="radio" value="3" checked="checked" /> 开发预览 <a href="/Docs/dev" target="_blank">(?)</a></label> 
                    </div>
                    <div class="radio radio-inline">
                    <label><input name="rule" type="radio" value="0" checked="checked" /> 全量下发</label> 
                    </div>
                    <div class="radio radio-inline">
                    <label><input name="rule" type="radio" value="1" /> 条件下发 <a href="/Docs/rule" target="_blank">(?)</a></label> 
                    </div>
                    <div class="radio radio-inline">
                    <label><input name="rule" type="radio" value="2" /> 灰度下发 <a href="/Docs/rule" target="_blank">(?)</a></label> 
                    </div>
                  </div>
        
                  <div class="form-group patch-form-condition" style="display:none">
                    <input type="text" class="form-control" name="condition" id="conditionInput" placeholder="条件"/>
                                  <select id="conditionSelect"> 
                          <option value="0">预设条件</option> 
                          <option value="sdk>=19 ">SDK版本>=19 </option> 
                          <option value="sdk>=20">SDK版本>=20 </option> 
                          <option value="wifi==1">wifi==1</option> 
                      </select>          </div>
                  <div class="form-group patch-form-gray" style="display:none">
                    <select name="grayType" id="grayType">
                        <option value="0">按百分比</option> 
                        <option value="1">按人数</option> 
                    </select>
        
                    <select name="gray" id="grayPercent"> 
                        <option value="0">全量</option> 
                        <option value="1">10%</option> 
                        <option value="2">20%</option> 
                        <option value="3">30%</option> 
                        <option value="4">40%</option> 
                        <option value="5">50%</option> 
                        <option value="6">60%</option> 
                        <option value="7">70%</option> 
                        <option value="8">80%</option> 
                        <option value="9">90%</option> 
                    </select> 
                    <input type="number" id="grayCount" name="grayCount" class="patch-form-gray-count" style="display:none" placeholder="人数" />
                  </div>
        
                  <div class="form-group patch-submit">
                    <input name="appID" type="hidden" value="4490" />
                    <input name="appVersion" type="hidden" value="2.0"/>
                    <input name="patchID" type="hidden" value="7523" />
                    <button type="submit" class="btn btn-large btn-block btn-primary" id="submitBtn"> 提 交 </button>
                  </div>
                </form>
                <div class="patch-actions">
                        <a href="#deleteModal" class="btn btn-large btn-danger btn-block patch-delete-btn-new" data-toggle="modal">删除此版本</a>
                        <div class="clear"></div>
                    </div>    </div>
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
          $('input[id=patchFile]').change(function() {  
            $('#patchFileInput').val($(this).val().replace('C:\\fakepath\\', ''));  
          });  
          $('input[id=rsaKeyFile]').change(function() {  
            $('#rsaKeyFileInput').val($(this).val());  
          });  
        
        
          $('.patch-delete-btn-new').click(function(){
              $('.patch-delete-panel').fadeIn(100);
              fillPadding();
          })
          $('.patch-rule-swich input:radio').change(function() {
            var val = $(this).val();
            if (val == 0 || val == 3) {
              $('.patch-form-condition').hide();
              $('.patch-form-gray').hide();
            } else if (val == 1) {
              $('.patch-form-condition').show();
              $('.patch-form-gray').hide();
            } else if (val == 2) {
              $('.patch-form-condition').hide();
              $('.patch-form-gray').show();
            }
          })
          $('#rsaCb').change(function(){
            $(this).prop("checked") ? $('#rsaFile').show(): $('#rsaFile').hide();
          });
          $('#grayType').change(function(){
            
            if ($(this).val() == 0) {
              $('#grayPercent').show();
              $('#grayCount').hide();
            } else {
              $('#grayPercent').hide();
              $('#grayCount').show();
            }
          });
        
          $('.btn-patch-new').click(function(){
              $('<div class="form-group"> \
                  <input type="file" class="form-control patch-file" name="patch[]" placeholder="js文件"> \
                  <a class="btn btn-large btn-danger btn-patch-del"> - </a> \
                  <div class="clear"></div> \
                </div> \
              ').insertAfter($(this).parent());
          })
          $(document).on('click', '.btn-patch-del', function(){
              $(this).parent().remove()
          })
        
          $('#patchMenuFile').click(function(){
            $('#patchMenuText').removeClass('selected');
            $('#patchMenuFile').addClass('selected');
            $('#patchTextPanel').hide();
            $('#patchFilePanel').show();
            $('.patch-content-menu span .tips').hide();
          })
        
          $('#patchMenuText').click(function(){
            $('#patchMenuText').addClass('selected');
            $('#patchMenuFile').removeClass('selected');
            $('#patchTextPanel').show();
            $('#patchFilePanel').hide();
            $('.patch-content-menu span .tips').show();
          })
        
          $('#submitBtn').click(function(check){
            
            if ($('#patchMenuText').is(":visible")) {
              try {
                var ast = parse($('#patchTextarea').val(), {strict: false});
                ast.figure_out_scope();
              } catch (e) {
                $('#jsSyntaxAlert').remove();
                var lines = $('#patchTextarea').val().split('\n');
        
                var errMsg = '语法错误，' + e.message + ', line: ' + e.line + ' ' + lines[e.line - 1];
                $('#patch-form').prepend($('<div class="alert alert-danger" id="jsSyntaxAlert">' + errMsg + '</div>'));
                check.preventDefault();
              }
            }
          })
        
          $('#conditionSelect').change(function(){
            var text = $('#conditionInput').val();
            if (text == '0') return;
            if (text.length < 2) {
              $('#conditionInput').val(text + $(this).val());
            } else {
              var last2Char = text.substr(text.length - 2);
              if (last2Char == '&&' || last2Char == '||') {
                $('#conditionInput').val(text + $(this).val());
              } else {
                $('#conditionInput').val(text + '&&' + $(this).val());
              }
            }
            $(this).val('0');
          })
        
          function uglify(code) {
              var ast = parse(code, {strict: false});
              ast.figure_out_scope();
              code = ast.print_to_string({beautify: true});
              return code;
          }
        
          var patchVersionNewest = parseInt('0');
          var patchVersionOldest = parseInt('0');
          if (patchVersionNewest > 0 && patchVersionNewest != patchVersionOldest) {
            if (patchVersionOldest <= 0) patchVersionOldest = 1;
            var historySelect = '<select id="historySelect"><option value="0">载入历史版本</option>';
            for (var i = patchVersionNewest; i >= patchVersionOldest; i --) {
              historySelect += '<option value="' + i + '">' + i + '</option>';
            }
            historySelect += '</select>';
        
            var $loadingImage = $('<img src="/Public/img/loading.gif" style="display:none;margin-left:10px;" />');
            $(historySelect).appendTo('#patchTextSelectArea').change(function(){
              if ($(this).val() == 0) return;
              if ($('#patchTextarea').val().length > 0) {
                if (!confirm("编辑框已有内容，是否覆盖？")) {
                  return;
                }
              }
        
              $loadingImage.show();
              $.get("/Apps/patchContent", {appID: "4490",  "v": "2.0_" + $(this).val(), 'file': 'main.js'}, function(data){
                  $loadingImage.hide();
                  if (data && data['files'] && data['files'][0]) {
                    $('#patchTextarea').val(data['files'][0]['content']);
                  }
              });
            });
        
            $loadingImage.appendTo('#patchTextSelectArea');
          }
        
        
        </script>

<#include "layout/footer.ftl"/>