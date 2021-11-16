@selenium_grid
Feature: verify_application_title
  @grid_chrome
  Scenario: verify_title_on_chrome
    Given user is on the application_login page with chrome
    Then verify the title includes Resortsline

#  CHROME NODE REGISTER:
#  java -Dwebdriver.chrome.driver="/Users/techproed/Documents/selenium libraries/drivers/chromedriver" -jar selenium-server-standalone-3.141.59.jar -role node -hub http://192.168.0.14:4444/grid/register -port 4445
#
#  CHANGE 3 DATA:
#  chrome        -> gecko
#  chromedriver  -> geckodriver
#  4445          -> 4446
#
  #  FIREFOX NODE REGISTER
#  java -Dwebdriver.gecko.driver="/Users/techproed/Documents/selenium libraries/drivers/geckodriver" -jar selenium-server-standalone-3.141.59.jar -role node -hub http://192.168.0.14:4444/grid/register -port 4446
  @grid_firefox
  Scenario: verify_title_on_firefox
    Given user is on the application_login page with firefox
    Then verify the title includes Resortsline

#    NOTES:
#  1. Register HUB
#  -Change Directory and RUn code: java -jar selenium-server-standalone-3.141.59.jar -role hub

#  2. Register node for chrome:
#  -Change Directory and run code:
#  java -Dwebdriver.chrome.driver="/Users/techproed/Documents/selenium libraries/drivers/chromedriver" -jar selenium-server-standalone-3.141.59.jar -role node -hub http://192.168.0.14:4444/grid/register -port 4445

#  3. Register node for firefox:
#  -Change Directory and run code:
#  java -Dwebdriver.gecko.driver="/Users/techproed/Documents/selenium libraries/drivers/geckodriver" -jar selenium-server-standalone-3.141.59.jar -role node -hub http://192.168.0.14:4444/grid/register -port 4446

#  4. Write your feature file and step defs
#    @grid_firefox
#  Scenario: verify_title_on_firefox
#    Given user is on the application_login page with firefox
#    Then verify the title includes Resortsline
#     @Given("user is on the application_login page with firefox")
#    public void user_is_on_the_application_login_page_with_firefox() {
#    }

#  5. Run tests to see if your test run on chrome and firefox.Feature:

#######  CROSS BROWSER TEST (MULTI BROWSER TEST)   #######
#  WHAT ? : Test execution in DIFFERENT BROWSER is called "CROSS BROWSER TESTING"
#  WHY ?  : To make sure the application(functionalities) works as expected across the browsers


#  INTERVIEW QUESTIONS?
#  What is Selenium Grid?
#  Selenium grid is used for remote test execution. We can also do parallel testing with grid.
#  What is Desired Capabilities?
#  DesiredCapabilities is used for adding different properties for browsers such as name, version, etc.
#  What is Remote Driver? Why Do you use it?
#  Remote driver is used to connect a remote platform. I used Remote Driver to connect the nodes when I use Selenium grid
#  driver= new RemoteWebDriver(new URL(hubURL),options);
#  What is the benefit of Selenium Grid?
#  We can use selenium grid with parallel testing. Then it saves time. We can use grid with cucumber or testng framework.
#  What is Hub?
#  Hub is a server that drives the parallel test execution on different machines
#  What is Node?
#  Node is a virtual machine that is registered to a hub. There can be multiple nodes that can work with selenium grid
#  How do you run tests on Selenium Grid?
#  We register Hub and use it as a server. Then I register nodes to the Hub. Then I create my test cases. And then run the test.
#  How do you configure test cases on selenium grid?
#  I use Desired capabilities for set up
#  I add browser type and platforms then create my remote driver for execution
#  What are the challenges in multi browser testing ?
#  Set up. We need to create different drivers for each browser for cross browser testing.
#  The maintenance. We need to keep our drivers and browsers up to date. Our drivers and browser also should be compatable. Otherwise we might get exception.
#  Test execution time might be more because we need to test on multiple browser. It will take more time to compatible.
#  How do you keep your driver up to date?
#  The best code is WORKING code. So if the driver work then keep using it. If there is some exception related to driver, then update it from the company repository.
#  ####################### ################### #################


  @grid_firefox
  Scenario: verify_title_on_firefox
    Given user is on the application_login page with firefox
    Then verify the title includes Resortsline
