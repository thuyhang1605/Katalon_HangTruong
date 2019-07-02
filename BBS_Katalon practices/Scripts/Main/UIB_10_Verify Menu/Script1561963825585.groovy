import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import org.openqa.selenium.By as By
import org.openqa.selenium.WebElement as WebElement
import org.openqa.selenium.support.ui.ExpectedConditions as ExpectedConditions
import com.kms.katalon.core.model.FailureHandling as FailureHandling
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

WebUI.callTestCase(findTestCase('Common/Go to page and verify title'), [('p_FunctionName') : 'JQuery UI Menus', ('p_HeaderTitle') : 'JQueryUI - Menu'], 
    FailureHandling.STOP_ON_FAILURE)

'Select Enabled -> JQuery UI menu'
WebUI.click(findTestObject('Page_Menu/Enable Menu'))

WebUI.waitForElementVisible(findTestObject('Page_Menu/JQuery UI menu'), 10)

WebUI.click(findTestObject('Page_Menu/JQuery UI menu'))

'Verify JQuery UI header title is displayed'
WebUI.verifyElementText(findTestObject('General/lbl_Header title'), 'JQuery UI')

'Click on Menu link'
WebUI.click(findTestObject('Page_Menu/Menu_link'))

'Verify JQueryUI - Menu header title is displayed'
WebUI.verifyElementText(findTestObject('General/lbl_Header title'), 'JQueryUI - Menu')

'Select Enabled -> Downloads -> CSV menu'
WebUI.click(findTestObject('Page_Menu/Enable Menu'))

WebUI.waitForElementVisible(findTestObject('Page_Menu/Downloads menu'), 5)

WebUI.click(findTestObject('Page_Menu/Downloads menu'))

WebUI.waitForElementVisible(findTestObject('Page_Menu/CSV_link'), 5)

'Delete the file if it is existing'

CustomKeywords.'htPackage.FileDownloaded.deleteFile'('C:\\Users\\hangtruong\\Downloads\\', 'menu.csv')

WebUI.click(findTestObject('Page_Menu/CSV_link'))

CustomKeywords.'htPackage.FileDownloaded.waitUntilFileDownloaded'('C:\\Users\\hangtruong\\Downloads\\', 'menu.csv', 5, 1)

//WebUI.verifyEqual(CustomKeywords.'htPackage.FileDownloaded.isFileDownloaded'('C:\\Users\\hangtruong\\Downloads\\', 'menu.csv'), true)
	
CustomKeywords.'htPackage.FileDownloaded.deleteFile'('C:\\Users\\hangtruong\\Downloads\\', 'menu.csv')

