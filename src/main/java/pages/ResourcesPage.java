package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ResourcesPage {

    private WebDriver driver;

    private By downloadButton = By.cssSelector("#__next > section:nth-child(1) > div > div.pr-2xh.pl-baseh.justify-content-between.mb-base > div.br-card.h-fixed.d-flex > div > div > div > button");

    public ResourcesPage(WebDriver driver){
        this.driver = driver;
    }

    public void clickDownloadButton(){
        driver.findElement(downloadButton).click();
    }
}
