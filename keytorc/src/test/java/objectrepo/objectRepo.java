package objectrepo;


import org.openqa.selenium.By;

public class objectRepo {


public static By hoverloginButton = By.cssSelector("[title='Giriş Yap']");
public static By aktifhoverloginButton = By.cssSelector("[class*='profile logged-in']");
public static By loginButton = By.cssSelector("[data-cy*='login-button']");
public static By controlLoginPage = By.id("gg-login-box");
public static By loginEmail = By.id("L-UserNameField");
public static By loginPassword = By.id("L-PasswordField");
public static By loginUser = By.id("gg-login-enter");
public static By controlUser = By.cssSelector("[title='Hesabım'] span");
public static By search = By.cssSelector("[data-cy*='search-input']");
public static By homePage = By.cssSelector("[class*='style__Main']");
public static By sayfala  = By.cssSelector("[class*='pt30'] li a");
public static By sayfaVerify  = By.id("best-match-right");
public static By sayfaVerify2  = By.cssSelector("[class='selected']");
public static By urunler  = By.cssSelector("[class='product-title ']");
public static By menuList  = By.cssSelector("[class*='user-panel-list'] [rel='nofollow']");
public static By favList  = By.cssSelector("[class*='product-title']");
public static By favList2  = By.cssSelector("[class='watch-products--table'] tbody tr");
public static By aramaPage  = By.cssSelector("[class*='keyword']");
public static By selectedFavoriButton  = By.cssSelector("[class*='selected'] [class*='favorite']");
public static By favoriButton  = By.cssSelector("[class*='favorite']");
public static By pageTitle  = By.cssSelector("[class*='products-title']");
public static By deleteButton  = By.cssSelector("[class*='delete-all-button']");





}
