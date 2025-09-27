public class Main{
    public static void main(String[] args) {
        System.out.println("Main class executed");
        BasicOps basics = new BasicOps();
        System.out.println("Adding numbers x = 10 and y = 20:");
        System.out.println(basics.add(10, 20));

        System.out.println("Subtracting numbers x = 10 and y = 20:");
        System.out.println(basics.substract(10, 20));

        System.out.println("Multiplying numbers x = 10 and y = 20:");
        System.out.println(basics.mul(10, 20));

        System.out.println("Dividing numbers x = 10 and y = 20:");
        System.out.println(basics.div(10, 20));

        System.out.println("Now performing Advanced operations\n");
        AdvOps advs = new AdvOps();

        
        System.out.println("Square root of x = 16:");
        System.out.println(advs.sqrt(16));

        System.out.println("Factorial of 5:");
        System.out.println(advs.factorial(5));

        System.out.println("Natural Log of 10:");
        System.out.println(advs.ln(10));

        System.out.println("Power of 2 to the power of 3:");
        System.out.println(advs.pow(2, 3));
    }
}