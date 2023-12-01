class factoryOS{
    public static void main(String[] args) {
        OSFactory osf=new OSFactory();
        OS o1=osf.getInt("open");
        o1.show();

        OS o2=osf.getInt("closed");
        o2.show();

        OS o3=osf.getInt(" ");
        o3.show();
    }
}

interface OS{
    void show();
}

class Android implements OS{
    public void show(){
        System.out.println("I am Android");
    }
}
class Ios implements OS{
    public void show(){
        System.out.println("I am Ios");
    }
}
class Windows implements OS{
    public void show(){
        System.out.println("I am Windows");
    }
}

class OSFactory{
    public OS getInt(String str){
        if(str.equalsIgnoreCase("open"))
            return new Android();
        else if(str.equalsIgnoreCase("closed"))
            return new Ios();
        else    
            return new Windows();        
    }
}

