package page;

import objectrepo.objectRepo;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import testcase.test;


import java.util.List;

import static page.AbstractPage.*;

public class methodClass extends test {


    public WebDriverWait wait;


    public methodClass(WebDriver driver, Logger log) {
        this.driver = driver;
        this.log = log;
        this.wait = new WebDriverWait(driver, 20);
    }

    @BeforeMethod
    public void beforeSuite() {
        PropertyConfigurator.configure("path_to_log4j.properties");
    }

    public methodClass openPage() throws InterruptedException {
        openPage2();
        log.info("Open Page ");
        return this;
    }


    public methodClass login(String username, String password) throws InterruptedException {
        moveToElement(objectRepo.hoverloginButton);
        click(objectRepo.loginButton);
        wait.until(ExpectedConditions.visibilityOfElementLocated(objectRepo.controlLoginPage));
        sendKeys(objectRepo.loginEmail, username);
        sendKeys(objectRepo.loginPassword, password);
        clickJS(objectRepo.loginUser);
        log.info("Giriş Yapıldı");
        return this;
    }

    public methodClass controlAccount(String name) {
        wait.until(ExpectedConditions.visibilityOfElementLocated(objectRepo.homePage));
        String text = getText(objectRepo.controlUser);
        Assert.assertEquals(name, text);
        return this;
    }

    public methodClass phoneSearch(String searchText) throws InterruptedException {
        wait.until(ExpectedConditions.visibilityOfElementLocated(objectRepo.search));
        sendKeys(objectRepo.search, searchText, true);
        log.info(searchText + " arandı.");
        return this;
    }

    public methodClass nextPage(String pageCount) throws InterruptedException {
        wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(objectRepo.sayfala));
        List<WebElement> page = findElements(objectRepo.sayfala);
        for (int i = 0; i < page.size(); i++) {
            if (page.get(i).getText().equals(pageCount)) {
               clickJS(page.get(i));
                break;
            }
        }
        wait.until(ExpectedConditions.visibilityOfElementLocated(objectRepo.sayfaVerify));
        String pageVerify = getText(objectRepo.sayfaVerify2);
        Assert.assertEquals(pageVerify, pageCount);
        log.info(pageCount + " sayfasına gidildi.");
        return this;
    }

    public String openPhone(int index) {
        wait.until(ExpectedConditions.visibilityOfElementLocated(objectRepo.urunler));
        List<WebElement> urunler = findElements(objectRepo.urunler);
        String urunName = urunler.get(index - 1).getText();
        urunler.get(index - 1).click();
        return urunName;
    }

    public methodClass clickFavori() throws InterruptedException {
        if (isElementExist(objectRepo.selectedFavoriButton, 2)) {
            log.info("Ürün zaten favorilerde.");
        } else if (isElementExist(objectRepo.favoriButton, 2)) {
            click(objectRepo.favoriButton);
            log.info("Favori button'a tıklandı.");
        }
        return this;
    }


    public methodClass clickFavorilerimPage(String fav) {
        moveToElement(objectRepo.aktifhoverloginButton);
        wait.until(ExpectedConditions.visibilityOfElementLocated(objectRepo.menuList));
        List<WebElement> elementList = findElements(objectRepo.menuList);
        for (int i = 0; i < elementList.size(); i++) {
            if (elementList.get(i).getText().contains(fav)) {
                elementList.get(i).click();
                break;
            }
        }
        return this;
    }

    public methodClass controlPage(String favorilerim) {
        String pageText = getText(objectRepo.pageTitle);
        boolean durum2 = pageText.contains(favorilerim);
        Assert.assertTrue(durum2);
        log.info(favorilerim + " sayfasında olduğu doğrulandı");
        return this;
    }

    public methodClass controlFavoriIlan(String fav) {
        boolean durum = false;
        if (isElementExist(objectRepo.favList, 5)) {
            List<WebElement> elementList = findElements(objectRepo.favList);
            for (int i = 0; i < elementList.size(); i++) {
                if (elementList.get(i).getText().contains(fav)) {
                    durum = true;
                    break;
                }
            }
        } else {
            log.info("Favori ilan bulunamadı.");
        }


        Assert.assertTrue(durum);
        log.info("Favori ilan görüldü");
        return this;
    }

    public methodClass favoriIlanDelete(String urunName) throws InterruptedException {
        boolean durum = false;
        List<WebElement> elementList = findElements(objectRepo.favList2);
        for (int i = 0; i < elementList.size(); i++) {
            if (elementList.get(i).getText().contains(urunName)) {
                elementList.get(i).findElement(By.cssSelector("[class='checkmark']")).click();
                click(objectRepo.deleteButton);
                durum = true;
                break;
            }
        }
        log.info(urunName + " favori ilani silindi");
        Assert.assertTrue(durum);
        return this;
    }

    public methodClass favoriNotAppear(String urunName) {
        boolean durum = false;
        if (isElementExist(objectRepo.favList, 5)) {
            List<WebElement> elementList = findElements(objectRepo.favList);
            for (int i = 0; i < elementList.size(); i++) {
                if (elementList.get(i).getText().contains(urunName)) {
                    durum = true;
                    break;
                }
            }
        }
        Assert.assertFalse(durum);
        log.info(urunName + " olmadığı görüldü...");
        return this;
    }

    public methodClass controlSearchPage(String phone) {
        String arama = getText(objectRepo.aramaPage);
        Assert.assertEquals(arama,phone);
        log.info("Arama sayfasında olduğu dogrulandi");
        return this;
    }
}