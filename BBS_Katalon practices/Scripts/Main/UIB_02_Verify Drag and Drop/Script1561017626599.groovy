import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import org.openqa.selenium.JavascriptExecutor as JavascriptExecutor
import org.openqa.selenium.WebDriver as WebDriver
import org.openqa.selenium.WebElement as WebElement
import com.kms.katalon.core.webui.common.WebUiCommonHelper as WebUiCommonHelper
import com.kms.katalon.core.webui.driver.DriverFactory as DriverFactory
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import com.kms.katalon.core.mobile.keyword.MobileBuiltInKeywords as Mobile
import com.kms.katalon.core.cucumber.keyword.CucumberBuiltinKeywords as CucumberKW
import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords as WS
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.checkpoint.CheckpointFactory.findCheckpoint
import com.kms.katalon.core.model.FailureHandling as FailureHandling
import com.kms.katalon.core.testcase.TestCase as TestCase
import com.kms.katalon.core.testdata.TestData as TestData
import com.kms.katalon.core.testobject.TestObject as TestObject
import com.kms.katalon.core.checkpoint.Checkpoint as Checkpoint
import internal.GlobalVariable as GlobalVariable

WebUI.callTestCase(findTestCase('Common/Go to page and verify title'), [('p_FunctionName') : 'Drag and Drop', ('p_HeaderTitle') : 'Drag and Drop'], 
    FailureHandling.STOP_ON_FAILURE)

//WebElement source = WebUiCommonHelper.findWebElement(findTestObject('Object Repository/Page_Drap and Drop/columnA'), 30)
//WebElement taget = WebUiCommonHelper.findWebElement(findTestObject('Object Repository/Page_Drap and Drop/columnB'), 30)
String itemA = '#column-a'

String itemB = '#column-b'

'Drag and Drop A to B'
dragAndDrop(itemA, itemB)

String v_header = WebUI.getText(findTestObject('Page_Drap and Drop/columnA'))

'Verity header of column B'
WebUI.verifyEqual(v_header, 'B')

void dragAndDrop(String itemA, String itemB) {
    WebDriver driver = DriverFactory.getWebDriver()

    String basePath = new File('').getAbsolutePath()

    String filePath = 'C:\\Users\\hangtruong\\IdeaProjects\\SeleniumForTester\\src\\test\\resources\\drag_and_drop_helper.js'

    StringBuilder buffer = new StringBuilder()

    String line

    BufferedReader br = new BufferedReader(new FileReader(filePath))

    while ((line = br.readLine()) != null) {
        buffer.append(line)
    }
    
    String javaScript = buffer.toString() + String.format(((('$(\'' + itemA) + '\').simulateDragDrop({ dropTarget: \'') + 
        itemB) + '\'});')

        ((driver) as JavascriptExecutor).executeScript(javaScript)
}

