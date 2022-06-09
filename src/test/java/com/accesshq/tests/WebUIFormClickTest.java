package com.accesshq.models;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

public class WebUIFormClickTest {
    //WebUITestModels model = new WebUITestModels();

    @Test
    public void WebUIClickTest () {
        // Arrange
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://d18u5zoaatmpxx.cloudfront.net/");
        driver.findElement(By.cssSelector("[aria-label=forms]")).click();
        driver.findElement(By.id("name")).sendKeys("Benjamin Duong");
        driver.findElement(By.id("email")).sendKeys("benjaminduong@gmail.com");
        driver.findElement(By.cssSelector("[for=agree]")).click();

        // Act
        List<WebElement> buttons = driver.findElements(By.cssSelector(".v-btn"));
        for (WebElement button: buttons) {
            if (button.getText().equalsIgnoreCase("submit")) {
                button.click();
                break;
            }
        }

        // Assert
        new WebDriverWait(driver,10).
                until(ExpectedConditions.visibilityOf(driver.findElement(By.cssSelector(".popup-message"))));
        String popup = driver.findElement(By.cssSelector(".popup-message")).getText();
        Assertions.assertEquals("Thanks for your feedback Benjamin Duong", popup);
        driver.quit();
    }

    @Test
    public void PlanetEarthTest () {
        // Arrange
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://d18u5zoaatmpxx.cloudfront.net/");
        driver.findElement(By.cssSelector("[aria-label=planets]")).click();

        // Act
        List<WebElement> planets = driver.findElements(By.className("planet"));
        for (WebElement planet: planets) {
            if (planet.findElement(By.className("name")).getText().equalsIgnoreCase("Earth")) {
                WebElement button = planet.findElement(By.tagName("button"));
                button.click();
                break;
            }
        }

        // Assert
//        new WebDriverWait(driver,10).
//                until(ExpectedConditions.visibilityOf(driver.findElement(By.cssSelector(".popup-message"))));
//        String popup = driver.findElement(By.cssSelector(".popup-message")).getText();
//        Assertions.assertEquals("Thanks for your feedback Benjamin Duong", popup);
//        driver.quit();
    }

    @Test
    public void ClickPlanetFurthestFromSunTest () {
        // Arrange
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://d18u5zoaatmpxx.cloudfront.net/");
        driver.findElement(By.cssSelector("[aria-label=planets]")).click();

        // Act
        List<WebElement> planets = driver.findElements(By.className("planet"));
        WebElement furthestPlanet = planets.get(0);
        long distance = 0L;
        for (WebElement planet: planets) {
            //planet.findElement(By.className("distance")).getText().replace(" km","").replace(",","");
            long d = Long.parseLong(planet.findElement(By.className("distance")).getText().
                    replace(",","").replace(" km", ""));
            if (d > distance) {
                distance = d;
                furthestPlanet = planet;
            }
        }
        String planetName = furthestPlanet.findElement(By.className("name")).getText();
        WebElement button = furthestPlanet.findElement(By.tagName("button"));
        button.click();

        // Assert
//        new WebDriverWait(driver,10).
//                until(ExpectedConditions.visibilityOf(driver.findElement(By.cssSelector(".popup-message"))));
//        String popup = driver.findElement(By.cssSelector(".popup-message")).getText();
//        Assertions.assertEquals("Thanks for your feedback Benjamin Duong", popup);
//        driver.quit();
    }

}
