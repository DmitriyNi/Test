package src;

import src.Observer;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
/**
 * Created by dem on 02.04.2017.
 */
public class Pult implements IPult{
    private  final int CODE_BUTTON_VOLUME_UP=1;
    private  final int CODE_BUTTON_VOLUME_DOWN=-1;
    private  final int CODE_BUTTON_BRIGHT_UP=2;
    private  final int CODE_BUTON_BRIGHT_DOWN=-2;
    public int codeButton;
    public void pressButtonUp(int values)
    {
        this.codeButton = values;
        notifyObserver();
    }
    public void notifyObserver()
    {

    }

    @Override
    public void pressButtonUp() {

    }

    @Override
    public void pressButtonDown() {

    }

    @Override
    public void pressButton1() {

    }

    @Override
    public void pressButton2() {

    }
}



