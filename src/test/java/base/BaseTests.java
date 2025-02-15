package base;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import pages.HomePage;

import java.util.concurrent.TimeUnit;

public class BaseTests {
    private WebDriver driver;
    protected HomePage homePage;
    @BeforeEach
    public void setUp() {
        System.setProperty("webdriver.chrome.driver", "resources/chromedriver.exe");
        driver = new ChromeDriver();
        driver.get("https://the-internet.herokuapp.com/");
        driver.manage().window().maximize();
        homePage = new HomePage(driver);
//        System.out.println(driver.getTitle());
//        driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
//        driver.quit();
    }

//    public static void main(String[] args) {
//        BaseTests test = new BaseTests();
//        test.setUp();
//    }
    @AfterEach
    public  void tearDown(){
        driver.quit();
    }
}
