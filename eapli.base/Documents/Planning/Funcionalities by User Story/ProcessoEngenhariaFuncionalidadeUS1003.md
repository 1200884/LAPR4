# US1003
=======================================


# 1. Requirements



**1003** As Sales Clerk, I want to register a new customer.

- Create a new customer as a Sales Clerk.

- This option is on the customer menu,and the customer is created only with valid information which is checked on its introduction

- No dependencies


# 2. Analysis

- 1. Concepts: Customers

- 2. Organization: The Customer UI gathers the necessary information to created the customer, the controller validates it, the service with the information gathered creates the customer itself, as the persist saves it.
    

- 3. Code excerpt to validate the name: 


    private boolean hasSpecialCharacters(String str) {
    String specialCharactersString = "!@#$%&*()'+,-./:;<=>?[]^_`{|}";
    for (int i = 0; i < str.length(); i++) {
    char ch = str.charAt(i);
    if (specialCharactersString.contains(Character.toString(ch))) {
    return true;
    } else if (i == str.length() - 1)
    return false;}
    return false;
    }

    
# 3. Design

## 3.1. Functionalities (SSD)

(On documents folder)
## 3.2. Class Diagram

(On documents folder)
## 3.3. Applied standards

The standard information gathering was made in a way which the information could be valid all the time, this is, if the Sales Clerk introduced invalid information he couldn't continue until the provided information was in accordance to the patterns defined by the team (ex: vat length is 9).

## 3.4. Tests 

No tests implemented yet.

# 4. Implementation

- The development of the User Story is in accordance with the Diagrams shown in the latter topic, which can be visible, mainly in the controller methods that validate the information.

- The relevant commits for this US were the ones made by João Gaspar, specially the commit "4fe3af4", which had a base of the US implementation with it being updated, and most importantly, enhanced in the next ones


# 5. Integration/ Documentation

This US was made with special precaution regarding the US of listing all customers, in order to check if the Customers were created successfully, which they were.

# 6. Observations

Although this is a functional US according to the orientation given, it doesn't solve conflits regarding information duplication such as the vat, which could be solved in a near future.
