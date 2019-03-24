import java.util.ArrayList;
import java.util.List;

public class CombinatorialCircuit {
    List<LogicVariable> vars = new ArrayList<LogicVariable>();

    public boolean addVariable(LogicVariable var) {
        for (LogicVariable variable : vars)
            if (variable.getName() == var.getName())
                return false;
        vars.add(var);
        return true;
    }

    public LogicVariable getVariableByName(String name) {
        for (LogicVariable var : vars)
            if (var.getName() == name)
                return var;
        return null;
    }
}
