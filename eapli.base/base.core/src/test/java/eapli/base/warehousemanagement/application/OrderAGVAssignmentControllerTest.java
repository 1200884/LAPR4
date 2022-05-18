package eapli.base.warehousemanagement.application;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class OrderAGVAssignmentControllerTest {

    @Test
    void validateAnswer() {
        assertTrue(OrderAGVAssignmentController.validateAnswer("1"));
        assertTrue(OrderAGVAssignmentController.validateAnswer("2"));
        assertFalse(OrderAGVAssignmentController.validateAnswer("Yannick Djálo"));
        assertFalse(OrderAGVAssignmentController.validateAnswer("RDT!"));
    }

    @Test
    void isValidId() {
    }

    @Test
    void existsOrderId() {
    }
}