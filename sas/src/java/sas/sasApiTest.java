/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package sas;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.concurrent.TimeUnit;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import org.json.JSONArray;
import org.json.JSONObject;

/**
 *
 * @author soumabratamajumder
 */
@WebServlet(name = "sasApiTest", urlPatterns = {"/sasApiTest"})      
        
public class sasApiTest extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
           JSONArray jsarr = null;
        JSONObject jsobj = null;

        try{
            
            
            if (request.getParameter("pid") != null) {
                String pid = Security.SecurityClass.killchar(request.getParameter("pid"));
                OkHttpClient client = new OkHttpClient().newBuilder()
                        .connectTimeout(5, TimeUnit.MINUTES) // connect timeout
                        .writeTimeout(5, TimeUnit.MINUTES) // write timeout                                                     
                        .readTimeout(5, TimeUnit.MINUTES) // read timeout
                        .build();                                                                                                                                                                                                                                                                                                                                                      
                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                        
                Request request2 = new Request.Builder()
                        .url("http://localhost:8081/sas_api/pendingData")
                        .method("GET", null)
                        .build();
                Response response2 = client.newCall(request2).execute();
                String res = response2.body().string();
                 if (res.equalsIgnoreCase("[]")) {
                    jsobj = new JSONObject();
                    jsobj.put("aaData", new JSONArray());
                } else {
                    jsarr = new JSONArray(res);
                    jsobj = new JSONObject();
                    jsobj.put("aaData", jsarr);
                    
                }

            /* TODO output your page here. You may use following sample code. */
        }
        if(request.getParameter("rcMemberId") != null){
                String rcMemberId = Security.SecurityClass.killchar(request.getParameter("rcMemberId"));
                OkHttpClient client = new OkHttpClient().newBuilder()
                        .connectTimeout(5, TimeUnit.MINUTES) // connect timeout
                        .writeTimeout(5, TimeUnit.MINUTES) // write timeout                                                     
                        .readTimeout(5, TimeUnit.MINUTES) // read timeout
                        .build();                                                                                                                                                                                                                                                                                                                                                      
                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                        
                Request request2 = new Request.Builder()
                        .url("http://localhost:8081/sas_api/pendingMember/" + rcMemberId )
                        .method("GET", null)
                        .build();
                Response response2 = client.newCall(request2).execute();
                String res = response2.body().string();
                 if (res.equalsIgnoreCase("[]")) {
                    jsobj = new JSONObject();
                    jsobj.put("aaData", new JSONArray());
                } else {
                    jsarr = new JSONArray(res);
                    jsobj = new JSONObject();
                    jsobj.put("aaData", jsarr);
                    
                }}
    }
        catch (Exception e) {
            // e.printStackTrace();
            out.print("No Data....");
            


    }
        out.print(jsobj);
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
