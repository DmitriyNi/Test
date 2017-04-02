import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
/**
 * Created by dem on 02.04.2017.
 */
public class Pult {
    privata Observer observer;// = new Obsever();
    private int volume;
    private  int bright;
    public Pult(int volume, int bright )
    {
        this.volume = volume;
        this.bright = bright;
    }

    public void setVolume(int volume)
    {
        this.volume = volume;
        notifyObserver();
    }
    public void setVolume(int volume)
    {
        this.bright = bright;
        notifyObserver();
    }
    public void notifyObserver()
    {
        valueChanges(this);
    }


}
