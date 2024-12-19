import ge.tbc.testautomation.RetryAnnotation.RetryAnalyzer;
import ge.tbc.testautomation.RetryAnnotation.RetryCount;
import io.qameta.allure.Description;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import org.testng.Assert;
import org.testng.annotations.Test;

public class FailedTest {

    @RetryCount(count = 5)
    @Test(description = "This is a sample test description", retryAnalyzer = RetryAnalyzer.class, groups = {"all"})
    @Description("This test shoul fail")
    @Severity(SeverityLevel.TRIVIAL)
    public void thisTestShouldFail() {
        Assert.assertEquals(1, 2);
    }
}
