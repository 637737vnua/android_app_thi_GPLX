package androidvnua.vnua.thi_gplx_21;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.TextView;

import androidvnua.vnua.BatDauThiThu.Home;

public class MainActivity extends AppCompatActivity {

    private static int SPLASH_SCREEN = 1;

    Animation animAlpha;
    TextView logo;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        animAlpha = AnimationUtils.loadAnimation(MainActivity.this, R.anim.anim_alpha);

        logo = findViewById(R.id.logo);

        logo.setAnimation(animAlpha);

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent intent = new Intent(MainActivity.this, Home.class);
                startActivity(intent);
                overridePendingTransition(android.R.anim.fade_in, android.R.anim.fade_out);
                finish();
            }
        }, SPLASH_SCREEN);
    }
}