package com.example.sumofarray;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    // Used to load the 'native-lib' library on application startup.
    static {
        System.loadLibrary("native-lib");
    }

    Button checkSum;


    EditText number;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        checkSum=(Button)findViewById(R.id.checkNumber);
        number=(EditText)findViewById(R.id.number);

checkSum.setOnClickListener(new View.OnClickListener() {
    @Override
    public void onClick(View v) {
        int no = Integer.parseInt(number.getText().toString());
        int s=sum(no);
        Toast.makeText(MainActivity.this, "SUM = "+s, Toast.LENGTH_SHORT).show();
    }
});
    }

    /**
     * A native method that is implemented by the 'native-lib' native library,
     * which is packaged with this application.
     */
    public native int sum(int t);
}
