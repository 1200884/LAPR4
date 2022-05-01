package eapli.base.warehousemanagement;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class JSONReader {
        @SuppressWarnings("unchecked")
        public static void main(String[] args)
        {
            JSONParser jsonParser = new JSONParser();
            try (FileReader reader = new FileReader("warehouse1.json"))
            {Object obj = jsonParser.parse(reader);
                JSONArray list = (JSONArray) obj;
                System.out.println(list);
                list.forEach(emp -> parseWarehouseObject((JSONObject) emp));
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            } catch (ParseException e) {
                e.printStackTrace();
            }
        }

        private static void parseWarehouseObject(JSONObject object)
        {
            JSONObject js = (JSONObject) object.get("Id");
            String begin = (String) js.get("begin");
            System.out.println(begin);
            String end = (String) js.get("end");
            System.out.println(end);
            String accessability = (String) js.get("accessability");
            System.out.println(accessability);
        }
    }

