package com.example.yzy.shutcutdemo;

import android.graphics.Rect;
import android.os.SystemClock;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.RotateAnimation;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
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

    private ImageView mIv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        RelativeLayout layout = (RelativeLayout) findViewById(R.id.layout);
        Rect vBounds = getIntent().getSourceBounds();
        int w = vBounds.width()*75/100;
        int x = vBounds.centerX();
        int y = vBounds.centerY();
        Log.e("yzy", "x: " + x + ",y:" + y);


        mIv = new ImageView(this);
        mIv.setVisibility(View.INVISIBLE);
        mIv.setImageDrawable(getResources().getDrawable(R.mipmap.clean_icon));
        RelativeLayout.LayoutParams vParams = new RelativeLayout.LayoutParams(w,w);
        vParams.setMargins(x-(w/2),y-w+8,0,0);
        layout.addView(mIv,vParams);
        RotateAnimation vAnimation = new RotateAnimation(0,360,RELATIVE_TO_SELF,0.5f,RELATIVE_TO_SELF,0.5f);
        vAnimation.setRepeatCount(50);
        vAnimation.setDuration(100);
        vAnimation.setFillAfter(true);
        vAnimation.setAnimationListener(this);
        SystemClock.sleep(500);
        mIv.startAnimation(vAnimation);

    }


    @Override
    public void onAnimationStart(Animation pAnimation) {
        mIv.setVisibility(View.VISIBLE);
    }

    @Override
    public void onAnimationEnd(Animation pAnimation) {
        mIv.setVisibility(View.INVISIBLE);
        Toast.makeText(Main2Activity.this, "垃圾清理完毕，很干净哦！", Toast.LENGTH_SHORT).show();
        SystemClock.sleep(500);
        finish();
    }

    @Override
    public void onAnimationRepeat(Animation pAnimation) {

    }
}
