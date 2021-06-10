package androidvnua.vnua.mucdethi;

import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.widget.ListView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import java.lang.reflect.Field;
import java.util.ArrayList;

import androidvnua.vnua.database.dbCauHoi;
import androidvnua.vnua.thi_gplx_21.R;

public class MainActivity_start extends AppCompatActivity {

    dbCauHoi db;
    String maDe;
    ArrayList<ListQuestion> listQuestions;
    AdapterListQues adapter;
    ListView listView;

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
}