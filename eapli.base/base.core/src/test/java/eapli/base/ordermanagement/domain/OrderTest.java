package eapli.base.ordermanagement.domain;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class OrderTest {
    static final int idlength = 9;

    @Test
    void isValidId() {
        int correct = 123456789;
        int correct1 = 987654321;
        String wrong = "Fernando Andrade";
        String wrong1 = "Cédric Soares";
        assertTrue(Order.isValidId(String.valueOf(correct)));
        assertTrue(Order.isValidId(String.valueOf(correct1)));
        assertFalse(Order.isValidId(wrong));
        assertFalse(Order.isValidId(wrong1));
    }

    @Test
    void generateId() {
        String k = Order.generateId();
        assertNotNull(k);
        for (int i = 1; i < 100; i++) {
            assertNotEquals(k.length(), idlength + i);
        }
        int kint = Integer.parseInt(k);


    }
}