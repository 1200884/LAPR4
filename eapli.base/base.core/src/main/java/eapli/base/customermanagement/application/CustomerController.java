package eapli.base.customermanagement.application;

import eapli.framework.application.UseCaseController;

@UseCaseController
public class CustomerController {

    CustomerRegisterService customerRegisterService = new CustomerRegisterService();
    private final static int NAMEMAXLENGTH = 40;
    private final static int VATLENGHT = 9;
    private final static int PHONENUMBERLENGTH = 9;
    private final static int EMAILMAXLENGTH = 30;


    public void customerInformation(String nome, int vat, int phonenumber, String email, String billingadresscountry, String billingadressadress, String delivering_addresscountry, String delivering_adressadress, String birth, String gender) {
        customerRegisterService.registerCustomer(nome, vat, phonenumber, email, billingadresscountry, billingadressadress, delivering_addresscountry, delivering_adressadress, birth, gender);
    }

    public boolean validName(String name) {
        if (hasNumbers(name) || hasSpecialCharacters(name)) {
            return false;
        } else {
            return name.length() < NAMEMAXLENGTH;
        }
    }

    public boolean validVAT(String vat) {
        return length(vat, VATLENGHT);
    }

    public boolean validPhoneNumber(String phonenumber) {
        return length(phonenumber, PHONENUMBERLENGTH);
    }

    private boolean length(String phonenumber, int length) {
        if (phonenumber.length() != length) {
            return false;
        }
        for (int i = 0; i < length; i++) {
            if (!(phonenumber.charAt(i) <= '9' && phonenumber.charAt(i) >= '0')) {
                return false;
            }
        }
        return true;
    }

    public boolean validEmail(String email) {
        if (email.length() > EMAILMAXLENGTH) {
            return false;
        }
        return email.contains("@") && email.contains(".");
    }

    private boolean hasSpecialCharacters(String str) {
        String specialCharactersString = "!@#$%&*()'+,-./:;<=>?[]^_`{|}";
        for (int i = 0; i < str.length(); i++) {
            char ch = str.charAt(i);
            if (specialCharactersString.contains(Character.toString(ch))) {
                return true;
            } else if (i == str.length() - 1)
                return false;

        }
        return false;
    }

    private boolean hasNumbers(String str) {
        for (int i = 0; i < str.length(); i++) {
            if (str.charAt(i) <= '0' && str.charAt(i) >= '9') {
                return true;
            }
        }
        return false;
    }
}
