package jsonCucumber;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class) 
@CucumberOptions(plugin = {"pretty", "junit:target/JunitReports/report2.xml",
		 "json:target/JSONReports/report2.json",
		  "html:target/HTMLreport2"})
public class JsonRunner {

}
