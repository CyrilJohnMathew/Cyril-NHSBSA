package StepDefinition;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static pages.SearchPage.*;
import java.util.List;

public class JobSearch {


    @Given("^I am a jobseeker on NHS Jobs website$")
    public void i_am_a_jobseeker_on_NHS_Jobs_website() throws Throwable
    {
        logging_NHS_job_search();
    }

    @When("^I put my preferences into the Search functionality$")
    public void i_put_my_preferences_into_the_Search_functionality() throws Throwable
    {
        adding_preferences();
        //Performing Job sort
        sorting();
    }

    @Then("^I should get a list of jobs which matches my preferences$")
    public void i_should_get_a_list_of_jobs_which_matches_my_preferences() throws Throwable
    {
        List<String> jobTitles = visibility_job_title();
        //checking the listed jobs contains the tile 'Analyst'
        for (String jobTitle : jobTitles) {
            if (!jobTitle.contains("Analyst")) {
                throw new Exception("Job title does not contain 'Analyst': " + jobTitle);
            }
        }

    }

    @Then("^my search results should be sorted by the newest Date Posted$")
    public void the_search_results_should_be_sorted_by_the_newest_Date_Posted() throws InterruptedException
    {

        String job_count = job_count_check();


    }
}
