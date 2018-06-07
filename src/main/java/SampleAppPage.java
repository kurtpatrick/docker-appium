import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class SampleAppPage extends PageBase {

    private static By InputOneLocator = By.id("first_input");
    private static By InputTwoLocator = By.id("second_input");
    private static By CalculateLocator = By.id("btn_calculate");
    private static By ResultLocator = By.id("result");

    public SampleAppPage(WebDriver driver) {
        super(driver);
    }

    public SampleAppPage setInputOne(int value) {
        _userActions.setText(InputOneLocator, String.valueOf(value));
        return this;
    }

    public SampleAppPage setInputTwo(int value) {
        _userActions.setText(InputTwoLocator, String.valueOf(value));
        return this;
    }

    public SampleAppPage clickCalculate() {
        _userActions.clickElement(CalculateLocator);
        return this;
    }

    public String getResult() {
        return _userActions.getText(ResultLocator);
    }

}
