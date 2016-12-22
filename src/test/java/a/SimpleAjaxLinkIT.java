package a;

import org.junit.Assert;
import org.junit.Test;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.htmlunit.HtmlUnitDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.WebDriverWait;

public class SimpleAjaxLinkIT {
    @Test
    public void testSimpleAjaxPageFetchingRemoteContent() throws Exception{
        WebDriver driver = new HtmlUnitDriver(true);
        WebDriverWait wait = new WebDriverWait(driver, 30);
	

	driver.get("http://localhost:8080/simple-ajax-link.action");
	Assert.assertEquals("Click on the link bellow.", driver.findElement(By.id("result")).getText());
        driver.findElement(By.id("ajaxlink")).click();
        
        // wait for jQuery to load
        ExpectedCondition<Boolean> jQueryIdle = new ExpectedCondition<Boolean>() {
          @Override
          public Boolean apply(WebDriver driver) {
            try {
              return ((Long)((JavascriptExecutor)driver).executeScript("return jQuery.active") == 0);
            } catch (Exception e) {
               // no jQuery present
               return true;
            }
          }
        };
	

wait.until(jQueryIdle);
	Assert.assertEquals("This is simple text from an ajax call.", driver.findElement(By.id("result")).getText());
    }
}
