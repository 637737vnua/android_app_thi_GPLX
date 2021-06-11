package androidvnua.vnua.mucdethi;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.view.KeyEvent;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import java.lang.reflect.Field;
import java.util.ArrayList;

import androidvnua.vnua.database.dbCauHoi;
import androidvnua.vnua.thi_gplx_21.CountDownText;
import androidvnua.vnua.thi_gplx_21.R;

public class MainActivity_start extends AppCompatActivity {

    dbCauHoi db;
    String maDe;
    ArrayList<ListQuestion> listQuestions;
    AdapterListQues adapter;
    ListView listView;
    TextView txtCountDown;
    CountDownTimer mcountDownTimer;
    long timeLeftInMilliseconds = 60000; // 1p;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_start);
        Intent intent = getIntent();
        maDe =intent.getStringExtra("ma_de");

        connectDB();
        anhxa();
        getCauHoi();
        adapter = new AdapterListQues(MainActivity_start.this, R.layout.custom_view_question, listQuestions);
        listView.setAdapter(adapter);

        CountDown();

    }

    private void connectDB() {
        db = new dbCauHoi(this, "CauHoiDataBase.sqlite", null, 1);
    }

    private void getCauHoi() {
        listQuestions.clear();

        Cursor dataCauHoi = db.GetData("SELECT * FROM CauHoi WHERE soDe ="+ maDe);
        int id = dataCauHoi.getColumnIndex("ID");
        int cauhoi = dataCauHoi.getColumnIndex("CauHoi");
        int sode = dataCauHoi.getColumnIndex("soDe");
        int cauHoiA = dataCauHoi.getColumnIndex("CauHoiA");
        int cauHoiB = dataCauHoi.getColumnIndex("CauHoiB");
        int cauHoiC = dataCauHoi.getColumnIndex("CauHoiC");
        int cauHoiD = dataCauHoi.getColumnIndex("CauHoiD");
        int image = dataCauHoi.getColumnIndex("Image");
        int dapAn = dataCauHoi.getColumnIndex("DapAn");

        while (dataCauHoi.moveToNext()) {
            int idCauHoi= dataCauHoi.getInt(id);
            String Ques = dataCauHoi.getString(cauhoi);
            String A = dataCauHoi.getString(cauHoiA);
            String B = dataCauHoi.getString(cauHoiB);
            String C = dataCauHoi.getString(cauHoiC);
            String D = dataCauHoi.getString(cauHoiD);
            String img = dataCauHoi.getString(image);
            String Ans = dataCauHoi.getString(dapAn);
            int resID = getResId(img, R.drawable.class);
            listQuestions.add(new ListQuestion(""+Ques, ""+A, ""+B, ""+C, ""+D, resID, ""+Ans));
        }

    }

    private void anhxa() {
        listView = (ListView) findViewById(R.id.listStart);
        txtCountDown = (TextView) findViewById(R.id.txtCountDown);
        listQuestions = new ArrayList<>();
    }

    public static int getResId(String resName, Class<?> c) {
        try {
            Field idField = c.getDeclaredField(resName);
            return idField.getInt(idField);
        } catch (Exception e) {
            e.printStackTrace();
            return 0;
        }
    }

    // Function xử lý CountDownTimer
    public void CountDown() {
        mcountDownTimer = new CountDownTimer(timeLeftInMilliseconds, 1000) {
            @Override
            public void onTick(long millisUntilFinished) {
                timeLeftInMilliseconds = millisUntilFinished;
                updateTimer();
            }

            @Override
            public void onFinish() {
                dialogHetGio();
            }
        }.start();
    }

    // Function Update timer xử lý thời gian và setText
    public void updateTimer() {
        long second = (timeLeftInMilliseconds % 60000) / 1000;

        // minutes = 120000 / 60000 = 2 (m)
        int minutes = (int) timeLeftInMilliseconds / 60000;

        // seconds = (120000 % 60000) / 1000 = 0;
        int seconds = (int) second;

        // Thời gian còn lại
        String timeLeftText;

        // 2:
        timeLeftText = "" + minutes;
        timeLeftText += ":";

        // nếu seconds(s) < 10
        if (seconds < 10) {
            //2:0
            timeLeftText += "0";
        }

        // 2:00
        timeLeftText += seconds;

        txtCountDown.setText(timeLeftText);
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

    private void dialogHetGio() {
        Dialog dialog = new Dialog(this);
        dialog.setContentView(R.layout.dialog_custom_thi);
        dialog.show();
        dialog.setCanceledOnTouchOutside(false);
        dialog.setCancelable(false);
    }


    // Xử lý khi người dùng click quay trở lại trên thanh cứng android
    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        switch(keyCode){
            case KeyEvent.KEYCODE_BACK:
                DiaLogBack();
                return true;
        }
        return super.onKeyDown(keyCode, event);
    }

    // Function DiaLogBack xử lý thông báo
    public void DiaLogBack() {
        //Tạo đối tượng
        AlertDialog.Builder b = new AlertDialog.Builder(this);
        //Thiết lập tiêu đề
        b.setTitle("Xác nhận");
        b.setMessage("Bạn có đồng ý thoát chương trình không?");
        // Nút Ok
        b.setPositiveButton("Đồng ý", new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialog, int id) {
                finish();
            }
        });
        //Nút Cancel
        b.setNegativeButton("Không đồng ý", new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialog, int id) {
                dialog.cancel();
            }
        });
        //Tạo dialog
        AlertDialog al = b.create();
        //Hiển thị
        al.show();
    }
}