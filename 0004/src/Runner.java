import figure.Line;
import figure.Point;
import figure.Square;

/**
 * Created by dem on 07.04.2017.
 */
public class Runner {
    public static void main(String[] args) {
        Point point1 = new Point(1000,1000);
        Point point2 = new Point(1000,1001);
        Point point3 = new Point(1001,1001);
        Point point4 = new Point(1001,1000);
        Square square = new Square(point1,point2,point3,point4);
        double s=square.line1.getDistanse();
        double s1 =square.getSquare();
        System.out.println(s);
        System.out.println(s1);
       square.expansion( 2);
        double s2=square.line1.getDistanse();
        double s3 =square.getSquare();
        System.out.println(s2 + " " + s3);
       /* double s1 = square.getSquare();
        System.out.println(s1);
        square.pressure(2);
        double s5 = square.getSquare();
        System.out.println(s5);*/

    }
}
