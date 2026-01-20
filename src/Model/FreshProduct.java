package Model;

public class FreshProduct extends Product {
    private boolean isRipe;
    private boolean isOrganicProduct;

    public FreshProduct(String name, int price, int quantity, int barcode, String brand, int daysLeft, boolean isRipe, boolean isOrganicProduct) {
        super(name, price, quantity, barcode, brand, daysLeft);
        this.isRipe = isRipe;
        this.isOrganicProduct = isOrganicProduct;
    }

    public Boolean getRipe() {
        return isRipe;
    }

    public boolean getOrganicProduct() {

        return isOrganicProduct;
    }

    public void setRipe(boolean isRipe) {

        this.isRipe = isRipe;
    }

    public void setOrganicProduct(boolean isOrganicProduct) {

        this.isOrganicProduct = isOrganicProduct;
    }
    @Override
    public String getProductType() {
        return "FreshProduct";
    }
    @Override
    public boolean isProductBig() {
        return false;
    }

    @Override
    public void productName() {
        if (isRipe && isOrganicProduct) {
            System.out.println(name+" is Ripe and Organic\uD83D\uDC4D.It is ready for grocery store to deliver\uD83D\uDE9A");
        } else {
            System.out.println(name+ " is not eatable\uD83E\uDD22.Won't be delivered\uD83D\uDE9A❌");
        }
    }

    @Override
    public void productVerification() {
        if (daysLeft <= 10) {
            System.out.println(name+" has been expired\uD83E\uDD22.Verication failed❌");
        }
        else{
            System.out.println("Success!✅ "+name+" Verified");
        }
    }

    public boolean isRipe() {
        return isRipe;
    }
    public boolean isOrganicProduct() {
        return isOrganicProduct;
    }
}
