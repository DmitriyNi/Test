package src;

/**
 * Created by dem on 04.04.2017.
 */
public abstract class AbstractPult {
    private final static String CODE_BUTTON_OFF ="OFF" ;
    private final static String CODE_BUTTON_ON = "ON";
    private final static String CODE_BUTTON_VOLUME_UP="1V";
    private final static String CODE_BUTTON_VOLUME_DOWN="-1V";
    private final static String CODE_BUTTON_1="1";
    private final static String CODE_BUTTON_2="2";;
    public String codeButton;
    private Observer observer;

  //  public AbstractPult(Observer observer)
    {
        this.observer = observer;
    }
// Change 1 1
        
    public void notifyObserver(String codeButton)
    {
        this.observer.changeValues(codeButton);
    }


    public void pressButtonVolumeUp()
    {
        this.codeButton = CODE_BUTTON_VOLUME_UP;
        this.notifyObserver(codeButton);
    }
    public void pressButtonVolumeDown()
    {
        this.codeButton = CODE_BUTTON_VOLUME_DOWN;
        this.notifyObserver(codeButton);
    }
    public void pressButton1()
    {
        this.codeButton = CODE_BUTTON_1;
        this.notifyObserver(codeButton);
    }
    public void pressButton2()
    {
        this.codeButton = CODE_BUTTON_2;
        this.notifyObserver(codeButton);
    }

    public void someMetode() {}

    public void pressButtonModeOn()
    {
        this.codeButton = CODE_BUTTON_ON;
        this.notifyObserver(codeButton);
    }
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

