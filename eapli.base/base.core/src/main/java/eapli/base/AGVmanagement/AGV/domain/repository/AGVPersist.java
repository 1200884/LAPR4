package eapli.base.AGVmanagement.AGV.domain.repository;

import eapli.base.AGVmanagement.AGV.domain.AGV;
import eapli.base.brandmanagement.domain.Brand;
import eapli.base.infrastructure.persistence.PersistenceContext;
import eapli.base.modelmanagement.Model.domain.Model;
import eapli.base.modelmanagement.Model.domain.repositories.ModelRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;

public class AGVPersist {

    @Autowired
    private static AGVRepository agvRepository = PersistenceContext.repositories().AGVs();

    @Autowired
    private static ModelRepository modelRepository = PersistenceContext.repositories().models();

    public AGV createAGVPersist(AGV agv) {
        Model model=null;
        for(Model m : (modelRepository.findAll())){
            if(m.getName().equals(agv.getModel().getName())){
                model = m;
            }
        }
        agv.setModel(model);

        model.addAGV(agv);
        agvRepository.save(agv);

        return ((ArrayList<AGV>)agvRepository.findAll()).get(((ArrayList<AGV>)agvRepository.findAll()).size()-1);
    }
}
