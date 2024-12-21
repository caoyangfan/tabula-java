package technology.tabula.strategy;

public class Client {
    public static void main(String[] args) {
        Context context = new Context(new StrategyA());
        context.algorithm();
        context.setStrategy(new StrategyB());
        context.algorithm();
    }
}
