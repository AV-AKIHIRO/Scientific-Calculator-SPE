public class BasicOps {
    public double add(Number a, Number b) {
        return a.doubleValue() + b.doubleValue();
    }

    public double substract(Number a, Number b) {
        return a.doubleValue() - b.doubleValue();
    }

    public double mul(Number a, Number b) {
        return a.doubleValue() * b.doubleValue();
    }

    public double div(Number a, Number b) {
        try {
            return a.doubleValue() / b.doubleValue();
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
            return 0.0;
        }
    }
}