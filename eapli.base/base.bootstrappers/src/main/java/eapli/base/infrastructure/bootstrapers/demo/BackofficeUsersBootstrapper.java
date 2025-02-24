/*
 * Copyright (c) 2013-2021 the original author or authors.
 *
 * MIT License
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy of this software and
 * associated documentation files (the "Software"), to deal in the Software without restriction,
 * including without limitation the rights to use, copy, modify, merge, publish, distribute,
 * sublicense, and/or sell copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in all copies or
 * substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR IMPLIED, INCLUDING BUT
 * NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY, FITNESS FOR A PARTICULAR PURPOSE AND
 * NONINFRINGEMENT. IN NO EVENT SHALL THE AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM,
 * DAMAGES OR OTHER LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE SOFTWARE.
 */
package eapli.base.infrastructure.bootstrapers.demo;

import java.util.HashSet;
import java.util.Set;

import eapli.base.infrastructure.bootstrapers.TestDataConstants;
import eapli.base.infrastructure.bootstrapers.UsersBootstrapperBase;
import eapli.base.usermanagement.domain.BaseRoles;
import eapli.framework.actions.Action;
import eapli.framework.infrastructure.authz.domain.model.Role;

/**
 * @author Paulo Gandra Sousa
 */
public class BackofficeUsersBootstrapper extends UsersBootstrapperBase implements Action {

    @SuppressWarnings("squid:S2068")
    private static final String PASSWORD1 = "Password1";

    @Override
    public boolean execute() {
        registerCustomer("customer", PASSWORD1, "Pierre", "Kalulu", "kalulu@emai.l.com");
        registerSalesManager("sales_manager", PASSWORD1, "Duvan", "Zapata", "Toco@emai.l.com");
        registerSalesClerk("sales_clerk",TestDataConstants.PASSWORD1,"Abilio","Maia","sirAbilio@gmail.com");
        registerWarehouseEmployee("warehouse_employee",PASSWORD1,"Kuku", "Fidelis","kuku@email.com");
        registerAGVManager("AGV_Manager",PASSWORD1,"Fernando", "Andrade","nandices@email.com");
        return true;
    }

    private void registerCustomer(final String username, final String password,
            final String firstName, final String lastName, final String email) {
        final Set<Role> roles = new HashSet<>();
        roles.add(BaseRoles.CUSTOMER);

        registerUser(username, password, firstName, lastName, email, roles);
    }
    private void registerWarehouseEmployee(final String username, final String password,final String firstName, final String lastName, final String email){
        final Set<Role> roles =new HashSet<>();
        roles.add(BaseRoles.WAREHOUSE_EMPLOYEE);
        registerUser(username,password,firstName,lastName,email,roles);
    }

    private void registerSalesManager(final String username, final String password,
            final String firstName, final String lastName, final String email) {
        final Set<Role> roles = new HashSet<>();
        roles.add(BaseRoles.SALES_MANAGER);

        registerUser(username, password, firstName, lastName, email, roles);
    }
    private void registerAGVManager(final String username, final String password,
                                     final String firstName, final String lastName, final String email) {
        final Set<Role> roles = new HashSet<>();
        roles.add(BaseRoles.AGV_MANAGER);

        registerUser(username, password, firstName, lastName, email, roles);
    }

    private void registerSalesClerk(final String username, final String password,
                                    final String firstName, final String lastName, final String email) {
        final Set<Role> roles = new HashSet<>();
        roles.add(BaseRoles.SALES_CLERK);

        registerUser(username, password, firstName, lastName, email, roles);
    }
}
