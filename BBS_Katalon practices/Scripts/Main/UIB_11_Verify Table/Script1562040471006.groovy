import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import com.google.common.collect.Ordering as Ordering
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

'go to page and verify title'
WebUI.callTestCase(findTestCase('Common/Go to page and verify title'), [('p_FunctionName') : 'Sortable Data Tables', ('p_HeaderTitle') : 'Data Tables'], 
    FailureHandling.STOP_ON_FAILURE)

'Verify header at column 3 on Table 1 is Email'
WebUI.verifyElementText(findTestObject('Page_Table/Header column', ['tableName' : 'table1']), 'Email')


'Verify cell value (row 3, column 2) on Table 1 is Jason'
WebUI.verifyElementAttributeValue(findTestObject('Page_Table/cellTable', [('tableName') : 'table1', ('rowIndex') : 3
            , ('columnIndex') : 2]), 'innerText', 'Jason', 3)

'Verify cell value (row 2, column 4) on Table 1 is $51.00'
WebUI.verifyElementAttributeValue(findTestObject('Page_Table/cellTable', [('tableName') : 'table1', ('rowIndex') : 2
            , ('columnIndex') : 4]), 'innerText', '$51.00', 3)

WebUI.click(findTestObject('Page_Table/Header column', ['tableName' : 'table2']))

ArrayList<String> sortedList = new ArrayList<String>()

for (int i = 1; i < 5; i++) {
    sortedList.add(WebUI.getText(findTestObject('Page_Table/cellTable', [('tableName') : 'table2', ('rowIndex') : i, ('columnIndex') : 3])))
}

System.out.println('The sorted list is ' + sortedList)

boolean sorted = Ordering.natural().isOrdered(sortedList)

WebUI.verifyEqual(sorted, true)

