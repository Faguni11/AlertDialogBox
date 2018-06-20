package com.example.dell.fifthclassassignment;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.icu.text.UnicodeSetSpanner;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import java.util.List;

public class MainActivity extends AppCompatActivity  {

    int p1,p2;
    String text="";
    String text2="";
Button register,details,create;
EditText name,email,phone,password;
SharedPreferences sharedPreferences;
String UKEY="n",PKEY="e",PINKEY="pi";
String[] countryArr={
        "India",
        "Japan",
        "Canada"
};
String[] IndiaArr={
        "Assam",
        "Bihar",
        "Goa",
        "Delhi"};
String[] JapanArr={
        "Tokyo",
        "Kyoto",
        "Osaka",
        "Nara"};
String[] CanadaArr={
        "Ontario",
        "Alberta",
        "Quebec",
        "Manitoba"};

Spinner stateSpinner,countrySpinner;
ArrayAdapter<String> countryAdapter,Adapter1,Adapter2,Adapter3;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        register=(Button)findViewById(R.id.registerBtn);
        details=(Button)findViewById(R.id.detailsBtn);
        create=(Button)findViewById(R.id.bid);
        name=(EditText)findViewById(R.id.nameET);
        email=(EditText) findViewById(R.id.emailET);
        phone=(EditText)findViewById(R.id.phoneET);
        password=(EditText) findViewById(R.id.passET);

        sharedPreferences=getSharedPreferences("mysharedpre", Context.MODE_PRIVATE);
        if(sharedPreferences.contains(UKEY)&&sharedPreferences.contains(PKEY)&&sharedPreferences.contains(PINKEY)){
Intent intent=new Intent(MainActivity.this,PinActivity.class);
startActivity(intent);

        }


        countrySpinner=(Spinner)findViewById(R.id.CountrySpinner);
        stateSpinner=(Spinner)findViewById(R.id.StateSpinner);
        countryAdapter=new ArrayAdapter<String>(getApplicationContext(),android.R.layout.simple_spinner_item,countryArr);
        countrySpinner.setAdapter(countryAdapter);

        countrySpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {

                if(position == 0){

                    Adapter1=new ArrayAdapter<String>(getApplicationContext(),android.R.layout.simple_spinner_item,IndiaArr);
                    stateSpinner.setAdapter(Adapter1);
                }

                else
                if(position == 1){
                    Adapter2=new ArrayAdapter<String>(getApplicationContext(),android.R.layout.simple_spinner_item,JapanArr);
                    stateSpinner.setAdapter(Adapter2);
                }
                else
                if(position == 2){
                    Adapter3=new ArrayAdapter<String>(getApplicationContext(),android.R.layout.simple_spinner_item,CanadaArr);
                    stateSpinner.setAdapter(Adapter3);
                }
                stateSpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
                    @Override
                    public void onItemSelected(AdapterView<?> p, View v, int po, long i) {
                        p2 = stateSpinner.getSelectedItemPosition();
                        text2=stateSpinner.getItemAtPosition(p2).toString();
                    }
                    @Override
                    public void onNothingSelected(AdapterView<?> parent) {

                    }

                });
                p1 = countrySpinner.getSelectedItemPosition();
                 text=countrySpinner.getItemAtPosition(p1).toString();

            }
            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
        details.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, RegisterationDetails.class);
                String mail=email.getText().toString();
                String pass=password.getText().toString();
                String phoneNo=phone.getText().toString();
                String username=name.getText().toString();

                intent.putExtra("name",username);
                intent.putExtra("phone",phoneNo);
                intent.putExtra("email",mail);
                intent.putExtra("password",pass);
                intent.putExtra("country",text);
              intent.putExtra("state",text2);
                intent.putExtra("cid",p1);
                intent.putExtra("sid",p2);

                startActivity(intent);
            }
        });
        register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent intent = new Intent(MainActivity.this, LoginActivity.class);
                startActivity(intent);
            }
        });
        name.setText(getIntent().getStringExtra("name2"));
        email.setText(getIntent().getStringExtra("mail2"));
        phone.setText(getIntent().getStringExtra("phone2"));

        countrySpinner.setSelection(getIntent().getIntExtra("country2",0));

        stateSpinner.setSelection(getIntent().getIntExtra("state2",0));


    create.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            String uname=name.getText().toString();
            String pwd=password.getText().toString();
            String em=email.getText().toString();
            SharedPreferences.Editor editor=sharedPreferences.edit();
            editor.putString(UKEY,uname);
            editor.putString(PKEY,pwd);
            editor.putString(PINKEY,em);
            editor.commit();
            Toast.makeText(MainActivity.this,"DETAILS SAVED",Toast.LENGTH_SHORT).show();
        }
    });
    
    
    }
    public void onBackPressed() {
        openAlert();
    }
    private void openAlert(){
        AlertDialog.Builder alertDialogBuilder=new AlertDialog.Builder(MainActivity.this);
        alertDialogBuilder.setTitle("EXIT APP");
        alertDialogBuilder.setMessage("ARE YOU SURE YOU WANT TO EXIT");
        alertDialogBuilder.setIcon(R.mipmap.ic_launcher);
        alertDialogBuilder.setPositiveButton("Yes,Exit app", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                Toast.makeText(MainActivity.this,"Exiting app",Toast.LENGTH_SHORT).show();
                finish();
            }
        });
        alertDialogBuilder.setNegativeButton("No,don't Exit app", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                Toast.makeText(MainActivity.this,"Staying on the app",Toast.LENGTH_SHORT).show();
                dialog.cancel();
            }
        });
        AlertDialog alertDialog = alertDialogBuilder.create();
        alertDialog.show();
    }
}
