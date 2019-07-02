import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject

import org.openqa.selenium.WebElement as WebElement

import com.kms.katalon.core.model.FailureHandling as FailureHandling
import com.kms.katalon.core.webui.common.WebUiCommonHelper as WebUiCommonHelper
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI


'CLick Drag and Drop link and open the page'
WebUI.openBrowser('')

WebUI.navigateToUrl('https://the-internet.herokuapp.com/')

WebUI.click(findTestObject('null'))



'Set source object is Column A'
WebElement source = WebUiCommonHelper.findWebElement(findTestObject('Object Repository/Page_Drap and Drop/columnA'), 30)
'Set target object is column B'
WebElement target = WebUiCommonHelper.findWebElement(findTestObject('Object Repository/Page_Drap and Drop/columnB'), 30)
'Define java script content'
String scriptContent ="var src=arguments[0],tgt=arguments[1];var dataTransfer={dropEffe" +
		"ct:'',effectAllowed:'all',files:[],items:{},types:[],setData:fun" +
		"ction(format,data){this.items[format]=data;this.types.append(for" +
		"mat);},getData:function(format){return this.items[format];},clea" +
		"rData:function(format){}};var emit=function(event,target){var ev" +
		"t=document.createEvent('Event');evt.initEvent(event,true,false);" +
		"evt.dataTransfer=dataTransfer;target.dispatchEvent(evt);};emit('" +
		"dragstart',src);emit('dragenter',tgt);emit('dragover',tgt);emit(" +
		"'drop',tgt);emit('dragend',src);";
'Execute Java Script to drag and drop source object to target object'
WebUI.executeJavaScript(scriptContent, Arrays.asList(source,target))

'Verify Column A\'s name is changed to \'B\''
WebUI.verifyElementText(findTestObject('Object Repository/Page_Drap and Drop/columnA'), 'B')

'Verify Column B\'s name is changed to \'A\''
WebUI.verifyElementText(findTestObject('Object Repository/Page_Drap and Drop/columnB'), 'A')

WebUI.closeBrowser()