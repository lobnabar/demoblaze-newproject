package pages;

import java.time.Duration;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.JavascriptExecutor;

public class AboutUsPage extends PageBase {

    public AboutUsPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(css = "button.vjs-big-play-button")
    private WebElement videoPlayBtn;

    @FindBy(tagName = "video")
    private WebElement videoElement;

    public void userCanPlayVideo() {
        clickButton(videoPlayBtn);

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(driver -> videoElement.isDisplayed());
    }

    public boolean isVideoPlaying() {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        // Check if video is not paused and has played some time
        Boolean isPaused = (Boolean) js.executeScript("return arguments[0].paused;", videoElement);
        Double currentTime = (Double) js.executeScript("return arguments[0].currentTime;", videoElement);

        return !isPaused && currentTime > 0;
    }
}
