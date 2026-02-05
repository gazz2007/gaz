package menu;


import Model.*;
import database.ProductDAO;

import java.util.List;
import java.util.Scanner;
public class ShopMenu implements Menu {
    private static Scanner scanner;
    private static ProductDAO productDAO = new  ProductDAO();

    public ShopMenu() {
        this.scanner = new Scanner(System.in);
        this.productDAO = new ProductDAO();

        System.out.println("\n╔════════════════════════════════════════╗");
        System.out.println("║  RESTAURANT MANAGEMENT SYSTEM v2.0    ║");
        System.out.println("║  Week 8: Fully Database-Driven 🗄️     ║");
        System.out.println("╚════════════════════════════════════════╝");
        System.out.println("✅ All data is stored in PostgreSQL");
        System.out.println("✅ No in-memory ArrayLists");
        System.out.println("✅ Complete CRUD operations");
    }
    @Override
    public void displayMenu() {
        System.out.println("\n========================================");
        System.out.println(" GROCERY MANAGEMENT SYSTEM");
        System.out.println("========================================");
        System.out.println("1. Add FrozenProducts");
        System.out.println("2. View FrozenProducts");
        System.out.println("3. Add FreshProducts");
        System.out.println("4. View FreshProducts");
        System.out.println("5. View All Products (Polymorphic)");
        System.out.println("6. View All Products Status ");
        System.out.println("7. Update Product");
        System.out.println("8. Delete Product");
        System.out.println("9. Search Product");
        System.out.println("10.Search by Price");
        System.out.println("11.Search by Min Price");
        System.out.println("0. Exit");
        System.out.println("========================================");
        System.out.print("Enter your choice: ");
    }
    @Override
    public void run() {
        boolean running = true;
        while (running) {
            displayMenu();
            try {
                int choice = scanner.nextInt();
                scanner.nextLine();

                switch (choice) {
                    case 1:
                        addFrozenProduct();
                        break;
                    case 2:
                        viewFrozenProducts();
                        break;
                    case 3:
                        addFreshProduct();
                        break;
                    case 4:
                        viewFreshProducts();
                        break;
                    case 5:
                        viewAllProducts();
                        break;
                    case 6:
                        viewProductStatus();
                        break;
                    case 7:
                        updateProduct();
                        break;
                    case 8:
                        deleteProduct();
                        break;
                    case 9:
                        searchByName();
                        break;
                    case 10:
                        searchByPriceRange();
                        break;
                    case 11:
                        searchByMinPrice();
                        break;
                    case 0:
                        System.out.println("\nGoodbye");
                        running = false;
                        break;
                    default:
                        System.out.println("\n Invalid choice");
                }
            }catch(java.util.InputMismatchException e){
                System.out.println("Please enter a valid number");
                scanner.nextLine();
            }catch(Exception e){
                System.out.println("Error: " + e.getMessage());
                scanner.nextLine();
            }
            if (running) {
                System.out.println("Press any key to continue");
                scanner.nextLine();
            }
        }
        scanner.close();
    }

