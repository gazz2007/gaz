public class Main {
    public static void main(String[] args) {
        Product apple = new Product("Apple",300,8,42342432,"Astroworld",18);
        System.out.println("----Information about the product----: ");
        System.out.println(apple.toString());
        System.out.println("----Presence of discount----: ");
        System.out.println("Price after discount: "+ apple.getRealPrice());
        System.out.println("----Check whether we need to add some items or not-----: ");
        System.out.println("Do wee need to add more?--> "+ apple.checkQuantity());

        System.out.println(" ");
        Inventory inventory = new Inventory(100,80,33,"Rodeo",30,12);
        System.out.println("---Storage info---");
        System.out.println(inventory.toString());
        System.out.println("----Capacity Check----: ");
        System.out.println("Overloaded? " + inventory.checkMaxCapacity());
        System.out.println("---Product Expiration check---");
        System.out.println("Should we store them?--> "+ inventory.checkExpDays());

        System.out.println("  ");
        Employee[] stuff=new Employee[3];
        stuff[0]=new Employee("Gaziz",3900210,18,2700,"LaFlame@gmail.com",4);
        stuff[1]=new Employee("Kaisar",84324241,19,3500,"Roxxane@gmail.com",5);
        stuff[2]=new Employee("Akniet",179542157,18,1200,"bolatova@gmail.com",1);
        System.out.println("---Employee Salaries Calculation---");
        for(Employee i:stuff){
            System.out.println(i.getEmployeeName()+" Gets "+i.AnnualEmployeeSalary()+" Salary");
        }
        System.out.println(" ");
        System.out.println("---Employees who deserve extra salaries---");
        for(Employee i:stuff){
            if(i.isEligibleForPromotion()){
                System.out.println("Congrats! "+i.getEmployeeName()+" Gets " + (i.AnnualEmployeeSalary()*1.1-i.AnnualEmployeeSalary())+" Extra Salary");
            }
        }
    }

}
