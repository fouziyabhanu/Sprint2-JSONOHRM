Feature: Admin user  functionality

@PositiveTest

Scenario: Admin can search,edit the details
Given Admin is on the User management page
When Admin enters username and clicks on search button
Then User details should be displayed
When Admin clicks on add button
And Enters Employee details and clicks on save button
Then A new user is added
Given Admin is on edit user page
When Admin edits users information and clicks on save button
Then The user details are updated
When Admin selects a user to be deleted
Then The selected user is deleted