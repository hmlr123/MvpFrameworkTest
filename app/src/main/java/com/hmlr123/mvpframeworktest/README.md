# MVP 架构
##  目的
实现Model、View、Presenter 三层架构的双向传递
##  图示
![](http://www.imgeek.org/uploads/article/20190322/840ecbc6eab31688fb700ed9a7f6ceb3.jpeg)
##  三层内容
1. M层:模型层(Model),此层和MVC中的M层作用类似.
2. V层:视图层(View),在MVC中V层只包含XML文件,而MVP中V层包含XML,Activity和Fragment三者.理论上V层不涉及任何逻辑,只负责界面的改变,尽量把逻辑处理放到M层.
3. P层:通知层(Presenter),P层的主要作用就是连接V层和M层,起到一个通知传递数据的作用.
## MVP结构和MVC架构的区别
参照 <a href="http://www.imgeek.org/article/825309701">传送阵</a>
## MVP需要解决的问题
实现三层之间的数据传递。根据图示框架：
1. View层调用Presenter层，Presenter层调用Model层。使用持有接口对象的方式。
2. 那么反过来的持有怎么处理？两种方式：  
第一种方式：使用接口对象回调相应的方法实现反向的处理。Model回调Presenter实现数据的处理，回调方法由Presenter实现  
第二种方式：使用通用泛型接口实现，抽离基本的接口，实现基本接口的通用的基础方法，里面绑定泛型View 从而实现对View的操控，View的传入使用createPresenter创建Presenter的同时调用基础方法绑定生命周期 将View传入
3. 单页面 多请求如何处理？使用中间层次，存储多请求数据，每个请求分别处理绑定View,解绑View
4. 代码中为什么有通用的无方法接口？用于适配不同的情况，在这里我们只适配的单请求、多请求，还有其他情况扩展可以集成通用接口
5. 为什么需要Presenter 绑定View 的生命周期？ 避免在View被销毁的时候还有Presenter存在，造成资源浪费，这里同样也可以扩展Model层生命周期
## 尾巴
1. 详细内容可以看代码 或者 参照该 <a href="http://www.imgeek.org/article/825309701">文章</a>
2. 该文章github地址 https://github.com/serge66/MVPDemo
