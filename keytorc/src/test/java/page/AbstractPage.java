package page;

import org.apache.log4j.Logger;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.util.List;
import java.util.concurrent.TimeUnit;
import page.methodClass.*;

public class AbstractPage extends methodClass{
    protected WebDriverWait wait;

    public AbstractPage(WebDriver driver, Logger log) {
        super(driver, log);
    }

    protected static void openPage2() throws InterruptedException {
        driver.get("https://www.gittigidiyor.com/");
        driver.manage().timeouts().pageLoadTimeout(20, TimeUnit.SECONDS);
        log.info("Web application launched");

    }

    protected static void click(By by, int... index) throws InterruptedException {
        WebElement element;
        try {
            element = driver.findElement(by);
            element.click();
        } catch (Exception e) {
            log.error("Error while clicking webelement : " + e);
        }
    }

    protected static void clickJS(By by, int... index) throws InterruptedException {

        WebElement element = driver.findElement(by);
        JavascriptExecutor executor = (JavascriptExecutor) driver;
        executor.executeScript("arguments[0].click();", element);
    }

    protected static void clickJS(WebElement element) throws InterruptedException {

        JavascriptExecutor executor = (JavascriptExecutor) driver;
        executor.executeScript("arguments[0].click();", element);
    }

    protected static void moveToElement(By by) {
        try {
            Actions action = new Actions(driver);
            WebElement we = driver.findElement(by);
            action.moveToElement(we).build().perform();
            Thread.sleep(2000);
        } catch (Exception e) {
            log.error("Error while filling field : " + e);
        }
    }

    protected static void sendKeys(By by,String text) {
        try {
            WebElement we = driver.findElement(by);
            we.clear();
            we.sendKeys(text);
        } catch (Exception e) {
            log.error("Error while filling field : " + e);
        }
    }

    protected static void sendKeys(By by, String text, boolean pressEnter, int... index) throws InterruptedException {

        WebElement element = null;
        try {
            WebElement we = driver.findElement(by);
            we.clear();
            we.sendKeys(text);
                if (pressEnter == true) {
                    we.sendKeys(Keys.ENTER);
                }
            }
         catch (Exception e) {
            log.error("Error while filling field : " + e);
     }
    }

    protected static String getText(By by) {
        String text = driver.findElement(by).getText();
        return text;
    }

    protected static List<WebElement> findElements(By by) {
        List<WebElement> webElements = null;
        try {
            webElements = driver.findElements(by);
        } catch (Exception e) {
            log.error("Error while listing webelements by css selector : " + e);
        }
        return webElements;
    }

    protected static boolean isElementExist(By by, int timeSeconds) {
        driver.manage().timeouts().implicitlyWait(timeSeconds, TimeUnit.SECONDS);
        boolean isExist = driver.findElements(by).size() > 0;
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        return isExist;
    }

}



