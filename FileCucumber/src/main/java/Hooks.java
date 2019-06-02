import cucumber.api.java.After;
import cucumber.api.java.Before;

public class Hooks {

    @Before
    public void before(){
        System.out.println("Scenario begin: ");
    }

    @After
    public void after(){
        System.out.println("Scenario end: ");
    }
}