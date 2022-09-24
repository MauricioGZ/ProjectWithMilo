package com.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;

public class ItemDetailPage {
    WebDriver driver;
    public ItemDetailPage(WebDriver driver) {
        this.driver = driver;
    }

    By quantity = By.xpath("//*[@id=\"quantity_wanted\"]");
    By size = By.xpath("//*[@id=\"group_1\"]");
    By firstColor = By.xpath("//*[@id=\"color_14\"]");
    By secondColor = By.xpath("//*[@id=\"color_13\"]");
    By defaultColor = firstColor;
    By submit = By.xpath("//*[@id=\"add_to_cart\"]/button/span");

    public void setQuantity(int _quantity) {
        driver.findElement(quantity).sendKeys(String.valueOf(_quantity));
    }

    public void clearQuantity() {
        driver.findElement(quantity).clear();
    }

    public void setSize(String _size) {
        Select selectLocator = new Select(driver.findElement(size));
        selectLocator.selectByVisibleText(_size);
    }

    public void setColor(String _color) {
        switch (_color) {
            case "one":
                driver.findElement(firstColor).click();
                break;
            case "two":
                driver.findElement(secondColor).click();
                break;
            default:
                driver.findElement(defaultColor).click();
                break;
        }
    }

    public void addToCar() {
        driver.findElement(submit).click();
    }
}
