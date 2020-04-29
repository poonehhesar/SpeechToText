package com.example.speach_to_text;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

import org.w3c.dom.Text;

public class AddActivity extends AppCompatActivity {

    TextView tv;
    String st;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add);

        Bundle text = getIntent().getExtras();
        String Value = text.getString("Value");

        Log.d("addActivity", Value);

        tv=findViewById(R.id.textView);
        tv.setText(Value);

        @SuppressLint("CommitEdits") SharedPreferences.Editor editor = getSharedPreferences("add", MODE_PRIVATE).edit();
        editor.putString("word", " ");
        editor.apply();
        editor.commit();

        Log.d("Lifecycle", "Main Activity:onCreate() invoke");

    }

    public void saveWord(String word) {
        SharedPreferences.Editor editor = getSharedPreferences("Add", MODE_PRIVATE).edit();
        editor.putString("word", word);
        Log.d("word","word saved " + word);
        editor.apply();
        editor.commit();
    }


    @Override
    protected void onStart() {
        super.onStart();
        Log.d("lifecycle", "onStart invoked " + getApplication());

    }
    @Override
    protected void onResume() {
        super.onResume();
        Log.d("lifecycle", "onResume invoked " + getApplication());
    }
    @Override
    protected void onPause() {
        super.onPause();
        Log.d("lifecycle", "onPause invoked " + getApplication());
    }
    @Override
    protected void onStop() {
        super.onStop();
        Log.d("lifecycle", "onStart invoked " + getApplication());
    }


    public void returnBtn(View view) {
        Log.d("returnBtn", "return btn works");

        Intent i=new Intent(AddActivity.this,MainActivity.class);
        startActivity(i);
    }
}
