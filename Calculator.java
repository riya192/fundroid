package com.example.hi.android_project;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class Calculator extends AppCompatActivity {

    Button b1,b2,b3,b4,b5,b6;
    EditText e1,e2;
    String s1,s2,s3;
    TextView t1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calculator);
        b1=(Button)findViewById(R.id.button13);   //add
        b2=(Button)findViewById(R.id.button14);   //sub
        b3=(Button)findViewById(R.id.button15);    //mul
        b4=(Button)findViewById(R.id.button16);   //div
        b5=(Button)findViewById(R.id.button17);   //reset
        b6=(Button)findViewById(R.id.button18);    //back
        e1=(EditText)findViewById(R.id.editText6);  //first no
        e2=(EditText)findViewById(R.id.editText7);  //second no
        t1=(TextView)findViewById(R.id.textView2);  //ans

        b6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(Calculator.this,Menu.class);
                startActivity(i);
                finish();
            }
        });
        b5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                t1.setText("");
                e1.setText("");
                e2.setText("");
            }
        });
        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                s1=e1.getText().toString();
                s2=e2.getText().toString();
                Integer i1,i2,i3;
                i1=Integer.parseInt(s1);
                i2=Integer.parseInt(s2);
                i3=i2+i1;
                s3=Integer.toString(i3);
                t1.setText(s3);
            }
        });
        b2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                s1=e1.getText().toString();
                s2=e2.getText().toString();
                Integer i1,i2,i3;
                i1=Integer.parseInt(s1);
                i2=Integer.parseInt(s2);
                i3=i2-i1;
                s3=Integer.toString(i3);
                t1.setText(s3);
            }
        });
        b3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                s1=e1.getText().toString();
                s2=e2.getText().toString();
                Integer i1,i2,i3;
                i1=Integer.parseInt(s1);
                i2=Integer.parseInt(s2);
                i3=i2*i1;
                s3=Integer.toString(i3);
                t1.setText(s3);
            }
        });
        b4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                s1=e1.getText().toString();
                s2=e2.getText().toString();
                Integer i1,i2,i3;
                i1=Integer.parseInt(s1);
                i2=Integer.parseInt(s2);
                i3=i2/i1;
                s3=Integer.toString(i3);
                t1.setText(s3);
            }
        });


    }
}
