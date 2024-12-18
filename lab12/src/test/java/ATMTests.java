import org.junit.jupiter.api.Test;

import ua.ucu.edu.task1.*;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class ATMTests {

    @Test
    void testAmount() {
        ATM atm = new ATM();

        int totalMoney = atm.getMoney(1280);

        assertEquals(11, totalMoney);
    }

    @Test
    void testSingleDenomination() {
        Money money = new Money10(null);

        int totalMoney = money.receiveCoins(50);

        assertEquals(5, totalMoney);
    }

    @Test
    void testZeroAmount() {
        Money money = new Money10(null);

        int totalMoney = money.receiveCoins(0);

        assertEquals(0, totalMoney);
    }

    @Test
    void testInvalidAmount() {
        ATM atm = new ATM();

        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () -> {
            atm.getMoney(1285);
        });

        assertEquals("Can not give this amount", exception.getMessage());
    }
}
