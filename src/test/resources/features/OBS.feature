Feature: OBS Task

Scenario Outline: OBS Task
Given navigate to google
And search for "Orange Business services"
When open "Orange Business Services: Your partner for digital ..." that has the URL "https://www.orange-business.com/en"
And click on "solution" -> "all products" 
Then validate the options (Business innovation - cloud - collaborative workspace - Customer Exp – cyber defense - Data Intelligence - IOT - Mobile connectivity - Network transformation - all services) 
And choose "Cloud" 
And click apply 
And choose the item with title "Managed Applications: Improve operational capability in the cloud"
And validate that the system opens the right article
And close the browser
