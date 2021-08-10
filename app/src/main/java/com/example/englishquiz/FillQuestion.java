package com.example.englishquiz;

public class FillQuestion extends Question {



    public FillQuestion(int id, String type, String question, String correctIns, boolean yourAns) {
        super(id,type,question,correctIns,yourAns);
    }

    public FillQuestion(int id, String type, String question, String correctIns) {
        super(id,type,question,correctIns);
    }

}
