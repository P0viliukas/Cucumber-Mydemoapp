package setup;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;
import io.appium.java_client.service.local.AppiumDriverLocalService;
import io.appium.java_client.service.local.AppiumServiceBuilder;

import java.time.Duration;

public class StartStopServer {
    public AppiumDriver driver;

    public void runServer() {
        AppiumDriverLocalService service = new AppiumServiceBuilder()
                .withIPAddress("127.0.0.1")
                .usingAnyFreePort()
                .build();
        service.start();
        System.out.println("Appium service started successfully.");

        UiAutomator2Options options = new UiAutomator2Options()
                .setUdid("emulator-5556")
                .setPlatformName("Android")
                .setPlatformVersion("12.0")
                .setAutomationName("UiAutomator2")
                .setAvdReadyTimeout(Duration.ofSeconds(5))
                .setAvdLaunchTimeout(Duration.ofSeconds(5))
                .setApp(System.getProperty("user.dir")+"/app/Android-MyDemoAppRN.1.3.0.build-244.apk")
                .eventTimings();


        driver = new AndroidDriver(service.getUrl(), options);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
    }

    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
}
