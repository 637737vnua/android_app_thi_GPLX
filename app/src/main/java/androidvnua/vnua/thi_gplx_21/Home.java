package androidvnua.vnua.thi_gplx_21;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;

import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.drawerlayout.widget.DrawerLayout;

import com.google.android.material.navigation.NavigationView;

import java.lang.reflect.Field;

import androidvnua.vnua.database.dbCauHoi;
import androidvnua.vnua.mucdethi.MainActivity_dethi;

public class Home extends AppCompatActivity {

    private ImageView iconMenu;

    //  Khai báo button
    ConstraintLayout
            btnThiThu,
            btnCauDiemLiet,
            btnHocBienBao,
            btnCauSai,
            btnThiSaHinh,
            btnMeoThi;

    //Menu bar
    DrawerLayout drawerLayout;
    NavigationView navigationView;
    androidx.appcompat.widget.Toolbar toolbar;


    // Database
    private dbCauHoi db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        goibutton();

        // Menu
        renderMenu();

        // Database (Khởi tạo và tạo bảng)
        DataBaseCauHoi();

        // Insert (table)
        // InsertTableDB();
    }

    //  Ánh xạ button
    public void goibutton() {
        btnThiThu = (ConstraintLayout) findViewById(R.id.btnBatDauThi);
        btnCauDiemLiet = (ConstraintLayout) findViewById(R.id.btnCauDiemLiet);
        btnHocBienBao = (ConstraintLayout) findViewById(R.id.btnCacBienBao);
        btnCauSai = (ConstraintLayout) findViewById(R.id.btnCauSai);
        btnThiSaHinh = (ConstraintLayout) findViewById(R.id.btnThiSaHinh);
        btnMeoThi = (ConstraintLayout) findViewById(R.id.btnMeoThi);
    }

    //  Hàm sự kiện Click
    public void onClick(View v) {
        if (v == btnThiThu) {
            Intent intent = new Intent(Home.this, MainActivity_dethi.class);
            startActivity(intent);
        }else if (v == btnCauDiemLiet) {
            Toast.makeText(Home.this, "Phần câu diểm liệt", Toast.LENGTH_LONG).show();
        }else if (v == btnCauSai) {
            Toast.makeText(Home.this, "Phần câi trả lời sai", Toast.LENGTH_LONG).show();
        }else if (v == btnHocBienBao) {
            Intent intent = new Intent(Home.this, TrafficSign.class);
            startActivity(intent);
        }else if (v == btnThiSaHinh) {
            Toast.makeText(Home.this, "Phần thi sa hình", Toast.LENGTH_LONG).show();
        }else if (v == btnMeoThi) {
            Intent intent = new Intent(Home.this, Tutorial.class);
            startActivity(intent);
        }
    }

    // Hàm menu
    private void renderMenu() {
        drawerLayout = findViewById(R.id.drawer_layout);
        navigationView = findViewById(R.id.navc_view);
        toolbar = findViewById(R.id.toolbar);

        setSupportActionBar(toolbar);

        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(Home.this, drawerLayout, toolbar, R.string.Open, R.string.Close);
        drawerLayout.addDrawerListener(toggle);
        toggle.syncState();
    }

    // Khởi tạo, tạo tạo bảng database
    public void DataBaseCauHoi() {
        // Khoi tao database
        db = new dbCauHoi(this, "CauHoiDataBase.sqlite", null, 1);

        // Tao bang table book
        db.QueryData("CREATE TABLE IF NOT EXISTS CauHoi (" +
                "ID INTEGER PRIMARY KEY AUTOINCREMENT," +
                " CauHoi VARCHAR(200)," +
                " CauHoiA VARCHAR(200)," +
                " CauHoiB VARCHAR(200)," +
                " CauHoiC VARCHAR(200)," +
                " CauHoiD VARCHAR(200)," +
                " Image VARCHAR(100)," +
                " soDe INTEGER," +
                " DapAn VARCHAR(10))");
    }

    // Insert table vào database
    public void InsertTableDB() {
        // insert

        // câu 1:
        db.QueryData("INSERT INTO CauHoi" +
                " VALUES " +
                "(null," +
                " 'Người điều khiển phương tiện giao thông đường bộ mà trong cơ thể có chất ma túy có bị nghiêm cấm hay không?'," +
                " 'Bị nghiêm cấm'," +
                " 'Không bị nghiêm cấm'," +
                " 'Không bị nghiêm cấm, nếu có chất ma túy ở mức nhẹ, có thể điều khiển phương tiện tham gia giao thông'," +
                " null," +
                " null," +
                " 1," +
                " 'A')");

        // câu 2:
        db.QueryData("INSERT INTO CauHoi" +
                " VALUES " +
                "(null," +
                " 'Hành vi điều khiển xe cơ giới chạy quá tốc độ quy định, giành đường, vượt ẩu có bị nghiêm cấm hay không?'," +
                " 'Bị nghiêm cấm tùy từng trường hợp'," +
                " 'Không bị nghiêm cấm'," +
                " 'Bị nghiêm cấm'," +
                " null," +
                " null," +
                " 1," +
                " 'C')");

        // câu 3:
        db.QueryData("INSERT INTO CauHoi " +
                " VALUES " +
                "(null," +
                " 'Bạn đang lái xe phía trước có một xe cứu thương đang phát tín hiệu ưu tiên bạn có được phép vượt hay không?'," +
                " 'Không được vượt'," +
                " 'Được vượt khi đang đi trên cầu'," +
                " 'Được phép vượt khi đi qua nơi giao nhau có ít phương tiện cùng tham gia giao thông'," +
                " 'Được vượt khi đảm bảo an toàn'," +
                " null," +
                " 1," +
                " 'A')");

        // câu 4:
        db.QueryData("INSERT INTO CauHoi " +
                " VALUES " +
                "(null," +
                " 'Ở phần đường dành cho người đi bộ qua đường, trên cầu, đầu cầu, đường cao tốc, đường hẹp, đường dốc, tại nơi đường bộ giao nhau cùng mức với đường sắt có được quay đầu xe hay không?'," +
                " 'Được phép'," +
                " 'Không được phép'," +
                " 'Tùy từng trường hợp'," +
                " 'Không được phép'," +
                " null," +
                " 1," +
                " 'B')");

        // câu 5:
        db.QueryData("INSERT INTO CauHoi " +
                " VALUES " +
                "(null," +
                " 'Người điều khiển xe mô tô hai bánh, ba bánh, xe gắn máy có được phép sử dụng xe để kéo hoặc đẩy các phương tiện khác khi tham gia giao thông không?'," +
                " 'Được phép'," +
                " 'Nếu phương tiện được kéo, đẩy có khối lượng nhỏ hơn phương tiện của mình'," +
                " 'Tùy trường hợp'," +
                " null," +
                " null," +
                " 2," +
                " 'D')");

        // câu 6:
        db.QueryData("INSERT INTO CauHoi " +
                " VALUES " +
                "(null," +
                " 'Khi điều khiển xe mô tô hai bánh, xe mô tô ba bánh, xe gắn máy, những hành vi buông cả hai tay; sử dụng xe để kéo, đẩy xe khác, vật khác; sử dụng chân chống của xe quệt xuống đường khi xe đang chạy có được phép không?'," +
                " 'Được phép'," +
                " 'Tùy trường hợp'," +
                " 'Không được phép'," +
                " null," +
                " null," +
                " 2," +
                " 'C')");

        // câu 7:
        db.QueryData("INSERT INTO CauHoi " +
                " VALUES " +
                "(null," +
                " 'Người ngồi trên xe mô tô hai bánh, ba bánh, xe gắn máy khi tham gia giao thông có được mang, vác vật cồng kềnh hay không?'," +
                " 'Được mang, vác tùy trường hợp cụ thể'," +
                " 'Không được mang, vác'," +
                " 'Được mang, vác nhưng phải đảm bảo an toàn'," +
                " 'Được mang, vác tùy theo sức khỏe của bản thân'," +
                " null," +
                " 2," +
                " 'B')");

        // câu 8:
        db.QueryData("INSERT INTO CauHoi " +
                " VALUES " +
                "(null," +
                " 'Người ngồi trên xe mô tô hai bánh, xe mô tô ba bánh, xe gắn máy khi tham gia giao thông có được bám, kéo hoặc đẩy các phương thiện khác không?'," +
                " 'Được phép'," +
                " 'Được bám trong trường hợp phương tiện của mình bị hỏng'," +
                " 'Được kéo, đẩy trong trường hợp phương tiện khác bị hỏng'," +
                " 'Không được phép'," +
                " null," +
                " 1," +
                " 'D')");

        // câu 9:
        db.QueryData("INSERT INTO CauHoi " +
                " VALUES " +
                "(null," +
                " 'Gặp biển nào người tham gia giao thông phải đi chậm và thận trọng đề phòng khả năng xuất hiện và di chuyển bất ngờ của trẻ em trên mặt đường?'," +
                " 'Biển 1'," +
                " 'Biển 2'," +
                " null," +
                " null," +
                " 'imagech'," +
                " 2," +
                " 'A')");

        // câu 10:
        db.QueryData("INSERT INTO CauHoi " +
                " VALUES " +
                "(null," +
                " 'Người điều khiển phương tiện giao thông đường bộ mà trong cơ thể có chất ma túy có bị nghiêm cấm hay không?'," +
                " 'Bị nghiêm cấm'," +
                " 'Không bị nghiêm cấm'," +
                " 'Không bị nghiêm cấm, nếu có chất ma túy ở mức nhẹ, có thể điều khiển phương tiện tham gia giao thông.'," +
                " null," +
                " null," +
                " 1," +
                " 'A')");
    }

    // Get string Image vd: int resID = getResId(img, R.drawable.class);
    public static int getResId(String resName, Class<?> c) {
        try {
            Log.e("", "thành công");
            Field idField = c.getDeclaredField(resName);
            return idField.getInt(idField);
        } catch (Exception e) {
            e.printStackTrace();
            return -1;
        }
    }
}