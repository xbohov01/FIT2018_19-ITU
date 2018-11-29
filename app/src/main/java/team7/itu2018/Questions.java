package team7.itu2018;

public class Questions {
    private String Question;
    private String AnswerA;
    private String AnswerB;
    private String AnswerC;
    private int RightAnswer;

    //constructor
    public Questions(String Question,String AnswerA,String AnswerB,String AnswerC,int RightAnswer){
        this.Question = Question;
        this.AnswerA = AnswerA;
        this.AnswerB = AnswerB;
        this.AnswerC = AnswerC;
        this.RightAnswer = RightAnswer;
    }

    //getter
    public String getQuestion(){return Question;}
    public String getAnswerA(){return AnswerA;}
    public String getAnswerB(){return AnswerB;}
    public String getAnswerC(){return AnswerC;}
    public int getRightAnswer(){return RightAnswer;}
}
