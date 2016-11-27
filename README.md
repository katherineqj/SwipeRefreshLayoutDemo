# SwipeRefreshLayoutDemo
下拉刷新
SwipeRefreashLayout就是用来实现下拉刷新效果的 
我也没有用过别的下拉刷新组件，简单的介绍一下这个：

包含在SwipeRefreashLayout中的只能有一个控件 ，如果放置了多于一个的话并不会报错但是在显示的时候他只会显示SwipeRefreashLayout里面的第一个组件，这个组件可以是可滚动的组件比如RecycleView，ListView等，也可以是简单的TextView或者Button，我看有的博客说里面的child组件只能是可滚动的View 我试着用TextView也可以 
所以我也不确定~~~~



先看一下有四个常用的方法:

 -  **setOnRefreshListener(OnRefreshListener): 为布局添加一个Listener**
为布局添加listener的方式有两种
一种是实现SwipeRefreshLayout.OnRefreshListener()接口，然后重写onRefresh()方法
还有一种是创建一SwipeRefreshLayout.OnRefreshListener()
的匿名内部类 然后重写onRefresh()方法 和我们普通写监听事件一样 所以我们是将需要更新的操作放在onRefresh()
中的

 - **setRefreshing(boolean): 显示或隐藏刷新进度条**
这个是我们刻意控制刷新进度条是否显示的一个方法，我们在一开始进入界面或者初始化的时候可以发现是没有刷新这个进度条的，当我们下拉后会出现当我们完成数据请求或者显示后会 setRefreshing(false)让进度条消失
我大概看了一点点源码，大概是说有一个全局变量
叫mRefreshing 
![这里写图片描述](http://img.blog.csdn.net/20161127172422134)
我们可以看到给他的初始值是false，是不显示的，
在源码中还有这样一段：
![这里写图片描述](http://img.blog.csdn.net/20161127172513947)
可以理解为当你进行操作的时候会调用这个finishSpinner方法，显示进度条然后当我们完成数据请求后手动调用setRefreshing(flase)让进度条消失。
 - **isRefreshing(): 检查是否处于刷新状态**
这个方法就是简单的判断你当前是否在刷新，返回一个布尔类型的值 
源码里面也很简单 
我们可以看到他返回的就是我们上面提到的mRefreshing 这个全部变量，所以说mRefreshing 
是这个标记这个控件刷新状态的一个变量
![这里写图片描述](http://img.blog.csdn.net/20161127173737362)

 - **setColorScheme(): 设置进度条的颜色主题，最多能设置四种**
  简单的就是设置你进度条的颜色这样一个方法，我试验出的结论是 ：
一圈转一个颜色，旋转的圈数和你刷新所需要的时间有关系，就比如说我设置了2种颜色在里面，分别是a,b。然后我刷新需要一秒 就转一圈颜色是a。需要两秒，就转两圈 颜色是a,b。需要三秒转三圈，颜色是a,b,a.但是最多只可以设置四种颜色


 




