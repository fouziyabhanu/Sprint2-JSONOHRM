Feature: End-to-end functionality
Given I have the base URL

Scenario: Getting a resource
When I request for a resource
Then I get the resource

Scenario: Fetch list of resources
When I request for a list of resources
Then I get list of resources

Scenario Outline: Creating a resource
When I add a new resource with "<id>","<userId>","<title>" and "<body>"
Then The reource is added
Examples:
|id|userId|title|body|
|101|101|Wings of fire|Autography of APJ Abdul Kalam covering his early life and his work in Indian space research and missle programs|
|102|102|Believe in Yourself|A self-help book about self-esteem and confidence|
|103|103|A Girl with no dreams|A story about Dreams,Hope and Death.|

Scenario: Updating a resource
When I update a resource
|103|123|A Girl with no dreams|A story about Dreams,Hope and Death.|
Then the resource is added


Scenario: Patching a resource
When I update a resource partially

Then The resource details get updated


Scenario: Deleting a resource
When I delete a resource
Then The resource gets deleted

Scenario: Filtering a resource
When I want to fetch particular userId resource
Then I get that userId resources