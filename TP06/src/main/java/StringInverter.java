public class StringInverter implements StringTransformer {

    private StringDrink drink;

    public StringInverter(StringDrink d) {
        drink = d;
    }
    public void execute() {
        StringBuffer newS = new StringBuffer(drink.getText());
        newS = newS.reverse();
        drink.setText(newS.toString());
    }
    public void undo() {
        execute();
    }
}
