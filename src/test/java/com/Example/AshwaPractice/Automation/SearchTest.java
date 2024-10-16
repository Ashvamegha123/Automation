package com.Example.AshwaPractice.Automation;

//import com.Example.AshwaPractice.Automation.pages.CartPage;
import com.Example.AshwaPractice.Automation.pages.SearchPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
//import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import io.github.bonigarcia.wdm.WebDriverManager;

public class SearchTest {
    WebDriver driver;
    SearchPage searchPage;
   // CartPage cartPage;

    @BeforeMethod
    public void setup() {
        WebDriverManager.chromedriver().setup();
       WebDriver driver = new ChromeDriver();
       
       
        driver.get("https://www.amazon.in/");
        
       driver.manage().window().maximize();
       
        searchPage = new SearchPage(driver);
       // cartPage=new CartPage(driver);
    }

    @Test(priority = 1)
    public void testSearchNonExistingProduct() throws InterruptedException {
        searchPage.searchForProduct("ld345tsxslfer");
        Assert.assertTrue(searchPage.getSearchResultText().contains("No results"), "No results found message should be displayed");
    }
/*
    @Test(priority = 2)
    public void testSearchExistingProduct() throws InterruptedException {
        searchPage.searchForProduct("Laptop");
        Assert.assertTrue(searchPage.getSearchResultText().contains("Laptop"), "Product results should contain 'Laptop'");
    }
    */
    @Test(priority = 3)
    public void addToCart() throws InterruptedException
    
    {
    	searchPage.fourthProduct();
        //searchPage.selectFourthProduct();  // Select and click on 4th product
        searchPage.clickAddToCart();  //Click On Add to cart Button
    }
    
    @Test(priority = 4)
    public void updateQuanity() {
    	searchPage.CartButtonIcon();       //Click on Cart To Button Icon
    	searchPage.updateQuantity("2");    //Update the quantity to 2

    	
    	}
    
    @Test(priority = 5)
    public void removeProductFromCart() {
    	searchPage.deleteProduct();  // Remove the product from the cart

        try {
            Thread.sleep(2000); // Wait for the product to be removed
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        Assert.assertTrue(searchPage.isCartEmpty(), "Cart is not empty");
    }
    
   
    @AfterMethod
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }

    
    
}
