import org.junit.jupiter.api.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.File;
import java.time.Duration;

public class FormTest {

    WebDriver driver;
    WebDriverWait wait;


    @BeforeAll
    public void setUp() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(40));
        wait = new WebDriverWait(driver, Duration.ofSeconds(15));
    }

    @Test
    public void formSubmissionRun() throws InterruptedException {

        driver.get("https://www.digitalunite.com/practice-webform-learners");

        // 1. Fill Form Details
        driver.findElement(By.id("edit-name")).sendKeys("Test User 01");
        driver.findElement(By.id("edit-number")).sendKeys("0177777777");

        WebElement dateField = driver.findElement(By.id("edit-date"));
        dateField.sendKeys("01/02/2026");

        driver.findElement(By.id("edit-email")).sendKeys("test_user_01@mail.net");
        driver.findElement(By.id("edit-tell-us-a-bit-about-yourself-")).sendKeys("This is a automation test practice.");

        // 2. Upload Document
        WebElement uploadElement = driver.findElement(By.id("edit-uploadocument-upload"));
        File file = new File("src/test/resources/hasan.rtf");
        if(file.exists()) {
            uploadElement.sendKeys(file.getAbsolutePath());
        } else {
            System.out.println("File not found for Test upload - skipping upload step");
        }
        Thread.sleep(1000);

        // 3. Checkbox
        WebElement checkBoxElement = driver.findElement(By.cssSelector("[type='checkbox']"));
        checkBoxElement.click();

        // 4. Submit
        WebElement submitButton = driver.findElement(By.id("edit-submit"));
        submitButton.click();

        // 5. Verification (Assertion)
        WebElement successMessage = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//h1[contains(text(),'Thank you for your submission!')]")));
        String actualMessage = successMessage.getText();

        Assertions.assertNotNull(successMessage, "Success message element was null");
        Assertions.assertTrue(actualMessage.contains("Thank you for your submission!"),
                "Registration Unsuccessful!");
    }


    @AfterAll
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
}