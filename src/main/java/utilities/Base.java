package utilities;
import io.appium.java_client.AppiumDriver;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.json.simple.JSONObject;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.sikuli.script.Screen;
import org.testng.asserts.SoftAssert;
import pageobjects.parabank.AccountsOverviewPage;
import pageobjects.parabank.FindTransactionsPage;
import pageobjects.parabank.OpenNewAccountPage;
import pageobjects.parabank.TransactionsResultsPage;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

public class Base {
    //General

    protected static WebDriverWait wait;
    protected static SoftAssert softAssert;
    protected static Screen screen;
    public static Actions action;
    public static String platform;

    //Web

    protected static WebDriver driver;

    //Mobile
    protected static AppiumDriver mobileDriver;
    protected static DesiredCapabilities dc = new DesiredCapabilities();


    //Rest API

    protected static RequestSpecification httpRequest;
    protected static Response response;
    protected static JSONObject params= new JSONObject();
    protected static JsonPath jp;

    //DataBase

    protected static Connection con;
    protected static Statement stmt;
    protected static ResultSet rs;

    //page objects
    protected static pageobjects.parabank.LoginPage parabankLogin;
    protected static pageobjects.parabank.MainPage parabankMain;
    protected static pageobjects.parabank.BottomLeftMenuPage parabankBottomLeftMenu;
    protected static AccountsOverviewPage parabankAccountsOverview;
    protected static OpenNewAccountPage parabankOpenNewAccount;
    protected static FindTransactionsPage parabankFindTransactions;
    protected static TransactionsResultsPage parabankTransactionsResults;

    //page objects - mobile
    protected static pageobjects.mortgage.MainPage mortgageMain;

    //page objects - electron
    protected static pageobjects.todo.MainPage todoMain;

    //page objects- desktop
    protected static pageobjects.calculator.MainPage calcMain;



}
