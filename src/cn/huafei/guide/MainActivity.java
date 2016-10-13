package cn.huafei.guide;

import java.util.ArrayList;

import android.app.Activity;
import android.content.res.ColorStateList;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.Toast;
import cn.huafei.widget.GuideView;

public class MainActivity extends Activity {

	@SuppressWarnings("deprecation")
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		GuideView mGuideView = (GuideView) findViewById(R.id.guideView);

		ArrayList<Bitmap> images = new ArrayList<Bitmap>();
		images.add(BitmapFactory.decodeResource(getResources(), R.drawable.guide_1));
		images.add(BitmapFactory.decodeResource(getResources(), R.drawable.guide_2));
		images.add(BitmapFactory.decodeResource(getResources(), R.drawable.guide_3));
		mGuideView.setImages(images);// 设置ViewPager图片列表

		mGuideView.setNormalPointsBGId(R.drawable.shape_point_gray);//设置默认形状
		mGuideView.setCurPointBGId(R.drawable.shape_point_red);//设置滚动圆点背景
		// 获取button
		Button btnStart = mGuideView.getBtnStart();
		btnStart.setText("进入主页");
		btnStart.setBackgroundDrawable(getResources().getDrawable(R.drawable.selector_guide_btn_bg));
		btnStart.setPadding(10, 10, 10, 10);
		btnStart.setTextColor(createColorStateList(Color.WHITE, Color.BLACK, Color.BLUE, Color.GRAY));
		btnStart.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				Toast.makeText(getApplicationContext(), "进入主页", 0).show();
			}
		});		
		mGuideView.bind();
	}

	/**设置不同状态时其文字颜色。 */
	private ColorStateList createColorStateList(int normal, int pressed, int focused, int unable) {
		int[] colors = new int[] { pressed, focused, normal, focused, unable, normal };
		int[][] states = new int[6][];
		states[0] = new int[] { android.R.attr.state_pressed, android.R.attr.state_enabled };
		states[1] = new int[] { android.R.attr.state_enabled, android.R.attr.state_focused };
		states[2] = new int[] { android.R.attr.state_enabled };
		states[3] = new int[] { android.R.attr.state_focused };
		states[4] = new int[] { android.R.attr.state_window_focused };
		states[5] = new int[] {};
		ColorStateList colorList = new ColorStateList(states, colors);
		return colorList;
	}

}
