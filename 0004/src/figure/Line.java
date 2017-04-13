package figure;

import figure.Point;
/**
 * Created by dem on 07.04.2017.
 */
public class Line {
    private Point point1;
    private Point point2;

    public Line(Point point1, Point point2) {
        this.point1 = point1;
        this.point2 = point2;
    }

    public double getDistanse()
    {
        double length = Math.sqrt((point2.getX()-point1.getX())*(point2.getX()-point1.getX()) + (point2.getY() - point1.getY())*(point2.getY() - point1.getY()));


        return length;
    }
    public Point getPoint1()
    {

        return this.point1;
    }
    public Point getPoint2()
    {

        return this.point2;
    }
    /* public void expansion(Line line)
    {
        //int x = line.point1.getX(point1);
    }*/

}