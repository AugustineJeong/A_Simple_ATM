import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class ATMTest {
    ATM atm;

    @BeforeEach
    void setup() {
        atm = new ATM(0);
    }

    @Test
    void increaseATMBalanceTest() {
        atm.increaseATMBalance(0);
        assertEquals(0, atm.getAtmBalance());
        atm.increaseATMBalance(30);
        assertEquals(30, atm.getAtmBalance());
        atm.increaseATMBalance(-10);
        assertEquals(20, atm.getAtmBalance());
        atm.increaseATMBalance(-30);
        assertEquals(-10, atm.getAtmBalance());
    }

    @Test
    void decreaseATMBalanceTest() {
        atm.decreaseATMBalance(0);
        assertEquals(0, atm.getAtmBalance());
        atm.decreaseATMBalance(50);
        assertEquals(-50, atm.getAtmBalance());
        atm.decreaseATMBalance(-20);
        assertEquals(-30, atm.getAtmBalance());
        atm.decreaseATMBalance(-100);
        assertEquals(70, atm.getAtmBalance());
    }
}
