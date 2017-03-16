package eu.fakje.api.helper;

import javax.xml.bind.DatatypeConverter;
import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class Hash
{
    public static String md5(String string)
    {
        String md5ed = null;
        byte[] stringInBytes;
        byte[] digested;
        MessageDigest messageDigest;
        try {
            stringInBytes = string.getBytes("UTF-8");
            messageDigest = MessageDigest.getInstance("MD5");
            digested = messageDigest.digest(stringInBytes);
            md5ed = DatatypeConverter.printHexBinary(digested);
        } catch (NoSuchAlgorithmException | UnsupportedEncodingException e) {
            e.printStackTrace();
            System.out.println(e.getMessage());
        }
        return md5ed.toLowerCase();
    }
}
