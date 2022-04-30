package eapli.base.customermanagement.application;

import eapli.framework.application.UseCaseController;

@UseCaseController
public class CustomerController {

    CustomerRegisterService customerRegisterService = new CustomerRegisterService();
    private final int NAMEMAXLENGTH = 40;
    private final int VATLENGHT = 9;
    private final int PHONENUMBERLENGTH = 9;
    private final int EMAILMAXLENGTH = 30;


    public void customerinformation(String nome, int vat, int phonenumber, String email, String billingadresscountry, String billingadressadress, String delivering_addresscountry, String delivering_adressadress, String birth, String gender) {
        System.out.println("27 customer controller");
        customerRegisterService.registerCustomer(nome, vat, phonenumber, email, billingadresscountry, billingadressadress, delivering_addresscountry, delivering_adressadress, birth, gender);
    }

    public boolean validname(String name) {
        if (hasnumbers(name) || hasspecialcharacters(name)) {
            return false;
        } else {
            return name.length() < NAMEMAXLENGTH;
        }
    }

    public boolean validvat(String vat) {
        return length(vat, VATLENGHT);
    }

    public boolean validphonenumber(String phonenumber) {
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

    public boolean validemail(String email) {
        if (email.length() > EMAILMAXLENGTH) {
            return false;
        }
        return email.contains("@") && email.contains(".");
    }

    private boolean hasspecialcharacters(String str) {
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

    private boolean hasnumbers(String str) {
        for (int i = 0; i < str.length(); i++) {
            if (str.charAt(i) <= '0' && str.charAt(i) >= '9') {
                return true;
            }
        }
        return false;
    }
}
