/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sas;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.json.JSONArray;
import org.json.JSONObject;

/**
 *
 * @author Diptanu
 */
@WebServlet(name = "sasServlet", urlPatterns = {"/sasServlet"})
public class SasServlet extends HttpServlet {

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
        try {
            if (request.getParameter("rcid") != null) {
                jsarr = new JSONArray("[{\n"
                        + "	\"rowno\": 1,\n"
                        + "	\"slno\": 2901632,\n"
                        + "	\"ration_card_no\": \"161000000112\",\n"
                        + "	\"ration_card_memberid\": \"16100000011202\",\n"
                            + "	\"member_name_en\": \"DIPALI DEBNATH\",\n"
                        + "	\"member_name_ll\": \"দিপালী দেবনাথ\",\n"
                        + "	\"father_name\": \"DHARONI DEBNATH\",\n"
                        + "	\"father_name_ll\": \"ধরণী দেবনাথ\",\n"
                        + "	\"father_memberid\": null,\n"
                        + "	\"mother_name\": \"SHIBANI DEBNATH\",\n"
                        + "	\"mother_name_ll\": \"শিবানী দেবনাথ\",\n"
                        + "	\"mother_memberid\": null,\n"
                        + "	\"member_dob\": null,\n"
                        + "	\"uid\": \"********4567\",\n"
                        + "	\"gender\": \"F\",\n"
                        + "	\"caste\": null,\n"
                        + "	\"relationship_hof\": \"6\",\n"
                        + "	\"status\": \"1\",\n"
                        + "	\"lgd_district_code\": \"272\",\n"
                        + "	\"lgd_subdiv_code\": \"6689\",\n"
                        + "	\"lgd_block_code\": \"2445\",\n"
                        + "	\"lgd_gp_code\": \"104406\",\n"
                        + "	\"lgd_district_name\": \"West Tripura\",\n"
                        + "	\"lgd_subdiv_name\": \"Mohanpur\",\n"
                        + "	\"lgd_block_name\": \"Mohanpur\",\n"
                        + "	\"lgd_gp_name\": \"Ishanpur\",\n"
                         + "	\"lgd_address\": \"West Tripura\",\n"
                        + "	\"hof\": \"Y\",\n"
                        + "	\"mobile\": \"9086247896\",\n"
                         + "	\"email\": \"dv@gmail.com\",\n"
                        + "	\"bankac\": \"\",\n"
                        + "	\"ifsc\": \"\"\n"
                        + "},\n"
                        + "{\n"
                        + "	\"rowno\": 2,\n"
                        + "	\"slno\": 2901632,\n"
                        + "	\"ration_card_no\": \"161000000112\",\n"
                        + "	\"ration_card_memberid\": \"16100000011203\",\n"
                        + "	\"member_name_en\": \"SAJAL DEBNATH\",\n"
                        + "	\"member_name_ll\": \"সজল দেবনাথ\",\n"
                        + "	\"father_name\": \"SHANKAR DEBNATH\",\n"
                        + "	\"father_name_ll\": \"ধরণী দেবনাথ\",\n"
                        + "	\"father_memberid\": null,\n"
                        + "	\"mother_name\": \"DIPALI DEBNATH\",\n"
                        + "	\"mother_name_ll\": \"শিবানী দেবনাথ\",\n"
                        + "	\"mother_memberid\": null,\n"
                        + "	\"member_dob\": null,\n"
                        + "	\"uid\": \"********1234\",\n"
                        + "	\"gender\": \"M\",\n"
                        + "	\"caste\": null,\n"
                        + "	\"relationship_hof\": \"8\",\n"
                        + "	\"status\": \"1\",\n"
                        + "	\"lgd_district_code\": \"272\",\n"
                        + "	\"lgd_subdiv_code\": \"6689\",\n"
                        + "	\"lgd_block_code\": \"2445\",\n"
                        + "	\"lgd_gp_code\": \"104406\",\n"
                        + "	\"lgd_district_name\": \"West Tripura\",\n"
                        + "	\"lgd_subdiv_name\": \"Mohanpur\",\n"
                        + "	\"lgd_block_name\": \"Mohanpur\",\n"
                        + "	\"lgd_gp_name\": \"Ishanpur\",\n"
                         + "	\"lgd_address\": \"West Tripura\",\n"
                        + "	\"hof\": \"N\",\n"
                        + "	\"mobile\": \"9820145686\",\n"
                         + "	\"email\": \"\",\n"
                        + "	\"bankac\": \"\",\n"
                        + "	\"ifsc\": \"\"\n"
                        + "}]");
                jsobj = new JSONObject();
                jsobj.put("aaData", jsarr);
            }

            if (request.getParameter("ekycrcmember") != null) {
                jsarr = new JSONArray("[{\n"
                        + "	\"rowno\": 1,\n"
                        + "	\"slno\": 2901632,\n"
                        + "	\"ration_card_no\": \"\",\n"
                        + "	\"ration_card_memberid\": \"16100000011202\",\n"
                        + "	\"member_name_en\": \"DIPALI DEBNATH\",\n"
                        + "	\"member_name_ll\": \"দিপালী দেবনাথ\",\n"
                        + "	\"father_name\": \"DHARONI DEBNATH\",\n"
                        + "	\"father_name_ll\": \"ধরণী দেবনাথ\",\n"
                        + "	\"father_memberid\": null,\n"
                        + "	\"mother_name\": \"SHIBANI DEBNATH\",\n"
                        + "	\"mother_name_ll\": \"শিবানী দেবনাথ\",\n"
                        + "	\"mother_memberid\": null,\n"
                        + "	\"member_dob\": null,\n"
                        + "	\"uid\": \"********4567\",\n"
                        + "	\"gender\": \"F\",\n"
                        + "	\"caste\": null,\n"
                        + "	\"relationship_hof\": \"6\",\n"
                        + "	\"status\": \"1\",\n"
                        + "	\"lgd_district_code\": \"272\",\n"
                        + "	\"lgd_subdiv_code\": \"6689\",\n"
                        + "	\"lgd_block_code\": \"2445\",\n"
                        + "	\"lgd_gp_code\": \"104406\",\n"
                        + "	\"lgd_district_name\": \"West Tripura\",\n"
                        + "	\"lgd_subdiv_name\": \"Mohanpur\",\n"
                        + "	\"lgd_block_name\": \"Mohanpur\",\n"
                        + "	\"lgd_gp_name\": \"Ishanpur\",\n"
                        + "	\"lgd_address\": \"West Tripura\",\n"
                        + "	\"hof\": \"Y\",\n"
                        + "	\"mobile\": \"9086247896\",\n"
                         + "	\"email\": \"\",\n"
                        + "	\"bankac\": \"\",\n"
                        + "	\"ifsc\": \"\"\n"
                        + "}  ]");
                jsobj = new JSONObject();
                jsobj.put("aaData", jsarr);
            }
        } catch (Exception e) {
            // e.printStackTrace();
            out.print("Can not redirect...Try again.");
        } finally {

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
