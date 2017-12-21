# ShortCutDemo
Android创建桌面快捷图标  
完美实现360手机助手桌面意见加速图标旋转动画  
![](https://github.com/yzytmac/ShortCutDemo/blob/master/device-2017-12-20-212637.gif "我的图片")

```

//点击快捷方式的意图
        Intent clickIntent = new Intent();
        clickIntent.setClass(getApplicationContext(), MainActivity.class);
        clickIntent.setAction("android.intent.action.MAIN");
        /* 网上很多demo里面都会有这行代码，在国产安卓系统中不会有任何影响，也会在桌面创建快捷图标，
        但是在原生Android中就无法创建，这是一个很大的坑。所以千万不要加这行代码
        clickIntent.addCategory("android.intent.category.LAUNCHER");
        */


        //创建一个快捷方式意图
        Intent shortCutIntent = new Intent();
        //意图的action动作
        shortCutIntent.setAction("com.android.launcher.action.INSTALL_SHORTCUT");
        //点击图标后要做的操作意图
        shortCutIntent.putExtra(Intent.EXTRA_SHORTCUT_INTENT, clickIntent);
        //快捷方式的名称
        shortCutIntent.putExtra(Intent.EXTRA_SHORTCUT_NAME, "快捷方式");
        //快捷图标
        shortCutIntent.putExtra(Intent.EXTRA_SHORTCUT_ICON_RESOURCE, Intent.ShortcutIconResource.fromContext(getApplicationContext(), R.mipmap.ic_launcher));
        // 是否允许重建，这个true和false好像没什么区别
        shortCutIntent.putExtra("duplicate", false);
        //发送广播进行创建
        sendBroadcast(shortCutIntent);


```  
需要在清单文件中添加权限  
```
<uses-permission android:name="com.android.launcher.permission.INSTALL_SHORTCUT"/>
```
