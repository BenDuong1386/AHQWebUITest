package com.accesshq.models;

import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class ExplorePlanetTest {
    private WebDriver driver;
    private PlanetPage planetPage;

    @Test
    public void ExplorePlanetTest() {
        // Arrange
        driver = new ChromeDriver();

        //form = new ModernForm(driver);
        planetPage = new PlanetPage(driver);
        planetPage.clickPlanet("https://d18u5zoaatmpxx.cloudfront.net/");
    }
}