    private void viewAllProducts() {
        productDAO.displayAllProduct();
    }
    private static void addFrozenProduct(){
        try{
            System.out.println("enter the name of the product: ");
            String name = scanner.nextLine();
            System.out.println("enter the price of the product: ");
            int price = scanner.nextInt();
            scanner.nextLine();
            System.out.println("enter the quantity of the product: ");
            int quantity = scanner.nextInt();
            scanner.nextLine();
            System.out.println("enter the barcode of the product: ");
            int barcode = scanner.nextInt();
            scanner.nextLine();
            System.out.println("enter the brand of the product: ");
            String brand = scanner.nextLine();
            System.out.println("enter the daysLeft of the product: ");
            int daysLeft = scanner.nextInt();
            scanner.nextLine();
            System.out.println("enter the temperature of the product: ");
            int temperature = scanner.nextInt();
            scanner.nextLine();
            System.out.println("enter the Validation of the product: ");
            boolean isFrozen = scanner.nextBoolean();
            scanner.nextLine();
            System.out.println("enter the id of  the Frozen product: ");
            int product_id = scanner.nextInt();
            scanner.nextLine();
            FrozenProduct frozenproduct=new FrozenProduct(name,price,quantity,barcode, brand, daysLeft, temperature, isFrozen,product_id);
            ProductDAO dao = new ProductDAO();
            dao.insertFrozenProduct(frozenproduct);
        }
        catch(java.util.InputMismatchException e){
            System.out.println("Please enter the name of the product: ");
            scanner.nextLine();
        }
        catch(IllegalArgumentException e){
            System.out.println("Error: " + e.getMessage());
        }
    }
    private static void viewFrozenProducts() {
        System.out.println("\n========================================");
        System.out.println(" FROZEN PRODUCTS ONLY");
        System.out.println("========================================");
        //ProductDAO dao = new ProductDAO();
        List<FrozenProduct> frozenProducts = productDAO.getAllFrozenProducts();
        int FRPcount = 0;
        for (Product s : frozenProducts) {
            if (s instanceof FrozenProduct) {
                FrozenProduct item = (FrozenProduct) s;
                FRPcount++;
                System.out.println(FRPcount + ". " + item.getName());
                System.out.println(" Price: " + item.getPrice()+"\uD83D\uDCB8");
                System.out.println(" Brand: " + item.getBrand()+"\uD83D\uDDF2");
                System.out.println(" Temperature: " + item.getTemperature()+"\uD83C\uDF21\uFE0F");
                System.out.println(" Frozen product: " + item.isFrozen()+"❄\uFE0F");
                if (item.getDaysLeft()>10) {
                    System.out.println(" Eatable product ✅");
                }
                else{
                    System.out.println("Garbage\uD83E\uDD22");
                }
                System.out.println();
            }
        }
        if (FRPcount == 0) {
            System.out.println("No Fresh products found.❌");
        }
    }
    private static void addFreshProduct() {
        try {
            System.out.println("ADD PRODUCT");
            System.out.println("name of the product: ");
            String name = scanner.nextLine();
            System.out.println("price of the product: ");
            int price = scanner.nextInt();
            scanner.nextLine();
            System.out.println("quantity of the product: ");
            int quantity = scanner.nextInt();
            scanner.nextLine();
            System.out.println("barcode of the product: ");
            int barcode = scanner.nextInt();
            scanner.nextLine();
            System.out.println("Brand of the product: ");
            String brand = scanner.nextLine();
            System.out.println("How much days left: ");
            int daysLeft = scanner.nextInt();
            scanner.nextLine();
            System.out.println("Ripeness of the product: ");
            boolean isRipe = scanner.nextBoolean();
            scanner.nextLine();
            System.out.println("Organicness of the product: ");
            boolean isOrganicProduct = scanner.nextBoolean();
            System.out.println("enter the id of the Fresh product: ");
            int product_id = scanner.nextInt();
            FreshProduct freshProduct = new FreshProduct(name, price, quantity, barcode, brand, daysLeft, isRipe, isOrganicProduct,product_id);
            ProductDAO dao = new ProductDAO();
            dao.insertFreshProduct(freshProduct);
            System.out.println("Fresh Model.Product added successfully✅");
        }
        catch(java.util.InputMismatchException e){
            System.out.println("Please enter a valid number");
            scanner.nextLine();
        }catch(IllegalArgumentException e){
            System.out.println("Validation Error"+e.getMessage());
        }
    }
    private static void viewFreshProducts() {
        System.out.println("\n========================================");
        System.out.println(" FRESH PRODUCTS ONLY");
        System.out.println("========================================");
        ProductDAO dao = new ProductDAO();
        List<FreshProduct> freshProducts = dao.getAllFreshProducts();
        int FRPcount = 0;
        for (Product s : freshProducts) {
            if (s instanceof FreshProduct) {
                FreshProduct item = (FreshProduct) s;
                FRPcount++;
                System.out.println(FRPcount + ". " + item.getName());
                System.out.println(" Price: " + item.getPrice()+"\uD83D\uDCB8");
                System.out.println(" Brand: " + item.getBrand()+"\uD83D\uDDF2");
                System.out.println(" Days left: " + item.getDaysLeft()+"⏳");
                if (item.isRipe()) {
                    System.out.println(" Eatable product ✅");
                }
                System.out.println();
            }
        }
        if (FRPcount == 0) {
            System.out.println("No Fresh products found.❌");
        }

    }
    private static void viewProductStatus(){
        ProductDAO dao = new ProductDAO();
        dao.ProductStatus();
    }

