import java.util.Scanner;

// this class roughly simulates what the functionalities of an actual API might be
public class FakeAPI {
    private Scanner scanner = new Scanner(System.in);

    // imitates card detection and returning of corresponding customer data
    public Customer cardInsert() {
        Customer sampleCustomer = new Customer(1, 500, 1000, "Foo");
        scanner.nextLine();
        return sampleCustomer;
    }

    // imitates pin validation process
    public boolean validatePin() {
        String input = scanner.nextLine();
        return input.matches("[0-9]+") && input.length() == 4;
    }
}
