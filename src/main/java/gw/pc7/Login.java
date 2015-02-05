package gw.pc7;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;

/**
 * Created with IntelliJ IDEA.
 * User: hogawa
 * Date: 14/08/15
 * Time: 14:08
 * To change this template use File | Settings | File Templates.
 */
public class Login {
    public static WebDriver driver;
    final static int wait = 500;
    public static void main(String[] args) {
        driver = new FirefoxDriver();
        driver.get("http://localhost:8180/pc/PolicyCenter.do");
        driver.switchTo().frame("top_frame");
        sleep(wait);
        Login l = new Login();
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
        driver.findElement(By.id("Login:LoginScreen:LoginDV:username")).sendKeys("su");
        driver.findElement(By.id("Login:LoginScreen:LoginDV:password")).sendKeys("gw");
        driver.findElement(By.id("Login:LoginScreen:LoginDV:submit")).click();
    }

    public void goToNewAccount(){
        driver.findElement(By.id("TabBar:AccountTab_arrow")).click();
        driver.findElement(By.id("TabBar:AccountTab:AccountTab_NewAccount")).click();
    }
    public void createNewPersonAccount(){
        driver.findElement(By.id("NewAccount:NewAccountScreen:NewAccountSearchDV:LastName")).sendKeys("たなか");
        driver.findElement(By.id("NewAccount:NewAccountScreen:NewAccountSearchDV:FirstName")).sendKeys("たろう");
        driver.findElement(By.id("NewAccount:NewAccountScreen:NewAccountSearchDV:SearchAndResetInputSet:SearchLinksInputSet:Search_link")).click();
        driver.findElement(By.id("NewAccount:NewAccountScreen:NewAccountSearchResultsLV_tb:NewAccountButton_arrow")).click();
        driver.findElement(By.id("menu_item_NewAccount:NewAccountScreen:NewAccountSearchResultsLV_tb:NewAccountButton_NewAccount:NewAccountScreen:NewAccountSearchResultsLV_tb:NewAccountButton:NewAccount_Person")).click();
        sleep(wait);
        driver.findElement(By.id("CreateAccount:CreateAccountScreen:CreateAccountDV:CreateAccountContactInputSet:LastNameKanji")).sendKeys("田中");
        driver.findElement(By.id("CreateAccount:CreateAccountScreen:CreateAccountDV:CreateAccountContactInputSet:FirstNameKanji")).sendKeys("太郎");
        driver.findElement(By.id("CreateAccount:CreateAccountScreen:CreateAccountDV:AddressInputSet:PostalCode")).clear();
        driver.findElement(By.id("CreateAccount:CreateAccountScreen:CreateAccountDV:AddressInputSet:PostalCode")).sendKeys("100-0006");
        driver.findElement(By.id("CreateAccount:CreateAccountScreen:CreateAccountDV:AddressInputSet:AddressLine1")).sendKeys("ゆうらくちょう");
        driver.findElement(By.id("CreateAccount:CreateAccountScreen:CreateAccountDV:AddressInputSet:AddressLine1Kanji")).sendKeys("有楽町");
        driver.findElement(By.id("CreateAccount:CreateAccountScreen:CreateAccountDV:ProducerSelectionInputSet:Producer")).sendKeys("ホッ");

        new Select(driver.findElement(By.id("CreateAccount:CreateAccountScreen:CreateAccountDV:AddressType"))).selectByIndex(2);
        new Select(driver.findElement(By.id("CreateAccount:CreateAccountScreen:CreateAccountDV:ProducerSelectionInputSet:ProducerCode"))).selectByIndex(1);

    }


}