package src;

/**
 * Created by dem on 02.04.2017.
 */
public  class Observer {

    public static void changeValues(Pult pult)
    {
        if (pult.codeButton == 1)
        {
            Display.volumeUp();
        }
        if (pult.codeButton==-1)
        {
            Display.volumeDown();
        }
    }
}
