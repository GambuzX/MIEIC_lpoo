import java.util.List;
import java.util.ArrayList;

public class SmartStrategy implements OrderingStrategy {

    List<StringRecipe> recipes = new ArrayList<StringRecipe>();

    @Override
    public void wants(StringRecipe recipe, StringBar bar) {
        if (bar.isHappyHour()) bar.order(recipe);
        else recipes.add(recipe);
    }

    @Override
    public void happyHourStarted(StringBar bar) {
        for(StringRecipe recipe : recipes)
            bar.order(recipe);
        recipes.clear();
    }

    @Override
    public void happyHourEnded(StringBar bar) {

    }
}
