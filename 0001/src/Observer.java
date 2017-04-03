package src;

/**
 * Created by dem on 02.04.2017.
 */
public  class Observer {
    private Display display = new Display();
    public void changeValues(int values)
    {
        if (values == 1)
        {
            display.changeVolume(values);
        }
        if (values==-1)
        {
            display.changeVolume(values);
        }
    }
}
