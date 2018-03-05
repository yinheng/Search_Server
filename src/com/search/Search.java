package com.search;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Search {
    WebDriver webDriver;

    public void FireFoxInit() {
        System.setProperty("webdriver.gecko.driver", "C:\\firefoxdriver\\geckodriver.exe");
        webDriver = new FirefoxDriver();
        webDriver.get("https://www.baidu.com/");
        webDriver.manage().window().maximize();
    }

    public void search(String massage) {

        webDriver.findElement(By.id("kw")).clear();
        webDriver.findElement(By.id("kw")).sendKeys(massage);
        webDriver.findElement(By.id("su")).click();

    }

}
