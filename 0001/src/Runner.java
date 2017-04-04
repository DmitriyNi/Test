package src; /**
 * Created by dem on 02.04.2017.
 */

import src.Pult;

public class Runner
{
    public static void main(String[] args) {
        Display display1 = new Display(10,10);
        Observer observer1 = new Observer(display1);
        Pult pult = new Pult(observer1);
        pult.pressButtonVolumeUp();
        pult.pressButtonModeOn();
        pult.pressButton1();
        pult.pressButtonVolumeUp();
        pult.pressButtonVolumeUp();
        pult.pressButtonVolumeUp();
        Display display2 = new Display(100,11);
        observer1.setObserver(display2);
        pult.pressButtonVolumeUp();
        pult.pressButtonVolumeUp();
        pult.pressButton2();
        pult.pressButtonVolumeDown();
        pult.pressButtonModeOff();


    }
}
