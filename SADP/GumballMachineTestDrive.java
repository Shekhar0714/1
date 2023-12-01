//package GumballMachine;

//Main class
public class GumballMachineTestDrive {
 public static void main(String[] args) {
     GumballMachine gumballMachine = new GumballMachine(5);
     
     System.out.println(gumballMachine);
     
     gumballMachine.insertQuarter();
     gumballMachine.turnCrank();
     
     System.out.println(gumballMachine);
     
     gumballMachine.insertQuarter();
     gumballMachine.ejectQuarter();
     gumballMachine.turnCrank();
     
     System.out.println(gumballMachine);
     
     gumballMachine.insertQuarter();
     gumballMachine.turnCrank();
     gumballMachine.insertQuarter();
     gumballMachine.turnCrank();
     
     System.out.println(gumballMachine);
     
     gumballMachine.insertQuarter();
     gumballMachine.turnCrank();
     
     System.out.println(gumballMachine);
 }
}


//State interface
interface State {
 void insertQuarter();
 void ejectQuarter();
 void turnCrank();
 void dispense();
}

//Concrete State: NoQuarterState
class NoQuarterState implements State {
 private GumballMachine gumballMachine;
 
 public NoQuarterState(GumballMachine gumballMachine) {
     this.gumballMachine = gumballMachine;
 }
 
 public void insertQuarter() {
     System.out.println("You inserted a quarter.");
     gumballMachine.setState(gumballMachine.getHasQuarterState());
 }
 
 public void ejectQuarter() {
     System.out.println("You haven't inserted a quarter.");
 }
 
 public void turnCrank() {
     System.out.println("You turned, but there's no quarter.");
 }
 
 public void dispense() {
     System.out.println("You need to pay first.");
 }
 
 public String toString() {
     return "Waiting for quarter";
 }
}

//Concrete State: HasQuarterState
class HasQuarterState implements State {
 private GumballMachine gumballMachine;
 
 public HasQuarterState(GumballMachine gumballMachine) {
     this.gumballMachine = gumballMachine;
 }
 
 public void insertQuarter() {
     System.out.println("You can't insert another quarter.");
 }
 
 public void ejectQuarter() {
     System.out.println("Quarter returned.");
     gumballMachine.setState(gumballMachine.getNoQuarterState());
 }
 
 public void turnCrank() {
     System.out.println("You turned...");
     gumballMachine.setState(gumballMachine.getSoldState());
 }
 
 public void dispense() {
     System.out.println("No gumball dispensed.");
 }
 
 public String toString() {
     return "Waiting for turn of crank";
 }
}

//Concrete State: SoldState
class SoldState implements State {
 private GumballMachine gumballMachine;
 
 public SoldState(GumballMachine gumballMachine) {
     this.gumballMachine = gumballMachine;
 }
 
 public void insertQuarter() {
     System.out.println("Please wait, we're already giving you a gumball.");
 }
 
 public void ejectQuarter() {
     System.out.println("Sorry, you already turned the crank.");
 }
 
 public void turnCrank() {
     System.out.println("Turning twice doesn't get you another gumball!");
 }
 
 public void dispense() {
     gumballMachine.releaseGumball();
     if (gumballMachine.getCount() > 0) {
         gumballMachine.setState(gumballMachine.getNoQuarterState());
     } else {
         System.out.println("Oops, out of gumballs!");
         gumballMachine.setState(gumballMachine.getSoldOutState());
     }
 }
 
 public String toString() {
     return "Dispensing a gumball";
 }
}

//Concrete State: SoldOutState
class SoldOutState implements State {
 private GumballMachine gumballMachine;
 
 public SoldOutState(GumballMachine gumballMachine) {
     this.gumballMachine = gumballMachine;
 }
 
 public void insertQuarter() {
     System.out.println("Sorry, gumballs are sold out.");
 }
 
 public void ejectQuarter() {
     System.out.println("You can't eject, you haven't inserted a quarter yet.");
 }
 
 public void turnCrank() {
     System.out.println("You turned, but there are no gumballs.");
 }
 
 public void dispense() {
     System.out.println("No gumball dispensed.");
 }
 
 public String toString() {
     return "Sold out";
 }
}

//Gumball Machine class
class GumballMachine {
 private State soldOutState;
 private State noQuarterState;
 private State hasQuarterState;
 private State soldState;
 
 private State state;
 private int count = 0;
 
 public GumballMachine(int numberOfGumballs) {
     soldOutState = new SoldOutState(this);
     noQuarterState = new NoQuarterState(this);
     hasQuarterState = new HasQuarterState(this);
     soldState = new SoldState(this);
     
     this.count = numberOfGumballs;
     if (numberOfGumballs > 0) {
         state = noQuarterState;
     } else {
         state = soldOutState;
     }
 }
 
 public void insertQuarter() {
     state.insertQuarter();
 }
 
 public void ejectQuarter() {
     state.ejectQuarter();
 }
 
 public void turnCrank() {
     state.turnCrank();
     state.dispense();
 }
 
 void setState(State state) {
     this.state = state;
 }
 
 void releaseGumball() {
     System.out.println("A gumball comes rolling out the slot...");
     if (count != 0) {
         count--;
     }
 }
 
 int getCount() {
     return count;
 }
 
 State getSoldOutState() {
     return soldOutState;
 }
 
 State getNoQuarterState() {
     return noQuarterState;
 }
 
 State getHasQuarterState() {
     return hasQuarterState;
 }
 
 State getSoldState() {
     return soldState;
 }
 
 public String toString() {
     StringBuilder result = new StringBuilder();
     result.append("\nMighty Gumball, Inc.");
     result.append("\nJava-enabled Standing Gumball Model #2023");
     result.append("\nInventory: " + count + " gumball");
     if (count != 1) {
         result.append("s");
     }
     result.append("\n");
     result.append("Machine is " + state + "\n");
     return result.toString();
 }
}

