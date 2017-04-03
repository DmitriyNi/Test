package src; /**
 * Created by dem on 02.04.2017.
 */

import src.Pult;

public class Runner
{
    public static void main(String[] args) {
        Pult pult = new Pult();
        Display display1 = new Display();
        pult.pressButtonVolumeUp();
        pult.pressButtonModeOn();
        pult.pressButton1();
        pult.pressButtonVolumeUp();
        pult.pressButtonVolumeUp();
        pult.pressButtonVolumeUp();
        Display display2 = new Display();
        pult.pressButtonVolumeUp();
        pult.pressButton2();
        pult.pressButtonVolumeDown();
        pult.pressButtonModeOff();


    }
}
