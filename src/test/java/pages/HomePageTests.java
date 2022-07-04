package pages;

import base.BaseTest;
import org.junit.jupiter.api.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

public class HomePageTests extends BaseTest {

    @Test
    public void testCountPanelsHomePage() throws InterruptedException {

        loadHomePage();
        int numPanels = homePage.countPanels();

        // wait 2 seconds to load the page
        Thread.sleep(2000);

        assertThat(numPanels, is(3));
    }

    @Test
    public void testSuccessfulLogin() throws InterruptedException {

        // click on "Enter" button
        homePage.clickEnterButton();

       // fill user and password
        homePage.fillUser(email);
        homePage.fillPassword(password);

        // click on confirmation button
        homePage.clickConfirmLoginButton();

        // wait 5 seconds to load the page
        Thread.sleep(5000);

        // verify user status
        boolean status = homePage.isLogged(email);
        assertThat(status, is(true));
    }

    @Test
    public void testDownloadResource_CT0007() throws InterruptedException {

        // login
        testSuccessfulLogin();

         // click on a valid panel
        homePage.clickValidPanel(0);

        // wait 5 seconds to load resources  page
        Thread.sleep(5000);

        // try download the resource
        resourcesPage.clickDownloadButton();

        // wait 5 seconds to load resources  page
        Thread.sleep(5000);

        // tabs opened on browser
        int tabs = getNumberOfTabs();

        // if everything goes well browser will have 2 open tabs
        assertThat(tabs, is(2));
    }
}
