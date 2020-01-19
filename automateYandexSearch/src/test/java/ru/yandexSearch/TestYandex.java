package ru.yandexSearch;


import org.junit.*;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;
import java.util.concurrent.TimeUnit;

import static org.junit.Assert.assertSame;

public class TestYandex{

  private ChromeDriver driver;
  private MainPage mainPage;
  private ResultsPage resultsPage;

  @Before
  public void setUp() {
    System.setProperty("webdriver.chrome.driver", "\\Users\\Тейран\\Downloads\\chromedriver_win32\\chromedriver.exe");
    driver = new ChromeDriver();
    driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
    driver.manage().window().maximize();
    driver.get("https://yandex.ru/");
    mainPage = new MainPage(driver);
  }

  @Test
  public void typedValueTest () throws InterruptedException {
    mainPage.typeSearchRequest("Новости");
    Thread.sleep(3000);
    String expectedValue = mainPage.getShownSuggestions().get(3).getText();
    mainPage.getShownSuggestions().get(3).click();
    resultsPage = new ResultsPage(driver);
    Thread.sleep(3000);
    String actualValue = resultsPage.getTextFromSearchField();
    List<WebElement> results = resultsPage.getListOfResults();
    Assert.assertEquals(expectedValue, actualValue);
  }

  @Test
  public void shownResultsTest() throws InterruptedException {
    mainPage.typeSearchRequest("Новости");
    Thread.sleep(3000);
    mainPage.getShownSuggestions().get(3).click();
    resultsPage = new ResultsPage(driver);
    List<WebElement> results = resultsPage.getListOfResults();
    Thread.sleep(3000);
    System.out.println("Количество результатов на странице равно: " + results.size());
    Assert.assertTrue(results.size() > 0);
  }
 @Test
  public void shownResultsCountTest() throws InterruptedException {
    mainPage.typeSearchRequest("Новости");
    Thread.sleep(3000);
    mainPage.getShownSuggestions().get(3).click();
    Thread.sleep(3000);
    resultsPage = new ResultsPage(driver);
    Assert.assertTrue(resultsPage.getCountOfResultsLabel().getText().contains("Нашлось"));
  }



  @After
  public void tearDown() {
    driver.quit();
  }


}
