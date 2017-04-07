package figure;

import static org.eclipse.jdt.internal.compiler.codegen.ConstantPool.ValueOf;

/**
 * Created by dem on 07.04.2017.
 */
public class Square {
    public Line line1;
    public Line line2;
    public Line line3;
    public Line line4;
    public int size;
    public double lenght;

    //private Color color;
public  Square(Line line1, Line line2, Line line3, Line line4) {
    this.line1 = line1;
    this.line2 = line2;
    this.line3 = line3;
    this.line4 = line4;
    double x1Line1 = line1.point1.getX();
    double x2Line1 = line1.point2.getX();
    double y1Line2 = line2.point1.getY();
    double y2Line2 = line2.point2.getY();
    double x1Line3 = line3.point1.getX();
    double x2Line3 = line3.point2.getX();
    double y1Line4 = line4.point1.getY();
    double y2Line4 = line4.point2.getY();
        if (x1Line1 == x2Line1 && y1Line2==y2Line2 && x1Line3==x2Line3 && y1Line4==y2Line4 && !(x1Line1 == x1Line3) ) {
        System.out.println("Квадрат создан");
    }
        else
            {
            System.out.println("Квадрат не существует");
            }
}
    public void setSize(int size)
    {

    }
    public   void expansion( double coef)
    {
        this.line1.point2.x = this.line1.point2.x * coef;
        this.line1.point2.y = this.line1.point2.y * coef;
        this.line2.point2.x = this.line1.point2.x * coef;
        this.line2.point2.y = this.line1.point2.y * coef;
        this.line3.point2.x = this.line1.point2.x * coef;
        this.line3.point2.y = this.line1.point2.y * coef;
    }
    public   void pressure( double coef)
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
        double a = this.line1.getDistanse() * this.line1.getDistanse();
        return  a;
    }

}