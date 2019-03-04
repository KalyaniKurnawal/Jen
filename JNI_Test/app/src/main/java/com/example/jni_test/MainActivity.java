package com.example.jni_test;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    TextView textView;
    static {
        System.loadLibrary("native-lib");
    }

    public native String getMessageFromNative();

    public native float getMemberFieldFromNative(MeshData obj);

    public native int invokeMemberFuncFromNative(MeshData obj);

    public native MeshData createObjectFromNative(int param);

    public native int processObjectArrayFromNative(MeshData[] objArray);

    @Override
    public void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);

        // get simple string from native
        String msg = getMessageFromNative();

        // access class member in native code and return result to caller
        MeshData obj = new MeshData(3);
        msg += "\n\nResult getMemberFieldFromNative: "+ getMemberFieldFromNative(obj);
        msg += "\nResult invokeMemberFuncFromNative: "+ invokeMemberFuncFromNative(obj);

        // create object in native method and return it to caller
        MeshData obj2 = createObjectFromNative(18);
        msg += "\n\nResult createObjectFromNative: " + obj2.getFacetCount();

        // process object array in native code and return result to caller
        MeshData[] objArray = new MeshData[]
                {
                        new MeshData(10),
                        new MeshData(20)
                };

        int arrayRes = processObjectArrayFromNative(objArray);
        msg += "\n\nResult processObjectArrayFromNative: " + arrayRes;

        textView = new TextView(this);
        textView.setText(msg);
        setContentView(textView);
    }
}
