package com.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class HomePage {
    private WebDriver driver;
    
    public HomePage(WebDriver driver) {
        this.driver = driver;
    }


    public void selectItem(By _by) {
        driver.findElement(_by).click();
    }
}
