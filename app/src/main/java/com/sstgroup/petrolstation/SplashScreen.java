package com.sstgroup.petrolstation;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.MotionEvent;

import com.sstgroup.petrolstation.activities.LoginActivity;

public class SplashScreen extends Activity {

    private Thread mSplashThread;

    @Override

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash_screen);
        final SplashScreen sPlashScreen = this;

        mSplashThread =  new Thread(){
            @Override
            public void run(){
                try {
                    synchronized(this){
                        wait(3000);
                    }
                }
                catch(InterruptedException ex){
                }
                finish();

                Intent intent = new Intent();
                intent.setClass(sPlashScreen, LoginActivity.class);
                startActivity(intent);
                overridePendingTransition(R.anim.bounce, R.anim.zoom_out);


            }
        };

        mSplashThread.start();
    }

    @Override
    public boolean onTouchEvent(MotionEvent evt)
    {
        if(evt.getAction() == MotionEvent.ACTION_UP)
        {
            synchronized(mSplashThread){
                mSplashThread.notifyAll();
            }
        }
        return true;

    }

}

