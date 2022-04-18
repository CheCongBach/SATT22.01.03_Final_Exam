package Common;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class WebDriverCommon {
    public static void initDriver () {
        switch (Constant.BROWSER.toLowerCase()) {
            case "chrome":
                System.setProperty("webdriver.chrome.driver", "resources/driver/chromedriver.exe");
                Constant.WEBDRIVER = new ChromeDriver();
                Constant.WEBDRIVER.manage().window().maximize();
                break;
            case "firefox":
                System.setProperty("webdriver.gecko.driver", "resources/driver/geckodriver.exe");
                Constant.WEBDRIVER = new FirefoxDriver();
                Constant.WEBDRIVER.manage().window().maximize();
                break;
        }
    }

    public static void navigateToUrlRailway (String URL) {
        Constant.WEBDRIVER.get(URL);
    }

    public static void quitRailwaySystem () {
        Constant.WEBDRIVER.quit();
    }

    public static void scrollDownPage () {
        JavascriptExecutor js = (JavascriptExecutor) Constant.WEBDRIVER;
        js.executeScript("window.scrollBy(0,300)");
    }

    public static void zoomInScreen () {
        JavascriptExecutor jse = (JavascriptExecutor) Constant.WEBDRIVER;
        jse.executeScript("document.body.style.zoom='130%';");
    }
}
