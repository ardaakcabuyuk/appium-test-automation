import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.util.HashMap;
import java.util.Map;

public class TestSuite {
    private static final String FIELD_BASE_XPATH = "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup[#]/android.widget.EditText";
    private static final String RESULT_BASE_XPATH = "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.TextView[#]";
    private static final String FIRST_OPTION_XPATH = "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.widget.ScrollView/android.view.ViewGroup/android.view.ViewGroup[1]/android.view.ViewGroup/android.widget.TextView";
    private static final String SUBMIT_XPATH = "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup[9]";
    private static final String CHANGE_ANSWER_XPATH = "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.view.ViewGroup/android.view.ViewGroup[1]/android.widget.TextView";
    private static final String SUBMIT_SURVEY_XPATH = "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.view.ViewGroup/android.view.ViewGroup[2]/android.widget.TextView";
    private static final String SUBMIT_MESSAGE_XPATH = "/hierarchy/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.ScrollView/android.widget.LinearLayout/android.widget.TextView";
    private static final String SUBMIT_MESSAGE_OK_BUTTON_XPATH = "/hierarchy/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.ScrollView/android.widget.LinearLayout/android.widget.Button";
    private static final String[] fields = {
            "Name",
            "Surname",
            "Birth Date",
            "City",
            "Gender",
            "Vaccine Type",
            "Side Effect",
            "PCR Positive",
            "Submit"
    };
    private static final String[] inputs = {
            "Arda Akca",
            "Buyuk",
            "29/3/2022",
            "Ankara",
            "Male",
            "Type 1",
            "Yes",
            "Yes"
    };
    private static final String[] results = {
            "Name  Arda Akca",
            "Surname  Buyuk",
            "Birth Date  29/3/2022",
            "City  Ankara",
            "Gender  Male",
            "Vaccine Type Type 1",
            "Side Effect Yes",
            "PCR Positive Yes"
    };
    private Map<String, String> xPathsFields = new HashMap<>();
    private Map<String, String> xPathsResults = new HashMap<>();
    private AppiumDriver driver;
    private WebDriverWait wait;

    public TestSuite(AppiumDriver driver) {
        this.driver = driver;
        for (int i = 0; i < fields.length; i++) {
            xPathsFields.put(fields[i], FIELD_BASE_XPATH.replace('#', Character.forDigit(i+1, 10)));
            xPathsResults.put(fields[i], RESULT_BASE_XPATH.replace('#', Character.forDigit(i+1, 10)));
        }
        wait = new WebDriverWait(driver, 5);
    }

