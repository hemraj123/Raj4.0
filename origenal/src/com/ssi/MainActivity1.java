package com.ssi;

import android.*;
import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import junit.framework.TestCase;

public class MainActivity1 extends Activity {

    Button btn1;
    Button btn2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main1);
       
        btn1=(Button)findViewById(R.id.btn1);
        btn2=(Button)findViewById(R.id.btn2);
        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
               
                    Intent i=new Intent(MainActivity1.this,second.class);
                  //  MainActivity.setData(Uri.parse(fileUrl));
                    startActivity(i);
                
            }
        });
        
        btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
               
                    Intent i=new Intent(MainActivity1.this,third.class);
                  //  MainActivity.setData(Uri.parse(fileUrl));
                    startActivity(i);
                
            }
        });
       
    }
}
	


