package com.example.streetartgallery;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        Button btn = findViewById(R.id.button2);
        Button btn2 = findViewById(R.id.button3);
        Button btn3 = findViewById(R.id.button4);
        Button btn4 = findViewById(R.id.button5);
        Button btn6 = findViewById(R.id.button6);
        Button btn7 = findViewById(R.id.button7);
        Button btn8 = findViewById(R.id.button8);
        Button btn9 = findViewById(R.id.button9);

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                EditText in1=(EditText) findViewById(R.id.editText2);

                Intent myIntent = new Intent(MainActivity.this,Main2Activity.class);
                myIntent.putExtra("ID",Integer.parseInt(in1.getText().toString()));

                startActivity(myIntent);

            }
        });

        btn6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                EditText in1=(EditText) findViewById(R.id.editText62);
                EditText in2=(EditText) findViewById(R.id.editText63);

                Intent myIntent = new Intent(MainActivity.this,Main6Activity.class);
                myIntent.putExtra("ID",Integer.parseInt(in1.getText().toString()));
                myIntent.putExtra("NAME",in2.getText().toString());

                startActivity(myIntent);

            }
        });

        btn7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                EditText in1=(EditText) findViewById(R.id.editText74);
                EditText in2=(EditText) findViewById(R.id.editText75);

                Intent myIntent = new Intent(MainActivity.this,Main7Activity.class);
                myIntent.putExtra("ID",Integer.parseInt(in1.getText().toString()));
                myIntent.putExtra("NAME",in2.getText().toString());

                startActivity(myIntent);

            }
        });
        btn8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                EditText in1=(EditText) findViewById(R.id.editText84);
                EditText in2=(EditText) findViewById(R.id.editText85);
                EditText in3=(EditText) findViewById(R.id.editText86);
                EditText in4=(EditText) findViewById(R.id.editText87);

                Intent myIntent = new Intent(MainActivity.this,Main8Activity.class);
                myIntent.putExtra("ID",Integer.parseInt(in1.getText().toString()));
                myIntent.putExtra("pass",in2.getText().toString());
                myIntent.putExtra("LNAME",in3.getText().toString());
                myIntent.putExtra("FNAME",in4.getText().toString());

                startActivity(myIntent);

            }
        });
        btn9.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                EditText in1=(EditText) findViewById(R.id.editText91);

                Intent myIntent = new Intent(MainActivity.this,Main9Activity.class);
                myIntent.putExtra("ID",Integer.parseInt(in1.getText().toString()));

                startActivity(myIntent);

            }
        });

        btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
              //  EditText in1=(EditText) findViewById(R.id.editText2);

                Intent myIntent = new Intent(MainActivity.this,Main3Activity.class);
            //    myIntent.putExtra("ID",Integer.parseInt(in1.getText().toString()));

                startActivity(myIntent);

            }
        });
        btn3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
               // EditText in1=(EditText) findViewById(R.id.editText2);

                Intent myIntent = new Intent(MainActivity.this,Main4Activity.class);
         //       myIntent.putExtra("ID",Integer.parseInt(in1.getText().toString()));

                startActivity(myIntent);

            }
        });
        btn4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
          //      EditText in1=(EditText) findViewById(R.id.editText2);

                Intent myIntent = new Intent(MainActivity.this,Main5Activity.class);
           //     myIntent.putExtra("ID",Integer.parseInt(in1.getText().toString()));

                startActivity(myIntent);

            }
        });




    }

}