Feature: PIM functionality

Scenario: Admin can search,add,delete employee
Given Admin is on Employee List page
When Admin enters the employee name and employee ID,Supervisor Name
Then Clicks on search
And User details displayed
When User click on add
Then Enters firstname and lastname
And Clicks on save button
Then Select user to delete
And Delete the user