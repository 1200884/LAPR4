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
import java.net.URI;
import java.net.URISyntaxException;
import java.sql.Time;
import java.util.Date;
import java.util.Timer;
import java.util.TimerTask;

public class AGVInfoToJSON {



    public static void agvinfotojson() {
        int i=0;
        while (true) {
            if (i == 0) {
                String url = "example.html";
                File htmlFile = new File(url);
                try {
                    URI oURL = new URI("http://localhost:63342/eapli.base/base/example.html?_ijt=4pi3sne8v86qpq3oa2huqlmrp4&_ij_reload=RELOAD_ON_SAVE");
                    Desktop.getDesktop().browse(oURL);

                    Desktop.getDesktop().browse(htmlFile.toURI());
                } catch (IOException e) {
                    e.printStackTrace();
                } catch (URISyntaxException e) {
                    e.printStackTrace();
                }
            }
            JSONArray jsonArray = new JSONArray();
            for (AGV agv : AGVService.getAgvs()) {
                if (agv.getStatus().availabilityToString().equals("AVAILABLE")) {
                    agv.setLocation(new Location(0, 0));
                }
                // agv.setLocation(new Location(AGV.randomiselocationx(), AGV.randomiselocationy()));
                agv.moveRight();
                JSONObject jsonObjectid = new JSONObject();
                JSONObject jsonObjectstatus = new JSONObject();
                JSONObject jsonObjectlocationx = new JSONObject();
                JSONObject jsonObjectlocationy = new JSONObject();
                jsonObjectid.put("Id", agv.getId());
                jsonObjectstatus.put("Status", agv.getStatus().availabilityToString());
                jsonObjectlocationx.put("X", agv.getLocation().getX());
                jsonObjectlocationy.put("Y", agv.getLocation().getY());
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

            i++;
            for(int j=0;j<50000;j=j+2){
                for(int k=0;k<50000;k=k+2){
                    for(int p=0;p<50000;p=p+2){
                        p--;
                    }
                    k--;
                }
                j--;
            }
        }

    }
}