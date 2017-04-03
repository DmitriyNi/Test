package src;

/**
 * Created by dem on 03.04.2017.
 */
public class Display {
    private static int volume=10;
    private int bright=10;

    public static void volumeUp() {
        volume += 1;
        System.out.println("volume ="+ volume);
    }
    public static void volumeDown()
    {
        volume+=-1;
        System.out.println("volume=" +volume);
    }
}
