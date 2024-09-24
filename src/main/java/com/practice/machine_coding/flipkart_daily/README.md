Description:
Flipkart wants to build an app to deliver groceries and daily essentials by next morning. Users can
search for items from inventory with some filters and can place an order, only if they have enough
balance in the wallet.
Features:
Inventory management - Create an item having brand, category , price, quantity.
Add / remove items / update quantity for items in customers cart.
Get current users cart info.
Create wallet for a user, with some balance in it, have the capability to add money to it.
Checkout - This places the order directly using the wallet amount.
Bonus:
Search items in inventory via using multiple filters like price, brand, category and can perform
search with multiple filters.
search(brand,price), search(category, price), search(brand,category)...

Things to take care:

1. Do not use any database or NoSQL store, use in-memory data structures for now.
2. Do not create any UI for the application.
3. Write a driver class for demo purposes that executes all the commands in one place in the code
   and includes test cases.
   4 - Put necessary validations/exceptions in place.
5. Please prioritize code compilation, execution, and completion.
6. Code should be modular, with Object-Oriented design. Maintain good separation of concerns.
7. Code should be extensible. It should be easy to add/remove functionality without rewriting the
   entire codebase.
8. Code should handle edge cases properly and fail gracefully.
9. Code should be readable. Follow good coding practices: use intuitive variable names, function
   names, class names, etc. and indent code properly.
10. Concurrent handling is not needed, also not expected to solve using algorithms and can simply go
    for brute force approach.
11. Expected time to solve it is 90 minutes.

This exercise assesses the candidates' ability to design and implement an allocation system,
considering preferences and availability. It aims to test their proficiency in object-oriented
programming.

Test cases: (You need not follow the same method signatures and output)                  1.
Add/Update Item (brand, category, price)

2. Add inventory (category,brand, quantity)
3. Add user (“Name”,”Address”,”Wallet Amount”)
4. Search (“brand”,”category”)  - expected response  <brand, category, price,
   remaining_inventory_count> {Bonus}
5. Add to cart(user, category, brand, quantity) 6. Get cart info(user)
7. Remove from cart
8. Checkout
   Sample input/output

# AddItem(<item_brand>, <item_category>, <item_price>)

AddItem(Amul, Milk, 100)
AddItem(Amul, Curd, 50)
AddItem(Nestle, Milk, 60)
AddItem(Nestle, Curd, 90)

# AddInventory(<item_brand>, <item_category>, <units>)

AddInventory(Amul, Milk, 10)
AddInventory(Nestle, Milk, 15)
AddInventory(Nestle, Curd, 10)
AddInventory(Amul, Milk, 10)
AddInventory(Amul, Curd, 5)

# Final View Inventory :

Amul - > Milk -> 20
Amul -> Curd -> 5
Nestle -> Milk -> 15
Nestle -> Curd -> 10

#AddUser(<Name>,<Address>,<Wallet Amount>)
AddUser(Jhonny, ”Flipkart Bellandur, Bangalore 560068”, 600)
AddUser(Naruto, ”BTM Layout, Bengaluru, 560042”, 500)
AddUser(Goku, ”Vijay Nagar, Indore, MP”, 3000)

# AddToCart(<User_Name>, <item_category>, <item_brand>, <units>)

AddToCart(Jhonny, Milk, Nestle, 5)
UpdateInventory(Nestle, Milk, 5)
AddToCart(Goku, Milk, Nestle, 10)

# GetCart(<User_Name>)

GetCart(Goku)
Nestle -> Milk - > 10 → Total Price 50  
GetCart(Jhonny)
Nestle -> Milk -> 5 -> Total Price : 25 GetCart(Naruto)
Empty Cart

# expected response  <brand, category, price, remaining_inventory_count>

SearchItems([Nestle])
Nestle -> Curd-> 90 -> 10
SearchItems([Nestle, Amul], [Curd])
Amul -> Curd -> 50 -> 5
Nestle -> Curd -> 90 -> 10
SearchItems([Nestle], [Curd, Milk, Paneer]) Nestle -> Curd -> 90 -> 10
Nestle -> Milk -> 60 -> 0

# Checkout(<Name>)

Checkout(Goku)
-> Successful checkout , new wallet amount: 2950
Checkout(Jhonny)
-> Successful checkout , new wallet amount: 575
Checkout(Naruto)
-> No order to checkout
Note: in case the wallet amount is less than cart total amount, checkout fails
