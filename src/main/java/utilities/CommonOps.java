package utilities;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.AndroidMobileCapabilityType;
import io.appium.java_client.remote.MobileCapabilityType;
import io.appium.java_client.windows.WindowsDriver;
import io.github.bonigarcia.wdm.WebDriverManager;
import io.restassured.RestAssured;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.sikuli.script.Screen;
import org.testng.annotations.*;
import org.testng.asserts.SoftAssert;
import org.w3c.dom.Document;
import workflows.ElectronFlows;
import java.lang.reflect.Method;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import java.io.File;
import java.net.URL;
import java.util.concurrent.TimeUnit;

public class CommonOps extends Base {



    public static String getData (String nodeName)
    {
        DocumentBuilder dBuilder;
        Document doc = null;
        File fXmlFile = new File("./Configuration/DataConfig.xml");
        DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
        try
        {
            dBuilder = dbFactory.newDocumentBuilder();
            doc = dBuilder.parse(fXmlFile);
        }
        catch(Exception e)
        {
            System.out.println("Exception in reading XML file: " + e);
        }
        doc.getDocumentElement().normalize();
        return doc.getElementsByTagName(nodeName).item(0).getTextContent();
    }


    public static void initBrowser(String browserType){

        if (browserType.equalsIgnoreCase("chrome"))
            driver= initChromeDriver();
        else if (browserType.equalsIgnoreCase("ie"))
            driver= initIEDriver();
        else if (browserType.equalsIgnoreCase("firefox"))
            driver=initFireFoxDriver();
        else
            throw new RuntimeException("Browser Type is Invalid");

        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Long.parseLong(getData("Timeout")), TimeUnit.SECONDS);
        wait = new WebDriverWait(driver, Long.parseLong(getData("Timeout")));
        driver.get(getData("url"));
        ManagePages.initParaBank();

    }

public static WebDriver initChromeDriver(){
    WebDriverManager.chromedriver().setup();
    WebDriver driver= new ChromeDriver();
    return driver;
}

    public static WebDriver initIEDriver(){
        WebDriverManager.iedriver().setup();
        WebDriver driver= new InternetExplorerDriver();
        return driver;
    }

    public static WebDriver initFireFoxDriver(){
        WebDriverManager.firefoxdriver().setup();
        WebDriver driver= new FirefoxDriver();
        return driver;
    }

    public static void initMobile(){
        dc.setCapability(MobileCapabilityType.UDID, getData("UDID"));
        dc.setCapability(AndroidMobileCapabilityType.APP_PACKAGE, getData("AppPackage"));
        dc.setCapability(AndroidMobileCapabilityType.APP_ACTIVITY, getData("AppActivity"));
        try {
           mobileDriver = new AndroidDriver<>(new URL(getData("AppiumServer")), dc);
       } catch (Exception e) {
           System.out.println("Can not connect to Appium Server, see details: "+e);
       }
        ManagePages.initMortgage();
        mobileDriver.manage().timeouts().implicitlyWait(Long.parseLong(getData("Timeout")), TimeUnit.SECONDS);
        wait = new WebDriverWait(mobileDriver, Long.parseLong(getData("Timeout")));
       action=new Actions(driver);
   }

    public static void initAPI(){
        RestAssured.baseURI=getData("url-api");
        httpRequest=RestAssured.given().auth().preemptive().basic(getData("UserName"), getData("Password"));

    }

    public static void initElectron(){

    System.setProperty("webdriver.chrome.driver",getData("electron-driver-path"));
        ChromeOptions opt =new ChromeOptions();
        opt.setBinary(getData("electron-app-path"));
dc.setCapability("chromeOptions", opt);
dc.setBrowserName("chrome");
driver= new ChromeDriver(dc);
ManagePages.initToDo();
        driver.manage().timeouts().implicitlyWait(Long.parseLong(getData("Timeout")), TimeUnit.SECONDS);
        wait = new WebDriverWait(driver, Long.parseLong(getData("Timeout")));
        action=new Actions(driver);

    }

    public static void initDesktop(){


        dc.setCapability("app", getData("calculator-app"));
        try {
            driver= new WindowsDriver(new URL(getData("AppiumServerDesktop")),dc);
        } catch (Exception e) {
           System.out.println("couldn't connnect to appium server, see details: " + e);
        }
        driver.manage().timeouts().implicitlyWait(Long.parseLong(getData("Timeout")), TimeUnit.SECONDS);
        wait = new WebDriverWait(driver, Long.parseLong(getData("Timeout")));
        ManagePages.initCalculator();


    }

    @BeforeClass
    @Parameters({"PlatformName"})
    public void startSession(String PlatformName){

        platform=PlatformName;

        if(platform.equalsIgnoreCase("web"))
            initBrowser(getData("BrowserName"));
        else if(platform.equalsIgnoreCase("mobile"))
            initMobile();
        else if(platform.equalsIgnoreCase("api"))
            initAPI();
        else if(platform.equalsIgnoreCase("electron"))
            initElectron();
        else if(platform.equalsIgnoreCase("desktop" ))
            initDesktop();
        else
            throw new RuntimeException("Invalid platform name");


       softAssert= new SoftAssert();
       screen= new Screen();
       ManageDB.openConnection(getData("db-url"),getData("db-username"),getData("db-pass"));

   }

   @AfterMethod
   public void afterMethod(){
        if(platform.equalsIgnoreCase("web"))
        driver.get(getData("url"));

       else if(platform.equalsIgnoreCase("electron"))
            ElectronFlows.emptyList();

   }

   @AfterClass
    public void endSession() {
       ManageDB.closeConnection();
       if (!platform.equalsIgnoreCase("api")) {
           if (!platform.equalsIgnoreCase("mobile"))
               driver.quit();
          else
               mobileDriver.quit();

       }

   }

   @BeforeMethod
    public void beforeMethod(Method method) {
        if(!platform.equalsIgnoreCase("api")) {
            try {
                MonteScreenRecorder.startRecord(method.getName());
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

   }


}
