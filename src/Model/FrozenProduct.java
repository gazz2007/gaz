package Model;

public class FrozenProduct extends Product {
    private int temperature;
    private boolean isFrozen;
    public FrozenProduct(String name, int price, int quantity, int barcode, String brand, int daysLeft,int temperature, boolean isFrozen) {
        super(name, price, quantity, barcode, brand, daysLeft);
        this.temperature=temperature;
        this.isFrozen=isFrozen;
    }

    public int getTemperature() {
        return temperature;
    }
    public boolean getFrozen() {
        return isFrozen;
    }
    public void setTemperature(int temperature) {
        if (temperature > 0) {
            throw new IllegalArgumentException("Frozen product temperature must be below zero");
        }
        this.temperature = temperature;
    }
    public void setFrozen(boolean isFrozen) {
        if (!isFrozen) {
            throw new IllegalArgumentException("Product must be frozen");
        }
        this.isFrozen = isFrozen;
    }
    @Override
    public void productName(){
        if(isFrozen==false){
            System.out.println(name+"'s temperature status is "+isFrozen +"❌❄\uFE0F"+"When the product "+name+" will be frozen enough then it is ready in order to deliver to storage");
        }
        else{
            System.out.println(name+ "'s temperature status is "+isFrozen+"✅❄\uFE0F. "+"Success now you can pick up the "+name+"!");
        }
    }

    @Override
    public String getProductType() {
        return "FrozenProduct";
    }

    @Override
    public boolean isProductBig() {
        return true;
    }

    @Override
    public void productVerification(){
        if(temperature<-10){
            System.out.println(name+"'s temperature is "+temperature+"\uD83C\uDF21\uFE0F .Verified successfully✅");
        }
        else{
            System.out.println(name+"'s temperature is "+temperature+"\uD83C\uDF21\uFE0F .Verification failed❌");
        }
    }

    public boolean isFrozen() {
        return isFrozen;
    }
    public boolean checkTemp(){
        if(temperature<-10){
            return false;
        }
        else{
            return true;
        }
    }
}
