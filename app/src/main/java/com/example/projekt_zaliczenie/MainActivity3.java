package com.example.projekt_zaliczenie;

import androidx.appcompat.app.AppCompatActivity;

import android.animation.ObjectAnimator;
import android.os.Bundle;
import android.view.animation.Animation;
import android.view.animation.BounceInterpolator;
import android.view.animation.RotateAnimation;
import android.widget.ImageView;
import android.widget.TextView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import java.util.ArrayList;
import java.util.Map;

public class MainActivity3 extends AppCompatActivity {

    //zawartość koszyka
    ArrayList<Map<String, Object>> data;


    TextView TitleTV;
    TextView LetniTV;
    TextView ZimowyTV;
    TextView MenuLokTV;

    ImageView SunIV;
    ImageView SnowflakeIV;
    ImageView MenuIV;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main3);

        //odebranie zawartości koszyka
        data = (ArrayList) getIntent().getSerializableExtra("KOSZYK");
        //-----------------------------------------------------------------------
        TitleTV = (TextView) findViewById(R.id.TitleTV);
        ObjectAnimator titleAnim = ObjectAnimator.ofFloat(TitleTV, "alpha", 0.3f);
        titleAnim.setDuration(500);
        titleAnim.setRepeatCount(5);
        titleAnim.setRepeatMode(titleAnim.REVERSE);
        titleAnim.start();

        SunIV = (ImageView) findViewById(R.id.SunIV);
        ObjectAnimator summerAnim = ObjectAnimator.ofFloat (SunIV, "scaleY", 2);
        summerAnim.setDuration(1500);
       // summerAnim.setInterpolator(new BounceInterpolator());
        summerAnim.setRepeatCount(3);
        summerAnim.setRepeatMode(summerAnim.REVERSE);
        summerAnim.start();

        SnowflakeIV = (ImageView) findViewById(R.id.SnowflakeIV);
        ObjectAnimator winterAnim = ObjectAnimator.ofFloat (SnowflakeIV, "X", 150);
        summerAnim.setDuration(1500);
        // summerAnim.setInterpolator(new BounceInterpolator());
        winterAnim.setRepeatCount(5);
        winterAnim.setRepeatMode(summerAnim.REVERSE);
        winterAnim.start();

        MenuLokTV = (TextView) findViewById(R.id.MenuLokTV);
        ObjectAnimator MenuLokAnim = ObjectAnimator.ofFloat (MenuLokTV, "scaleX", 0.9f);
        MenuLokAnim.setDuration(2000);
       //  MenuLokAnim.setInterpolator(new BounceInterpolator());
        MenuLokAnim.setRepeatCount(3);
        MenuLokAnim.setRepeatMode(summerAnim.REVERSE);
        MenuLokAnim.start();

        ZimowyTV = (TextView) findViewById(R.id.ZimowyTV);
        ObjectAnimator ZimowyTVAnim = ObjectAnimator.ofFloat (ZimowyTV, "scaleY", 0.9f);
        ZimowyTVAnim.setDuration(500);
        ZimowyTVAnim.setInterpolator(new BounceInterpolator());
        ZimowyTVAnim.setRepeatCount(5);
        ZimowyTVAnim.setRepeatMode(summerAnim.REVERSE);
        ZimowyTVAnim.start();


        MenuIV = (ImageView) findViewById(R.id.MenuIV);
        RotateAnimation rotate = new RotateAnimation(180,360, Animation.RELATIVE_TO_SELF,0.5f, Animation.RELATIVE_TO_SELF,0.5f);//ObjectAnimator MenuIVAnim = ObjectAnimator.ofFloat (MenuIV, "", 150);
        rotate.setDuration(3000);
        // summerAnim.setInterpolator(new BounceInterpolator());
        rotate.setRepeatCount(1);
        rotate.setRepeatMode(summerAnim.REVERSE);
        rotate.start();
        MenuIV.startAnimation(rotate);
    }

    public void onBtnClick(View view) {
        //odesłasłanie do menu oraz przesłanie zawartości koszyka
        Intent intent = new Intent(getBaseContext(), MainActivity.class);
        intent.putExtra("KOSZYK", data);
        startActivity(intent);
    }
}