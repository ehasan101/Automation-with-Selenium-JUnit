# Selenium JUnit Web Form Automation

This project is a Java-based automated test script using **Selenium WebDriver** and **JUnit 5**. 
It automates the submission of a learner practice web form and Scrap the table data from DSEBD.

## 1. Webform Automation

## Project Overview
The test covers an end-to-end scenario including:
1.  Opening the target web form.
2.  Filling out text fields (Name, Phone, Email, Text Area).
3.  Interacting with Date pickers.
4.  **File Upload** functionality.
5.  Handling Checkboxes.
6.  Submitting the form.
7.  **Assertion:** Verifying the success message ("Thank you for your submission!") to ensure the test passed.

## Prerequisites

Before running this project, ensure you have the following installed:

* **Java Development Kit (JDK):** Version 8 or higher (JDK 17+ recommended).
* **Gradle:** For build and dependency management.
* **Google Chrome:** The script utilizes `ChromeDriver`.
* **IDE:** IntelliJ IDEA, Eclipse, or VS Code.


## Report:
![T1_image](https://drive.google.com/uc?export=view&id=1oQFcf4R11QCnXvZDu-b6l-RPV3Ok8kAO)

### Video Demonstration:
[video_demonstration_webForm.mp4](https://drive.google.com/file/d/18GFRjY6227cr2RBalkWD2UvsAATOw_sr/view?usp=drive_link)



## 2.  Scrap Table Data
## Project Overview
This project is a Java-based web automation tool designed to scrape real-time share price data from the Dhaka Stock Exchange (DSE). Using Selenium WebDriver and JUnit 5, the automation script performs the following actions:

1. Navigates to the DSE "Latest Share Price" page. 
2. Locates the main data table containing stock information. 
3. Prints all cell values (Trading Code, LTP, High, Low, etc.) to the console. 
4. Stores the extracted data into a local text file (share_prices_data.txt) for further analysis.

## Prerequisites
Before running this project, ensure you have the following installed on your machine:
* Java Development Kit (JDK): Version 11 or higher. 
* Gradle: For dependency management and running tests. 
* Google Chrome: The browser used for automation. 
* IDE: IntelliJ IDEA, Eclipse, or VS Code (optional but recommended).

## Report:
![T2_image](https://drive.google.com/uc?export=view&id=1QmWQ2nexKc7YyVfegkPMWCyzXAHmTCGs)

### Video Demonstration:
[video_demonstration_DSE.mp4](https://drive.google.com/file/d/1LypsL-lFD6BZ8lSpsqb86LW8ACuf0M9E/view?usp=drive_link)




---
Author: _@HASAN_