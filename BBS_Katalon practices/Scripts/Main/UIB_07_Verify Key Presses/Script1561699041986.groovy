import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject

import java.awt.Robot as Robot

import com.kms.katalon.core.model.FailureHandling as FailureHandling
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI

import java.awt.event.KeyEvent as KeyEvent

'go to page and verify title'
WebUI.callTestCase(findTestCase('Common/Go to page and verify title'), [('p_FunctionName') : 'Key Presses', ('p_HeaderTitle') : 'Key Presses'], 
    FailureHandling.STOP_ON_FAILURE)

'Verify the ENTER key'
Robot rbt = new Robot()

rbt.keyPress(KeyEvent.VK_ENTER)

WebUI.verifyElementAttributeValue(findTestObject('Page_Key Press/result Message'), 'textContent', 'You entered: ENTER',5)

'Verify the TAB key'
rbt.keyPress(KeyEvent.VK_TAB)

WebUI.verifyElementAttributeValue(findTestObject('Page_Key Press/result Message'), 'textContent', 'You entered: TAB',5)

'Verify the G key'
rbt.keyPress(KeyEvent.VK_G)
WebUI.verifyElementAttributeValue(findTestObject('Page_Key Press/result Message'), 'textContent', 'You entered: G',5)



