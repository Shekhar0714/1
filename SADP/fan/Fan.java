package SADP.Que7;

public class Fan {
    public static final int high=3, medium=2,low=1,off=0;
    int speed=2;
    public void undo()
    {
        if(speed ==3)
        {
            System.out.println("Current  Ceiling Fan on High State");
        }
        else if(speed ==2)
        {
            System.out.println("Current Ceeling Fan on Medium State");
        }
        else if(speed ==1)
        {
            System.out.println("Current Ceiling Fan On Low State");
        }


        System.out.println("After Undo Operation");
        if(speed == high)
        {
            speed--;
            System.out.println("Now Ceiling Fan is on Medium State");
        }
        else if(speed == medium)
        {
            speed--;
            System.out.println("Now Ceiling Fan is on Low State");
        }
        else if(speed == low)
        {
            speed--;
            System.out.println("Now Ceiling Fan is on Off State");
        }

    }

    public void on()
    {
        System.out.println("Fan is ON");
    }

    public void off()
    {
        System.out.println("Fan is OFF");
    }
    
}
