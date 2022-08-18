package com.rootcode.selenium;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.safari.SafariDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import static org.assertj.core.api.Assertions.*;

public class TestSauceDemoLogin {
    private WebDriver driver;

    @BeforeClass
    public void beforeClass() {
        WebDriverManager.chromedriver().setup();
//        WebDriverManager.firefoxdriver().setup();
//        WebDriverManager.safaridriver().setup();
//        WebDriverManager.iedriver().setup();
//        WebDriverManager.edgedriver();
    }

    @BeforeMethod
    public void beforeMethod() {
        driver = new ChromeDriver();
        //driver = new FirefoxDriver();
//        driver = new SafariDriver();
//        driver = new InternetExplorerDriver();
//        driver = new EdgeDriver();

        driver.get("https://www.saucedemo.com/");
        driver.manage().window().maximize();
    }

    @AfterMethod
    public void afterMethod() {
        if (driver != null) {
            driver.close();
        }
    }

    @Test(priority = 0)
    public void TestLoginWithValidCreds() {
       // System.out.println("Valid credentials");
        driver.findElement(By.id("user-name")).sendKeys("standard_user");
        driver.findElement(By.id("password")).sendKeys("secret_sauce");
        driver.findElement(By.id("login-button")).click();
        String actualTitle = driver.findElement(By.className("title")).getText();

        //verify outcome
        assertThat(actualTitle).isEqualTo("PRODUCTS");
    }

    @Test(priority = 2)
    public void TestLoginWithInvalidPassword() {
        //System.out.println("Invalid password");
        String expectedError = "Epic sadface: Username and password do not match any user in this service";
        driver.findElement(By.id("user-name")).sendKeys("standard_user");
        driver.findElement(By.id("password")).sendKeys("invalid");
        driver.findElement(By.id("login-button")).click();

        String actualError = driver.findElement(By.tagName("h3")).getText();
        assertThat(actualError).containsIgnoringCase(expectedError);


    }

    @Test(enabled = false)
    public void TestLoginWithBlankPassword() {
        //System.out.println("blank password");
        String expectedError = "Epic sadface: Password is required";

        driver.findElement(By.id("user-name")).sendKeys("standard_user");
        driver.findElement(By.id("password")).sendKeys("");
        driver.findElement(By.id("login-button")).click();

        String actualError = driver.findElement(By.tagName("h3")).getText();
        assertThat(actualError).containsIgnoringCase(expectedError);
    }

    @Test(enabled = false)
    public void TestLoginWithoutEmail() {
       // System.out.println("blank email");
        String expectedError = "Epic sadface: Username is required";

        driver.findElement(By.id("user-name")).sendKeys("");
        driver.findElement(By.id("password")).sendKeys("secret_sauce");
        driver.findElement(By.id("login-button")).click();

        String actualError = driver.findElement(By.tagName("h3")).getText();
        assertThat(actualError).containsIgnoringCase(expectedError);
    }

    @Test(priority = 1)
    public void TestLoginWithEmptyCreds() {
       // System.out.println("empty");
        String expectedError = "Epic sadface: Username is required";

        driver.findElement(By.id("user-name")).sendKeys("");
        driver.findElement(By.id("password")).sendKeys("");
        driver.findElement(By.id("login-button")).click();

        String actualError = driver.findElement(By.tagName("h3")).getText();
        assertThat(actualError).containsIgnoringCase(expectedError);
    }


}
