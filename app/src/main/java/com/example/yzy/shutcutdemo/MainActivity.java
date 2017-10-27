package com.example.yzy.shutcutdemo;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void onClick(View pView) {
        addShorttCut();
    }

    public void addShorttCut() {
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
    }
}
