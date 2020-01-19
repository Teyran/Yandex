package ru.yandexSearch;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class WebDriver {
  public static ChromeDriver driver;

  @BeforeClass
  public static void setDriver() {
    System.setProperty("webdriver.chrome.driver", "\\Users\\Тейран\\Downloads\\chromedriver_win32\\chromedriver.exe");
    driver = new ChromeDriver();
    driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    driver.manage().timeouts().pageLoadTimeout(15, TimeUnit.SECONDS);

  }

  @AfterClass
  public static void closeBrowser () {
    System.out.println("Browser closed");
    driver.quit();
  }

}
