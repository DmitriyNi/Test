package figure;

import java.awt.geom.Point2D;

/**
 * Created by dem on 07.04.2017.
 */
public class Line {
    private Point point1;
    private Point point2;
    private double length;

    public Line(Point point1, Point point2) {
        this.point1 = point1;
        this.point2 = point2;
    }
    public int[] getXY(Line line)
    {
        int[] cordinatsPoint = new int[3] ;
            cordinatsPoint[0] = line.point1.getX(point1);
            cordinatsPoint[1] = line.point1.getY(point1);
    return cordinatsPoint;
    }
    public double getDistanse(Point point, Point point2)
    {
        double length = Math.sqrt((point2.getX(point2)-point1.getX(point1))^2 + (point2.getY(point2) - point1.getY(point1))^2);
        double length2 = Point2D.distance(point1.getX(point1),point1.getY(point1),point2.getX(point2),point2.getY(point2));
        this.length = length;
        return length;
    }


}