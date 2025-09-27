public class AdvOps {
    private final BasicOps basicOps = new BasicOps();

    public double sqrt(Number x) {
        double value = x.doubleValue();
        if (value < 0) {
            throw new IllegalArgumentException("Sqrt error: x must be non-negative");
        }
        return Math.sqrt(value);
    }

    public double factorial(Number x) {
        double value = x.doubleValue();
        if (value < 0) {
            throw new IllegalArgumentException("Factorial error: x must be non-negative");
        }
        if (value != Math.floor(value)) {
            throw new IllegalArgumentException("Factorial error: Factorials defined for integers only");
        }

        long n = (long) value;
        double result = 1.0;
        for (long i = 2; i <= n; i++) {
            result = basicOps.mul(result, i);
        }
        return result;
    }

    public double ln(Number x) {
        double value = x.doubleValue();
        if (value <= 0) {
            throw new IllegalArgumentException("Natural Log error: x must be positive");
        }
        return Math.log(value);
    }

    public double pow(Number x, Number b) {
        return Math.pow(x.doubleValue(), b.doubleValue());
    }
}
