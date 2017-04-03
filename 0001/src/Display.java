package src;

/**
 * Created by dem on 03.04.2017.
 */
public class Display implements IDisplay {
    private static int volume = 10;
    private int bright = 10;
    private static boolean mode;

    public Display() {
        this.volume = volume;
        this.mode = false;
    }
    private static void displayOn()
    {
        Display display = new Display();
        mode = true;
        System.out.println("Телевизор включен");
    }

    public static void changeValues(String codeTable) {
            if (mode == true) {
                switch (codeTable)
                {
                    case "10":
                        volume += 1;
                        System.out.println("Volume =" + volume);
                        break;
                    case "11":
                        volume += -1;
                        System.out.println("Volume=" + volume);
                        break;
                    case "1":
                        System.out.println("Показываем первый канал");
                        break;
                    case "2":
                        System.out.println("Показываем второй канал");
                        break;
                    case "666":
                        Display.displayOff();
                        break;
                }
            } else
                {
                Display.mode = true;
                Display.displayOn();
                }

        }


    public static void displayOff()
    {
        Display.mode = false;
        System.out.println("Телевизор выключен");
    }
}






