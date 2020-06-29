package StepDefinitions.com;

import Pages.AmazonPage;
import Utils.ConfigReader;
import Utils.Driver;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.cucumber.java.bs.A;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.apache.http.HttpResponse;
import org.apache.http.HttpStatus;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.utils.URIBuilder;
import org.apache.http.impl.client.HttpClientBuilder;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.io.IOException;
import java.net.URISyntaxException;
import java.util.List;
import java.util.Map;

import static io.restassured.RestAssured.given;

public class AmazonTest {

    WebDriver driver = Driver.getDriver();
    AmazonPage amazonPage = new AmazonPage();


    @Given("the user goes to amazon.com")
    public void the_user_goes_to_amazon_com() throws URISyntaxException, IOException {
        // https://www.amazon.com/
        driver.navigate().to(ConfigReader.getProperty("UrlAmazon"));
    }

    @When("the user print all links from amazon")
    public void the_user_print_all_links_from_amazon() throws URISyntaxException, IOException {

        List<WebElement> links=amazonPage.allLinks;

        System.out.println(links.size());

        for(WebElement aL:links){
            System.out.println(aL.getAttribute("href"));
            try{
                int statusCode=given().get(aL.getAttribute("href")).statusCode();
                if(statusCode ==200){ //HttpStatus.SC_OK
                    System.out.println(aL.getAttribute("href"));
                }
            }catch (Exception e){
                continue;
            }

        }
    }



}
