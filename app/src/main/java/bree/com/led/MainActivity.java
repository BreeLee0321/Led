package bree.com.led;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
    private Boolean needblink=true;
    public void click(View v){
        switch (v.getId()){
            case R.id.on:
                needblink=true;
                Thread t1 = new Thread() {
                    @Override
                    public void run() {
                        while (needblink) {
                            try {
                                Thread.sleep(100);
                            } catch (InterruptedException e) {
                                e.printStackTrace();
                            }
                            if (!needblink)
                                break;
                            LedSpeakerUtil.setLedOn();
                            try {
                                Thread.sleep(100);
                            } catch (InterruptedException e) {
                                e.printStackTrace();
                            }
                            LedSpeakerUtil.setLedOff();
                        }
                    }
                };
                t1.start();
                break;
            case R.id.off:
                LedSpeakerUtil.setLedOff();
                needblink=false;
            break;

        }
    }
}
