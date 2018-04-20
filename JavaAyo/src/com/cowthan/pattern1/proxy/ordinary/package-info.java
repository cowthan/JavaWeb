/**
 * 代理模式：又叫委托模式
 * 
 * 为其他对象提供一种代理以控制对对象的访问
 * 
 * 主要有三种角色：
 * 1、被代理接口
 * 2、被代理对象
 * 3、代理对象：实现了被代理接口，并以一个被代理对象为成员，其对接口的实现就是调用
 * 被代理对象的方法，这是基本套路
 * 
 * 实例：
 * ——以玩家玩游戏太累为例，使用游戏代练来升级，这个代练就是代理
 */
package com.cowthan.pattern1.proxy.ordinary;