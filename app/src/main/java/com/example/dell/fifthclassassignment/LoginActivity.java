package com.example.dell.fifthclassassignment;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class LoginActivity extends AppCompatActivity implements View.OnClickListener {
    Button reset,back,login;
    EditText email,password;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.login_main);
        Intent i=getIntent();
        login=(Button) findViewById(R.id.logBtn);
        reset=(Button)findViewById(R.id.resetBtn);
        back=(Button)findViewById(R.id.BackBtn);
        email=(EditText)findViewById(R.id.emailEdt);
        password=(EditText)findViewById(R.id.passEdt);
        reset.setOnClickListener(this);
        login.setOnClickListener(this);
        back.setOnClickListener(this);




    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.logBtn:       String username=email.getText().toString();
                                    String pass=password.getText().toString();

                                    Intent i=new Intent(LoginActivity.this,Main2Activity.class);
                                    i.putExtra("name",username);
                                    startActivity(i);
                                    break;
            case R.id.resetBtn:     email.setText("");
                                    password.setText("");
                                    break;

        }


    }
}
