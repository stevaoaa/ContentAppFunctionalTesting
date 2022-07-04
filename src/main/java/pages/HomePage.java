package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;


public class HomePage {
    private WebDriver driver;

    private By panels = By.className("card-footer");
    private By singInButton = By.cssSelector("#header > div.container-lg > div > div.header-actions > div > div.header-sign-in.false > button:nth-child(1)");
    private By emailField = By.id("email");
    private By passwordField = By.id("password");
    private By confirmSingIn = By.cssSelector("#header > div.jsx-2cf427c2b491f906.br-login.container-login.openPopup > div > div > form > div.jsx-2cf427c2b491f906.br-modal-footer.justify-content-end > button.br-button.m-2.primary.small");
    private By dropDownButton = By.id("buttonNotification");
    private By emailText = By.cssSelector("#avatar-menu > div.notificaton-header.d-flex.pl-2.justify-content-between.align-items-center > div.col-5 > small");

    public HomePage(WebDriver driver){
        this.driver = driver;
    }

    public int countPanels(){
        List<WebElement> panelsList = driver.findElements(panels);

        return panelsList.size();
    }

    public void clickEnterButton(){
        driver.findElement(singInButton).click();
    }

    public void fillUser(String user){
        driver.findElement(emailField).sendKeys(user);
    }

    public void fillPassword(String password){
        driver.findElement(passwordField).sendKeys(password);
    }

    public void clickConfirmLoginButton(){
        driver.findElement(confirmSingIn).click();
    }

    public boolean isLogged(String expectedUser) {

        driver.findElement(dropDownButton).click();
        String email = driver.findElement(emailText).getText();
        return email.contentEquals(expectedUser);
    }

    public void clickValidPanel(int index){
        // get all panels
        List<WebElement> panelsList = driver.findElements(panels);

        // get one
        WebElement panel = panelsList.get(index);

        // click on the selected panel
        panel.click();
    }

}
