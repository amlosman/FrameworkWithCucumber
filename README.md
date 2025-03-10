# GUI Automation using Cucumber
  GUI tests for a sample web application https://www.globalsqa.com/angularJs-protractor/BankingProject/.
  It uses the following tools and frameworks:
 
### Project Overview
This project is designed to automate the testing of a web application using the following tools and technologies:

#### Cucumber:
For writing feature files and step definitions in a BDD format.

##### Selenium WebDriver:
For browser automation and interacting with web elements.

#### TestNG/JUnit:
For test execution and reporting.

#### Maven:
For dependency management and build automation.
 
 ### Prerequisites
 Before running the project, ensure the following tools and dependencies are installed:

 Maven: Version 3.6.x or higher (if using Maven).

 IDE: IntelliJ IDEA, Eclipse, or any other Java IDE.

Browser: Chrome, Firefox, or any other browser supported by Selenium WebDriver.
 ##### Project Stucture

1. Pages Package : this contains all pages as class
2. Utilities Package: this package contains
    * Helper: 
        * ElementActions: To interact with element
        * ScrollingActions: To scroll in page
        * VerifyAction: To verify actions
        * WebBrowsers: To change selected browser
    
    * Readers : To read files
3. Runner package : To Run features
4. stepDef package: To define steps
5. Hooks: To set before and after configuration
6. Feature package: To add feature files
7. Cucumber.properties: To generate cucumber report 
8. Test Config.properties: To set config
 ##### Project Setup
 1. Clone the Repository
 Clone this repository to your local machine:
 
          git clone https://github.com/amlosman/FrameworkWithCucumber.git
    
 2. Install Dependencies Maven will automatically download the required dependencies. If not, run the following command in the project root directory:
 
          mvn clean install
 #### Running the Tests

 1. Running GUI Tests
 To run the GUI tests, use the following commands:
 
 Run all GUI tests:
 
          mvn test 

Or 

          Run from TestRunner
          
  3. Genetate Report from terminal 
 
          1- Please open the Cucumber report URL from Terminal
  
Example:For cucumber

![image](https://github.com/user-attachments/assets/a052ef86-3aca-413d-867a-32e8357d5935)
![image](https://github.com/user-attachments/assets/bdb0ff70-f7aa-440e-98f7-dd541918452e)


