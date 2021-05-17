package androidvnua.vnua.thi_gplx_21;


import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;


public class TrafficSign extends AppCompatActivity {

    ListView listView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_traffic_sign);
        listView=findViewById(R.id.listView);

        //Create data
        ArrayList<TrafficItem> arrayList= new ArrayList<>();

        arrayList.add(new TrafficItem(R.drawable.bienbao3, "Biển báo cấm", "Biển báo cấm là đường tròn màu đỏ,.."));
        arrayList.add(new TrafficItem(R.drawable.bienbao5, "Biển chỉ dẫn", "Biển chỉ dẫn là biển hình vuông và ... "));
        arrayList.add(new TrafficItem(R.drawable.bienbao2, "Biển báo nguy hiểm", "Biển báo có dạng tam giác đều, viền đỏ.."));
        arrayList.add(new TrafficItem(R.drawable.bienbao3, "Biển báo cấm", "Biển báo có dạng hình vuông hoặc hình chữ nhật,.."));
        arrayList.add(new TrafficItem(R.drawable.bienbao2, "Biển hiệu lệnh", "Biển báo cấm là đường tròn màu đỏ"));


        //Make custom adapter
        TrafficAdapter trafficAdapter=new TrafficAdapter(this,R.layout.list_row,arrayList);
        listView.setAdapter(trafficAdapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                if (position==0){
                    Intent intent=new Intent(TrafficSign.this, Traffic_list_1.class);
                    startActivity(intent);
                }
                if (position==1){
                    Intent intent=new Intent(TrafficSign.this, Traffic_list_2.class);
                    startActivity(intent);
                }
                if (position==2){
                    Toast.makeText(TrafficSign.this, "Biển báo nguy hiểm", Toast.LENGTH_LONG).show();
                }
                if (position==3){
                    Toast.makeText(TrafficSign.this, "Biển báo cấm", Toast.LENGTH_LONG).show();
                }
                if (position==4){
                    Toast.makeText(TrafficSign.this, "Biển hiệu lệnh", Toast.LENGTH_LONG).show();
                }


            }
        });

    }

}