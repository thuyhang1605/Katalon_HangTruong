import static com.kms.katalon.core.checkpoint.CheckpointFactory.findCheckpoint
import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import com.kms.katalon.core.checkpoint.Checkpoint as Checkpoint
import com.kms.katalon.core.cucumber.keyword.CucumberBuiltinKeywords as CucumberKW
import com.kms.katalon.core.mobile.keyword.MobileBuiltInKeywords as Mobile
import com.kms.katalon.core.model.FailureHandling as FailureHandling
import com.kms.katalon.core.testcase.TestCase as TestCase
import com.kms.katalon.core.testdata.TestData as TestData
import com.kms.katalon.core.testobject.TestObject as TestObject
import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords as WS
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import internal.GlobalVariable as GlobalVariable

'Go to page and verify title'
WebUI.callTestCase(findTestCase('Common/Go to page and verify title'), [('p_FunctionName') : 'Challenging DOM', ('p_HeaderTitle') : 'Challenging DOM'], 
    FailureHandling.STOP_ON_FAILURE)

'Verify font size'
String fontSize = WebUI.getCSSValue(findTestObject('Page_Color and Font/bt_foo'), 'font-size')

WebUI.verifyEqual(fontSize, '16px')

'Verify background color'
String background = WebUI.getCSSValue(findTestObject('Page_Color and Font/bt_Second Red button'), 'background-color')

WebUI.verifyEqual(true, (background == 'rgb(198, 15, 19)') || (background == 'rgba(198, 15, 19, 1)'))

'Verify border color'
String bordertop = WebUI.getCSSValue(findTestObject('Page_Color and Font/bt_Third Green button'), 'border-top-color')

WebUI.verifyEqual(true, (bordertop == 'rgb(69, 122, 26)') || (bordertop == 'rgba(69, 122, 26, 1)'))

