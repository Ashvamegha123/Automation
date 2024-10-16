/*package com.Example.AshwaPractice.Automation.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class CartPage {
    WebDriver driver;

  
    By cartButton = By.xpath("(//span[normalize-space()='Cart'])[1]");   // Click on Cart Button
    By quantityDropdown = By.id("quantity");                           //  CLick on Dropdwon button of qual
    By deleteButton = By.xpath("//input[@value='Delete']");  
    By emptyCartMessage = By.xpath("//h2[contains(text(),'Your Amazon Cart is empty')]");

    public CartPage(WebDriver driver) {
        this.driver = driver;
    }

    public void CartButtonIcon() {
    	driver.findElement(cartButton).click();
    }

    public void updateQuantity(String quantity) {
        driver.findElement(quantityDropdown).sendKeys(quantity);
    }

    public void deleteProduct() {
        driver.findElement(deleteButton).click();
    }
    
    public boolean isCartEmpty() {
    	
        // Check if the empty cart message is displayed
    	
        WebElement emptyCartElement = driver.findElement(emptyCartMessage);   
        return emptyCartElement.isDisplayed();
    }
}*/