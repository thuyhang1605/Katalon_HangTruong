import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import org.openqa.selenium.WebElement as WebElement
import com.kms.katalon.core.webui.common.WebUiCommonHelper as WebUiCommonHelper
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

'Go to iFarme Editor page'
WebUI.click(findTestObject('General/lnk_Function Name', [('linkName') : 'WYSIWYG Editor']))

'Verify header title'
WebUI.verifyElementText(findTestObject('General/lbl_Header title'), 'An iFrame containing the TinyMCE WYSIWYG Editor')

'Verify the default content'
String default_content = WebUI.getText(findTestObject('Page_Editor iFrame/iframe content'))

WebUI.verifyEqual(default_content, 'Your content goes here.')

'Set new content "Hello, how are you?"'
WebUI.setText(findTestObject('Page_Editor iFrame/iframe content'), 'Hello, how are you?')

'Verify new content use Element text'
WebUI.verifyElementText(findTestObject('Page_Editor iFrame/iframe content'), 'Hello, how are you?')

'Verify new content use Element Atrribute value'
WebUI.verifyElementAttributeValue(findTestObject('Page_Editor iFrame/iframe content'), 'innerText', 'Hello, how are you?', 
    5)

