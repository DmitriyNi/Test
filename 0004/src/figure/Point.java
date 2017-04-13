package figure;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by dem on 07.04.2017.
 */
public class Point {
    private double x;
    private double y;
    public Point(double x, double y)
    {
        this.x = x;
        this.y = y;
    }

    public double getX()
    {

        return this.x;
    }
    public double getY()
    {
        return this.y;
    }
    public void setPointXY(double x,double y)
    {
        this.x= this.x+x;
        this.y=this.y+y;
    }
}
