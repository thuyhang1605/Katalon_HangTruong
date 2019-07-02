import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject

import org.openqa.selenium.WebElement as WebElement
import org.openqa.selenium.interactions.Actions

import com.kms.katalon.core.model.FailureHandling as FailureHandling
import com.kms.katalon.core.webui.driver.DriverFactory as DF
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import com.kms.katalon.core.testobject.TestObject as TestObject

'go to page and verify title'
WebUI.callTestCase(findTestCase('Common/Go to page and verify title'), [('p_FunctionName') : 'Horizontal Slider', ('p_HeaderTitle') : 'Horizontal Slider'], 
    FailureHandling.STOP_ON_FAILURE)

def driver = DF.getWebDriver()

TestObject slider = findTestObject('Object Repository/Page_Slider/Slider')
TestObject rangeValueObject = findTestObject('Page_Slider/Range')

'Set Slider range and verify range value'
setSliderRange(slider,4.0)
'Verify range value is correct'
WebUI.verifyEqual(getCurrentSliderValue(rangeValueObject), 4.0)


double getCurrentSliderValue(TestObject rangeValueObject) {
String value=WebUI.getText(rangeValueObject)
return Double.parseDouble(value)
}

void setSliderRange(TestObject slider,double rangeValue) {
Double maxRange=Double.parseDouble(WebUI.getAttribute(slider, 'max'))
int oneRangeValue = WebUI.getElementWidth(slider)/maxRange
int expectedXCoord = (int) ((rangeValue - maxRange/2) * oneRangeValue)
WebUI.dragAndDropByOffset(slider, expectedXCoord, 0)
}




