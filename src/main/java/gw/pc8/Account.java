package gw.pc8;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;

/**
 * Created with IntelliJ IDEA.
 * User: hogawa
 * Date: 14/08/15
 * Time: 15:51
 * To change this template use File | Settings | File Templates.
 */
public class Account {
    public static WebDriver driver;
    final static int wait = 5000;
    public static void main(String[] args) {
        driver = new FirefoxDriver();
        driver.get("http://localhost:8180/pc/PolicyCenter.do");
        sleep(wait);
        Account l = new Account();
        l.login();
        sleep(wait);
        l.goToNewAccount();
        sleep(wait);
        l.createNewPersonAccount();
//        driver.quit();
    }

    private static void sleep(int microtime) {
        try {
            Thread.sleep(microtime);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public void login(){
        driver.findElement(By.id("Login:LoginScreen:LoginDV:username-inputEl")).sendKeys("su");
        driver.findElement(By.id("Login:LoginScreen:LoginDV:password-inputEl")).sendKeys("gw");
        driver.findElement(By.id("Login:LoginScreen:LoginDV:submit-btnEl")).click();
    }

    public void goToNewAccount(){
        driver.findElement(By.id("Desktop:DesktopMenuActions-btnEl")).click();
        driver.findElement(By.id("Desktop:DesktopMenuActions:DesktopMenuActions_Create:DesktopMenuActions_NewAccount-textEl")).click();
    }
    public void createNewPersonAccount(){
        driver.findElement(By.id("NewAccount:NewAccountScreen:NewAccountSearchDV:GlobalPersonNameInputSet:LastName-inputEl")).sendKeys("たなか");
        driver.findElement(By.id("NewAccount:NewAccountScreen:NewAccountSearchDV:GlobalPersonNameInputSet:FirstName-inputEl")).sendKeys("たろう");
        driver.findElement(By.id("NewAccount:NewAccountScreen:NewAccountSearchDV:SearchAndResetInputSet:SearchLinksInputSet:Search")).click();
        sleep(wait);
        driver.findElement(By.id("NewAccount:NewAccountScreen:NewAccountButton-btnWrap")).click();
        driver.findElement(By.id("NewAccount:NewAccountScreen:NewAccountButton:NewAccount_Person-itemEl")).click();
        sleep(wait);
        String createAccount = "CreateAccount:CreateAccountScreen:CreateAccountDV:CreateAccountContactInputSet:";
        driver.findElement(By.id(createAccount + "GlobalPersonNameInputSet:LastNameKanji-inputEl")).sendKeys("田中");
        driver.findElement(By.id(createAccount + "GlobalPersonNameInputSet:FirstNameKanji-inputEl")).sendKeys("太郎");
        driver.findElement(By.id("CreateAccount:CreateAccountScreen:CreateAccountDV:AddressInputSet:globalAddressContainer:GlobalAddressInputSet:AgrexSearch-inputEl")).sendKeys("100-0006");
        driver.findElement(By.id("CreateAccount:CreateAccountScreen:CreateAccountDV:AddressInputSet:globalAddressContainer:GlobalAddressInputSet:AgrexSearch:SelectAgrexSearch")).click();
        sleep(wait);
        driver.findElement(By.id("AgrexAddressSelectPopup:0:_Select")).click();
        sleep(wait);

        driver.findElement(By.id("CreateAccount:CreateAccountScreen:CreateAccountDV:ProducerSelectionInputSet:Producer-inputEl")).sendKeys("ホッ");

        Actions builder = new Actions(driver);
        Action tabPress = builder.sendKeys(Keys.TAB).build();

        tabPress.perform();

        driver.findElement(By.id("CreateAccount:CreateAccountScreen:CreateAccountDV:AddressType-inputEl")).clear();
        driver.findElement(By.id("CreateAccount:CreateAccountScreen:CreateAccountDV:AddressType-inputEl")).sendKeys("仕事用");
        tabPress.perform();
        driver.findElement(By.id("CreateAccount:CreateAccountScreen:CreateAccountDV:ProducerSelectionInputSet:ProducerCode-inputEl")).clear();
        driver.findElement(By.id("CreateAccount:CreateAccountScreen:CreateAccountDV:ProducerSelectionInputSet:ProducerCode-inputEl")).sendKeys("100");
        sleep(400);
        tabPress.perform();
        driver.findElement(By.id("CreateAccount:CreateAccountScreen:Update-btnInnerEl")).click();

    }
}