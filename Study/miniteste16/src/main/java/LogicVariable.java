public class LogicVariable {

    private String name;
    private boolean value;

    private LogicGate calculatedBy;
    private String formula;

    public LogicVariable(String name) {
        this.name = name;
        this.value = false;
        calculatedBy = null;
        formula = name;
    }

    public LogicVariable(String name, boolean bool) {
        this.name = name;
        this.value = bool;
        calculatedBy = null;
        formula = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public boolean getValue() {
        if (calculatedBy != null)
            calculatedBy.recalculate();
        return value;
    }

    public void setValue(boolean bool) {
        this.value = bool;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null) return false;
        if (getClass() != o.getClass()) return false;

        LogicVariable obj = (LogicVariable) o;
        return name == obj.getName() && value == obj.getValue();
    }

    public LogicGate getCalculatedBy() {
        return calculatedBy;
    }

    public void setCalculatedBy(LogicGate gate) {
        calculatedBy = gate;
    }

    public String getFormula() {
        return formula;
    }

    public void setFormula(String newFormula) throws CycleException {
        if (newFormula.contains(name)) throw new CycleException();
        formula = newFormula;
    }
}
