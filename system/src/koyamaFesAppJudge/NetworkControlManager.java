package koyamaFesAppJudge;

import com.sun.deploy.trace.Trace;

import java.io.*;
import java.net.URL;
import java.net.URLConnection;
import java.util.ArrayList;
import java.util.stream.Collectors;

public class NetworkControlManager {

    private final boolean DEBUG = false;
    private final boolean TRACE = true;

    private URLConnection urlConnection;
    private ArrayList<String[]> list;

    //コンストラクタ
    public NetworkControlManager(String uri) {
        if(TRACE) System.out.println("NetworkControlManager : 開発中");

        this.setUri(uri);
    }


    public Boolean setUri(String uri) {
        if(TRACE) System.out.println("setUri : 開発中");

        try {
            urlConnection = new URL(uri).openConnection();
        } catch(Exception e) {
            e.printStackTrace();
            return false;
        }
        return true;
    }


    public AnswerManager getAnswer() throws IOException{
        if(TRACE) System.out.println("getAnswer : 開発中");

        list = new ArrayList<>();
        AnswerManager answerManager = new AnswerManager(list);
        try {
            BufferedReader in = new BufferedReader(new InputStreamReader(urlConnection.getInputStream()));
            //list = in.lines().map(s -> s.split(",")).collect(Collectors.toList()); ArrayListだから書けない
            in.lines().map(s -> s.split(",")).forEach(list::add);
        } catch(FileNotFoundException e) {
            e.printStackTrace();
        }

        //AnswerManagerのインスタンスのanswerDataを更新できてないのでダメ
        return answerManager;
    }
}