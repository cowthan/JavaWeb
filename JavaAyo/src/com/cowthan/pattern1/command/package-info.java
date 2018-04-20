/**
 *   命令模式
 *   
 *   将一个请求封装成对象，从而让你使用不同的请求将客户端参数化，
 *   对请求排队或者记录请求日志，可以提供命令的撤销和恢复
 *   
 *   实例：
 *   一个项目三个组，需求组（Requirement Group）， 美工组（Page Group），代码组（Code Group）
 *   客户有什么问题，就找这三个组讨论，有时一个改动需要分别找三个组分别讨论，不合理
 *   所以就找一个中间人，客户只跟中间人讨论
 *   
 *   对于中间人Invoker：
 *   ——最先想到是用String来传递不同的命令，让不同的组去实现相关的改动
 *   ——但是字符串没有什么约束力，根据字符串判断业务逻辑也不是个优秀的设计
 *   ——所以最后就找到命令模式：把命令封装成对象
 *   
 *   三大角色：
 *   1、CMD：对命令的封装，我们将这些命令提供给客户
 *   2、Invoker：对外接头人，唯一与客户交流的人
 *   3、Receiver：干活的角色，命令的最终接受者，就是各个Group
 *   
 *   结合其他模式：
 *   1、命令模式 + 责任链模式： 实现命令族解析任务
 *   2、命令模式 + 模板方法模式： 解决CMD子类膨胀问题
 *   
 *   撤销和恢复：
 *   1、可以结合备忘录模式，还原最后状态，适用于接受者执行命令导致状态的变更
 *   不适合事件处理
 *   2、给每一个命令定义一个反命令，实现回滚，但要记录日志，而日志是一个
 *   复杂的东西，比如说数据库的日志处理
 *   总之实现这个功能就是复杂，应该有现成的库可以调用吧，没研究过
 */


package com.cowthan.pattern1.command;