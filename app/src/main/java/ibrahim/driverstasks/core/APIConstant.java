package ibrahim.driverstasks.core;

import org.json.JSONObject;

/**
 * Created by Ibrahim on 2/5/2015.
 */
public class APIConstant{

public static String path="http://ibrahimasad.ml/DriversTasks/public/driver/";
public static  String loginPath="login/";
    public  static  String path2="http://ibrahimasad.ml/DriversTasks/public/driver/getTasks/";
public static JSONObject response=new JSONObject();
    public static  boolean responseStatus=true;


    public  static  String cuurentPath=APIConstant.path2+"1";

    public static void setServerURL(String method){
        APIConstant.cuurentPath=APIConstant.path+method;
    }
    public  static void setParameters(String param){
        APIConstant.cuurentPath+=param;
    }
    public  static  String responseText="";

}
