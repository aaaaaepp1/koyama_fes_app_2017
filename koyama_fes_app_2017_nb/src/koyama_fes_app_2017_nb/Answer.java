package koyama_fes_app_2017_nb;

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


        return this.hn;
    }


    public Integer getQn() {


        return this.qn;
    }


    public String getAns() {


        return this.ans;
    }


    public Calendar getSt() {


        return this.st;
    }


    public Calendar getRt() {


        return this.rt;
    }


    public Integer getSn() {


        return this.sn;
    }
}
