package Ch9;

public class Rectangle {

    public static void main(String[] args){
        Rectangle a = new Rectangle(4,40);
        Rectangle b = new Rectangle(3.5, 35.9);

        System.out.printf("%-10s%-10s%-30s%-15s\n", "width", "height", "area", "perimeter");
        System.out.printf("%-10s%-10s%-30s%-15s\n", a.width, a.height, a.getArea(), a.getPerimeter());
        System.out.printf("%-10s%-10s%-30s%-15s\n", b.width, b.height, b.getArea(), b.getPerimeter());
    }

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
