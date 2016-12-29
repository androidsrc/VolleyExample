package com.example.volley;

import android.app.ProgressDialog;
import android.content.Context;
import android.widget.TextView;

import com.android.volley.Request.Method;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;

public class NetworkStringLoader {
	Context context;
	TextView display;

	public NetworkStringLoader(Context con, TextView tv) {
		context = con;
		display = tv;
	}

	public void requestString(String url) {
		// Tag used to cancel the request
		String tag_string_req = "string_req";

		final ProgressDialog pDialog = new ProgressDialog(context);
		pDialog.setMessage("Loading...");
		pDialog.show();

		StringRequest strReq = new StringRequest(Method.GET, url,
				new Response.Listener<String>() {

					@Override
					public void onResponse(String response) {
						display.setText(response);
						pDialog.hide();

					}
				}, new Response.ErrorListener() {

					@Override
					public void onErrorResponse(VolleyError error) {
						display.setText(error.toString());
						pDialog.hide();
					}
				});

		// Adding request to request queue
		VolleySingleton.getInstance().addToRequestQueue(strReq, tag_string_req);
	}

}
