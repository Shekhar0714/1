class uppertolower {
     public static void main(String args[]) throws Exception{
        Word msg = new ChangeCase("JACK");
        System.out.println("word in UppperCase");
        msg.display();

        Word msgChange = new LowerCaseDecorator(new ChangeCase("JACK"));
         System.out.println("word after changing from UppperCase to lowerCase");
         msgChange.display();

    }
    
}
interface Word{
    void display();
}

class ChangeCase implements Word{
    String msg ="";

    ChangeCase() {
        this.msg = msg;
    }
    public ChangeCase(String msg){
        this.msg = msg;
    }
    public void display() {
    System.out.println("word: " + msg);
    }
    public String getLowerCase(){
        return msg.toLowerCase();
    }
}
abstract class WordDecorator implements Word{
    protected Word decoratWord;
    public WordDecorator(Word decoratWord){
        this.decoratWord = decoratWord;
    }

    public void display() {
        decoratWord.display();
    }
}
class LowerCaseDecorator extends WordDecorator{
    public LowerCaseDecorator(Word decoratWord){
        super(decoratWord);
    }

    public void display(){
        super.display();
        setLowerCase(decoratWord);
    }

    private void setLowerCase(Word decoratWord){
        if(decoratWord instanceof ChangeCase){
            ChangeCase changeCase = (ChangeCase) decoratWord;
            System.out.println("The word Change after implementing Decorator is " + changeCase.getLowerCase());
        }
    }
}


