package eapli.base.warehousemanagement.application;

import eapli.base.warehousemanagement.Domain.AGVDocks;
import eapli.base.warehousemanagement.Domain.Aisle;
import eapli.base.warehousemanagement.Domain.Row;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;
import java.util.HashSet;
import java.util.Set;

public class JSONReader {
    JSONParser jsonParser = new JSONParser();
    CreateWarehouseController theController = new CreateWarehouseController();
    public void jsonReader(String path) throws FileNotFoundException {

        try (Reader reader = new FileReader(path)) {

            JSONObject a = (JSONObject) jsonParser.parse(reader);

            String warehouse = (String) a.get("Warehouse");
            System.out.println(warehouse);

            Long length = (Long) a.get("Length");
            System.out.println(length);

            Long width = (Long) a.get("Width");
            System.out.println(width);

            Long square = (Long) a.get("Square");
            System.out.println(square);


            String unit = (String) a.get("unit");
            System.out.println(unit);

            System.out.println("1111111111111111111111");

            JSONArray aisles = (JSONArray) a.get("Aisles");
            Set<Aisle> aisle = new HashSet<>();
            Set<Row> row = new HashSet<>();
            for (Object b : aisles) {
                JSONObject c = (JSONObject) b;

                Long id = (Long) c.get("Id");
                System.out.println(id);

                JSONObject begin = (JSONObject) c.get("begin");
                Long lsquare = (Long) begin.get("lsquare");
                System.out.println(lsquare);
                Long wsquare = (Long) begin.get("wsquare");
                System.out.println(wsquare);

                JSONObject end = (JSONObject) c.get("end");
                Long lsquareEnd = (Long) end.get("lsquare");
                System.out.println(lsquareEnd);
                Long wsquareEnd = (Long) end.get("wsquare");
                System.out.println(wsquareEnd);

                JSONObject depth = (JSONObject) c.get("depth");
                Long lsquareDepth = (Long) depth.get("lsquare");
                System.out.println(lsquareEnd);
                Long wsquareDepth = (Long) depth.get("wsquare");
                System.out.println(wsquareEnd);

                String acessability = (String) c.get("accessibility");
                System.out.println(acessability);
                System.out.println("2222222222222222222222222222222222");
                JSONArray rows = (JSONArray) c.get("rows");
                Aisle aisle1 = new Aisle(id,lsquare,wsquare,lsquareEnd,wsquareEnd,lsquareDepth,wsquareDepth,acessability);
                for (Object d : rows) {
                    JSONObject e = (JSONObject) d;

                    Long idr = (Long) e.get("Id");
                    System.out.println(idr);
                    JSONObject beginRow = (JSONObject) e.get("begin");
                    Long lsquareRow = (Long) beginRow.get("lsquare");
                    System.out.println(lsquareRow);
                    Long wsquareRow = (Long) beginRow.get("wsquare");
                    System.out.println(wsquareRow);

                    JSONObject endRow = (JSONObject) e.get("end");
                    Long lsquareEndRow = (Long) endRow.get("lsquare");
                    System.out.println(lsquareEndRow);
                    Long wsquareEndRow = (Long) endRow.get("wsquare");
                    System.out.println(wsquareEndRow);

                    System.out.println(wsquareEndRow);
                    Long shelves = (Long) e.get("shelves");
                    System.out.println(shelves);
                    row.add(new Row(idr,lsquareRow,wsquareRow,lsquareEndRow,wsquareEndRow,shelves,aisle1));
                }
                aisle.add(aisle1);
            }

            JSONArray AGVDocks = (JSONArray) a.get("AGVDocks");
            Set<AGVDocks> docks = new HashSet<>();
            for (Object f : AGVDocks) {
                JSONObject g = (JSONObject) f;
                String ida = (String) g.get("Id");
                System.out.println(ida);

                JSONObject begin = (JSONObject) g.get("begin");
                Long lsquare = (Long) begin.get("lsquare");
                System.out.println(lsquare);
                Long wsquare = (Long) begin.get("wsquare");
                System.out.println(wsquare);

                JSONObject end = (JSONObject) g.get("end");
                Long lsquareEnd = (Long) end.get("lsquare");
                System.out.println(lsquareEnd);
                Long wsquareEnd = (Long) end.get("wsquare");
                System.out.println(wsquareEnd);

                JSONObject depth = (JSONObject) g.get("depth");
                Long lsquareDepth = (Long) depth.get("lsquare");
                System.out.println(lsquareEnd);
                Long wsquareDepth = (Long) depth.get("wsquare");
                System.out.println(wsquareEnd);

                String acessability = (String) g.get("accessibility");
                System.out.println(acessability);
            }
            theController.createWarehouse(length,width,square,unit,aisle,docks,row);
        } catch (IOException | ParseException e) {
            e.printStackTrace();
        }
    }
}

