import ge.tbc.testautomation.RetryAnnotation.RetryAnalyzer;
import ge.tbc.testautomation.RetryAnnotation.RetryCount;
import org.testng.Assert;
import org.testng.annotations.Test;

public class FailedTest {

    @RetryCount(count = 5)
    @Test(description = "This is a sample test description", retryAnalyzer = RetryAnalyzer.class, groups = {"all"})
    public void thisTestShouldFail(){
        Assert.assertEquals(1, 2);
    }
}
