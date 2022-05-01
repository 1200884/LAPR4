package eapli.base.warehousemanagement;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class JSONReader {
    JSONParser jsonParser = new JSONParser();

    public void jsonReader(String path) throws FileNotFoundException {

        JSONArray a = null;
        try {
            a = (JSONArray) jsonParser.parse(new FileReader(path));
        } catch (IOException | ParseException e) {
            e.printStackTrace();
        }
        for (Object o : a) {
            JSONObject person = (JSONObject) o;

            String warehouse = (String) person.get("Warehouse");
            System.out.println(warehouse);

            String length = (String) person.get("Length");
            System.out.println(length);

            String width = (String) person.get("Width");
            System.out.println(width);
            String square = (String) person.get("Square");
            System.out.println(square);
            JSONArray aisles = (JSONArray) person.get("aisles");
            for (Object c : aisles) {
                JSONObject e = (JSONObject) o;
                String id = (String) e.get("Id");
                System.out.println(id);
                String begin = (String) e.get("begin");
                System.out.println(begin);
                String end = (String) e.get("end");
                System.out.println(end);
                String acessability = (String) e.get("acessability");
                System.out.println(acessability);
                JSONArray rows = (JSONArray) e.get("rows");
                for (Object d : rows) {
                    JSONObject f = (JSONObject) o;
                    String idr = (String) f.get("Id");
                    System.out.println(idr);
                    String beginr = (String) f.get("begin");
                    System.out.println(beginr);
                    String endr = (String) f.get("end");
                    System.out.println(endr);
                    String shelves = (String) f.get("shelves");
                    System.out.println(shelves);
                }
            }
            JSONArray AGVDocks = (JSONArray) person.get("AGVDocks");

            for (Object c : AGVDocks) {
                JSONObject n = (JSONObject) o;
                String ida = (String) n.get("Id");
                System.out.println(ida);
                String begina = (String) n.get("begin");
                System.out.println(begina);
                String enda = (String) n.get("end");
                System.out.println(enda);
                String acessabilitya = (String) n.get("acessability");
                System.out.println(acessabilitya);
            }
        }
    }
}

