package koyamaFesAppJudge;

import java.util.ArrayList;

public class AnswerManager {

    private final boolean DEBUG = false;
    private final boolean TRACE = true;

    private ArrayList<String[]> rawCsvData;
    private ArrayList<Answer> answerData;

    public AnswerManager(ArrayList<String[]> csvData) {
        if(TRACE) System.out.println("AnswerManager : 開発中");

        this.setCsvData(csvData);
    }


    public void setCsvData(ArrayList<String[]> csvData) {
        if(TRACE) System.out.println("setCsvData : 開発中");

        rawCsvData = new ArrayList<>(csvData);
    }


    public ArrayList<Answer> getAnswerData() {
        if(TRACE) System.out.println("getAnswerData : 開発中");

        answerData = new ArrayList<>();
        for(int i = 1;i < rawCsvData.size();i++) {
            String[] oneData = rawCsvData.get(i);
            Answer oneAnswer = new Answer(oneData[0], new Integer(oneData[1]), oneData[2], new Long(oneData[3]), new Long(oneData[4]), new Integer(oneData[5]));
            answerData.add(oneAnswer);
        }
        /*
        answerData = rawCsvData.parallelStream() //頭わるわるstream版、どうせ後でソートするなら並列の方が速そう（こなみ n番目を弾くとかは苦手だよねこいつ
                               .filter(s -> s[1].equals("QN"))
                               .map(s -> new Answer(s[0], new Integer(s[1]), s[2], new Long(s[3]), new Long(s[4]), new Integer(s[5])))
                               .collect(Collectors.toList());
        */
        this.sortAnswerData();
        return answerData;
    }


    private void sortAnswerData(){
        if(TRACE) System.out.println("sortAnswerData : 開発中");

        //answerData.sort(Comparator.comparing(Answer::getSt)); クイックじゃないしこんなコンパレータでちゃんと動くかわかんないので殴り書きしておく
    }

}
