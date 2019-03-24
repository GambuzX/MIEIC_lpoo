import java.util.ArrayList;
import java.util.List;

public abstract class LogicGate {
    protected LogicVariable internal;

    public LogicVariable getOutput() {
        return internal;
    }

    public abstract String getSymbol();
    public abstract LogicVariable[] getInputs();
    public abstract String getFormula();
    public abstract void recalculate();

}
