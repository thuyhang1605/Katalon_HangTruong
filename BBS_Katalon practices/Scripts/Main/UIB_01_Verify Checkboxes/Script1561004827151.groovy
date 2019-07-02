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
import org.openqa.selenium.Keys as Keys

'Go to page and verify header title'
WebUI.callTestCase(findTestCase('Common/Go to page and verify title'), [('p_FunctionName') : 'Checkboxes', ('p_HeaderTitle') : 'Checkboxes'],
	FailureHandling.STOP_ON_FAILURE)

'Checked on checkbox1'
WebUI.check(findTestObject('Page_Checkboxes/checkbox1'))

'Verify checkbox1 is checked'
WebUI.verifyElementChecked(findTestObject('Page_Checkboxes/checkbox1'), 5)

'unChecked on checkbox2'
WebUI.uncheck(findTestObject('Page_Checkboxes/checkbox2'))

'Verify checkbox2 is unchecked'
WebUI.verifyElementNotChecked(findTestObject('Page_Checkboxes/checkbox2'), 5)



