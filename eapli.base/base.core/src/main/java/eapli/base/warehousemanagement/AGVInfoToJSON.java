package eapli.base.warehousemanagement;

import eapli.base.AGVmanagement.AGV.application.AGVService;
import eapli.base.AGVmanagement.AGV.domain.AGV;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

import java.io.FileWriter;
import java.io.IOException;

public class AGVInfoToJSON {
    public void agvinfotojson() {
        JSONArray jsonArrayStatus = new JSONArray();
        JSONArray jsonArrayLocation = new JSONArray();
        JSONObject jsonObject=new JSONObject();
        for (AGV agv : AGVService.getAgvs()) {
            jsonArrayStatus.add("AGV id ="+agv.getId()+" : Status = "+agv.getStatus().availabilityToString());
        }
        jsonObject.put("STATUS", jsonArrayStatus);
        for (AGV agv : AGVService.getAgvs()) {
            jsonArrayStatus.add("AGV id ="+agv.getId()+" : Location = "+agv.getLocation().toString());
        }
        jsonObject.put("BASE LOCATION",jsonArrayLocation);
        try {
            FileWriter file = new FileWriter("E:/webdashboard.json");
            file.write(jsonObject.toJSONString());
            file.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
