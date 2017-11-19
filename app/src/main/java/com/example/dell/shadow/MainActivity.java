package com.example.dell.shadow;

import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.LinearLayout;

/**
 * 作者：聂
 * 时间：2017年11月19日14:09:17
 */

public class MainActivity extends AppCompatActivity {
    private LinearLayout line;
    private ObservableScrollView scrollView;
    private int imageHeight=300; //设置渐变高度，一般为导航图片高度，自己控制
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //查找控件
        line= (LinearLayout) findViewById(R.id.line);
        scrollView= (ObservableScrollView) findViewById(R.id.scrollView);
        //搜索框在布局最上面
        line.bringToFront();
        //滑动监听
        scrollView.setScrollViewListener(new ObservableScrollView.ScrollViewListener() {
            @Override
            public void onScrollChanged(ObservableScrollView scrollView, int x, int y, int oldx, int oldy) {
                if (y <= 0) {
                    line.setBackgroundColor(Color.argb((int) 0, 227, 29, 26));//AGB由相关工具获得，或者美工提供
                } else if (y > 0 && y <= imageHeight) {
                    float scale = (float) y / imageHeight;
                    float alpha = (255 * scale);
                    // 只是layout背景透明
                    line.setBackgroundColor(Color.argb((int) alpha, 227, 29, 26));
                } else {
                    line.setBackgroundColor(Color.argb((int) 255, 227, 29, 26));
                }
            }
        });
    }
}
