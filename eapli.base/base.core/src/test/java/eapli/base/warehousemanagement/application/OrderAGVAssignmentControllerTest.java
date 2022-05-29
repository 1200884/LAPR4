package eapli.base.warehousemanagement.application;

import eapli.base.AGVmanagement.AGV.domain.AGV;
import eapli.base.AGVmanagement.AGV.domain.Status;
import eapli.base.modelmanagement.Model.domain.Model;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class OrderAGVAssignmentControllerTest {

    @Test
    void validateAnswer() {
        assertTrue(OrderAGVAssignmentController.validateAnswer("1"));
        assertTrue(OrderAGVAssignmentController.validateAnswer("2"));
        assertFalse(OrderAGVAssignmentController.validateAnswer("Fernando"));
        assertFalse(OrderAGVAssignmentController.validateAnswer("RDT!"));
    }

    @Test
    void isValidId() {
        assertFalse(OrderAGVAssignmentController.isValidId("123"));
        assertTrue(OrderAGVAssignmentController.isValidId("123456789"));
        assertFalse(OrderAGVAssignmentController.isValidId("Cédric"));
        assertTrue(OrderAGVAssignmentController.isValidId("987654321"));

    }

    @Test
    void existsOrderId() {
    }
    @Test
    void randomisetasktime(){
        assertNotEquals(OrderAGVAssignmentController.randomizetasktime(),6);
    }
}