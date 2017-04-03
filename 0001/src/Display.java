package src;

/**
 * Created by dem on 03.04.2017.
 */
public class Display implements IDisplay {
    private static int volume=10;
    private int bright=10;

    @Override
    public static void changeVolume() {
        volume +=1;
    }

    @Override
    public void changeBright() {

    }
}
