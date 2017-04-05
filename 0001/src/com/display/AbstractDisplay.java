package src.com.display;

/**
 * Created by dem on 05.04.2017.
 */
public abstract class AbstractDisplay {
    private  int volume;
    private int brigth;
    private  boolean mode;
     public abstract void changeValues(String codeTable);

    public abstract void displayOn();
    public  abstract void displayOff();

}
