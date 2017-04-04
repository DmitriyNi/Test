package src; /**
 * Created by dem on 02.04.2017.
 */

import src.Pult;

public class Runner
{
    public static void main(String[] args) {
        Display display1 = new Display(10,10);
        DisplaySony displaySony1 = new DisplaySony(100,10);
        Observer observer1 = new Observer(display1);
        observer1.setObserver(displaySony1);
        Pult pult = new Pult(observer1);
        PultSony pultSony = new PultSony(observer1);


        pult.pressButtonVolumeDown();
        pultSony.pressButtonDublScreen();
        pult.pressButtonVolumeDown();
        pultSony.pressButton2();
        pult.pressButtonModeOff();
    }
}
