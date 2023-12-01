import java.io.*;
import java.util.*;

class AbstractFactory
{
    public static void main(String args[]) throws Exception
    {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        System.out.println("Enter choice Bank or Loan...");
        System.out.println("Enter 1 for Bank");
        System.out.println("Enter 2 for Loan");
        Scanner sc=new Scanner(System.in);
        int var;
        var=sc.nextInt();
        switch(var)
        {
            case 1:
                AbstractFactories bankFactory=FactoryCreator.getFactory("Bank");
                System.out.println("Enter Bank name:");
                String bNm=br.readLine();
                Bank b1=bankFactory.getBank(bNm);
                System.out.println("Your account for "+b1.getBankName()+" is created");
                break;
            case 2:
                AbstractFactories loanFactory=FactoryCreator.getFactory("Loan");
                System.out.println("Enter Loan name:");
                String lnm=br.readLine();
                Loan l1=loanFactory.getLoan(lnm);
                System.out.println("Enter the loan amount:");
                double loanAmount=Double.parseDouble(br.readLine());
                System.out.println("Enter interest rate:");
                double rate=Double.parseDouble(br.readLine());
                System.out.println("Enter the number of years:");
                int years=Integer.parseInt(br.readLine());
                l1.getInterestRate(rate);
                l1.calculateLoan(loanAmount,years);
                break;
        }        
    }
}

interface Bank{
    String getBankName();
}

class ICICIBank implements Bank{
    private final String Bankname;
    ICICIBank(){
        Bankname="ICICIBank";
    }
    public String getBankName(){
        return Bankname;
    }
}

class AxisBank implements Bank{
    private final String Bankname;
    AxisBank(){
        Bankname="AxisBank";
    }
    public String getBankName(){
        return Bankname;
    }
}

class KotakBank implements Bank{
    private final String Bankname;
    KotakBank(){
        Bankname="KotakBank";
    }
    public String getBankName(){
        return Bankname;
    }
}

abstract class Loan{
    protected Double rate;
    abstract void getInterestRate(Double rate);
    public void calculateLoan(Double loanamt,int year){
        Double EMI;
        int num;
        num=year*12;
        rate = rate /1200;
        
        EMI=((rate*Math.pow((1+rate),num))/((Math.pow((1+rate),num))-1))*loanamt;
        System.out.println("Your Monthly EMI is "+EMI+" for the amount "+loanamt+" you have borrowed");
    }
}
class HomeLoan extends Loan{
    public void getInterestRate(Double r){
        rate=r;
    }
}

class CarLoan extends Loan{
    public void getInterestRate(Double r){
        rate=r;
    }
}

class BikeLoan extends Loan{
    public void getInterestRate(Double r){
        rate=r;
    }
}
abstract class AbstractFactories{
    public abstract Bank getBank(String b);
    public abstract Loan getLoan(String l);
}
class BankFactory extends AbstractFactories{
    public Bank getBank(String b){

        if(b==null){
            return null;
        }
        else if(b.equalsIgnoreCase("ICICIBank")){
            return new ICICIBank();
        }
        else if(b.equalsIgnoreCase("AxisBank")){
            return new AxisBank();
        }
        else if(b.equalsIgnoreCase("KotakBank")){
            return new KotakBank();
        }
        return null;
    }
     public Loan getLoan(String loan)
    {
        return null;
    }
}

class LoanFactory extends AbstractFactories{
    public Bank getBank(String loan)
    {
        return null;
    }
    public Loan getLoan(String l){
        
        if(l==null){
            return null;
        }
        else if(l.equalsIgnoreCase("HomeLoan")){
            return new HomeLoan();
        }
        else if(l.equalsIgnoreCase("CarLoan")){
            return new CarLoan();
        }
        else if(l.equalsIgnoreCase("BikeLoan")){
            return new BikeLoan();
        }
        return null;
    }
   
}

class FactoryCreator{
    public static AbstractFactories getFactory(String choice){
        if(choice.equalsIgnoreCase("Bank")){
            return new BankFactory();
        }
        else if(choice.equalsIgnoreCase("Loan")){
            return new LoanFactory();
        }
        return null;
    }
}

  