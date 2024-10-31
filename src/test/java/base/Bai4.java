package base;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Bai4 {
    public static void main(String[] args) {
        // Đường dẫn tới chromedriver
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\ADMIN\\Downloads\\chromedriver.exe");

        // Khởi tạo WebDriver
        WebDriver driver = new ChromeDriver();

        // Truy cập trang cần kiểm thử
        driver.get("https://www.seleniumeasy.com/test/dynamic-data-loading-demo.html");

        try {
            // Nhấn nút "Get New User" để tải thông tin người dùng mới
            driver.findElement(By.id("save")).click();

            // Chờ thông tin người dùng mới hiển thị
            WebDriverWait wait = new WebDriverWait(driver, 10);
            WebElement loadingComplete = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@id='loading' and contains(text(), 'First Name')]")));

            // Lấy thông tin tên và họ từ văn bản
            String[] userDetails = loadingComplete.getText().split(" ");
            String firstName = userDetails[2];
            String lastName = userDetails[5];

            // In ra tên và họ
            System.out.println("Tên: " + firstName);
            System.out.println("Họ: " + lastName);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            // Đóng trình duyệt sau khi hoàn thành
            driver.quit();
        }
    }
}