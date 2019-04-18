package com.tayon.xvso;

import android.content.Intent;
import android.graphics.Typeface;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class LevelActivity extends AppCompatActivity {

    Button jbtnBeat, jbtnN, jbtnUnbeat;
    TextView jtxtLevel;

    @Override
    public void onBackPressed() {
        finish();
        Intent menuIntent = new Intent(LevelActivity.this, MenuActivity.class);
        startActivity(menuIntent);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_level);

        Typeface CaviarDreamsBold = Typeface.createFromAsset(getAssets(),  "fonts/CaviarDreamsBold.ttf");

        jbtnBeat = findViewById(R.id.btnBeat);
        jbtnN = findViewById(R.id.btnNormal);
        jbtnUnbeat = findViewById(R.id.btnUnbeat);
        jtxtLevel = findViewById(R.id.txtLevel);

        jbtnBeat.setTypeface(CaviarDreamsBold);
        jbtnUnbeat.setTypeface(CaviarDreamsBold);
        jbtnN.setTypeface(CaviarDreamsBold);
        jtxtLevel.setTypeface(CaviarDreamsBold);

        jbtnBeat.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
                Intent chooseIntent = new Intent(LevelActivity.this, ChooseActivity.class);
                chooseIntent.putExtra("level", "beat");
                startActivity(chooseIntent);
            }
        });

        jbtnN.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
                Intent chooseIntent = new Intent(LevelActivity.this, ChooseActivity.class);
                chooseIntent.putExtra("level", "normal");
                startActivity(chooseIntent);
            }
        });


        jbtnUnbeat.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
                Intent chooseIntent = new Intent(LevelActivity.this, ChooseActivity.class);
                chooseIntent.putExtra("level", "unbeat");
                startActivity(chooseIntent);
            }
        });
    }
}