    private void updateProduct() {
        System.out.println("\n┌─ UPDATE Product ─────────────────────────┐");
        System.out.print("│ Enter Product product id to update: ");

        try {
            int product_id = scanner.nextInt();
            scanner.nextLine();

            // First, get existing Product from database
            ProductDAO dao = new ProductDAO();
            Product existingProduct=dao.getProductById(product_id);

            if (existingProduct == null) {
                System.out.println("❌ No Product found with ID: " + product_id);
                return;
            }

            // Display current info
            System.out.println("│ Current Info:");
            System.out.println("│ " + existingProduct.toString());
            System.out.println("└────────────────────────────────────────┘");

            // Get new values
            System.out.println("\n┌─ ENTER NEW VALUES ─────────────────────┐");
            System.out.println("│ (Press Enter to keep current value)   │");

            System.out.print("│ New Name [" + existingProduct.getName() + "]: ");
            String newName = scanner.nextLine();
            if (newName.trim().isEmpty()) {
                newName = existingProduct.getName();
            }

            System.out.print("│ New Price [" + existingProduct.getPrice() + "]: ");
            String priceInput = scanner.nextLine();
            int newPrice = priceInput.trim().isEmpty() ?
                    existingProduct.getPrice() : Integer.parseInt(priceInput);

            System.out.print("│ New Quantity [" + existingProduct.getQuantity() + "]: ");
            String quantityInput = scanner.nextLine();
            int newQuantity = quantityInput.trim().isEmpty() ?
                    existingProduct.getQuantity() : Integer.parseInt(quantityInput);

            System.out.println("│ New barcode ["+existingProduct.getBarcode()+"]");
            String  barcodeInput = scanner.nextLine();
            int newBarcode = barcodeInput.trim().isEmpty() ?
                    existingProduct.getBarcode() : Integer.parseInt(barcodeInput);


            System.out.print("│ New Brand [" + existingProduct.getBrand() + "]: ");
            String newBrand = scanner.nextLine();
            if (newBrand.trim().isEmpty()) {
                newBrand = existingProduct.getBrand();
            }

            System.out.print("│ New daysLeft [" + existingProduct.getDaysLeft() + "]: ");
            String DaysLeftInput = scanner.nextLine();
            int newDaysLeft = DaysLeftInput.trim().isEmpty() ?
                    existingProduct.getDaysLeft() : Integer.parseInt(DaysLeftInput);


            // Update based on type
            if (existingProduct instanceof FrozenProduct) {
                FrozenProduct frozenProduct = (FrozenProduct) existingProduct;

                System.out.print("│ New temperature [" + frozenProduct.getTemperature() + "]: ");
                String TempInput = scanner.nextLine();
                int newTemp = TempInput.trim().isEmpty() ?
                        frozenProduct.getTemperature() : Integer.parseInt(TempInput);

                System.out.println("│ New isFrozen state [" + frozenProduct.isFrozen() + "]");
                String IsFrozenInput = scanner.nextLine();
                Boolean newIsFrozen = IsFrozenInput.trim().isEmpty() ?
                        frozenProduct.isFrozen() : Boolean.parseBoolean(IsFrozenInput);
                System.out.println("│ New  ID ["+ frozenProduct.getProduct_id());
                String  IDInput = scanner.nextLine();
                int newIdInput = IDInput.trim().isEmpty() ?
                        frozenProduct.getProduct_id() : Integer.parseInt(IDInput);
                FrozenProduct updatedFrozenProduct = new FrozenProduct(newName, newPrice, newQuantity, newBarcode,newBrand,newDaysLeft,newTemp,newIsFrozen,newIdInput);
                dao.updateFrozenProduct(updatedFrozenProduct);
            }else if (existingProduct instanceof FreshProduct) {
                FreshProduct freshProduct = (FreshProduct) existingProduct;
                System.out.print("│ New IsRipe state [" + freshProduct.isRipe() + "]: ");
                String isRipeInput = scanner.nextLine();
                boolean newIsRipe = isRipeInput.trim().isEmpty()
                        ? freshProduct.isRipe()
                        : Boolean.parseBoolean(isRipeInput);

                System.out.println("│ New isOrganicProduct state [" +  freshProduct.isOrganicProduct() + "]");
                String isOrganicProductInput = scanner.nextLine();
                boolean newIsOrganicProduct = isRipeInput.trim().isEmpty()
                        ? freshProduct.isOrganicProduct()
                        : Boolean.parseBoolean(isOrganicProductInput);
                System.out.println("│ New  ID ["+ freshProduct.getProduct_id());
                String  IDInput = scanner.nextLine();
                int newIdInput = IDInput.trim().isEmpty() ?
                        freshProduct.getProduct_id() : Integer.parseInt(IDInput);


                FreshProduct updatedFreshProduct = new FreshProduct(newName, newPrice, newQuantity, newBarcode,newBrand,newDaysLeft,newIsRipe,newIsOrganicProduct,newIdInput);
                dao.updateFreshProduct(updatedFreshProduct);
            }

            System.out.println("└────────────────────────────────────────┘");

        } catch (NumberFormatException e) {
            System.out.println("❌ Error: Invalid number format!");
        } catch (IllegalArgumentException e) {
            System.out.println("❌ Validation Error: " + e.getMessage());
        }
    }
    private void deleteProduct() {
        System.out.print("Enter Product ID to delete: ");
        int product_id = scanner.nextInt();
        scanner.nextLine();
        // 1. First, load and show who will be deleted
        ProductDAO dao = new ProductDAO();
        Product product = dao.getProductById(product_id);
        if (product == null) {
            System.out.println(" ❌No product found with ID: " + product_id);
            return;
        }
        // 2. Display staff details
        System.out.println("Product to delete:");
        System.out.println(product.toString());
        // 3. Ask for confirmation
        System.out.print("⚠\uFE0FAre you sure? (yes/no): ");
        String confirmation = scanner.nextLine();
        // 4. Delete only if confirmed
        if (confirmation.equalsIgnoreCase("yes")) {
            dao.deleteProduct(product_id);
        } else {
            System.out.println(" ❌Deletion cancelled.");
        }
    }
    private void searchByName() {
        System.out.println("\n┌─ SEARCH BY NAME ───────────────────────┐");
        System.out.print("│ Enter name to search: ");
        String name = scanner.nextLine();
        System.out.println("└────────────────────────────────────────┘");
        ProductDAO dao = new ProductDAO();
        List<Product> results = dao.searchByName(name);

        displaySearchResults(results, "Search: '" + name + "'");
    }
    private void displaySearchResults(List<Product> results, String criteria) {
        System.out.println("\n╔════════════════════════════════════════╗");
        System.out.println("║         SEARCH RESULTS                ║");
        System.out.println("╚════════════════════════════════════════╝");
        System.out.println("Criteria: " + criteria);
        System.out.println("─────────────────────────────────────────");

        if (results.isEmpty()) {
            System.out.println("📭 No product found matching criteria.");
        } else {
            for (int i = 0; i < results.size(); i++) {
                Product s = results.get(i);
                System.out.print((i + 1) + ". ");
                System.out.print("[" + s.getProductType() + "] ");
                System.out.println(s.toString());
            }
            System.out.println("─────────────────────────────────────────");
            System.out.println("Total Results: " + results.size());
        }
    }
    private void searchByPriceRange() {
        try {
            System.out.println("\n┌─ SEARCH BY Price RANGE ───────────────┐");
            System.out.print("│ Enter minimum price: ");
            double minSalary = scanner.nextDouble();

            System.out.print("│ Enter maximum price: ");
            double maxSalary = scanner.nextDouble();
            scanner.nextLine();
            System.out.println("└────────────────────────────────────────┘");
            ProductDAO dao = new ProductDAO();

            List<Product> results = dao.searchByPriceRange(minSalary, maxSalary);

            displaySearchResults(results, "Price: " + minSalary + " - " + maxSalary + " KZT");

        } catch (java.util.InputMismatchException e) {
            System.out.println("❌ Error: Invalid number!");
            scanner.nextLine();
        }
    }
    private void searchByMinPrice() {
        try {
            System.out.println("\n┌─ HIGH-PRICE ──────────────────────┐");
            System.out.print("│ Enter minimum price: ");
            double minPrice = scanner.nextDouble();
            scanner.nextLine();
            System.out.println("└────────────────────────────────────────┘");
            ProductDAO dao = new ProductDAO();

            List<Product> results = dao.searchByMinPrice(minPrice);

            displaySearchResults(results, "PRICE >= " + minPrice + " KZT");

        } catch (java.util.InputMismatchException e) {
            System.out.println("❌ Error: Invalid number!");
            scanner.nextLine();
        }
    }




}
