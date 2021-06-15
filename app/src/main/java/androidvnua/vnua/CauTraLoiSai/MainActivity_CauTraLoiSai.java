package androidvnua.vnua.CauTraLoiSai;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.database.Cursor;
import android.os.Bundle;
import android.widget.TextView;

import java.util.ArrayList;

import androidvnua.vnua.database.dbCauHoi;
import androidvnua.vnua.thi_gplx_21.R;

public class MainActivity_CauTraLoiSai extends AppCompatActivity {

    private RecyclerView rcv;
    private AdapterCauHoiSai adapterCauHoiSai;
    private ArrayList<ObjCauTraLoiSai> arrayList;
    private dbCauHoi db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_cau_tra_loi_sai);

        // kết nối db
        connectDB();

        // ánh xạ
        init ();

        // Khởi tạo hàm + adapter
        InitArrayAndAdapter();
    }

    private void connectDB() {
        db = new dbCauHoi(this, "CauHoiDataBase.sqlite", null, 1);
    }

    private void init () {
        rcv = (RecyclerView) findViewById(R.id.rcv);
    }

    private void InitArrayAndAdapter() {
        arrayList = new ArrayList<>();

        // add item từ database
        addArrayList();
        adapterCauHoiSai = new AdapterCauHoiSai(this, arrayList);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        rcv.setLayoutManager(linearLayoutManager);
        rcv.setAdapter(adapterCauHoiSai);
    }

    private void addArrayList () {
        Cursor cursorCauHoiSai = db.GetData("SELECT * FROM CauHoiSai");
        while (cursorCauHoiSai.moveToNext()) {
            int id = cursorCauHoiSai.getInt(0);
            int idCauHoiSai = cursorCauHoiSai.getInt(1);

            Cursor cursorCauHoi = db.GetData("SELECT * FROM CauHoi WHERE ID = '"+idCauHoiSai+"'");
            while (cursorCauHoi.moveToNext()) {
                int idCauHoi = cursorCauHoi.getInt(0);
                String CauHoi = cursorCauHoi.getString(1);
                String dapAn = cursorCauHoi.getString(8);
                String textDapAn ="";
                if (dapAn.equals("A")) {
                    textDapAn = cursorCauHoi.getString(2);
                } else if (dapAn.equals("B")) {
                    textDapAn = cursorCauHoi.getString(3);
                } else if (dapAn.equals("C")) {
                    textDapAn = cursorCauHoi.getString(4);
                } else if (dapAn.equals("D")) {
                    textDapAn = cursorCauHoi.getString(5);
                }
                String value = dapAn +". "+ textDapAn;
                arrayList.add(new ObjCauTraLoiSai(CauHoi.trim(), value.trim(), idCauHoi));
            }
            System.out.println("Câu hỏi sai là: " + idCauHoiSai);
        }
    }
}