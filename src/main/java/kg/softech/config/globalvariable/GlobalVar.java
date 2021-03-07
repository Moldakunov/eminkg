package kg.softech.config.globalvariable;

public class GlobalVar {

  public static int storeId = 5;

  //    public static String mainURL="http://web.imd.kg:8080/";
  public static String mainURL = "http://212.2.230.77:8080/";
  public static String storeName = "EMIN.KG";

  // Linux: System.getProperty("user.home") + "/files/eminkg/"
  // Windows: System.getProperty("user.home") + "\\files\\eminkg\\"
  public static final String SITEMAP = System.getProperty("user.home") + "/files/eminkg/sitemap.xml";

  // Linux: System.getProperty("user.home") + "/banners/eminkg/"
  // Windows: System.getProperty("user.home") + "\\banners\\eminkg\\"
  public static final String BANNER_UPLOAD_DIRECTORY = System.getProperty("user.home") + "/banners/eminkg/";

  // Linux: System.getProperty("user.home") + "/files/eminkg/"
  // Windows: System.getProperty("user.home") + "\\files\\eminkg\\"
  public static final String FAVICON = System.getProperty("user.home") + "/files/eminkg/favicon.ico";
}
