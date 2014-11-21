package com.example.welcome;


import com.example.filpview.R;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.GestureDetector;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup.LayoutParams;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ViewFlipper;

public class welcome extends Activity implements
		android.view.GestureDetector.OnGestureListener {

	private int[] imgs = { R.drawable.image1, R.drawable.image2,
			R.drawable.image3, R.drawable.image4, R.drawable.image5,
			R.drawable.image6, R.drawable.image7, R.drawable.image8,
			R.drawable.image9 , R.drawable.image10};
	private GestureDetector gestureDetector;
	private ViewFlipper viewFlipper;
	private Activity mActivity;

	@SuppressWarnings("deprecation")
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.welcome);
		mActivity = this;
		viewFlipper = (ViewFlipper) findViewById(R.id.viewflipper);

		gestureDetector = new GestureDetector(this);		
		ImageView iv = new ImageView(this);
		iv.setImageResource(imgs[0]);
		iv.setScaleType(ImageView.ScaleType.FIT_XY);
		viewFlipper.addView(iv, new LayoutParams(LayoutParams.MATCH_PARENT,
				LayoutParams.WRAP_CONTENT));
		
		ImageView iv1 = new ImageView(this);
		iv1.setImageResource(imgs[1]);
		iv1.setScaleType(ImageView.ScaleType.FIT_XY);
		viewFlipper.addView(iv1, new LayoutParams(LayoutParams.MATCH_PARENT,
				LayoutParams.WRAP_CONTENT));
		
		ImageView iv2 = new ImageView(this);
		iv2.setImageResource(imgs[2]);
		iv2.setScaleType(ImageView.ScaleType.FIT_XY);
		viewFlipper.addView(iv2, new LayoutParams(LayoutParams.MATCH_PARENT,
				LayoutParams.WRAP_CONTENT));
		
		ImageView iv3 = new ImageView(this);
		iv3.setImageResource(imgs[3]);
		iv3.setScaleType(ImageView.ScaleType.FIT_XY);
		viewFlipper.addView(iv3, new LayoutParams(LayoutParams.MATCH_PARENT,
				LayoutParams.MATCH_PARENT));
		
		ImageView iv4 = new ImageView(this);
		iv4.setImageResource(imgs[4]);
		iv4.setScaleType(ImageView.ScaleType.FIT_XY);
		viewFlipper.addView(iv4, new LayoutParams(LayoutParams.MATCH_PARENT,
				LayoutParams.WRAP_CONTENT));
		
		ImageView iv5 = new ImageView(this);
		iv5.setImageResource(imgs[5]);
		iv5.setScaleType(ImageView.ScaleType.FIT_XY);
		viewFlipper.addView(iv5, new LayoutParams(LayoutParams.MATCH_PARENT,
				LayoutParams.WRAP_CONTENT));
		
		ImageView iv6 = new ImageView(this);
		iv6.setImageResource(imgs[6]);
		iv6.setScaleType(ImageView.ScaleType.FIT_XY);
		viewFlipper.addView(iv6, new LayoutParams(LayoutParams.MATCH_PARENT,
				LayoutParams.WRAP_CONTENT));
		
		ImageView iv7 = new ImageView(this);
		iv7.setImageResource(imgs[7]);
		iv7.setScaleType(ImageView.ScaleType.FIT_XY);
		viewFlipper.addView(iv7, new LayoutParams(LayoutParams.MATCH_PARENT,
				LayoutParams.WRAP_CONTENT));

		ImageView iv8 = new ImageView(this);
		iv8.setImageResource(imgs[8]);
		iv8.setScaleType(ImageView.ScaleType.FIT_XY);
		viewFlipper.addView(iv8, new LayoutParams(LayoutParams.MATCH_PARENT,
				LayoutParams.MATCH_PARENT));
		
		ImageView i = new ImageView(this);
		i.setImageResource(imgs[9]);
		i.setScaleType(ImageView.ScaleType.FIT_XY);
		viewFlipper.addView(i, new LayoutParams(LayoutParams.MATCH_PARENT,
				LayoutParams.MATCH_PARENT));

		LayoutInflater factory = LayoutInflater.from(welcome.this);
		View last = factory.inflate(R.layout.welcomelast, null);
		viewFlipper.addView(last);
		
		final Button gointo = (Button) findViewById(R.id.button1);
		
		gointo.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				
				Intent intent = new Intent(welcome.this,
						Main.class);
				startActivity(intent);
				finish();
				onDestroy();
			}
			});
		
		viewFlipper.setAutoStart(true); // �����Զ����Ź��ܣ�����¼���ǰ�Զ����ţ�
		viewFlipper.setFlipInterval(5000);
		if (viewFlipper.isAutoStart() && !viewFlipper.isFlipping()) {
			viewFlipper.startFlipping();
		}
	}

	@Override
	public boolean onTouchEvent(MotionEvent event) {
		// TODO Auto-generated method stub
		viewFlipper.stopFlipping(); // ����¼���ֹͣ�Զ�����
		viewFlipper.setAutoStart(false);
		return gestureDetector.onTouchEvent(event); // ע�������¼�
	}

	@Override
	public boolean onDown(MotionEvent arg0) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean onFling(MotionEvent e1, MotionEvent e2, float arg2,
			float arg3) {
		if (e2.getX() - e1.getX() > 120) { // �������һ���������ҳ���
			Animation rInAnim = AnimationUtils.loadAnimation(mActivity,
					R.anim.push_right_in); // ���һ���������Ľ���Ч����alpha 0.1 -> 1.0��
			Animation rOutAnim = AnimationUtils.loadAnimation(mActivity,
					R.anim.push_right_out); // ���һ����Ҳ໬���Ľ���Ч����alpha 1.0 -> 0.1��

			viewFlipper.setInAnimation(rInAnim);
			viewFlipper.setOutAnimation(rOutAnim);
			viewFlipper.showPrevious();
			return true;
		} else if (e2.getX() - e1.getX() < -120) { // �������󻬶����ҽ������
			Animation lInAnim = AnimationUtils.loadAnimation(mActivity,
					R.anim.push_left_in); // ���󻬶�������Ľ���Ч����alpha 0.1 -> 1.0��
			Animation lOutAnim = AnimationUtils.loadAnimation(mActivity,
					R.anim.push_left_out); // ���󻬶��Ҳ໬���Ľ���Ч����alpha 1.0 -> 0.1��

			viewFlipper.setInAnimation(lInAnim);
			viewFlipper.setOutAnimation(lOutAnim);
			viewFlipper.showNext();
			return true;
		}
		return true;
	}

	@Override
	public void onLongPress(MotionEvent arg0) {
		// TODO Auto-generated method stub

	}

	@Override
	public boolean onScroll(MotionEvent arg0, MotionEvent arg1, float arg2,
			float arg3) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void onShowPress(MotionEvent arg0) {
		// TODO Auto-generated method stub

	}

	@Override
	public boolean onSingleTapUp(MotionEvent arg0) {
		// TODO Auto-generated method stub
		return false;
	}

}
