package com.example.volley;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends Activity {
	String urlString = "http://androidsrc.net/api/sample_files/sample.html";
	String urlJSON = "http://androidsrc.net/api/sample_files/sample.json";
	Button stringLoaderBtn, jsonLoaderBtn;
	TextView tv;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		tv = (TextView) findViewById(R.id.textView1);
		stringLoaderBtn = (Button) findViewById(R.id.buttonLoadString);
		stringLoaderBtn.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				NetworkStringLoader loader = new NetworkStringLoader(
						MainActivity.this, tv);
				loader.requestString(urlString);
			}
		});
		jsonLoaderBtn = (Button) findViewById(R.id.buttonJSONRequest);
		jsonLoaderBtn.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				NetworkJSONLoader j = new NetworkJSONLoader(MainActivity.this,
						tv);
				j.requestJSON(urlJSON);
			}
		});

	}
}
