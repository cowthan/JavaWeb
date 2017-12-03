<#assign title="实时监控 - 账单" />
<#include "layout/header.ftl"/>
            <div class="main   ">
        

        <style>
        .app-stat-menu {
            text-align: center;
            padding:10px;
        }
        .app-stat-menu span {
            padding: 0 5px;
        }
        .patch-select {
            display: none;
        }
        #patchBtn {
            font-size: 14px;
            line-height: 14px;
            padding: 7px 12px;
            margin-left: 10px;
        }
        .app-stat-detail {
            padding: 10px;
            text-align: center;
        }
        .app-stat-detail p {
            padding: 5px;
            margin: 0;
        }
        .tips-empty {
            display: none;
            text-align: center;
            padding:120px;
        }
        .tips-empty span {
            display: block;
            padding:5px;
            font-size: 14px;
            color:#888;
        }
        </style>

            <#include "layout/sidebar.ftl" />


                <div class="app-ctn">
                <h1>实时监控</h1>
                <div class="app-stat-menu">
                    <span>
                        <span class="title">App版本:</span>
                        <select id="appSelect">
                        <option value="5.7.7">5.7.7</option><option value="5.7.4">5.7.4</option><option value="5.3">5.3</option>                </select>
                    </span>
                    <span>
                        <span class="title">补丁版本:</span>
                        <select data-appVersion="5.7.7" class="patch-select">
                                <option value="1">1</option>                    </select><select data-appVersion="5.7.4" class="patch-select">
                                <option value="2">2</option>                    </select><select data-appVersion="5.3" class="patch-select">
                                <option value="9">9</option><option value="8">8</option>                    </select>            </span>
                    <span>
                        <select id="typeSelect">
                            <option value="day">最近一天</option>
                            <option value="week" >最近七天</option>
                        </select>
                    </span>
        
                    <a href="javascript:void(0)" class="btn btn-info" id="patchBtn">查看</a>
        
                </div>        <div id="succStat" style="height: 250px;">
                    <div class="tips-empty">暂无数据
                                    </div>
                </div>
                            <div class="app-stat-detail">
                        <!-- <p id="detailSucc">应用成功数 / 合成成功数 / 下载成功数：<span id="succApplyTotalCount">0</span> / <span id="succPatchTotalCount">0</span> / <span id="succTotalCount">0</span> </p> -->
                        <p id="detailSucc"><span id="succApplyTotalCount">0</span> / <span id="succPatchTotalCount">0</span> / <span id="succTotalCount">0</span> </p>
                        <p id="detailPercent"><span id="succPercent"></span></p>
                        <p id="detailApplyWording"></p>
                        <p id="detailPatchWording"></p>
                        <p id="detailErrorWording"></p>
                        <p id="detailErr">失败数：<span id="errTotalCount">0</span></p>
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
        
        var statJson = eval({"statData":[["2017-11-23 19:00:00","54374"],["2017-11-23 20:00:00","54375"],["2017-11-23 23:00:00","54377"],["2017-11-24 17:00:00","54378"],["2017-11-24 18:00:00","54379"]],"succTotalCount":"54379","errTotalCount":1776,"succApplyTotalCount":53421,"succPatchTotalCount":53730}) || {};
        var patchListJson = eval() || {};
        
        var appVersion = '5.7.7';
        var patchVersion = '1';
        var appId = 1326;
        
        // $('#succTotalCount').text(statJson['succTotalCount'])
        // $('#succApplyTotalCount').text(statJson['succApplyTotalCount'])
        // $('#succPatchTotalCount').text(statJson['succPatchTotalCount'])
        if (statJson['succTotalCount'] != 0) {
            if (statJson['succPatchTotalCount'] > 0) {
                $('#detailSucc').text('应用成功数 / 合成成功数 / 下载成功数： ' + statJson['succApplyTotalCount'] + '/' + statJson['succPatchTotalCount'] + '/' + statJson['succTotalCount'])
                $('#succPercent').text('合成成功率：' + ((statJson['succPatchTotalCount'] / statJson['succTotalCount'])*100).toFixed(2) + '%');
                $('#detailApplyWording').text("应用成功: 用户已经成功启动了应用patch的版本")
                $('#detailPatchWording').text("合成成功: patch文件已被校验、并与基础包成功的进行合成")
                $('#detailErrorWording').text("如果失败数有大量异常，请及时联系我们确认原因和接入是否有误")
            } else {
                $('#detailSucc').text('应用成功数 / 下载成功数： ' + statJson['succApplyTotalCount'] + '/' + statJson['succTotalCount'])
                $('#succPercent').text('应用成功率：' + ((statJson['succApplyTotalCount'] / statJson['succTotalCount'])*100).toFixed(2) + '%');
                $('#detailApplyWording').text("应用成功: 用户已经成功启动了应用patch的版本")
                $('#detailErrorWording').text("如果失败数有大量异常，请及时联系我们确认原因和接入是否有误")
            }
        } else {
            $('#succPercent').text('0%');
        }
        if (statJson['errTotalCount'] > 0) {
            $('#errTotalCount').html('<a href="${base}/patch/data/detail">' + statJson['errTotalCount'] + '（点击查看详情）' + '</a>')
        } else {
            $('#errTotalCount').text(statJson['errTotalCount'])
        }
        
        $('#appSelect option').filter(function() {
            return $(this).text() == appVersion;
        }).prop('selected', true);
        
        $('#appSelect').change(function() {
            appVersion = $('#appSelect option:selected').val();
            var $currPatch = $('.patch-select').hide().filter(function(){
                return $(this).attr('data-appVersion') == appVersion;
            }).show()
            patchVersion = $currPatch.find('option:selected').val()
        })
        
        $('.patch-select').filter(function(){
            return $(this).attr('data-appVersion') == appVersion;
        }).show().change(function(){
            patchVersion = $(this).find('option:selected').val();
        }).find('option').filter(function() {
            return $(this).text() == patchVersion;
        }).prop('selected', true);;
        
        $('#patchBtn').click(function(){
            document.location = '/Apps/stat/appID/' + appId + '/av/' + appVersion + '/pv/' + patchVersion + '/type/' + $('#typeSelect option:selected').val();
        })
        
        </script>

        <script>
        if (statJson['succTotalCount'] > 0) {
            var statData = statJson['statData'];
            var chartData = [];
            var countMin = statData.length > 0 ? statData[0][1] : 0;
            for (var i = 0; i < statData.length; i ++) {
                var currCount = statData[i][1];
                if (currCount < countMin) {
                    countMin = currCount;
                }
                chartData.push({time: statData[i][0], count: currCount});
            }
        
            new Morris.Line({
              element: 'succStat',
              data: chartData,
              xkey: 'time',
              ykeys: ['count'],
              labels: ['成功数'],
              ymin: countMin - 10 > 0 ? countMin - 10: 0
            });
        } else {
            if (statJson['errTotalCount'] <= 0) {
                $('#succStat .tips-empty').show();
                $('#detailErr').hide();
                $('#detailSucc').hide();
                $('#detailPercent').hide();
            } else {
                $('#succStat').hide();
            }
        }
        
        </script>

<#include "layout/footer.ftl"/>
        
        