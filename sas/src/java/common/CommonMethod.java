package common;

import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import org.json.JSONArray;
import org.json.JSONObject;

/**
 *
 * @author Diptanu
 */
public class CommonMethod {

    public String getDistrict(String defaultValue) throws java.sql.SQLException {
        String res = "";
        String options_string = "";
        try {

            OkHttpClient client = new OkHttpClient().newBuilder()
                    .build();
            Request request = new Request.Builder()
                    .url("http://localhost:8081/sas_api/district")
                    .method("GET", null)
                    .build();
            Response response = client.newCall(request).execute();
            res = response.body().string();
            JSONArray jsarr = new JSONArray(res);
         //   JSONObject jsonRes = new JSONObject();
          //  jsonRes.put("aaData", jsarr);
            options_string += "<option value=\"\">" + defaultValue + "</option>";

            for (int i = 0; i < jsarr.length(); i++) {
                // store each object in JSONObject  
                JSONObject explrObject = jsarr.getJSONObject(i);
                String dname = (String) explrObject.get("district_name");
                String did = (String) explrObject.get("id");
                options_string += "<option value=\"" + did + "\" title =\"" + dname + "\">" + dname + "</option>";
            }
            //while (res.next()) {

            //      options_string += "<option value=\"" + res.getString(1) + "\" title =\"" + res.getString(2) + "\">" + res.getString(2) + "</option>";
            //    }
        } catch (Exception e) {

        } finally {

        }

        return options_string;
    }

    public String fillDropdown(String query, String defaultValue) throws java.sql.SQLException {

        String options_string = "";
        String res = "";
        try {

            OkHttpClient client = new OkHttpClient().newBuilder()
                    .build();
            Request request = new Request.Builder()
                    .url("http://localhost:8081/sas_api/district")
                    .method("GET", null)
                    .build();
            Response response = client.newCall(request).execute();
            res = response.body().string();
            //   options_string += "<option value=\"\">" + defaultValue + "</option>";

            //while (res.next()) {
            //      options_string += "<option value=\"" + res.getString(1) + "\" title =\"" + res.getString(2) + "\">" + res.getString(2) + "</option>";
            //    }
        } catch (Exception e) {

        } finally {

        }

        return res;
    }
}
