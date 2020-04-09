package lab.mvc;

import java.util.HashMap;
import java.util.Map;

public class Model {
    private Map<Integer,Command> command = new HashMap<>();
    int i = 0;

    public void setCommand(Command command){
        this.command.put(++i, command);
    }

    public void start (int i){
        command.get(i).execute();
    }

}
