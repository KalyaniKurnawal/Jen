package com.example.earphoneconnectivity;

import android.annotation.TargetApi;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.media.AudioDeviceInfo;
import android.media.AudioManager;
import android.os.Build;
import android.provider.Telephony;
import android.support.annotation.RequiresApi;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import static android.os.Build.VERSION_CODES.P;


public class MainActivity extends AppCompatActivity {
    TextView t1,t2,t3;
    private MusicIntentReceiver myReceiver;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        t1 = (TextView) findViewById(R.id.textView1);
        t2 = (TextView) findViewById(R.id.textView2);
        t3 = (TextView) findViewById(R.id.textView3);

        myReceiver = new MusicIntentReceiver();
    }

    @Override
    public void onResume() {
        IntentFilter filter = new IntentFilter(Intent.ACTION_HEADSET_PLUG);
        registerReceiver(myReceiver, filter);
        super.onResume();
    }

    @Override
    public void onPause() {
        unregisterReceiver(myReceiver);
        super.onPause();
    }


    private class MusicIntentReceiver extends BroadcastReceiver {

        @TargetApi(Build.VERSION_CODES.P)
        @RequiresApi(api = Build.VERSION_CODES.P)
        @Override
        public void onReceive(Context context, Intent intent) {
            if (intent.getAction().equals(Intent.ACTION_HEADSET_PLUG)) {
                int state;
                state = intent.getIntExtra("state", -1);
                switch (state) {
                    case 0:
                        t1.setText("OFF");
                        break;
                    case 1:
                        t1.setText("ON");
                        break;
                    default:
                        t1.setText("NO IDEA");
                }
            }

            AudioManager am1 = (AudioManager) getSystemService(Context.AUDIO_SERVICE);
            AudioDeviceInfo[] devices = new AudioDeviceInfo[0];
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
                devices = am1.getDevices(AudioManager.GET_DEVICES_ALL);
            }
            for (AudioDeviceInfo device : devices) {
                int type = 0;
                int id = 0;
                String addr = null;
                CharSequence prod = null;
                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
                    type = device.getType();

                        addr=device.getAddress();


                    prod = device.getProductName();
                    id = device.getId();
                }
                switch (type) {
                    case AudioDeviceInfo.TYPE_WIRED_HEADPHONES:
                        t2.setText("WIRED_HEADPHONES");

                        t3.setText("Address = "+addr+"\nProductName = "+prod+"\nID = "+id);
                        break;
                    case AudioDeviceInfo.TYPE_WIRED_HEADSET:
                        t2.setText("WIRED_HEADSET");

                        t3.setText("Address = "+addr+"\nProductName = "+prod+"\nID = "+id);
                        break;
                    case AudioDeviceInfo.TYPE_USB_DEVICE:
                        t2.setText("USB_DEVICE");

                        t3.setText("Address = "+addr+"\nProductName = "+prod+"\nID = "+id);
                        break;
                    case AudioDeviceInfo.TYPE_UNKNOWN:
                        t2.setText("UNKNOWN");

                        t3.setText("Address = "+addr+"\nProductName = "+prod+"\nID = "+id);
                        break;
                }

            }
        }
    }
}
