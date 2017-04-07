/**
 * Created by dem on 02.04.2017.
 */

import display.DisplayHorizont;
import display.DisplaySony;
import display.IDisplay;
import pult.IPult;
import pult.IPultSony;
import pult.PultHorizont;
import pult.PultSony;
import util.Observer;

import java.util.ArrayList;
import java.util.List;

public class Runner
{
    public static void main(String[] args) {
        IDisplay displayHorizont = new DisplayHorizont(10, 10);
        IDisplay displaySony = new DisplaySony(15, 15);
        Observer observer = new Observer(displayHorizont);
        observer.setObserver(displaySony);
        IPult pultHorizont1 = new PultHorizont(observer);
        IPult pultHorizont2 = new PultHorizont(observer);
        IPult pultHorizont3 = new PultHorizont(observer);
        IPult pultSony1 = new PultSony(observer);
        IPult pultSony2 = new PultSony(observer);
        IPult pultSony3 = new PultSony(observer);
        List<IPult> listPult = new ArrayList();
        listPult.add(pultHorizont1);
        listPult.add(pultHorizont2);
        listPult.add(pultHorizont3);
        listPult.add(pultSony2);
        listPult.add(pultSony3);
        listPult.add(pultSony1);
        testForEveryPult(listPult);



    }
    public static void testForEveryPult(List<IPult> list)
    {
        for (IPult i: list)
        {
            if (i instanceof PultSony )
            {
                ((PultSony)i).pressButtonDublScreen();

            }
            i.pressButtonModeOn();
            i.pressButtonVolumeUp();
            i.pressButtonVolumeDown();
            i.pressButton1();
            i.pressButtonModeOff();
            i.pressButton2();

        }
}
    }
