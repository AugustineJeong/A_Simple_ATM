import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class CustomerTest {

    Customer customer1;
    Customer customer2;

    @BeforeEach
    void setup() {
        customer1 = new Customer(1, 100, 200, "Foo");
        customer2 = new Customer(2, 0, 0, "Bar");
    }

    @Test
    void getBalanceTest() {
        assertEquals(200, customer1.getBalance());
        assertEquals(0, customer2.getBalance());
    }

    @Test
    void getNameTest() {
        assertEquals("Foo", customer1.getName());
        assertEquals("Bar", customer2.getName());
    }

    @Test
    void depositTest() {
        customer1.deposit(50);
        assertEquals(250, customer1.getBalance());
        customer1.deposit(70);
        assertEquals(320, customer1.getBalance());
    }

    @Test
    void withdrawTest() {
        customer1.withdraw(10);
        assertEquals(190, customer1.getBalance());
        customer1.withdraw(100);
        assertEquals(90, customer1.getBalance());
    }

    @Test
    void exceedsWithdrawalLimitFalseTest() {
        assertFalse(customer1.exceedsWithdrawalLimit(0));
        assertFalse(customer1.exceedsWithdrawalLimit(50));
        assertFalse(customer1.exceedsWithdrawalLimit(100));
        assertFalse(customer2.exceedsWithdrawalLimit(0));
    }

    @Test
    void exceedsWithdrawalLimitTrueTest() {
        assertTrue(customer1.exceedsWithdrawalLimit(101));
        assertTrue(customer1.exceedsWithdrawalLimit(200));
        assertTrue(customer2.exceedsWithdrawalLimit(1));
        assertTrue(customer2.exceedsWithdrawalLimit(50));
    }

    @Test
    void exceedsAccountBalanceFalseTest() {
        assertFalse(customer1.exceedsAccountBalance(0));
        assertFalse(customer1.exceedsAccountBalance(100));
        assertFalse(customer1.exceedsAccountBalance(200));
        assertFalse(customer2.exceedsAccountBalance(0));
    }

    @Test
    void exceedsAccountBalanceTrueTest() {
        assertTrue(customer1.exceedsAccountBalance(201));
        assertTrue(customer1.exceedsAccountBalance(300));
        assertTrue(customer2.exceedsAccountBalance(1));
        assertTrue(customer2.exceedsAccountBalance(50));
    }


}
