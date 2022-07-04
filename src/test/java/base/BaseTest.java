package base;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import pages.HomePage;
import pages.ResourcesPage;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;


public class BaseTest {

    private static WebDriver driver;
    private static String url;
    protected static String email;
    protected static String password;

    protected HomePage homePage;
    protected ResourcesPage resourcesPage;

    @BeforeAll
    public static void initializer(){

        // get operational system name
        String os = System.getProperty("os.name");

        // get project path
        String path = System.getProperty("user.dir");

        Properties props = new Properties();
        InputStream input;

        try {

            // windows
            if(os.contains("Windows")){
                System.setProperty("webdriver.chrome.driver", path + "\\src\\main\\resources\\webdrivers\\chrome\\103\\chromedriver.exe");
                input = new FileInputStream(path + "\\src\\main\\resources\\local.properties");
            }

            //linux
            else{
                System.setProperty("webdriver.chrome.driver", path + "/src/main/resources/webdrivers/chrome/103/chromedriver");
                input = new FileInputStream("/src/main/resources/local.properties");
            }

            // load file info in props attribute
            props.load(input);
        }
        catch (IOException exception){
            System.out.println("Create local.properties file in the resources folder of the project and add the \"url\", \"email\" and \"password\" values to it.");
            return;
        }

        // get the url, email and password from properties file
        url = props.getProperty("url");
        email = props.getProperty("email");
        password = props.getProperty("password");

        System.out.println(url);


        // load the driver
        driver = new ChromeDriver();

        // a timer to guarantee that elements will load (implicit wait of 5 seconds)
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
    }

    @BeforeEach
    public void loadHomePage(){
        driver.get(url);
        homePage = new HomePage(driver);
        resourcesPage = new ResourcesPage(driver);

    }

    @AfterAll
    public static void finish(){
        driver.quit();
    }

    public int getNumberOfTabs(){

        //get window handlers as list
        List<String> browserTabs = new ArrayList<String>(driver.getWindowHandles());

        return browserTabs.size();
    }

}
