package eu.fakje.api.helper;

import java.util.Random;

public class Token
{
    private static final Random random = new Random();
    private static final String chars = "abcdefghijklmnopqrstuvwxyz1234567890_-";

    public static String getToken()
    {
        return getToken(6);
    }

    private static String getToken(int length)
    {
        StringBuilder token = new StringBuilder(length);
        for (int i = 0; i < length; i++) {
            token.append(chars.charAt(random.nextInt(chars.length())));
        }
        return token.toString();
    }
}
