<#assign title="补丁详情 - 账单" />
<#include "layout/header.ftl"/>
        <div class="main   ">
    
    <style>
    #graySelect {
        width:80px;
    }
    
    #conditionInput {
        width:200px;
        display: inline-block;
        height:37px;
    }
    #conditionRollText {
        padding-left:75px;
        font-size: 14px;
    }
    .patch-ctn {
        padding:20px 10px 0 50px;
        float: left;
        width:550px;
    }
    .patch-ctn h4{
        text-align: center;
        padding: 20px 0 30px 0;
        font-size: 35px;
    }
    .patch-form-gray-count {
        width:100px;
        height:30px!important;
    }
    #patchContent img {
        margin-left:10px;
        display: none;
    }
    #patchCode {
        display: none;
        margin-top:10px;
    }
    #patchCode h4{
        padding:0;
        text-align: left;
        font-size: 14px;
        margin: 10px 0 8px 0;
        display: inline;
    }
    #patchCode pre{
        clear:both;
        overflow-x: scroll;
        margin-top:10px;
    }
    #contentHideBtn {
        display: none;
    }
    .download-code {
        font-size:14px;
        float: right;
        margin-right: 10px;
    }
    
    #conditionSelect {
        width: 95px;
        height: 38px;
    }
    
    </style>
    <div id="pauseModal" class="modal hide fade" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
      <div class="modal-header">
        <button type="button" class="close" data-dismiss="modal" aria-hidden="true">×</button>
        <div class="modal-title">确定暂停补丁下发？</div>
      </div>
      <div class="modal-body">
        <p>暂停后，补丁不再下发，未拉取过补丁的设备不会再拉取到补丁，已拉取过的设备仍继续执行补丁。</p>
      </div>
      <div class="modal-footer">
        <button class="btn btn-default" data-dismiss="modal" aria-hidden="true">取消</button>
        <button class="btn btn-primary" id="pauseBtn">暂停下发</button>
      </div>
    </div>
    
    
    <div id="resumeModal" class="modal hide fade" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
      <div class="modal-header">
        <button type="button" class="close" data-dismiss="modal" aria-hidden="true">×</button>
        <div class="modal-title">确定恢复补丁下发？</div>
      </div>
      <div class="modal-body">
        <p>恢复下发后，下发规则仍与暂停前一样。</p>
      </div>
      <div class="modal-footer">
        <button class="btn btn-default" data-dismiss="modal" aria-hidden="true">取消</button>
        <button class="btn btn-primary" id="resumeBtn">恢复下发</button>
      </div>
    </div>
    
    
    <div id="deleteModal" class="modal hide fade" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
      <div class="modal-header">
        <button type="button" class="close" data-dismiss="modal" aria-hidden="true">×</button>
        <div class="modal-title">确定删除此版本？</div>
      </div>
      <div class="modal-body">
            <p>删除后，对应版本的客户端会清除补丁。</p>  </div>
      <div class="modal-footer">
        <form method="POST" action="/Apps/patch/id/8079" style="margin:0">
            <input name="appVersion" type="hidden" value="2.0"/>
            <input name="patchID" type="hidden" value="8079" />
            <input name="appID" type="hidden" value="4797" />
            <input name="isDel" type="hidden" value="1" />
    
            <button class="btn btn-default" data-dismiss="modal" aria-hidden="true">取消</button>
            <button class="btn btn-danger" type="submit">确定删除</button>
        </form>
      </div>
    </div>



        <#include "layout/sidebar.ftl" />


            <div class="patch-ctn">
            <h4>补丁详情</h4>
              <div class="alert alert-danger" id="errMsg" style="display:none"></div>
              <div class="alert alert-success" id="succMsg" style="">补丁发布成功</div>
                <div class="patch-info">
                    <div><span class="title">App版本号：</span><span>2.0</span></div>
                    <div><span class="title">当前补丁版本号：</span><span>1</span></div>
                    <div><span class="title">当前补丁大小：</span><span>85.67KB</span></div>
                    <div><span class="title">更新时间：</span><span>2017-11-24 18:24:20</span></div>
                    <div><span class="title">补丁描述：</span><span>11111</span></div>
                                        <div id="patchCount"><span class="title">已下发：</span><span id="patchCountNumT"></span></div>
                                    <div>
                        <span class="title">下发状态：</span>
                        <span>
                        
                        已全量下发 <a href="#pauseModal" role="button" class="btn btn-primary btn-pause" data-toggle="modal">暂停下发</a>                    
                        
                                        </span>
                    </div>
                </div>
    
                <div class="patch-actions">
                    <a href="${base}/patch/add" class="btn btn-large btn-primary btn-block patch-new-btn">发布新补丁</a>
    
                    <a href="#deleteModal" class="btn btn-large btn-danger btn-block patch-delete-btn" data-toggle="modal">删除此版本</a>
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
    $(function(){
        $(document).on('click', '.btn-patch-del', function(){
            $(this).parent().remove()
        })
    
        $('.patch-delete-btn').click(function(){
            $('.patch-delete-panel').fadeIn(100);
            fillPadding();
        })
        $('.patch-delete-cancel').click(function() {
            $('.patch-delete-panel').hide();
            fillPadding();
        })
    
    
        $('#grayBtn').click(function(){
            if ($('#grayCount').length) {
                $('#grayText').hide();
                $('#grayDoneBtn').show();
                $('#grayBtn').hide();
                $('#grayCount').show();
                $('#grayAllBtn').show();
            } else {
                $('#graySelect').show();
                $('#grayText').hide();
                $('#grayDoneBtn').show();
                $('#grayBtn').hide();
            }
        })
    
        $('#grayDoneBtn').click(function(){
            if ($('#grayCount').val() && $('#grayCount').val().length) {
                updatePatch(null, null, $('#grayCount').val())
            } else {
                updatePatch(null, $('#graySelect').val(), null)
            }
        })
        $('#grayAllBtn').click(function(){
            updatePatchAll()
        })
    
        $('#conditionBtn').click(function(){
            $('#conditionInput').show();
            $('#conditionText').hide();
            $('#conditionDoneBtn').show();
            $('#conditionBtnPanel').show();
            $('#conditionBtn').hide();
        })
        $('#conditionAllBtn').click(function(){
            updatePatchAll()
        })
    
    
        $('#conditionDoneBtn').click(function(){
            if (!$('#conditionInput').val().length) {
                alert('请输入条件规则');
                return;
            }
            updatePatch($('#conditionInput').val(), null, null)
        })
    
    
    
    
        $('#devBtnCondition').click(function(){
            $('#dev').hide();
            $('#devCondition').show();
            $('#conditionInput').show();
        })
    
        $('#devBtnGray').click(function(){
            $('#dev').hide();
            $('#devGray').show();
            $('#graySelect').show();
        })
    
        $('#devBtnAll').click(function(){
            var ret = confirm("确定全量下发？");
            if (ret) {
                updatePatchAll();
            }
        })
    
        $('.dev-cancel').click(function(){
            $('#devCondition').hide();
            $('#devGray').hide();
            $('#dev').show();
        })
    
        $('#devGrayDoneBtn').click(function(){
            if ($('#grayType').val() == 1) {
                updatePatch(null, null, $('#grayCount').val())
            } else {
                updatePatch(null, $('#graySelect').val(), null)
            }
        })
    
        $('#devConditionDoneBtn').click(function(){
            updatePatch($('#conditionInput').val(), null, null)
        })
    
    
        $('#grayType').change(function(){
            if ($(this).val() == 0) {
              $('#graySelect').show();
              $('#grayCount').hide();
            } else {
              $('#graySelect').hide();
              $('#grayCount').show();
            }
        });
    
        function updatePatch(condition, gray, grayCount) {
            var params = { patchID: "8079" }
            if (condition !== null) params['condition'] = condition;
            if (gray !== null) params['gray'] = gray;
            if (grayCount !== null) params['grayCount'] = grayCount;
            if (condition === null && gray === null && grayCount === null) {
                params['all'] = 1;
            }
    
            $.post("/Apps/editPatch", params, function(data){
                $('#errMsg').hide();
                $('#succMsg').hide();
                if (data['err']) {
                    $('#errMsg').text(data['err']).show();
                } else {
                    window.location.href = location.href;
                }
            });
        }
    
        $('#pauseBtn').click(function(){
            $.post("/Apps/editPatch", {patchID: "8079", pause: 1}, function(data){
                window.location.href = location.href;
            });
        })
    
        $('#resumeBtn').click(function(){
            $.post("/Apps/editPatch", {patchID: "8079", resume: 1}, function(data){
                window.location.href = location.href;
            });
        })
    
        function updatePatchAll() {
            updatePatch(null, null, null);
        }
    
        $.post("/Apps/statcount", {appID: "4797", pv: "1", av: "2.0"}, function(data) {
            var succCount = data['succCount'] ? data['succCount'] : 0,
                errCount = data['errCount'] ? data['errCount'] : 0,
                succApplyCount = data['succApplyCount'] ? data['succApplyCount'] : 0;
                succPatchCount = data['succPatchCount'] ? data['succPatchCount'] : 0;
            if ($('#patchCountNumT').length) {
                if (succPatchCount > 0) {
                    $('#patchCountNumT').html('<a href="/Apps/stat/appID/4797/av/2.0/pv/1">' + '[应用/合成/下载]数： ' + succApplyCount + '/' + succPatchCount + '/' + succCount + '（查看详情）' +'</a>')
                } else {
                    $('#patchCountNumT').html('<a href="/Apps/stat/appID/4797/av/2.0/pv/1">' + '[应用/下载]数： ' + succApplyCount + '/' + succCount + '（查看详情）' +'</a>')
                }
            } else {
                $('#patchCountNum').html('<a href="/Apps/stat/appID/4797/av/2.0/pv/1">' + succCount + '/' + (errCount + succCount) + '</a>')
            }
        })
    
        $('#contentShowBtn').click(function(){
            $('#patchContent img').show();
            $.get("/Apps/patchContent", {appID: "4797",  "v": "2.0_1"}, function(data){
                if (data && data['files']) {
                    for (var i = 0; i < data['files'].length; i ++) {
                        $('#patchCode').append('<h4>' + data['files'][i]['fileName'] + '</h4><span class="download-code"><a href="' + data['files'][i]['downloadUrl'] + '">下载</a></span><pre>' + data['files'][i]['content'] + '</pre>')
                    }
                    $('#patchCode').show();
                }
                $('#contentShowBtn').hide();
                $('#contentHideBtn').show();
                $('#patchContent img').hide();
            });
    
        })
    
        $('#contentHideBtn').click(function(){
            $('#patchCode').html('').hide();
            $('#contentHideBtn').hide();
            $('#contentShowBtn').show();
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
    })
    </script>

<#include "layout/footer.ftl"/>