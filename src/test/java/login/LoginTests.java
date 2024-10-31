package login;

import base.BaseTests;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import pages.HomePage;
import pages.LoginPage;
import pages.SecureAreaPage;

public class LoginTests extends BaseTests {
    @Test
    @DisplayName("TC1 - Login successfully")
    public void testLoginSuccessful() {
        // Nhấn vào liên kết "Form Authentication" trên HomePage// Make sure to initialize HomePage with the WebDriver
        LoginPage loginPage = homePage.clickFormAuthentication();

        // Nhập tên đăng nhập và mật khẩu
        loginPage.setUserName("tomsmith");
        loginPage.setPassword("SuperSecretPassword!");

        // Nhấn nút đăng nhập và chuyển đến SecureAreaPage
        SecureAreaPage secureAreaPage = loginPage.clickLoginButton();

        // Lấy nội dung thông báo sau khi đăng nhập thành công
        String alertText = secureAreaPage.getAlertText();

        // Kiểm tra nội dung thông báo có chứa "You logged into a secure area!"
        Assertions.assertTrue(alertText.contains("You logged into a secure area!"),
                "Alert text is incorrect!");
    }
}