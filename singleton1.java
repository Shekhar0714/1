class EagerThread extends Thread{
    private static EagerThread ins=new EagerThread();

    private EagerThread(){
        System.out.println("Hello world");
    }

    public static EagerThread getIns(){
        return ins;
    }
}

public class singleton1{
    public static void main(String args){
        Thread t1=new Thread(new Runnable()
        {
            public void run(){
                EagerThread e1=EagerThread.getIns();
                System.out.println("Instance 1");
            }
        });
        Thread t2=new Thread(new Runnable()
        {
            public void run(){
                EagerThread e2=EagerThread.getIns();
                System.out.println("Instance 2");
            }
        });
        Thread t3=new Thread(new Runnable()
        {
            public void run(){
                EagerThread e3=EagerThread.getIns();
                System.out.println("Instance 3");
            }
        });
        t1.start();
        t2.start();
        t3.start();
    }
}