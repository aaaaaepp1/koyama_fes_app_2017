package koyamaFesAppJudge;

import com.sun.deploy.trace.Trace;

import java.io.*;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.HttpURLConnection;
import java.util.ArrayList;

public class NetworkControlManager {

    private final boolean DEBUG = false;
    private final boolean TRACE = true;

    private HttpURLConnection urlConnection;

    //コンストラクタ
    public NetworkControlManager(String uri) throws IOException{
        if(TRACE) System.out.println("NetworkControlManager : 開発中");

        this.setUri(uri);
    }


    public Boolean setUri(String uri) throws IOException{
        if(TRACE) System.out.println("setUri : 開発中");

        try {
            urlConnection = (HttpURLConnection) new URL(uri).openConnection();
        } catch(MalformedURLException e) { //new URL()で発生しうる例外 有効なプロトコルが見つからないor文字列を解析できない
            e.printStackTrace();
            return false;
        }

        //応答メッセージから状態コードを取得して200番だったら
        if(urlConnection.getResponseCode() == HttpURLConnection.HTTP_OK) {
            return true;
        }
        return false;
    }


    public AnswerManager getAnswer() throws IOException{
        if(TRACE) System.out.println("getAnswer : 開発中");

        ArrayList<String[]> list = new ArrayList<>();
        AnswerManager answerManager = new AnswerManager(list);
        try {
            BufferedReader in = new BufferedReader(new InputStreamReader(urlConnection.getInputStream()));
            //list = in.lines().map(s -> s.split(",")).collect(Collectors.toList()); ArrayListだから書けない
            in.lines().map(s -> s.split(",")).forEach(list::add);
        } catch(FileNotFoundException e) {
            e.printStackTrace();
        }

        //AnswerManagerのインスタンスのanswerDataを更新できてないけどきっとこれを使う人が.getAnswerData()(=ソート)してくれるだろう
        return answerManager;
    }
}