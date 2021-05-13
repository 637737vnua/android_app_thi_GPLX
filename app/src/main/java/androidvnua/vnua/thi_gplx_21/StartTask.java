package androidvnua.vnua.thi_gplx_21;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.os.CountDownTimer;
import android.util.Log;
import android.widget.TextView;

public class StartTask extends AppCompatActivity {

    TextView txtCountDown;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_start_task);
        getSupportActionBar().hide();

        getTextView();
        countDown();
    }

    private void getTextView() {
        txtCountDown = (TextView) findViewById(R.id.timeCountDown);
    }

    private void countDown() {
        final CountDownTimer countDownTimer = new CountDownTimer(1320000, 1000) {
            long min;
            int s = 60;
            String num01, num02;


            @Override
            public void onTick(long millisUntilFinished) {
                s--;
                min = millisUntilFinished/1000/60;
                num01 = addNumber0(min, 10);
                num02 = addNumber0(s, 10);
                txtCountDown.setText(num01+String.valueOf(min)+":"+num02+String.valueOf(s));
                if (s == 0) {
                    s = 60;
                }
            }

            @Override
            public void onFinish() {

            }
        };

        countDownTimer.start();
    }

    private String addNumber0(long number, int min){
        String string;
        if (number < min) {
            string = "0";
        }else {
            string = "";
        }
        return string;
    }

}