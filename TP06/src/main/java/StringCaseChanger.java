public class StringCaseChanger implements StringTransformer {
    private StringDrink drink;

    public StringCaseChanger(StringDrink d) {
        drink = d;
    }
    public void execute() {
        StringBuffer newS = new StringBuffer(); //drink.getText());
        for (int i = 0; i < drink.getText().length(); i++) {
            char curr = drink.getText().charAt(i);
            if (Character.isLowerCase(curr)) curr -= 32;
            else if (Character.isUpperCase(curr)) curr += 32;
            newS.append(curr);
        }
        drink.setText(newS.toString());
    }
    public void undo() {
        execute();
    }
}
