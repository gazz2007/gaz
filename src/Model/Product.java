package Model;

public abstract class Product {
        protected String name;
        protected int price, quantity;
        protected int barcode;
        protected String brand;
        protected int daysLeft;

        public Product(String name, int price, int quantity, int barcode, String brand, int daysLeft) {
            setName(name);
            setPrice(price);
            setQuantity(quantity);
            this.barcode = barcode;
            this.brand = brand;
            this.daysLeft = daysLeft;
        }

        public Product() {
            this.name = "Unknown";
            this.price = 0;
            this.quantity = 0;
            this.barcode = 0;
            this.brand = "None";
            this.daysLeft = 0;
        }

        public void setDaysLeft(int daysLeft) {
            if (daysLeft < 0){
                throw new IllegalArgumentException("Days left can't be negative");}
            else{
                this.daysLeft = daysLeft;
            }
        }

        public void setBrand(String brand) {
            this.brand = brand;
        }

        public void setBarcode(int barcode) {
            this.barcode = barcode;
        }

        public  void setQuantity(int quantity) {
            if (quantity>0) {
                this.quantity = quantity;
            }else{
                throw new IllegalArgumentException("Quantity can't be negative");
            }
        }

        public void setPrice(int price) {
            if (price>0) {
                this.price = price;
            }else{
                System.out.println("Price must be greater than zero");
            }
        }

        public void setName(String name) {
            if(name!=null&&!name.trim().isEmpty()){
                this.name = name;
            }
            else{
                System.out.println("Name cannot be empty");
            }
        }

        public int getDaysLeft() {
            return daysLeft;
        }

        public String getBrand() {
            return brand;
        }

        public int getBarcode() {
            return barcode;
        }

        public int getQuantity() {
            return quantity;
        }

        public int getPrice() {
            return price;
        }

        public String getName() {
            return name;
        }

        public double getRealPrice(){
            if(daysLeft==0){
                return 0;
            }
            if(30<daysLeft && daysLeft<=40 ){
                return price*(0.9);
            }
            if(15<=daysLeft && daysLeft<=30 ){
                return price*(0.7);
            }
            if(0<daysLeft && daysLeft<15 ){
                return price*(0.5);
            }
            return price;
        }
        public boolean checkQuantity(){
            return quantity<10;
        }
        public  void productName(){
            System.out.println(name+" is now ready in order to deliver to storage\uD83D\uDE9A");
        }
        public abstract String getProductType();
        public abstract boolean isProductBig();

        public  void productVerification(){
            System.out.println(name+ " is being verified⏳ ");
        }

        @Override
        public String toString() {
            return "Model.Product{" +
                    "name='" + name + '\'' +
                    ", price=" + price +
                    ", quantity=" + quantity +
                    ", barcode=" + barcode +
                    ", brand='" + brand + '\'' +
                    ", daysLeft=" + daysLeft +
                    '}';
        }
    }
