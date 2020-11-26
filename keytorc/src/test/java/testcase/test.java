package testcase;


import com.sun.net.httpserver.Authenticator;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.*;
import org.apache.log4j.Logger;
import page.methodClass;


public class test {
    public static Logger log  = Logger.getLogger(test.class);
    public static WebDriver driver;


    @BeforeMethod
    public void beforeSuite() {
        System.setProperty("webdriver.chrome.driver", "C:\\keytorc\\chromedriver.exe");
        this.driver = new ChromeDriver();
        this.driver.manage().window().maximize();
    }



    @Test(description = "Favoriye Ürün Ekleme ve Silme", retryAnalyzer = Retry.class)
    public void test1() throws InterruptedException {


        methodClass methodClass = new methodClass(driver,log);
        String username = "emrekonyar";
        String password = "emreemreemre1997";
        String phone = "Samsung";

        methodClass
                .openPage()
                .login(username,password)
                .controlAccount(username)
                .phoneSearch(phone)
                .controlSearchPage(phone)
                .nextPage("2");
                String urunName = methodClass.openPhone(3);
         methodClass
                .clickFavori()
                .clickFavorilerimPage("Favorilerim")
                .controlPage("Favori")
                .controlFavoriIlan(urunName)
                .favoriIlanDelete(urunName)
                .favoriNotAppear(urunName);


    }

//    @AfterMethod
//    public void quit (){
//        driver.quit();
//        log.info("Driver Close");
//    }


}
