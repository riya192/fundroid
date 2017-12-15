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

public class Signup extends AppCompatActivity {

    EditText e1,e2,e3;
    Button b1,b2;
    String s1,s2,s3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup);
        e1=(EditText)findViewById(R.id.editText3);           //username
        e2=(EditText)findViewById(R.id.editText4);         //password
        e3=(EditText)findViewById(R.id.editText5);         //email
        b1=(Button)findViewById(R.id.button3);              //back
        b2=(Button)findViewById(R.id.button4);               //signup
        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i=new Intent(Signup.this,MainActivity.class);
                startActivity(i);
                finish();
            }
        });
        b2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                s1=e1.getText().toString();
                s2=e2.getText().toString();
                s3=e3.getText().toString();
                if(s1.equals("") || s2.equals("") || s3.equals(""))
                {
                    Toast.makeText(Signup.this, "fill all options ", Toast.LENGTH_SHORT).show();
                }
                else
                {
                    SQLiteDatabase data = openOrCreateDatabase("net",MODE_PRIVATE,null);
                    data.execSQL("create table if not exists info(name varchar,password varchar,email varchar)");
                    String s4="select * from info where name='"+s1+"' and password='"+s2+"'";
                    Cursor cursor =data.rawQuery(s4,null);
                    if(cursor.getCount()>0)
                    {
                        Toast.makeText(Signup.this, "User already exists", Toast.LENGTH_SHORT).show();
                    }
                    else
                    {
                        data.execSQL("insert into info values('"+s1+"','"+s2+"','"+s3+"');");
                        Toast.makeText(Signup.this, "Sign up successful", Toast.LENGTH_SHORT).show();

                        Intent i=new Intent(Signup.this,MainActivity.class);
                        startActivity(i);
                        finish();

                    }
                }
            }
        });
    }
}
