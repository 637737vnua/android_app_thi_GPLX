package androidvnua.vnua.mucdethi.BatDauThiThu;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.KeyEvent;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import java.util.Random;

import androidvnua.vnua.thi_gplx_21.Home;
import androidvnua.vnua.thi_gplx_21.R;

public class KiemTraKetQua extends AppCompatActivity {

    private String maDe, cauSai;
    private int soCauDung;
    private TextView txtDiem, txtMsg, TxtMsg2;
    private ImageView imgKetQua;

    @SuppressLint({"SetTextI18n", "ResourceAsColor"})
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_kiem_tra_ket_qua);
        Intent intent = getIntent();
        maDe = intent.getStringExtra("ma_de");
        soCauDung = intent.getIntExtra("so_cau_dung", 0);
        cauSai = intent.getStringExtra("cau_sai");

        anhxa();
        txtDiem.setText("Điểm của bạn là: "+soCauDung+"/6");
        if (soCauDung >= 5) {
            imgKetQua.setImageResource(R.drawable.winner);
            txtMsg.setTextColor(Color.GREEN);
            txtMsg.setText("Bạn đã thi đậu");
            randomMsgSuccess();
        } else {
            imgKetQua.setImageResource(R.drawable.book);
            txtMsg.setTextColor(Color.RED);
            txtMsg.setText("Bạn đã trượt");
            randomMsgFailed();
        }
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

    private void anhxa() {
        TxtMsg2 = findViewById(R.id.txtMsg2);
        txtDiem = findViewById(R.id.txtDiem);
        txtMsg = findViewById(R.id.txtMsg);
        imgKetQua = findViewById(R.id.imgKetQua);
    }

    private void randomMsgSuccess() {
        Random random = new Random();
        int randomMsg = random.nextInt(5)+1;
        switch (randomMsg) {
            case 1:
                TxtMsg2.setText("Hãy không ngừng nỗ lực nổ đạt kết quả cao nhất bạn nhé!");
                break;
            case 2:
                TxtMsg2.setText("Chúc mừng bạn!");
                break;
            case 3:
                TxtMsg2.setText("Vnua team sẽ giúp bạn vượt qua kì thi sắp tới!");
                break;
            case 4:
                TxtMsg2.setText("Hãy ôn tập thật tốt nhé!");
                break;
            default:
                TxtMsg2.setText("Cố lên nào!");
        }
    }

    private void randomMsgFailed() {
        Random random = new Random();
        int randomMsg = random.nextInt(5)+1;
        switch (randomMsg) {
            case 1:
                TxtMsg2.setText("Không sao cả hãy cố hết sức nào!");
                break;
            case 2:
                TxtMsg2.setText("Bạn nên ôn tập lại kiến thức!");
                break;
            case 3:
                TxtMsg2.setText("Có lẽ kiến thức của bạn vẫn còn thiếu!");
                break;
            case 4:
                TxtMsg2.setText("Hãy ôn tập thật tốt nhé!");
                break;
            default:
                TxtMsg2.setText("Chỉ là thi thử thôi cố gắng lên nào!");
        }
    }
}