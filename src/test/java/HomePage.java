import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static org.testng.Assert.assertFalse;
import static org.testng.Assert.assertTrue;

public class HomePage {

    WebDriver driver;

    @BeforeMethod
    public void openHomePage(){
        driver=new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("http://localhost:3000/");
    }

    @Test
    public void testNavbar(){
        // Verify that the Home link is present and clickable
        assertTrue(driver.findElement(By.linkText("Home")).isDisplayed(), "Home link is not displayed.");
        driver.findElement(By.linkText("Home")).click();
        assertTrue(driver.getCurrentUrl().contains("/"), "Home page not opened after clicking the Home link.");

        // Verify that the Testimonials link is present and clickable
        assertTrue(driver.findElement(By.linkText("Testimonials")).isDisplayed(), "Testimonials link is not displayed.");
        driver.findElement(By.linkText("Testimonials")).click();
        assertTrue(driver.getCurrentUrl().contains("testimonials"), "Testimonials section not opened after clicking the Testimonials link.");

        // Verify that the Features link is present and clickable
        assertTrue(driver.findElement(By.linkText("Features")).isDisplayed(), "Features link is not displayed.");
        driver.findElement(By.linkText("Features")).click();
        assertTrue(driver.getCurrentUrl().contains("features"), "Features section not opened after clicking the Features link.");

        // Verify that the Get Started button is present and opens the login modal
        assertTrue(driver.findElement(By.id("getStarted")).isDisplayed(), "Get Started button is not displayed.");
        driver.findElement(By.id("getStarted")).click();

        // Check if the login modal opens (by verifying the modal's visibility or an element inside it)
        assertTrue(driver.findElement(By.id("authentication-modal")).isDisplayed(), "Login modal did not open after clicking Get Started button.");


        // Check if Signup Modal is visible
        assertTrue(driver.findElement(By.id("signup-model")).isDisplayed(), "Signup modal did not open.");

        // Close the Signup Modal by clicking the X button
        driver.findElement(By.id("closeModelSignup")).click();



        // Verify that Signup Modal is no longer visible
        assertFalse(driver.findElement(By.id("signup-model")).isDisplayed(), "Signup modal did not close.");

        // Open Login Modal again
        driver.findElement(By.id("authentication-modal")).click();



        // Close the Login Modal by clicking the X button
        driver.findElement(By.id("closeModelLogin")).click();



        // Verify that Login Modal is no longer visible
        assertFalse(driver.findElement(By.id("authentication-modal")).isDisplayed(), "Login modal did not close.");
    }

}
