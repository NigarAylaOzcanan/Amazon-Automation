package utilities;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.awt.*;
import java.awt.datatransfer.StringSelection;
import java.awt.event.InputEvent;
import java.awt.event.KeyEvent;
import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

public class ReusableMethods {

    public WebDriverWait wait = new WebDriverWait(GWD.getDriver(), Duration.ofSeconds(ConfigReader.getIntProperty("explicit.wait")));

    public void clickFunction(WebElement element) {
        wait.until(ExpectedConditions.elementToBeClickable(element));
        scrollToElement(element);
        element.click();
    }

    public void clickWithFallBack(WebElement element) {
        try {
            wait.until(ExpectedConditions.elementToBeClickable(element));
            scrollToElement(element);
            element.click();
        } catch (Exception e) {
            wait.until(ExpectedConditions.elementToBeClickable(element));
            JavascriptExecutor js = (JavascriptExecutor) GWD.getDriver();
            js.executeScript("arguments[0].click();", element);
        }
    }

    public void sendKeysFunction(WebElement element, String text) {
        wait.until(ExpectedConditions.visibilityOf(element));
        scrollToElement(element);
        element.clear();
        element.sendKeys(text);
    }

    public void sendKeysJS(WebElement element, String text) {
        JavascriptExecutor js = (JavascriptExecutor) GWD.getDriver();
        js.executeScript("arguments[0].value='" + text + "'", element);
    }

    public static void scrollToElement(WebElement element) {
        JavascriptExecutor js = (JavascriptExecutor) GWD.getDriver();
        js.executeScript("arguments[0].scrollIntoView();", element);
    }

    public static void scrollToHome() {
        JavascriptExecutor js = (JavascriptExecutor) GWD.getDriver();
        js.executeScript("window.scrollTo(0,-document.body.scrollHeight)");
    }

    public static void scrollToEnd() {
        JavascriptExecutor js = (JavascriptExecutor) GWD.getDriver();
        js.executeScript("window.scrollTo(0,document.body.scrollHeight)");
    }

    public String jsGetText(WebElement element) {
        wait.until(ExpectedConditions.visibilityOf(element));
        JavascriptExecutor js = (JavascriptExecutor) GWD.getDriver();
        return (String) (js.executeScript("arguments[0].textContent;", element));
    }

    public void jsClick(WebElement element) {
        wait.until(ExpectedConditions.elementToBeClickable(element));
        JavascriptExecutor js = (JavascriptExecutor) GWD.getDriver();
        js.executeScript("arguments[0].click();", element);
    }

    public static void sendAttributeJS(WebElement element, String text) {
        JavascriptExecutor js = (JavascriptExecutor) GWD.getDriver();
        js.executeScript("arguments[0].setAttribute('value','" + text + "')", element);
    }

    public static void getValueByJS(String id, String attributeName) {
        JavascriptExecutor js = (JavascriptExecutor) GWD.getDriver();
        String attributeValue = (String) js.executeScript("return document.getElementById('" + id + "')." + attributeName);
        System.out.println("Attribute Value: " + attributeValue);
    }

    public static void clearByJs(WebElement element) {
        JavascriptExecutor jse = (JavascriptExecutor) GWD.getDriver();
        jse.executeScript("arguments[0].value = '';", element);
    }

    public static void highlightElement(WebElement element) {
        JavascriptExecutor js = (JavascriptExecutor) GWD.getDriver();
        js.executeScript("arguments[0].style.border='3px solid red'", element);
    }

    public void verifyContainsText(WebElement element, String value) {
        wait.until(ExpectedConditions.textToBePresentInElement(element, value));
        Assert.assertTrue(element.getText().toLowerCase().contains(value.toLowerCase()));

        new Actions(GWD.getDriver()).sendKeys(Keys.ESCAPE).build().perform();

    }

