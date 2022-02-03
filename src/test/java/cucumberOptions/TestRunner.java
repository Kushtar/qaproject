package cucumberOptions;


import io.cucumber.testng.CucumberOptions;
import io.cucumber.testng.AbstractTestNGCucumberTests;

//we have to comment below code to run it with testng. before it was running as a Junit test.
//@RunWith(Cucumber.class)
@CucumberOptions(
		//it will execute all files in features folder. By giving file name after folder name you
		//can execute only that file
		features = "src/test/java/features",
		//implementation file. indicate the folder our features file need. 
		glue = "stepDefinitions"
		)

//you need extend this class to make testng run this Junit test. 
public class TestRunner extends AbstractTestNGCucumberTests{

}
