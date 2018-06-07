import org.testng.Assert;
import org.testng.annotations.Test;

public class SampleAppTestsTwo extends TestBase {

    @Test
    public void testCase() {
        testLogic();
    }

    void testLogic() {
        int loopCount = getRandomNumberInRange(1, 2);
        for(int index=0; index<=loopCount; index++) {

            int inputOne = getRandomNumberInRange(1, 99);
            int inputTwo = getRandomNumberInRange(1, 10);
            String expected = String.valueOf(inputOne + inputTwo);

            String actual =
                    _pageObject
                            .setInputOne(inputOne)
                            .setInputTwo(inputTwo)
                            .clickCalculate()
                            .getResult();

            Assert.assertEquals(expected, actual);
        }
    }

}
