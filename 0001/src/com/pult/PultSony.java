package src.com.pult;

import src.com.util.Observer;

/**
 * Created by dem on 04.04.2017.
 */
public class PultSony extends AbstractPult implements IPult,IPultSony {
    public PultSony(Observer observer)
    {
        super(observer);
    }
    private final static String CODE_BUTON_DUBL_SCREEN = "DUBL SCREEN";
    public void pressButtonDublScreen()
    {
        this.codeButton =CODE_BUTON_DUBL_SCREEN;
        this.notifyObserver(codeButton);
    }
}

