package com.example.shoppinglist;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;


public class SecondActivity extends AppCompatActivity {

    private static final String LOG_TAG = SecondActivity.class.getSimpleName();
    public static final String EXTRA_ITEM = "com.example.android.shoppinglist.extra.ITEM";
    private Button sendingButton;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);
    }


    public void returnItem(View view) {
        switch (view.getId()) {
            case R.id.btn_one_cheese:
                sendingButton = findViewById(R.id.btn_one_cheese);
                break;
            case R.id.btn_two_rice:
                sendingButton = findViewById(R.id.btn_two_rice);
                break;
            case R.id.btn_three_apples:
                sendingButton = findViewById(R.id.btn_three_apples);
                break;
            case R.id.btn_four_bread:
                sendingButton = findViewById(R.id.btn_four_bread);
                break;
            case R.id.btn_five_milk:
                sendingButton = findViewById(R.id.btn_five_milk);
                break;
            case R.id.btn_six_butter:
                sendingButton = findViewById(R.id.btn_six_butter);
                break;
            case R.id.btn_seven_eggs:
                sendingButton = findViewById(R.id.btn_seven_eggs);
                break;
            case R.id.btn_eight_cereal:
                sendingButton = findViewById(R.id.btn_eight_cereal);
                break;
            case R.id.btn_nine_flour:
                sendingButton = findViewById(R.id.btn_nine_flour);
                break;
            case R.id.btn_ten_sugar:
                sendingButton = findViewById(R.id.btn_ten_sugar);
                break;
        }

        String itemToAdd = sendingButton.getText().toString();
        Intent itemIntent = new Intent();

        itemIntent.putExtra(EXTRA_ITEM, itemToAdd);
        setResult(RESULT_OK, itemIntent);

        Log.d(LOG_TAG, "End SecondActivity");
        finish();
    }


    @Override
    public void onStart() {
        super.onStart();
        Log.d(LOG_TAG, "onStart");
    }


    @Override
    protected void onStop() {
        super.onStop();
        Log.d(LOG_TAG, "onStop");
    }


    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.d(LOG_TAG, "onDestroy");
    }


    @Override
    protected void onPause() {
        super.onPause();
        Log.d(LOG_TAG, "onPause");
    }


    @Override
    protected void onResume() {
        super.onResume();
        Log.d(LOG_TAG, "onResume");
    }


    @Override
    protected void onRestart() {
        super.onRestart();
        Log.d(LOG_TAG, "onRestart");
    }
}