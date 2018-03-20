package com.ssi;

import junit.framework.TestCase;

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
import android.widget.TextView;
import android.widget.Toast;

public class third extends Activity {
private EditText tspecialist;
private TextView tv1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main3);
    tspecialist=(EditText)findViewById(R.id.tspecialist);
    tv1=(TextView)findViewById(R.id.tv1);
    
    }
    public void SearchData(View v)
    {
 	String s="http://192.168.43.207:8080/Myserver/searchEmp.jsp?s="+tspecialist.getText().toString().trim()+"";
 	
 	Search ob=new Search();
    ob.execute(s);
    
    }
    
    public class Search extends AsyncTask
    {
		@Override
		protected String doInBackground(Object... params) {
			  DefaultHttpClient client=new DefaultHttpClient();
				HttpGet get=new HttpGet(params[0].toString());
				String s="";
			try{
				HttpResponse res=client.execute(get);
				HttpEntity en=res.getEntity();
					s=EntityUtils.toString(en);
			}
			catch(Exception ex){}
			return s;
		}
    	
    	@Override
    	protected void onPostExecute(Object result) {
    		// TODO Auto-generated method stub
    	  disp(String.valueOf(result));
    		super.onPostExecute(result);
    	}
    }
    
    public void disp(String data)
    {
       	//Toast.makeText(this, data,Toast.LENGTH_LONG).show();
    	 String s1="";
    	   
    	String ar[]=data.split(",");
    	 
    for(String s:ar)
    {
    	  s1+=s+"\n";
    }
  tv1.setText(s1);
    
    }
  
}
