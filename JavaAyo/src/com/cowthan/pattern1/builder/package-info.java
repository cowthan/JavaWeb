/**
 * 建造者模式：生成器模式
 * 
 * 将一个复杂对象的构建与他的表示分离，使得同样的构建过程可以创建不同的表示
 * 
 * 在建造者模式中，有4种角色：
 * 1、Product：产品类
 * 通常实现了模板方法模式，因为builder模式讲究的是组装，组装方式
 * 不一样，对象的效能也不一样，所以Product中一般有个方法处理各种
 * 组装方式，这就是模板
 * 
 * 2、Builder :抽象建造者
 * 3、ConcreteBuilder:具体的建造者
 * 
 * 4、Director：导演类
 * 这个类封装了对象的创建，负责安排已有模块顺序（不同模块顺序导致对象行为不同），
 * 这里的模块顺序是需要在创建Product时初始化的东西
 * ——所以导演类最重要，它封装了用户对产品种类的需求
 * 
 * 实例需求：
 * 现在就是需要很多种汽车模型，如奔驰，宝马，而对于每辆汽车来说，有几个动作：
 * start, stop, alarm, engineBoom
 * ——如果这几个动作的顺序始终是一样的，那就模板方法模式就能搞定
 * ——但是客户要求每个模型的执行顺序由客户自己定
 * ——这时就用到了建造者模式
 * 
 * 现在的问题是：
 * 用户要模型，但是对于奔驰模型，有很多种，每一种都有不同的动作顺序，
 * 所以在创建模型时，就需要把执行顺序设置进去
 * 
 * 注意：
 * 建造者模式强调对零件的装配，不同的零件装配顺序产生不同的效能，
 * 而模板方法模式强调各个零件的实现在子类中（零件就是动作的实现）
 * 工厂方法强调的是零件创建，而不是组装
 */
package com.cowthan.pattern1.builder;