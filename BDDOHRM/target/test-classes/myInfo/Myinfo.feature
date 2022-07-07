Feature: My Info functionality
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
