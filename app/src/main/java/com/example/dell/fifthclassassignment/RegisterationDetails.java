package com.example.dell.fifthclassassignment;

import android.content.Intent;
import android.graphics.Bitmap;
import android.provider.MediaStore;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.ContextMenu;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class RegisterationDetails extends AppCompatActivity implements View.OnClickListener{
    TextView tv1,tv2,tv3,tv4,tv5,tv6,tv7;
int c,s;
    Button back,profile;
    private static final int CAMERA_PIC_REQUEST = 1337;
    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registeration_details);
        tv7=(TextView)findViewById(R.id.id1);
        registerForContextMenu(tv7);
        Intent i=getIntent();

        back=(Button)findViewById(R.id.backBtn);
        profile=(Button)findViewById(R.id.profileBtn);
        String username=i.getStringExtra("name");
        String phone=i.getStringExtra("phone");
        String email=i.getStringExtra("email");
        String password=i.getStringExtra("password");
      String country=i.getStringExtra("country");
        String state=i.getStringExtra("state");
 this.c=i.getIntExtra("cid",0);
        this.s=i.getIntExtra("sid",0);


        tv1=(TextView)findViewById(R.id.textV1);
        tv1.setText(username);

        tv2=(TextView)findViewById(R.id.textV2);
        tv2.setText(phone);

        tv3=(TextView)findViewById(R.id.textV3);
        tv3.setText(email);

        tv4=(TextView)findViewById(R.id.textV4);
        tv4.setText(password);

    tv5=(TextView)findViewById(R.id.textV5);
        tv5.setText(country);


        tv6=(TextView)findViewById(R.id.textV6);
        tv6.setText(state);



       back.setOnClickListener(this);
        profile.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
              Intent cam=new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
              startActivityForResult(cam,CAMERA_PIC_REQUEST);


            }
        });
    }
    protected void onActivityResult(int rc,int r,Intent data){
        if(rc==CAMERA_PIC_REQUEST){
            Bitmap image=(Bitmap)data.getExtras().get("data");
            ImageView img=(ImageView)findViewById(R.id.imV);
            img.setImageBitmap(image);

        }
    }

    @Override
    public void onClick(View v) {
        Intent intent = new Intent(RegisterationDetails.this,MainActivity.class);
        intent.putExtra("name2",tv1.getText().toString());
        intent.putExtra("mail2",tv3.getText().toString());
        intent.putExtra("phone2",tv2.getText().toString());
        intent.putExtra("country2",c);
        intent.putExtra("state2",s);
        //intent.putExtra("state2",tv6.getText().toString());

        startActivity(intent);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater menuInflater=getMenuInflater();
        menuInflater.inflate(R.menu.main,menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch(item.getItemId()){
            case R.id.i1: Toast.makeText(getApplicationContext(),"SETTINGS MENU ITEM SELECTED",Toast.LENGTH_SHORT).show();
            break;
            case R.id.i2: Toast.makeText(getApplicationContext(),"LOG OUT MENU ITEM SELECTED",Toast.LENGTH_SHORT).show();
                break;
            case R.id.i3: Toast.makeText(getApplicationContext(),"HELP MENU ITEM SELECTED",Toast.LENGTH_SHORT).show();
                break;
            case R.id.i4: Toast.makeText(getApplicationContext(),"ABOUT US MENU ITEM SELECTED",Toast.LENGTH_SHORT).show();
                break;
        }


        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {
        super.onCreateContextMenu(menu, v, menuInfo);
        menu.setHeaderTitle("MY CONTEXT MENU");
        menu.setHeaderIcon(R.mipmap.ic_launcher);
        MenuInflater inflater = getMenuInflater();

        menu.add(0,100,1,"Cut");
        menu.add(0,101,2,"Copy");
        menu.add(0,102,3,"paste");
        menu.add(0,103,4,"Delete");
        menu.add(0,104,5,"pa");


    }
}

