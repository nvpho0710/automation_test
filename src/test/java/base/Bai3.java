package base;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class Bai3 {
    public static void main(String[] args) {
        // Khởi tạo WebDriver
        System.setProperty("webdriver.chrome.driver", "resources/chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.get("https://the-internet.herokuapp.com/login");

        // Tìm các phần tử username và password
        WebElement userNameElement = driver.findElement(By.id("username"));
        WebElement passwordElement = driver.findElement(By.id("password"));


        userNameElement.sendKeys("tomsmith");
        passwordElement.sendKeys("SuperSecretPassword!");


        System.out.println("Name attribute of username element: " + userNameElement.getAttribute("name"));


        WebElement loginButton = driver.findElement(By.xpath("//i[contains(text(),'Login')]"));
        loginButton.click();


        driver.navigate().back();
        List<WebElement> inputList = driver.findElements(By.tagName("input"));
        System.out.println("Số lượng phần tử <input>: " + inputList.size());

        for (WebElement element : inputList) {
            System.out.println("Element: " + element.getAttribute("name"));
        }

        for (int i = 0; i < inputList.size(); i++) {
            System.out.println("Element: " + inputList.get(i).getAttribute("name"));
        }

        System.out.println("Is username element displayed? " + userNameElement.isDisplayed());
        System.out.println("Is login button enabled? " + loginButton.isEnabled());
        System.out.println("Size of password element: " + passwordElement.getSize());
        System.out.println("Tag name of login button: " + loginButton.getTagName());
        System.out.println("CSS Value of font-size in username: " + userNameElement.getCssValue("font-size"));

        Actions actions = new Actions(driver);
        actions.keyDown(userNameElement, Keys.SHIFT).sendKeys("shift text").keyUp(Keys.SHIFT).perform();

        // Đóng trình duyệt
        driver.quit();
    }
}