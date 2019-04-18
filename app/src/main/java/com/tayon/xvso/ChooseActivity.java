package com.tayon.xvso;

import android.content.Intent;
import android.graphics.Color;
import android.graphics.Typeface;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class ChooseActivity extends AppCompatActivity {

    Button jbtnX, jbtnO;
    TextView jtxtChoose, jtxtNote;
    Intent intent;
    String level, vs, tmp;

    @Override
    public void onBackPressed() {
        finish();
        Intent menuIntent = new Intent(ChooseActivity.this, MenuActivity.class);
        startActivity(menuIntent);
    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_choose);

        Typeface KBZipaDeeDooDah = Typeface.createFromAsset(getAssets(),  "fonts/KBZipaDeeDooDah.ttf");
        Typeface CaviarDreamsBold = Typeface.createFromAsset(getAssets(),  "fonts/CaviarDreamsBold.ttf");

        jbtnX = findViewById(R.id.btnX);
        jbtnO = findViewById(R.id.btnO);
        jtxtChoose = findViewById(R.id.txtChoose);
        jtxtNote = findViewById(R.id.txtNote);

        jbtnX.setTypeface(KBZipaDeeDooDah);
        jbtnO.setTypeface(KBZipaDeeDooDah);
        jtxtChoose.setTypeface(CaviarDreamsBold);
        jtxtNote.setTypeface(CaviarDreamsBold);

        jbtnX.setTextColor(Color.parseColor("#ffff4444"));
        jbtnO.setTextColor(Color.parseColor("#32CD32"));

        intent = getIntent();
        level = intent.getStringExtra("level");

        jbtnX.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
            vs = "X";
            tmp = vs + level;
            finish();
            Intent playIntent = new Intent(ChooseActivity.this, PlayActivity.class);
            playIntent.putExtra("vs", tmp);
            startActivity(playIntent);

            }


        });

        jbtnO.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
            vs = "O";
            tmp = vs+level;
            finish();
            Intent playIntent = new Intent(ChooseActivity.this, PlayActivity.class);
            playIntent.putExtra("vs", tmp);
            startActivity(playIntent);
            }
        });
    }
}
