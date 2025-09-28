import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        BasicOps basics = new BasicOps();
        AdvOps advs = new AdvOps();
        int choice;

        do {
            System.out.println("\nScientific Calculator Menu:");
            System.out.println("1. Add");
            System.out.println("2. Subtract");
            System.out.println("3. Multiply");
            System.out.println("4. Divide");
            System.out.println("5. Square Root");
            System.out.println("6. Factorial");
            System.out.println("7. Natural Log (ln)");
            System.out.println("8. Power");
            System.out.println("0. Exit");
            System.out.print("Enter your choice: ");
            choice = scanner.nextInt();

            double num1, num2;

            try {
                switch (choice) {
                    case 1:
                        System.out.print("Enter first number: ");
                        num1 = scanner.nextDouble();
                        System.out.print("Enter second number: ");
                        num2 = scanner.nextDouble();
                        System.out.println("Result: " + basics.add(num1, num2));
                        break;
                    case 2:
                        System.out.print("Enter first number: ");
                        num1 = scanner.nextDouble();
                        System.out.print("Enter second number: ");
                        num2 = scanner.nextDouble();
                        System.out.println("Result: " + basics.substract(num1, num2));
                        break;
                    case 3:
                        System.out.print("Enter first number: ");
                        num1 = scanner.nextDouble();
                        System.out.print("Enter second number: ");
                        num2 = scanner.nextDouble();
                        System.out.println("Result: " + basics.mul(num1, num2));
                        break;
                    case 4:
                        System.out.print("Enter dividend: ");
                        num1 = scanner.nextDouble();
                        System.out.print("Enter divisor: ");
                        num2 = scanner.nextDouble();
                        if (num2 == 0) {
                            System.out.println("Error: Division by zero is not allowed.");
                        } else {
                            System.out.println("Result: " + basics.div(num1, num2));
                        }
                        break;
                    case 5:
                        System.out.print("Enter a number: ");
                        num1 = scanner.nextDouble();
                        System.out.println("Result: " + advs.sqrt(num1));
                        break;
                    case 6:
                        System.out.print("Enter a number: ");
                        num1 = scanner.nextDouble();
                        System.out.println("Result: " + advs.factorial(num1));
                        break;
                    case 7:
                        System.out.print("Enter a number: ");
                        num1 = scanner.nextDouble();
                        System.out.println("Result: " + advs.ln(num1));
                        break;
                    case 8:
                        System.out.print("Enter the base: ");
                        num1 = scanner.nextDouble();
                        System.out.print("Enter the exponent: ");
                        num2 = scanner.nextDouble();
                        System.out.println("Result: " + advs.pow(num1, num2));
                        break;
                    case 0:
                        System.out.println("Exiting calculator. Goodbye!");
                        break;
                    default:
                        System.out.println("Invalid choice. Please try again.");
                }
            } catch (IllegalArgumentException e) {
                System.out.println("Error: " + e.getMessage());
            } catch (Exception e) {
                System.out.println("An unexpected error occurred. Please try again.");
                scanner.next(); // Clear the invalid input
            }

        } while (choice != 0);

        scanner.close();
    }
}
