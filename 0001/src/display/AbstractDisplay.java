package display;

/**
 * Created by dem on 05.04.2017.
 */
public abstract class AbstractDisplay implements IDisplay {
    private  int volume;
    private int brigth;
    private  boolean mode;
    public AbstractDisplay(int volume, int brigth)
    {
        this.volume = volume;
        this.brigth = brigth;
        this.mode = false;
    }
    public void changeValues(String codeTable) {
        if (mode) {
            switch (codeTable)
             {
                case "1V":
                    volume += 1;
                    System.out.println("Volume =" + volume);
                    break;
                case "-1V":
                    volume += -1;
                    System.out.println("Volume=" + volume);
                    break;
                case "1":
                    System.out.println("Показываем первый канал");
                    break;
                case "2":
                    System.out.println("Показываем второй канал");
                    break;
                case "OFF":
                    this.displayOff();
                    break;
                default: realizeNewMetod(codeTable);
            }
        } else {
            this.displayOn();
        }
    }
    public abstract void  realizeNewMetod(String   codeTable);
    public void displayOn() {
        {
            this.mode = true;
            System.out.println("Телевизор включен");
        }
    }

    public void displayOff()
    {
        this.mode = false;
        System.out.println("Телевизор выключен");
    }

}



