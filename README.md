This file expalins the Sprints Automation Task.
We used in the task Selenium with Java + TestNG + POM Using Maven for dependency management and allure for reporting 
We add selenuim version, testng version, logs version, allure version and waiting version dependacies in pom.xml file 
These steps to build or setup our frame work :- 

In main folder :-
1- Created the DriverFactory Class to implement the driver setup 
2- Created the Utilities Folder including three classes (Data Utils , Logs Utils and Utility)
In DataUtils class we create two functions that read from (Json file and property file) called (getJsonData , getPropertyValue)
In LogsUtils class we create 6 functions for logs tracing called (trace, debug, info, error, fatal and warning)
In Utility class we create our main classes that we manage our driver actions that dealing with the locators like (clickOnElement, sendData, getText, findWebElement , selectFromDropDown, scrolling, clickEnter and takeScreenShots)
3- Created the resources folder that belongs to the main including two classes (allure.properites , log4j2.properties) that generates our logs data to intilize the logs and the path for the allure data

In out test folder :-
1- Create folder called listners that contain two classes (IInvokedMethodListenerClass and ITestResultListenerClass) listen to our test and return to us the status of the test that passed or failed 
2- Create tests folder to manage our tests 
3- Create resources contains the files that we reading the data from it, we create (environment.properties) that we read the environemnt data from it (searchData and shippingData) that we read our test data from it
4- Create our test_outputs folder in our project that display our results of the tests like (Logs, Screenshots and target)
5- Create our Test Runner folder contains our xml file that we run our test from it 

To generate our report run the command (allure serve test-outputs/target/allure-results) 

The project structure according to the Page object model we create pages for every test 

We create 6 different pages (landing page, product page , review page , search result page , shipping page and thank you page) these pages including the elements locators and our main functions that serve the test
for example click on elemnts, send data for elements or get text of elements and intilize our defualt constructor for evry page that we can move with the driver between pages 

We create a lot of tests that mentioned in the task like (valid search , negative search, adding product to cart and complete a purchase) 
In our tests we inilize the setup function that inilize the driver and reading with files data, our test cases and quit driver function to end our driver session 
