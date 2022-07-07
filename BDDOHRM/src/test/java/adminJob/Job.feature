Feature: Admin-job functionality

@PositiveTest

Scenario: Admin can add,edit and delete the job
Given Admin is on job page
When Admin clicks on add button and enter the job to be added
Then Admin is added the job successfully
When Admin selects the job to be deleted and clicks on delete button
Then The selected job is deleted 
When Admin edits the job details
Then Admin updates the job details