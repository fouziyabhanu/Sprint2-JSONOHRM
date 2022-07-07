Feature: Creating Resource functionality

Scenario Outline: Creating a resource
When I add a new resource with "<id>","<userId>","<title>" and "<body>"
Then The reource is added
Examples:
|id|userId|title|body|
|101|101|Wings of fire|Autography of APJ Abdul Kalam covering his early life and his work in Indian space research and missle programs|
|102|102|Believe in Yourself|A self-help book about self-esteem and confidence|
|103|103|A Girl with no dreams|A story about Dreams,Hope and Death.|
