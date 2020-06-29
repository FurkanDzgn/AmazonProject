package StepDefinitions;

import Utils.BrowserUtils;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;

public class Hooks {

    @Before
    public void setUp(Scenario scenario){
        System.out.println("This one will run before each scenario");
        System.out.println(scenario.getName());
    }

    @After
    public void tearDown(Scenario scenario){
        System.out.println("This one will run after each scenario");
        if(scenario.isFailed()){
            //    scenario.log(scenario.getName()+" is failed");
            System.out.println("failed");
            // if some feature files line and stepDefinion class console gives us error
            // There is a problem here
            BrowserUtils.takeScreenShot();
        }
    }
}
