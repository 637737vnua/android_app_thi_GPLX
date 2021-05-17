package androidvnua.vnua.thi_gplx_21;


import android.os.Bundle;
import android.widget.ListView;
import androidx.appcompat.app.AppCompatActivity;
import java.util.ArrayList;


import static androidvnua.vnua.thi_gplx_21.R.drawable.danduong1;
import static androidvnua.vnua.thi_gplx_21.R.drawable.danduong2;
import static androidvnua.vnua.thi_gplx_21.R.drawable.danduong3;
import static androidvnua.vnua.thi_gplx_21.R.id;
import static androidvnua.vnua.thi_gplx_21.R.layout;


public class Traffic_list_2 extends AppCompatActivity {
    ListView listView2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(layout.activity_traffic_list2);
        listView2=findViewById(id.listView2);

        //Create data
        ArrayList<TrafficItem> arrayList= new ArrayList<>();

        arrayList.add(new TrafficItem(danduong1, "Biển báo ô tô đi thẳng", "Biển chỉ dẫn tất cả ô tô đi thẳng ..."));
        arrayList.add(new TrafficItem(danduong2, "Đường một chiều", "Chỉ cho phép tất cả phương tiện đi một chiều..."));
        arrayList.add(new TrafficItem(danduong3, "Khu vực quay xe", "Biển chỉ dẫn vị trí được phép quay lại..."));
        arrayList.add(new TrafficItem(danduong1, "Phía trước là ô tô", "Biển báo cấm tấm cả các loại phương tiện ..."));
        arrayList.add(new TrafficItem(danduong2, "Đường một chiều", "Chỉ cho phép tất cả phương tiện đi một chiều..."));
        arrayList.add(new TrafficItem(danduong3, "Khu vực quay xe", "Biển chỉ dẫn vị trí được phép quay lại..."));


        //Make custom adapter
        TrafficAdapter trafficAdapter=new TrafficAdapter(this, layout.list_row,arrayList);
        listView2.setAdapter(trafficAdapter);

    }
}