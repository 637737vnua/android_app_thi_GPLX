package androidvnua.vnua.mucdethi.BatDauThiThu;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.database.Cursor;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.view.Gravity;
import android.view.KeyEvent;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;
import android.widget.SeekBar;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import java.lang.reflect.Field;
import java.util.ArrayList;

import androidvnua.vnua.database.dbCauHoi;
import androidvnua.vnua.mucdethi.AdapterListQues;
import androidvnua.vnua.mucdethi.ListQuestion;
import androidvnua.vnua.thi_gplx_21.R;

public class MainActivity_start extends AppCompatActivity {

    private dbCauHoi db;
    private String maDe;
    private ArrayList<ListQuestion> listQuestions;
    private AdapterListQues adapter;
    private ListView listView;
    private TextView txtCountDown, txtDe;
    private Button btnChecked;
    private CountDownTimer mcountDownTimer;
    private Button btnBack;
    private long timeLeftInMilliseconds = 900000; // 1p;
    private int count = 0;
    private int countPass = 0;
    private String msg = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_start);
        Intent intent = getIntent();
        maDe = intent.getStringExtra("ma_de");

        connectDB();
        anhxa();
        getCauHoi();
        CountDown();
        CreateBtn();
        ClickBtnBack();

        adapter = new AdapterListQues(this, listQuestions);
        listView.setAdapter(adapter);

        txtDe.setText("Đề số "+maDe);
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
        int cauDiemLiet = dataCauHoi.getColumnIndex("CauDiemLiet");

        while (dataCauHoi.moveToNext()) {
            int idCauHoi= dataCauHoi.getInt(id);
            String isSpecial = dataCauHoi.getString(cauDiemLiet);
            String Ques = dataCauHoi.getString(cauhoi);
            String A = dataCauHoi.getString(cauHoiA);
            String B = dataCauHoi.getString(cauHoiB);
            String C = dataCauHoi.getString(cauHoiC);
            String D = dataCauHoi.getString(cauHoiD);
            String img = dataCauHoi.getString(image);
            String Ans = dataCauHoi.getString(dapAn);
            int resID = getResId(img, R.drawable.class);
            listQuestions.add(new ListQuestion(idCauHoi, isSpecial, ""+Ques, ""+A, ""+B, ""+C, ""+D, resID, ""+Ans));
        }

    }

    private void anhxa() {
        listView = (ListView) findViewById(R.id.listStart);
        txtCountDown = (TextView) findViewById(R.id.txtCountDown);
        btnBack = (Button) findViewById(R.id.back);
        txtDe = (TextView) findViewById(R.id.txtSoDe);
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

    private void dialogHetGio() {
        Dialog dialog = new Dialog(this);
        dialog.setContentView(R.layout.dialog_custom_thi);
        dialog.show();
        dialog.setCanceledOnTouchOutside(false);
        dialog.setCancelable(false);

        Button btnKiemTraInDiaLOg = (Button) dialog.findViewById(R.id.btnXemKQ);
        btnKiemTraInDiaLOg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                for (int i = 0; i < adapter.isPass.length; i++) {
                    if (adapter.isPass[i]) {
                        countPass++;
                        msg = msg +":"+ adapter.isPass[i];
                    }
                }
                if (countPass > 0) {
                    Toast.makeText(MainActivity_start.this, "Bạn đã trượt", Toast.LENGTH_LONG).show();
                    countPass = 0;
                    msg = "";
                } else {
                    for (int i = 0; i < adapter.ans.length; i++) {
                        if (adapter.ans[i]) {
                            count++;
                        } {
                            msg = msg +":"+i;
                        }
                    }

                    Intent intent = new Intent(MainActivity_start.this, KiemTraKetQua.class);
                    mcountDownTimer.cancel();
                    intent.putExtra("ma_de", maDe);
                    intent.putExtra("so_cau_dung", count);
                    intent.putExtra("cau_sai", msg);
                    startActivity(intent);
                    finish();
                }
            }
        });
    }


    // Xử lý khi người dùng click quay trở lại trên thanh cứng android
    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        switch(keyCode){
            case KeyEvent.KEYCODE_BACK:
                DiaLogBack("Bạn có muốn dừng làm bài không?");
                return true;
        }
        return super.onKeyDown(keyCode, event);
    }

    // Function DiaLogBack xử lý thông báo
    public void DiaLogBack(String title) {
        //Tạo đối tượng
        AlertDialog.Builder b = new AlertDialog.Builder(this);
        b.setCancelable(false);
        //Thiết lập tiêu đề
        b.setTitle("Xác nhận");
        b.setMessage(title);
        // Nút Ok
        b.setPositiveButton("Đồng ý", new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialog, int id) {
                mcountDownTimer.cancel();
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

    public void CreateBtn () {
        btnChecked = new Button(this);

        btnChecked.setText("Nộp Bài");
        btnChecked.setGravity(Gravity.CENTER);

        btnChecked.setTextColor(getApplication().getResources().getColor(R.color.white));
        Drawable custom = getDrawable(R.drawable.button_check);

        btnChecked.setBackground(custom);

        if (btnChecked != null) {
           listView.addFooterView(btnChecked);
        }

        btnChecked.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                DiaLogCheck("Vẫn còn thời gian bạn muốn nộp bài không?");
            }
        });
    }

    public void ClickBtnBack() {
        btnBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                DiaLogBack("Bạn có muốn dừng làm bài không?");
            }
        });
    }

    public void DiaLogCheck(String title) {

        AlertDialog.Builder b = new AlertDialog.Builder(this);
        b.setCancelable(false);
        b.setTitle("Xác nhận nộp bài");
        b.setMessage(title);
        b.setPositiveButton("Đồng ý", new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialog, int id) {
                for (int i = 0; i < adapter.ans.length; i++) {
                    if (adapter.ans[i]) {
                        count++;
                    } {
                        msg = msg +":"+i;
                    }
                }

                for (int i = 0; i < adapter.isPass.length; i++) {
                    if (adapter.isPass[i]) {
                        countPass++;
                    }
                }

                if (countPass > 0) {
                    Intent intent = new Intent(MainActivity_start.this, KiemTraKetQua.class);
                    mcountDownTimer.cancel();
                    intent.putExtra("ma_de", maDe);
                    intent.putExtra("so_cau_dung", count);
                    intent.putExtra("cau_sai", msg);
                    intent.putExtra("isPass", false);
                    startActivity(intent);
                    finish();
                } else {
                    Intent intent = new Intent(MainActivity_start.this, KiemTraKetQua.class);
                    mcountDownTimer.cancel();
                    intent.putExtra("ma_de", maDe);
                    intent.putExtra("so_cau_dung", count);
                    intent.putExtra("cau_sai", msg);
                    intent.putExtra("isPass", true);
                    startActivity(intent);
                    finish();
                }
            }
        });

        b.setNegativeButton("Chưa nộp bài", new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialog, int id) {
                dialog.cancel();
            }
        });

        AlertDialog al = b.create();
        al.show();
    }
}