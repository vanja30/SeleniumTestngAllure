# SeleniumTestngAllure
Template proj for selenium 
This is template project with Selenium, Test Ng , Maven and Allure.

We can run test loccaly with "TestNG runner", also we can right click on any
Test file and create testng xml, whic can be edited later. For this we need
extension in IntelliJ.

For allure run "mvn serve" command

- Project shoud be improved in several different areas:
1. There is no git ignore file
2. There are no standard Assertion or soft Assertion classes
3. Think about Wrapping "WebElement" class so we have (Buttons, Checkbox, Links, DropDowns,...)
4. Think about better capabilities since there are no cookis handle, only two browsers
5. Add Selenium grid, and try maybe to connect it on free trail with browser Stack, Souce Lab
 or something else
 6. Build CI/CD on Jenkins (scheduled) only work days. Try maybe to build pip line on your own and
 connect Allure history
 7. Play with maven profiles
 ....
