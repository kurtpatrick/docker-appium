import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class UserActions {

    private WebDriver _driver;
    private WebDriverWait _wait;

    public UserActions(WebDriver driver) {
        _driver = driver;
        if(_driver == null) {
            throw new NullPointerException();
        }
        _wait = new WebDriverWait(_driver, 30);
    }

    public void setText(By locator, String text) {
        WebElement element = _wait.until(ExpectedConditions.elementToBeClickable(locator));
        element.clear();
        element.sendKeys(text);
    }

    protected String getText(By locator) {
        WebElement element = _wait.until(ExpectedConditions.presenceOfElementLocated(locator));
        return element.getText();
    }

    protected void clickElement(By locator) {
        WebElement element = _wait.until(ExpectedConditions.elementToBeClickable(locator));
        element.click();
    }

    protected boolean isDisplayed(By locator) {
        WebElement element = _wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
        return element.isDisplayed();
    }

}
