package project.instaLiker;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.opera.OperaDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import static org.openqa.selenium.support.ui.ExpectedConditions.elementToBeClickable;

public class InstagramPostLiker {

    private static final String FIREFOX_DRIVER_KEY = "webdriver.gecko.driver";
    private static final String CHROME_DRIVER_KEY = "webdriver.chrome.driver";
    private static final String EDGE_DRIVER_KEY = "webdriver.edge.driver";
    private static final String OPERA_DRIVER_KEY = "webdriver.opera.driver";

    private static final String FIREFOX_DRIVER_LOCATION = "drivers/geckodriver.exe";
    private static final String CHROME_DRIVER_LOCATION = "drivers/chromedriver.exe";
    private static final String EDGE_DRIVER_LOCATION = "drivers/MicrosoftWebDriver.exe";
    private static final String OPERA_DRIVER_LOCATION = "drivers/operadriver.exe";

    private static final String FIRST_POST_CSS_CLASS_NAME = "_e3il2";
    private static final String LOGIN_BUTTON_CLASS_NAME = "_b93kq";
    private static final String ARROW_CSS_CLASS_NAME = "coreSpriteRightPaginationArrow";

    private static final String INSTAGRAM_HOME_PAGE = "https://www.instagram.com/";

    private WebDriver driver;

    public InstagramPostLiker(int browserChoice) {

        switch (browserChoice) {

            case 0: System.setProperty(FIREFOX_DRIVER_KEY, FIREFOX_DRIVER_LOCATION);
                driver = new FirefoxDriver();
                break;

            case 1: System.setProperty(CHROME_DRIVER_KEY, CHROME_DRIVER_LOCATION);
                driver = new ChromeDriver();
                break;

            case 2: System.setProperty(EDGE_DRIVER_KEY, EDGE_DRIVER_LOCATION);
                driver = new EdgeDriver();
                break;

            case 3: System.setProperty(OPERA_DRIVER_KEY, OPERA_DRIVER_LOCATION);
                driver = new OperaDriver();
                break;

            default: break;
        }

    }

    public void loginToInstagram(String login, char[] password) {
        driver.get(INSTAGRAM_HOME_PAGE);
        new WebDriverWait(driver, 15).until(elementToBeClickable(By.className(LOGIN_BUTTON_CLASS_NAME))).click();
        driver.findElement(By.cssSelector("input[name='username']")).sendKeys(login);
        driver.findElement(By.cssSelector("input[name='password']")).sendKeys(new String(password)); // should be char array but no such API has been provided by Selenium
        driver.findElement(By.cssSelector("button[class='_qv64e _gexxb _4tgw8 _njrw0']")).click();
    }

    public void likeAllPostsOf(String instagramLink) {

        driver.get(instagramLink);
        driver.findElement(By.className(FIRST_POST_CSS_CLASS_NAME)).click();

        while(driver.findElement(By.className(ARROW_CSS_CLASS_NAME)) != null) {
            WebElement element = new WebDriverWait(driver, 15).until(elementToBeClickable(By.cssSelector(".coreSpriteHeartOpen, .coreSpriteHeartFull")));
            if ("coreSpriteHeartOpen".equals(element.getAttribute("className"))){
                element.click();
            } else {
                driver.findElement(By.className(ARROW_CSS_CLASS_NAME)).click();
            }
        }

        driver.quit();

    }

}
