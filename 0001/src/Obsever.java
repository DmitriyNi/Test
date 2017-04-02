/**
 * Created by dem on 02.04.2017.
 */
public class Obsever {

    TV tv = new TV();
    Pult pult = new Pult();
    public void reactionInChange()
    {
        state = pult.getState();
        tv.setCommand(new Command(state));
    }
}
