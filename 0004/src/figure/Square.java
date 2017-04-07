package figure;

/**
 * Created by dem on 07.04.2017.
 */
public class Square {
    private Line line1;
    private Line line2;
    private Line line3;
    private Line line4;
    private int size;
    private double lenght;
    //private Color color;
public Square(Line line1, Line line2, Line line3, Line line4) {
    int[] corPointsLine1 = line1.getXY(line1);
    int[] corPointsLine2 = line2.getXY(line2);
    int[] corPointsLine3 = line3.getXY(line3);
    int[] corPointsLine4 = line4.getXY(line4);
    if (corPointsLine1[0] == corPointsLine2[0] && corPointsLine2[1] == corPointsLine3[1] && corPointsLine3[0] == corPointsLine4[0] && corPointsLine4[1] == corPointsLine1[1]) {
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
}