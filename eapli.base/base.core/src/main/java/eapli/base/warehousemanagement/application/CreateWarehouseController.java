package eapli.base.warehousemanagement.application;

import eapli.base.usermanagement.domain.BaseRoles;
import eapli.base.warehousemanagement.Domain.AGVDocks;
import eapli.base.warehousemanagement.Domain.Aisle;
import eapli.base.warehousemanagement.Domain.Row;
import eapli.framework.application.UseCaseController;
import eapli.framework.infrastructure.authz.application.AuthorizationService;
import eapli.framework.infrastructure.authz.application.AuthzRegistry;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Set;

@UseCaseController
public class CreateWarehouseController {
    private final AuthorizationService authz = AuthzRegistry.authorizationService();
    @Autowired
    private CreateWarehouseService cws=new CreateWarehouseService();

    public boolean createWarehouse(Long length, Long width, Long square, String unit, Set<Aisle> aisle, Set<AGVDocks> docks){
        authz.ensureAuthenticatedUserHasAnyOf(BaseRoles.WAREHOUSE_EMPLOYEE);
        cws.createWarehouse(length, width, square, unit,aisle,docks);
        return true;
    }
}
