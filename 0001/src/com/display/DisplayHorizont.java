package src.com.display;

/**
 * Created by dem on 03.04.2017.
 */
public class DisplayHorizont extends AbstractDisplay implements IDisplay {
    private int volume;
    private int brigth;
    private boolean mode;

    public DisplayHorizont(int volume, int bright) {
      super(volume,bright);
    }

    @Override
    public void realizeNewMetod(String codeTable) {
        System.out.println("Функция не подерживается");
    }
}







