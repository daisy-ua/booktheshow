package app.models.user;

import java.util.Map;
import java.util.HashMap;

public class DefaultUserData {

    private static final Map<String, String> PAYPAL_DATA = new HashMap<>();

    static {

        PAYPAL_DATA.put("natasha123", "nata123@ya.com");
        PAYPAL_DATA.put("natasha123", "nata123@ye.com");
        PAYPAL_DATA.put("123", "1234");
    } 
    
    public static Map<String, String> getPayPalData() {

        return PAYPAL_DATA;
    }

}