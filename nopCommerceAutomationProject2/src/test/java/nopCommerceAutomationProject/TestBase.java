package nopCommerceAutomationProject;

 import java.io.File;
 import java.io.FileInputStream;
 import java.io.IOException;

 import org.apache.poi.ss.usermodel.Row;
 import org.apache.poi.ss.usermodel.Sheet;
 import org.apache.poi.xssf.usermodel.XSSFWorkbook;
 import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import io.github.bonigarcia.wdm.WebDriverManager;

	public class TestBase {

		public static WebDriver driver;
		public static String happyScenarioData;
		public static String badScenarioData;

		public static void setup() throws IOException {

			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
			driver.get("https://demo.nopcommerce.com/");
			driver.manage().window().maximize();

		}

		public static Object[][] getDataFromSheet(String sheetName, int startRow, int noOfTestCases) throws Exception {
			File file = new File( "src\\test\\resources\\TestData\\Data Sheet.xlsx");
			FileInputStream fileInputStream = new FileInputStream(file);
			XSSFWorkbook workbook = new XSSFWorkbook(fileInputStream);
			Sheet sheet = workbook.getSheet(sheetName);
			int cols = sheet.getRow(startRow).getLastCellNum();
			Object data[][] = new Object[noOfTestCases][cols];
			for (int i = startRow; i < startRow + noOfTestCases; i++) {
				for (int j = 0; j < cols; j++) {
					data[i - startRow][j] = sheet.getRow(i).getCell(j).toString();
				}
			}
			workbook.close();
			fileInputStream.close();
			return data;
		}

	}



