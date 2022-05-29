package eapli.base.warehousemanagement;

import eapli.base.AGVmanagement.AGV.application.AGVService;
import eapli.base.AGVmanagement.AGV.domain.AGV;
import eapli.base.AGVmanagement.AGV.domain.repository.Location;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

import java.awt.*;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;

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
        /*
        try {
            File file=new File("example.html");
            Files.write(file.toPath(), content.getBytes());
            Desktop.getDesktop().browse(file.toURI());
        } catch (IOException e) {
            // TODO Auto-generated catch block
        }*/
        String url = "example.html";
        File htmlFile = new File(url);
        try {
            Desktop.getDesktop().browse(htmlFile.toURI());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
