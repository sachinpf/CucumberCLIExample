package com.myOrg.helper;

import net.masterthought.cucumber.Configuration;
import net.masterthought.cucumber.ReportBuilder;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

public class TestReportHelper {

    private static String tags;
    private static String numOfThreads;
    //private static String environmentType;

    public static void generateCucumberReport() {
        tags = System.getProperty("tags");
        numOfThreads = System.getProperty("numOfThreads");
        //environmentType = System.getProperty("environment");
        File reportOutputDirectory = new File("target");

        ArrayList<String> jsonFiles = new ArrayList<String>();
        jsonFiles.add("target/cucumber-report/cucumber.json");

        String projectName = "Solr Services Automation";

        Configuration configuration = new Configuration(reportOutputDirectory, projectName);

        try {
            FileOutputStream out = new FileOutputStream("src/test/resources/config/config.properties");
            FileInputStream in = new FileInputStream("src/test/resources/config/config.properties");
            Properties props = new Properties();
            props.load(in);
            in.close();
            //props.setProperty("browserType", "chrome");
            //props.setProperty("environmentType", environmentType);
            props.setProperty("tags", tags);
            //props.setProperty("chromeInstances", numOfThreads);
            props.store(out, null);
            out.close();
        } catch (Exception e) {
            System.out.println("Exception occurred while reading config.properties file");
            e.printStackTrace();
        }

        List<String> classificationFiles = new ArrayList<String>();
        classificationFiles.add("src/test/resources/config/config.properties");
        configuration.addClassificationFiles(classificationFiles);

        ReportBuilder reportBuilder = new ReportBuilder(jsonFiles, configuration);
        reportBuilder.generateReports();
    }

}