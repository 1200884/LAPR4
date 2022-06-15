package eapli.base.warehousemanagement.application;

import eapli.base.warehousemanagement.Domain.AGVDocks;
import eapli.base.warehousemanagement.Domain.Aisle;
import eapli.base.warehousemanagement.Domain.Rowe;
import eapli.base.warehousemanagement.application.CreateWarehouseController;
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

            Long length = (Long) a.get("Length");

            Long width = (Long) a.get("Width");

            Long square = (Long) a.get("Square");


            String unit = (String) a.get("Unit");

            JSONArray aisles = (JSONArray) a.get("Aisles");
            Set<Aisle> aisle = new HashSet<>();
            for (Object b : aisles) {
                JSONObject c = (JSONObject) b;

                Long id = (Long) c.get("Id");

                JSONObject begin = (JSONObject) c.get("begin");
                Long lsquare = (Long) begin.get("lsquare");
                Long wsquare = (Long) begin.get("wsquare");

                JSONObject end = (JSONObject) c.get("end");
                Long lsquareEnd = (Long) end.get("lsquare");
                Long wsquareEnd = (Long) end.get("wsquare");

                JSONObject depth = (JSONObject) c.get("depth");
                Long lsquareDepth = (Long) depth.get("lsquare");
                Long wsquareDepth = (Long) depth.get("wsquare");

                String acessability = (String) c.get("accessibility");

                JSONArray rows = (JSONArray) c.get("rows");
                Aisle aisle1 = new Aisle(id, lsquare, wsquare, lsquareEnd, wsquareEnd, lsquareDepth, wsquareDepth, acessability);
                Set<Rowe> row = new HashSet<>();
                for (Object d : rows) {
                    JSONObject e = (JSONObject) d;

                    Long idr = (Long) e.get("Id");
                    JSONObject beginRow = (JSONObject) e.get("begin");
                    Long lsquareRow = (Long) beginRow.get("lsquare");
                    Long wsquareRow = (Long) beginRow.get("wsquare");

                    JSONObject endRow = (JSONObject) e.get("end");
                    Long lsquareEndRow = (Long) endRow.get("lsquare");
                    Long wsquareEndRow = (Long) endRow.get("wsquare");

                    Long shelves = (Long) e.get("shelves");
                    row.add(new Rowe(idr, lsquareRow, wsquareRow, lsquareEndRow, wsquareEndRow, shelves));
                }
                aisle1.setRows(row);
                aisle.add(aisle1);
            }

            JSONArray AGVDocks = (JSONArray) a.get("AGVDocks");
            Set<AGVDocks> docks = new HashSet<>();
            for (Object f : AGVDocks) {
                JSONObject g = (JSONObject) f;
                String ida = (String) g.get("Id");

                JSONObject begin = (JSONObject) g.get("begin");
                Long lsquare = (Long) begin.get("lsquare");
                Long wsquare = (Long) begin.get("wsquare");

                JSONObject end = (JSONObject) g.get("end");
                Long lsquareEnd = (Long) end.get("lsquare");
                Long wsquareEnd = (Long) end.get("wsquare");

                JSONObject depth = (JSONObject) g.get("depth");
                Long lsquareDepth = (Long) depth.get("lsquare");
                Long wsquareDepth = (Long) depth.get("wsquare");

                String acessability = (String) g.get("accessibility");
                docks.add(new AGVDocks(ida, lsquare, wsquare, lsquareEnd, wsquareEnd, lsquareDepth, wsquareDepth, acessability));
            }
            theController.createWarehouse(length, width, square, unit, aisle, docks);

        } catch (IOException | ParseException e) {
            e.printStackTrace();
        }
    }

    public int[][] walls() {
        //spots that have
        int[][] warehouse = new int[20][18];
        for (int i = 0; i < 20; i++) {
            for (int j = 0; j < 18; j++) {
                warehouse[i][j] = 0;
            }
        }
        for (int k = 4; k < 15; k++) {
            warehouse[k][1] = 1;
        }
        for (int k = 4; k < 15; k++) {
            warehouse[k][8] = 1;
        }
        for (int k = 4; k < 15; k++) {
            warehouse[k][11] = 1;
        }
        for (int k = 4; k < 15; k++) {
            warehouse[k][18] = 1;
        }

        return warehouse;
    }
}

