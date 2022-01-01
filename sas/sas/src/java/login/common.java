package login;


import java.io.InputStream;
import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Properties;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author Ashim
 */
public class common {

    public static String password_security_token = "nic@ors#delhi";
    
    public static String getMd5String(String token) {
        MessageDigest m;
        String contentTypeHex = "";
        try {
            m = MessageDigest.getInstance("MD5");
            m.update(token.getBytes(), 0, token.length());
            contentTypeHex = new BigInteger(1, m.digest()).toString(16);

            while (contentTypeHex.length() < 32) {
                contentTypeHex = "0" + contentTypeHex;
            }

        } catch (NoSuchAlgorithmException ex) {

        }
        return contentTypeHex;
    }

    public String MD5Hash(String str) {
        String passwordToHash = str;
        String generatedPassword = null;
        try {
            // Create MessageDigest instance for MD5
            MessageDigest md = MessageDigest.getInstance("MD5");
            //Add password bytes to digest
            md.update(passwordToHash.getBytes());
            //Get the hash's bytes
            byte[] bytes = md.digest();
            //This bytes[] has bytes in decimal format;
            //Convert it to hexadecimal format
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < bytes.length; i++) {
                sb.append(Integer.toString((bytes[i] & 0xff) + 0x100, 16).substring(1));
            }
            //Get complete hashed password in hex format
            generatedPassword = sb.toString();
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        } finally {
            return generatedPassword;
        }

    }
    
    public String getInfoFromConfig() {
        Properties prop = new Properties();
        InputStream inputStream = null;
        String tokenName = "";
        try {
            inputStream = this.getClass().getClassLoader().getResourceAsStream("Owasp.CsrfGuard.properties");
            prop.load(inputStream);
            tokenName = prop.getProperty("org.owasp.csrfguard.TokenName");
            //System.out.println("TokenName :"+prop.getProperty("org.owasp.csrfguard.TokenName"));

        } catch (Exception ex) {
            System.out.println(ex.toString());
        } finally {
            if (inputStream != null) {
                try {
                    inputStream.close();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }
        return tokenName;

    }
}
