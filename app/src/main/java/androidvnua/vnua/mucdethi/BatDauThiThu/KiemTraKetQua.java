package androidvnua.vnua.mucdethi.BatDauThiThu;

import android.content.Intent;
import android.os.Bundle;
import android.view.KeyEvent;

import androidx.appcompat.app.AppCompatActivity;

import androidvnua.vnua.thi_gplx_21.Home;
import androidvnua.vnua.thi_gplx_21.R;

public class KiemTraKetQua extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_kiem_tra_ket_qua);
    }

    // Xử lý khi người dùng click quay trở lại trên thanh cứng android
    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        switch(keyCode){
            case KeyEvent.KEYCODE_BACK:
                Intent intent = new Intent(KiemTraKetQua.this, Home.class);
                startActivity(intent);
                return true;
        }
        return super.onKeyDown(keyCode, event);
    }
}