class FacadeDP{
    public static void main(String args[]) throws Exception{
        ShapeMaker s=new ShapeMaker();
        s.drawCircle();
        s.drawRectangle();
        s.drawSquare();
    }
}

interface Shape{
    void draw();
}

class Rectangle implements Shape{
    public void draw(){
        System.out.println("Shape::Rectangle");
    }
}

class Square implements Shape{
    public void draw(){
        System.out.println("Shape::Square");
    }
}

class Circle implements Shape{
    public void draw(){
        System.out.println("Shape::Circle");
    }
}

class ShapeMaker{
    private Shape circle;
    private Shape rectangle;
    private Shape square;

    public ShapeMaker(){
        circle=new Circle();
        rectangle=new Rectangle();
        square=new Square();
    }

    public void drawCircle(){
        circle.draw();
    }
    public void drawRectangle(){
        rectangle.draw();
    }
    public void drawSquare(){
        square.draw();
    }
}