    public static void checkTextContains(WebElement element, String text) {
        WebDriverWait wait = new WebDriverWait(GWD.getDriver(), Duration.ofSeconds(ConfigReader.getIntProperty("explicit.wait")));
        WebElement elementName = wait.until(ExpectedConditions.visibilityOf(element));
        if (elementName.getText().trim().toLowerCase().contains(text.trim().toLowerCase())) {
            Assert.assertTrue(true);
        } else
            Assert.fail(text + " not found! Element text :" + elementName.getText());
    }

    public void selectByIndex(WebElement element, int num) {
        wait.until(ExpectedConditions.visibilityOf(element));
        Select menu = new Select(element);
        menu.selectByIndex(num);
    }

    public void selectByText(WebElement element, String text) {
        wait.until(ExpectedConditions.visibilityOf(element));
        Select select = new Select(element);
        select.selectByVisibleText(text);
    }

    //DropDown Value
    public void selectByValue(WebElement element, String value) {
        wait.until(ExpectedConditions.visibilityOf(element));
        Select select = new Select(element);
        select.selectByValue(value);
    }

    public void hoverOver(WebElement element) {
        wait.until(ExpectedConditions.visibilityOf(element));
        new Actions(GWD.getDriver()).moveToElement(element).build().perform();
    }

    public void uploadFileFunction(String pathFile) {
        Robot robot;
        try {
            robot = new Robot();
        } catch (AWTException e) {
            throw new RuntimeException(e);
        }

        StringSelection createPathFile = new StringSelection(pathFile);
        Toolkit.getDefaultToolkit().getSystemClipboard().setContents(createPathFile, null);

        wait(1);
        robot.keyPress(KeyEvent.VK_CONTROL);
        robot.keyPress(KeyEvent.VK_V);

        robot.keyRelease(KeyEvent.VK_V);
        robot.keyRelease(KeyEvent.VK_CONTROL);

        wait(1);
        robot.keyPress(KeyEvent.VK_ENTER);
        robot.keyRelease(KeyEvent.VK_ENTER);
        wait(1);
    }

    public static void tabKeyMultiplePress(int quantity) {
        Robot robot;
        try {
            robot = new Robot();
        } catch (AWTException e) {
            throw new RuntimeException(e);
        }

        for (int i = 0; i < quantity; i++) {
            robot.delay(500);
            robot.keyPress(KeyEvent.VK_TAB);
            robot.keyRelease(KeyEvent.VK_TAB);
        }
    }

    public static void enterKeyMultiplePress(int quantity) {
        Robot robot;
        try {
            robot = new Robot();
        } catch (AWTException e) {
            throw new RuntimeException(e);
        }

        for (int i = 0; i < quantity; i++) {
            robot.delay(1000);
            robot.keyPress(KeyEvent.VK_ENTER);
            robot.keyRelease(KeyEvent.VK_ENTER);
        }
    }

    public static void leftClickMultiplePress(int quantity) {
        Robot robot;
        try {
            robot = new Robot();
        } catch (AWTException e) {
            throw new RuntimeException(e);
        }

        for (int i = 0; i < quantity; i++) {
            robot.delay(1000);
            robot.mousePress(InputEvent.BUTTON1_DOWN_MASK);
            robot.mouseRelease(InputEvent.BUTTON1_DOWN_MASK);
            robot.delay(1000);
        }
    }

    public static int randomGenerator(int range) {
        return (int) (Math.random() * range);
    }

    public void waitUntilVisibilityOf(WebElement element) {
        wait.until(ExpectedConditions.visibilityOf(element));
    }

    public void waitUntilElementToBeClickable(WebElement element) {
        wait.until(ExpectedConditions.elementToBeClickable(element));
    }

    public static void waitForPageTitle(String title) {
        WebDriverWait wait = new WebDriverWait(GWD.getDriver(), Duration.ofSeconds(ConfigReader.getIntProperty("explicit.wait")));
        wait.until(ExpectedConditions.titleIs(title));
    }

    public static String getAttribute(WebElement element, String attribute) {
        return element.getAttribute(attribute);
    }

    public void loadingBarWait(WebElement element) {
        wait.until(ExpectedConditions.attributeToBe(element, "style", "height: 2px;"));
    }

