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
	// ֪ͨid
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
				// ȡ��֪ͨ
				manager.cancel(NOTICE_ID);
			}
		});
	}

	private void notityMe() {
		// ���֪ͨ��������֪ͨ��һ��ϵͳ����
		final NotificationManager manager = (NotificationManager) getSystemService(NOTIFICATION_SERVICE);
		// ��ʼ��֪ͨ���� p1:֪ͨ��ͼ�� p2:֪ͨ��״̬����ʾ����ʾ p3:֪ͨ��ʾ��ʱ��
		Notification notification = new Notification(R.drawable.ic_launcher, "֪ͨ����",
				System.currentTimeMillis());
		// ���֪ͨ���Intent�������ӵ�������ڵ�ǰ����
		Intent myIntent = new Intent(this,DennySecondActivity.class);
		PendingIntent intent = PendingIntent.getActivity(this, 0, myIntent, 0);
		// ����֪ͨ��Ϣ
		notification.setLatestEventInfo(this, "֪ͨtitle", "֪ͨ��Ϣ����", intent);
		// ֪ͨ
		manager.notify(NOTICE_ID, notification);
	}
}
