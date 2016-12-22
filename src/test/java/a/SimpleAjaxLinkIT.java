package a;

import static org.junit.Assert.fail;

import org.junit.Test;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.htmlunit.HtmlUnitDriver;

public class SimpleAjaxLinkIT {
    @Test
    public void testSimpleAjaxPageFetchingRemoteContent() {
        WebDriver driver = new HtmlUnitDriver(true);
    }
}
