package display;

/**
 * Created by dem on 04.04.2017.
 */
public class DisplaySony extends AbstractDisplay implements IDisplay {
    private int volume;
    private int brigth;
    private boolean mode;

    public DisplaySony(int volume, int brigth) {
        super(volume,brigth);
    }

    @Override
    public void realizeNewMetod(String codeTable) {
        switch (codeTable) {
            case "DUBL SCREEN":
                System.out.println("Картинка в картинке. Круто!");
        }
    }
}




