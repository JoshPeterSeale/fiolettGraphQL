# Feature-03 work

In this feature will begin to introduce orders
This will require graphql schema updates to our menu to include prices
The price will be a function of the cost e.g. price = cost * 3 (rounded)
The cost will be a function of the cost of each ingredient- total cost is the sum of all costs per ingredient
An ingredient object will be modified to include a cost per serving

A mutation will be created to add the order to the database

## Future work this will enable:
Email service that sends receipt after order (blocked by account login)
Kitchen POS: a prompt for the Head Chef that details the progress of the order. Accessible to the user too? (Like the dominoes robot)



