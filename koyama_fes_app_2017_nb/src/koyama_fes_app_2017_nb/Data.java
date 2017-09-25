package koyama_fes_app_2017_nb;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

/**
 *
 * @author ushiohiroto
 */
public class Data {
    private final SimpleStringProperty answerNumber;
    private final SimpleStringProperty handleName;
    private final SimpleStringProperty questionNumber;
    private final SimpleStringProperty answerExample;

    Data(String aNum,String name,String qNum, String aExam) {
        this.answerNumber = new SimpleStringProperty(aNum);
        this.handleName = new SimpleStringProperty(name);
        this.questionNumber = new SimpleStringProperty(qNum);
        this.answerExample = new SimpleStringProperty(aExam);
    }

    public StringProperty answerNumberProperty(){
        return answerNumber;
    }

    public StringProperty handleNameProperty(){
        return handleName;
    }

    public StringProperty questionNumberProperty(){
        return questionNumber;
    }

    public StringProperty answerExampleProperty(){
        return answerExample;
    }



}
