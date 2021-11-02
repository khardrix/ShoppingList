package com.example.shoppinglist;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private static final String LOG_TAG = MainActivity.class.getSimpleName();
    private TextView txtDisplay1, txtDisplay2, txtDisplay3, txtDisplay4, txtDisplay5,
        txtDisplay6, txtDisplay7, txtDisplay8, txtDisplay9, txtDisplay10;
    private TextView currentTxtDisplay;
    public static final int TEXT_REQUEST = 1; // <-possible problem?


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Log.d(LOG_TAG, "-------");
        Log.d(LOG_TAG, "onCreate");

        // Initialize all the textView variables.
        // possible to not need these?
        txtDisplay1 = findViewById(R.id.txtView_one);
        txtDisplay2 = findViewById(R.id.txtView_two);
        txtDisplay3 = findViewById(R.id.txtView_three);
        txtDisplay4 = findViewById(R.id.txtView_four);
        txtDisplay5 = findViewById(R.id.txtView_five);
        txtDisplay6 = findViewById(R.id.txtView_six);
        txtDisplay7 = findViewById(R.id.txtView_seven);
        txtDisplay8 = findViewById(R.id.txtView_eight);
        txtDisplay9 = findViewById(R.id.txtView_nine);
        txtDisplay10 = findViewById(R.id.txtView_ten);

        // initialize the currentTxtDisplay to the first empty textView
        if(txtDisplay1.getText().toString().isEmpty()){
            currentTxtDisplay = findViewById(R.id.txtView_one);
        } else if(txtDisplay2.getText().toString().isEmpty()){
            currentTxtDisplay = findViewById(R.id.txtView_two);
        } else if(txtDisplay3.getText().toString().isEmpty()){
            currentTxtDisplay = findViewById(R.id.txtView_three);
        } else if(txtDisplay4.getText().toString().isEmpty()){
            currentTxtDisplay = findViewById(R.id.txtView_four);
        } else if(txtDisplay5.getText().toString().isEmpty()){
            currentTxtDisplay = findViewById(R.id.txtView_five);
        } else if(txtDisplay6.getText().toString().isEmpty()){
            currentTxtDisplay = findViewById(R.id.txtView_six);
        } else if(txtDisplay7.getText().toString().isEmpty()){
            currentTxtDisplay = findViewById(R.id.txtView_seven);
        } else if(txtDisplay8.getText().toString().isEmpty()){
            currentTxtDisplay = findViewById(R.id.txtView_eight);
        } else if(txtDisplay9.getText().toString().isEmpty()){
            currentTxtDisplay = findViewById(R.id.txtView_nine);
        } else {
            currentTxtDisplay = findViewById(R.id.txtView_ten);
        }

        // TEST TO SEE IF currentTxtDisplay IS ITERATING
        Log.d(LOG_TAG, "currentTxtDisplay = " + currentTxtDisplay.getId());

        // Restore the saved state.
        // See onSaveInstanceState() for what gets saved.
        if (savedInstanceState != null) {
            boolean isVisible = savedInstanceState.getBoolean("itemToAdd_visible");
            // Show both the header and the message views. If isVisible is
            // false or missing from the bundle, use the default layout.
            if (isVisible) {
                txtDisplay1.setVisibility(View.VISIBLE);
                txtDisplay2.setVisibility(View.VISIBLE);
                txtDisplay3.setVisibility(View.VISIBLE);
                txtDisplay4.setVisibility(View.VISIBLE);
                txtDisplay5.setVisibility(View.VISIBLE);
                txtDisplay6.setVisibility(View.VISIBLE);
                txtDisplay7.setVisibility(View.VISIBLE);
                txtDisplay8.setVisibility(View.VISIBLE);
                txtDisplay9.setVisibility(View.VISIBLE);
                txtDisplay10.setVisibility(View.VISIBLE);
                currentTxtDisplay.setText(savedInstanceState
                        .getString("itemToAdd_text"));
                currentTxtDisplay.setVisibility(View.VISIBLE);
            }
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
                // mReplyHeadTextView.setVisibility(View.VISIBLE); <- not needed
                currentTxtDisplay.setText(itemToAdd);
                currentTxtDisplay.setVisibility(View.VISIBLE);
            }
        }
    }

    // POSSIBLE SOURCE OF PROBLEM!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!
    @Override
    public void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        // If the heading is visible, message needs to be saved.
        // Otherwise we're still using default layout.
        if (currentTxtDisplay.getVisibility() == View.VISIBLE) {
            outState.putBoolean("itemToAdd_visible", true);
            outState.putString("itemToAdd_text", currentTxtDisplay.getText().toString());
        }
    }


    @Override
    public void onStart(){
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