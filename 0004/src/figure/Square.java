package figure;
import figure.Line;
import figure.Point;
import static org.eclipse.jdt.internal.compiler.codegen.ConstantPool.ValueOf;

/**
 * Created by dem on 07.04.2017.
 */
public class Square {
    public Line line1;
    public Line line2;
    public Line line3;
    public Line line4;
    public boolean angleTrue;
    public int size;
    public double lenght;
    public boolean exist;
    private boolean propertyesSquare1;
    private boolean propertyesSquare2;


    //private Color color;
public  Square(Point point1, Point point2, Point point3, Point point4)
    {
    this.line1 = new Line(point1,point2);
    this.line2 = new Line(point2,point3);
    this.line3 = new Line(point3,point4);
    this.line4 = new Line(point4,point1);
    angleTrue(line1,line2);
    propertyesSquare1();
    propertyesSquare2();
        if (propertyesSquare1 && propertyesSquare2 && angleTrue)
            {
                  System.out.println("Квадрат создан");
                  this.exist = true;
            }
        else
            {
                System.out.println("Квадрат не существует");
            }
    }
    public void angleTrue(Line line1, Line line2)
    {
        double A = line1.point2.getX()-line1.point1.getX();
        double B = line1.point2.getY()-line1.point1.getY();
        double C = line2.point2.getX()-line2.point1.getX();
        double D = line2.point2.getY()-line2.point1.getY();
        double vectorABBC = A * C + B * D;
            if (vectorABBC == 0)
            {
             this.angleTrue = true;
            }
            else System.out.println("не перпендикулярны");
    }
    public void propertyesSquare1()
    {
        //Проверка на свовпадение точек
        if (line1.point2.equals(line2.point1) && line2.point2.equals(line3.point1) && line3.point2.equals(line4.point1) && line4.point2.equals(line1.point1))
            {
            propertyesSquare1 = true;
            }
            else System.out.println("Точки квадрата не совпадают");
    }
    public void propertyesSquare2()
    { //Проверка равенства длин сторон

        if ( (line1.getDistanse() == line2.getDistanse()) && (line2.getDistanse() == line3.getDistanse()) && (line3.getDistanse() == line4.getDistanse()) && (line4.getDistanse() == line1.getDistanse()))

        {
            propertyesSquare2 = true;
        }
        else System.out.println("Стороны не равны");
    }

    public void setSize(int size)
    {

    }
    public   void expansion( double coef) {
        if (exist) {
            if ()
            this.line1.point2.x = this.line1.point2.x +this.line1.getDistanse()*coef;
            this.line1.point2.y = this.line1.point2.y +coef;
            this.line2.point2.x = this.line1.point2.x + coef;
            this.line2.point2.y = this.line1.point2.y + coef;
            this.line3.point2.x = this.line1.point2.x + coef;
            this.line3.point2.y = this.line1.point2.y + coef;
        } else {
            System.out.println("Квадрат не существует");
        }
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

}