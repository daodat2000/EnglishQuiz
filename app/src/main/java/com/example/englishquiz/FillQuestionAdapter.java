package com.example.englishquiz;

import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class FillQuestionAdapter extends RecyclerView.ViewHolder {
    TextView question;
    EditText answer;
    public FillQuestionAdapter(@NonNull View itemView) {
        super(itemView);
        question = itemView.findViewById(R.id.question);
        answer = itemView.findViewById(R.id.answer);
    }
    void setQuestion(FillQuestion q){
        question.setText(q.getQuestion());
        answer.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                String correctAns = q.getCorrectAns();
                q.setCheckAns(false);
                if (answer.getText().toString().equals(correctAns)) {
                    q.setCheckAns(true);
                }
            }

            @Override
            public void afterTextChanged(Editable editable) {

            }
        });

    }

}
