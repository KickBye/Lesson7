package seleniumTests;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import utils.PropertyLoader;

import java.net.MalformedURLException;
import java.net.URL;

public class BaseTest {
    WebDriver driver;
//в стендкей заносим стенд1, если хотим запускать через мавен, то эту строчку нужно закомментить
    public String setStendKey = System.setProperty("StendKey","stend1");
    //получаем Стенд кей
    public String stendKey = System.getProperty("StendKey");
//передаем его на проперти лоадер
    public String stendUrl = PropertyLoader.loadProperty(stendKey);

    @BeforeTest
    public void beforeT(){
        String selectedBrowser="chrome";

        //ГУГЛ
        System.setProperty("webdriver.chrome.driver","./src/main/resources/chromedriver.exe");
        ChromeOptions op = new ChromeOptions();
        //закомментировано в 6 уроке
     //   DesiredCapabilities dc= DesiredCapabilities.chrome();
     //   dc.setCapability(ChromeOptions.CAPABILITY,op);
      //  driver= new ChromeDriver();

        //   op.setCapability("version","100.0");

        //ФАЕРФОКС
        System.setProperty("webdriver.gecko.driver", "./src/main/resources/geckodriver.exe");
        FirefoxOptions fo = new FirefoxOptions();
        fo.setCapability("browserName","firefox");


        URL hub = null;
        try {
            hub = new URL("http://localhost:4444/wd/hub");
        }catch (MalformedURLException e){
            e.printStackTrace();
        }

        if (selectedBrowser=="firefox"){
            driver = new RemoteWebDriver(hub,fo);}
        else if (selectedBrowser=="chrome"){
            driver = new RemoteWebDriver(hub,op);}
        else{
            System.out.println("Браузер не определен");
        }
    }








    @AfterTest
    public void afterTest(){
        driver.quit();
        if (driver!=null){
            driver.quit();

    }
    }
    public WebDriver getDriver(){
        return driver;
    }



    //Получение скриншота
    //возврат массива байтов
    public byte[] getScreenShot(){
        return((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
    }

}
