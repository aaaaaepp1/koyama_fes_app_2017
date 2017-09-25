package koyama_fes_app_2017_nb;

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
            //マージされたらエラー消えるはずだけど消えなかったらゴメン
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


    //分けた意味ある？
    private void sortAnswerData(){
        if(TRACE) System.out.println("sortAnswerData : 開発中");

        this.quickSort(answerData);
        //answerData.sort(Comparator.comparing(Answer::getSt)); クイックじゃないしこんなコンパレータでちゃんと動くかわかんないので殴り書きしておく
    }


    /**
     * quickSort
     * @param list ソートしたいリスト
     * @return ソートされたリスト
     */
    private ArrayList<Answer> quickSort(ArrayList<Answer> list){
        if(TRACE) System.out.println("quickSort : 開発中");


        if(list.size() < 2) return list;

        ArrayList<Answer> smaller = new ArrayList<>();
        ArrayList<Answer> bigger = new ArrayList<>();
        ArrayList<Answer> result = new ArrayList<>();


        //軸の設定　else使いたくなかった・・・
        Long key;
        if(list.get(0).getSt().getTimeInMillis() > list.get(1).getSt().getTimeInMillis()) key = list.get(0).getSt().getTimeInMillis();
        else key = list.get(1).getSt().getTimeInMillis();


        //軸よりデカいかで振り分けます アルゴリの教科書では要素をスワップしてたけどコレクション大量生成しちゃうクソプログラムなのでこれでもよいかと
        for(Answer ans : list) {
            if(ans.getSt().getTimeInMillis() >= key) bigger.add(ans);
            else smaller.add(ans);
        }


        result.addAll(quickSort(smaller));
        result.addAll(quickSort(bigger));
        return result;
    }

}
