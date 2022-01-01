/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Security;

import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author acer
 */
public class SecurityClass {

    private final static char[] CHARSET = new char[]{'A', 'B', 'C', 'D', 'E',
        'F', 'G', 'H', 'I', 'J', 'K', 'L', 'M', 'N', 'O', 'P', 'Q', 'R',
        'S', 'T', 'U', 'V', 'W', 'X', 'Y', 'Z', '0', '1', '2', '3', '4',
        '5', '6', '7', '8', '9'};

    public static String killchar(String inchar) {

        if (inchar == null) {
            return null;
        }
        String message = inchar;

        message = message.replace('<', '_');
        message = message.replace('>', '_');
        message = message.replace('"', '_');
        message = message.replace('\'', '_');
        message = message.replace('%', '_');
        message = message.replace(';', '_');
        message = message.replace('(', ' ');
        message = message.replace(')', ' ');
        message = message.replace('&', '_');
        message = message.replace('+', '_');
        message = message.replace('=', ' ');
        return message;

    }

    public String gethexString(String inseed) throws UnsupportedEncodingException {

        // algorithm can be "MD5", "SHA-1", "SHA-256"
        String retstr = "";

        try {
            MessageDigest digest = MessageDigest.getInstance("SHA-256");
            byte[] inputBytes = digest.digest(inseed.getBytes("UTF-8"));
            retstr = convertByteArrayToHexString(inputBytes);

        } catch (NoSuchAlgorithmException ex) {
            try {
                throw new Exception(
                        "Could not generate hash from String", ex);
            } catch (Exception ex1) {
                Logger.getLogger(SecurityClass.class.getName()).log(Level.SEVERE, null, ex1);
            }
        }
        return retstr.trim();
    }

    private String convertByteArrayToHexString(byte[] arrayBytes) {
        StringBuffer stringBuffer = new StringBuffer();
        for (int i = 0; i < arrayBytes.length; i++) {
            stringBuffer.append(Integer.toString((arrayBytes[i] & 0xff) + 0x100, 16).substring(1));
        }
        return stringBuffer.toString();
    }

    public static String generateRandomId() {
        SecureRandom sr = new SecureRandom();
        int len = 32;
        StringBuilder sb = new StringBuilder();

        for (int i = 1; i < len + 1; i++) {
            int index = sr.nextInt(CHARSET.length);
            char c = CHARSET[index];
            sb.append(c);

            if ((i % 4) == 0 && i != 0 && i < len) {
                sb.append('-');
            }
        }

        return sb.toString();
    }

}
