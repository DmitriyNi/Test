package figure;
import figure.Line;
import figure.Point;

/**
 * Created by dem on 07.04.2017.
 */
public class Square {
    private Line line1;
    private Line line2;
    private Line line3;
    private Line line4;
    private Line radius;
    private double diagonalLength;
    private double radiusLength;
    private int size;
    private double lenght;
    private boolean exist;
    private Point centr;
    //private Color color;
public  Square(Point point1, Point point2, Point point3, Point point4)
    {
        boolean propertyesSquare1;
        boolean propertyesSquare2;
        boolean angleTrue;
        this.line1 = new Line(point1,point2);
        this.line2 = new Line(point2,point3);
        this.line3 = new Line(point3,point4);
        this.line4 = new Line(point4,point1);
        if (propertyesSquare1() && propertyesSquare2() && angleTrue(line1,line2))
            {
                  System.out.println("Квадрат создан");
                  this.exist = true;
            }
        else
            {
                System.out.println("Квадрат не существует");
            }
    }
    public boolean angleTrue(Line line1, Line line2)
    {
        double A = line1.getPoint2().getX()-line1.getPoint1().getX();
        double B = line1.getPoint2().getY()-line1.getPoint1().getY();
        double C = line2.getPoint2().getX()-line2.getPoint1().getX();
        double D = line2.getPoint2().getY()-line2.getPoint1().getY();
        double vectorABBC = A * C + B * D;
            if (vectorABBC == 0)
            {
             return true;

            }
            else System.out.println("не перпендикулярны");
            return false;
    }
    public boolean propertyesSquare1()
    {
        //Проверка на свовпадение точек
        if (line1.getPoint2().equals(line2.getPoint1()) && line2.getPoint2().equals(line3.getPoint1()) && line3.getPoint2().equals(line4.getPoint1()) && line4.getPoint2().equals(line1.getPoint1()))
            {
            return true;
            }
            else System.out.println("Точки квадрата не совпадают");
        return false;
    }
    public boolean propertyesSquare2()
    { //Проверка равенства длин сторон

        if ( (line1.getDistanse() == line2.getDistanse()) && (line2.getDistanse() == line3.getDistanse()) && (line3.getDistanse() == line4.getDistanse()) && (line4.getDistanse() == line1.getDistanse()))

        {
            return true;
        }
        else System.out.println("Стороны не равны");
        return false;
    }
    public Point searchCentr()
    {
        double x = (this.line1.getPoint1().getX()+this.line2.getPoint1().getX()+this.line3.getPoint1().getX()+this.line4.getPoint1().getX())/4;
        double y = (this.line1.getPoint1().getY()+this.line2.getPoint1().getY()+this.line3.getPoint1().getY()+this.line4.getPoint1().getY())/4;
        this.centr =new Point (x,y);
        return centr;
    }
    public Point getCentr()
    {

        return this.centr;
    }
    private double findRadiusLength()
    {

        this.radius = new Line(line1.getPoint1(),searchCentr());
        this.radiusLength = this.radius.getDistanse();
        return radiusLength;
    }
    public void anglea(double angle)
    {
        findRadiusLength();
        System.out.println(radiusLength);
        searchCentr();
        System.out.println(centr.getX()+" " +centr.getY());
        double x = this.radiusLength*Math.sin(angle);
        System.out.println(x);
        double y = this.radiusLength*Math.cos(angle);
        System.out.println(y);
        this.line1.getPoint1().setPointXY(x,y);
        double testX = this.line1.getPoint1().getX();
        double testY = this.line1.getPoint1().getX();
        System.out.println(testX + " " + testY);
        this.line2.getPoint1().setPointXY(x,y);
        this.line3.getPoint1().setPointXY(x,y);
        this.line4.getPoint1().setPointXY(x,y);

    }

    public void setSize(int size)
    {

    }
   /* public   void expansion( double coef) {
        if (exist) {

            this.line1.point2.x = this.line1.point2.x +this.line1.getDistanse()*coef;
            this.line1.point2.y = this.line1.point2.y +coef;
            this.line2.point2.x = this.line1.point2.x + coef;
            this.line2.point2.y = this.line1.point2.y + coef;
            this.line3.point2.x = this.line1.point2.x + coef;
            this.line3.point2.y = this.line1.point2.y + coef;
        } else {
            System.out.println("Квадрат не существует");
        }


    public   void pressure(double coef)
    {
        this.line1.point2.x = this.line1.point2.x / coef;
        this.line1.point2.y = this.line1.point2.y / coef;
        this.line2.point2.x = this.line1.point2.x / coef;
        this.line2.point2.y = this.line1.point2.y / coef;
        this.line3.point2.x = this.line1.point2.x / coef;
        this.line3.point2.y = this.line1.point2.y / coef;
    }
*/

    public double getSquare()
    {
        if(exist)
        {
            double a = this.line1.getDistanse() * this.line1.getDistanse();
            return a;
        }
        else
            System.out.println("Квадрат не существует");

        return 0;
    }
    public Line getLine1()
    {
        return this.line1;
    }
    public Line getLine2()
    {
        return this.line1;
    }
    public Line getLine3()
    {
        return this.line1;
    }
    public Line getLine4()
    {
        return this.line1;
    }

}