package androidvnua.vnua.thi_gplx_21;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;


public class TrafficSign extends AppCompatActivity {
    ListView listView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_traffic_sign);
        listView=findViewById(R.id.listView);

        int[] image = { R.drawable.bienbao1,R.drawable.bienbao2,R.drawable.bienbao3,R.drawable.bienbao4,R.drawable.bienbao5,
                R.drawable.bienbao6,R.drawable.bienbao7,R.drawable.bienbao8, R.drawable.bienbao9,R.drawable.bienbao10,
                R.drawable.bienbao11,R.drawable.bienbao12,R.drawable.bienbao13,R.drawable.bienbao14,R.drawable.bienbao15,
                R.drawable.bienbao16,R.drawable.bienbao17,R.drawable.bienbao18,R.drawable.bienbao19,R.drawable.bienbao20,
                R.drawable.bienbao41,R.drawable.bienbao42,R.drawable.bienbao57,R.drawable.bienbao44,R.drawable.bienbao45,
                R.drawable.bienbao46,R.drawable.bienbao47,R.drawable.bienbao48,R.drawable.bienbao49,R.drawable.bienbao51,
                R.drawable.bienbao52,R.drawable.bienbao53,R.drawable.bienbao54,R.drawable.bienbao55,R.drawable.bienbao56};

        String[] name = {"Đường cấm","Cấm đi ngược chiều","Cấm oto","Cấm oto rẽ phải","Cấm oto rẽ trái",
                "Cấm moto","Cấm oto và moto","Cấm oto tải","Cấm oto tải theo trọng lượng","Cấm oto tải trờ hàng nguy hiểm",
                "Câm oto khách và oto tải","Cấm oto khách","Cấm xe taxi","Cấm xe sơ mi rơ mooc","Cấm oto kéo rơ mooc",
                "Cấm máy kéo","Cấm xe đạp","Cấm xe gắn máy","Cấm xe điện","Cấm xe máy thồ",
                "Cấm oto rẽ phải và quay xe","Cấm vượt","Cấm oto tải vượt","Tốc độ tối đa cho phép","Cấm bóp còi",
                "Kiểm tra","Cấm dừng và đỗ xe","Cấm đỗ xe","Cấm đỗ xe ngày lễ","Cấm đi thẳng",
                "Các xe chỉ được rẽ phải","Các xe chỉ được rẽ trái","Các xe chỉ được rẽ phải","Các xe chỉ được rẽ trái","Các xe chỉ được rẽ trái và phải"};

        String[] des = {"Biển báo đường cấm tất cả các loại phương tiện tham gia giao thông đi lại cả hai hướng","Biển báo đường cấm tất cả các loại phương tiện tham gia giao thông đi ngược chiều","Biển báo đường cấm tất cả các loại oto","Biển báo đường cấm tất cả các loại oto rẽ phải","Biển báo đường cấm tất cả các loại oto rẽ trái","Biển cấm tất cả các xe máy thồ đi qua",
                "Biển báo đường cấm tất cả các loại moto đi qua, trừ các loại moto được ưu tiên theo luật giao thông đường bộ","Biển báo đường cấm tất cả các loại xe cơ giới đi qua, trừ các loại moto được ưu tiên theo luật giao thông đường bộ","Biển báo đường cấm tất cả các loại otot tải đi qua, trừ các loại moto được ưu tiên theo luật giao thông đường bộ","Trọng lượng được tính theo tấn ghi trên biển","Cấm tất cả cá loại xe oto trở hàng nguy hiểm",
                "Biển báo đường cấm tất cả oto khách va oto tải đi qua","Biển báo đường cấm tất cả oto khách, không cấm xe bus","Biển báo đường cấm tất oto taxi","Biển báo đường cấm tất cả xe sơ mi rơ mooc trừ các xe được ưu tiên","Biển báo đường cấm tất cả cacs loại xe cơ giới theo rơ mooc kể cả moto,máy kéo...",
                "Biển báo đường cấm tất cả các loại máy kéo, kể cả máy kéo bánh hơi và bánh xích đi qua","Biển báo đường cấm tất cả xe đạp đi qua, dắt xe thì được","Biển báo đường cấm tất cả các xe dienjd đi qua, trừ các xe được ưu tiên","Biển cấm tất cả các xe máy thồ đi qua",
                "Biển báo cấm tất cả oto rẽ phải đồng thời cấm quay đầu phải, trừ các loại xe được ưu tiên","Biển báo cấm tất cả các loại xe cơ giới vượt nhau, kể cả các xe được ưu tiên","Biển có hiệu lực cấm tất cả các loại oto tải co khối lượng chuyên chở lớn hơn 3500kg vượt xe khác","Biển có hiệu lực cấm tất cả các loại xe cơ giới vượt quá tốc độ ghi trên biển","Biển báo cấm tất cả các loại xe cơ giới sử dụng còi",
                "Biển báo nơi đặt trạm kiểm tra, các loại phương tiện vận tải qua đó phải dừng lại đê làm thủ tục kiểm tra, kiểm soát theo quy định","Biển có hiệu lực cấm tất cả các loại xe cơ giới đường bộ dừng và đỗ xe","Biển có hiệu lực cấm tất cả các loại xe cơ giới đường bộ đỗ xe","Biển có hiệu lực cấm tất cả các loại xe cơ giới đường bộ đỗ xe ngày lẽ","Biển có hiệu lực cấm tất cả các loại xe đi thẳng",
                "Được đặt sau ngã ba, ngã tư. Các xe chỉ được rẽ phải ở khu vực trước mặt","Được đặt sau ngã ba, ngã tư. Các xe chỉ được rẽ trái ở khu vực trước mặt","Được đặt sau ngã ba, ngã tư. Các xe chỉ được rẽ phải ở phạm vi ngã ba, ngã tư đằng sau mặt biển","Được đặt sau ngã ba, ngã tư. Các xe chỉ được rẽ trái ở phạm vi ngã ba, ngã tư đằng sau mặt biển","Được đặt sau ngã ba, ngã tư. Các xe chỉ được rẽ trái, quay đầu hoặc rẽ phải ở phạm vi ngã ba, ngã tư đằng sau mặt biển"};


        ArrayList<Traffic> TrafficArrayList = new ArrayList<>();

        for(int i = 0;i< image.length;i++){

            Traffic traffic = new Traffic(name[i],des[i],image[i]);
            TrafficArrayList.add(traffic);

        }

        Adapter adapter=new Adapter(this, R.layout.list_row,TrafficArrayList);
        listView.setAdapter(adapter);
        listView.setClickable(true);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                Intent i = new Intent(TrafficSign.this,TrafficInfor.class);
                i.putExtra("name",name[position]);
                i.putExtra("des",des[position]);
                i.putExtra("image",image[position]);
                startActivity(i);

            }
        });

    }
}