package Model;

public class Customer {
    protected int customerId;
    protected String name;
    protected String phoneNumber;
    protected int loyaltyPoints;

    public Customer(int customerId, String name, String phoneNumber, int loyaltyPoints) {
        this.customerId = customerId;
        this.name = name;
        this.phoneNumber = phoneNumber;
        setLoyaltyPoints(loyaltyPoints);
    }

    public void setCustomerId(int customerId) {
        if(customerId < 0){
            throw new IllegalArgumentException("Customer Id can't be negative");
        }
        this.customerId = customerId;
    }

    public void setName(String name) {
        if(name == null || name.isEmpty()){
            throw new IllegalArgumentException("Customer Name can't be null or empty");
        }
        this.name = name;
    }

    public void setPhoneNumber(String phoneNumber) {
        if(phoneNumber == null || phoneNumber.isEmpty()){
            throw new IllegalArgumentException("Customer Phone Number can't be null or empty");
        }
        this.phoneNumber = phoneNumber;
    }

    public void setLoyaltyPoints(int loyaltyPoints) {
        if(loyaltyPoints >= 0) {
            this.loyaltyPoints = loyaltyPoints;
        } else {
            this.loyaltyPoints = 0;
        }
    }

    public int getCustomerId() {
        return customerId;
    }

    public String getName() {
        return name;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public int getLoyaltyPoints() {
        return loyaltyPoints;
    }
    public boolean isVIP() {
        return loyaltyPoints > 100;
    }
    @Override
    public String toString() {
        return "Model.Customer{" +
                "customerId=" + customerId +
                ", name='" + name + '\'' +
                ", phoneNumber='" + phoneNumber + '\'' +
                ", loyaltyPoints=" + loyaltyPoints +
                '}';
    }
}
