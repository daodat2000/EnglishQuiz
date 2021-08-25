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
        switch (questions.get(position).getType()) {
            case "FillQuestion":
                Log.d("viewType", "0");
                return 0;
            case "MultipleQuestion":
                Log.d("viewType", "1");
                return 1;
            case "Listening":
                Log.d("viewType", "2");
                return 2;
        }
        Log.d("viewType", "3");
        return 3;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        Log.d("RecyclerAdapter", "onCreateViewHolder: ");
        if (viewType == 0) {
            Log.d("viewType", "create fill");
            return new FillQuestionAdapter(
                    LayoutInflater.from(parent.getContext()).inflate(
                            R.layout.fill_question_view, parent, false
                    ));
        }
        else if(viewType == 1 ){
            Log.d("viewType", "create multi");
            return new MultipleQuestionAdapter(
                    LayoutInflater.from(parent.getContext()).inflate(
                            R.layout.multiple_question_view, parent, false
                    ));

        }
        Log.d("viewType", "create listening");
        return new ListeningAdapter(
                LayoutInflater.from(parent.getContext()).inflate(
                        R.layout.listening_view, parent, false
                ));
    }


    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        Log.d("RecyclerAdapter", "onBindViewHolder: ");
        if(getItemViewType(position) == 0) {
            FillQuestion question = (FillQuestion) questions.get(position);
            ((FillQuestionAdapter) holder).setQuestion(question);
        }
        else if(getItemViewType(position) == 1) {
            MultipleQuestion question = (MultipleQuestion) questions.get(position);
            ((MultipleQuestionAdapter) holder).setQuestion(question);
        }
        else if(getItemViewType(position) == 2) {
            Listening question = (Listening) questions.get(position);
            ((ListeningAdapter) holder).setQuestion(question);
        }

    }

    @Override
    public int getItemCount() {
        Log.d("RecyclerAdapter", "getItemCount: ");
        Log.d("RecyclerAdapter", String.valueOf(questions.size()));
        return questions.size();
    }


}
