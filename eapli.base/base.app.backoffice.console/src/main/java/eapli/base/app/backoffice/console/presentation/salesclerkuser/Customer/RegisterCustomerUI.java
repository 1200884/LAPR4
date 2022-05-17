package eapli.base.app.backoffice.console.presentation.salesclerkuser.Customer;

import eapli.base.customermanagement.application.CustomerController;
import eapli.framework.io.util.Console;
import eapli.framework.presentation.console.AbstractUI;

public class RegisterCustomerUI extends AbstractUI {
    CustomerController customerController = new CustomerController();

    @Override
    protected boolean doShow() {
        int phonenumber, vat;
        String NULLSTRING = "null";
        String country1 = NULLSTRING, country = NULLSTRING, address = NULLSTRING, address1 = NULLSTRING, gender = NULLSTRING, birthdate = NULLSTRING;
        String username = Console.readLine("Name:");
        while (!customerController.validName(username)) {
            System.out.println("The name information was incorrect. Please enter a valid name with no numbers nor special characters.");
            username = Console.readLine("Name:");
        }
        String vatstr = Console.readLine("VAT:");
        while (!CustomerController.validVAT(vatstr)) {
            System.out.println("The vat information was incorrect. Please enter a valid vat with 9 digits.");
            vatstr = Console.readLine("VAT:");
        }
        vat = Integer.parseInt(vatstr);
        String phonenumberstr = Console.readLine("Phone Number:");
        while (!customerController.validPhoneNumber(phonenumberstr)) {
            System.out.println("The phone number information was incorrect. Please enter a phone number with 9 digits.");
            phonenumberstr = Console.readLine("Phone Number:");
        }
        phonenumber = Integer.parseInt(phonenumberstr);

        String email = Console.readLine("E-mail");
        while (!CustomerController.validEmail(email)) {
            System.out.println("The email information was incorrect. Please enter a valid email");
            email = Console.readLine("E-mail");
        }
        int answer = Console.readInteger("The mandatory information was concluded, do you wish to add some optional information?\n1- Yes\n2- No");

        if (answer == 2) {
            customerController.customerInformation(username, vat, phonenumber, email, NULLSTRING, NULLSTRING, NULLSTRING, NULLSTRING, NULLSTRING, NULLSTRING);
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
          customerController.customerInformation(username, vat, phonenumber, email, country1, address1, country, address, birthdate, gender);
            System.out.println("Customer created successfully!");

        }

        return false;
    }

    @Override
    public String headline() {
        return "Here a new customer will be created";
    }
}
