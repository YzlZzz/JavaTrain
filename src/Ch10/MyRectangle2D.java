package Ch10;

public class MyRectangle2D {
    public static void main(String[] args){
        MyRectangle2D r1 = new MyRectangle2D(2, 2, 5.5,4.9);
        System.out.println("r1 area is " + r1.getArea() + " and perimeter is " + r1.getPerimeter());

        System.out.println(r1.contains(3,3));
        System.out.println(r1.contains(new MyRectangle2D(4, 5, 10.5, 3.2)));
        System.out.println(r1.overlaps(new MyRectangle2D(3, 5, 2.3, 5.4)));
    }

    private double x;

    private double y;

    private double width;

    private double height;

    public MyRectangle2D (){
        x = 0;
        y = 0;
        width = 1;
        height = 1;
    }

    public MyRectangle2D(double x, double y, double width, double height){
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
    }

    public double getArea(){
        return width * height;
    }

    public double getPerimeter(){
        return 2 * (width + height);
    }

    public boolean contains(double x, double y){
        return Math.abs(this.x - x) < width / 2 && Math.abs(this.y - y) < height / 2;
    }

    public boolean contains(MyRectangle2D r){
        return Math.abs(this.x - r.x + (r.width / 2)) < this.width / 2 && Math.abs(this.y - r.y + (r.height / 2)) < height /2;
    }

    public boolean overlaps(MyRectangle2D r){
        return Math.abs(this.x - r.x) < (this.width + r.width) / 2 && Math.abs(this.x - r.x) < (this.height + r.height) / 2;
    }

}
