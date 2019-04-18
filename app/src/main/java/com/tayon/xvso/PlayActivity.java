package com.tayon.xvso;

import android.content.Intent;
import android.graphics.Color;
import android.graphics.Typeface;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Random;

public class PlayActivity extends AppCompatActivity {

    int ran, turn = 1, min = 1, max = 9;
    Button jbtn1, jbtn2, jbtn3, jbtn4, jbtn5, jbtn6, jbtn7, jbtn8, jbtn9, jbtnNew;
    TextView jtxtScoreX, jtxtScoreO, jtxtScoreDraw, jtxtSX, jtxtSO, jtxtDraw;
    String move = "", win, vs, b1,b2,b3,b4,b5,b6,b7,b8,b9;
    Boolean box1, box2, box3, box4, box5, box6, box7, box8, box9;
    Intent intent;
    Random r;
    boolean doubleBackToExitPressedOnce = false;

    @Override
    public void onBackPressed() {

        if (doubleBackToExitPressedOnce) {
            super.onBackPressed();
            finish();
            Intent menuIntent = new Intent(PlayActivity.this, MenuActivity.class);
            startActivity(menuIntent);
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

    //On create activity
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_play);

        Typeface KBZipaDeeDooDah = Typeface.createFromAsset(getAssets(),  "fonts/KBZipaDeeDooDah.ttf");
        Typeface CaviarDreamsBold = Typeface.createFromAsset(getAssets(),  "fonts/CaviarDreamsBold.ttf");

        intent = getIntent();
        vs = intent.getStringExtra("vs");
        jbtn1 = findViewById(R.id.btn1);
        jbtn2 = findViewById(R.id.btn2);
        jbtn3 = findViewById(R.id.btn3);
        jbtn4 = findViewById(R.id.btn4);
        jbtn5 = findViewById(R.id.btn5);
        jbtn6 = findViewById(R.id.btn6);
        jbtn7 = findViewById(R.id.btn7);
        jbtn8 = findViewById(R.id.btn8);
        jbtn9 = findViewById(R.id.btn9);
        jbtn1.setTypeface(KBZipaDeeDooDah);
        jbtn2.setTypeface(KBZipaDeeDooDah);
        jbtn3.setTypeface(KBZipaDeeDooDah);
        jbtn4.setTypeface(KBZipaDeeDooDah);
        jbtn5.setTypeface(KBZipaDeeDooDah);
        jbtn6.setTypeface(KBZipaDeeDooDah);
        jbtn7.setTypeface(KBZipaDeeDooDah);
        jbtn8.setTypeface(KBZipaDeeDooDah);
        jbtn9.setTypeface(KBZipaDeeDooDah);

        jbtnNew = findViewById(R.id.btnNew);
        jbtnNew.setTypeface(CaviarDreamsBold);

        jtxtScoreX = findViewById(R.id.txtScoreX);
        jtxtScoreO = findViewById(R.id.txtScoreO);
        jtxtScoreDraw = findViewById(R.id.txtScoreDraw);
        jtxtSX = findViewById(R.id.txtSX);
        jtxtSO = findViewById(R.id.txtSO);
        jtxtDraw = findViewById(R.id.txtDraw);

        jtxtScoreX.setTypeface(CaviarDreamsBold);
        jtxtScoreO.setTypeface(CaviarDreamsBold);
        jtxtScoreDraw.setTypeface(CaviarDreamsBold);
        jtxtSX.setTypeface(CaviarDreamsBold);
        jtxtSO.setTypeface(CaviarDreamsBold);
        jtxtDraw.setTypeface(CaviarDreamsBold);

        jbtn1.setEnabled(false);
        jbtn2.setEnabled(false);
        jbtn3.setEnabled(false);
        jbtn4.setEnabled(false);
        jbtn5.setEnabled(false);
        jbtn6.setEnabled(false);
        jbtn7.setEnabled(false);
        jbtn8.setEnabled(false);
        jbtn9.setEnabled(false);
        box1 = true;
        box2 = true;
        box3 = true;
        box4 = true;
        box5 = true;
        box6 = true;
        box7 = true;
        box8 = true;
        box9 = true;

        //If player press button
        jbtn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(jbtn1.getText().toString().equals(""))
                {
                    press1();
                }
            }
        });
        jbtn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(jbtn2.getText().toString().equals(""))
                {
                    press2();
                }
            }
        });
        jbtn3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(jbtn3.getText().toString().equals(""))
                {
                    press3();
                }
            }
        });
        jbtn4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(jbtn4.getText().toString().equals(""))
                {
                    press4();
                }
            }
        });
        jbtn5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(jbtn5.getText().toString().equals(""))
                {
                    press5();
                }
            }
        });
        jbtn6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(jbtn6.getText().toString().equals(""))
                {
                    press6();
                }
            }
        });
        jbtn7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(jbtn7.getText().toString().equals(""))
                {
                    press7();
                }
            }
        });
        jbtn8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(jbtn8.getText().toString().equals(""))
                {
                    press8();
                }
            }
        });
        jbtn9.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(jbtn9.getText().toString().equals(""))
                {
                    press9();
                }
            }
        });

        //If player press new game button
        jbtnNew.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                jbtn1.setEnabled(true);
                jbtn2.setEnabled(true);
                jbtn3.setEnabled(true);
                jbtn4.setEnabled(true);
                jbtn5.setEnabled(true);
                jbtn6.setEnabled(true);
                jbtn7.setEnabled(true);
                jbtn8.setEnabled(true);
                jbtn9.setEnabled(true);
                jbtnNew.setEnabled(false);
                jbtn1.setText("");
                jbtn2.setText("");
                jbtn3.setText("");
                jbtn4.setText("");
                jbtn5.setText("");
                jbtn6.setText("");
                jbtn7.setText("");
                jbtn8.setText("");
                jbtn9.setText("");
                box1 = true;
                box2 = true;
                box3 = true;
                box4 = true;
                box5 = true;
                box6 = true;
                box7 = true;
                box8 = true;
                box9 = true;
                move = "";

                if(vs.equals("Ounbeat") || vs.equals("Xunbeat"))
                    turn = 1;

                changeTurn();

                //If player play against android
                if(vs != "player") {
                    androidTurn();
                }
            }
        });
    }//End of create activity code


    //Start functions
    //Button press functions
    public void press1() {

        if(turn == 1) {
            turn = 2;
            jbtn1.setTextColor(Color.parseColor("#ffff4444"));
            jbtn1.setText("X");
        }
        else if(turn == 2) {
            turn = 1;
            jbtn1.setTextColor(Color.parseColor("#32CD32"));
            jbtn1.setText("O");
        }
        box1 = false;
        changeTurn();
        checkEnd();
    }
    public void press2() {

        if(turn == 1) {
            turn = 2;
            jbtn2.setTextColor(Color.parseColor("#ffff4444"));
            jbtn2.setText("X");
        }
        else if(turn == 2) {
            turn = 1;
            jbtn2.setTextColor(Color.parseColor("#32CD32"));
            jbtn2.setText("O");
        }
        box2 = false;
        changeTurn();
        checkEnd();
    }
    public void press3() {

        if(turn == 1) {
            turn = 2;
            jbtn3.setTextColor(Color.parseColor("#ffff4444"));
            jbtn3.setText("X");
        }
        else if(turn == 2) {
            turn = 1;
            jbtn3.setTextColor(Color.parseColor("#32CD32"));
            jbtn3.setText("O");
        }
        box3 = false;
        changeTurn();
        checkEnd();
    }
    public void press4() {

        if(turn == 1) {
            turn = 2;
            jbtn4.setTextColor(Color.parseColor("#ffff4444"));
            jbtn4.setText("X");
        }
        else if(turn == 2) {
            turn = 1;
            jbtn4.setTextColor(Color.parseColor("#32CD32"));
            jbtn4.setText("O");
        }
        box4 = false;
        changeTurn();
        checkEnd();
    }
    public void press5() {

        if(turn == 1) {
            turn = 2;
            jbtn5.setTextColor(Color.parseColor("#ffff4444"));
            jbtn5.setText("X");
        }
        else if(turn == 2) {
            turn = 1;
            jbtn5.setTextColor(Color.parseColor("#32CD32"));
            jbtn5.setText("O");
        }
        box5 = false;
        changeTurn();
        checkEnd();
    }
    public void press6() {

        if(turn == 1) {
            turn = 2;
            jbtn6.setTextColor(Color.parseColor("#ffff4444"));
            jbtn6.setText("X");
        }
        else if(turn == 2) {
            turn = 1;
            jbtn6.setTextColor(Color.parseColor("#32CD32"));
            jbtn6.setText("O");
        }
        box6 = false;
        changeTurn();
        checkEnd();
    }
    public void press7() {

        if(turn == 1) {
            turn = 2;
            jbtn7.setTextColor(Color.parseColor("#ffff4444"));
            jbtn7.setText("X");
        }
        else if(turn == 2) {
            turn = 1;
            jbtn7.setTextColor(Color.parseColor("#32CD32"));
            jbtn7.setText("O");
        }
        box7 = false;
        changeTurn();
        checkEnd();
    }
    public void press8() {

        if(turn == 1) {
            turn = 2;
            jbtn8.setTextColor(Color.parseColor("#ffff4444"));
            jbtn8.setText("X");
        }
        else if(turn == 2) {
            turn = 1;
            jbtn8.setTextColor(Color.parseColor("#32CD32"));
            jbtn8.setText("O");
        }
        box8 = false;
        changeTurn();
        checkEnd();
    }
    public void press9() {

        if(turn == 1) {
            turn = 2;
            jbtn9.setTextColor(Color.parseColor("#ffff4444"));
            jbtn9.setText("X");
        }
        else if(turn == 2) {
            turn = 1;
            jbtn9.setTextColor(Color.parseColor("#32CD32"));
            jbtn9.setText("O");
        }
        box9 = false;
        changeTurn();
        checkEnd();
    }


    //To display current turn
    public void changeTurn() {
        if(turn == 1) {
            jbtnNew.setText("X's Turn");
        }
        else if(turn == 2) {
            jbtnNew.setText("O's Turn");
        }
    }


    //To check game is end or not
    public void checkEnd() {

        b1 = jbtn1.getText().toString();
        b2 = jbtn2.getText().toString();
        b3 = jbtn3.getText().toString();
        b4 = jbtn4.getText().toString();
        b5 = jbtn5.getText().toString();
        b6 = jbtn6.getText().toString();
        b7 = jbtn7.getText().toString();
        b8 = jbtn8.getText().toString();
        b9 = jbtn9.getText().toString();

        //Winning probability of X
        if(b1.equals(b2) && b1.equals(b3) && b1.equals("X")) {
            Toast.makeText(PlayActivity.this, "Winner is X!", Toast.LENGTH_SHORT).show();
            blinkBox1(); blinkBox2(); blinkBox3();
            win = "X";
            endGame();
        }
        else if(b4.equals(b5) && b4.equals(b6) && b4.equals("X")) {
            Toast.makeText(PlayActivity.this, "Winner is X!", Toast.LENGTH_SHORT).show();
            blinkBox4(); blinkBox5(); blinkBox6();
            win = "X";
            endGame();
        }
        else if(b7.equals(b8) && b7.equals(b9) && b7.equals("X")) {
            Toast.makeText(PlayActivity.this, "Winner is X!", Toast.LENGTH_SHORT).show();
            blinkBox7(); blinkBox8(); blinkBox9();
            win = "X";
            endGame();
        }
        else if(b1.equals(b4) && b1.equals(b7) && b1.equals("X")) {
            Toast.makeText(PlayActivity.this, "Winner is X!", Toast.LENGTH_SHORT).show();
            blinkBox1(); blinkBox4(); blinkBox7();
            win = "X";
            endGame();
        }
        else if(b2.equals(b5) && b2.equals(b8) && b2.equals("X")) {
            Toast.makeText(PlayActivity.this, "Winner is X!", Toast.LENGTH_SHORT).show();
            blinkBox2(); blinkBox5(); blinkBox8();
            win = "X";
            endGame();
        }
        else if(b3.equals(b6) && b3.equals(b9) && b3.equals("X")) {
            Toast.makeText(PlayActivity.this, "Winner is X!", Toast.LENGTH_SHORT).show();
            blinkBox3(); blinkBox6(); blinkBox9();
            win = "X";
            endGame();
        }
        else if(b1.equals(b5) && b1.equals(b9) && b1.equals("X")) {
            Toast.makeText(PlayActivity.this, "Winner is X!", Toast.LENGTH_SHORT).show();
            blinkBox1(); blinkBox5(); blinkBox9();
            win = "X";
            endGame();
        }
        else if(b3.equals(b5) && b3.equals(b7) && b3.equals("X")) {
            Toast.makeText(PlayActivity.this, "Winner is X!", Toast.LENGTH_SHORT).show();
            blinkBox3(); blinkBox5(); blinkBox7();
            win = "X";
            endGame();
        }

        //Winning probability of O
        else if(b1.equals(b2) && b1.equals(b3) && b1.equals("O")) {
            Toast.makeText(PlayActivity.this, "Winner is O!", Toast.LENGTH_SHORT).show();
            blinkBox1(); blinkBox2(); blinkBox3();
            win = "O";
            endGame();
        }
        else if(b4.equals(b5) && b4.equals(b6) && b4.equals("O")) {
            Toast.makeText(PlayActivity.this, "Winner is O!", Toast.LENGTH_SHORT).show();
            blinkBox4(); blinkBox5(); blinkBox6();
            win = "O";
            endGame();
        }
        else if(b7.equals(b8) && b7.equals(b9) && b7.equals("O")) {
            Toast.makeText(PlayActivity.this, "Winner is O!", Toast.LENGTH_SHORT).show();
            blinkBox7(); blinkBox8(); blinkBox9();
            win = "O";
            endGame();
        }
        else if(b1.equals(b4) && b1.equals(b7) && b1.equals("O")) {
            Toast.makeText(PlayActivity.this, "Winner is O!", Toast.LENGTH_SHORT).show();
            blinkBox1(); blinkBox4(); blinkBox7();
            win = "O";
            endGame();
        }
        else if(b2.equals(b5) && b2.equals(b8) && b2.equals("O")) {
            Toast.makeText(PlayActivity.this, "Winner is O!", Toast.LENGTH_SHORT).show();
            blinkBox2(); blinkBox5(); blinkBox8();
            win = "O";
            endGame();
        }
        else if(b3.equals(b6) && b3.equals(b9) && b3.equals("O")) {
            Toast.makeText(PlayActivity.this, "Winner is O!", Toast.LENGTH_SHORT).show();
            blinkBox3(); blinkBox6(); blinkBox9();
            win = "O";
            endGame();
        }
        else if(b1.equals(b5) && b1.equals(b9) && b1.equals("O")) {
            Toast.makeText(PlayActivity.this, "Winner is O!", Toast.LENGTH_SHORT).show();
            blinkBox1(); blinkBox5(); blinkBox9();
            win = "O";
            endGame();
        }
        else if(b3.equals(b5) && b3.equals(b7) && b3.equals("O")) {
            Toast.makeText(PlayActivity.this, "Winner is O!", Toast.LENGTH_SHORT).show();
            blinkBox3(); blinkBox5(); blinkBox7();
            win = "O";
            endGame();
        }

        //If game is draw
        else if(!b1.equals("") && !b2.equals("") && !b3.equals("") && !b4.equals("") && !b5.equals("") && !b6.equals("") && !b7.equals("") && !b8.equals("") && !b9.equals("")) {
            Toast.makeText(PlayActivity.this, "Looks like game is draw!", Toast.LENGTH_SHORT).show();
            win = "Draw";
            endGame();
        }

        else if(!vs.equals("player")) {
            androidTurn();
        }
    }


    //If game is over
    public void endGame() {

        jbtn1.setEnabled(false);
        jbtn2.setEnabled(false);
        jbtn3.setEnabled(false);
        jbtn4.setEnabled(false);
        jbtn5.setEnabled(false);
        jbtn6.setEnabled(false);
        jbtn7.setEnabled(false);
        jbtn8.setEnabled(false);
        jbtn9.setEnabled(false);
        jbtnNew.setEnabled(true);
        jbtnNew.setText("New Game");
        scorePlus();
    }


    //Add score
    public void scorePlus() {

        switch (win) {
            case "X": {
                String tmpScore = jtxtScoreX.getText().toString();
                int score = Integer.parseInt(tmpScore);
                score++;
                jtxtScoreX.setText(String.valueOf(score));
                if (!vs.equals("Ounbeat") && !vs.equals("Xunbeat"))
                    turn = 1;
                break;
            }
            case "O": {
                String tmpScore = jtxtScoreO.getText().toString();
                int score = Integer.parseInt(tmpScore);
                score++;
                jtxtScoreO.setText(String.valueOf(score));
                if (!vs.equals("Ounbeat") && !vs.equals("Xunbeat"))
                    turn = 2;
                break;
            }
            case "Draw": {
                String tmpScore = jtxtScoreDraw.getText().toString();
                int score = Integer.parseInt(tmpScore);
                score++;
                jtxtScoreDraw.setText(String.valueOf(score));

                break;
            }
        }
    }


    //Android turn
    public void androidTurn() {

        if(!vs.equals("player")) {

            //If player select O in easy
            if(vs.equals("Obeat") && turn == 1) {
                randomFire();
            }
            //If player select X in easy
            else if(vs.equals("Xbeat") && turn == 2) {
                randomFire();
            }

            //if player select O in normal
            else if(vs.equals("Onormal") && turn == 1) {

                if(box1 && box2 && box3 && box4 && box5 && box6 && box7 && box8 && box9 == true) {
                    randomFire();
                } else {
                    checkStrikeO();
                }
            }

            //if player select X in normal
            else if(vs.equals("Xnormal") && turn == 2) {
                checkStrikeX();
            }

            //If Player select O in expert
            else if(vs.equals("Ounbeat") && turn==1) {
                oUnbeatable();
            }

            //if player select X in expert
            else if(vs.equals("Xunbeat") && turn == 2) {
                xUnbeatable();
            }
        }
    }


    //For random android move
    public void randomFire() {

        r = new Random();
        ran = r.nextInt(max - min + 1) + min;

        if (ran==1) {
            if (box1){
                press1();
            } else {
                androidTurn();
            }
        } else if (ran==2) {
            if (box2){
                press2();
            } else {
                androidTurn();
            }
        } else if (ran==3) {
            if (box3){
                press3();
            } else {
                androidTurn();
            }
        } else if (ran==4) {
            if (box4){
                press4();
            } else {
                androidTurn();
            }
        } else if (ran==5) {
            if (box5){
                press5();
            } else {
                androidTurn();
            }
        } else if (ran==6) {
            if (box6){
                press6();
            } else {
                androidTurn();
            }
        } else if (ran==7) {
            if (box7){
                press7();
            } else {
                androidTurn();
            }
        } else if (ran==8) {
            if (box8){
                press8();
            } else {
                androidTurn();
            }
        } else if (ran==9) {
            if (box9){
                press9();
            } else {
                androidTurn();
            }
        }
    }


    //To check strike is possible or not if player select O
    public void checkStrikeO() {

        //Attack
        if (b1.equals("X") && b2.equals("X") && b3.equals("")) {
            press3();
        } else if (b3.equals("X") && b2.equals("X") && b1.equals("")) {
            press1();
        } else if (b1.equals("X") && b4.equals("X") && b7.equals("")) {
            press7();
        } else if (b7.equals("X") && b4.equals("X") && b1.equals("")) {
            press1();
        } else if (b3.equals("X") && b6.equals("X") && b9.equals("")) {
            press9();
        } else if (b9.equals("X") && b6.equals("X") && b3.equals("")) {
            press3();
        } else if (b7.equals("X") && b8.equals("X") && b9.equals("")) {
            press9();
        } else if (b9.equals("X") && b8.equals("X") && b7.equals("")) {
            press7();
        } else if (b1.equals("X") && b3.equals("X") && b2.equals("")) {
            press2();
        } else if (b3.equals("X") && b9.equals("X") && b6.equals("")) {
            press6();
        } else if (b7.equals("X") && b9.equals("X") && b8.equals("")) {
            press8();
        } else if (b1.equals("X") && b7.equals("X") && b4.equals("")) {
            press4();
        } else if (b2.equals("X") && b5.equals("X") && b8.equals("")) {
            press8();
        } else if (b4.equals("X") && b5.equals("X") && b6.equals("")) {
            press6();
        } else if (b6.equals("X") && b5.equals("X") && b4.equals("")) {
            press4();
        } else if (b8.equals("X") && b5.equals("X") && b2.equals("")) {
            press2();
        } else if (b1.equals("X") && b5.equals("X") && b9.equals("")) {
            press9();
        } else if (b3.equals("X") && b5.equals("X") && b7.equals("")) {
            press7();
        } else if (b9.equals("X") && b5.equals("X") && b1.equals("")) {
            press1();
        } else if (b7.equals("X") && b5.equals("X") && b3.equals("")) {
            press3();
        } else if (b1.equals("X") && b9.equals("X") && b5.equals("")) {
            press5();
        } else if (b3.equals("X") && b7.equals("X") && b5.equals("")) {
            press5();
        } else if (b2.equals("X") && b8.equals("X") && b5.equals("")) {
            press5();
        } else if (b4.equals("X") && b6.equals("X") && b5.equals("")) {
            press5();
        }

        //Defense
        else if (b1.equals("O") && b2.equals("O") && b3.equals("")) {
            press3();
        } else if (b3.equals("O") && b2.equals("O") && b1.equals("")) {
            press1();
        } else if (b1.equals("O") && b4.equals("O") && b7.equals("")) {
            press7();
        } else if (b7.equals("O") && b4.equals("O") && b1.equals("")) {
            press1();
        } else if (b3.equals("O") && b6.equals("O") && b9.equals("")) {
            press9();
        } else if (b9.equals("O") && b6.equals("O") && b3.equals("")) {
            press3();
        } else if (b7.equals("O") && b8.equals("O") && b9.equals("")) {
            press9();
        } else if (b9.equals("O") && b8.equals("O") && b7.equals("")) {
            press7();
        } else if (b1.equals("O") && b3.equals("O") && b2.equals("")) {
            press2();
        } else if (b3.equals("O") && b9.equals("O") && b6.equals("")) {
            press6();
        } else if (b7.equals("O") && b9.equals("O") && b8.equals("")) {
            press8();
        } else if (b1.equals("O") && b7.equals("O") && b4.equals("")) {
            press4();
        } else if (b2.equals("O") && b5.equals("O") && b8.equals("")) {
            press8();
        } else if (b4.equals("O") && b5.equals("O") && b6.equals("")) {
            press6();
        } else if (b6.equals("O") && b5.equals("O") && b4.equals("")) {
            press4();
        } else if (b8.equals("O") && b5.equals("O") && b2.equals("")) {
            press2();
        } else if (b1.equals("O") && b5.equals("O") && b9.equals("")) {
            press9();
        } else if (b3.equals("O") && b5.equals("O") && b7.equals("")) {
            press7();
        } else if (b9.equals("O") && b5.equals("O") && b1.equals("")) {
            press1();
        } else if (b7.equals("O") && b5.equals("O") && b3.equals("")) {
            press3();
        } else if (b1.equals("O") && b9.equals("O") && b5.equals("")) {
            press5();
        } else if (b3.equals("O") && b7.equals("O") && b5.equals("")) {
            press5();
        } else if (b2.equals("O") && b8.equals("O") && b5.equals("")) {
            press5();
        } else if (b4.equals("O") && b6.equals("O") && b5.equals("")) {
            press5();
        } else {
            randomFire();
        }
    }

    //To check strike is possible or not if player select X
    public void checkStrikeX() {

        //Attack
        if (b1.equals("O") && b2.equals("O") && b3.equals("")) {
            press3();
        } else if (b3.equals("O") && b2.equals("O") && b1.equals("")) {
            press1();
        } else if (b1.equals("O") && b4.equals("O") && b7.equals("")) {
            press7();
        } else if (b7.equals("O") && b4.equals("O") && b1.equals("")) {
            press1();
        } else if (b3.equals("O") && b6.equals("O") && b9.equals("")) {
            press9();
        } else if (b9.equals("O") && b6.equals("O") && b3.equals("")) {
            press3();
        } else if (b7.equals("O") && b8.equals("O") && b9.equals("")) {
            press9();
        } else if (b9.equals("O") && b8.equals("O") && b7.equals("")) {
            press7();
        } else if (b1.equals("O") && b3.equals("O") && b2.equals("")) {
            press2();
        } else if (b3.equals("O") && b9.equals("O") && b6.equals("")) {
            press6();
        } else if (b7.equals("O") && b9.equals("O") && b8.equals("")) {
            press8();
        } else if (b1.equals("O") && b7.equals("O") && b4.equals("")) {
            press4();
        } else if (b2.equals("O") && b5.equals("O") && b8.equals("")) {
            press8();
        } else if (b4.equals("O") && b5.equals("O") && b6.equals("")) {
            press6();
        } else if (b6.equals("O") && b5.equals("O") && b4.equals("")) {
            press4();
        } else if (b8.equals("O") && b5.equals("O") && b2.equals("")) {
            press2();
        } else if (b1.equals("O") && b5.equals("O") && b9.equals("")) {
            press9();
        } else if (b3.equals("O") && b5.equals("O") && b7.equals("")) {
            press7();
        } else if (b9.equals("O") && b5.equals("O") && b1.equals("")) {
            press1();
        } else if (b7.equals("O") && b5.equals("O") && b3.equals("")) {
            press3();
        } else if (b1.equals("O") && b9.equals("O") && b5.equals("")) {
            press5();
        } else if (b3.equals("O") && b7.equals("O") && b5.equals("")) {
            press5();
        } else if (b2.equals("O") && b8.equals("O") && b5.equals("")) {
            press5();
        } else if (b4.equals("O") && b6.equals("O") && b5.equals("")) {
            press5();
        }

        //Defense
        else if (b1.equals("X") && b2.equals("X") && b3.equals("")) {
            press3();
        } else if (b3.equals("X") && b2.equals("X") && b1.equals("")) {
            press1();
        } else if (b1.equals("X") && b4.equals("X") && b7.equals("")) {
            press7();
        } else if (b7.equals("X") && b4.equals("X") && b1.equals("")) {
            press1();
        } else if (b3.equals("X") && b6.equals("X") && b9.equals("")) {
            press9();
        } else if (b9.equals("X") && b6.equals("X") && b3.equals("")) {
            press3();
        } else if (b7.equals("X") && b8.equals("X") && b9.equals("")) {
            press9();
        } else if (b9.equals("X") && b8.equals("X") && b7.equals("")) {
            press7();
        } else if (b1.equals("X") && b3.equals("X") && b2.equals("")) {
            press2();
        } else if (b3.equals("X") && b9.equals("X") && b6.equals("")) {
            press6();
        } else if (b7.equals("X") && b9.equals("X") && b8.equals("")) {
            press8();
        } else if (b1.equals("X") && b7.equals("X") && b4.equals("")) {
            press4();
        } else if (b2.equals("X") && b5.equals("X") && b8.equals("")) {
            press8();
        } else if (b4.equals("X") && b5.equals("X") && b6.equals("")) {
            press6();
        } else if (b6.equals("X") && b5.equals("X") && b4.equals("")) {
            press4();
        } else if (b8.equals("X") && b5.equals("X") && b2.equals("")) {
            press2();
        } else if (b1.equals("X") && b5.equals("X") && b9.equals("")) {
            press9();
        } else if (b3.equals("X") && b5.equals("X") && b7.equals("")) {
            press7();
        } else if (b9.equals("X") && b5.equals("X") && b1.equals("")) {
            press1();
        } else if (b7.equals("X") && b5.equals("X") && b3.equals("")) {
            press3();
        } else if (b1.equals("X") && b9.equals("X") && b5.equals("")) {
            press5();
        } else if (b3.equals("X") && b7.equals("X") && b5.equals("")) {
            press5();
        } else if (b2.equals("X") && b8.equals("X") && b5.equals("")) {
            press5();
        } else if (b4.equals("X") && b6.equals("X") && b5.equals("")) {
            press5();
        } else {
            randomFire();
        }
    }


    //Play unbeatable move if player select O
    public void oUnbeatable() {

        //1st move of android
        switch (move) {
            case "":

                r = new Random();
                ran = r.nextInt(max - min + 1) + min;
                if (ran == 1) {
                    move = "Corner";
                    press1();
                } else if (ran == 3) {
                    move = "Corner";
                    press3();
                } else if (ran == 5) {
                    move = "Center";
                    press5();
                } else if (ran == 7) {
                    move = "Corner";
                    press7();
                } else if (ran == 9) {
                    move = "Corner";
                    press9();
                } else {
                    androidTurn();
                }
                break;


            //If android's 1st move is center
            case "Center":

                //If opponent's 1st move is edge (Android's 1st move is center)
                if (b2.equals("O") || b4.equals("O") || b6.equals("O") || b8.equals("O")) {

                    if (!box2) {

                        r = new Random();
                        ran = r.nextInt(max - min + 1) + min;

                        if (ran == 7) {
                            move = "CenterEdge1";
                            press7();
                        } else if (ran == 9) {
                            move = "CenterEdge1";
                            press9();
                        } else {
                            androidTurn();
                        }
                    } else if (!box4) {

                        r = new Random();
                        ran = r.nextInt(max - min + 1) + min;

                        if (ran == 3) {
                            move = "CenterEdge1";
                            press3();
                        } else if (ran == 9) {
                            move = "CenterEdge1";
                            press9();
                        } else {
                            androidTurn();
                        }
                    } else if (!box6) {

                        r = new Random();
                        ran = r.nextInt(max - min + 1) + min;

                        if (ran == 1) {
                            move = "CenterEdge1";
                            press1();
                        } else if (ran == 7) {
                            move = "CenterEdge1";
                            press7();
                        } else {
                            androidTurn();
                        }
                    } else if (!box8) {

                        r = new Random();
                        ran = r.nextInt(max - min + 1) + min;

                        if (ran == 1) {
                            move = "CenterEdge1";
                            press1();
                        } else if (ran == 3) {
                            move = "CenterEdge1";
                            press3();
                        } else {
                            androidTurn();
                        }
                    }
                }

                //If opponent's 1st move is corner (Android's 1st move is center)
                else if (b1.equals("O") || b3.equals("O") || b7.equals("O") || b9.equals("O")) {

                    if (!box1) {
                        move = "CenterCorner1";
                        press9();
                    } else if (!box3) {
                        move = "CenterCorner1";
                        press7();
                    } else if (!box7) {
                        move = "CenterCorner1";
                        press3();
                    } else if (!box9) {
                        move = "CenterCorner1";
                        press1();
                    }
                }
                break;

            //Beginning of opponent's 1st edge move code (Android's 1st move is center)
            //If opponent's 1st move is edge (Android's 1st move is center)
            case "CenterEdge1":

                checkStrikeO();

                if (turn == 1) {

                    if (b7.equals("X") && b3.equals("O") && b2.equals("O")) {
                        move = "CenterEdge2";
                        press1();
                    } else if (b9.equals("X") && b1.equals("O") && b2.equals("O")) {
                        move = "CenterEdge2";
                        press3();
                    } else if (b3.equals("X") && b7.equals("O") && b4.equals("O")) {
                        move = "CenterEdge2";
                        press1();
                    } else if (b9.equals("X") && b1.equals("O") && b4.equals("O")) {
                        move = "CenterEdge2";
                        press7();
                    } else if (b1.equals("X") && b9.equals("O") && b6.equals("O")) {
                        move = "CenterEdge2";
                        press3();
                    } else if (b7.equals("X") && b3.equals("O") && b6.equals("O")) {
                        move = "CenterEdge2";
                        press9();
                    } else if (b1.equals("X") && b9.equals("O") && b8.equals("O")) {
                        move = "CenterEdge2";
                        press7();
                    } else if (b3.equals("X") && b7.equals("O") && b8.equals("O")) {
                        move = "CenterEdge2";
                        press9();
                    }
                }
                break;

            //If opponent's 1st move is edge (Android's 1st move is center and Opponent's 2st move is defence)
            case "CenterEdge2":
                checkStrikeO();
                break;


            //Beginning of opponent's 1st corner move code (Android's 1st move is center)
            //If opponent's 1st move is corner (Android's 1st move is center)
            case "CenterCorner1":

                //If opponent's 2nd move is side by 1st (Android's 1st move is center)
                if (b2.equals("O") || b4.equals("O") || b6.equals("O") || b8.equals("O")) {

                    if (b7.equals("X") && b3.equals("O") && b2.equals("O")) {
                        move = "CenterCorner2";
                        press1();
                    } else if (b9.equals("X") && b1.equals("O") && b2.equals("O")) {
                        move = "CenterCorner2";
                        press3();
                    } else if (b3.equals("X") && b7.equals("O") && b4.equals("O")) {
                        move = "CenterCorner2";
                        press1();
                    } else if (b9.equals("X") && b1.equals("O") && b4.equals("O")) {
                        move = "CenterCorner2";
                        press7();
                    } else if (b1.equals("X") && b9.equals("O") && b6.equals("O")) {
                        move = "CenterCorner2";
                        press3();
                    } else if (b7.equals("X") && b3.equals("O") && b6.equals("O")) {
                        move = "CenterCorner2";
                        press9();
                    } else if (b1.equals("X") && b9.equals("O") && b8.equals("O")) {
                        move = "CenterCorner2";
                        press7();
                    } else if (b3.equals("X") && b7.equals("O") && b8.equals("O")) {
                        move = "CenterCorner2";
                        press9();
                    }

                    //If opponent's 2nd move is opposite side of 1st (Android's 1st move is center)
                    else if (b3.equals("X") && b7.equals("O") && b2.equals("O")) {
                        move = "CenterCorner2";
                        press9();
                    } else if (b3.equals("X") && b7.equals("O") && b6.equals("O")) {
                        move = "CenterCorner2";
                        press1();
                    } else if (b7.equals("X") && b3.equals("O") && b8.equals("O")) {
                        move = "CenterCorner2";
                        press1();
                    } else if (b7.equals("X") && b3.equals("O") && b4.equals("O")) {
                        move = "CenterCorner2";
                        press9();
                    } else if (b1.equals("X") && b9.equals("O") && b2.equals("O")) {
                        move = "CenterCorner2";
                        press7();
                    } else if (b1.equals("X") && b9.equals("O") && b4.equals("O")) {
                        move = "CenterCorner2";
                        press3();
                    } else if (b9.equals("X") && b1.equals("O") && b6.equals("O")) {
                        move = "CenterCorner2";
                        press7();
                    } else if (b9.equals("X") && b1.equals("O") && b8.equals("O")) {
                        move = "CenterCorner2";
                        press3();
                    }
                }

                //If opposite's 2nd move is corner (Android's 1st move is center)
                else if (b1.equals("O") || b3.equals("O") || b7.equals("O") || b9.equals("O")) {

                    if (b1.equals("O") && b3.equals("O")) {
                        move = "CenterCorner3";
                        press2();
                    } else if (b3.equals("O") && b9.equals("O")) {
                        move = "CenterCorner3";
                        press6();
                    } else if (b9.equals("O") && b7.equals("O")) {
                        move = "CenterCorner3";
                        press8();
                    } else if (b7.equals("O") && b1.equals("O")) {
                        move = "CenterCorner3";
                        press4();
                    }
                }
                break;

            //If opposite's 2nd move is not corner (Android's 1st move is center)
            case "CenterCorner2":
                checkStrikeO();
                break;

            //If opposite's 2nd move is corner (Android's 1st move is center)
            case "CenterCorner3":

                checkStrikeO();

                if (turn == 1) {

                    if (box2) {
                        press2();
                    } else if (box4) {
                        press4();
                    } else if (box6) {
                        press6();
                    } else if (box8) {
                        press8();
                    } else {
                        randomFire();
                    }
                }
                break;
            //End of android's 1st center move code


            //Beginning of android 1st corner move code
            //If 1st move of android is corner
            case "Corner":

                //If opponent's 1st move is edge (Android 1st move is corner)
                if (b2.equals("O") || b4.equals("O") || b6.equals("O") || b8.equals("O")) {

                    //If opponent's 1st move is edge side by android's (Android's 1st move is corner)
                    if (b1.equals("X") && b2.equals("O")) {
                        move = "CornerEdge1";
                        press7();
                    } else if (b1.equals("X") && b4.equals("O")) {
                        move = "CornerEdge1";
                        press3();
                    } else if (b3.equals("X") && b2.equals("O")) {
                        move = "CornerEdge1";
                        press9();
                    } else if (b3.equals("X") && b6.equals("O")) {
                        move = "CornerEdge1";
                        press1();
                    } else if (b9.equals("X") && b6.equals("O")) {
                        move = "CornerEdge1";
                        press7();
                    } else if (b9.equals("X") && b8.equals("O")) {
                        move = "CornerEdge1";
                        press3();
                    } else if (b7.equals("X") && b8.equals("O")) {
                        move = "CornerEdge1";
                        press1();
                    } else if (b7.equals("X") && b4.equals("O")) {
                        move = "CornerEdge1";
                        press9();
                    }

                    //If opponent's 1st move is opposite edge of android's (Android's 1st move is corner)
                    else if (b1.equals("X") && b6.equals("O")) {
                        move = "CornerEdge1";
                        press3();
                    } else if (b1.equals("X") && b8.equals("O")) {
                        move = "CornerEdge1";
                        press7();
                    } else if (b3.equals("X") && b4.equals("O")) {
                        move = "CornerEdge1";
                        press1();
                    } else if (b3.equals("X") && b8.equals("O")) {
                        move = "CornerEdge1";
                        press9();
                    } else if (b9.equals("X") && b4.equals("O")) {
                        move = "CornerEdge1";
                        press7();
                    } else if (b9.equals("X") && b2.equals("O")) {
                        move = "CornerEdge1";
                        press3();
                    } else if (b7.equals("X") && b2.equals("O")) {
                        move = "CornerEdge1";
                        press1();
                    } else if (b7.equals("X") && b6.equals("O")) {
                        move = "CornerEdge1";
                        press9();
                    }
                }

                //If opponent's 1st move is corner (Android 1st move is corner)
                else if (b1.equals("O") || b3.equals("O") || b7.equals("O") || b9.equals("O")) {

                    //If opponent's 1st move is opposite corner of android's 1st (Android 1st move is corner)
                    if (b1.equals("X") && b9.equals("O")) {

                        r = new Random();
                        ran = r.nextInt(max - min + 1) + min;

                        if (ran == 3) {
                            move = "CornerCorner1";
                            press3();
                        } else if (ran == 7) {
                            move = "CornerCorner1";
                            press7();
                        } else {
                            androidTurn();
                        }
                    } else if (b3.equals("X") && b7.equals("O")) {

                        r = new Random();
                        ran = r.nextInt(max - min + 1) + min;

                        if (ran == 1) {
                            move = "CornerCorner1";
                            press1();
                        } else if (ran == 9) {
                            move = "CornerCorner1";
                            press9();
                        } else {
                            androidTurn();
                        }
                    } else if (b7.equals("X") && b3.equals("O")) {

                        r = new Random();
                        ran = r.nextInt(max - min + 1) + min;

                        if (ran == 1) {
                            move = "CornerCorner1";
                            press1();
                        } else if (ran == 9) {
                            move = "CornerCorner1";
                            press9();
                        } else {
                            androidTurn();
                        }
                    } else if (b9.equals("X") && b1.equals("O")) {

                        r = new Random();
                        ran = r.nextInt(max - min + 1) + min;

                        if (ran == 3) {
                            move = "CornerCorner1";
                            press3();
                        } else if (ran == 7) {
                            move = "CornerCorner1";
                            press7();
                        } else {
                            androidTurn();
                        }
                    }

                    //If opponent's 1st move is corner side by android's 1st (Android 1st move is corner)
                    else if (b1.equals("X") && b3.equals("O")) {
                        move = "CornerCorner1";
                        press7();
                    } else if (b1.equals("X") && b7.equals("O")) {
                        move = "CornerCorner1";
                        press3();
                    } else if (b3.equals("X") && b1.equals("O")) {
                        move = "CornerCorner1";
                        press9();
                    } else if (b3.equals("X") && b9.equals("O")) {
                        move = "CornerCorner1";
                        press1();
                    } else if (b9.equals("X") && b7.equals("O")) {
                        move = "CornerCorner1";
                        press3();
                    } else if (b9.equals("X") && b3.equals("O")) {
                        move = "CornerCorner1";
                        press7();
                    } else if (b7.equals("X") && b1.equals("O")) {
                        move = "CornerCorner1";
                        press9();
                    } else if (b7.equals("X") && b9.equals("O")) {
                        move = "CornerCorner1";
                        press1();
                    }
                }

                //If opponent's 1st move is center (Android 1st move is corner)
                else if (b5.equals("O")) {

                    if (b1.equals("X")) {
                        move = "CornerCenter1";
                        press9();
                    } else if (b3.equals("X")) {
                        move = "CornerCenter1";
                        press7();
                    } else if (b7.equals("X")) {
                        move = "CornerCenter1";
                        press3();
                    } else if (b9.equals("X")) {
                        move = "CornerCenter1";
                        press1();
                    }
                }
                break;

            //Beginning of opponent's 1st edge move code (Android's 1st move is corner)
            //If opponent's 1st move is edge (Android's 1st move is corner)
            case "CornerEdge1":

                checkStrikeO();

                if (turn == 1) {

                    if (b1.equals("X") && b7.equals("X") && b4.equals("O") && b2.equals("O")) {
                        move = "CornerEdge2";
                        press9();
                    } else if (b1.equals("X") && b3.equals("X") && b4.equals("O") && b2.equals("O")) {
                        move = "CornerEdge2";
                        press9();
                    } else if (b3.equals("X") && b9.equals("X") && b2.equals("O") && b6.equals("O")) {
                        move = "CornerEdge2";
                        press7();
                    } else if (b3.equals("X") && b1.equals("X") && b2.equals("O") && b6.equals("O")) {
                        move = "CornerEdge2";
                        press7();
                    } else if (b9.equals("X") && b3.equals("X") && b6.equals("O") && b8.equals("O")) {
                        move = "CornerEdge2";
                        press1();
                    } else if (b9.equals("X") && b7.equals("X") && b6.equals("O") && b8.equals("O")) {
                        move = "CornerEdge2";
                        press1();
                    } else if (b7.equals("X") && b9.equals("X") && b4.equals("O") && b8.equals("O")) {
                        move = "CornerEdge2";
                        press3();
                    } else if (b7.equals("X") && b1.equals("X") && b4.equals("O") && b8.equals("O")) {
                        move = "CornerEdge2";
                        press3();
                    }
                }
                break;
            case "CornerEdge2":
                checkStrikeO();
                break;


            //Beginning of opponent's 1st edge move code (Android's 1st move is corner)
            //If opponent's 1st move is corner (Android's 1st move is corner)
            case "CornerCorner1":

                checkStrikeO();

                if (turn == 1) {

                    if (b1.equals("X") && b3.equals("O")) {
                        move = "CornerCorner2";
                        press9();
                    } else if (b1.equals("X") && b7.equals("O")) {
                        move = "CornerCorner2";
                        press9();
                    } else if (b3.equals("X") && b9.equals("O")) {
                        move = "CornerCorner2";
                        press7();
                    } else if (b3.equals("X") && b1.equals("O")) {
                        move = "CornerCorner2";
                        press7();
                    } else if (b7.equals("X") && b1.equals("O")) {
                        move = "CornerCorner2";
                        press3();
                    } else if (b7.equals("X") && b9.equals("O")) {
                        move = "CornerCorner2";
                        press3();
                    } else if (b9.equals("X") && b7.equals("O")) {
                        move = "CornerCorner2";
                        press1();
                    } else if (b9.equals("X") && b3.equals("O")) {
                        move = "CornerCorner2";
                        press1();
                    }
                }
                break;
            case "CornerCorner2":
                checkStrikeO();
                break;


            //Beginning of opponent's 1st center move code (Android's 1st move is corner)
            //If opponent's 1st move is center (Android's 1st move is corner)
            case "CornerCenter1":

                if (b1.equals("O")) {
                    move = "CornerCenter2";
                    press9();
                } else if (b3.equals("O")) {
                    move = "CornerCenter2";
                    press7();
                } else if (b7.equals("O")) {
                    move = "CornerCenter2";
                    press3();
                } else if (b9.equals("O")) {
                    move = "CornerCenter2";
                    press1();
                } else if (b2.equals("O")) {
                    move = "CornerCenter2";
                    press8();
                } else if (b4.equals("O")) {
                    move = "CornerCenter2";
                    press6();
                } else if (b8.equals("O")) {
                    move = "CornerCenter2";
                    press2();
                } else if (b6.equals("O")) {
                    move = "CornerCenter2";
                    press4();
                }
                break;

            //If opponent's 1st move is center (Android's 1st move is corner)
            case "CornerCenter2":

                checkStrikeO();

                if (turn == 1) {

                    if (b1.equals("O") && b9.equals("")) {
                        move = "CornerCenter3";
                        press9();
                    } else if (b3.equals("O") && b7.equals("")) {
                        move = "CornerCenter3";
                        press7();
                    } else if (b7.equals("O") && b3.equals("")) {
                        move = "CornerCenter3";
                        press3();
                    } else if (b9.equals("O") && b1.equals("")) {
                        move = "CornerCenter3";
                        press1();
                    }
                }
                break;

            //If opponent's 1st move is center (Android's 1st move is corner)
            case "CornerCenter3":
                checkStrikeO();
                randomFire();
                break;
        }
        //End of android 1st corner move code
    }//End of unbeatable move if player select O code



    //Play unbeatable move if player select X
    public void xUnbeatable() {

        //If opponent play 1st move
        if(move.equals("")) {

            //If opponent's 1st move is center
            //Beginning of opponent's 1st center move code
            if(b5.equals("X")) {

                r = new Random();
                ran = r.nextInt(max - min + 1) + min;
                if (ran == 1) {
                    move = "XCenterCorner";
                    press1();
                }
                else if (ran == 3) {
                    move = "XCenterCorner";
                    press3();
                }
                else if (ran == 7) {
                    move = "XCenterCorner";
                    press7();
                }
                else if (ran == 9) {
                    move = "XCenterCorner";
                    press9();
                }
                else {
                    androidTurn();
                }
            }

            //If opponent's 1st move is corner
            //Beginning of opponent's 1st corner move code
            else if(b1.equals("X") || b3.equals("X") || b7.equals("X") || b9.equals("X")) {

                move = "XCornerCenter";
                press5();
            }

            //If opponent's 1st move is edge
            //Beginning of opponent's 1st edge move code
            else if(b2.equals("X") || b4.equals("X") || b6.equals("X") || b8.equals("X")) {

                if(b2.equals("X")) {
                    move = "XEdgeEdge";
                    press8();
                }
                else if(b4.equals("X")) {
                    move = "XEdgeEdge";
                    press6();
                }
                else if(b6.equals("X")) {
                    move = "XEdgeEdge";
                    press4();
                }
                else if(b8.equals("X")) {
                    move = "XEdgeEdge";
                    press2();
                }
            }
        }


        //If opponent's 1st move is center
        //Beginning of opponent's 1st center move code
        else if(move.equals("XCenterCorner")) {

            //If opponent's 2nd move is opposite corner of android's (Opposite's 1st move is center)
            if (b1.equals("X") && b9.equals("O")) {

                r = new Random();
                ran = r.nextInt(max - min + 1) + min;

                if (ran == 3) {
                    move = "XCenterCorner2";
                    press3();
                } else if (ran == 7) {
                    move = "XCenterCorner2";
                    press7();
                } else {
                    androidTurn();
                }
            }
            else if (b3.equals("X") && b7.equals("O")) {

                r = new Random();
                ran = r.nextInt(max - min + 1) + min;

                if (ran == 1) {
                    move = "XCenterCorner2";
                    press1();
                } else if (ran == 9) {
                    move = "XCenterCorner2";
                    press9();
                } else {
                    androidTurn();
                }
            }
            else if (b7.equals("X") && b3.equals("O")) {

                r = new Random();
                ran = r.nextInt(max - min + 1) + min;

                if (ran == 1) {
                    move = "XCenterCorner2";
                    press1();
                } else if (ran == 9) {
                    move = "XCenterCorner2";
                    press9();
                } else {
                    androidTurn();
                }
            }
            else if (b9.equals("X") && b1.equals("O")) {

                r = new Random();
                ran = r.nextInt(max - min + 1) + min;

                if (ran == 3) {
                    move = "XCenterCorner2";
                    press3();
                } else if (ran == 7) {
                    move = "XCenterCorner2";
                    press7();
                } else {
                    androidTurn();
                }
            }

            //If opponent's 2nd move is side corner of android's (Opposite's 1st move is center)
            else if (b1.equals("O") && b3.equals("X") || b7.equals("X")) {
                move = "XCenterCorner2";
                checkStrikeX();
            }
            else if (b3.equals("O") && b1.equals("X") || b9.equals("X")) {
                move = "XCenterCorner2";
                checkStrikeX();
            }
            else if (b7.equals("O") && b1.equals("X") || b9.equals("X")) {
                move = "XCenterCorner2";
                checkStrikeX();
            }
            else if (b9.equals("O") && b3.equals("X") || b7.equals("X")) {
                move = "XCenterCorner2";
                checkStrikeX();
            }

            //If opponent's 2nd move is edge (Opposite's 1st move is center)
            else if(b2.equals("X") || b4.equals("X") || b6.equals("X") || b8.equals("X")) {
                move = "XCenterCorner2";
                checkStrikeX();
            }
        }

        //Beginning of opponent's 2nd corner move code (Opponent's 1st move is center)
        //If opponent's 2nd move is corner (Opposite's 1st move is center)
        else if(move.equals("XCenterCorner2")) {

            checkStrikeX();

            if(turn == 2) {
                randomFire();
            }
        }//End of opponent's 2nd corner move code (Opponent's 1st move is center)


        //Beginning of opponent's 2nd edge move code (Opponent's 1st move is center)
        //If opponent's 2nd move is edge (Opposite's 1st move is center)
        else if(move.equals("XCenterEdge2")) {

            checkStrikeX();

            if(turn == 2) {

                if (b1.equals("O") && b4.equals("") && b7.equals("")) {
                    r = new Random();
                    ran = r.nextInt(max - min + 1) + min;

                    if (ran == 4) {
                        move = "XCenterEdge3";
                        press4();
                    } else if (ran == 7) {
                        move = "XCenterEdge3";
                        press7();
                    } else {
                        androidTurn();
                    }
                }
                else if (b1.equals("O") && b2.equals("") && b3.equals("")) {
                    r = new Random();
                    ran = r.nextInt(max - min + 1) + min;

                    if (ran == 2) {
                        move = "XCenterEdge3";
                        press2();
                    } else if (ran == 3) {
                        move = "XCenterEdge3";
                        press3();
                    } else {
                        androidTurn();
                    }
                }
                else  if (b3.equals("O") && b2.equals("") && b1.equals("")) {
                    r = new Random();
                    ran = r.nextInt(max - min + 1) + min;

                    if (ran == 2) {
                        move = "XCenterEdge3";
                        press2();
                    } else if (ran == 1) {
                        move = "XCenterEdge3";
                        press1();
                    } else {
                        androidTurn();
                    }
                }
                else if (b3.equals("O") && b6.equals("") && b9.equals("")) {
                    r = new Random();
                    ran = r.nextInt(max - min + 1) + min;

                    if (ran == 6) {
                        move = "XCenterEdge3";
                        press6();
                    } else if (ran == 9) {
                        move = "XCenterEdge3";
                        press9();
                    } else {
                        androidTurn();
                    }
                }
                else  if (b7.equals("O") && b4.equals("") && b1.equals("")) {
                    r = new Random();
                    ran = r.nextInt(max - min + 1) + min;

                    if (ran == 4) {
                        move = "XCenterEdge3";
                        press4();
                    } else if (ran == 1) {
                        move = "XCenterEdge3";
                        press1();
                    } else {
                        androidTurn();
                    }
                }
                else if (b7.equals("O") && b8.equals("") && b9.equals("")) {
                    r = new Random();
                    ran = r.nextInt(max - min + 1) + min;

                    if (ran == 8) {
                        move = "XCenterEdge3";
                        press8();
                    } else if (ran == 9) {
                        move = "XCenterEdge3";
                        press9();
                    } else {
                        androidTurn();
                    }
                }
                else  if (b9.equals("O") && b6.equals("") && b3.equals("")) {
                    r = new Random();
                    ran = r.nextInt(max - min + 1) + min;

                    if (ran == 6) {
                        move = "XCenterEdge3";
                        press6();
                    } else if (ran == 3) {
                        move = "XCenterEdge3";
                        press3();
                    } else {
                        androidTurn();
                    }
                }
                else if (b9.equals("O") && b8.equals("") && b7.equals("")) {
                    r = new Random();
                    ran = r.nextInt(max - min + 1) + min;

                    if (ran == 8) {
                        move = "XCenterEdge3";
                        press8();
                    } else if (ran == 7) {
                        move = "XCenterEdge3";
                        press7();
                    } else {
                        androidTurn();
                    }
                }
            }
        }

        else if(move.equals("XCenterEdge3")) {
            checkStrikeX();
            if (turn == 2) {
                randomFire();
            }
        }//End of opponent's 2nd edge move code (Opponent's 1st move is center)
        //End of opponent's 1st center move code


        //Beginning of opponent's 1st corner move code
        //If opponent's 1st move is corner
        else if(move.equals("XCornerCenter")) {

            //If opponent's 2nd move is opposite corner of 1st (Opposite's 1st move is corner)
            if(b1.equals("X") && b9.equals("X") || b3.equals("X") && b7.equals("X")) {

                r = new Random();
                ran = r.nextInt(max - min + 1) + min;

                if (ran == 2) {
                    move = "XCornerCenter2";
                    press2();
                } else if (ran == 4) {
                    move = "XCornerCenter2";
                    press4();
                } else if (ran == 6) {
                    move = "XCornerCenter2";
                    press6();
                } else if (ran == 8) {
                    move = "XCornerCenter2";
                    press8();
                } else {
                    androidTurn();
                }
            }

            //If opponent's 2nd move is side corner of 1st (Opposite's 1st move is corner)
            else if(b1.equals("X") && b3.equals("X")) {
                move = "XCornerCenter2";
                press2();
            }
            else if(b1.equals("X") && b7.equals("X")) {
                move = "XCornerCenter2";
                press4();
            }
            else if(b3.equals("X") && b9.equals("X")) {
                move = "XCornerCenter2";
                press6();
            }
            else if(b7.equals("X") && b9.equals("X")) {
                move = "XCornerCenter2";
                press8();
            }

            //If opponent's 2nd move is edge (Opposite's 1st move is corner)
            else if(b2.equals("X") || b4.equals("X") || b6.equals("X") || b8.equals("X")) {


                if(b1.equals("X") && b2.equals("X")) {
                    move = "XCornerCenter2";
                    press3();
                }
                else if(b3.equals("X") && b2.equals("X")) {
                    move = "XCornerCenter2";
                    press1();
                }
                else if(b1.equals("X") && b4.equals("X")) {
                    move = "XCornerCenter2";
                    press7();
                }
                else if(b7.equals("X") && b4.equals("X")) {
                    move = "XCornerCenter2";
                    press1();
                }
                else if(b7.equals("X") && b8.equals("X")) {
                    move = "XCornerCenter2";
                    press9();
                }
                else if(b9.equals("X") && b8.equals("X")) {
                    move = "XCornerCenter2";
                    press7();
                }
                else if(b9.equals("X") && b6.equals("X")) {
                    move = "XCornerCenter2";
                    press3();
                }
                else if(b3.equals("X") && b6.equals("X")) {
                    move = "XCornerCenter2";
                    press9();
                }

                else if(b1.equals("X") && b8.equals("X")) {
                    move = "XCornerCenter2";
                    press6();
                }
                else if(b1.equals("X") && b6.equals("X")) {
                    move = "XCornerCenter2";
                    press8();
                }

                else if(b3.equals("X") && b4.equals("X")) {
                    move = "XCornerCenter2";
                    press8();
                }
                else if(b3.equals("X") && b8.equals("X")) {
                    move = "XCornerCenter2";
                    press4();
                }

                else if(b7.equals("X") && b2.equals("X")) {
                    move = "XCornerCenter2";
                    press6();
                }
                else if(b7.equals("X") && b6.equals("X")) {
                    move = "XCornerCenter2";
                    press2();
                }

                else if(b9.equals("X") && b2.equals("X")) {
                    move = "XCornerCenter2";
                    press4();
                }
                else if(b9.equals("X") && b4.equals("X")) {
                    move = "XCornerCenter2";
                    press2();
                }


            }
        }

        //Beginning of opponent's 2nd corner move code (Opponent's 1st move is corner)
        //If opponent's 2nd move is corner (Opposite's 1st move is center)
        else if(move.equals("XCornerCenter2")) {

            checkStrikeX();

            if(turn==2) {

                if(b2.equals("") && b8.equals("")) {
                    r = new Random();
                    ran = r.nextInt(max - min + 1) + min;

                    if (ran == 2) {
                        move = "XCornerCenter3";
                        press2();
                    } else if (ran == 8) {
                        move = "XCornerCenter3";
                        press8();
                    } else {
                        androidTurn();
                    }
                }
                else if(b4.equals("") && b6.equals("")) {
                    r = new Random();
                    ran = r.nextInt(max - min + 1) + min;

                    if (ran == 4) {
                        move = "XCornerCenter3";
                        press4();
                    } else if (ran == 6) {
                        move = "XCornerCenter3";
                        press6();
                    } else {
                        androidTurn();
                    }
                }
                else if(b1.equals("") && b9.equals("")) {
                    r = new Random();
                    ran = r.nextInt(max - min + 1) + min;

                    if (ran == 1) {
                        move = "XCornerCenter3";
                        press1();
                    } else if (ran == 9) {
                        move = "XCornerCenter3";
                        press9();
                    } else {
                        androidTurn();
                    }
                }
                else if(b3.equals("") && b7.equals("")) {
                    r = new Random();
                    ran = r.nextInt(max - min + 1) + min;

                    if (ran == 3) {
                        move = "XCornerCenter3";
                        press3();
                    } else if (ran == 7) {
                        move = "XCornerCenter3";
                        press7();
                    } else {
                        androidTurn();
                    }
                }
                else {
                    randomFire();
                }
            }
        }

        //If opponent's 2nd move is side corner of 1st (Opposite's 1st move is center)
        else if(move.equals("XCornerCenter3")) {

            checkStrikeX();
            if(turn==2) {
                randomFire();
            }
        }//End of opponent's 2st corner move code


        //If opponent's 1st move is edge
        //Beginning of opponent's 1st edge move code
        else if(move.equals("XEdgeEdge")) {

            //If opposite's 2nd move is side corner of 1st (Opposite's 1st move is edge)
            if(b2.equals("X") && b1.equals("X")) {
                move = "XEdgeEdge2";
                press3();
            }
            else if(b2.equals("X") && b3.equals("X")) {
                move = "XEdgeEdge2";
                press1();
            }
            else if(b4.equals("X") && b1.equals("X")) {
                move = "XEdgeEdge2";
                press7();
            }
            else if(b4.equals("X") && b7.equals("X")) {
                move = "XEdgeEdge2";
                press1();
            }
            else if(b6.equals("X") && b3.equals("X")) {
                move = "XEdgeEdge2";
                press9();
            }
            else if(b6.equals("X") && b9.equals("X")) {
                move = "XEdgeEdge2";
                press3();
            }
            else if(b8.equals("X") && b7.equals("X")) {
                move = "XEdgeEdge2";
                press9();
            }
            else if(b8.equals("X") && b9.equals("X")) {
                move = "XEdgeEdge2";
                press7();
            }

            //If opposite's 2nd move is opposite corner of 1st (Opposite's 1st move is edge)
            else if(b2.equals("X") && b7.equals("X")) {
                move = "XEdgeEdge2";
                press1();
            }
            else if(b2.equals("X") && b9.equals("X")) {
                move = "XEdgeEdge2";
                press3();
            }
            else if(b4.equals("X") && b3.equals("X")) {
                move = "XEdgeEdge2";
                press1();
            }
            else if(b4.equals("X") && b9.equals("X")) {
                move = "XEdgeEdge2";
                press7();
            }
            else if(b6.equals("X") && b1.equals("X")) {
                move = "XEdgeEdge2";
                press3();
            }
            else if(b6.equals("X") && b7.equals("X")) {
                move = "XEdgeEdge2";
                press9();
            }
            else if(b8.equals("X") && b1.equals("X")) {
                move = "XEdgeEdge2";
                press7();
            }
            else if(b8.equals("X") && b3.equals("X")) {
                move = "XEdgeEdge2";
                press9();
            }

            //If opposite's 2nd move is edge (Opposite's 1st move is edge)
            else if(b2.equals("X") && b4.equals("X")) {
                move = "XEdgeEdge2";
                press1();
            }
            else if(b2.equals("X") && b6.equals("X")) {
                move = "XEdgeEdge2";
                press3();
            }
            else if(b8.equals("X") && b4.equals("X")) {
                move = "XEdgeEdge2";
                press7();
            }
            else if(b8.equals("X") && b6.equals("X")) {
                move = "XEdgeEdge2";
                press9();
            }

            //If opposite's 2nd move is center (Opposite's 1st move is edge)
            else if(b2.equals("X") && b5.equals("X")) {
                r = new Random();
                ran = r.nextInt(max - min + 1) + min;

                if (ran == 7) {
                    move = "XEdgeEdge2";
                    press7();
                } else if (ran == 9) {
                    move = "XEdgeEdge2";
                    press9();
                } else {
                    androidTurn();
                }
            }
            else if(b4.equals("X") && b5.equals("X")) {
                r = new Random();
                ran = r.nextInt(max - min + 1) + min;

                if (ran == 3) {
                    move = "XEdgeEdge2";
                    press3();
                } else if (ran == 9) {
                    move = "XEdgeEdge2";
                    press9();
                } else {
                    androidTurn();
                }
            }
            else if(b6.equals("X") && b5.equals("X")) {
                r = new Random();
                ran = r.nextInt(max - min + 1) + min;

                if (ran == 1) {
                    move = "XEdgeEdge2";
                    press1();
                } else if (ran == 7) {
                    move = "XEdgeEdge2";
                    press7();
                } else {
                    androidTurn();
                }
            }
            else if(b8.equals("X") && b5.equals("X")) {
                r = new Random();
                ran = r.nextInt(max - min + 1) + min;

                if (ran == 1) {
                    move = "XEdgeEdge2";
                    press1();
                } else if (ran == 3) {
                    move = "XEdgeEdge2";
                    press3();
                } else {
                    androidTurn();
                }
            }
        }

        else if (move.equals("XEdgeEdge2")) {

            checkStrikeX();

            if(turn == 2) {

                if(b2.equals("X") && b4.equals("X") && b9.equals("")) {

                    if(box3) {
                        move = "XEdgeEdge3";
                        press3();
                    }
                    else if (box7) {
                        move = "XEdgeEdge3";
                        press7();
                    }
                }
                else if(b2.equals("X") && b6.equals("X") && b7.equals("")) {

                    if(box1) {
                        move = "XEdgeEdge3";
                        press1();
                    }
                    else if(box9) {
                        move = "XEdgeEdge3";
                        press9();
                    }

                }
                else if(b8.equals("X") && b4.equals("X") && b3.equals("")) {

                    if(box1) {
                        move = "XEdgeEdge3";
                        press1();
                    }
                    else if(box9) {
                        move = "XEdgeEdge3";
                        press9();
                    }
                }
                else if(b8.equals("X") && b6.equals("X") && b1.equals("")) {

                    if(box3) {
                        move = "XEdgeEdge3";
                        press3();
                    }
                    else if(box7) {
                        move = "XEdgeEdge3";
                        press7();
                    }
                }

                else if(b2.equals("X") && b4.equals("X") && b9.equals("X")) {
                    if(box1) {
                        move = "XEdgeEdge3";
                        press1();
                    }
                    else if(box6) {
                        move = "XEdgeEdge3";
                        press6();
                    }
                    else if(box8){
                        move = "XEdgeEdge3";
                        press8();
                    }
                }
                else if(b2.equals("X") && b6.equals("X") && b7.equals("X")) {
                    if(box3) {
                        move = "XEdgeEdge3";
                        press3();
                    }
                    else if(box4) {
                        move = "XEdgeEdge3";
                        press4();
                    }
                    else if(box8){
                        move = "XEdgeEdge3";
                        press8();
                    }
                }
                else if(b8.equals("X") && b4.equals("X") && b3.equals("X")) {
                    if(box7) {
                        move = "XEdgeEdge3";
                        press7();
                    }
                    else if(box2) {
                        move = "XEdgeEdge3";
                        press2();
                    }
                    else if(box6){
                        move = "XEdgeEdge3";
                        press6();
                    }
                }
                else if(b8.equals("X") && b6.equals("X") && b1.equals("X")) {
                    if(box9) {
                        move = "XEdgeEdge3";
                        press9();
                    }
                    else if(box2) {
                        move = "XEdgeEdge3";
                        press2();
                    }
                    else if(box4){
                        move = "XEdgeEdge3";
                        press4();
                    }
                }
                else {
                    randomFire();
                }
            }
        }

        else if(move.equals("XEdgeEdge3")) {

            checkStrikeX();
            if(turn == 2) {
                randomFire();
            }
        }//End of opponent's 1st edge move code
    }//End of unbeatable move if player select X code


    //Make button blink
    public void blinkBox1(){
        Animation anim = new AlphaAnimation(0.0f, 1.0f);
        anim.setDuration(300);
        anim.setStartOffset(50);
        anim.setRepeatCount(2);
        jbtn1.startAnimation(anim);
    }
    public void blinkBox2(){
        Animation anim = new AlphaAnimation(0.0f, 1.0f);
        anim.setDuration(300);
        anim.setStartOffset(50);
        anim.setRepeatCount(2);
        jbtn2.startAnimation(anim);
    }
    public void blinkBox3(){
        Animation anim = new AlphaAnimation(0.0f, 1.0f);
        anim.setDuration(300);
        anim.setStartOffset(50);
        anim.setRepeatCount(2);
        jbtn3.startAnimation(anim);
    }
    public void blinkBox4(){
        Animation anim = new AlphaAnimation(0.0f, 1.0f);
        anim.setDuration(300);
        anim.setStartOffset(50);
        anim.setRepeatCount(2);
        jbtn4.startAnimation(anim);
    }
    public void blinkBox5(){
        Animation anim = new AlphaAnimation(0.0f, 1.0f);
        anim.setDuration(300);
        anim.setStartOffset(50);
        anim.setRepeatCount(2);
        jbtn5.startAnimation(anim);
    }
    public void blinkBox6(){
        Animation anim = new AlphaAnimation(0.0f, 1.0f);
        anim.setDuration(300);
        anim.setStartOffset(50);
        anim.setRepeatCount(2);
        jbtn6.startAnimation(anim);
    }
    public void blinkBox7(){
        Animation anim = new AlphaAnimation(0.0f, 1.0f);
        anim.setDuration(300);
        anim.setStartOffset(50);
        anim.setRepeatCount(2);
        jbtn7.startAnimation(anim);
    }
    public void blinkBox8(){
        Animation anim = new AlphaAnimation(0.0f, 1.0f);
        anim.setDuration(300);
        anim.setStartOffset(50);
        anim.setRepeatCount(2);
        jbtn8.startAnimation(anim);
    }
    public void blinkBox9(){
        Animation anim = new AlphaAnimation(0.0f, 1.0f);
        anim.setDuration(300);
        anim.setStartOffset(50);
        anim.setRepeatCount(2);
        jbtn9.startAnimation(anim);
    }
}