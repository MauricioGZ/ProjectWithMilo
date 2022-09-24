package com.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class ResumePage {
    WebDriver driver;
    public ResumePage(WebDriver driver) {
        this.driver = driver;
    }

    By checkout = By.xpath("//*[@id=\"layer_cart\"]/div[1]/div[2]/div[4]/a/span");
    By attributes = By.id("layer_cart_product_attributes");
    By quantity = By.id("layer_cart_product_quantity");
    //WebDriverWait timer = new WebDriverWait(driver, Duration.ofSeconds(5));

    public void proceedToCheckout() {
        driver.findElement(checkout).click();
    }

    /*public void waitUntil() {
        timer.until(ExpectedConditions.visibilityOf(driver.findElement(attributes)));
    }*/
    public String getColor() {
        String summaryValues = driver.findElement(attributes).getText();
        int commaIndex = summaryValues.indexOf(",");
        return summaryValues.substring(0, commaIndex);
    }
    public String getSize() {
        String summaryValues = driver.findElement(attributes).getText();
        int commaIndex = summaryValues.indexOf(",");
        return summaryValues.substring(commaIndex + 2);
    }
    public String getQuantity() {
        return driver.findElement(quantity).getText();
    }
}
