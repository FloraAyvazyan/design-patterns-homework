import com.codeborne.selenide.*;
import com.codeborne.selenide.logevents.SelenideLogger;
import ge.tbc.testautomation.util.ModdedAllureSelenide;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.*;

public class ConfigTest {

    @BeforeTest
    @Parameters({"browserType"})
    public void setUp(@Optional("chrome") String browserType) {
        SelenideLogger.addListener("AllureSelenide", new ModdedAllureSelenide());
        switch (browserType.toLowerCase()) {
            case "chrome":
                WebDriverManager.chromedriver().setup();
                WebDriverRunner.setWebDriver(new ChromeDriver());
                break;
            case "firefox":
                WebDriverManager.firefoxdriver().setup();
                WebDriverRunner.setWebDriver(new FirefoxDriver());
                break;
            case "edge":
                WebDriverManager.edgedriver().setup();
                WebDriverRunner.setWebDriver(new EdgeDriver());
                break;
            default:
                throw new IllegalArgumentException("Unsupported browser type: " + browserType);
        }

        Configuration.timeout = 10000;
        WebDriverRunner.getWebDriver().manage().window().maximize();
        Configuration.assertionMode = AssertionMode.STRICT;
        Configuration.holdBrowserOpen = true;
    }

//    @AfterClass
//    public void tearDown(){
//        Selenide.closeWindow();
//    }
}
