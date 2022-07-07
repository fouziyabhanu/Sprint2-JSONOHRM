Feature: OHRM end-end functionality

@PositiveTest, @ParameterizedTest 
Scenario: Login
Given User is on login page
When User enters valid username and valid password
|Admin|admin123|
Then User should logs in successfully

@PositiveTest
Scenario: Admin can search,edit the details
Given Admin is on the User management page
When Admin enters username and clicks on search button
Then User details should be displayed
When Admin clicks on add button
And Enters Employee details and clicks on save button
Then A new user is added
Given Admin is on edit user page
When Admin edits users information
Then The user details are updated
When Admin selects a user to be deleted
Then The selected user is deleted


@PositiveTest
Scenario: Admin can add,edit and delete the job
Given Admin is on job page
When Admin clicks on add button and enter the job to be added
Then Admin is added the job successfully
When Admin selects the job to be deleted and clicks on delete button
Then The selected job is deleted 
When Admin edits the job details
Then Admin updates the job details


@PositiveTest
Scenario: Admin can all personal details,add attachment
Given Admin is on MyInfo  page
When Admin clicks on edit button and edit user details
Then Admin updated the details
Given Admin is on custom feild
When Admin clicks on edit button
And Choose blood group,vaccination details 
Then Admin updated the blood group and vaccination details
When Admin selects the file to be deleted
Then The selected file deleted successfully

@PositiveTest
Scenario: Admin can search,add,delete employee
Given Admin is on Employee List page
When Admin enters employee ID and employee name
Then Admin gets the searched employee id
When Admin clicks on add button and enters the name and edit details
Then Added the employee successfully
When Admin selects the employee to be deleted
Then Employee deletes successfully

@PositiveTest
Scenario: Admin can logout
Given Admin is on home page
When Admin clicks on welcome link
Then Admin should logs out successfully
