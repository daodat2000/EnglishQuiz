package com.example.englishquiz;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

import org.json.JSONException;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    List<Question> lstQuestion;
    RecyclerAdapter recyclerAdapter;
    RecyclerView recyclerView;

    List<String> moviesList;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        lstQuestion = new ArrayList<>();
        String jsonFileString = Utils.getJsonFromAssets(getApplicationContext(), "dataQuestion.json");

        Log.i("data", jsonFileString);

        try {
            lstQuestion = Question.Deserialize(this,jsonFileString);
        } catch (JSONException e) {
            e.printStackTrace();
        }

        Log.i("data", String.valueOf(lstQuestion.size()));

        recyclerView = findViewById(R.id.recyclerView);
        recyclerAdapter = new RecyclerAdapter(lstQuestion);
        recyclerView.setAdapter(recyclerAdapter);
        Log.d("data", "error");
    }
    public void submitAnswers(View view) {
        int right=0, total = lstQuestion.size();
        for(int i=0;i<lstQuestion.size();i++){
            if(lstQuestion.get(i).isCheckAns()){
                right=right+1;
                Toast.makeText(this,"Dung cau "+i,Toast.LENGTH_LONG).show();
                Log.d("check", "Dung cau " + i);
            }
            else {
                Toast.makeText(this,"Sai cau "+i,Toast.LENGTH_LONG).show();
                Log.d("check", "Sai cau " + i);
            }


        }
        Intent intent = new Intent(MainActivity.this, ResultActivity.class);
        intent = intent.putExtra("right",right);
        intent = intent.putExtra("total",total);
        startActivity(intent);
    }


}