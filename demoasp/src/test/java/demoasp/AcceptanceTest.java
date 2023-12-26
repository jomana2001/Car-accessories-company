package demoasp;


import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;

import java.io.*;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import io.cucumber.junit.CucumberOptions.SnippetType;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;


@RunWith(Cucumber.class)
@CucumberOptions(features="feature",plugin={"html:target/cucumber/wikipedia.html"},monochrome=true,snippets=SnippetType.CAMELCASE,glue={"car_accessore"})


public class AcceptanceTest {


}