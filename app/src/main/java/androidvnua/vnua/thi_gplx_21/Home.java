package androidvnua.vnua.thi_gplx_21;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;

import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.drawerlayout.widget.DrawerLayout;

import com.google.android.material.navigation.NavigationView;

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

    //Menu bar
    DrawerLayout drawerLayout;
    NavigationView navigationView;
    androidx.appcompat.widget.Toolbar toolbar;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        goibutton();

        // Menu
        renderMenu();
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
            Intent intent = new Intent(Home.this, TrafficSign.class);
            startActivity(intent);
        }else if (v == btnThiSaHinh) {
            Toast.makeText(Home.this, "Phần thi sa hình", Toast.LENGTH_LONG).show();
        }else if (v == btnMeoThi) {
            Intent intent = new Intent(Home.this, Tutorial.class);
            startActivity(intent);
        }
    }

    // Hàm menu
    private void renderMenu() {
        drawerLayout = findViewById(R.id.drawer_layout);
        navigationView = findViewById(R.id.navc_view);
        toolbar = findViewById(R.id.toolbar);

        setSupportActionBar(toolbar);

        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(Home.this, drawerLayout, toolbar, R.string.Open, R.string.Close);
        drawerLayout.addDrawerListener(toggle);
        toggle.syncState();
    }

}