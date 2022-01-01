/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package common;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/**
 *
 * @author Diptanu
 */
@WebServlet(name = "AjaxServlet", urlPatterns = {"/AjaxServlet"})
public class AjaxServlet extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        JSONArray jsarr = null;
        String wsListDisplay = "";
        try {
            if (request.getParameter("category") != null) {

                String category = Security.SecurityClass.killchar(request.getParameter("category"));
                Integer itemVal = 0;

                try {
                    if (request.getParameter("value") != null || !(request.getParameter("value").equals(""))) {
                        itemVal = Integer.parseInt(Security.SecurityClass.killchar(request.getParameter("value")));
                    }

                    if (category.equals("fillSubDiv")) {
//                    sql = "SELECT lgd_subdivision_code, subdivision_name FROM lgd.tbl_subdivision WHERE lgd_district_code='" + itemVal + "' ORDER BY subdivision_name";
//                    con = new DBCon.DBSource().connectToLGDDB().getConnection();
                        OkHttpClient client = new OkHttpClient().newBuilder()
                                .build();
                        Request request1 = new Request.Builder()
                                .url("http://localhost:8081/sas_api/subdivision/" + itemVal)
                                .method("GET", null)
                                .build();
                        Response response1 = client.newCall(request1).execute();
                        String res = response1.body().string();
                        jsarr = new JSONArray(res);
                        wsListDisplay = wListCreate("subdivision_code", "subdivision_name", jsarr);

                    } else if (category.equals("fillBlock")) {
//                    sql = "SELECT DISTINCT block_code, block_name FROM lgd.master_dist_sd_block_bac_gp WHERE subdiv_code= " + itemVal + " ORDER BY block_name";
//                    con = new DBCon.DBSource().connectToLGDDB().getConnection();
                        OkHttpClient client = new OkHttpClient().newBuilder()
                                .build();
                        Request request1 = new Request.Builder()
                                .url("http://localhost:8081/sas_api/block/" + itemVal)
                                .method("GET", null)
                                .build();
                        Response response1 = client.newCall(request1).execute();
                        String res = response1.body().string();
                        jsarr = new JSONArray(res);
                        wsListDisplay = wListCreate("blockcode", "blockname", jsarr);
                    } else if (category.equals("fillGp")) {
//                    sql = "SELECT DISTINCT gp_vc_ward_code, gp_vc_ward_name FROM lgd.master_dist_sd_block_bac_gp WHERE block_code=" + itemVal + " ORDER BY gp_vc_ward_name";
//                    con = new DBCon.DBSource().connectToLGDDB().getConnection();
                        OkHttpClient client = new OkHttpClient().newBuilder()
                                .build();
                        Request request1 = new Request.Builder()
                                .url("http://localhost:8081/sas_api/gp/" + itemVal)
                                .method("GET", null)
                                .build();
                        Response response1 = client.newCall(request1).execute();
                        String res = response1.body().string();
                        jsarr = new JSONArray(res);
                        wsListDisplay = wListCreate("gpvcwardcode", "gpvcward_name", jsarr);
                    } else if (category.equals("fillPoliceStation")) {
//                     sql = "SELECT DISTINCT sl_no, police_station_name FROM lgd.mas_police_station WHERE district_lgd_code='" + itemVal + "' Postoffice";
                        //                   con = new DBCon.DBSource().connectToLGDDB().getConnection();
                        OkHttpClient client = new OkHttpClient().newBuilder()
                                .build();
                        Request request1 = new Request.Builder()
                                .url("http://localhost:8081/sas_api/policestation/" + itemVal)
                                .method("GET", null)
                                .build();
                        Response response1 = client.newCall(request1).execute();
                        String res = response1.body().string();
                        jsarr = new JSONArray(res);
                        wsListDisplay = wListCreate("sl", "police_station_name", jsarr);
                    } else if (category.equals("fillPostOffice")) {
//                    sql = "SELECT DISTINCT sl||'#'||pin, post_office FROM lgd.mas_post_office WHERE subdiv_lgd_code='" + itemVal + "' ORDER BY post_office";
//                    con = new DBCon.DBSource().connectToLGDDB().getConnection();
  OkHttpClient client = new OkHttpClient().newBuilder()
                                .build();
                        Request request1 = new Request.Builder()
                                .url("http://localhost:8081/sas_api/postoffice/" + itemVal)
                                .method("GET", null)
                                .build();
                        Response response1 = client.newCall(request1).execute();
                        String res = response1.body().string();
                        jsarr = new JSONArray(res);
                        wsListDisplay = wListCreate("pin", "postoffice", jsarr);
                        
                    } else {

                    }

//                rset = smt.executeQuery(sql);
//                    String wList = "var wlistArray = new Array();";
//                    String wListID = "var wlistIDArray = new Array();";
//                    int i = 0;
//                    while (rset.next()) {
//                        String item_name = rset.getString(2);
//                        String item_id = rset.getString(1);
//
//                        wList = wList + "wlistArray[" + i + "]=\"" + item_name + "\";";
//                        wListID = wListID + "wlistIDArray[" + i + "]=\"" + item_id + "\";";
//                        i++;
//                    }
                    if (wsListDisplay == "") {
                        out.print("No Data");
                    } else {
                        out.print(wsListDisplay);
                    }
                } catch (Exception ex) {

                } finally {

                }
            }

        } catch (Exception e) {

        }
    }

    public String wListCreate(String paraId, String paraName, JSONArray jsarr) {
        String wList = "var wlistArray = new Array();";
        String wListID = "var wlistIDArray = new Array();";
        try {
            for (int i = 0; i < jsarr.length(); i++) {
                // store each object in JSONObject  
                JSONObject explrObject;
                explrObject = jsarr.getJSONObject(i);
                //   String dcode = (String) explrObject.get("district_code");
                String item_id =  explrObject.get(paraId).toString();
                String item_name =  explrObject.get(paraName).toString();

                wList = wList + "wlistArray[" + i + "]=\"" + item_name + "\";";
                wListID = wListID + "wlistIDArray[" + i + "]=\"" + item_id + "\";";

            }
        } catch (JSONException ex) {
            Logger.getLogger(AjaxServlet.class.getName()).log(Level.SEVERE, null, ex);
        }
        return wList + wListID;
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
