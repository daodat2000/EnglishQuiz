package com.example.englishquiz;

import android.util.Log;
import android.view.View;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class MultipleQuestionAdapter extends RecyclerView.ViewHolder {
    TextView question;
    RadioButton answer1, answer2, answer3, answer4;
    RadioGroup answer;
    public MultipleQuestionAdapter(@NonNull View itemView) {
        super(itemView);
        Log.d("RecyclerAdapter", "Multi");
        question = itemView.findViewById(R.id.question);
        answer1 = itemView.findViewById(R.id.answer_1);
        answer2 = itemView.findViewById(R.id.answer_2);
        answer3 = itemView.findViewById(R.id.answer_3);
        answer4 = itemView.findViewById(R.id.answer_4);
        answer = itemView.findViewById(R.id.answer);
    }
    void setQuestion(MultipleQuestion q){
        question.setText(q.getQuestion());
        answer1.setText(q.getAnswer1());
        answer2.setText(q.getAnswer2());
        answer3.setText(q.getAnswer3());
        answer4.setText(q.getAnswer4());
        answer.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, int i) {
                String correctAns = q.getCorrectAns();
                q.setCheckAns(false);
                if (i == R.id.answer_1) {
                    if (correctAns.equals("1")) {
                        q.setCheckAns(true);
                    }
                } else if (i == R.id.answer_2) {
                    if (correctAns.equals("2")) {
                        q.setCheckAns(true);
                    }
                } else if (i == R.id.answer_3) {
                    if (correctAns.equals("3")) {
                        q.setCheckAns(true);
                    }
                } else if (i == R.id.answer_4) {
                    if (correctAns.equals("4")) {
                        q.setCheckAns(true);
                    }
                }

            }
        });
    }
}
