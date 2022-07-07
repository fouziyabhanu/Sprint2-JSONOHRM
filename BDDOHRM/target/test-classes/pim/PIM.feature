Feature: PIM functionality

@PositiveTest

Scenario: Admin can search,add,delete employee
Given Admin is on Employee List page
When Admin enters employee ID and employee name
Then Admin gets the searched employee id
When Admin clicks on add button and enters the name and edit details
Then Added the employee successfully
When Admin selects the employee to be deleted
Then Employee deletes successfully
