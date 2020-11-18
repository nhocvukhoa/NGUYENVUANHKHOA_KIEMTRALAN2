package com.example.list;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.widget.ImageView;
import android.widget.TextView;

public class Profile extends AppCompatActivity {
    ImageView idavata;
    TextView idten;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);

        idavata=(ImageView) findViewById(R.id.idavata);
        idten=(TextView) findViewById(R.id.idten);


        Intent intent = getIntent();
        int receivedAvata = intent.getIntExtra("avata",0);
        String receivedTen =  intent.getStringExtra("ten");


        idavata.setImageResource(receivedAvata);
        idten.setText(receivedTen);

        //hiện nút quay lại
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (item.getItemId() == android.R.id.home) {
            onBackPressed();
        }
        return super.onOptionsItemSelected(item);

    }
    @Override
    public void onBackPressed() {
        super.onBackPressed();
    }
}