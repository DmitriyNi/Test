import figure.Line;
import figure.Point;
import figure.Square;

/**
 * Created by dem on 07.04.2017.
 */
public class Runner {
    public static void main(String[] args) {
        Point point1 = new Point(0,0);
        Point point2 = new Point(0,10);
        Point point3 = new Point(10,10);
        Point point4 = new Point(10,0);
        Square square = new Square(point1,point2,point3,point4);
        double s=square.getLine1().getDistanse();
        double s1 =square.getSquare();
        System.out.println(s);
        System.out.println(s1);
        square.anglea(180);
        System.out.println(square.getLine1().getPoint1().getX() + " "+square.getLine1().getPoint1().getY());
       //square.expansion( 2);
       Point centr = square.getCentr();
        System.out.println(centr.getX() + " " + centr.getY() );
        double t=square.getSquare();
        double r=square.getLine1().getDistanse();
        System.out.println(t+" "+r);
       // double s2=square.line1.getDistanse();
       // double s3 =square.getSquare();
       // System.out.println(s2 + " " + s3);
       /* double s1 = square.getSquare();
        System.out.println(s1);
        square.pressure(2);
        double s5 = square.getSquare();
        System.out.println(s5);*/

    }
}
