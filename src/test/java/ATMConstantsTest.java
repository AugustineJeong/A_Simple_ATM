import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class ATMConstantsTest {
    @Test
    void greetUserByNameMessageTest() {
        String expectedString = "Hello, Foo!";
        assertEquals(expectedString, ATMConstants.greetUserByNameMessage("Foo"));
    }

    @Test
    void customerBalanceTest() {
        Customer customer = new Customer(1, 0, 50, "Foo");
        String expectedString = "Your balance is $ 50";
        assertEquals(expectedString, ATMConstants.customerBalance(customer));
    }

    @Test
    void depositCompletionMessageTest() {
        String expectedString = "Deposited $ 200 into your account. \n" +
                "Your new balance is: $ 700";
        assertEquals(expectedString, ATMConstants.depositCompletionMessage(200, 500));
    }

    @Test
    void withdrawCompletionMessageTest() {
        String expectedString = "Withdrew $ 100 from your account. \n" +
                "Your new balance is: $ 150";
        assertEquals(expectedString, ATMConstants.withdrawCompletionMessage(100, 250));
    }





}
