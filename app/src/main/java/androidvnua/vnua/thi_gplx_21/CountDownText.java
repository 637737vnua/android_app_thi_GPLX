package androidvnua.vnua.thi_gplx_21;

import android.widget.TextView;

public class CountDownText {
        static void countDown(long millislnFuture, long countDownInterval, TextView view) {
            final android.os.CountDownTimer countDownTimer = new android.os.CountDownTimer(millislnFuture, countDownInterval) {
                long min;
                int s = 60;
                String num01, num02;

                @Override
                public void onTick(long millisUntilFinished) {
                    s--;
                    min = millisUntilFinished/1000/60;
                    num01 = addNumber0(min, 10);
                    num02 = addNumber0(s, 10);
                    view.setText(num01+String.valueOf(min)+":"+num02+String.valueOf(s));
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

        private static String addNumber0(long number, int min){
            String string;
            if (number < min) {
                string = "0";
            }else {
                string = "";
            }
            return string;
        }
}
