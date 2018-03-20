package com.ssi;

import java.util.ArrayList;


import java.util.List;

import org.apache.http.Header;
import org.apache.http.HeaderIterator;
import org.apache.http.HttpEntity;
import org.apache.http.HttpEntityEnclosingRequest;
import org.apache.http.HttpResponse;
import org.apache.http.NameValuePair;
import org.apache.http.ProtocolVersion;
import org.apache.http.RequestLine;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.params.HttpParams;
import org.apache.http.util.EntityUtils;

import android.os.AsyncTask;
import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class second extends Activity {
private EditText tcode,tname,taddress,tspecialist;
    @Override
    protected void onCreate(Bundle savedInstanceState) 
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
    tcode=(EditText)findViewById(R.id.tcode);
    tname=(EditText)findViewById(R.id.tname);
    taddress=(EditText)findViewById(R.id.taddress);
    tspecialist=(EditText)findViewById(R.id.tspeciality);
    }
   public void saveData(View v)
   {
	   	// 127.0.0.1
	 
	   
	   String s="http://192.168.43.207:8080/Myserver/Emp.jsp";
	   Test t1=new Test();
	   t1.execute(s);
   }
   
   class Test extends AsyncTask
   {

	@Override
	protected String doInBackground(Object...v) {
	String s="";
	   String code=tcode.getText().toString().trim();
	   String name=tname.getText().toString().trim();
	   String address=taddress.getText().toString().trim();
	   String specialist=tspecialist.getText().toString().trim();
	   List<NameValuePair> lst=new ArrayList<NameValuePair>();
	  lst.add(new BasicNameValuePair("c", code));
	  lst.add(new BasicNameValuePair("n",name));
	  lst.add(new BasicNameValuePair("ci", address));
	  lst.add(new BasicNameValuePair("s", specialist));
	  DefaultHttpClient client=new DefaultHttpClient();
		HttpPost post=new HttpPost(v[0].toString());
	try{
		post.setEntity(new UrlEncodedFormEntity(lst));
		HttpResponse res=client.execute(post);
		HttpEntity en=res.getEntity();
	    s=EntityUtils.toString(en);
    	}
	catch(Exception ex){}
		
		return s;
	}
	 
	@Override
	protected void onPostExecute(Object result) {
		// TODO Auto-generated method stub
		show(String.valueOf(result));
		super.onPostExecute(result);
	}
	   
   }
   public void show(String s1)
   {
	   Toast.makeText(this, s1,Toast.LENGTH_LONG).show();
	   
   }
}
