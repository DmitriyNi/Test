package figure;

import figure.Point;
/**
 * Created by dem on 07.04.2017.
 */
public class Line {
    protected Point point1;
    protected Point point2;

    public Line(Point point1, Point point2) {
        this.point1 = point1;
        this.point2 = point2;
    }

    public double getDistanse()
    {

        double length = Math.sqrt((point2.x-point1.x)*(point2.x-point1.x) + (point2.y - point1.y)*(point2.y - point1.y));

        return length;
    }
   /* public void expansion(Line line)
    {
        //int x = line.point1.getX(point1);
    }*/

}