package eapli.base.customermanagement.application;


import eapli.base.customermanagement.domain.model.Customer;
import eapli.base.usermanagement.domain.BaseRoles;
import eapli.framework.application.UseCaseController;
import eapli.framework.infrastructure.authz.application.AuthorizationService;
import eapli.framework.infrastructure.authz.application.AuthzRegistry;
import eapli.framework.infrastructure.authz.application.UserManagementService;
import eapli.framework.infrastructure.authz.domain.model.SystemUser;
import eapli.framework.infrastructure.authz.domain.model.Username;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.Optional;

@UseCaseController
public class ListCustomerController {
    private final AuthorizationService authz = AuthzRegistry.authorizationService();
    @Autowired
    private ListCustomerServices lcs;

    public Iterable<Customer> allCustomers() {
        authz.ensureAuthenticatedUserHasAnyOf(BaseRoles.SALES_CLERK);
        return lcs.allCustomers();
    }

}
