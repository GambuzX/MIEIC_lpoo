public class GateNot extends LogicGate{
    private LogicVariable var;

    public GateNot(LogicVariable v1, LogicVariable v) throws Exception {
        internal = v1;
        var = v;
        calculate();
    }

    private void calculate() throws Exception {
        if (internal.getCalculatedBy() != null) throw new ColisionException();
        internal.setValue(!var.getValue());
        internal.setCalculatedBy(this);
        internal.setFormula( getFormula());
    }

    public void recalculate() {
        internal.setValue(!var.getValue());
    }

    public String getFormula() {
        return getSymbol() + "(" + var.getFormula() + ")";
    }

    @Override
    public LogicVariable[] getInputs() {
        return new LogicVariable[]{var};
    }

    @Override
    public String getSymbol() {
        return "NOT";
    }
}
