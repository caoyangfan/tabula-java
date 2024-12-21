package technology.tabula.strategy;

public class Context {
    private Strategy strategy;

    public Context(Strategy strategy) {
        this.strategy = strategy;
    }

    public void algorithm(){
         strategy.algorithm();
    }

    public void setStrategy(Strategy strategy) {
        this.strategy = strategy;
    }
}
