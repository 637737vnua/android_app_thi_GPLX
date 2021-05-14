package androidvnua.vnua.thi_gplx_21;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

import static androidvnua.vnua.thi_gplx_21.CountDownText.*;

public class StartTask extends AppCompatActivity {

    TextView txtCountDown;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_start_task);

        getTextView();
        CountDownText.countDown(1320000, 1000, txtCountDown);

    }

    private void getTextView() {
        txtCountDown = (TextView) findViewById(R.id.timeCountDown);
    }

}