import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import cucumber.api.PendingException;
import org.junit.Assert;
import org.junit.Test;
import java.io.*;

public class SomeInstanceTestSteps {



    @Given("^File name \"([^\"]*)\"$")
    public void file_name(String arg1) throws Throwable {
        TestContext.creator = new FileCreator();
        TestContext.creator.filename = arg1;
        System.out.println("Given: filename is " + arg1);
    }


    @When("^File created$")
    public void file_created() throws Throwable {
        TestContext.creator.create();
        System.out.println("When: try create file " +  TestContext.creator.filename);
    }


    @Then("^Exists file \"([^\"]*)\" is (\\d+)$")
    public void exists_file_is(String arg1, int arg2) throws Throwable {
        boolean a = TestContext.creator.isExists(arg1);

        int aint = 0;
        if (a == true) {
            aint = 1;
        }
        System.out.println("Created: " + a );
        Assert.assertEquals(aint, arg2);
    }
}