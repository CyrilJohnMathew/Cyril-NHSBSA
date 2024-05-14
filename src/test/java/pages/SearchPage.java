package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import utility.BrowserDriver;
import java.time.Duration;
import java.util.ArrayList;
import java.util.List;


public class SearchPage extends BrowserDriver {
    public static String homepage_heading = "//*[@id='heading']";
    public static String free_space_xpath = "//*[@id='searchFilterRibbon']";
    public static String input_job_xpath = "//*[@class='nhsuk-input nhsuk-u--width-full']";
    public static String input_location_xpath = "//*[@id='location' and @name='location']";
    public static String search_button_xpath = "//*[@id='search' and @class='nhsuk-button']";
    public static String sort_button_xpath = "//*[@id='sort' and @name='sort']";
    public static String new_post_option_xpath = "//*[@id='sort']/option[3]";
    public static String job_count_xpath = "//*[@id='maincontent']/div[1]/div/h2/span";
    public static String first_job_title_xpath = "//*[@id='maincontent']/div[2]/div[2]/ul/li[1]/div[1]/div[1]/h3/a";
    public static String second_job_title_xpath = "//*[@id='maincontent']/div[2]/div[2]/ul/li[2]/div[1]/div[1]/h3/a";
    public static String third_job_title_xpath = "//*[@id='maincontent']/div[2]/div[2]/ul/li[3]/div[1]/div[1]/h3/a";
    public static String fourth_job_title_xpath = "//*[@id='maincontent']/div[2]/div[2]/ul/li[4]/div[1]/div[1]/h3/a";
    public static String first_job_xpath = "//*[@id='maincontent']/div[2]/div[2]/ul/li[1]";
    public static String second_job_xpath = "//*[@id='maincontent']/div[2]/div[2]/ul/li[2]";
    public static String third_job_xpath = "//*[@id='maincontent']/div[2]/div[2]/ul/li[3]";
    public static String fourth_job_xpath = "//*[@id='maincontent']/div[2]/div[2]/ul/li[4]";



    public static void logging_NHS_job_search() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
    //    driver.get("https://www.jobs.nhs.uk/candidate/search");
        // Using the wait to wait for visibility of a Search Page Heading
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(homepage_heading)));

    }

    public static void adding_preferences() throws InterruptedException {

        WebElement job_title = driver.findElement(By.xpath(input_job_xpath));
        WebElement location = driver.findElement(By.xpath(input_location_xpath));
        WebElement search_button = driver.findElement(By.xpath(search_button_xpath));
        WebElement free_space = driver.findElement(By.xpath(free_space_xpath));

        Thread.sleep(2000);
        job_title.click();
        job_title.sendKeys("Analyst");
        free_space.click();
        Thread.sleep(2000);
        location.click();
        location.sendKeys("London");
        free_space.click();
        Thread.sleep(2000);
        search_button.click();
    }

    public static void sorting() throws InterruptedException {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
        // Using the wait to wait for visibility of a Sort Option
        WebElement sort_element = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(sort_button_xpath)));
        WebElement new_post = driver.findElement(By.xpath(new_post_option_xpath));

        sort_element.click();
        new_post.click();
        Thread.sleep(4000);
    }

    public static List<String> visibility_job_title() {
        List<String> jobTitles = new ArrayList<>();

        String jobTitle1 = driver.findElement(By.xpath(first_job_title_xpath)).getText();
        String jobTitle2 = driver.findElement(By.xpath(second_job_title_xpath)).getText();
        String jobTitle3 = driver.findElement(By.xpath(third_job_title_xpath)).getText();
        String jobTitle4 = driver.findElement(By.xpath(fourth_job_title_xpath)).getText();

        jobTitles.add(jobTitle1);
        jobTitles.add(jobTitle2);
        jobTitles.add(jobTitle3);
        jobTitles.add(jobTitle4);

        return jobTitles;
    }

    public static String job_count_check() throws InterruptedException {

        Thread.sleep(2000);
        //scrolling down
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollBy(0,500)");

        return driver.findElement(By.xpath(job_count_xpath)).getText();


    }

}