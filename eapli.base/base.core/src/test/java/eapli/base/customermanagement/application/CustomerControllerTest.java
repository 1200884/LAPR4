package eapli.base.customermanagement.application;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CustomerControllerTest {
    @Test
    void validName() {
        String falsse= "13";
        assertFalse(CustomerController.validName(falsse));
        String trulu="wu lei";
        assertTrue(CustomerController.validName(trulu));
    }

    @Test
    void validVAT() {
        String nome="alfredo";
        assertFalse(CustomerController.validVAT(nome));
        int number =123456789;
        String n1=Integer.toString(number);
        assertTrue(CustomerController.validVAT(n1));
    }

    @Test
    void validPhoneNumber() {

        String nome="alfredo";
        assertFalse(CustomerController.validPhoneNumber(nome));
        int number =123456789;
        String n1=Integer.toString(number);
        assertTrue(CustomerController.validPhoneNumber(n1));
    }

    @Test
    void validEmail() {
        String nome="alfredo";
        assertFalse(CustomerController.validEmail(nome));
        String name="alfredo@email.com";
        assertTrue(CustomerController.validEmail(name));
    }
}