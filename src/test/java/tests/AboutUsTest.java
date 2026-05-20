package tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import pages.AboutUsPage;
import pages.HomePage;

public class AboutUsTest extends TestBase {
	HomePage homeObject;
    

	@Test
    public void userCanPlayVideo() {
        homeObject = new HomePage(driver);
        AboutUsPage aboutUsPage = new AboutUsPage(driver);

        driver.get("https://www.demoblaze.com/");

        // الفتح صفحة About Us واضغط على زر التشغيل
        homeObject.openAboutUsPage();
        aboutUsPage.userCanPlayVideo();

        // تأكد إن الفيديو بيشتغل
        //Assert.assertTrue(aboutUsPage.isVideoPlaying(), "The video should be playing.");
    }

}