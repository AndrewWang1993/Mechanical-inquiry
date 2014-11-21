package com.wangxm.mechanical_inquiry;
//所需改进
//1_1公差   一个数据数据应该对应一个随机数，或者引入数据库真实数据。
//1_2形位公差 增加对输入错误数据如0的判断。增加数据库从assert文件夹写入data的功能。
//html 浏览时 取消四周padding 5dip
//增加主界面滑动流畅度
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.GestureDetector;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.ViewFlipper;

import com.example.gc1_1.gongcha1_1;
import com.example.xwgc1_2.xingweigongcha1_2;
import com.example.lwbz1_3.luowenbiaozhun;
import com.example.clsj1_4.chilunsheji;
import com.example.wlwg1_5.wolunwogan;
import com.example.llsj1_6.lianlunsheji;
import com.example.zccs1_7.zhoucheng;
import com.example.lzq1_8.lianzhouqi;
import com.example.clzl1_9.cailiaozhongliang;
import com.example.cydy2_1.Changyongdanwei;
import com.example.sjhs2_2.Sanjiaohanshu;
import com.example.gcclsj2_3.gongchengcailiao;
import com.example.thcs2_4.tanhuangcanshu;
import com.example.skzl2_5.Shukongzhiling;
import com.example.jxzshz2_6.Jixiezhishi;
import com.example.jlj2_7.jianlianjie;
import com.example.hjlj2_8.huajianlianjie;
import com.example.xlj2_9.xiaolianjie;
import com.example.jsqx3_1.jinshuqiexue;
import com.example.maindlg.R;

