Framework is consist of the following :
1- src/main/java folder
  - base package contains the BaseMethods class: include common variables & methods to open browser, navigate to page, load property file, close browser, waits, screenshot capture
  - Pages package contains classes represent pages; each class includes OR initiation and method used at those pages and inherit from BaseMethods class
3- src/test/java
-	StepDefiniations package contains OBSSteps class for the feature file
-	TestRunner package contains TestRunner class to configure cucumber options (report , glue)
4- src/test/resource
-	Contains -> Feature File (cucumber scenarios) , Properties File(Browser and URL values) 
6- Reports -> Includes Extended report and screenshots for the execution
7- target -> Include cucumber report
8- pom.xml -> includes properties, dependency , plugins , tested to be run through maven CLI
