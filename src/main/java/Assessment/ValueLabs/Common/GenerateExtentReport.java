package Assessment.ValueLabs.Common;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;

import org.apache.commons.io.FileUtils;
import org.apache.commons.io.IOExceptionWithCause;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import com.relevantcodes.extentreports.ExtentReports;

import Assessment.ValueLabs.Utility.CommonUtility;
import Assessment.ValueLabs.Utility.TestBase_Setup;

public class GenerateExtentReport extends TestBase_Setup {
		
			static String folderPath;

			public GenerateExtentReport() {
			}

			public void init() {
				extent = new ExtentReports(createFolder() + "/ExtentReport.html", true);
				// extent.addSystemInfo("Environment","Environment Name")
				extent.addSystemInfo("Host Name", "Prodapt").addSystemInfo("Environment", "Automation Testing")
						.addSystemInfo("User Name", System.getProperty("user.home"));
				extent.loadConfig(new File(System.getProperty("user.dir") + "/extent-config.xml"));
			}

			public String getScreenshot() throws IOException {
				int imageName = randomNumberGenerator();
				TakesScreenshot ts = (TakesScreenshot) mobileDriver;
				File source = ts.getScreenshotAs(OutputType.FILE);
				String destination = folderPath + "/screenshot/" + TestBase_Setup.className + "/" + imageName + ".png";
				File finalDestination = new File(destination);
				FileUtils.copyFile(source, finalDestination);
				// Returns the captured file path
				return destination;
			}

			public static String createFolder() {
				String dateName = new SimpleDateFormat("yyyy-MM-dd-hhmmss").format(new Date());
				File f = new File(System.getProperty("user.dir") + "/reports/" + dateName);
				// Create directory with specified name, true is returned if created.
				boolean flag = f.mkdir();
				System.out.println(f.getAbsolutePath());
				folderPath = f.getAbsolutePath();
				// Print whether true/false
				System.out.println("Directory created (T/F)? " + flag);
				return folderPath;
			}
			
			public static int randomNumberGenerator()
			{
				Random t = new Random();
				return t.nextInt(100000);
			}
}