public class MainDlg extends Activity implements
android.view.GestureDetector.OnGestureListener{

	private GestureDetector gestureDetector;
	private ViewFlipper viewFlipper;
	private Activity mActivity;
	
	@SuppressWarnings("deprecation")
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.maindlg);
		
		mActivity = this;
		viewFlipper = (ViewFlipper) findViewById(R.id.viewflipper);
		gestureDetector = new GestureDetector(this);
		
		LayoutInflater factory = LayoutInflater.from(MainDlg.this);
		View first = factory.inflate(R.layout.firstpage, null);
		viewFlipper.addView(first);
		View second = factory.inflate(R.layout.secondpage, null);
		viewFlipper.addView(second);
		View third = factory.inflate(R.layout.thirdpage, null);
		viewFlipper.addView(third);
		
       Button btn11 = (Button) findViewById(R.id.button11);
		
		btn11.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				Intent intent = new Intent(MainDlg.this,
						gongcha1_1.class);
				startActivity(intent);
				onDestroy();
			}
			});
		
		Button btn12 = (Button) findViewById(R.id.button12);
		
		btn12.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				
				Intent intent = new Intent(MainDlg.this,
						xingweigongcha1_2.class);
				startActivity(intent);
				onDestroy();
			}
		});
		
		Button btn13 = (Button) findViewById(R.id.button13);
		
		btn13.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				
				Intent intent = new Intent(MainDlg.this,
						luowenbiaozhun.class);
				startActivity(intent);
				onDestroy();
			}
		});
		
		Button btn14 = (Button) findViewById(R.id.button14);
		
		btn14.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				
				Intent intent = new Intent(MainDlg.this,
						chilunsheji.class);
				startActivity(intent);
				onDestroy();
			}
		});
		Button btn15 = (Button) findViewById(R.id.button15);
		
		btn15.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				
				Intent intent = new Intent(MainDlg.this,
						wolunwogan.class);
				startActivity(intent);
				onDestroy();
			}
		});
		Button btn16 = (Button) findViewById(R.id.button16);
		
		btn16.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				
				Intent intent = new Intent(MainDlg.this,
						lianlunsheji.class);
				startActivity(intent);
				onDestroy();
			}
		});
		Button btn17 = (Button) findViewById(R.id.button17);
		
		btn17.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				
				Intent intent = new Intent(MainDlg.this,
						zhoucheng.class);
				startActivity(intent);
				onDestroy();
			}
		});
		
		Button btn18 = (Button) findViewById(R.id.button18);
		
		btn18.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				
				Intent intent = new Intent(MainDlg.this,
						lianzhouqi.class);
				startActivity(intent);
				onDestroy();
			}
		});
		
		Button btn19 = (Button) findViewById(R.id.button19);
		
		btn19.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				
				Intent intent = new Intent(MainDlg.this,
						cailiaozhongliang.class);
				startActivity(intent);
				onDestroy();
			}
		});
		
		
		
		Button btn21 = (Button) findViewById(R.id.button21);
		
		btn21.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				
				Intent intent = new Intent(MainDlg.this,
						Changyongdanwei.class);
				startActivity(intent);
				onDestroy();
			}
		});
		
	Button btn22 = (Button) findViewById(R.id.button22);
		
		btn22.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				
				Intent intent = new Intent(MainDlg.this,
						Sanjiaohanshu.class);
				startActivity(intent);
				onDestroy();
			}
		});
		
			
		Button btn23 = (Button) findViewById(R.id.button23);
		
		btn23.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				
				Intent intent = new Intent(MainDlg.this,
						gongchengcailiao.class);
				startActivity(intent);
				onDestroy();
			}
		});
		
		Button btn24 = (Button) findViewById(R.id.button24);
		
		btn24.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				
				Intent intent = new Intent(MainDlg.this,
						tanhuangcanshu.class);
				startActivity(intent);
				onDestroy();
			}
		});
		
	
		
		Button btn25 = (Button) findViewById(R.id.button25);
		
		btn25.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				
				Intent intent = new Intent(MainDlg.this,
						Shukongzhiling.class);
				startActivity(intent);
				onDestroy();
			}
		});
		
		Button btn26 = (Button) findViewById(R.id.button26);
		
		btn26.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				
				Intent intent = new Intent(MainDlg.this,
						Jixiezhishi.class);
				startActivity(intent);
				onDestroy();
			}
		});
		
			Button btn27 = (Button) findViewById(R.id.button27);
			
			btn27.setOnClickListener(new OnClickListener() {
				@Override
				public void onClick(View v) {
					
					Intent intent = new Intent(MainDlg.this,
							jianlianjie.class);
					startActivity(intent);
					onDestroy();
				}
			});
			
			
			Button btn28 = (Button) findViewById(R.id.button28);
			
			btn28.setOnClickListener(new OnClickListener() {
				@Override
				public void onClick(View v) {
					
					Intent intent = new Intent(MainDlg.this,
							huajianlianjie.class);
					startActivity(intent);
					onDestroy();
				}
			});
			
			Button btn29 = (Button) findViewById(R.id.button29);
			
			btn29.setOnClickListener(new OnClickListener() {
				@Override
				public void onClick(View v) {
					
					Intent intent = new Intent(MainDlg.this,
							xiaolianjie.class);
					startActivity(intent);
					onDestroy();
				}
			});
			
			Button btn31 = (Button) findViewById(R.id.button31);
			
			btn31.setOnClickListener(new OnClickListener() {
				@Override
				public void onClick(View v) {
					
					Intent intent = new Intent(MainDlg.this,
							jinshuqiexue.class);
					startActivity(intent);
					onDestroy();
				}
			});
		
		
		
	
	}


	@Override
	public boolean onTouchEvent(MotionEvent event) {
		return gestureDetector.onTouchEvent(event); // 注册手势事件
	}
	
	
	@Override
	public boolean onDown(MotionEvent e) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean onFling(MotionEvent e1, MotionEvent e2, float velocityX,
			float velocityY) {
		if (e2.getX() - e1.getX() > 100) { // 从左向右滑动（左进右出）
			Animation rInAnim = AnimationUtils.loadAnimation(mActivity,
					R.anim.push_right_in); // 向右滑动左侧进入的渐变效果（alpha 0.1 -> 1.0）
			Animation rOutAnim = AnimationUtils.loadAnimation(mActivity,
					R.anim.push_right_out); // 向右滑动右侧滑出的渐变效果（alpha 1.0 -> 0.1）

			viewFlipper.setInAnimation(rInAnim);
			viewFlipper.setOutAnimation(rOutAnim);
			viewFlipper.showPrevious();
			return true;
		} else if (e2.getX() - e1.getX() < -100) { // 从右向左滑动（右进左出）
			Animation lInAnim = AnimationUtils.loadAnimation(mActivity,
					R.anim.push_left_in); // 向左滑动左侧进入的渐变效果（alpha 0.1 -> 1.0）
			Animation lOutAnim = AnimationUtils.loadAnimation(mActivity,
					R.anim.push_left_out); // 向左滑动右侧滑出的渐变效果（alpha 1.0 -> 0.1）

			viewFlipper.setInAnimation(lInAnim);
			viewFlipper.setOutAnimation(lOutAnim);
			viewFlipper.showNext();
			return true;
		}
		return true;
	}

	@Override
	public void onLongPress(MotionEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public boolean onScroll(MotionEvent e1, MotionEvent e2, float distanceX,
			float distanceY) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void onShowPress(MotionEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public boolean onSingleTapUp(MotionEvent e) {
		// TODO Auto-generated method stub
		return false;
	}

}