    public static void switchToParentFrame() {
        GWD.getDriver().switchTo().parentFrame();
    }

    public void iframeSwitchByIndex(int index) {
        wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(index));
    }

    public void iframeSwitchByNameOrId(String nameOrId) {
        wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(nameOrId));
    }

    public void iframeSwitchByElement(WebElement iframeElement) {
        wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(iframeElement));
    }

    public static void switchToDefaultContent() {
        GWD.getDriver().switchTo().defaultContent();
    }

    public static void clearCookies() {
        GWD.getDriver().manage().deleteAllCookies();
    }

    public static void acceptAllCookies() {
        java.util.List<WebElement> acceptButtons = GWD.getDriver().findElements(By.xpath("//button[contains(text(),'Accept')]"));
        if (!acceptButtons.isEmpty()) {
            acceptButtons.get(0).click();
        }
    }

    public static boolean listContainsString(java.util.List<WebElement> list, String search) {
        boolean isFound = false;
        for (WebElement e : list) {
            if (e.getText().equalsIgnoreCase(search))
                isFound = true;
        }
        return isFound;
    }

    public static boolean compareLists(java.util.List<WebElement> list1, java.util.List<String> list2) {
        // Check if the lists are of equal size.
        if (list1.size() != list2.size()) {
            return false;
        }

        // Iterate through the elements of both lists and compare them.
        for (int i = 0; i < list1.size(); i++) {
            if (!list1.get(i).getText().equals(list2.get(i))) {
                return false;
            }
        }
        return true;
    }

    public static void wait(int sn) {
        try {
            Thread.sleep(sn * 1000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    public static void captureScreenshot(String fileName) {
        File screenshot = ((TakesScreenshot) GWD.getDriver()).getScreenshotAs(OutputType.FILE);
        try {
            FileUtils.copyFile(screenshot, new File("screenshots/" + fileName + ".png"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void selectRadioButtonByValue(java.util.List<WebElement> radioButtons, String value) {
        for (WebElement radioButton : radioButtons) {
            if (radioButton.getAttribute("value").equalsIgnoreCase(value)) {
                if (!radioButton.isSelected()) {
                    radioButton.click();
                }
                break;
            }
        }
    }

    //Alert ACCEPT
    public static void alertAccept(int timeout) {
        WebDriverWait wait = new WebDriverWait(GWD.getDriver(), Duration.ofSeconds(timeout));
        wait.until(ExpectedConditions.alertIsPresent());
        GWD.getDriver().switchTo().alert().accept();
    }

    public static void alertDismiss() {
        GWD.getDriver().switchTo().alert().dismiss();
    }

    public static void alertWait(int timeout) {
        WebDriverWait wait = new WebDriverWait(GWD.getDriver(), Duration.ofSeconds(timeout));
        wait.until(ExpectedConditions.alertIsPresent());
    }

    public static void alertText() {
        GWD.getDriver().switchTo().alert().getText();
    }

    public static void alertPromptBox(String text) {
        GWD.getDriver().switchTo().alert().sendKeys(text);
    }

    public static void refreshPage() {
        GWD.getDriver().navigate().refresh();
    }

    public static String getCurrentURL() {
        return GWD.getDriver().getCurrentUrl();
    }

    public static void switchToWindow(int num) {
        List<String> windowHandlesAll = new ArrayList<String>(GWD.getDriver().getWindowHandles());
        GWD.getDriver().switchTo().window(windowHandlesAll.get(num));
    }

    public static void switchToWindow2(int num) {
        GWD.getDriver().switchTo().window(GWD.getDriver().getWindowHandles().toArray()[num].toString());
    }

    public static void waitForNumberOfWindowsToEqual(int numberOfWindows) {
        WebDriverWait wait = new WebDriverWait(GWD.getDriver(), Duration.ofSeconds(ConfigReader.getIntProperty("explicit.wait")));
        wait.until(ExpectedConditions.numberOfWindowsToBe(numberOfWindows));
    }
}
