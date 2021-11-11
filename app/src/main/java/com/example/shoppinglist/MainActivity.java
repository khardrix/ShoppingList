package com.example.shoppinglist;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

import java.util.ArrayList;


public class MainActivity extends AppCompatActivity {

    private static final String LOG_TAG = MainActivity.class.getSimpleName();
    public static final int TEXT_REQUEST = 1;
    private ArrayList<TextView> textViews = new ArrayList<>();
    private ArrayList<String> items = new ArrayList<>();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Log.d(LOG_TAG, "-------");
        Log.d(LOG_TAG, "onCreate");

        textViews.add(findViewById(R.id.txtView_one));
        textViews.add(findViewById(R.id.txtView_two));
        textViews.add(findViewById(R.id.txtView_three));
        textViews.add(findViewById(R.id.txtView_four));
        textViews.add(findViewById(R.id.txtView_five));
        textViews.add(findViewById(R.id.txtView_six));
        textViews.add(findViewById(R.id.txtView_seven));
        textViews.add(findViewById(R.id.txtView_eight));
        textViews.add(findViewById(R.id.txtView_nine));
        textViews.add(findViewById(R.id.txtView_ten));

        if(savedInstanceState != null) {
            items = (ArrayList<String>) savedInstanceState.getSerializable("array");
        }

        for(int i = 0; i < items.size(); i++) {
            textViews.get(i).setText(items.get(i));
        }
    }


    public void launchSecondActivity(View view) {
        Intent intent = new Intent(this, SecondActivity.class);
        Log.d(LOG_TAG, "Button clicked!");
        startActivityForResult(intent, TEXT_REQUEST);
    }


    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (requestCode == TEXT_REQUEST) {
            if (resultCode == RESULT_OK) {
                String itemToAdd = data.getStringExtra(SecondActivity.EXTRA_ITEM);

                if (!(items.contains(itemToAdd))) {
                    items.add(itemToAdd);
                }

                for(int i = 0; i < items.size(); i++) {
                    textViews.get(i).setText(items.get(i));
                }
            }
        }
    }


    @Override
    public void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);

        outState.putSerializable("array", items);
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
        for(int i = 0; i < items.size(); i++) {
            textViews.get(i).setText(items.get(i));
        }
    }


    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.d(LOG_TAG, "onDestroy");
        for(int i = 0; i < items.size(); i++) {
            textViews.get(i).setText(items.get(i));
        }
    }


    @Override
    protected void onPause() {
        super.onPause();
        Log.d(LOG_TAG, "onPause");
        for(int i = 0; i < items.size(); i++) {
            textViews.get(i).setText(items.get(i));
        }
    }


    @Override
    protected void onResume() {
        super.onResume();
        Log.d(LOG_TAG, "onResume");
        for(int i = 0; i < items.size(); i++) {
            textViews.get(i).setText(items.get(i));
        }
    }


    @Override
    protected void onRestart() {
        super.onRestart();
        Log.d(LOG_TAG, "onRestart");
        for(int i = 0; i < items.size(); i++) {
            textViews.get(i).setText(items.get(i));
        }
    }
}