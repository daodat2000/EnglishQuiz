package com.example.englishquiz;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class ResultActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result);
        Intent intent = getIntent();
        int right = intent.getIntExtra("right",0);
        int result = (right*100/intent.getIntExtra("total", 1));
        String fullResult = result + getResources().getString(R.string.percentage);
        TextView resultTextView = (TextView) findViewById(R.id.result);
        ImageView resultImageView = (ImageView) findViewById(R.id.image);
        if (result >= 80) {
            resultTextView.setText(fullResult);
            resultImageView.setImageResource(R.drawable.happy);
            Toast.makeText(this, "Well Done!", Toast.LENGTH_SHORT).show();
        } else if (result > 0) {
            resultTextView.setText(fullResult);
            resultImageView.setImageResource(R.drawable.fair);
            Toast.makeText(this, "Fair", Toast.LENGTH_SHORT).show();
        } else {
            resultTextView.setText(fullResult);
            resultImageView.setImageResource(R.drawable.sad);
            Toast.makeText(this, "Try Again", Toast.LENGTH_SHORT).show();
        }


    }


}
