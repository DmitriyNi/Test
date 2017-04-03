package src;

/**
 * Created by dem on 03.04.2017.
 */
public class Display {
    private int volume=10;
    private int bright=10;

    public void changeVolume(int value) {
        volume += value;
        System.out.println("volume ="+ volume);
    }
}
