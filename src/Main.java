import java.util.ArrayList;
import java.util.Scanner;
public class Main {
    private static ArrayList<Product> products = new ArrayList<>();
    private static ArrayList<Employee> employees = new ArrayList<>();
    private static ArrayList<Customer> customers = new ArrayList<>();
    private static ArrayList<Product> Allproducts = new ArrayList<>();

    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        Allproducts.add(new Product("Apple", 300, 8, 242424, "Astroworld", 18));
        Allproducts.add(new FrozenProduct("Pineapple",150,12,24242442,"astrothunder",12,-12,true));
        Allproducts.add(new FreshProduct("Cow meat",30000,5,2464646,"AqtobeMalBazary",45,true,true));
        products.add(new Product("Apple", 300, 8, 242424, "Astroworld", 18));
        employees.add(new Employee("Gaziz", 2424, 18, 1000, "gazomazo@gmail.com", 3));
        customers.add(new Customer(12313, "Akzhan", "8700021", 32));
        boolean running = true;
        while (running) {
            displayMenu();
            int choice = scanner.nextInt();
            scanner.nextLine();
            switch (choice) {
                case 1:
                    addProduct();
                    break;
                case 2:
                    addFrozenProduct();
                    break;
                case 3:
                    viewFrozenProducts();
                    break;
                case 4:
                    addFreshProduct();
                    break;
                case 5:
                    viewFreshProducts();
                    break;
                case 6:
                    viewAllProducts();
                    break;
                case 7:
                    viewProductStatus();
                    break;
                case 8:
                    addCustomer();
                    break;
                case 9:
                    viewAllCustomers();
                    break;
                case 10:
                    addEmployee();
                    break;
                case 11:
                    viewAllEmployees();
                    break;
                case 0:
                    System.out.println("\nGoodbye");
                    running = false;
                    break;
                default:
                    System.out.println("\n Invalid choice");
            }
            if (running) {
                System.out.println("Press any key to continue");
                scanner.nextLine();
            }
        }
        scanner.close();
    }

    private static void displayMenu() {
        System.out.println("\n========================================");
        System.out.println(" GROCERY MANAGEMENT SYSTEM");
        System.out.println("========================================");
        System.out.println("1. Add Product");
        System.out.println("2. Add FrozenProducts");
        System.out.println("3. View FrozenProducts");
        System.out.println("4. Add FreshProducts");
        System.out.println("5. View FreshProducts");
        System.out.println("6. View All Products (Polymorphic)");
        System.out.println("7. View All Products Status ");
        System.out.println("8. Add Customer");
        System.out.println("9. View All Customers");
        System.out.println("10. Add Employee");
        System.out.println("11. View All Employees");
        System.out.println("0. Exit");
        System.out.println("========================================");
        System.out.print("Enter your choice: ");
    }

    private static void addProduct() {
        System.out.println("ADD PRODUCT");
        System.out.println("name of the product: ");
        String name = scanner.nextLine();

        System.out.println("price of the product: ");
        int price = scanner.nextInt();
        scanner.nextLine();

        System.out.println("quantity of the product: ");
        int quantity = scanner.nextInt();
        scanner.nextLine();

        System.out.println("Barcode of the product: ");
        int barcode = scanner.nextInt();
        scanner.nextLine();

        System.out.println("Brand of the product: ");
        String brand = scanner.nextLine();

        System.out.println("How much days left: ");
        int daysLeft = scanner.nextInt();
        scanner.nextLine();

        Product product = new Product(name, price, quantity, barcode, brand,daysLeft);
        products.add(product);

        System.out.println("Product added successfully✅");
    }

    private static void viewAllProducts() {
        System.out.println("\n========================================");
        System.out.println(" ALL Products (POLYMORPHIC LIST)");
        System.out.println("========================================");
        if (Allproducts.isEmpty()) {
            System.out.println("No  Products found❌.");
            return;
        }
        System.out.println("Total products: " + Allproducts.size());
        System.out.println();
        for (int i = 0; i < Allproducts.size(); i++) {
            Product s = Allproducts.get(i);
            System.out.println((i + 1) + ". " + s);
            if (s instanceof FrozenProduct) {
                FrozenProduct frozenProduct = (FrozenProduct) s;
                System.out.println("|Did it freeze? : "+ frozenProduct.getFrozen()+"|  |temperature: " + frozenProduct.getTemperature()+"C\uD83C\uDF21\uFE0F|");
                if (frozenProduct.checkTemp()) {
                    System.out.println("Enough temperature✅ ");
                }
            } else if (s instanceof FreshProduct) {
                FreshProduct freshProduct = (FreshProduct) s;
                System.out.println("|Days left: " + freshProduct.getDaysLeft()+"⏳ | is it Fresh?: "+freshProduct.isRipe()+"|");
                if (freshProduct.isOrganicProduct()) {
                    System.out.println("100% Natural✅");
                }
            }
            System.out.println();
        }

    }
    private static void addFrozenProduct() {
        System.out.println("ADD FROZENPRODUCTS");
        System.out.println("name of the product: ");
        String name = scanner.nextLine();
        System.out.println("price of the product: ");
        int price = scanner.nextInt();
        scanner.nextLine();
        System.out.println("barcode of the product: ");
        int barcode = scanner.nextInt();
        scanner.nextLine();
        System.out.println("How much days left: ");
        int daysLeft = scanner.nextInt();
        scanner.nextLine();
        System.out.println("Brand of the product: ");
        String brand = scanner.nextLine();
        System.out.println("Quantity of the product: ");
        int quantity = scanner.nextInt();
        scanner.nextLine();
        System.out.println("temperature of the product: ");
        int temperature = scanner.nextInt();
        scanner.nextLine();
        System.out.println("Validation of Frozen product: ");
        boolean isFrozen = scanner.nextBoolean();
        scanner.nextLine();
        FrozenProduct frozenProduct=new FrozenProduct(name, price, quantity, barcode, brand, daysLeft,temperature,isFrozen);
        Allproducts.add(frozenProduct);
        System.out.println("Frozen Product added successfully✅");

    }
    private static void viewFrozenProducts() {
        System.out.println("\n========================================");
        System.out.println(" FROZEN PRODUCTS ONLY");
        System.out.println("========================================");
        int FRPcount = 0;
        for (Product s : Allproducts) {
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
        boolean isRipe= scanner.nextBoolean();
        scanner.nextLine();
        System.out.println("Organicness of the product: ");
        boolean isOrganicProduct = scanner.nextBoolean();
        FreshProduct freshProduct=new FreshProduct(name,price,quantity,barcode,brand,daysLeft,isRipe,isOrganicProduct);
        Allproducts.add(freshProduct);
        System.out.println("Fresh Product added successfully✅");
    }
    private static void viewFreshProducts() {
        System.out.println("\n========================================");
        System.out.println(" FRESH PRODUCTS ONLY");
        System.out.println("========================================");
        int FRPcount = 0;
        for (Product s : Allproducts) {
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
        System.out.println("\n========================================");
        System.out.println(" POLYMORPHISM DEMONSTRATION");
        System.out.println("========================================");
        System.out.println("Calling Productname() and ProductVerification on all Products:");
        System.out.println();
        for (Product s : Allproducts) {
            s.productVerification();
            s.productName();
            System.out.println("----------------------------------------");
        }
        System.out.println();

    }
    private static void addCustomer() {
        System.out.println("ADD CUSTOMER");

        System.out.println("id of the customer: ");
        int customerId = scanner.nextInt();
        scanner.nextLine();

        System.out.println("name of the customer: ");
        String name = scanner.nextLine();

        System.out.println("phone number of the customer: ");
        String phoneNumber = scanner.nextLine();

        System.out.println("loyalty points of the customer: ");
        int loyaltyPoints = scanner.nextInt();
        scanner.nextLine();

        Customer customer = new Customer(customerId, name, phoneNumber, loyaltyPoints);
        customers.add(customer);

        System.out.println("Customer added successfully✅");
    }
    private static void viewAllCustomers() {
        System.out.println("\n========================================");
        System.out.println(" ALL CUSTOMERS");
        System.out.println("========================================");
        // Check if list is empty
        if (customers.isEmpty()) {
            System.out.println("No menu items found.❌");
            return; // Exit method early
        }
        System.out.println("Total items: " + customers.size());
        System.out.println();
        for (int i = 0; i < customers.size(); i++) {
            Customer item = customers.get(i); // Get item at index i
            System.out.println((i + 1) + ". " + item.getName() + " The loyalty points: "+" - "+ item.getLoyaltyPoints());
            System.out.println(" VIP Category? : " + item.isVIP());
            System.out.println();
        }
    }
    private static void addEmployee() {
        System.out.println("ADD EMPLOYEE");
        System.out.println("name of the employee: ");
        String employeeName = scanner.nextLine();

        System.out.println("id of the employee: ");
        int employeeId = scanner.nextInt();
        scanner.nextLine();

        System.out.println("age of the employee: ");
        int employeeAge = scanner.nextInt();
        scanner.nextLine();

        System.out.println("salary of the employee: ");
        int employeeSalary = scanner.nextInt();
        scanner.nextLine();

        System.out.println("email of the employee: ");
        String employeeEmail = scanner.nextLine();

        System.out.println("work experience of the employee: ");
        int employeeWorkExperience = scanner.nextInt();
        scanner.nextLine();

        Employee employee= new Employee(employeeName,employeeId,employeeAge,employeeSalary,employeeEmail,employeeWorkExperience);
        employees.add(employee);
        System.out.println("Employee added successfully✅");
    }
    private static void viewAllEmployees() {
        System.out.println("\n========================================");
        System.out.println(" ALL Employers");
        System.out.println("========================================");
        if (employees.isEmpty()) {
            System.out.println("No menu items found.");
            return; // Exit method early
        }
        System.out.println("Total items: " + employees.size());
        System.out.println();
        for (int i = 0; i < employees.size(); i++) {
            Employee item = employees.get(i); // Get item at index i
            System.out.println((i + 1) + ". " + item.getEmployeeName() + " Annual Salary " + " - " + item.AnnualEmployeeSalary());
            System.out.println("Does he deserve promotion?: " + item.isEligibleForPromotion());
            System.out.println();
        }
    }
}

