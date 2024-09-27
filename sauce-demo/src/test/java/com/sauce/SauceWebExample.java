package com.sauce;

import com.saucelabs.saucebindings.SauceSession;
import com.saucelabs.saucebindings.junit5.SauceBindingsExtension;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.RegisterExtension;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;


public class SauceWebExample {
    //no need to import Selenium package
    WebDriver driver;
    //use this to interact with Sauce Labs
    SauceSession session;

    @RegisterExtension static SauceBindingsExtension sauceBindingsExtension = new SauceBindingsExtension();

    @BeforeEach
    public void storeObjects() {
        session = sauceBindingsExtension.getSession();
        driver = sauceBindingsExtension.getDriver();
    }

    @Test
    public void sauceTest() {
        //code to start first session using sauce bindings
        driver.get("https://www.saucedemo.com/");
        new WebDriverWait(driver, Duration.ofSeconds(6)).until(d -> d.findElement(By.id("user-name")));

    }
}
