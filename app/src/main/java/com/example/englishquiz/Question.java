package com.example.englishquiz;

import android.util.Log;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

public class Question {
    private int id;
    private String type;
    private String question;
    private String correctAns;
    private boolean checkAns;

    public String getCorrectAns() {
        return correctAns;
    }

    public void setCorrectAns(String correctAns) {
        this.correctAns = correctAns;
    }

    public boolean isCheckAns() {
        return checkAns;
    }

    public void setCheckAns(boolean checkAns) {
        this.checkAns = checkAns;
    }

    public Question(int id, String type, String question, String correctIns, boolean yourAns) {
        this.id = id;
        this.type = type;
        this.question = question;
        this.correctAns = correctIns;
        this.checkAns = yourAns;

    }
    public Question(int id,String type, String question, String correctIns) {
        this.id = id;
        this.type = type;
        this.question = question;
        this.correctAns = correctIns;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getQuestion() {
        return question;
    }

    public void setQuestion(String question) {
        this.question = question;
    }

    public String getCorrectIns() {
        return correctAns;
    }

    public void setCorrectIns(String correctIns) {
        this.correctAns = correctIns;
    }

    public static ArrayList<Question> Deserialize(String jsonFileString) throws JSONException {
        ArrayList<Question> listQuestion = new ArrayList<>();
        Log.i("data", jsonFileString);
        JSONArray array = new JSONArray(jsonFileString);

        for (int i = 0; i < array.length(); i++) {
            JSONObject question = array.getJSONObject(i);
            Log.i("data", "> Item " + i + "\n" + question);
            if (question.getString("type").equals("FillQuestion")) {
                Log.d("question", "Deserialize: Add FillQuestion");

                listQuestion.add((new FillQuestion(question.getInt("id"),
                        question.getString("type"),
                        question.getString("question"),
                        question.getString("correctAns")
                )));
            }
            else if (question.getString("type").equals("MultipleQuestion")) {
                Log.d("question", "Deserialize: Add MultipleQuestion");

                listQuestion.add((new MultipleQuestion(question.getInt("id"),
                        question.getString("type"),
                        question.getString("question"),
                        question.getString("answer1"),
                        question.getString("answer2"),
                        question.getString("answer3"),
                        question.getString("answer4"),
                        question.getString("correctAns")
                )));
            }

        }
        return listQuestion;
    }
}
