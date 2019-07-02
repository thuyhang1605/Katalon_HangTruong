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

'Go to Dropdown list page and verify title'
WebUI.callTestCase(findTestCase('Common/Go to page and verify title'), [('p_FunctionName') : 'Dropdown', ('p_HeaderTitle') : 'Dropdown List'], 
    FailureHandling.STOP_ON_FAILURE)

'Select item by label \'\'Option 2\' '
WebUI.selectOptionByLabel(findTestObject('Page_Dropdown List/Dropdown list'), 'Option 2', false)

'Verify the current item is \'Option 2\''
WebUI.verifyOptionSelectedByLabel(findTestObject('Page_Dropdown List/Dropdown list'), 'Option 2', false, 30)

'Select item by index 1'
WebUI.selectOptionByIndex(findTestObject('Page_Dropdown List/Dropdown list'), 1, FailureHandling.STOP_ON_FAILURE)

'The current item is \'Option 1\''
WebUI.verifyOptionSelectedByLabel(findTestObject('Page_Dropdown List/Dropdown list'), 'Option 1', false, 30)

'Select item by value 2'
WebUI.selectOptionByValue(findTestObject('Page_Dropdown List/Dropdown list'), '2', false)

'The current item is \'Option 2\''
WebUI.verifyOptionSelectedByLabel(findTestObject('Page_Dropdown List/Dropdown list'), 'Option 2', false, 30)

