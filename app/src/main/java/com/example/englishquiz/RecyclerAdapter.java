package com.example.englishquiz;

import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class RecyclerAdapter extends RecyclerView.Adapter{

    List<Question> questions;

    public RecyclerAdapter(List<Question> questions) {
        this.questions = questions;
    }

    @Override
    public int getItemViewType(int position) {
        Log.d("RecyclerAdapter", "getItemViewType: ");
        if (questions.get(position).getType().equals("FillQuestion")) {
            Log.d("viewType", "0");
            return 0;
        }
        else if (questions.get(position).getType().equals("MultipleQuestion")) {
            Log.d("viewType", "1");
            return 1;
        }
        Log.d("viewType", "2");
        return 2;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        Log.d("RecyclerAdapter", "onCreateViewHolder: ");
        if (viewType == 0) {
            Log.d("viewType", "create fill");
            return new FillViewHolder(
                    LayoutInflater.from(parent.getContext()).inflate(
                    R.layout.fill_question_view, parent, false
            ));
        }
        Log.d("viewType", "create multi");
        return new MultipleViewHolder(
                LayoutInflater.from(parent.getContext()).inflate(
                R.layout.multiple_question_view, parent, false
        ));
    }


    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        Log.d("RecyclerAdapter", "onBindViewHolder: ");
        if(getItemViewType(position) == 0) {
            FillQuestion question = (FillQuestion) questions.get(position);
            ((FillViewHolder) holder).setQuestion(question);
        }
        else if(getItemViewType(position) == 1) {
            MultipleQuestion question = (MultipleQuestion) questions.get(position);
            ((MultipleViewHolder) holder).setQuestion(question);
        }

    }

    @Override
    public int getItemCount() {
        Log.d("RecyclerAdapter", "getItemCount: ");
        Log.d("RecyclerAdapter", String.valueOf(questions.size()));
        return questions.size();
    }



    class FillViewHolder extends RecyclerView.ViewHolder{
        TextView question;
        EditText answer;


        public FillViewHolder(@NonNull View itemView) {
            super(itemView);
            Log.d("RecyclerAdapter", "Fill");
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
    class MultipleViewHolder extends RecyclerView.ViewHolder{
        TextView question;
        RadioButton answer1, answer2, answer3, answer4;
        RadioGroup answer;

        public MultipleViewHolder(@NonNull View itemView) {
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
}
