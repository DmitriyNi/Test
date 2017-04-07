import figure.Line;
import figure.Point;
import figure.Square;

/**
 * Created by dem on 07.04.2017.
 */
public class Runner {
    public static void main(String[] args) {
        Point point1 = new Point(0,0);
        Point point2 = new Point(0,5);
        Point point3 = new Point(5,5);
        Point point4 = new Point(5,0);
        Line line1 = new Line(point1,point2);
        Line line2 = new Line(point2,point3);
        Line line3 = new Line(point3,point4);
        Line line4 = new Line(point4,point1);
        Square square = new Square(line1,line2,line3,line4);
        double s=line1.getDistanse();
        double s2=line2.getDistanse();
        double s3=line3.getDistanse();
        double s4=line4.getDistanse();
        System.out.println(s + s2 +s3 + s4);
        System.out.println(s);
        square.expansion( 2);
        double s1 = square.getSquare();
        System.out.println(s1);
        square.pressure(2);
        double s5 = square.getSquare();
        System.out.println(s5);

    }
}
