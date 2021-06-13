package androidvnua.vnua.mucdethi;

import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.GridView;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;
import androidvnua.vnua.database.dbCauHoi;
import androidvnua.vnua.mucdethi.BatDauThiThu.MainActivity_start;
import androidvnua.vnua.thi_gplx_21.R;

public class MainActivity_dethi extends AppCompatActivity {

    dbCauHoi db;

    GridView gridView;
    ArrayList<titleStack> listTitle;
    AdapterGridView adapter;
    int count = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_dethi);
        connectDB();
        getData();
        customTitle();
    }

    private void connectDB() {
        db = new dbCauHoi(this, "CauHoiDataBase.sqlite", null, 1);
    }

    private void getData() {

        Cursor dataCauHoi = db.GetData("SELECT * FROM CauHoi");

        while (dataCauHoi.moveToNext()) {
            count++;
        }
    }

    private void customTitle() {
        gridView = (GridView) findViewById(R.id.grView);

        listTitle = new ArrayList<>();

        for (int i = 1; i <= count/20; i++) {
            listTitle.add(new titleStack(String.valueOf(i)));
        }

        adapter = new AdapterGridView( MainActivity_dethi.this, R.layout.custom_btn_dethi, listTitle);
        gridView.setAdapter(adapter);

        gridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent intent = new Intent(MainActivity_dethi.this, MainActivity_start.class);
                intent.putExtra("ma_de", String.valueOf(position+1));
                startActivity(intent);
                finish();
            }
        });
    }

}