package com.example.sno;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    static {
        System.loadLibrary("native-lib");
    }
    int no1,counter=0;
    int[] array = new int[10];
    Button button1,button2,button3;
    EditText editText1,editText2;
    TextView textView;

    EditText number;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        button1=(Button)findViewById(R.id.button);
        editText1=(EditText)findViewById(R.id.number);
        button2=(Button)findViewById(R.id.next);
        editText2=(EditText)findViewById(R.id.edtxt);
        button3=(Button)findViewById(R.id.btn);
        textView=(TextView)findViewById(R.id.textView);

        button3.setEnabled(false);
        button2.setEnabled(false);

        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                button1.setEnabled(false);
                button2.setEnabled(true);

                no1 = Integer.parseInt(editText1.getText().toString());
                Toast.makeText(MainActivity.this,"No of element taken",Toast.LENGTH_SHORT).show();
            }
        });

        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int no2 = Integer.parseInt(editText2.getText().toString());
                editText2.getText().clear();

                if(counter<no1)
                {
                  array[counter]=no2;
                  counter++;
                }
                if(counter==no1)
                {
                    button2.setEnabled(false);
                    button3.setEnabled(true);

                }
                Toast.makeText(MainActivity.this,"Element "+no2+" added to array",Toast.LENGTH_SHORT).show();
            }
        });
        button3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if(sort(array,no1)) {

                    textView.setText("Sorted");
                }
                else
                {
                    textView.setText("Not Sorted");
                }
            }
        });

    }

    public native boolean sort(int[] array,int no1);
  }
