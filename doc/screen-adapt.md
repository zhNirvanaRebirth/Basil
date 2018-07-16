## devices  
###  phone  

###  table-portrait  

###  table-landscape  

###  desktop  

## layout  
* navigation  


## Product architecture  
### top-level sections  
* appetizers  
* entrees  
* desserts  
* cocktails  
### recipe page  
* ingredients  
* directions  


## method  
### screen dpi(屏幕密度)  
#### 资源外部化  
> 提供默认资源和多个备用资源  
  
* UI布局：layout(默认);layout-land(横屏)

### screen size(屏幕尺寸)  
### 提供资源  
> 可以在应用中提供何种资源，可将这些资源保存在何处以及如何为特定设备创建备用资源  
  
* 分组资源类型(提供默认资源)  
* 提供备用资源：通过使用限定符，在运行时，Android会检测当前设备配置并为应用加载合适的资源  
* 创建资源别名  
  
### 访问资源  
> 通过引用资源ID来应用该资源  
  
* aapt(Android asset package tool)：该工具会生成R类，使资源和R类中的资源ID生成对应的关系  
* assets资源：通过AssetManager访问  
* res/raw资源：通过openRawResource()读取字节流  
  
### 处理运行时变更  
* 屏幕方向发生改变时，系统会重启正在运行的Activity（onDestory()->onCreate()）,目的在于使用与设备新的配置匹配的备用资源  
* onSaveInstanceState(), onCreate(), onRestoreInstanceState()用于处理Activity重启是对象的保存（不适用与大对象， 因为数据都需要序列化和反序列化）  
* 可以使用Fragment来保留变更期间的对象（Fragment需要设置setRetainInstance(true)）  
* android:configChanges, onConfigurationChanged()用于设置Activity自处理配置变更，而不重启Activity  
  
### 本地化  
#### 支持不同的语言  
> 需要创建语言区域目录和字符串文件(values-en/)  
  

#### 常用限定符  
1. 语言（本地化）  
2. 布局方向（layout-ldrtl; layout-ldltr）  
1. 屏幕最小尺寸(sw<N>dp):最小屏幕可用的高度和宽度，就是不论屏幕的方向，只和屏幕的最小边比较  
1. 可用宽度(w<N>dp):最小可用屏幕宽度，随着屏幕方向的改变，最小可用屏幕宽度的大小会发生变化  
1. 可用高度(h<N>dp)  
1. 屏幕尺寸(small, normal, large, xlarge)  
1. 屏幕纵横比(long; notlong):屏幕的宽度较宽，和屏幕的方向无关  
1. 屏幕方向(port; land)  
1. 夜间模式(night; notnight)  
1. 屏幕像素密度(ldpi; mdpi; hdpi; xhdpi; xxhdpi; xxxhdpi; nodpi; tvdpi; anydpi)  


#### 动画  
> 包括：属性动画(property animation); 视图/渐变动画(view animation); 补间动画(tween animation); 帧动画(frame animation)  
  
* property animation: xml文件放在res/animator文件夹下；（位置，大小等属性）  
* view animation/tween animation: xml文件放在res/anim文件夹下  
* frame animation: xml文件放在res/drawable文件夹下  

##### Property Animation  
* duration  
* time interpolation  
* repeat count and behavior  
* animator sets  
* frame refresh delay  
* ValueAnimator, TypeEvalutor, TimeInterpolator, duration, startPropertyValue, endPropertyValue, ValueAnimator.AnimatorUpdateListener, AnimatorListenerAdapter  
* subclass of Animator: ValueAnimator, ObjectAnimator, AnimatorSet  
* animate layout changes to ViewGroup: LayoutTransition, LayoutAnimations, LayoutAnimationsByDefault
##### View Animation  
> 视图/渐变动画：平移，旋转，缩放，渐变，只能对View的子类起作用，只对View的绘制起作用，对View本身没有改变（如对button做平移动画，其绘制的位置会发生改变，但其响应点击的位置一直保持不变）  
  
##### 绘制(Rendering)  
*待看，地址[https://developer.android.com/topic/performance/rendering/]*  

##### 图标设计(Icon Design)  
*待看， 地址[https://developer.android.com/guide/practices/ui_guidelines/icon_design]*  


##### Camera  

##### 手势  
 