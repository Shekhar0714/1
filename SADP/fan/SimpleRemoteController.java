package SADP.Que7;

public class SimpleRemoteController {
    Command slot;
    public void setCommand(Command command1)
    {
        slot= command1;
    }
    public void buttonWasPressed()
    {
        slot.execute();
    }
}
