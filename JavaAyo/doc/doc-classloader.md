

1 ClassLoader

JVM第6章：Class文件结构，Class动态生成技术
JVM第7章：类加载
JVM第8章：字节码执行引擎
JVM第9章：类加载案例

2 CGLib：操作字节码

Spring用了

用于测试方法区溢出时，需要运行时产生大量的类，也可以用这个


3 OSGi

不受双亲委派模型的限制，类加载器成了一个网状的体系，这是为了实现热部署而做出的创新，虽然带来了额外的高复杂性，
但有一个共识：OSGi对类加载器的使用时很值得学习的，弄懂了OSGi的实现，也就明白了类加载器的精髓