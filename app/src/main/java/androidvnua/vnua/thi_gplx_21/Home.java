package androidvnua.vnua.thi_gplx_21;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;

import com.jeremyfeinstein.slidingmenu.lib.SlidingMenu;

public class Home extends AppCompatActivity {

    private ImageView iconMenu;

    //  Khai báo button
    ConstraintLayout
            btnThiThu,
            btnCauDiemLiet,
            btnHocBienBao,
            btnCauSai,
            btnThiSaHinh,
            btnMeoThi;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        getSupportActionBar().hide();
        goibutton();

        // function sliding
        sliding();

    }

    //  Ánh xạ button
    public void goibutton() {
        btnThiThu = (ConstraintLayout) findViewById(R.id.btnBatDauThi);
        btnCauDiemLiet = (ConstraintLayout) findViewById(R.id.btnCauDiemLiet);
        btnHocBienBao = (ConstraintLayout) findViewById(R.id.btnCacBienBao);
        btnCauSai = (ConstraintLayout) findViewById(R.id.btnCauSai);
        btnThiSaHinh = (ConstraintLayout) findViewById(R.id.btnThiSaHinh);
        btnMeoThi = (ConstraintLayout) findViewById(R.id.btnMeoThi);
    }

    //  Hàm sự kiện Click
    public void onClick(View v) {
        if (v == btnThiThu) {
            Intent intent = new Intent(Home.this, StartTask.class);
            startActivity(intent);
        }else if (v == btnCauDiemLiet) {
            Toast.makeText(Home.this, "Phần câu diểm liệt", Toast.LENGTH_LONG).show();
        }else if (v == btnCauSai) {
            Toast.makeText(Home.this, "Phần câi trả lời sai", Toast.LENGTH_LONG).show();
        }else if (v == btnHocBienBao) {
            Toast.makeText(Home.this, "Phần học biển báo", Toast.LENGTH_LONG).show();
        }else if (v == btnThiSaHinh) {
            Toast.makeText(Home.this, "Phần thi sa hình", Toast.LENGTH_LONG).show();
        }else if (v == btnMeoThi) {
            Intent intent = new Intent(Home.this, Tutorial.class);
            startActivity(intent);
        }
    }

    // sliding
    public void sliding () {
        SlidingMenu menu = new SlidingMenu(this);
        menu.setMode(SlidingMenu.LEFT);
        menu.setTouchModeAbove(SlidingMenu.TOUCHMODE_FULLSCREEN);
        menu.setShadowWidthRes(R.dimen.shadow_width);
        menu.setShadowDrawable(R.drawable.shadow);
        menu.setBehindOffsetRes(R.dimen.slidingmenu_offset);
        menu.setFadeDegree(0.35f);
        menu.attachToActivity(this, SlidingMenu.SLIDING_CONTENT);
        menu.setMenu(R.layout.layout_menu);

        iconMenu = (ImageView) findViewById(R.id.icon_Menu);

        // click icon menu
        iconMenu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                menu.toggle();
            }
        });
    }

}