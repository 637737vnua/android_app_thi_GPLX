package androidvnua.vnua.thi_gplx_21;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

public class StartTask extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_start_task);
        getSupportActionBar().hide();
    }
}