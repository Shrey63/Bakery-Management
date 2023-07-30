# Bakery-Management
This is desktop application based on Java.
	We have implemented an idea of managing a bakery  as whole and soul for the convenience of strict administrator and highly anticipated customer. 

	To serve administrator efficiently we have developed the admin login page which is linked to home page with a button called ‘Admin login’. For resolving security we are verifying Admin name and Password before giving access to Admin Dashboard. If admin fails to login he wouldn’t  be given the control of Dashboard.

	After logging in to the Dashboard the Admin will be able to see the detailed information of the sales such as  product_ID, product_Quantity, etc. which is perfectly synchronized with phpMyAdmin database.

	For convenience of customer we have designed the order form  which  includes customer name, customer phone number and  wish list of the items to purchase.

	The form includes all the sub-categories with major-categories of products sold by bakery which are cake, pastry, decorative, bread, etc.

	While submitting the form the name and phone number of customer is validated and form is submitted only when both are appropriate and there should be at least one item in customer's cart.

	After the form is submitted successfully the confirmation dialog-box appears to confirm the order and respective bill amount is displayed to the customer. Now the customer has two choices either to confirm the order or to cancel it so customer can choose likewise from dialog box.

	After Confirming the order the count down timer of 15 minutes appears with the option of submitting the feedback where customer can give feedback about the service of bakery and also can read the previous feedbacks.

	As the order arrives the timer automatically stops and the good bye screen appears in front of customer.

The database is categorized as follows:
	 First there is main table to store the customer information like customer_id, name and total amount of purchase done by that customer.
	Then, there are  child tables like cake_table, bread_table, ice-cream_table, chocolate_table, etc. to store the data of the respective sales.
