package eapli.base.warehousemanagement;

import eapli.base.AGVmanagement.AGV.application.AGVService;
import eapli.base.AGVmanagement.AGV.domain.AGV;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

import java.io.FileWriter;
import java.io.IOException;

public class AGVInfoToJSON {
    public void agvinfotojson() {
        JSONArray jsonArrayAGV = new JSONArray();
        JSONObject jsonObjectid = new JSONObject();
        JSONObject jsonObjectstatus = new JSONObject();
        JSONObject jsonObjectlocation = new JSONObject();
        for (AGV agv : AGVService.getAgvs()) {
            jsonObjectid.put("id", agv.getId());
            jsonObjectstatus.put("status", agv.getStatus().getAvailability().toString());
            jsonObjectlocation.put("location", agv.getLocation().toString());
            jsonArrayAGV.add(jsonObjectid);
            jsonArrayAGV.add(jsonObjectstatus);
            jsonArrayAGV.add(jsonObjectlocation);
        }
        try {
            FileWriter file = new FileWriter("jetbrains://idea/navigate/reference?project=eapli.base&path=webdashboard.json");
            file.write(jsonArrayAGV.toJSONString());
            file.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
