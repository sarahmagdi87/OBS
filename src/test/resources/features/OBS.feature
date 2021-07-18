Feature: OBS Task

Scenario: OBS Task
Given navigate to google
And search for "Orange Business services"
When open "Orange Business Services: Your partner for digital ..." that has the URL https://www.orange-business.com/en
And click on "Solutions" -> "All products" 
Then validate the options "Business innovation-Cloud-Collaborative workspace-Customer experience-Cyberdefense-Data intelligence-Internet of Things-Mobile connectivity-Network transformation-Services" 
And select Cloud 
And click apply 
And choose the item with title "Managed Applications: improve operational capability in the cloud"
And validate that the system opens the right article with title "Managed Applications: improve operational capability in the cloud"
And close the browser
