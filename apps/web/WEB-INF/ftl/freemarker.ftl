-----------------freemarker模板测试---------------------

----list标签：对数组，List，Set进行循环
<#list names as name>
${name_index+1}--${name}
</#list>

<#list ["星期一", "星期二", "星期三", "星期四", "星期五", "星期六", "星期天"] as x>
${x}
</#list>

----获取集合大小
names数组元素个数：${names?size}

----迭代Map
<#list namesMap?keys as key>
    ${key}--->${namesMap[key]!("null")}
</#list>

<#assign scores = {"语文":86,"数学":78} + {"数学":87,"Java":93}>
<#list {"语文":78, "数学":80}?keys as key>
${key}
</#list>


----if标签：判断
<#if (x > 3)>
    x大于3，值是${x}
<#else>
    x小于3，值是${x}
</#if>

<#if (intro == "FreeMarker Test")>
    intro的值是：FreeMarker Test
<#else >
    else了，intro的值是：${intro}
</#if>

<#assign age=23>
<#if (age>60)>老年人
<#elseif (age>40)>中年人
<#elseif (age>20)>青年人
<#else> 少年人
</#if>

判空
<#if mayBeNull??>
    mayBeNull的值不是null
<#else>
    mayByNull的值是null
</#if>

----include标签：包含文件
<#include "header.ftl"/>

----定义变量
这里定义的相当于从外部data传进来的data.put("answer", 42)
<#assign answer=42/>
${answer}
string = ${answer?string} <#-- the same as ${answer} -->
string.number = ${answer?string.number}
string.currency = ${answer?string.currency}
string.percent = ${answer?string.percent}
${answer}

----取值
常规取值：${x}
列表长度：${names?size}
null替换：${mayBeNul!("值为null时显示这个")}
默认值：${mayBeNul?default("值为null时以此为默认值")}

----数字格式化
mX:小数部分最小X位
MX:小数部分最大X位
<#assign x=2.582/>
<#assign y=4/>
#{x; M2} <#-- 输出2.58 -->
#{y; M2} <#-- 输出4 -->
#{x; m2} <#-- 输出2.58 -->
#{y; m2} <#-- 输出4.00 -->
#{x; m1M2} <#-- 输出2.58 -->
#{y; m1M2} <#-- 输出4.0 -->

----取整
<#assign x=5>
${ (x/2)?int }
${ 1.1?int }
${ 1.999?int }
${ -1.1?int }
${ -1.999?int }
结果是:2 1 1 -1 -1

----字符串处理
html:对字符串进行HTML编码
cap_first:使字符串第一个字母大写
lower_case:将字符串转换成小写
upper_case:将字符串转换成大写
trim:去掉字符串前后的空白字符

<#assign test="Tom & Jerry">
${test?html}
${test?upper_case?html}


-----------------freemarker模板测试完毕---------------------