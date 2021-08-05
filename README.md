# supermarket


### Assumptions: 
* Not going to use currency e.g. GBP. This would be tiny type with currency built in.

* Will be using BigDecimal over double.  

* Componentise the code base where possible  

* Multi-priced promotion was not listed as "This week's special price". Not sure to implement the promotion

* Basket use case was not mentioned in the task description. So went with checkout and scanning items. You could replace 
  the checkout class with basket, and the only difference would be method name change from scan to add.


### Further improvements if time allowed:
* In theory we could create a simpler promotion like BuyNForFixedPrice. Which  would cover "Buy 3, get one free", 
  "Meal deal" and "Multi-priced". We would use existing MealDeal logic and make it more flexiable.

* Add Fixtures and helper functions to reduce the duplicate creation of items and discount that are common between test classes

* Covert some class test to parameterized test like CheckoutTest.

* Add klint and detekt tool for static code analysis. Improving Kotlin code base.
  https://github.com/detekt/detekt