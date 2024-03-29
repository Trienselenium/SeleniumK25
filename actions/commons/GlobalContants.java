package commons;

import java.io.File;

public class GlobalContants {
	//public static final String PORTAL_URL = "https://demo.nopcommerce.com/";
	public static final String PORTAL_URL = "https://uat.vietjet.io/vi/";
	public static final String ADMIN_URL = "https://admin-demo.nopcommerce.com/";	
	public static final String PROJECT_PATH = System.getProperty("user.dir");
	public static final String JAVA_VERSION = System.getProperty("java.version");
	public static final String REPORTING_SCREENSHOT = PROJECT_PATH + File.separator + "ReportNGImages" + File.separator;
	public static final long SHORT_TIMEOUT = 5;
	public static final long LONG_TIMEOUT = 10;
	public static final long RETRY_TEST_FAIL = 3;


}
