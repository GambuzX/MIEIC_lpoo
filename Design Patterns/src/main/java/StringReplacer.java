public class StringReplacer implements StringTransformer {

    private StringDrink drink;
    private char oldC, newC;

    public StringReplacer(StringDrink d, char o, char n) {
        drink = d;
        oldC = o;
        newC = n;
    }
    public void execute() {
        StringBuffer newS = new StringBuffer();
        for (int i = 0; i < drink.getText().length(); i++) {
            char curr = drink.getText().charAt(i);
            if (curr == oldC) newS.append(newC);
            else newS.append(curr);
        }
        drink.setText(newS.toString());
    }

    public void undo() {
        StringBuffer newS = new StringBuffer();
        for (int i = 0; i < drink.getText().length(); i++) {
            char curr = drink.getText().charAt(i);
            if (curr == newC) newS.append(oldC);
            else newS.append(curr);
        }
        drink.setText(newS.toString());
    }
}
