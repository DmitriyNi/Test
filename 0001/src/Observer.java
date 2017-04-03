package src;

/**
 * Created by dem on 02.04.2017.
 */
public  class Observer {
    private Display display = new Display();
    public void changeValues(Pult pult)
    {
        if (pult.codeButton == 1)
        {
            display.volumeUp();
        }
        if (pult.codeButton==-1)
        {
            display.volumeDown();
        }
    }
}
