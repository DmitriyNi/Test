package src; /**
 * Created by dem on 02.04.2017.
 */

import src.com.pult.*;
import src.com.display.*;
import src.com.util.Observer;

public class Runner
{
    public static void main(String[] args) {
        IDisplay display1 = new DisplayHorizont(10,10);
        AbstractDisplay displaySony1 = new DisplaySony(100,10);
        Observer observer1 = new Observer(display1);
        observer1.setObserver(displaySony1);
        IPult pult = new PultHorizont(observer1);
        IPultSony pultSony = new PultSony(observer1);
        pult.pressButtonVolumeDown();
        pultSony.pressButtonDublScreen();
        pult.pressButtonVolumeDown();
        pult.pressButtonVolumeDown();
        pult.pressButton2();
        pultSony.pressButton2();
        pult.pressButtonModeOff();
        pultSony.pressButtonModeOff();
    }
}
