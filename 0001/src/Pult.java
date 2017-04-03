package src;

import src.Observer;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
/**
 * Created by dem on 02.04.2017.
 */
public class Pult implements IPult{
    private  final int CODE_BUTTON_VOLUME_UP=10;
    private  final int CODE_BUTTON_VOLUME_DOWN=11;
    private final int CODE_BUTTON_1=1;
    private final int CODE_BUTTON_2=2;;
    public int codeButton;
    private Observer observer;
    public Pult(Observer obs)
    {
        this.observer = new Observer();
    }
    public void notifyObserver(int codeButton)
    {
        this.observer.changeValues(codeButton);
    }
    @Override
    public void pressButtonVolumeUp(int CODE_BUTTON_VOLUME_UP)
    {
        this.codeButton = CODE_BUTTON_VOLUME_UP;
        this.notifyObserver(codeButton);
    }
    @Override
    public void pressButtonVolumeDown(int CODE_BUTON_BRIGHT_DOWN)
    {
        this.codeButton = CODE_BUTON_BRIGHT_DOWN;
        this.notifyObserver(codeButton);
    }
    @Override
    public void pressButton1(int CODE_BUTTON_1)
    {
        this.codeButton = CODE_BUTTON_1;
        this.notifyObserver(codeButton);
    }
    @Override
    public void pressButton2(int CODE_BUTTON_2)
    {
        this.codeButton = CODE_BUTTON_2;
        this.notifyObserver(codeButton);

    }
}



