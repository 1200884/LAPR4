package eapli.base.customermanagement.application;

import eapli.base.customermanagement.application.CustomerController;
import eapli.base.customermanagement.domain.model.Billing_Address;
import eapli.base.customermanagement.domain.model.Delivering_Address;
import eapli.framework.domain.repositories.ConcurrencyException;
import eapli.framework.domain.repositories.IntegrityViolationException;
import eapli.framework.infrastructure.authz.domain.model.Role;
import eapli.framework.io.util.Console;
import eapli.framework.presentation.console.AbstractUI;
import org.springframework.expression.spel.ast.NullLiteral;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

import static java.sql.JDBCType.NULL;

public class RegisterCustomerUI extends AbstractUI {
    CustomerController customerController = new CustomerController();
    Scanner scanner = new Scanner(System.in);
    final String NULLSTRING = NULL.name();

    @Override
    protected boolean doShow() {

        Delivering_Address delivering_address1 = new Delivering_Address(NULL.name(), NULL.name());
        Billing_Address billing_address1 = new Billing_Address(NULL.name(), NULL.name());
        String gender = NULLSTRING, birthdate = NULLSTRING;
        int phonenumber, vat;
        String country1 = NULLSTRING, country = NULLSTRING, address = NULLSTRING, address1 = NULLSTRING;
        System.out.println("Here a new customer will be created");
        String username = Console.readLine("Name:");
        while (!customerController.validname(username)) {
            System.out.println("The name information was incorrect. Please enter a valid name with no numbers nor special characters.");
            username = Console.readLine("Name:");
        }
        System.out.println("VAT:");
        String vatstr = Console.readLine("VAT:");
        while (!customerController.validvat(vatstr)) {
            System.out.println("The vat information was incorrect. Please enter a valid vat with 9 digits.");
            vatstr = Console.readLine("VAT:");
        }
        vat = Integer.parseInt(vatstr);
        String phonenumberstr = Console.readLine("Phone Number:");
        while (!customerController.validphonenumber(phonenumberstr)) {
            System.out.println("The phone number information was incorrect. Please enter a phone number with 9 digits.");
            phonenumberstr = Console.readLine("Phone Number:");
        }
        phonenumber = Integer.parseInt(phonenumberstr);

        String email = Console.readLine("E-mail");
        while (!customerController.validemail(email)) {
            System.out.println("The email information was incorrect. Please enter a valid email");
            email = Console.readLine("E-mail");
        }
        int answer = Console.readInteger("The mandatory information was concluded, do you wish to add some optional information?\n1- Yes\n2- No");


        Billing_Address billing_address = new Billing_Address(NULL.name(), NULL.name());
        Delivering_Address delivering_address = new Delivering_Address(NULL.name(), NULL.name());

        if (answer == 2) {
            customerController.customerinformation(username, vat, phonenumber, email, NULLSTRING, NULLSTRING, NULLSTRING, NULLSTRING, NULLSTRING, NULLSTRING);
        }
        if (answer == 1) {
            int firstquestion = Console.readInteger("Do you want to add your birth date?\n1-Yes\n2-No");
            if (firstquestion == 1) {
                birthdate = Console.readLine("Birthdate:");
            }
            int secondquestion = Console.readInteger("Do you want to add your gender?\n1-Yes\n2-No");
            if (secondquestion == 1) {
                gender = Console.readLine("Gender:");
            }
            int thirdquestion = Console.readInteger("Do you want to add your delivering adress?\n1-Yes\n2-No");
            if (thirdquestion == 1) {
                country = Console.readLine("Country:");
                address = Console.readLine("Adress");
            }
            int fourthquestion = Console.readInteger("Do you want to add your billing address=\n1-Yes\n2-No");
            if (fourthquestion == 1) {
                country1 = Console.readLine("Country:");
                address1 = Console.readLine("Adress");
            }
            customerController.customerinformation(username, vat, phonenumber, email, country1, address1, country, address, birthdate, gender);


        }

    return false;}

    @Override
    public String headline() {
        return null;
    }
}
