Feature: Validate eBay

 Scenario: Navigate to eBayHome
Given user is on eBayHome Page
When he searches for "dress"
And choose to buy the first item
And moves to checkout from mini cart
And enter personal details on checkout page
And select same delivery address
And select payment method as "check" payment
And place the order