package eapli.base.warehousemanagement;

import eapli.base.AGVmanagement.AGV.application.AGVService;
import eapli.base.AGVmanagement.AGV.domain.AGV;
import eapli.base.AGVmanagement.AGV.domain.repository.Location;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

import java.io.FileWriter;
import java.io.IOException;

public class AGVInfoToJSON {
    public static void agvinfotojson() {
        JSONArray jsonArray = new JSONArray();
        for (AGV agv : AGVService.getAgvs()) {
            agv.setLocation(new Location(AGV.randomiselocation(),AGV.randomiselocation()));
            if (agv.getStatus().availabilityToString().equals("AVAILABLE")) {
                agv.setLocation(new Location(0, 0));
            }
            JSONObject jsonObjectid = new JSONObject();
            JSONObject jsonObjectstatus = new JSONObject();
            JSONObject jsonObjectlocationx = new JSONObject();
            JSONObject jsonObjectlocationy = new JSONObject();
            System.out.println("eusebio1");
            jsonObjectid.put("Id", agv.getId());
            System.out.println("eusebio2");
            jsonObjectstatus.put("Status", agv.getStatus().availabilityToString());
            System.out.println("eusebio3");
            jsonObjectlocationx.put("X", agv.getLocation().getX());
            System.out.println("eusebio4");
            jsonObjectlocationy.put("Y", agv.getLocation().getY());
            System.out.println("eusebio6");
            jsonArray.add(jsonObjectid);
            jsonArray.add(jsonObjectstatus);
            jsonArray.add(jsonObjectlocationx);
            jsonArray.add(jsonObjectlocationy);
        }
        try {
            FileWriter file = new FileWriter("./webdashboard.json");
            file.write(jsonArray.toJSONString());
            file.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
