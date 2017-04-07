package figure;

import java.awt.geom.Point2D;

/**
 * Created by dem on 07.04.2017.
 */
public class Line {
    public Point point1;
    public Point point2;

    public Line(Point point1, Point point2) {
        this.point1 = point1;
        this.point2 = point2;
    }
    public double[] getXY()
    {
        double[] cordinatsPoint = new double[2] ;
            cordinatsPoint[0] = this.point1.getX();
            cordinatsPoint[1] = this.point1.getY();
    return cordinatsPoint;
    }
    public double getDistanse()
    {

        double length = Math.sqrt(Math.pow((this.point2.getX()-this.point1.getX()),2) + Math.pow((this.point2.getY() - this.point1.getY()),2));
        //double length2 = Point2D.distance(point1.getX(),point1.getY(),point2.getX(),point2.getY());

        return length;
    }
   /* public void expansion(Line line)
    {
        //int x = line.point1.getX(point1);
    }*/

}