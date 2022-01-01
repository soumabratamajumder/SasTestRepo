/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package login;

//import Connection.ConnectionMaker;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Types;
import org.apache.commons.codec.digest.DigestUtils;

/**
 *
 * @author 
 */
public class mas_user extends login.mas_user_data {

    public mas_user() {
    }

    public mas_user(String username, String pwd, String ranno) {

        java.sql.Connection cnn = null;
     //   ConnectionMaker connectionMaker=null;
        CallableStatement cs = null;
        String password = "";
        this.setIsvarified(0);
        String token = "";
        token = login.common.password_security_token;
        try {

          
cnn=new connector.conn.db.DBSource().connectToSAS().getConnection();
            // cnn.setAutoCommit(false);
            cs = cnn.prepareCall("{ call user_login(?,?,?,?,?) }");

            int out_uid, out_pwd_ue, out_entry_date, out_entry_by, out_entry_from, out_is_expired, out_expiary_date;
            //out_hospital_id
            int out_employee_id, out_sys_user, out_admin_user, out_expdt, out_result, is_first_login;
            int count = 1;
            cs.setString(count, ranno);
            count++;
            cs.setString(count, token);
            count++;
            cs.setString(count, username);
            count++;
            cs.setString(count, pwd);

            count++;
            cs.registerOutParameter(count, Types.VARCHAR);
            out_result = count;


//            count++;
//            cs.registerOutParameter(count, Types.INTEGER);
//            out_hospital_id = count;
            cs.execute();

            //this.setUid(cs.getInt(out_uid));
            this.setUsername(username);
            //this.setPwd(rset.getString("pwd"));
            // password =cs.getString(out_pwd_ue);
            
           

            String result = cs.getString(out_result);
            //compare hash values

            if (result != null) {
                if (pwd.length() > 50) {
                    result = DigestUtils.sha512Hex(result);
                }
                if (result.equalsIgnoreCase(pwd) == true) {
                    this.setIsvarified(1);
                }
            }

        } catch (Exception ex) {
            ex.printStackTrace();
        } finally {

            try {
                if (cs != null) {
                    cs.close();
                    cs = null;
                }
                if (cnn != null) {
                    cnn.close();
                    cnn = null;
                }
            } catch (SQLException ex) {
            }

            //  c = null;
        }

    }
}
