package src;

/**
 * Created by dem on 03.04.2017.
 */
public class Display implements IDisplay {
    private  int volume;
    private int brigth;
    private  boolean mode;

    public Display(int volume, int bright) {
        this.volume = volume;
        this.brigth = brigth;
        this.mode = false;
    }
    private  void displayOn()
    {
        this.mode = true;
        System.out.println("Телевизор включен");
    }
    @Override
    public  void changeValues(String codeTable) {
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
                }
            } else
                {
                this.displayOn();
                }

        }


    public  void displayOff()
    {
        this.mode = false;
        System.out.println("Телевизор выключен");
    }
}





