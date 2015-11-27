package com.example.redcdnnotification;

import android.app.Activity;
import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends Activity {
	// 通知id
	private static final int NOTICE_ID = 1222;
	private Button notify;
	private Button cancel;
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		notify = (Button) findViewById(R.id.noti);
		cancel = (Button) findViewById(R.id.cancel);
		notify.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				notityMe();
			}
		});

		cancel.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				final NotificationManager manager = (NotificationManager) getSystemService(NOTIFICATION_SERVICE);
				// 取消通知
				manager.cancel(NOTICE_ID);
			}
		});
	}

	private void notityMe() {
		// 获得通知管理器，通知是一项系统服务
		final NotificationManager manager = (NotificationManager) getSystemService(NOTIFICATION_SERVICE);
		// 初始化通知对象 p1:通知的图标 p2:通知的状态栏显示的提示 p3:通知显示的时间
		Notification notification = new Notification(R.drawable.ic_launcher, "通知测试",
				System.currentTimeMillis());
		// 点击通知后的Intent，此例子点击后还是在当前界面
		Intent myIntent = new Intent(this,DennySecondActivity.class);
		PendingIntent intent = PendingIntent.getActivity(this, 0, myIntent, 0);
		// 设置通知信息
		notification.setLatestEventInfo(this, "通知title", "通知信息内容", intent);
		// 通知
		manager.notify(NOTICE_ID, notification);
	}
}
