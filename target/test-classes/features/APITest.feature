Feature: To perform all the CRUD operations

  Scenario: To Perform the GET Operation on Employee DB
    Given The base URI is "http://localhost:4444/medicare/json/data/all/products"
    When I perform the Get Operation
    Then Response code should be 200 and product names are matching in UI
