package qr.cpe.project.com.qr_notify;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;



public class Splash_Screen extends AppCompatActivity {
    private Handler handler;
    private Runnable runnable;
    private long delay_time  = 3000;
    private long time = 3000L;
    private String TAG = "Splash screen";
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_splash_screen);

        init();
    }

    private void init(){
        try{

            getSupportActionBar().hide();
            handler = new Handler();

            runnable = new Runnable() {
                @Override
                public void run() {
                    Intent intent = new Intent(Splash_Screen.this, MainActivity.class);
                    startActivity(intent);
                    finish();
                }
            };

        }catch (Exception e){
            Log.e(TAG,e.getMessage());
        }

    }

    @Override
    protected void onResume() {
        super.onResume();
        try{
            delay_time = time;
            handler.postDelayed(runnable,delay_time);
            time = System.currentTimeMillis();
        }catch (Exception e){
            Log.e(TAG,e.getMessage());
        }
    }

    @Override
    protected void onPause() {
        super.onPause();
        try{
            handler.removeCallbacks(runnable);
            time = delay_time - (System.currentTimeMillis() - time);
        }catch (Exception e){
            Log.e(TAG,e.getMessage());
        }

    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        try{
            handler.removeCallbacks(runnable);
            time = delay_time - (System.currentTimeMillis() - time);
        }catch (Exception e){
            Log.e(TAG,e.getMessage());
        }
    }
}
