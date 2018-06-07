import org.openqa.selenium.WebDriver;

public class PageBase {

    private WebDriver _driver;
    protected UserActions _userActions;

    public PageBase(WebDriver driver) {
        _driver = driver;
        if(_driver == null) {
            throw new NullPointerException("_driver");
        }
        _userActions = new UserActions(driver);
        if(_userActions == null) {
            throw new NullPointerException("_userActions");
        }
    }

}
