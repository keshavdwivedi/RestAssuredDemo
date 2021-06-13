package apiUtils;

import java.util.Base64;

public class ApiUtility {

    public static String decodeString(String encodedString){
        byte[] bytes = Base64.getDecoder().decode(encodedString);
        return new String(bytes);
    }

}
