package com.dio.stepdef;

import com.dio.BaseTest;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.github.bonigarcia.wdm.WebDriverManager;

public class CucumberHooks extends BaseTest {
    @Before
    public void beforeTest(){
       getDriver();
    }

    @After
    public void afterTest(){
        driver.close();
    }
}
