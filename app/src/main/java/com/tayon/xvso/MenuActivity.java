package com.tayon.xvso;

import android.content.Intent;
import android.graphics.Typeface;
import android.os.Bundle;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class MenuActivity extends AppCompatActivity {

    Button jbtnP, jbtnA;
    TextView jtxtTitleX, jtxtTitleO, jtxtTitlevs;
    boolean doubleBackToExitPressedOnce = false;

    @Override
    public void onBackPressed() {
        if (doubleBackToExitPressedOnce) {
            super.onBackPressed();
            finish();
        }

        this.doubleBackToExitPressedOnce = true;
        Toast.makeText(this, "Press BACK again to exit", Toast.LENGTH_SHORT).show();

        new Handler().postDelayed(new Runnable() {

            @Override
            public void run() {
                doubleBackToExitPressedOnce=false;
            }
        }, 2000);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);

        Typeface CaviarDreamsBold = Typeface.createFromAsset(getAssets(),  "fonts/CaviarDreamsBold.ttf");
        Typeface KBZipaDeeDooDah = Typeface.createFromAsset(getAssets(),  "fonts/KBZipaDeeDooDah.ttf");

        jbtnP = findViewById(R.id.btnVsPlayer);
        jbtnA = findViewById(R.id.btnVsAndroid);
        jtxtTitleX = findViewById(R.id.txtTitleX);
        jtxtTitleO = findViewById(R.id.txtTitleO);
        jtxtTitlevs = findViewById(R.id.txtTitlevs);

        jbtnP.setTypeface(CaviarDreamsBold);
        jbtnA.setTypeface(CaviarDreamsBold);
        jtxtTitleX.setTypeface(KBZipaDeeDooDah);
        jtxtTitleO.setTypeface(KBZipaDeeDooDah);
        jtxtTitlevs.setTypeface(CaviarDreamsBold);

        jbtnA.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
                Intent levelIntent = new Intent(MenuActivity.this, LevelActivity.class);
                startActivity(levelIntent);
            }
        });

        jbtnP.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
                Intent playIntent = new Intent(MenuActivity.this, PlayActivity.class);
                playIntent.putExtra("vs", "player");
                startActivity(playIntent);
            }
        });
    }
}
