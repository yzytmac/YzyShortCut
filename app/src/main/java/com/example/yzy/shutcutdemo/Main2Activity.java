package com.example.yzy.shutcutdemo;

import android.graphics.Rect;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.RotateAnimation;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import static android.view.animation.Animation.ABSOLUTE;
import static android.view.animation.Animation.RELATIVE_TO_PARENT;
import static android.view.animation.Animation.RELATIVE_TO_SELF;

/**
 * @author YangZhenYu
 *         created at 17-12-20 下午5:52
 *         功能：完全透明的activity ，在上面产生动画
 */
public class Main2Activity extends AppCompatActivity implements Animation.AnimationListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Rect vBounds = getIntent().getSourceBounds();
        int d = vBounds.width()*9/10;
        int x = vBounds.centerX();
        int y = vBounds.centerY();
        Log.e("yzy", "x: " + x + ",y:" + y);


        ImageView iv = new ImageView(this);
        iv.setImageDrawable(getResources().getDrawable(R.mipmap.ic_launcher_round));
        LinearLayout.LayoutParams vParams1 = new LinearLayout.LayoutParams(d, d);
        vParams1.setMargins(x-d/2,y-(d),0,0);
        setContentView(iv,vParams1);
        RotateAnimation vAnimation = new RotateAnimation(0,360,RELATIVE_TO_SELF,0.5f,RELATIVE_TO_SELF,0.5f);
        vAnimation.setRepeatCount(50);
        vAnimation.setDuration(100);
        vAnimation.setFillAfter(true);
        vAnimation.setAnimationListener(this);
        iv.startAnimation(vAnimation);

    }


    @Override
    public void onAnimationStart(Animation pAnimation) {

    }

    @Override
    public void onAnimationEnd(Animation pAnimation) {
        Toast.makeText(Main2Activity.this, "垃圾清理完毕，很干净哦！", Toast.LENGTH_SHORT).show();
        finish();
    }

    @Override
    public void onAnimationRepeat(Animation pAnimation) {

    }
}
