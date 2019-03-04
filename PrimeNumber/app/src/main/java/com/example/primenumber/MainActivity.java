package com.example.primenumber;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;


public class MainActivity extends AppCompatActivity {

    // Used to load the 'native-lib' library on application startup.
    static {
        System.loadLibrary("native-lib");
    }


    Button checkPrime;


    EditText number;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        checkPrime=(Button)findViewById(R.id.checkNumber);
        number=(EditText)findViewById(R.id.number);


        checkPrime.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (!number.getText().toString().isEmpty()) {
                    int no = Integer.parseInt(number.getText().toString());
                    if (isPrime(no)) {
                        Toast.makeText(MainActivity.this, "Prime Number", Toast.LENGTH_SHORT).show();
                    } else {
                        Toast.makeText(MainActivity.this, "Not Prime Number", Toast.LENGTH_SHORT).show();
                    }
                }
            }

        });
    }

    /**
     * A native method that is implemented by the 'native-lib' native library,
     * which is packaged with this application.
     */
    public native boolean isPrime(int t);
}





