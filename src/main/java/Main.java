public class Main {
    public static void main(String[] args) {
        String deviceName = "Pixel XL API 30";
        String deviceId = "emulator-5554";
        String platformName = "Android";
        String platformVersion = "11";
        String appPackage = "com.ardaakcabuyuk.Project2";
        String appActivity = "com.ardaakcabuyuk.Project2.MainActivity";

        Appium.getInstance().initAppium(deviceName,deviceId,platformName,platformVersion,appPackage,appActivity);

        TestSuite testSuite = new TestSuite(Appium.getDriver());
        testSuite.runTestCases();
    }
}
