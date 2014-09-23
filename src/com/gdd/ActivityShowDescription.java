package com.gdd;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class ActivityShowDescription extends Activity {
	public void onCreate(Bundle icicle) {
		super.onCreate(icicle);
		setContentView(R.layout.showdescription);
		String content = null;
		Intent startingIntent = getIntent();

		if (startingIntent != null) {
			Bundle bundle = startingIntent
					.getBundleExtra("android.intent.extra.lineItem");
			if (bundle == null) {
				content = "不好意思程序出错啦";
			} else {
				content = bundle.getString("name") + "\n\n"
						+ bundle.getString("stats");
			}
			
//	    	 b.putString("book", feed.getItem(position).getBook());
//	    	 b.putString("title", feed.getItem(position).getTitle());
//	    	 b.putString("year", feed.getItem(position).getYear());
//	    	 b.putString("price", feed.getItem(position).getPrice());
			
			
		} else {
			content = "不好意思程序出错啦";

		}

		TextView textView = (TextView) findViewById(R.id.content);
		textView.setText(content);

		Button backbutton = (Button) findViewById(R.id.back);

		backbutton.setOnClickListener(new Button.OnClickListener() {
			public void onClick(View v) {
				finish();
			}
		});
	}
}

