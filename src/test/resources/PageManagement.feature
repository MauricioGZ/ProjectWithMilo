Feature: Page Management
  Scenario Outline: Scenario: Check items summary
    Given that I am on the main page of the store and have picked the item <Item>
    When I am in the item's page I select its size <Size> and a quantity equal to <Quantity>
    Then the selected size <Size> and quantity <Quantity> have to correspond the shown values in the summary
    Examples:
      | Item      | Size | Quantity |
      #| "Shirt"   | "M"  | 2        |
      | "Blouse"  | "L"  | 4        |