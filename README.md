**Vehicle Search Automation** 

This project uses Selenium to search vehicle based on the csv/excel file

**Import project in IntelliJ/Eclipse**

Check out the project using clone or download the Zip. 
In your IDE import project as Existing project maven.


**Technology Stack /Frameworks**

Java 8  ,
Selenium ,
Cucumber ,
Apache Commons ,
Apache IO 

**Logging**

Logback is implemented.

**Services**

AutomationServiceImpl is the main service which has two method. One is to display information about the file.

retrieveFiles method to get the files based on the File Mime Types. Currenty CSV and Excel are supported.

**Selenium**

Firefox and Chrome browsers are supported. Others can be plugged-in as its dynamic pattern.

**VehicleInformationFetcherTest** 
this test will load the files CSV and excel. Read the vehicle data and go to DVLA website and get data from there and match 

All other JUnit tests are added for regression tests.