    public void fillAllFieldsExceptName() {
        // Pick a birthdate
        MobileElement dateField = (MobileElement) driver.findElementByXPath(xPathsFields.get("Birth Date"));
        dateField.click();

        // Click on OK to select the birthdate
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("/hierarchy/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.ScrollView/android.widget.LinearLayout/android.widget.Button[2]")));
        MobileElement okButton = (MobileElement) driver.findElementByXPath("/hierarchy/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.ScrollView/android.widget.LinearLayout/android.widget.Button[2]");
        okButton.click();

        // Pick a city
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(xPathsFields.get("City"))));
        MobileElement cityField = (MobileElement) driver.findElementByXPath(xPathsFields.get("City"));
        cityField.click();

        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(FIRST_OPTION_XPATH)));
        MobileElement ankara = (MobileElement) driver.findElementByXPath(FIRST_OPTION_XPATH);
        ankara.click();

        // Pick a gender
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(xPathsFields.get("Gender"))));
        MobileElement genderField = (MobileElement) driver.findElementByXPath(xPathsFields.get("Gender"));
        genderField.click();

        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(FIRST_OPTION_XPATH)));
        MobileElement male = (MobileElement) driver.findElementByXPath(FIRST_OPTION_XPATH);
        male.click();

        // Pick a vaccine type
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(xPathsFields.get("Vaccine Type"))));
        MobileElement vaccineField = (MobileElement) driver.findElementByXPath(xPathsFields.get("Vaccine Type"));
        vaccineField.click();

        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(FIRST_OPTION_XPATH)));
        MobileElement type1 = (MobileElement) driver.findElementByXPath(FIRST_OPTION_XPATH);
        type1.click();

        // Pick a side effect
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(xPathsFields.get("Side Effect"))));
        MobileElement sideEffectField = (MobileElement) driver.findElementByXPath(xPathsFields.get("Side Effect"));
        sideEffectField.click();

        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(FIRST_OPTION_XPATH)));
        MobileElement yes = (MobileElement) driver.findElementByXPath(FIRST_OPTION_XPATH);
        yes.click();

        // Answer PCR Positive question
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(xPathsFields.get("PCR Positive"))));
        MobileElement pcrPositive = (MobileElement) driver.findElementByXPath(xPathsFields.get("PCR Positive"));
        pcrPositive.click();

        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(FIRST_OPTION_XPATH)));
        MobileElement pcrYes = (MobileElement) driver.findElementByXPath(FIRST_OPTION_XPATH);
        pcrYes.click();
    }

    public void testCase1() {
        try {
            boolean success = true;
            // Check if submit button is visible
            try {
                MobileElement submitButton = (MobileElement) driver.findElementByXPath(SUBMIT_XPATH);
                System.out.println("Test Case #1.1 Failed");
                success = false;
            } catch (Exception e) {
                System.out.println("Test Case #1.1 Passed");
            }

            // Fill name field
            MobileElement nameField = (MobileElement) driver.findElementByXPath(xPathsFields.get("Name"));
            nameField.sendKeys("Arda Akca");

            // Check if submit button is visible
            try {
                MobileElement submitButton = (MobileElement) driver.findElementByXPath(SUBMIT_XPATH);
                System.out.println("Test Case #1.2 Failed");
                success = false;
            } catch (Exception e) {
                System.out.println("Test Case #1.2 Passed");
            }

            // Fill surname field
            MobileElement surnameField = (MobileElement) driver.findElementByXPath(xPathsFields.get("Surname"));
            surnameField.sendKeys("Buyuk");

            // Check if submit button is visible
            try {
                MobileElement submitButton = (MobileElement) driver.findElementByXPath(SUBMIT_XPATH);
                System.out.println("Test Case #1.3 Failed");
                success = false;
            } catch (Exception e) {
                System.out.println("Test Case #1.3 Passed");
            }

            // Pick a birthdate
            MobileElement dateField = (MobileElement) driver.findElementByXPath(xPathsFields.get("Birth Date"));
            dateField.click();

            // Click on OK to select the birthdate
            wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("/hierarchy/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.ScrollView/android.widget.LinearLayout/android.widget.Button[2]")));
            MobileElement okButton = (MobileElement) driver.findElementByXPath("/hierarchy/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.ScrollView/android.widget.LinearLayout/android.widget.Button[2]");
            okButton.click();
            wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(xPathsFields.get("Birth Date"))));

            // Check if submit button is visible
            try {
                MobileElement submitButton = (MobileElement) driver.findElementByXPath(SUBMIT_XPATH);
                System.out.println("Test Case #1.4 Failed");
                success = false;
            } catch (Exception e) {
                System.out.println("Test Case #1.4 Passed");
            }

            // Pick a city
            wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(xPathsFields.get("City"))));
            MobileElement cityField = (MobileElement) driver.findElementByXPath(xPathsFields.get("City"));
            cityField.click();


            wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(FIRST_OPTION_XPATH)));
            MobileElement ankara = (MobileElement) driver.findElementByXPath(FIRST_OPTION_XPATH);
            ankara.click();
            wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(xPathsFields.get("City"))));

            // Check if submit button is visible
            try {
                MobileElement submitButton = (MobileElement) driver.findElementByXPath(SUBMIT_XPATH);
                System.out.println("Test Case #1.5 Failed");
                success = false;
            } catch (Exception e) {
                System.out.println("Test Case #1.5 Passed");
            }

            // Pick a gender
            wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(xPathsFields.get("Gender"))));
            MobileElement genderField = (MobileElement) driver.findElementByXPath(xPathsFields.get("Gender"));
            genderField.click();

            wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(FIRST_OPTION_XPATH)));
            MobileElement male = (MobileElement) driver.findElementByXPath(FIRST_OPTION_XPATH);
            male.click();
            wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(xPathsFields.get("Gender"))));

            // Check if submit button is visible
            try {
                MobileElement submitButton = (MobileElement) driver.findElementByXPath(SUBMIT_XPATH);
                System.out.println("Test Case #1.6 Failed");
                success = false;
            } catch (Exception e) {
                System.out.println("Test Case #1.6 Passed");
            }

            // Pick a vaccine type
            wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(xPathsFields.get("Vaccine Type"))));
            MobileElement vaccineField = (MobileElement) driver.findElementByXPath(xPathsFields.get("Vaccine Type"));
            vaccineField.click();

            wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(FIRST_OPTION_XPATH)));
            MobileElement type1 = (MobileElement) driver.findElementByXPath(FIRST_OPTION_XPATH);
            type1.click();
            wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(xPathsFields.get("Vaccine Type"))));

            // Check if submit button is visible
            try {
                MobileElement submitButton = (MobileElement) driver.findElementByXPath(SUBMIT_XPATH);
                System.out.println("Test Case #1.7 Failed");
                success = false;
            } catch (Exception e) {
                System.out.println("Test Case #1.7 Passed");
            }

            // Pick a side effect
            wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(xPathsFields.get("Side Effect"))));
            MobileElement sideEffectField = (MobileElement) driver.findElementByXPath(xPathsFields.get("Side Effect"));
            sideEffectField.click();

            wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(FIRST_OPTION_XPATH)));
            MobileElement yes = (MobileElement) driver.findElementByXPath(FIRST_OPTION_XPATH);
            yes.click();
            wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(xPathsFields.get("Side Effect"))));

            // Check if submit button is visible
            try {
                MobileElement submitButton = (MobileElement) driver.findElementByXPath(SUBMIT_XPATH);
                System.out.println("Test Case #1.8 Failed");
                success = false;
            } catch (Exception e) {
                System.out.println("Test Case #1.8 Passed");
            }

            // Answer PCR Positive question
            wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(xPathsFields.get("PCR Positive"))));
            MobileElement pcrPositive = (MobileElement) driver.findElementByXPath(xPathsFields.get("PCR Positive"));
            pcrPositive.click();

            wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(FIRST_OPTION_XPATH)));
            MobileElement pcrYes = (MobileElement) driver.findElementByXPath(FIRST_OPTION_XPATH);
            pcrYes.click();
            wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(xPathsFields.get("PCR Positive"))));

            // Check if submit button is visible in 3 seconds
            wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(SUBMIT_XPATH)));
            MobileElement submitButton = (MobileElement) driver.findElementByXPath(SUBMIT_XPATH);
            if (success && submitButton.isDisplayed()) {
                System.out.println("Test Case #1 Passed.");
            }
            else {
                System.out.println("Test Case #1 Failed.");
            }
        } catch (Exception e) {
            //e.printStackTrace();
            System.out.println("Test Case #1 Failed.");
        }
    }

    public void testCase2() {
        try {
            boolean success = true;
            // Check if submit button sends the data successfully
            wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(SUBMIT_XPATH)));
            MobileElement submitButton = (MobileElement) driver.findElementByXPath(SUBMIT_XPATH);
            submitButton.click();

            wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(xPathsResults.get("Name"))));
            for (int i = 0; i < fields.length - 1; i++) {
                MobileElement resultField = (MobileElement) driver.findElementByXPath(xPathsResults.get(fields[i]));
                String resultText = resultField.getText();
                if (results[i].equals(resultText)) {
                    System.out.println("Test Case #2." + (i+1) + " Passed.");
                }
                else {
                    System.out.println("Test Case #2." + (i+1) + " Failed.");
                    success = false;
                }
            }
            if (success)
                System.out.println("Test Case #2 Passed.");
            else
                System.out.println("Test Case #2 Failed.");
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("Test Case #2 Failed.");
        }
    }

    public void testCase3() {
        boolean success = true;
        MobileElement changeAnswerButton = (MobileElement) driver.findElementByXPath(CHANGE_ANSWER_XPATH);
        changeAnswerButton.click();

        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(xPathsFields.get("Name"))));

        // Check whether the fields are filled with correct data
        for (int i = 0; i < fields.length - 1; i++) {
            MobileElement field = (MobileElement) driver.findElementByXPath(xPathsFields.get(fields[i]));
            String fieldText = field.getText();
            if (inputs[i].equals(fieldText)) {
                System.out.println("Test Case #3." + (i+1) + " Passed.");
            }
            else {
                System.out.println("Test Case #3." + (i+1) + " Failed.");
                success = false;
            }
        }

        // Check if submit button is visible
        try {
            MobileElement submitButton = (MobileElement) driver.findElementByXPath(SUBMIT_XPATH);
            System.out.println("Test Case #3.9 Failed");
            success = false;
        } catch (Exception e) {
            System.out.println("Test Case #3.9 Passed");
        }

        // Empty name field
        MobileElement nameField = (MobileElement) driver.findElementByXPath(xPathsFields.get("Name"));
        nameField.clear();

        // Check if submit button is visible
        try {
            MobileElement submitButton = (MobileElement) driver.findElementByXPath(SUBMIT_XPATH);
            System.out.println("Test Case #3.10 Failed");
            success = false;
        } catch (Exception e) {
            System.out.println("Test Case #3.10 Passed");
        }

        // Fill name field with another
        nameField.sendKeys("Okyanus");

        // Submit button should be visible by now
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(SUBMIT_XPATH)));
        MobileElement submitButton = null;
        try {
            submitButton = (MobileElement) driver.findElementByXPath(SUBMIT_XPATH);
            System.out.println("Test Case #3.11 Passed");
        } catch (Exception e) {
            System.out.println("Test Case #3.11 Failed");
            success = false;
        }

        // Click on submit button and see whether the information is still correct
        submitButton.click();

        // Check changed field first
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(xPathsResults.get("Name"))));
        MobileElement changed = (MobileElement) driver.findElementByXPath(xPathsResults.get("Name"));
        String expected = "Name  Okyanus";
        if (expected.equals(changed.getText())) {
            System.out.println("Test Case #3.12 Passed.");
        }
        else {
            System.out.println("Test Case #3.12 Failed.");
            success = false;
        }

        // Check unchanged fields whether there is an inconvenience
        for (int i = 1; i < fields.length - 1; i++) {
            MobileElement resultField = (MobileElement) driver.findElementByXPath(xPathsResults.get(fields[i]));
            String resultText = resultField.getText();
            if (results[i].equals(resultText)) {
                System.out.println("Test Case #3." + (i+12) + " Passed.");
            }
            else {
                System.out.println("Test Case #3." + (i+12) + " Failed.");
                success = false;
            }
        }

        if (success)
            System.out.println("Test Case #3 Passed.");
        else
            System.out.println("Test Case #3 Failed.");
    }

    public void testCase4() {
        boolean success = true;
        MobileElement submitSurveyButton = (MobileElement) driver.findElementByXPath(SUBMIT_SURVEY_XPATH);
        submitSurveyButton.click();

        try {
            wait.until(ExpectedConditions.presenceOfElementLocated(By.id("android:id/alertTitle")));
            System.out.println("Test Case #4.1 Passed.");
        } catch (Exception e) {
            System.out.println("Test Case #4.1 Failed.");
            success = false;
        }

        String submitMessage = ((MobileElement) driver.findElementByXPath(SUBMIT_MESSAGE_XPATH)).getText();
        if (submitMessage.equals("Thank you for your participation")) {
            System.out.println("Test Case #4.2 Passed");
        }
        else {
            System.out.println("Test Case #4.2 Failed");
            success = false;
        }

        MobileElement okButton = (MobileElement) driver.findElementByXPath(SUBMIT_MESSAGE_OK_BUTTON_XPATH);
        okButton.click();

        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(xPathsFields.get("Name"))));
        for (int i = 0; i < fields.length - 1; i++) {
            MobileElement field = (MobileElement) driver.findElementByXPath(xPathsFields.get(fields[i]));
            if (field.getText().equals(fields[i])) {
                System.out.println("Test Case #4." + (i+3) + " Passed");
            }
            else {
                System.out.println("Test Case #4." + (i+3) + " Failed");
                success = false;
            }
        }

        if (success)
            System.out.println("Test Case #4 Passed.");
        else
            System.out.println("Test Case #4 Failed.");
    }

    public void testCase5() {
        boolean success = true;
        fillAllFieldsExceptName();

        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(xPathsFields.get("Surname"))));
        // Fill surname field normally
        MobileElement surnameField = (MobileElement) driver.findElementByXPath(xPathsFields.get("Surname"));
        surnameField.sendKeys("Buyuk");

        // Fill name field with beginning with lowercase character
        MobileElement nameField = (MobileElement) driver.findElementByXPath(xPathsFields.get("Name"));
        nameField.sendKeys("arda");

        // Try submitting
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(SUBMIT_XPATH)));
        MobileElement submitButton = (MobileElement) driver.findElementByXPath(SUBMIT_XPATH);

        submitButton.click();

        // Check alert for invalid name or surname
        try {
            wait.until(ExpectedConditions.presenceOfElementLocated(By.id("android:id/alertTitle")));
            System.out.println("Test Case #5.1 Passed.");
        } catch (Exception e) {
            System.out.println("Test Case #5.1 Failed.");
            success = false;
        }

        // Check alert message
        String submitMessage = ((MobileElement) driver.findElementByXPath(SUBMIT_MESSAGE_XPATH)).getText();
        if (submitMessage.equals("Invalid name or surname")) {
            System.out.println("Test Case #5.2 Passed");
        }
        else {
            System.out.println("Test Case #5.2 Failed");
            success = false;
        }

        MobileElement okButton = (MobileElement) driver.findElementByXPath(SUBMIT_MESSAGE_OK_BUTTON_XPATH);
        okButton.click();

        // Fill name field with numeric characters
        nameField = (MobileElement) driver.findElementByXPath(xPathsFields.get("Name"));
        nameField.sendKeys("9347345");

        // Try submitting
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(SUBMIT_XPATH)));
        submitButton = (MobileElement) driver.findElementByXPath(SUBMIT_XPATH);
        submitButton.click();

        // Check alert
        try {
            wait.until(ExpectedConditions.presenceOfElementLocated(By.id("android:id/alertTitle")));
            System.out.println("Test Case #5.3 Passed.");
        } catch (Exception e) {
            System.out.println("Test Case #5.3 Failed.");
            success = false;
        }

        // Check alert message
        submitMessage = ((MobileElement) driver.findElementByXPath(SUBMIT_MESSAGE_XPATH)).getText();
        if (submitMessage.equals("Invalid name or surname")) {
            System.out.println("Test Case #5.4 Passed");
        }
        else {
            System.out.println("Test Case #5.4 Failed");
            success = false;
        }

        okButton = (MobileElement) driver.findElementByXPath(SUBMIT_MESSAGE_OK_BUTTON_XPATH);
        okButton.click();

        // Fill name field with numeric characters
        nameField = (MobileElement) driver.findElementByXPath(xPathsFields.get("Name"));
        nameField.sendKeys("&%&+^^=;.");

        // Try submitting
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(SUBMIT_XPATH)));
        submitButton = (MobileElement) driver.findElementByXPath(SUBMIT_XPATH);
        submitButton.click();

        // Check alert
        try {
            wait.until(ExpectedConditions.presenceOfElementLocated(By.id("android:id/alertTitle")));
            System.out.println("Test Case #5.5 Passed.");
        } catch (Exception e) {
            System.out.println("Test Case #5.5 Failed.");
            success = false;
        }

        // Check alert message
        submitMessage = ((MobileElement) driver.findElementByXPath(SUBMIT_MESSAGE_XPATH)).getText();
        if (submitMessage.equals("Invalid name or surname")) {
            System.out.println("Test Case #5.6 Passed");
        }
        else {
            System.out.println("Test Case #5.6 Failed");
            success = false;
        }

        okButton = (MobileElement) driver.findElementByXPath(SUBMIT_MESSAGE_OK_BUTTON_XPATH);
        okButton.click();

        // Now fill the name field normally
        surnameField = (MobileElement) driver.findElementByXPath(xPathsFields.get("Name"));
        nameField.sendKeys("Arda Akca");

        // Fill surnname field with beginning with lowercase character
        surnameField = (MobileElement) driver.findElementByXPath(xPathsFields.get("Surname"));
        surnameField.sendKeys("buyuk");

        // Try submitting
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(SUBMIT_XPATH)));
        submitButton = (MobileElement) driver.findElementByXPath(SUBMIT_XPATH);
        submitButton.click();

        // Check alert
        try {
            wait.until(ExpectedConditions.presenceOfElementLocated(By.id("android:id/alertTitle")));
            System.out.println("Test Case #5.7 Passed.");
        } catch (Exception e) {
            System.out.println("Test Case #5.7 Failed.");
            success = false;
        }

        // Check alert message
        submitMessage = ((MobileElement) driver.findElementByXPath(SUBMIT_MESSAGE_XPATH)).getText();
        if (submitMessage.equals("Invalid name or surname")) {
            System.out.println("Test Case #5.8 Passed");
        }
        else {
            System.out.println("Test Case #5.8 Failed");
            success = false;
        }

        okButton = (MobileElement) driver.findElementByXPath(SUBMIT_MESSAGE_OK_BUTTON_XPATH);
        okButton.click();

        // Fill surname field with numeric characters
        surnameField = (MobileElement) driver.findElementByXPath(xPathsFields.get("Surname"));
        surnameField.sendKeys("9347345");

        // Try submitting
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(SUBMIT_XPATH)));
        submitButton = (MobileElement) driver.findElementByXPath(SUBMIT_XPATH);
        submitButton.click();

        // Check alert
        try {
            wait.until(ExpectedConditions.presenceOfElementLocated(By.id("android:id/alertTitle")));
            System.out.println("Test Case #5.9 Passed.");
        } catch (Exception e) {
            System.out.println("Test Case #5.9 Failed.");
            success = false;
        }

        // Check alert message
        submitMessage = ((MobileElement) driver.findElementByXPath(SUBMIT_MESSAGE_XPATH)).getText();
        if (submitMessage.equals("Invalid name or surname")) {
            System.out.println("Test Case #5.10 Passed");
        }
        else {
            System.out.println("Test Case #5.10 Failed");
            success = false;
        }

        okButton = (MobileElement) driver.findElementByXPath(SUBMIT_MESSAGE_OK_BUTTON_XPATH);
        okButton.click();

        // Fill surname field with numeric characters
        surnameField = (MobileElement) driver.findElementByXPath(xPathsFields.get("Surname"));
        surnameField.sendKeys("&%&+^^=;.");

        // Try submitting
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(SUBMIT_XPATH)));
        submitButton = (MobileElement) driver.findElementByXPath(SUBMIT_XPATH);
        submitButton.click();

        // Check alert
        try {
            wait.until(ExpectedConditions.presenceOfElementLocated(By.id("android:id/alertTitle")));
            System.out.println("Test Case #5.11 Passed.");
        } catch (Exception e) {
            System.out.println("Test Case #5.11 Failed.");
            success = false;
        }

        // Check alert message
        submitMessage = ((MobileElement) driver.findElementByXPath(SUBMIT_MESSAGE_XPATH)).getText();
        if (submitMessage.equals("Invalid name or surname")) {
            System.out.println("Test Case #5.12 Passed");
        }
        else {
            System.out.println("Test Case #5.12 Failed");
            success = false;
        }

        okButton = (MobileElement) driver.findElementByXPath(SUBMIT_MESSAGE_OK_BUTTON_XPATH);
        okButton.click();

        if (success)
            System.out.println("Test Case #5 Passed.");
        else
            System.out.println("Test Case #5 Failed.");
    }

    public void runTestCases() {
        testCase1();
        testCase2();
        testCase3();
        testCase4();
        testCase5();
    }
}
