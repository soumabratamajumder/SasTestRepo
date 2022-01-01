package login;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
//import Connection.ConnectionMaker;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.util.Enumeration;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author Ashim
 */
public class login_slvt extends HttpServlet {

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
        HttpSession session = request.getSession();
       // ConnectionMaker conMaker = null;

        login.clientPlatFormDetection browserDetails = new clientPlatFormDetection(request.getHeader("User-Agent"));
        String randomHash = new login.generateHash().getHashKey();
        String rnd = "";
        int process = 0;

        if (session.getAttribute("page_random") != null) {
            rnd = (String) session.getAttribute("page_random");
            if (rnd.equals(session.getAttribute("page_random")) == false) {
                response.sendRedirect("login.jsp?ERR=04");
                return;
            }

        } else {
            response.sendRedirect("login.jsp?ERR=04");
            return;
        }

        if (session.getAttribute("page_random") != null) {
            rnd = (String) session.getAttribute("page_random");
            if (rnd.length() < 1) {
                response.sendRedirect("login.jsp?ERR=04");
                return;

            }

        }

        if (request.getParameter("signin") != null) {
            String uname = "", pwd = "", act_pwd = "";
            String name = "";
            String user_mobile = "", user_pay_id = "";
            int sysAdmin = 0;
            String key1 = "a", key2 = "b";
            if (request.getParameter("inputCap") != null) {
                key1 = request.getParameter("inputCap");
                key1 = key1.replaceAll("'", "");
                key1 = key1.replaceAll(";", "");
                key2 = session.getAttribute("key").toString().trim();
            }

            if (key1.equals(key2)) {
                if (request.getParameter("inputUser") != null) {
                    uname = request.getParameter("inputUser");
                    uname = uname.replaceAll("'", "");
                    uname = uname.replaceAll(";", "");

                    if (request.getParameter("hash") != null) {

                        if (request.getParameter("hash") != null) {
                            pwd = (String) request.getParameter("hash");
                        }

                        act_pwd = request.getParameter("inputPassword");
                        pwd = pwd.replaceAll("'", "");
                        pwd = pwd.replaceAll(";", "");

                        if (session.getAttribute("page_random") != null) {
                            rnd = (String) session.getAttribute("page_random");

                        }
                        //pwd = new scurity.chksum().MD5Hash(pwd);

                        /* if (request.getParameter("sys_admin") != null) {
                         sysAdmin = Integer.parseInt(request.getParameter("sys_admin").trim());
                         } else {
                         sysAdmin = 0;
                         }*/
                        java.sql.Connection conn = null;
                        java.sql.PreparedStatement ps = null, ps1 = null;
                        java.sql.ResultSet rs = null;

                        try {
                            //conMaker = new ConnectionMaker();

                           // conn = (Connection) conMaker.Dbcon();
                            conn=new connector.conn.db.DBSource().connectToSAS().getConnection();
                            login.mas_user usr = null;
                            int time_diff = 0;
                            int is_new_pwd = 0;

                            usr = new login.mas_user(uname, pwd, rnd);
                            if (usr.getIsvarified() == 1) {
                                /*
                                ps = conn.prepareStatement("select is_new_pwd,case when is_new_pwd=1 then to_char(current_timestamp , 'yyyymmddhhmi')::numeric-pwd_creation_time::numeric  else 0 end as tm  from mas_admin where uname=?;");
                                ps.setString(1, uname);
                                rs = ps.executeQuery();

                                if (rs.next()) {
                                    time_diff = rs.getInt("tm");
                                    is_new_pwd = rs.getInt("is_new_pwd");
                                }
                                if (time_diff > 10 && is_new_pwd > 0) {
                                    process = 0;
                                    response.sendRedirect("login.jsp?ERR=05");
                                } else {
                                    process = 1;
                                }
                                */
                                  session.setAttribute("username",uname);
                                  String tokenName = new common().getInfoFromConfig();
                                    String tokenValue = (String) session.getAttribute(tokenName);
                                //response.sendRedirect("index.jsp?"+ tokenName +"=" +tokenValue);
                                response.sendRedirect("index.jsp");
                            }
                            /*
                            if (process > 0) {

                                ps = conn.prepareStatement("SELECT mobile,coalesce(mas_hospital.is_online,0) as is_online,coalesce(mas_hospital.is_telecolsultation,0) as is_telecolsultation,mas_admin.user_id,mas_hospital.hospital_name AS hos_name,hos_id,sys_admin,COALESCE(name||' '||family_name,' ') AS name,to_char(pwd_chnaged_time,'dd/MM/yyyy hh:mm AM') AS PC,pwd_chnaged_counter,last_access_id,to_char(las_access_time,'dd/MM/yyyy hh:mm AM') AS LAT, short_code_str FROM mas_admin LEFT JOIN mas_hospital ON mas_hospital.hospital_id=mas_admin.hos_id WHERE uname=?  ;");
                                ps.setString(1, uname);
                                //    ps.setString(2, act_pwd);
                                rs = ps.executeQuery();

                                if (rs.next()) {
                                    try {
                                        ps1 = conn.prepareStatement("UPDATE mas_admin SET last_access_id =? , las_access_time=CURRENT_TIMESTAMP WHERE uname=?;");
                                        ps1.setString(1, request.getRemoteAddr() + "(OS : " + browserDetails.getOsName() + ",Browser :" + browserDetails.getName() + "--Version : " + browserDetails.getVersion() + " )");
                                        ps1.setString(2, uname);
                                        ps1.execute();
                                    } catch (Exception e) {
                                    }
                                    name = rs.getString("name");
                                    sysAdmin = rs.getInt("sys_admin");
                                    user_mobile = rs.getString("mobile");
                                    user_pay_id = rs.getString("user_id");
                                    session.setAttribute("user_pay_id", user_pay_id);
                                    session.setAttribute("user_mobile", user_mobile);
                                    session.setAttribute("admin_name", name);
                                    session.setAttribute("uname", uname);
                                    session.setAttribute("sysAdmin_user", sysAdmin);

                                    boolean authorized = false;

                                    String user_sys_id = null;
                                    HttpSession oldsession = null;
                                    session = null;

                                    if (request instanceof HttpServletRequest) {
                                        oldsession = ((HttpServletRequest) request).getSession(false);

                                        if (oldsession != null) {
                                            // make a copy of the session content
                                            Map<String, Object> temp = new ConcurrentHashMap<String, Object>();
                                            Enumeration e = oldsession.getAttributeNames();
                                            while (e != null && e.hasMoreElements()) {
                                                String name1 = (String) e.nextElement();
                                                Object value = oldsession.getAttribute(name1);
                                                temp.put(name1, value);
                                            }

                                            // kill the old session and create a new one
                                            oldsession.invalidate();
                                            session = ((HttpServletRequest) request).getSession();

                                            // copy back the session content
                                            for (Map.Entry<String, Object> stringObjectEntry : temp.entrySet()) {
                                                session.setAttribute(stringObjectEntry.getKey(),
                                                        stringObjectEntry.getValue());
                                            }

                                            if (session != null) {
                                                user_sys_id = (String) session.getAttribute("user_sys_id");
                                                if (user_sys_id != null) {
                                                    authorized = true;
                                                }
                                            }
                                        }
                                    }

                                    session.setAttribute("is_online", rs.getInt("is_online"));
                                    session.setAttribute("user_id", rs.getInt("user_id"));
                                    session.setAttribute("hos_id", rs.getInt("hos_id"));
                                    session.setAttribute("hos_name", rs.getString("hos_name"));
                                    session.setAttribute("pwd_chnaged_counter", rs.getString("pwd_chnaged_counter"));
                                    session.setAttribute("pwd_chnaged_time", rs.getString("PC"));
                                    session.setAttribute("last_access_time", rs.getString("LAT"));
                                    session.setAttribute("last_access_ip", rs.getString("last_access_id"));
                                    //

                                    String tokenName = new common().getInfoFromConfig();
                                    String tokenValue = (String) session.getAttribute(tokenName);
                                    session.setAttribute("short_url", rs.getString("short_code_str"));
                                    if (time_diff < 10 && is_new_pwd > 0) {
                                        // 
                                        session.removeAttribute("user_id");
                                        session.removeAttribute("hos_id");
                                        session.setAttribute("sysAdmin", "N");
                                        session.setAttribute("first_login", "Y");
                                        response.sendRedirect("changepassword.jsp?" + tokenName + "=" + tokenValue);
                                    } else {
                                        response.sendRedirect("admin.jsp?" + tokenName + "=" + tokenValue);
                                    }

                                }
                            }
                               */
                            else {
                                response.sendRedirect("login.jsp?ERR=03");
                            }
                         

                        } catch (Exception e) {
                            e.printStackTrace();
                        } finally {

                            try {
                                if (ps != null) {
                                    ps.close();
                                }
                                if (ps1 != null) {
                                    ps1.close();
                                }
                                if (rs != null) {
                                    rs.close();
                                }
                                if (conn != null) {
                                    conn.close();
                                }

                            } catch (Exception ex) {

                            }
                        }
                    } else {
                        response.sendRedirect("login.jsp?ERR=02");
                    }
                } else {
                    response.sendRedirect("login.jsp?ERR=01");
                }
            } else {
                response.sendRedirect("login.jsp?ERR=04");
            }
        }
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
