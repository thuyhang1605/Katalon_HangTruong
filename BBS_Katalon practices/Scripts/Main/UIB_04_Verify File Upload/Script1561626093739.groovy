import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import com.kms.katalon.core.configuration.RunConfiguration as RunConfiguration
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

WebUI.callTestCase(findTestCase('Common/Go to page and verify title'), [('p_FunctionName') : 'File Upload', ('p_HeaderTitle') : 'File Uploader'], 
    FailureHandling.STOP_ON_FAILURE)

'Chose a file to upload'
WebUI.uploadFile(findTestObject('Page_File Upload/Upload file'), RunConfiguration.getProjectDir().replace('/', '\\') + '\\Data Files\\abc.jpg')

'Submit uploading'
WebUI.click(findTestObject('Page_File Upload/Upload button'))

'Verify that the chosen file is upload successful'
WebUI.verifyElementText(findTestObject('Page_File Upload/File Uploaded page title'), 'File Uploaded!')

WebUI.verifyElementText(findTestObject('Page_File Upload/Uploaded file title'), 'abc.jpg')

