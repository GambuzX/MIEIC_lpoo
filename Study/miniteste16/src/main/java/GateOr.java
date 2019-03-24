public class GateOr extends LogicGate{
    private LogicVariable var1;
    private LogicVariable var2;

    public GateOr(LogicVariable v1, LogicVariable v2, LogicVariable v3) throws Exception {
        internal = v1;
        var1 = v2;
        var2 = v3;
        calculate();
    }

    private void calculate() throws Exception {
        if (internal.getCalculatedBy() != null) throw new ColisionException();
        internal.setValue(var1.getValue() || var2.getValue());
        internal.setCalculatedBy(this);
        internal.setFormula( getFormula());
    }

    public void recalculate() {
        internal.setValue(var1.getValue() || var2.getValue());
    }

    public String getFormula() {
        return getSymbol() + "(" + var1.getFormula() + "," + var2.getFormula() + ")";
    }

    @Override
    public LogicVariable[] getInputs() {
        return new LogicVariable[]{ var1, var2};
    }

    @Override
    public String getSymbol() {
        return "OR";
    }
}
