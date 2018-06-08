package com.example.dell.fifthclassassignment;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class Main2Activity extends AppCompatActivity {
TextView tv;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        Intent i=getIntent();
        String username=i.getStringExtra("name");
        tv=(TextView)findViewById(R.id.textV);
        tv.setText(tv.getText()+""+username+",");
    }
}
