
import org.junit.jupiter.api.*;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.*;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.time.Duration;
import java.util.List;

public class dseScraper {

    WebDriver driver;

    @BeforeEach
    void openBrowser() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
    }

    @Test
    void scrapeTableData() {

        driver.get("https://dsebd.org/latest_share_price_scroll_by_value.php");

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement table = wait.until(
                ExpectedConditions.visibilityOfElementLocated(By.tagName("table"))
        );

        try {
            BufferedWriter writer = new BufferedWriter(
                    new FileWriter("src/test/resources/share_prices_data")
            );

            List<WebElement> allRows = table.findElements(By.tagName("tr"));

            for (WebElement row : allRows) {
                List<WebElement> allCells =
                        row.findElements(By.xpath(".//th | .//td"));

                for (WebElement cell : allCells) {
                    String cellText = cell.getText();
                    System.out.print(cellText + "\t");
                    writer.write(cellText + "\t");
                }

                System.out.println();
                writer.newLine();
            }

            writer.close();
            System.out.println("table data saved successfully.");

        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    @AfterEach
    void closeBrowser() {
        driver.quit();
    }
}


