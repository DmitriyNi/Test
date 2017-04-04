package src;

/**
 * Created by dem on 04.04.2017.
 */
public class PultSony extends AbstractPult implements ISony
{

    /*  Увеличение натуральных значений громкости 1V -1V
        по тому же принципу яркость 1B -1 B
        переключение каналов 1 ..100
        Включение - ON/OFF
    */
    private final static String CODE_BUTTON_OFF ="OFF" ;
    private final static String CODE_BUTTON_ON = "ON";
    private final static String CODE_BUTTON_VOLUME_UP="1V";
    private final static String CODE_BUTTON_VOLUME_DOWN="-1V";
    private final static String CODE_BUTTON_1="1";
    private final static String CODE_BUTTON_2="2";;
    private final static String CODE_BUTON_DUBL_SCREEN = "DUBL SCREEN";
    public String codeButton;
    private Observer observer;

      public PultSony(Observer observer)
    {
        this.observer = observer;
    }
// Change 1

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
    public void pressButtonDublScreen()
    {
        this.codeButton =CODE_BUTON_DUBL_SCREEN;
        this.notifyObserver(codeButton);
    }
    public void setObserver(Observer observer)
    {
        this.observer = observer;
    }
}


