# E-Commerce Console Application Documentation

## 1. Introduction

This document provides details about the structure, features, and usage of a Java-based E-Commerce Console Application. 
The app serves both customers and managers, providing several features.

## 2. Project Structure

The project comprises several packages:

### 2.1 HomePages Package

- **CustomerHomePage:** Manages customer interactions, allowing them to browse products, view the cart, checkout, and join the loyalty program.
- **ManagerHomePage:** Provides functionalities for managers, including browsing products, viewing products with discounts, and managing the product inventory.
- **HomePage Interface:** Defines common methods for home pages, such as `homePage()` and `browseProducts()`.

### 2.2 Product Package

- **Product:** Represents a basic product with properties such as ID, name, price, and category.
- **ProductWithDiscount:** Extends the basic Product class to include discount-related functionality.
- **ProductsCategories Package:** Contains classes representing different product categories (e.g., BabyAndKids, Electronics).

### 2.3 Users Package

- **User:** Represents a generic user.
- **Customer and Manager Classes:** Subclasses of User representing customers and managers, respectively.
- **Authentification Classes:** Handle user authentication for customers and managers.

### 2.4 AssociatedComponents Package

- **Inventory:** Manages the product inventory, including adding, updating, and removing products.
- **LoyaltyProgram:** Tracks loyalty points for customers.

### 2.5 Main Class

- **Main:** Serves as the entry point for the application, managing the main execution flow.

## 3. Features and Functionality

### 3.1 Customer Home Page

- **Browse Products:**
  - Comprehensive product search functionality by name or reference.
  - User-friendly interface for searching, filtering, and viewing products.

- **View Cart:**
  - Robust shopping cart management system enabling customers to interactively update their cart by adding, updating quantities, or removing items.

- **Checkout:**
  - Smooth checkout process with options for shipping and payment methods.

- **Order History:**
    - Detailed order history display for secure review and tracking.

- **Loyalty Program:**
    - Incentivizing points system for purchases with conversion feature.

### 3.2 Manager Home Page

- **Browse Products:**
    - Efficient interface for managers to search, filter, and view the product inventory.

- **View Discounts:**
  - Detailed display of products with applied discounts.
  - Allow managers to edit discount rates or remove discounts altogether.

- **View Selling History:**
  - Access to comprehensive selling history for all customer orders.

- **Edit Products:**
  - Provided managers with the capability to edit product details, including price and required stock.
  - Ensured data consistency by updating the product information across the application.

- **Add New Product:**
  - Developed a streamlined process for managers to add new products to the inventory.
  - Implemented category-based product creation to maintain a structured product catalog.

- **Add Discount:**
  - Empowered managers to apply discounts to specific products, promoting sales and marketing strategies.
  - Ensured the accurate application of discounts through the `ProductWithDiscount` class.

### 3.3 Product Management

- **Abstract `Product` Class:**
    - Foundation class for all product types with common attributes.

- **CRUD Operations:**
  - Facilitate Create, Read, Update, and Delete operations for products through the `Inventory` class.
  - Ensured data integrity and consistency across the application.

### 3.4 Shopping Cart

- **Enable Management of Products:**
  - Developed a robust shopping cart system that allows users to interactively manage their selected products.
  - Implemented functionalities for adding, updating quantities, and removing items from the cart.
  - Ensured real-time updates to reflect changes made by customers.

- **Functions Include:**
  - **Adding Items:**
    - Integrated an intuitive process for customers to add products to their cart.
    - Validated product availability to prevent adding out-of-stock items.
    - Displayed clear feedback on successful additions.

  - **Updating Items:**
    - Provided an interactive interface for customers to update quantities of items in their cart.
    - Implemented error handling for cases where the requested quantity exceeds available stock.

  - **Removing Items:**
    - Enabled customers to remove items from their cart with a simple and user-friendly process.
    - Ensured accurate updates to reflect changes in the shopping cart.

### 3.5 Order Processing

- **Develop the Transition from Cart to Order Completion:**
  - Implemented a seamless transition from the shopping cart to order completion.
  - Validated the contents of the cart to ensure all items are available and quantities are within stock limits.
  - Integrated a confirmation step for customers to review their order details before finalizing the purchase.

- **Maintain Records of User Transactions within an `Order` Class:**
    - Stores details of completed transactions.

### 3.6 Inventory Management

- **Automate Inventory Tracking and Updates Post-Purchase:**
  - Integrated inventory management to automatically update product quantities post-purchase.
  - Implemented a secure mechanism to deduct sold items from the available stock.
  - Handled scenarios where items are low or out of stock, placing orders automatically for replenishment.

### 3.7 Dynamic Product Search and Filtering

- **Implement Search Functionality for Product Discovery:**
  - Dynamic search feature allowing users to find products based on product name or reference.

- **Provide Filtering Options to Refine Search Results:**
  - Implemented various filtering options to refine search results based on price range, category.
  - Offered a user-friendly interface for customers to easily navigate and discover products.

### 3.8 Payment Processing

- **Simulate a Basic Payment Transaction System:**
  - Integrated a simulated payment system allowing users to complete transactions.
  - Provided options for payment methods such as credit card or cash on delivery.
  - Ensured the security and integrity of payment information.

### 3.9 Discounts and Promotions

- **Implement Functionality for Discounts and Promotions:**
  - Flexible system for applying discounts and promotions.

### 3.10 Shipping Options

- **Offer Various Shipping Methods:**
  - Implemented a flexible shipping module providing customers with multiple options.
  - Integrated choices for home delivery with associated costs and in-store pickup for added convenience.
  - Ensured a seamless selection process during the checkout phase.

- **Shipping Cost Calculation:**
  - Calculated shipping costs dynamically based on the chosen shipping method and other relevant parameters.
  - Displayed transparent and clear information regarding shipping fees to customers.

## 4. Usage and Execution

1. **Run the Main Class:**
   - Execute the Main class to start the application.

2. **Select Role:**
   - Choose between customer and manager roles.

3. **Login or Register:**
   - Authenticate as an existing user or register as a new one.

4. **Navigate Home Pages:**
   - Explore the features and functionalities available based on the selected role.

5. **Follow On-Screen Instructions:**
   - Respond to prompts and follow on-screen instructions to perform actions.

## 5. Conclusion

The E-Commerce Console Application provides a comprehensive platform with robust features. Users can seamlessly navigate the application, perform essential tasks like product management and order processing, and experience a secure and efficient e-commerce environment.

