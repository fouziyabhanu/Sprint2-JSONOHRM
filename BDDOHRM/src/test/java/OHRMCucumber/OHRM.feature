Feature: OHRM end-end functionality

Scenario: Login
Given User is on login page
When User enters valid username and valid password
|Admin|admin123|
Then User should logs in successfully

Scenario: Admin can search,edit the details
Given Admin is on the User management page
When Admin enters username and clicks on search button
Then Admin clicks on reset button
When User clicks on add button
And Enters Employee details
Then Clicks on save button
Given Admin is on edit user page
When Admin edits users information
Then User clicks on save button
When Admin selects a user to be deleted
Then Clicks on delete button

Scenario: Admin can add,edit and delete the job
Given Admin is on job page
When Admin is on job title page
Then User is able to add the job title
And User should able to delete the job
Then User is able to edit the job details

Scenario: Admin can add image,add attachment
Given Admin is on personal details page
When Admin clicks on edit button
And Edit user details
Then Clicks on save button
Given Admin is on custom feild
When Admin clicks on edit
And Choose blood groop, vaccination details
Then Admin clicks on save button
When Admin select file
Then clicks on delete button

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