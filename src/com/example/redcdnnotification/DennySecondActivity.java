package com.example.redcdnnotification;

import android.app.Activity;
import android.os.Bundle;
import android.widget.TextView;

public class DennySecondActivity extends Activity {
	
	private TextView mtv;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_second);
		TextView mtv = (TextView)findViewById(R.id.tv);
	}

	
	
	

}
