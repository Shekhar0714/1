package SADP.Que7;

import java.util.Scanner;

public class FanDemo {
    public static void main(String[] args) {
        SimpleRemoteController remote=new SimpleRemoteController();
        Fan fan1=new Fan();
        
        while(true){
            System.out.println("Fan should be:");
            System.out.println("1. ON");
            System.out.println("2. OFF");
            System.out.println("3. UNDO");
            System.out.println("What is ur choice: ");
            Scanner sc=new Scanner(System.in);
            int choice=sc.nextInt();
            switch(choice){
                case 1: remote.setCommand(new FanOnCommand(fan1));
                        remote.buttonWasPressed();
                        break;
                case 2: remote.setCommand(new FanOffCommand(fan1));
                        remote.buttonWasPressed();
                        break;
                case 3: remote.setCommand(new Undo(fan1));
                        remote.buttonWasPressed();
                        break;
            }
       }
    }
    
}
