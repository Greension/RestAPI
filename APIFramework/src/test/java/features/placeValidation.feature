   Feature: Validating Place API's
   
   Scenario: Verify if place is being Successfully adding using AddplaceAPI
   Given Add Place Payload
   When user calls "AddPlaceAPI" with Post http request
   Then The API call got Success with status code 200
   