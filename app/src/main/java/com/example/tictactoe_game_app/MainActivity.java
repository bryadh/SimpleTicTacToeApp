package com.example.tictactoe_game_app;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    public static final String TAG = "MainActiviy";
    public static final int PLAYER1 = 1;
    public static final int PLAYER2 = 2;
    public static final String X = "X";
    public static final String O = "O";
    
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void btnClicked(View view) {
        Button btn = (Button) view;

        int cellID = 0;

        switch (btn.getId()){

            case R.id.btn1:
                cellID = 1;
                break;
            case R.id.bnt2:
                cellID = 2;
                break;
            case R.id.btn3:
                cellID = 3;
                break;
            case R.id.btn4:
                cellID = 4;
                break;
            case R.id.btn5:
                cellID = 5;
                break;
            case R.id.btn6:
                cellID = 6;
                break;
            case R.id.btn7:
                cellID = 7;
                break;
            case R.id.btn8:
                cellID = 8;
                break;
            case R.id.btn9:
                cellID = 9;
                break;
        }

        init(cellID, btn);
    }

    int activePlayer = PLAYER1;
    List<Integer> player1Data = new ArrayList<>();
    List<Integer> player2Data = new ArrayList<>();

    public void init(int cellID, Button btn){

        Log.d(TAG, "init: cell "+cellID+" selected");

        if(activePlayer == PLAYER1){
            btn.setText(X);
            player1Data.add(cellID);
            activePlayer = PLAYER2;
        } else
            if(activePlayer == PLAYER2){
                btn.setText(O);
                player2Data.add(cellID);
                activePlayer = PLAYER1;
        }

        btn.setEnabled(false);
        checkWinner();
    }

    public void checkWinner(){
        int winner = 0;

        //ROWS
        //player1
        if(player1Data.contains(1) && player1Data.contains(2) && player1Data.contains(3))
            winner = PLAYER1;

        if(player1Data.contains(3) && player1Data.contains(4) && player1Data.contains(5))
            winner = PLAYER1;

        if(player1Data.contains(6) && player1Data.contains(7) && player1Data.contains(8))
            winner = PLAYER1;
        //player2
        if(player2Data.contains(1) && player2Data.contains(2) && player2Data.contains(3))
            winner = PLAYER2;

        if(player2Data.contains(3) && player2Data.contains(4) && player2Data.contains(5))
            winner = PLAYER2;

        if(player2Data.contains(6) && player2Data.contains(7) && player2Data.contains(8))
            winner = PLAYER2;

        if(winner != 0){
            Log.d(TAG, "checkWinner: the winner is player"+winner);
            Toast.makeText(this, "The winner is palyer"+winner, Toast.LENGTH_SHORT).show();
        }

    }


}