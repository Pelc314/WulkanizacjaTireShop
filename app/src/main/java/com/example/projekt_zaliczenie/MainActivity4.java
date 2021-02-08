package com.example.projekt_zaliczenie;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;

import java.util.ArrayList;
import java.util.Map;

public class MainActivity4 extends AppCompatActivity {

    //zawartość koszyka
    ArrayList<Map<String, Object>> data;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main4);

        //odebranie zawartości koszyka
        data = (ArrayList) getIntent().getSerializableExtra("KOSZYK");



    }

    public void onBtnClick(View view) {
        //odesłasłanie do menu oraz przesłanie zawartości koszyka
        Intent intent = new Intent(getBaseContext(), MainActivity.class);
        intent.putExtra("KOSZYK", data);
        startActivity(intent);
    }

    public void onBtnMapClick(View view) {
        Intent intent;
        intent = new Intent();
        intent.setAction(Intent.ACTION_VIEW);
        intent.setData(Uri.parse("geo:51.090481,17.024856?q= Uniwersytet Ekonomiczny, Wrocław"));
        startActivity(intent);
    }

    public void onBtnCallClick(View view) {
        Intent intent;
        intent = new Intent(Intent.ACTION_DIAL);
        intent.setData(Uri.parse("tel:2222222"));
        startActivity(intent);
    }
}