package Ch13;


public class ComparableCircle extends Circle implements Comparable<GeometricObject> {
    public static void main(String[] args) {
        ComparableCircle a = new ComparableCircle(2.5);
        ComparableCircle b = new ComparableCircle(5.5);

        System.out.println(a.compareTo(b));

        Rectangle c = new Rectangle(3, 5);
        System.out.println(a.compareTo(c));
    }

    public ComparableCircle(double radius){
        super(radius);
    }

    public int compareTo(ComparableCircle o){
        if(getArea() > o.getArea())
            return 1;
        else if (getArea() < o.getArea())
            return -1;
        else
            return 0;
    }



    public int compareTo(GeometricObject o) {
        if(getArea() > o.getArea())
            return 1;
        else if(getArea() < o.getArea())
            return -1;
        else return 0;
    }
}

class Circle{
    private double radius;

    public Circle(){
        this(0);
    }

    public Circle(double radius){
        this.radius = radius;
    }

    public double getRadius() {
        return radius;
    }

    public void setRadius(double radius) {
        this.radius = radius;
    }

    public double getArea(){
        return Math.PI * radius * radius;
    }

    public double getPerimeter(){
        return 2 * Math.PI * radius;
    }
}

class Rectangle extends GeometricObject{
    private double width = 1;
    private double height = 1;


    public Rectangle(){}

    public Rectangle(double width, double height){
        this.width = width;
        this.height = height;
    }

    public double getArea(){
        return width * height;
    }

    public double getPerimeter(){
        return 2 * ( width + height);
    }
}