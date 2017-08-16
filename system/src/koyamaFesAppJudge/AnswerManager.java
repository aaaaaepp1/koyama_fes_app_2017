package koyamaFesAppJudge;

import java.util.ArrayList;
import java.util.List;

public class AnswerManager {

    private final boolean DEBUG = false;
    private final boolean TRACE = true;

    private List<String[]> rawCsvData = new ArrayList<>();
    private List<Answer> answerData = new ArrayList<>();

    public AnswerManager(ArrayList<String[]> csvData) {
        if(TRACE) System.out.println("AnswerManager : 開発中");


    }


    public void setCsvData(ArrayList<String[]> csvData) {
        if(TRACE) System.out.println("setCsvData : 開発中");


    }

    public ArrayList<Answer> getAnswerData() {
        if(TRACE) System.out.println("getAnswerData : 開発中");


        return null;
    }

}
