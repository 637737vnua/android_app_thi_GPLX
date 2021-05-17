package androidvnua.vnua.thi_gplx_21;

import android.os.Bundle;
import android.widget.ListView;
import androidx.appcompat.app.AppCompatActivity;
import java.util.ArrayList;
import static androidvnua.vnua.thi_gplx_21.R.drawable.bienbao3;
import static androidvnua.vnua.thi_gplx_21.R.drawable.cam1;
import static androidvnua.vnua.thi_gplx_21.R.drawable.cam2;
import static androidvnua.vnua.thi_gplx_21.R.drawable.cam3;
import static androidvnua.vnua.thi_gplx_21.R.drawable.cam4;
import static androidvnua.vnua.thi_gplx_21.R.id;
import static androidvnua.vnua.thi_gplx_21.R.layout;

public class Traffic_list_1 extends AppCompatActivity {
    ListView listView1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(layout.activity_traffic_list1);
        listView1=findViewById(id.listView1);
        
        //Create data
        ArrayList<TrafficItem> arrayList= new ArrayList<>();

        arrayList.add(new TrafficItem(bienbao3, "Đường cấm", "Biển báo đường cấm tất cả các ..."));
        arrayList.add(new TrafficItem(cam2, "Cấm đi ngược chiều", "Biển báo cấm tấm cả các loại phương tiện ..."));
        arrayList.add(new TrafficItem(cam1, "Cấm oto", "Biển báo đường cấm oto 3 bánh..."));
        arrayList.add(new TrafficItem(cam3, "Cấm đi bộ", "Biển báo cấm người đi bộ đi qua..."));
        arrayList.add(new TrafficItem(cam4, "Cấm rẽ trái", "Biển báo cấm rẽ trái ..."));
        arrayList.add(new TrafficItem(cam2, "Cấm đi ngược chiều", "Biển báo cấm tấm cả các loại phương tiện ..."));


        //Make custom adapter
        TrafficAdapter trafficAdapter=new TrafficAdapter(this, layout.list_row,arrayList);
        listView1.setAdapter(trafficAdapter);

    }
}