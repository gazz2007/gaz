    public class Product {
        private String name;
        private int price, quantity;
        private int barcode;
        private String brand;
        private int daysLeft;

        public Product(String name, int price, int quantity, int barcode, String brand, int daysLeft) {
            this.name = name;
            this.price = price;
            this.quantity = quantity;
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
            this.daysLeft = daysLeft;
        }

        public void setBrand(String brand) {
            this.brand = brand;
        }

        public void setBarcode(int barcode) {
            this.barcode = barcode;
        }

        public void setQuantity(int quantity) {
            this.quantity = quantity;
        }

        public void setPrice(int price) {
            this.price = price;
        }

        public void setName(String name) {
            this.name = name;
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
        @Override
        public String toString() {
            return "Product{" +
                    "name='" + name + '\'' +
                    ", price=" + price +
                    ", quantity=" + quantity +
                    ", barcode=" + barcode +
                    ", brand='" + brand + '\'' +
                    ", daysLeft=" + daysLeft +
                    '}';
        }
    }
