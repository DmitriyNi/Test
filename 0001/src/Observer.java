package src;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by dem on 02.04.2017.
 */
public  class Observer
{
    private List<IDisplay> realObservers = new ArrayList(); // List<IDevice> как-то так нужно

    public Observer(IDisplay display)
    {
        setObserver(display);
    }
    public void setObserver(IDisplay display)
    {
        realObservers.add(display);
    }
    public void changeValues(String codeButton)
    {
        for (IDisplay i: realObservers)
        {
            i.changeValues(codeButton);
        }

    }
}
