package com.example.projekt_zaliczenie;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import java.util.ArrayList;
import java.util.Map;

public class MainActivity extends AppCompatActivity {

    //zawartość koszyka
    ArrayList<Map<String, Object>> data;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //odebranie zawartości koszyka
        data = (ArrayList) getIntent().getSerializableExtra("KOSZYK");
    }

    public void onClickSklep(View view) {
        //odesłasłanie do aktivity z produktami oraz przesłanie zawartości koszyka
        Intent intent = new Intent(getBaseContext(), MainActivity2.class);
        intent.putExtra("KOSZYK", data);
        startActivity(intent);
    }

    public void onClickPorada(View view) {
        //odesłasłanie do aktivity z poradami oraz przesłanie zawartości koszyka
        Intent intent = new Intent(getBaseContext(), MainActivity3.class);
        intent.putExtra("KOSZYK", data);
        startActivity(intent);
    }

    public void onClickKontakt(View view) {
        //odesłasłanie do aktivity z kontaktem oraz przesłanie zawartości koszyka
        Intent intent = new Intent(getBaseContext(), MainActivity4.class);
        intent.putExtra("KOSZYK", data);
        startActivity(intent);
    }
}