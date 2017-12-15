package com.example.hi.android_project;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    EditText e1,e2;
    Button b1,b2;
    String s1,s2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        e1=(EditText)findViewById(R.id.editText);           //username
        e2=(EditText)findViewById(R.id.editText2);         //password
        b1=(Button)findViewById(R.id.button);              //login
        b2=(Button)findViewById(R.id.button2);             //signup
        b2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i=new Intent(MainActivity.this,Signup.class);
                startActivity(i);
                finish();
            }
        });
        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                s1=e1.getText().toString();
                s2=e2.getText().toString();
                if(s1.equals("") || s2.equals(""))
                {
                    Toast.makeText(MainActivity.this, "fill all options", Toast.LENGTH_SHORT).show();
                }
                else
                {
                    SQLiteDatabase data=openOrCreateDatabase("net",MODE_PRIVATE,null);
                    data.execSQL("create table if not exists info(name varchar,password varchar,email varchar)");
                    String s3="select * from info where name='"+s1+"' and password='"+s2+"' ";
                    Cursor cursor=data.rawQuery(s3,null);
                    if(cursor.getCount()>0)
                    {
                        Toast.makeText(MainActivity.this, "Login successful", Toast.LENGTH_SHORT).show();
                        Intent i= new Intent(MainActivity.this,Menu.class);
                        startActivity(i);
                        finish();
                    }
                    else
                    {
                        Toast.makeText(MainActivity.this, "Mismatch", Toast.LENGTH_SHORT).show();
                    }
                }
            }
        });
    }
}
