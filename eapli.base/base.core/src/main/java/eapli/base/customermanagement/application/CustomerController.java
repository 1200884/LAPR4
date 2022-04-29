package eapli.base.customermanagement.application;

import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import eapli.base.customermanagement.domain.model.Billing_Address;
import eapli.base.customermanagement.domain.model.Customer;
import eapli.base.customermanagement.domain.model.Delivering_Address;
import eapli.framework.infrastructure.authz.application.AuthorizationService;
import eapli.framework.infrastructure.authz.application.AuthzRegistry;

import static javax.persistence.Persistence.createEntityManagerFactory;

public class CustomerController {
    private final AuthorizationService authz = AuthzRegistry.authorizationService();
    CustomerPersist customerPersist = new CustomerPersist();
    CustomerRegisterService customerRegisterService=new CustomerRegisterService();
    final int NAMEMAXLENGTH = 40;
    final int VATLENGHT = 9;
    final int PHONENUMBERLENGTH = 9;
    final int EMAILMAXLENGTH = 30;



    public void customerinformation(String nome, int vat, int phonenumber, String email, String billingadresscountry, String billingadressadress, String delivering_addresscountry, String delivering_adressadress, String birth, String gender) {
        customerRegisterService.registerCustomer(nome, vat, phonenumber, email, billingadresscountry, billingadressadress, delivering_addresscountry, delivering_adressadress, birth, gender);
    }

    public boolean validname(String name) {
        return name.length() <= NAMEMAXLENGTH && !hasspecialcharacters(name) && !hasnumbers(name);
    }
    public boolean validvat(String vat) {
        if (vat.length() != VATLENGHT) {
            return false;
        }
        for (int i = 0; i < VATLENGHT; i++) {
            if (!(vat.charAt(i) <= '9' && vat.charAt(i) >= '0')) {
                return false;
            }
        }
        return true;
    }

    public boolean validphonenumber(String phonenumber) {
        if (phonenumber.length() != PHONENUMBERLENGTH) {
            return false;
        }
        for (int i = 0; i < PHONENUMBERLENGTH; i++) {
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
        String regex = "[^a-zA-Z0-9]+";
        Pattern p = Pattern.compile(regex);
        Matcher m = p.matcher(str);
        return m.matches();
    }

    private boolean hasnumbers(String str) {
        for (int i = 0; i < str.length(); i++) {
            if (str.charAt(i) <= '0' && str.charAt(i) >= '9') {
                return false;
            }
        }
        return true;
    }
}
