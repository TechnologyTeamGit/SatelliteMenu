package my.example.popseletemenu;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup.MarginLayoutParams;
import android.view.Window;
import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.Toast;

public class MainActivity extends Activity {
	private LinearLayout popLayout;
	private MarginLayoutParams params;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		requestWindowFeature(Window.FEATURE_NO_TITLE);
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		popLayout=(LinearLayout)this.findViewById(R.id.popLayout);
		Button moveOut=(Button)this.findViewById(R.id.moveOut);
		Button moveInt=(Button)this.findViewById(R.id.moveInt);
		Button button=(Button)this.findViewById(R.id.button);
		final Animation animation_out=AnimationUtils.loadAnimation(MainActivity.this, R.anim.anim_out);
		animation_out.setFillAfter(false);
		final Animation animation_int=AnimationUtils.loadAnimation(MainActivity.this, R.anim.anim_int);
		animation_int.setFillAfter(true);
		moveOut.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				popLayout.startAnimation(animation_out);
				animation_out.setAnimationListener(new AnimationListener(){

					@Override
					public void onAnimationStart(Animation animation) {
						// TODO Auto-generated method stub
						
					}

					@Override
					public void onAnimationEnd(Animation animation) {
						popLayout.clearAnimation();//清除动画，以避免闪动
						params=(MarginLayoutParams) popLayout.getLayoutParams();
						params.topMargin=0;
						popLayout.setLayoutParams(params);
						Toast.makeText(MainActivity.this, "done", Toast.LENGTH_LONG).show();
					}

					@Override
					public void onAnimationRepeat(Animation animation) {
						// TODO Auto-generated method stub
						
					}
					
				});
			}
		});
		moveInt.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				popLayout.startAnimation(animation_int);
				animation_int.setAnimationListener(new AnimationListener(){

					@Override
					public void onAnimationStart(Animation animation) {
						// TODO Auto-generated method stub
						
					}

					@Override
					public void onAnimationEnd(Animation animation) {
						//popLayout.clearAnimation();//清除动画，以避免闪动
						params=(MarginLayoutParams) popLayout.getLayoutParams();
						params.topMargin=-59;
						popLayout.setLayoutParams(params);
						
					}

					@Override
					public void onAnimationRepeat(Animation animation) {
						// TODO Auto-generated method stub
						
					}
					
				});
				
			}
		});
		button.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				Toast.makeText(MainActivity.this, "可以点击", Toast.LENGTH_LONG).show();
			}
		});
	}

}
