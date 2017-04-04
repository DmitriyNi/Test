package src;

/**
 * Created by dem on 02.04.2017.
 */
public class Pult implements IPult{
    private final static String CODE_BUTTON_OFF ="666" ;
    private final static String CODE_BUTTON_ON = "777";
    private final static String CODE_BUTTON_VOLUME_UP="10";
    private final static String CODE_BUTTON_VOLUME_DOWN="11";
    private final static String CODE_BUTTON_1="1";
    private final static String CODE_BUTTON_2="2";;
    public String codeButton;
    private Observer observer;

    public Pult(Observer observer)
    {
        this.observer = observer;
    }
// Change 1

    public void notifyObserver(String codeButton)
    {
        this.observer.changeValues(codeButton);
    }

    @Override
    public void pressButtonVolumeUp()
    {
        this.codeButton = CODE_BUTTON_VOLUME_UP;
        this.notifyObserver(codeButton);
    }
    @Override
    public void pressButtonVolumeDown()
    {
        this.codeButton = CODE_BUTTON_VOLUME_DOWN;
        this.notifyObserver(codeButton);
    }
    @Override
    public void pressButton1()
    {
        this.codeButton = CODE_BUTTON_1;
        this.notifyObserver(codeButton);
    }
    @Override
    public void pressButton2()
    {
        this.codeButton = CODE_BUTTON_2;
        this.notifyObserver(codeButton);
    }
    @Override
    public void pressButtonModeOn()
    {
        this.codeButton = CODE_BUTTON_ON;
        this.notifyObserver(codeButton);
    }
    @Override
    public void pressButtonModeOff()
    {
        this.codeButton = CODE_BUTTON_OFF;
        this.notifyObserver(codeButton);
    }
    public void setObserver(Observer observer)
    {
        this.observer = observer;
    }
}



