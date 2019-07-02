import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import org.openqa.selenium.WebDriver as WebDriver
import com.kms.katalon.core.model.FailureHandling as FailureHandling
import com.kms.katalon.core.webui.driver.DriverFactory as DriverFactory
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import com.kms.katalon.core.mobile.keyword.MobileBuiltInKeywords as Mobile
import com.kms.katalon.core.cucumber.keyword.CucumberBuiltinKeywords as CucumberKW
import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords as WS
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.checkpoint.CheckpointFactory.findCheckpoint
import com.kms.katalon.core.testcase.TestCase as TestCase
import com.kms.katalon.core.testdata.TestData as TestData
import com.kms.katalon.core.testobject.TestObject as TestObject
import com.kms.katalon.core.checkpoint.Checkpoint as Checkpoint
import internal.GlobalVariable as GlobalVariable

'go to page and verify title'
WebUI.callTestCase(findTestCase('Common/Go to page and verify title'), [('p_FunctionName') : 'JavaScript Alerts', ('p_HeaderTitle') : 'JavaScript Alerts'], 
    FailureHandling.STOP_ON_FAILURE)

WebUI.click(findTestObject('Page_Alert/bt_JS Alert'))

'Getting the text from the alert and storing it in Variable'
String AlertText = WebUI.getAlertText()

'Verifying the Actual and Expected text from Alert'
WebUI.verifyEqual(AlertText, 'I am a JS Alert')

'Click \'Click for JS Alert\' button'
WebUI.acceptAlert()

'Verify Result message is: You successfuly clicked an alert'
WebUI.verifyElementText(findTestObject('Page_Alert/Result'), 'You successfuly clicked an alert')

'Click \'Click for JS Confirm\' button'
WebUI.click(findTestObject('Page_Alert/bt_JS Confirm'))

'Click \'Cancel\' button to close Alert'
WebUI.dismissAlert()

'Verify Result message is: You clicked: Cancel'
WebUI.verifyElementText(findTestObject('Page_Alert/Result'), 'You clicked: Cancel')

'Click \'Click for JS Prompt\' button'
WebUI.click(findTestObject('Page_Alert/bt_JS Prompt'))

'Set text "Hello"'
WebUI.setAlertText('Hello')

'Click \'OK\' button to close Alert'
WebUI.acceptAlert()

'Verify Result message is "You entered: Hello"'
WebUI.verifyElementText(findTestObject('Page_Alert/Result'), 'You entered: Hello')

