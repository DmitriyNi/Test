package src;

/**
 * Created by dem on 02.04.2017.
 */
public  class Observer
{
    private Display realObserver;

    public Observer(Display display)
    {
        this.realObserver = display;
    }
    public void changeValues(String codeButton)
    {
            realObserver.changeValues(codeButton);


    }
}
