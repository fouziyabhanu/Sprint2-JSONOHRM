package loginOHRM;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)

@CucumberOptions(plugin={"pretty","junit:target/JunitReports/report2.xml",
		  							"json:target/JSONReports/report2.json",
									"html:target/HTMLreport2"},
features="C:\\Users\\shabhanu\\eclipse-workspace\\BDDOHRM\\src\\test\\java\\loginOHRM",

tags="@PositiveTest, @ParameterizedTest",
glue="loginOHRM",
monochrome=true)

public class LoginRunner {

}
