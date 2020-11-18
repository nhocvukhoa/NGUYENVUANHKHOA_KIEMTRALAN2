package com.example.list;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.view.menu.MenuView;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.ListView;
import android.widget.RelativeLayout;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    //Lấy trong cú pháp chia list
    ListView listview;
    Context context;
    //Lấy trong đường bao bọc khung của list_profile
    RelativeLayout listviewdata;

    ArrayList<ProfileModel> profileData;
    ProfileAdapter profileAdapter;
    ProfileModel profileModel;

    @SuppressLint("WrongViewCast")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        context = this;
        setContentView(R.layout.activity_main);

        //getviews
        listview = findViewById(R.id.listview);
        listviewdata = (RelativeLayout) findViewById(R.id.listviewdata);
        profileData = new ArrayList<>();

        //add Countries Data
        populateProductData();
        listview.setOnItemLongClickListener(new ItemLongClickRemove());
        profileAdapter = new ProfileAdapter(context,profileData);
        listview.setAdapter(profileAdapter);
        registerForContextMenu(listview);
        listview = findViewById(R.id.listview);
        listview.setOnItemLongClickListener(new ItemLongClickRemove());


        listview.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long l) {
                Toast.makeText(context,profileData.get(position).getTen(), Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(getApplicationContext(),Profile.class);
                intent.putExtra("avata",profileData.get(position).getAvata());
                intent.putExtra("ten",profileData.get(position).getTen());
                startActivity(intent);
            }
        });

    }
    private void populateProductData() {
        //product1
        profileModel = new ProfileModel();
        profileModel.setId(1);
        profileModel.setAvata(R.drawable.vinmart);
        profileModel.setTen("Vinmart");
        profileModel.setMota("Chuỗi sưu thị uy tín. Sản phẩm đa dạng, vận chuyển siêu tốc");
        profileModel.setTick(R.drawable.tick);
        profileModel.setPhantram("Tích 3%");
        profileData.add(profileModel);

        profileModel = new ProfileModel();
        profileModel.setId(2);
        profileModel.setAvata(R.drawable.meji);
        profileModel.setTen("Meiji");
        profileModel.setMota("Nhã hiệu sữa bán chạy số 1 Nhật Bản");
        profileModel.setTick(R.drawable.tick);
        profileModel.setPhantram("Tích 10%");
        profileData.add(profileModel);

        profileModel = new ProfileModel();
        profileModel.setId(3);
        profileModel.setAvata(R.drawable.bactom);
        profileModel.setTen("Bác Tôm");
        profileModel.setMota("Thực phẩm sạch, đặc sản vùng miền");
        profileModel.setTick(R.drawable.tick);
        profileModel.setPhantram("Tích 5%");
        profileData.add(profileModel);

        profileModel = new ProfileModel();
        profileModel.setId(4);
        profileModel.setAvata(R.drawable.f5);
        profileModel.setTen("F5 Fruit");
        profileModel.setMota("Nhà bán lẻ trái cây nhập khẩu uy tín");
        profileModel.setTick(R.drawable.tick);
        profileModel.setPhantram("Tích 5%");
        profileData.add(profileModel);

        profileModel = new ProfileModel();
        profileModel.setId(5);
        profileModel.setAvata(R.drawable.dungha);
        profileModel.setTen("Nông sản Dũng Hà");
        profileModel.setMota("Bring nature to your home");
        profileModel.setTick(R.drawable.tick);
        profileModel.setPhantram("Tích 5%");
        profileData.add(profileModel);

        profileModel = new ProfileModel();
        profileModel.setId(6);
        profileModel.setAvata(R.drawable.quochuy);
        profileModel.setTen("Thực phẩm Quốc Huy");
        profileModel.setMota("Gạo ngon cho mọi gia đình");
        profileModel.setTick(R.drawable.tick);
        profileModel.setPhantram("Tích 5%");
        profileData.add(profileModel);

        profileModel = new ProfileModel();
        profileModel.setId(7);
        profileModel.setAvata(R.drawable.hoangdong);
        profileModel.setTen("Hoàng Đông Food");
        profileModel.setMota("Nhà phân phối bán lẻ thực phẩm sạch");
        profileModel.setTick(R.drawable.tick);
        profileModel.setPhantram("Tích 5%");
        profileData.add(profileModel);


    }
    private class ItemLongClickRemove implements AdapterView.OnItemLongClickListener {
        @Override
        public boolean onItemLongClick(AdapterView parent, View view, final int position, long id) {
            AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(MainActivity.this);
            alertDialogBuilder.setMessage("Bạn có muốn xóa sản phẩm này?");
            alertDialogBuilder.setPositiveButton("Có", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which) {
                    // xóa sp đang nhấn giữ
                    profileData.remove(position);
                    //cập nhật lại gridview
                    profileAdapter.notifyDataSetChanged();
                }
            });
            alertDialogBuilder.setNegativeButton("Không", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which) {
                }
            });
            alertDialogBuilder.show();
            return true;
        }
    }
}