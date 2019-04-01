public class HumanClient implements Client {

    private OrderingStrategy strategy;

    public HumanClient(OrderingStrategy strat) {
        strategy = strat;
    }

    @Override
    public void wants(StringRecipe recipe, StringBar bar) {
        strategy.wants(recipe, bar);
    }

    @Override
    public void happyHourStarted(Bar bar) {
        strategy.happyHourStarted((StringBar) bar);
    }

    @Override
    public void happyHourEnded(Bar bar) {

    }
}
