package androidvnua.vnua.thi_gplx_21;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

public class Home extends AppCompatActivity {

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
            Toast.makeText(Home.this, "Bắt đầu thi", Toast.LENGTH_LONG).show();
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

}