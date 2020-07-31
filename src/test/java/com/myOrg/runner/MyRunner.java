package com.myOrg.runner;

import com.myOrg.helper.TestReportHelper;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import java.io.IOException;

public class MyRunner {

    private String features;
    private String glue;
    private String tags;
    private String numOfThreads;

    @BeforeClass
    public void setUp() {
        features = System.getProperty("features");
        glue = System.getProperty("glue");
        tags = System.getProperty("tags");
        numOfThreads = System.getProperty("numOfThreads");
    }

    @Test(invocationCount = 1)
    public void test() {
        try {
            CucumberMain.main(new String[]
                    {
                            "--threads", numOfThreads,
                            "-p", "json:target/cucumber-report/cucumber.json",
                            "-p", "rerun:target/rerun.txt",
                          //  "-s","true",
                            "-g", glue,
                            "-t", tags,
                            features});
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @AfterClass(alwaysRun = true)
    public void generateHTMLReports() throws IOException {
        TestReportHelper.generateCucumberReport();
    }
}
