Feature: Admin user  functionality

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