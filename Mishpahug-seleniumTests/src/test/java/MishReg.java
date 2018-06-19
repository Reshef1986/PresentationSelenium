

import java.util.concurrent.TimeUnit;
import org.testng.annotations.*;
import static org.testng.Assert.*;
import org.openqa.selenium.*;
import org.openqa.selenium.firefox.FirefoxDriver;

public class MishReg {
  private WebDriver driver;
  private String baseUrl;
  private boolean acceptNextAlert = true;
  private StringBuffer verificationErrors = new StringBuffer();

  @BeforeClass(alwaysRun = true)
  public void setUp() throws Exception {
    driver = new FirefoxDriver();
    baseUrl = "https://www.katalon.com/";
    driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
  }

  @Test
  public void testMishReg() throws Exception {
    driver.get("https://mish.sheygam.com/#/wellcome");
    initNewUserRegistration();
    fillRegistrationForm();

    clickRegistrationButtonFirstLevel();

    fillSecondRegistrationForm();

    driver.findElement(By.id("description")).click();
    driver.findElement(By.id("description")).clear();
    driver.findElement(By.id("description")).sendKeys("etweuit");
    driver.findElement(By.xpath("//div[@id='pictureTable']/div[2]/form/div[2]/button[2]/span")).click();
  }

  public void fillSecondRegistrationForm() {
    type(By.id("inputFirstName"),"Alex");

     type(By.id("inputLastName"),"Zaharov");

    type(By.id("inputPhoneNumber"),"09854");
    type(By.id("inputDateOfBirth"),"12/2/1986");





    driver.findElement(By.xpath("//mat-select[@id='mat-select-1']/div/div")).click();
    driver.findElement(By.xpath("//mat-option[@id='mat-option-6']/span")).click();
    driver.findElement(By.xpath("//div[@id='pictureTable']/div[2]/form/div/div[2]/div[2]/mat-form-field/div/div/div")).click();
    driver.findElement(By.xpath("//mat-option[@id='mat-option-10']/span")).click();

    driver.findElement(By.xpath("//mat-select[@id='mat-select-3']/div/div")).click();

    driver.findElement(By.xpath("//div[@id='pictureTable']/div[2]/form/div/div[2]/div[4]/mat-form-field/div/div/div")).click();
    driver.findElement(By.xpath("//mat-option[@id='mat-option-13']/mat-pseudo-checkbox")).click();
    driver.findElement(By.xpath("//mat-option[@id='mat-option-16']/mat-pseudo-checkbox")).click();
    driver.findElement(By.xpath("//mat-option[@id='mat-option-14']/mat-pseudo-checkbox")).click();
    driver.findElement(By.xpath("//body/div/div[5]")).click();
  }

  public void clickRegistrationButtonFirstLevel() {
    driver.findElement(By.xpath("//span[contains(text(),'Registration')]")).click();
  }

  public void fillRegistrationForm() {
    type(By.id("mat-input-0"), "reshef1986+7@gmail.com");
    type(By.id("mat-input-1"),"123456");
    type(By.id("mat-input-2"),"123456");

  }

  public void type(By locator, String text) {

    driver.findElement(locator).sendKeys(text);
  }

  public void initNewUserRegistration() {
    driver.findElement(By.xpath("//span[contains(text(),'Create Account')]")).click();
  }

  @AfterClass(alwaysRun = true)
  public void tearDown() throws Exception {
    driver.quit();
    String verificationErrorString = verificationErrors.toString();
    if (!"".equals(verificationErrorString)) {
      fail(verificationErrorString);
    }
  }

  private boolean isElementPresent(By by) {
    try {
      driver.findElement(by);
      return true;
    } catch (NoSuchElementException e) {
      return false;
    }
  }

  private boolean isAlertPresent() {
    try {
      driver.switchTo().alert();
      return true;
    } catch (NoAlertPresentException e) {
      return false;
    }
  }

  private String closeAlertAndGetItsText() {
    try {
      Alert alert = driver.switchTo().alert();
      String alertText = alert.getText();
      if (acceptNextAlert) {
        alert.accept();
      } else {
        alert.dismiss();
      }
      return alertText;
    } finally {
      acceptNextAlert = true;
    }
  }
}
