Feature: Page Management
  Scenario Outline: Scenario: Check items summary
    Given that I am on the main page of the store and have picked the item <XPath>
    When I am in the item's page I select its color <Color>, size <Size> and a quantity equal to <Quantity>
    Then the selected color <Color>, the size <Size> and quantity <Quantity> have to correspond the shown values in the summary
    Examples:
      | XPath                                                   | Color | Size | Quantity |
      |"//*[@id=\"homefeatured\"]/li[1]/div/div[1]/div/a[1]/img"| "one" | "M"  | 2        |
      |"//*[@id=\"homefeatured\"]/li[2]/div/div[1]/div/a[1]/img"| "one" | "M"  | 4        |