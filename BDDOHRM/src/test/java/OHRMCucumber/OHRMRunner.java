package OHRMCucumber;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(features="C:\\Users\\shabhanu\\eclipse-workspace\\BDDOHRM\\src\\test\\java\\OHRMCucumber",
glue="OHRMCucumber",
tags="@PositiveTest, @ParameterizedTest",
monochrome = true,
plugin={"pretty","junit:target/JunitReports/report2.xml",
		"json:target/JSONReports/report2.json",
		"html:target/HTMLreport2"}

)

public class OHRMRunner {

}
