package extentions;

import io.qameta.allure.Step;
import utilities.CommonOps;
import java.util.*;

public class DBActions extends CommonOps {

    @Step("Get Credentials from Database")
    public static List<String> getCredentials(String query) {

        List<String> credentials = new ArrayList<String>();
        try {
           rs= stmt.executeQuery(query);
           rs.next();
           credentials.add(rs.getString(1));
            credentials.add(rs.getString(2));


        } catch (Exception e) {
            System.out.println("Error Occurred While Connecting to DB see details: " + e);
        }
return credentials;
    }
}