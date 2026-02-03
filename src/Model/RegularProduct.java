package Model;

public class RegularProduct extends Product {

    public RegularProduct(int id, String name, int price) {
        super(id, name, price);
    }

    @Override
    public String getProductType() {
        return "REGULAR";
    }

    @Override
    public boolean isProductBig() {
        return getPrice() > 1000;
    }
}
