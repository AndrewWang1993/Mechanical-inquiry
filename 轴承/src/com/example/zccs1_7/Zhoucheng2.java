package com.example.zccs1_7;

import com.example.zccs1_7.R;

import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;
import android.content.Context;
import android.graphics.*;
import android.graphics.drawable.BitmapDrawable;
import android.view.MotionEvent;
import android.widget.ImageView;
import android.widget.ImageView.ScaleType;

public class Zhoucheng2 extends Activity {
	/*
	 * ���ö�㴥��������ImageView��ͼ��ķŴ�����С
	 * ��ָ����ͼƬ�ƶ�
	 */
	
	private MyImageView imageView;
	private Bitmap bitmap;
	
	//���㴥����֮��ĳ���
	private float beforeLenght;
	private float afterLenght;
	
	//�����ƶ���ǰ������ֵ
	private float afterX,afterY;
	private float beforeX,beforeY;
	
	
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        findView();
        setContentView(imageView);
        config();
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.zhoucheng2, menu);
        return true;
    }
    



private void findView() {
	imageView = new MyImageView(this);
	//���ͼƬ
	bitmap = ((BitmapDrawable)getResources().getDrawable(R.drawable.xinjiuduizhao)).getBitmap();
}

private void config() {
	//����imageView����ʾͼƬ
	imageView.setImageBitmap(bitmap);
	//����ͼƬ���ImageView
	imageView.setScaleType(ScaleType.FIT_XY);
}

//����һ���Լ���ImageView��
	class MyImageView extends ImageView {
		private float scale = 0.1f;
		
		public MyImageView(Context context) {
			super(context);
		}
		//��������ImageView��λ��
		private void setLocation(int x,int y) {
			this.setFrame(this.getLeft()+x, this.getTop()+y, this.getRight()+x, this.getBottom()+y);
		}
		
private void setScale(float temp,int flag) {
			
			if(flag==0) {
				this.setFrame(this.getLeft()-(int)(temp*this.getWidth()), 
							  this.getTop()-(int)(temp*this.getHeight()), 
							  this.getRight()+(int)(temp*this.getWidth()), 
							  this.getBottom()+(int)(temp*this.getHeight()));	
			}else {
				this.setFrame(this.getLeft()+(int)(temp*this.getWidth()), 
							  this.getTop()+(int)(temp*this.getHeight()), 
						      this.getRight()-(int)(temp*this.getWidth()), 
						      this.getBottom()-(int)(temp*this.getHeight()));	
			}
}
			 @Override
		      protected void onDraw(Canvas canvas) {
		          super.onDraw(canvas);    
		          Rect rec=canvas.getClipBounds();
		          rec.bottom--;
		          rec.right--;
		          Paint paint=new Paint();
		          paint.setColor(Color.RED);
		          paint.setStyle(Paint.Style.STROKE);
		          canvas.drawRect(rec, paint);
		      }
			
			 
			/* ��ͼƬ������ָ������λ���ƶ�
			 * beforeX��Y����������ǰһλ�õ�����
			 * afterX��Y���������浱ǰλ�õ�����
			 * ���ǵĲ�ֵ����ImageView����������ӻ����ֵ
			 */
			public void moveWithFinger(MotionEvent event) {
				
				switch(event.getAction()) {
				
				case MotionEvent.ACTION_DOWN:
					beforeX = event.getX();
					beforeY = event.getY();
					break;
				case MotionEvent.ACTION_MOVE:
					afterX = event.getX();
					afterY = event.getY();
					
					this.setLocation((int)(afterX-beforeX),(int)(afterY-beforeY));
					
					beforeX = afterX;
					beforeY = afterY;
					break;
					
				case MotionEvent.ACTION_UP:
					break;
				}

			}
				/*
				 * ͨ����㴥���Ŵ����Сͼ��
				 * beforeLenght��������ǰһʱ������֮��ľ���
				 * afterLenght�������浱ǰʱ������֮��ľ���
				 */
				public void scaleWithFinger(MotionEvent event) {
					float moveX = event.getX(1) - event.getX(0);
					float moveY = event.getY(1) - event.getY(0);
					
					switch(event.getAction()) {
					case MotionEvent.ACTION_DOWN:
						beforeLenght = (float) Math.sqrt( (moveX*moveX) + (moveY*moveY) );
						break;
					case MotionEvent.ACTION_MOVE:
						//�õ�������֮��ĳ���
						afterLenght = (float) Math.sqrt( (moveX*moveX) + (moveY*moveY) );
						
						float gapLenght = afterLenght - beforeLenght;
						
						if(gapLenght == 0) {
							break;
						}
						
						//�����ǰʱ������������ǰһʱ��������룬��0������1
						if(gapLenght>0) {
							this.setScale(scale,0);
						}else {
							this.setScale(scale,1);
						}
						
						beforeLenght = afterLenght;
						break;
					}
				}
			 
		    }
			
		   //������������Ļ����ʱ��
		   @Override
			public boolean onTouchEvent(MotionEvent event) {
			   
			   /*
			    * �ж��û��Ƿ�������ͼƬ
			    * ����ǵ��㴥������ÿ���ͼƬ�ƶ��ķ���
			    * �����2�㴥������ÿ���ͼƬ��С�ķ���
			    */
			   	if(event.getY() > imageView.getTop() && event.getY() < imageView.getBottom()
			   			&& event.getX() > imageView.getLeft() && event.getX() < imageView.getRight()) {
			   		if(event.getPointerCount() == 2) {
				    	imageView.scaleWithFinger(event);
			    	}else if(event.getPointerCount() == 1) {
			    		imageView.moveWithFinger(event);
			    	}	   		
			   	}
				return true;
			}		


}