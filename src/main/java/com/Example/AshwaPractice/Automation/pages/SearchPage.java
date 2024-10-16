package com.Example.AshwaPractice.Automation.pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class SearchPage {
    WebDriver driver;

    By searchBox = By.xpath("//input[@id='twotabsearchtextbox']");
    By searchButton = By.xpath("//input[@id='nav-search-submit-button']");
    By searchResultText = By.xpath("(//div[@class='a-section a-spacing-small a-spacing-top-small']//span[@class='a-size-medium a-color-base a-text-normal'])[4]");
    By  productList= By.xpath("//div[@data-cy='title-recipe'])[4]]");
    By addToCartButton=By.xpath("//button[@id='a-autoid-3-announce']");
    
    By cartButton = By.xpath("(//span[normalize-space()='Cart'])[1]");   // Click on Cart Button
    By quantityDropdown = By.xpath("//select[@id='quantity']");                           //  CLick on Dropdwon button of qual
    By deleteButton = By.xpath("//input[@value='Delete']");  
    By emptyCartMessage = By.xpath("//h2[contains(text(),'Your Amazon Cart is empty')]");
    
    
    public SearchPage(WebDriver driver) {
        this.driver = driver;
    }
    
 // Method to search for a product
 
    public void searchForProduct(String product) throws InterruptedException {
        driver.findElement(searchBox).sendKeys(product);
        Thread.sleep(1000);
        driver.findElement(searchButton).click();
        Thread.sleep(10000);       
    }

    public String getSearchResultText() {
        return driver.findElement(searchResultText).getText();
        
         }
    
 //  Method to select the 4th product from search results
    
   public void fourthProduct() throws InterruptedException {
    	driver.findElement(productList).click();
    	Thread.sleep(6000);
    
    	}
    
    
    /*public void selectFourthProduct() {
        List<WebElement> products = driver.findElements(productList);
        if (products.size() >= 4) {
            products.get(3).click(); // Select the 4th product (index 3)
        }
    }*/
    
 // Method to Click on Add To Cart Button
    
    public void clickAddToCart() throws InterruptedException
    {
    	
    	driver.findElement(addToCartButton).click();
    	
    	Thread.sleep(5000);
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
    
    
 
    
    
}
