package test1;

abstract class Shape {
    //计算面积
    public abstract Double square();

    //计算周长
    public  abstract Double circumference();
}

//长方形类
class Rectangle extends  Shape{
    private double r_long;
    private double r_width;

    public Rectangle() {

    }

    public double getR_long() {
        return r_long;
    }

    public void setR_long(double r_long) {
        this.r_long = r_long;
    }

    public double getR_width() {
        return r_width;
    }

    public void setR_width(double r_width) {
        this.r_width = r_width;
    }

    @Override
    public Double square() {
        return r_long * r_width;
    }

    @Override
    public Double circumference() {
        return 2*(r_long+r_width);
    }
}
//圆形
class Square extends Shape{
//    private double pi = 3.14;
    private double s_radius;

    public Square() {

    }

    public double getS_radius() {
        return s_radius;
    }

    public void setS_radius(double s_radius) {
        this.s_radius = s_radius;
    }

    @Override
    public Double square() {
        return 2 * Math.PI * s_radius;
    }

    @Override
    public Double circumference() {
        return Math.PI * s_radius * s_radius;
    }
}
class test{
    public static void main(String[] args) {
        Square square = new Square();
        Rectangle rectangle = new Rectangle();
        square.setS_radius(2);
        rectangle.setR_long(2);
        rectangle.setR_width(3);
//        System.out.println(square.square());//○的面积
//        System.out.println(square.circumference());//○的周长
        System.out.println(rectangle.circumference());//面积
        System.out.println(rectangle.square());//周长
    }
}
