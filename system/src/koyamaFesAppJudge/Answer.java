package koyamaFesAppJudge;

import java.util.Calendar;

public class Answer {

    private final boolean DEBUG = false;
    private final boolean TRACE = true;

    private String hn;
    private Integer qn;
    private String ans;
    private Calendar st;
    private Calendar rt;
    private Integer sn;

    public Answer(String hn, Integer qn, String ans, Long stUt, Long rtUt, Integer num) {
        if(TRACE) System.out.println("Answer : 開発中");

        this.hn = hn;
        this.qn = qn;
        this.ans = ans;
        st = Calendar.getInstance();
        st.setTimeInMillis(stUt);
        rt = Calendar.getInstance();
        rt.setTimeInMillis(rtUt);
        sn = num;
    }


    public String getHn() {
        if(TRACE) System.out.println("getHn : 開発中");


        return this.hn;
    }


    public Integer getQn() {
        if(TRACE) System.out.println("getQn : 開発中");


        return this.qn;
    }


    public String getAns() {
        if(TRACE) System.out.println("getAns : 開発中");


        return this.ans;
    }


    public Calendar getSt() {
        if(TRACE) System.out.println("getSt : 開発中");


        return this.st;
    }


    public Calendar getRt() {
        if(TRACE) System.out.println("getRt : 開発中");


        return this.rt;
    }


    public Integer getSn() {
        if(TRACE) System.out.println("getSn : 開発中");


        return this.sn;
    }
}
