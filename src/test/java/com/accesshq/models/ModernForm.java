package com.accesshq.models;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class WebUITestModels {

    WebDriver driver;
    public WebUITestModels() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://d18u5zoaatmpxx.cloudfront.net/");
        driver.findElement(By.cssSelector("[aria-label=forms]")).click();
    }

    public void setName(String name) {
        driver.findElement(By.id("name")).sendKeys("Benjamin Duong");
    }

    public WebDriver getDriver() {
        return driver;
    }

    @BeforeEach
    public void Setup () {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
    }
}
